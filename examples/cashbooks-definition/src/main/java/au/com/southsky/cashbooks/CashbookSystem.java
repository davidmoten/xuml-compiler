package au.com.southsky.cashbooks;

import model.AssociationClass;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.AttributeReferential;
import model.CallEvent;
import model.Class;
import model.Package;
import model.Primitive;
import model.Specialization;
import model.SpecializationGroup;
import model.State;
import moten.david.xuml.model.Multiplicity;
import moten.david.xuml.model.util.SystemBase;

import org.junit.Test;

public class CashbookSystem extends SystemBase {

	public CashbookSystem() {
		// note that we pass a null schema name because hsqldb doesn't create
		// schemas for us
		// during hbm2ddl.SchemaExport and errors occur
		super(null, "cashbooks");
		initialize();
	}

	private void initialize() {
		model.Package pkg = createRootPackage("cashbooks", "cashbooks system");

		Class customer = createCustomer(pkg);
		Class email = createEmail(pkg);

		// Association between Customer and Email

		createAssociation("R1", createAssociationEndPrimary(customer,
				Multiplicity.ONE, "is used to contact"),
				createAssociationEndSecondary(email, Multiplicity.MANY,
						"is contactable via"));

		// create an Account class

		Class account = createClassWithArbitraryId(
				pkg,
				"Account",
				"an account operated by a customer for the purpose of making financial transactions");
		Attribute bsb = createAttribute(account, "bsb", Primitive.STRING);
		Attribute accountNo = createAttribute(account, "accountno",
				Primitive.STRING);
		createAttribute(account, "name", Primitive.STRING);
		createAttribute(account, "description", Primitive.STRING);
		createAttribute(account, "type", Primitive.STRING);

		// Identifiers

		createAttribute(account, "shortname").setUnique(true);

		// State machine

		State open = createState(account, "Open");
		State closed = createState(account, "Closed");
		CallEvent newAccount = createCallEvent(account, "newAccount");
		createParameter(newAccount, "customer", "cashbooks.Customer");
		createParameter(newAccount, "bsb");
		createParameter(newAccount, "accountno");
		createParameter(newAccount, "name");
		createParameter(newAccount, "decription");
		createParameter(newAccount, "type");

		CallEvent openAccount = createCallEvent(account, "openAccount");
		CallEvent closeAccount = createCallEvent(account, "closeAccount");

		createTransition(open, closed, closeAccount);
		createTransition(closed, open, openAccount);
		createTransition(account.getStateMachine().getInitialState(), open,
				openAccount);
		CallEvent remove = createCallEvent(account, "remove");
		createTransition(closed, account.getStateMachine().getFinalState(),
				remove);

		// Association between Customer and their accounts

		AssociationEndPrimary end1 = createAssociationEndPrimary(customer,
				Multiplicity.ONE, "is operated by");
		AssociationEndSecondary end2 = createAssociationEndSecondary(account,
				Multiplicity.MANY, "operates");

		createAssociation("R2", end1, end2);

		// referential attributes

		AttributeReferential customerId = createAttributeReferential(account,
				end1, "customerid");
		createIdentifierNonPrimary(account, "I2", new Attribute[] { bsb,
				accountNo }, customerId);

		// create CashBook class

		Class cashbook = createClass(
				pkg,
				"CashBook",
				"a primary accounting journal used to record and classify financials transactions");
		createArbitraryId(cashbook);
		Attribute name = createAttribute(cashbook, "name");
		createAttribute(cashbook, "description");

		// A customer may have a number of cashbooks to represents all of their
		// separate activities

		end1 = createAssociationEndPrimary(customer, Multiplicity.ONE,
				"records the financial activity of");
		end2 = createAssociationEndSecondary(cashbook, Multiplicity.MANY,
				"records financial activity in");

		createAssociation("R3", end1, end2);

		// attributes for cashbook derived from customer across R3

		customerId = createAttributeReferential(cashbook, end1, "customerId");
		createIdentifierNonPrimary(cashbook, "I2", new Attribute[] { name },
				customerId);

		// An account contributes transactions to exactly one cashbook

		end1 = createAssociationEndPrimary(cashbook, Multiplicity.ONE,
				"contributes transactions to");
		end2 = createAssociationEndSecondary(account, Multiplicity.MANY,
				"records and classifies transactions from");

		createAssociation("R4", end1, end2);

		// BankSuppliedTransaction
		// =======================
		//
		// These are transaction records maintained and supplied by the bank (or
		// other
		// financial institution). The represent primary, immutable financial
		// records
		//

		Class transaction = createClassWithArbitraryId(pkg,
				"BankSuppliedTransaction",
				"a transaction as recorded by the bank or other financial institution");
		Attribute tranDate = createAttribute(transaction, "tranDate",
				Primitive.DATE);
		tranDate.setMandatory(true);
		Attribute tranSequenceNo = createAttribute(transaction, "sequence",
				Primitive.INTEGER);
		tranSequenceNo.setMandatory(true);
		createAttribute(transaction, "description").setMandatory(true);
		createAttribute(transaction, "value", Primitive.DECIMAL).setMandatory(
				true);
		createAttribute(transaction, "balance", Primitive.DECIMAL);

		// An account has many transactions

		end1 = createAssociationEndPrimary(account, Multiplicity.ONE,
				"modifies the balance of");
		end2 = createAssociationEndSecondary(transaction, Multiplicity.MANY,
				"has balance modified by");

		createAssociation("R5", end1, end2);

		// attributes for transaction derived from account across R5

		AttributeReferential accountId = createAttributeReferential(
				transaction, end1, "accountId");
		createIdentifierNonPrimary(transaction, "I2", new Attribute[] {
				tranDate, tranSequenceNo }, accountId);

		// Cashbook Column
		// ===============
		//
		// A cashbook, like a spreadsheet is composed of mutiple columms. Each
		// cashbook column
		// represents a category of income, expense, capital, tax or some other
		// classification of a transaction.
		// A column may be a "cash" column or a non-cash column. Examples of
		// each type may appear in a cashbook
		// recording shares in a share portfolio: a cash column might be
		// "Dividend income" while a non-cash column
		// might be "Franking credit".
		//
		// When posting a transaction to a cashbook, the sum value of the "cash"
		// column posting must
		// equal the cash value of the transaction.
		//

		Class cashbookColumn = createClassWithArbitraryId(
				pkg,
				"CashbookColumn",
				"Allows the value of a transaction (or part thereof to be classified according to type");
		Attribute columnName = createAttribute(cashbookColumn, "name");
		createAttribute(cashbookColumn, "cash", Primitive.BOOLEAN);

		// Cashbook contains multiple cashbook columns. A cashbook column is a
		// category within a single cashbook.

		end1 = createAssociationEndPrimary(cashbook, Multiplicity.ONE,
				"is a transaction value category for");
		end2 = createAssociationEndSecondary(cashbookColumn, Multiplicity.MANY,
				"allows transaction values to be posted against");

		createAssociation("R6", end1, end2);

		// the name of a column must be unique within the cashbook to which it
		// belongs

		AttributeReferential cashbookId = createAttributeReferential(
				cashbookColumn, end1, "cashbookId");
		createIdentifierNonPrimary(cashbookColumn, "I2",
				new Attribute[] { columnName }, cashbookId);

		// A transactions is posted to one or more cashbookColumns. Each posting
		// is represented
		// by a cashbook entry.

		AssociationClass cashbookEntry = createAssociationClass(
				pkg,
				"CashbookEntry",
				"A transactions is posted to one or more cashbookColumns. Each posting is represented by a cashbook entry");
		createAttribute(cashbookEntry, "value", Primitive.DECIMAL)
				.setMandatory(true);

		end1 = createAssociationEndPrimary(cashbookColumn,
				Multiplicity.ONE_MANY, "is posted to");
		end2 = createAssociationEndSecondary(transaction, Multiplicity.MANY,
				"receives postings from");
		createAssociation("R7", end1, end2).setAssociationClass(cashbookEntry);

		// A cashbook entry is uniquely identified by the combination of the
		// transaction ID and the associated cashbookColumn Id

		AttributeReferential cashbookColumnId = createAttributeReferential(
				cashbookEntry, end1, "cashbookColumnId");
		AttributeReferential transactionId = createAttributeReferential(
				cashbookEntry, end2, "transactionId");
//		createIdentifierPrimary(cashbookEntry, "I", new Attribute[] {},
//				cashbookColumnId, transactionId);
		createIdentifierPrimary(cashbookEntry, "I", null,
				cashbookColumnId, transactionId);

		// Document (from document management system)

		Class document = createClass(pkg, "Document",
				"an electronic document (scanned or in original electronic form");
		Attribute documentPhysicalId = createAttribute(document, "physicalId",
				Primitive.STRING);
		// documentPhysicalId.setMandatory(true);

		createIdentifierPrimary(document, "I",
				new Attribute[] { documentPhysicalId },
				(AttributeReferential[]) null);

		createAttribute(document, "recordDate", Primitive.DATE).setMandatory(
				true);
		createAttribute(document, "title").setMandatory(true);
		createAttribute(document, "author").setMandatory(true);
		createAttribute(document, "description");
		createAttribute(document, "keywords");
		createAttribute(document, "actionRequired");

		// CustomerSuppliedDetails
		// =======================

		Class customerSuppliedDetails = createClassWithArbitraryId(pkg,
				"CustomerSuppliedDetails",
				"transaction details supplied by the customer");

		end1 = createAssociationEndPrimary(transaction, Multiplicity.ONE,
				"supplies additional information concerning");
		end2 = createAssociationEndSecondary(customerSuppliedDetails,
				Multiplicity.ZERO_ONE,
				"is augmented with additonal information supplied by");
		createAssociation("R8", end1, end2);

		transactionId = createAttributeReferential(customerSuppliedDetails,
				end1, "transactionId");

		createAttribute(customerSuppliedDetails, "narrative")
				.setMandatory(true);

		// TransactionDocument
		// ===================
		// customers may link documents as evidence to support their
		// transactions

		AssociationClass transactionDocument = createAssociationClass(pkg,
				"TransactionDocument",
				"the use of one document to support one bank supplied transaction");

		end1 = createAssociationEndPrimary(document, Multiplicity.MANY,
				"has supporting documentation provided by");
		end2 = createAssociationEndSecondary(customerSuppliedDetails,
				Multiplicity.MANY, "documents");
		createAssociation("R9", end1, end2).setAssociationClass(
				transactionDocument);

		AttributeReferential csdId = createAttributeReferential(
				transactionDocument, end2, "customerSuppliedDetailsId");
		AttributeReferential docId = createAttributeReferential(document, end1,
				"physicalId");
		createIdentifierPrimary(transactionDocument, "I", new Attribute[] {},
				csdId, docId);

		// Selector
		// ========
		//
		// A selector is used to select transactions for posting to a cashbook.
		//

		Class selector = createClassWithArbitraryId(pkg, "Selector",
				"is used to select transactions for posting to a cashbook");

		createAttribute(selector, "pattern").setMandatory(true);

		// R10 - selects transactions for a single Cashbook (TODO: review this
		// wording)
		// ===

		end1 = createAssociationEndPrimary(cashbook, Multiplicity.ONE,
				"selects transactions for");
		end2 = createAssociationEndSecondary(selector, Multiplicity.MANY,
				"has transactions selected by");
		createAssociation("R10", end1, end2);

		// PostingRule
		// ===========
		//
		// Specifies posting of a transaction (or part thereof) to a cashbook
		// column via
		// the creation of a CashbookEntry instance

		Class postingRule = createClassWithArbitraryId(
				pkg,
				"PostingRule",
				"specifies posting of a transaction (or part thereof) to a cashbook column via the creation of a CashbookEntry instance");

		// R11 - a PostingRule is invoked by a selector
		// ===

		end1 = createAssociationEndPrimary(selector, Multiplicity.ONE,
				"is invoked by");
		end2 = createAssociationEndSecondary(postingRule,
				Multiplicity.ONE_MANY, "invokes");
		createAssociation("R11", end1, end2);

		// R12 - A posting rule specifies postings to one column
		// ===

		end1 = createAssociationEndPrimary(cashbookColumn, Multiplicity.ONE,
				"specifies posting to");
		end2 = createAssociationEndSecondary(postingRule, Multiplicity.MANY,
				"has postings specified by");
		createAssociation("R12", end1, end2);

		createAttribute(postingRule, "multiplier", Primitive.DECIMAL)
				.setMandatory(true);
		createAttribute(postingRule, "description");

		// R13 - A CashbookEntry can be classified as either a ManualEntry or an
		// AutoGeneratedEntry

		SpecializationGroup r13 = createSpecializationGroup(
				cashbookEntry,
				"R13",
				"A CashbookEntry can be classified as either a ManualEntry or an AutoGeneratedEntry");

		Specialization manualEntry = createSpecialization(r13, pkg,
				"ManualEntry",
				"a CashbookEntry created by the customer in leiu of an AutoGeneratedEntry");
		Specialization autoGeneratedEntry = createSpecialization(r13, pkg,
				"AutoGeneratedEntry",
				"a CashbookEntry created automatically as a result of a psoting rule");

		// R14 - An AutoGeneratedEntry is originates from a PostingRule
		// ===

		end1 = createAssociationEndPrimary(postingRule, Multiplicity.ONE,
				"originates from");
		end2 = createAssociationEndSecondary(autoGeneratedEntry,
				Multiplicity.MANY, "give rise to");
		createAssociation("R14", end1, end2);

	}

	private Class createCustomer(Package pkg) {
		Class customer = createClassWithArbitraryId(pkg, "Customer",
				"a customer, possible contactable using multiple emails");
		createAttribute(customer, "name").setUnique(true);
		createAttribute(customer, "shortname").setUnique(true);
		State inactive = createState(customer, "Inactive");
		State active = createState(customer, "Active");
		CallEvent newCustomer = createCallEvent(customer, "newCustomer");
		createParameter(newCustomer, "name");
		CallEvent activate = createCallEvent(customer, "activate");
		CallEvent deactivate = createCallEvent(customer, "deactivate");
		CallEvent addEmail = createCallEvent(customer, "addEmail");
		createParameter(addEmail, "email", "cashbooks.Email");
		createTransition(inactive, active, activate);
		createTransition(active, inactive, deactivate);
		createTransition(active, active, addEmail);
		createTransition(customer.getStateMachine().getInitialState(),
				inactive, newCustomer);
		CallEvent remove = createCallEvent(customer, "remove");
		createTransition(inactive, customer.getStateMachine().getFinalState(),
				remove);
		return customer;
	}

	private Class createEmail(Package pkg) {
		Class email = createClassWithArbitraryId(pkg, "Email",
				"an email address belonging to a customer, e.g fred@google.com");
		createAttribute(email, "email");
		createOperation(email, "send", "sends an email", null, false,
				createParameter("subject", "subject line of the email"),
				createParameter("body", "body of the message"),
				createParameter("from", "the sender of the email"));
		return email;
	}

	@Override
	@Test
	public void validate() throws ValidationException {
		super.validate();
	}

}
