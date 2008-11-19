/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import model.ActionLanguage;
import model.Association;
import model.AssociationClass;
import model.AssociationEnd;
import model.AssociationEndPersistence;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.AttributePersistence;
import model.AttributeReferential;
import model.CallEvent;
import model.ChangeEvent;
import model.ClassPersistence;
import model.DataType;
import model.Event;
import model.ExceptionEvent;
import model.FinalState;
import model.FreeType;
import model.FromState;
import model.Identifier;
import model.IdentifierNonPrimary;
import model.IdentifierParticipant;
import model.IdentifierPrimary;
import model.Index;
import model.InitialState;
import model.ModelFactory;
import model.ModelPackage;
import model.Named;
import model.ObjectConstraintLanguage;
import model.Operation;
import model.OperationSignature;
import model.Parameter;
import model.Primitive;
import model.PrimitiveType;
import model.Procedure;
import model.SignalEvent;
import model.Specialization;
import model.SpecializationGroup;
import model.State;
import model.StateMachine;
import model.Stately;
import model.TimerEvent;
import model.ToState;
import model.Transition;
import model.Type;

import model.activity.ActivityPackage;

import model.activity.impl.ActivityPackageImpl;

import model.collaboration.CollaborationPackage;

import model.collaboration.impl.CollaborationPackageImpl;

import model.diagram.DiagramPackage;

import model.diagram.impl.DiagramPackageImpl;

import model.domain.DomainPackage;

import model.domain.impl.DomainPackageImpl;

import model.use.UsePackage;

import model.use.impl.UsePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelPackageImpl extends EPackageImpl implements ModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEndPrimaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEndSecondaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeReferentialEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationSignatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass freeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionLanguageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectConstraintLanguageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierPrimaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierNonPrimaryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierParticipantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signalEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass timerEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass changeEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exceptionEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procedureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initialStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finalStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statelyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stateMachineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fromStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass toStateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classPersistenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributePersistenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass associationEndPersistenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializationGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specializationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see model.ModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModelPackageImpl() {
		super(eNS_URI, ModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModelPackage init() {
		if (isInited) return (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Obtain or create and register package
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ModelPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		CollaborationPackageImpl theCollaborationPackage = (CollaborationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CollaborationPackage.eNS_URI) instanceof CollaborationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CollaborationPackage.eNS_URI) : CollaborationPackage.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		DiagramPackageImpl theDiagramPackage = (DiagramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI) instanceof DiagramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI) : DiagramPackage.eINSTANCE);
		UsePackageImpl theUsePackage = (UsePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsePackage.eNS_URI) instanceof UsePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsePackage.eNS_URI) : UsePackage.eINSTANCE);
		ActivityPackageImpl theActivityPackage = (ActivityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI) instanceof ActivityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI) : ActivityPackage.eINSTANCE);

		// Create package meta-data objects
		theModelPackage.createPackageContents();
		theCollaborationPackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theDiagramPackage.createPackageContents();
		theUsePackage.createPackageContents();
		theActivityPackage.createPackageContents();

		// Initialize created meta-data
		theModelPackage.initializePackageContents();
		theCollaborationPackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theDiagramPackage.initializePackageContents();
		theUsePackage.initializePackageContents();
		theActivityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModelPackage.freeze();

		return theModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Package() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Association() {
		return (EReference)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Constraint() {
		return (EReference)systemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Collaborator() {
		return (EReference)systemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Communication() {
		return (EReference)systemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Domain() {
		return (EReference)systemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Bridge() {
		return (EReference)systemEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_UseCase() {
		return (EReference)systemEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_ActorUseCase() {
		return (EReference)systemEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_UnitTest() {
		return (EReference)systemEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Event() {
		return (EReference)systemEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_FreeType() {
		return (EReference)systemEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_PrimitiveType() {
		return (EReference)systemEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackage() {
		return packageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackage_Class() {
		return (EReference)packageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackage_SubPackage() {
		return (EReference)packageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackage_Parent() {
		return (EReference)packageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackage_DataType() {
		return (EReference)packageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClass_() {
		return classEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Package() {
		return (EReference)classEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Attribute() {
		return (EReference)classEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_AttributeReferential() {
		return (EReference)classEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Operation() {
		return (EReference)classEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Constraints() {
		return (EReference)classEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_StateMachine() {
		return (EReference)classEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_IdentifierPrimary() {
		return (EReference)classEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_IdentifierNonPrimary() {
		return (EReference)classEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_AssociationEndPrimary() {
		return (EReference)classEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_AssociationEndSecondary() {
		return (EReference)classEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_Persistence() {
		return (EReference)classEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClass_SpecializationGroup() {
		return (EReference)classEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociation() {
		return associationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Primary() {
		return (EReference)associationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_Secondary() {
		return (EReference)associationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociation_AssociationClass() {
		return (EReference)associationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationEndPrimary() {
		return associationEndPrimaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationEndPrimary_Class() {
		return (EReference)associationEndPrimaryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationEndPrimary_Association() {
		return (EReference)associationEndPrimaryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationEndSecondary() {
		return associationEndSecondaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationEndSecondary_Class() {
		return (EReference)associationEndSecondaryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationEndSecondary_Association() {
		return (EReference)associationEndSecondaryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationEnd() {
		return associationEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationEnd_Mandatory() {
		return (EAttribute)associationEndEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationEnd_Multiple() {
		return (EAttribute)associationEndEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationEnd_VerbClause() {
		return (EAttribute)associationEndEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationEnd_Role() {
		return (EAttribute)associationEndEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationEnd_RolePlural() {
		return (EAttribute)associationEndEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationEnd_DerivedAttribute() {
		return (EReference)associationEndEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationEnd_Persistence() {
		return (EReference)associationEndEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationClass() {
		return associationClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationClass_Association() {
		return (EReference)associationClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttribute() {
		return attributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Class() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Constraints() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Type() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Unique() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_IdentifierPrimary() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_IdentifierNonPrimary() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Mandatory() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttribute_Persistence() {
		return (EReference)attributeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttribute_Values() {
		return (EAttribute)attributeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeReferential() {
		return attributeReferentialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeReferential_AssociationEnd() {
		return (EReference)attributeReferentialEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeReferential_Class() {
		return (EReference)attributeReferentialEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeReferential_IdentifierPrimary() {
		return (EReference)attributeReferentialEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeReferential_IdentifierNonPrimary() {
		return (EReference)attributeReferentialEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationSignature() {
		return operationSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationSignature_Parameter() {
		return (EReference)operationSignatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationSignature_Returns() {
		return (EReference)operationSignatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationSignature_ReturnsMultiple() {
		return (EAttribute)operationSignatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperation_Action() {
		return (EReference)operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFreeType() {
		return freeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFreeType_Type() {
		return (EAttribute)freeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFreeType_Multiple() {
		return (EAttribute)freeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFreeType_System() {
		return (EReference)freeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		return typeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_Type() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameter_Multiple() {
		return (EAttribute)parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionLanguage() {
		return actionLanguageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActionLanguage_Action() {
		return (EAttribute)actionLanguageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectConstraintLanguage() {
		return objectConstraintLanguageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectConstraintLanguage_Ocl() {
		return (EAttribute)objectConstraintLanguageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamed() {
		return namedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamed_Name() {
		return (EAttribute)namedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamed_Description() {
		return (EAttribute)namedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifier() {
		return identifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierPrimary() {
		return identifierPrimaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierPrimary_Attribute() {
		return (EReference)identifierPrimaryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierPrimary_AttributeReferential() {
		return (EReference)identifierPrimaryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierNonPrimary() {
		return identifierNonPrimaryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierNonPrimary_Attribute() {
		return (EReference)identifierNonPrimaryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierNonPrimary_AttributeReferential() {
		return (EReference)identifierNonPrimaryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierParticipant() {
		return identifierParticipantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_Transition() {
		return (EReference)eventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEvent_Parameter() {
		return (EReference)eventEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignalEvent() {
		return signalEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTimerEvent() {
		return timerEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTimerEvent_TimeMs() {
		return (EAttribute)timerEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getChangeEvent() {
		return changeEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallEvent() {
		return callEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExceptionEvent() {
		return exceptionEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveType() {
		return primitiveTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_Primitive() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveType_System() {
		return (EReference)primitiveTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_Precision() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_Scale() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_Utc() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_Length() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveType_YesNo() {
		return (EAttribute)primitiveTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getState() {
		return stateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_EntryProcedure() {
		return (EReference)stateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getState_StateMachine() {
		return (EReference)stateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransition() {
		return transitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_Event() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_FromState() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_ToState() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcedure() {
		return procedureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcedure_Action() {
		return (EReference)procedureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitialState() {
		return initialStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitialState_StateMachine() {
		return (EReference)initialStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFinalState() {
		return finalStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFinalState_StateMachine() {
		return (EReference)finalStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStately() {
		return statelyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateMachine() {
		return stateMachineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_Class() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_InitialState() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_State() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_FinalState() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStateMachine_Event() {
		return (EReference)stateMachineEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFromState() {
		return fromStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFromState_TransitionTo() {
		return (EReference)fromStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getToState() {
		return toStateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToState_TransitionFrom() {
		return (EReference)toStateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getToState_Event() {
		return (EReference)toStateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndex() {
		return indexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndex_Attribute() {
		return (EReference)indexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassPersistence() {
		return classPersistenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassPersistence_Schema() {
		return (EAttribute)classPersistenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassPersistence_Table() {
		return (EAttribute)classPersistenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassPersistence_Index() {
		return (EReference)classPersistenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributePersistence() {
		return attributePersistenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributePersistence_Column() {
		return (EAttribute)attributePersistenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributePersistence_GeneratedBySequence() {
		return (EAttribute)attributePersistenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributePersistence_GeneratedValue() {
		return (EAttribute)attributePersistenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributePersistence_Length() {
		return (EAttribute)attributePersistenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributePersistence_Scale() {
		return (EAttribute)attributePersistenceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributePersistence_Precision() {
		return (EAttribute)attributePersistenceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssociationEndPersistence() {
		return associationEndPersistenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAssociationEndPersistence_LazyFetch() {
		return (EAttribute)associationEndPersistenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssociationEndPersistence_OrderBy() {
		return (EReference)associationEndPersistenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_Attribute() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_Package() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecializationGroup() {
		return specializationGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecializationGroup_Generalization() {
		return (EReference)specializationGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecializationGroup_Specialization() {
		return (EReference)specializationGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecialization() {
		return specializationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecialization_Group() {
		return (EReference)specializationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPrimitive() {
		return primitiveEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelFactory getModelFactory() {
		return (ModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__PACKAGE);
		createEReference(systemEClass, SYSTEM__ASSOCIATION);
		createEReference(systemEClass, SYSTEM__CONSTRAINT);
		createEReference(systemEClass, SYSTEM__COLLABORATOR);
		createEReference(systemEClass, SYSTEM__COMMUNICATION);
		createEReference(systemEClass, SYSTEM__DOMAIN);
		createEReference(systemEClass, SYSTEM__BRIDGE);
		createEReference(systemEClass, SYSTEM__USE_CASE);
		createEReference(systemEClass, SYSTEM__ACTOR_USE_CASE);
		createEReference(systemEClass, SYSTEM__UNIT_TEST);
		createEReference(systemEClass, SYSTEM__EVENT);
		createEReference(systemEClass, SYSTEM__FREE_TYPE);
		createEReference(systemEClass, SYSTEM__PRIMITIVE_TYPE);

		packageEClass = createEClass(PACKAGE);
		createEReference(packageEClass, PACKAGE__CLASS);
		createEReference(packageEClass, PACKAGE__SUB_PACKAGE);
		createEReference(packageEClass, PACKAGE__PARENT);
		createEReference(packageEClass, PACKAGE__DATA_TYPE);

		classEClass = createEClass(CLASS);
		createEReference(classEClass, CLASS__PACKAGE);
		createEReference(classEClass, CLASS__ATTRIBUTE);
		createEReference(classEClass, CLASS__ATTRIBUTE_REFERENTIAL);
		createEReference(classEClass, CLASS__OPERATION);
		createEReference(classEClass, CLASS__CONSTRAINTS);
		createEReference(classEClass, CLASS__STATE_MACHINE);
		createEReference(classEClass, CLASS__IDENTIFIER_PRIMARY);
		createEReference(classEClass, CLASS__IDENTIFIER_NON_PRIMARY);
		createEReference(classEClass, CLASS__ASSOCIATION_END_PRIMARY);
		createEReference(classEClass, CLASS__ASSOCIATION_END_SECONDARY);
		createEReference(classEClass, CLASS__PERSISTENCE);
		createEReference(classEClass, CLASS__SPECIALIZATION_GROUP);

		associationEClass = createEClass(ASSOCIATION);
		createEReference(associationEClass, ASSOCIATION__PRIMARY);
		createEReference(associationEClass, ASSOCIATION__SECONDARY);
		createEReference(associationEClass, ASSOCIATION__ASSOCIATION_CLASS);

		associationEndPrimaryEClass = createEClass(ASSOCIATION_END_PRIMARY);
		createEReference(associationEndPrimaryEClass, ASSOCIATION_END_PRIMARY__CLASS);
		createEReference(associationEndPrimaryEClass, ASSOCIATION_END_PRIMARY__ASSOCIATION);

		associationEndSecondaryEClass = createEClass(ASSOCIATION_END_SECONDARY);
		createEReference(associationEndSecondaryEClass, ASSOCIATION_END_SECONDARY__CLASS);
		createEReference(associationEndSecondaryEClass, ASSOCIATION_END_SECONDARY__ASSOCIATION);

		associationEndEClass = createEClass(ASSOCIATION_END);
		createEAttribute(associationEndEClass, ASSOCIATION_END__MANDATORY);
		createEAttribute(associationEndEClass, ASSOCIATION_END__MULTIPLE);
		createEAttribute(associationEndEClass, ASSOCIATION_END__VERB_CLAUSE);
		createEAttribute(associationEndEClass, ASSOCIATION_END__ROLE);
		createEAttribute(associationEndEClass, ASSOCIATION_END__ROLE_PLURAL);
		createEReference(associationEndEClass, ASSOCIATION_END__DERIVED_ATTRIBUTE);
		createEReference(associationEndEClass, ASSOCIATION_END__PERSISTENCE);

		associationClassEClass = createEClass(ASSOCIATION_CLASS);
		createEReference(associationClassEClass, ASSOCIATION_CLASS__ASSOCIATION);

		attributeEClass = createEClass(ATTRIBUTE);
		createEReference(attributeEClass, ATTRIBUTE__CLASS);
		createEReference(attributeEClass, ATTRIBUTE__CONSTRAINTS);
		createEReference(attributeEClass, ATTRIBUTE__TYPE);
		createEAttribute(attributeEClass, ATTRIBUTE__UNIQUE);
		createEReference(attributeEClass, ATTRIBUTE__IDENTIFIER_PRIMARY);
		createEReference(attributeEClass, ATTRIBUTE__IDENTIFIER_NON_PRIMARY);
		createEAttribute(attributeEClass, ATTRIBUTE__MANDATORY);
		createEReference(attributeEClass, ATTRIBUTE__PERSISTENCE);
		createEAttribute(attributeEClass, ATTRIBUTE__VALUES);

		attributeReferentialEClass = createEClass(ATTRIBUTE_REFERENTIAL);
		createEReference(attributeReferentialEClass, ATTRIBUTE_REFERENTIAL__ASSOCIATION_END);
		createEReference(attributeReferentialEClass, ATTRIBUTE_REFERENTIAL__CLASS);
		createEReference(attributeReferentialEClass, ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY);
		createEReference(attributeReferentialEClass, ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY);

		operationSignatureEClass = createEClass(OPERATION_SIGNATURE);
		createEReference(operationSignatureEClass, OPERATION_SIGNATURE__PARAMETER);
		createEReference(operationSignatureEClass, OPERATION_SIGNATURE__RETURNS);
		createEAttribute(operationSignatureEClass, OPERATION_SIGNATURE__RETURNS_MULTIPLE);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__ACTION);

		freeTypeEClass = createEClass(FREE_TYPE);
		createEAttribute(freeTypeEClass, FREE_TYPE__TYPE);
		createEAttribute(freeTypeEClass, FREE_TYPE__MULTIPLE);
		createEReference(freeTypeEClass, FREE_TYPE__SYSTEM);

		typeEClass = createEClass(TYPE);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__TYPE);
		createEAttribute(parameterEClass, PARAMETER__MULTIPLE);

		actionLanguageEClass = createEClass(ACTION_LANGUAGE);
		createEAttribute(actionLanguageEClass, ACTION_LANGUAGE__ACTION);

		objectConstraintLanguageEClass = createEClass(OBJECT_CONSTRAINT_LANGUAGE);
		createEAttribute(objectConstraintLanguageEClass, OBJECT_CONSTRAINT_LANGUAGE__OCL);

		namedEClass = createEClass(NAMED);
		createEAttribute(namedEClass, NAMED__NAME);
		createEAttribute(namedEClass, NAMED__DESCRIPTION);

		identifierEClass = createEClass(IDENTIFIER);

		identifierPrimaryEClass = createEClass(IDENTIFIER_PRIMARY);
		createEReference(identifierPrimaryEClass, IDENTIFIER_PRIMARY__ATTRIBUTE);
		createEReference(identifierPrimaryEClass, IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL);

		identifierNonPrimaryEClass = createEClass(IDENTIFIER_NON_PRIMARY);
		createEReference(identifierNonPrimaryEClass, IDENTIFIER_NON_PRIMARY__ATTRIBUTE);
		createEReference(identifierNonPrimaryEClass, IDENTIFIER_NON_PRIMARY__ATTRIBUTE_REFERENTIAL);

		identifierParticipantEClass = createEClass(IDENTIFIER_PARTICIPANT);

		eventEClass = createEClass(EVENT);
		createEReference(eventEClass, EVENT__TRANSITION);
		createEReference(eventEClass, EVENT__PARAMETER);

		signalEventEClass = createEClass(SIGNAL_EVENT);

		timerEventEClass = createEClass(TIMER_EVENT);
		createEAttribute(timerEventEClass, TIMER_EVENT__TIME_MS);

		changeEventEClass = createEClass(CHANGE_EVENT);

		callEventEClass = createEClass(CALL_EVENT);

		exceptionEventEClass = createEClass(EXCEPTION_EVENT);

		primitiveTypeEClass = createEClass(PRIMITIVE_TYPE);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__PRIMITIVE);
		createEReference(primitiveTypeEClass, PRIMITIVE_TYPE__SYSTEM);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__PRECISION);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__SCALE);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__UTC);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__LENGTH);
		createEAttribute(primitiveTypeEClass, PRIMITIVE_TYPE__YES_NO);

		stateEClass = createEClass(STATE);
		createEReference(stateEClass, STATE__ENTRY_PROCEDURE);
		createEReference(stateEClass, STATE__STATE_MACHINE);

		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__EVENT);
		createEReference(transitionEClass, TRANSITION__FROM_STATE);
		createEReference(transitionEClass, TRANSITION__TO_STATE);

		procedureEClass = createEClass(PROCEDURE);
		createEReference(procedureEClass, PROCEDURE__ACTION);

		initialStateEClass = createEClass(INITIAL_STATE);
		createEReference(initialStateEClass, INITIAL_STATE__STATE_MACHINE);

		finalStateEClass = createEClass(FINAL_STATE);
		createEReference(finalStateEClass, FINAL_STATE__STATE_MACHINE);

		statelyEClass = createEClass(STATELY);

		stateMachineEClass = createEClass(STATE_MACHINE);
		createEReference(stateMachineEClass, STATE_MACHINE__CLASS);
		createEReference(stateMachineEClass, STATE_MACHINE__INITIAL_STATE);
		createEReference(stateMachineEClass, STATE_MACHINE__STATE);
		createEReference(stateMachineEClass, STATE_MACHINE__FINAL_STATE);
		createEReference(stateMachineEClass, STATE_MACHINE__EVENT);

		fromStateEClass = createEClass(FROM_STATE);
		createEReference(fromStateEClass, FROM_STATE__TRANSITION_TO);

		toStateEClass = createEClass(TO_STATE);
		createEReference(toStateEClass, TO_STATE__TRANSITION_FROM);
		createEReference(toStateEClass, TO_STATE__EVENT);

		indexEClass = createEClass(INDEX);
		createEReference(indexEClass, INDEX__ATTRIBUTE);

		classPersistenceEClass = createEClass(CLASS_PERSISTENCE);
		createEAttribute(classPersistenceEClass, CLASS_PERSISTENCE__SCHEMA);
		createEAttribute(classPersistenceEClass, CLASS_PERSISTENCE__TABLE);
		createEReference(classPersistenceEClass, CLASS_PERSISTENCE__INDEX);

		attributePersistenceEClass = createEClass(ATTRIBUTE_PERSISTENCE);
		createEAttribute(attributePersistenceEClass, ATTRIBUTE_PERSISTENCE__COLUMN);
		createEAttribute(attributePersistenceEClass, ATTRIBUTE_PERSISTENCE__GENERATED_BY_SEQUENCE);
		createEAttribute(attributePersistenceEClass, ATTRIBUTE_PERSISTENCE__GENERATED_VALUE);
		createEAttribute(attributePersistenceEClass, ATTRIBUTE_PERSISTENCE__LENGTH);
		createEAttribute(attributePersistenceEClass, ATTRIBUTE_PERSISTENCE__SCALE);
		createEAttribute(attributePersistenceEClass, ATTRIBUTE_PERSISTENCE__PRECISION);

		associationEndPersistenceEClass = createEClass(ASSOCIATION_END_PERSISTENCE);
		createEAttribute(associationEndPersistenceEClass, ASSOCIATION_END_PERSISTENCE__LAZY_FETCH);
		createEReference(associationEndPersistenceEClass, ASSOCIATION_END_PERSISTENCE__ORDER_BY);

		dataTypeEClass = createEClass(DATA_TYPE);
		createEReference(dataTypeEClass, DATA_TYPE__ATTRIBUTE);
		createEReference(dataTypeEClass, DATA_TYPE__PACKAGE);

		specializationGroupEClass = createEClass(SPECIALIZATION_GROUP);
		createEReference(specializationGroupEClass, SPECIALIZATION_GROUP__GENERALIZATION);
		createEReference(specializationGroupEClass, SPECIALIZATION_GROUP__SPECIALIZATION);

		specializationEClass = createEClass(SPECIALIZATION);
		createEReference(specializationEClass, SPECIALIZATION__GROUP);

		// Create enums
		primitiveEEnum = createEEnum(PRIMITIVE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CollaborationPackage theCollaborationPackage = (CollaborationPackage)EPackage.Registry.INSTANCE.getEPackage(CollaborationPackage.eNS_URI);
		DomainPackage theDomainPackage = (DomainPackage)EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI);
		DiagramPackage theDiagramPackage = (DiagramPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI);
		UsePackage theUsePackage = (UsePackage)EPackage.Registry.INSTANCE.getEPackage(UsePackage.eNS_URI);
		ActivityPackage theActivityPackage = (ActivityPackage)EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCollaborationPackage);
		getESubpackages().add(theDomainPackage);
		getESubpackages().add(theDiagramPackage);
		getESubpackages().add(theUsePackage);
		getESubpackages().add(theActivityPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		systemEClass.getESuperTypes().add(this.getNamed());
		packageEClass.getESuperTypes().add(this.getNamed());
		classEClass.getESuperTypes().add(this.getNamed());
		associationEClass.getESuperTypes().add(this.getNamed());
		associationEndPrimaryEClass.getESuperTypes().add(this.getAssociationEnd());
		associationEndSecondaryEClass.getESuperTypes().add(this.getAssociationEnd());
		associationEndEClass.getESuperTypes().add(this.getNamed());
		associationClassEClass.getESuperTypes().add(this.getClass_());
		attributeEClass.getESuperTypes().add(this.getIdentifierParticipant());
		attributeReferentialEClass.getESuperTypes().add(this.getIdentifierParticipant());
		operationSignatureEClass.getESuperTypes().add(this.getNamed());
		operationEClass.getESuperTypes().add(this.getOperationSignature());
		freeTypeEClass.getESuperTypes().add(this.getType());
		typeEClass.getESuperTypes().add(this.getNamed());
		parameterEClass.getESuperTypes().add(this.getNamed());
		actionLanguageEClass.getESuperTypes().add(this.getNamed());
		objectConstraintLanguageEClass.getESuperTypes().add(this.getNamed());
		identifierEClass.getESuperTypes().add(this.getNamed());
		identifierPrimaryEClass.getESuperTypes().add(this.getIdentifier());
		identifierNonPrimaryEClass.getESuperTypes().add(this.getIdentifier());
		identifierParticipantEClass.getESuperTypes().add(this.getNamed());
		eventEClass.getESuperTypes().add(this.getNamed());
		signalEventEClass.getESuperTypes().add(this.getEvent());
		timerEventEClass.getESuperTypes().add(this.getEvent());
		changeEventEClass.getESuperTypes().add(this.getEvent());
		callEventEClass.getESuperTypes().add(this.getEvent());
		exceptionEventEClass.getESuperTypes().add(this.getEvent());
		primitiveTypeEClass.getESuperTypes().add(this.getType());
		stateEClass.getESuperTypes().add(this.getToState());
		stateEClass.getESuperTypes().add(this.getFromState());
		transitionEClass.getESuperTypes().add(this.getNamed());
		procedureEClass.getESuperTypes().add(this.getNamed());
		initialStateEClass.getESuperTypes().add(this.getFromState());
		finalStateEClass.getESuperTypes().add(this.getToState());
		statelyEClass.getESuperTypes().add(this.getNamed());
		fromStateEClass.getESuperTypes().add(this.getStately());
		toStateEClass.getESuperTypes().add(this.getStately());
		indexEClass.getESuperTypes().add(this.getNamed());
		dataTypeEClass.getESuperTypes().add(this.getNamed());
		specializationGroupEClass.getESuperTypes().add(this.getNamed());
		specializationEClass.getESuperTypes().add(this.getClass_());

		// Initialize classes and features; add operations and parameters
		initEClass(systemEClass, model.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_Package(), this.getPackage(), null, "package", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Association(), this.getAssociation(), null, "association", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Constraint(), this.getObjectConstraintLanguage(), null, "constraint", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Collaborator(), theCollaborationPackage.getCollaborator(), null, "collaborator", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Communication(), theCollaborationPackage.getCommunication(), null, "communication", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Domain(), theDomainPackage.getDomain(), null, "domain", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Bridge(), theDomainPackage.getBridge(), null, "bridge", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_UseCase(), theUsePackage.getUseCase(), null, "useCase", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_ActorUseCase(), theActivityPackage.getActorUseCase(), null, "actorUseCase", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_UnitTest(), theUsePackage.getUnitTest(), null, "unitTest", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Event(), this.getEvent(), null, "event", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_FreeType(), this.getFreeType(), this.getFreeType_System(), "freeType", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSystem_FreeType().getEKeys().add(this.getNamed_Name());
		initEReference(getSystem_PrimitiveType(), this.getPrimitiveType(), this.getPrimitiveType_System(), "primitiveType", null, 0, -1, model.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getSystem_PrimitiveType().getEKeys().add(this.getNamed_Name());

		EOperation op = addEOperation(systemEClass, ecorePackage.getEBoolean(), "passesTest", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theUsePackage.getUnitTest(), "test", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(packageEClass, model.Package.class, "Package", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackage_Class(), this.getClass_(), this.getClass_Package(), "class", null, 0, -1, model.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackage_SubPackage(), this.getPackage(), this.getPackage_Parent(), "subPackage", null, 0, -1, model.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getPackage_SubPackage().getEKeys().add(this.getNamed_Name());
		initEReference(getPackage_Parent(), this.getPackage(), this.getPackage_SubPackage(), "parent", null, 0, 1, model.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackage_DataType(), this.getDataType(), this.getDataType_Package(), "dataType", null, 0, -1, model.Package.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classEClass, model.Class.class, "Class", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClass_Package(), this.getPackage(), this.getPackage_Class(), "package", null, 0, 1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Attribute(), this.getAttribute(), this.getAttribute_Class(), "attribute", null, 0, -1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_AttributeReferential(), this.getAttributeReferential(), this.getAttributeReferential_Class(), "attributeReferential", null, 0, -1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Operation(), this.getOperation(), null, "operation", null, 0, -1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Constraints(), this.getObjectConstraintLanguage(), null, "constraints", null, 0, 1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_StateMachine(), this.getStateMachine(), this.getStateMachine_Class(), "stateMachine", null, 0, 1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_IdentifierPrimary(), this.getIdentifierPrimary(), null, "identifierPrimary", null, 0, 1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_IdentifierNonPrimary(), this.getIdentifierNonPrimary(), null, "identifierNonPrimary", null, 0, -1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getClass_IdentifierNonPrimary().getEKeys().add(this.getNamed_Name());
		initEReference(getClass_AssociationEndPrimary(), this.getAssociationEndPrimary(), this.getAssociationEndPrimary_Class(), "associationEndPrimary", null, 0, -1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_AssociationEndSecondary(), this.getAssociationEndSecondary(), this.getAssociationEndSecondary_Class(), "associationEndSecondary", null, 0, -1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_Persistence(), this.getClassPersistence(), null, "persistence", null, 0, 1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClass_SpecializationGroup(), this.getSpecializationGroup(), this.getSpecializationGroup_Generalization(), "specializationGroup", null, 0, -1, model.Class.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getClass_SpecializationGroup().getEKeys().add(this.getNamed_Name());

		initEClass(associationEClass, Association.class, "Association", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociation_Primary(), this.getAssociationEndPrimary(), this.getAssociationEndPrimary_Association(), "primary", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociation_Secondary(), this.getAssociationEndSecondary(), this.getAssociationEndSecondary_Association(), "secondary", null, 1, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociation_AssociationClass(), this.getAssociationClass(), this.getAssociationClass_Association(), "associationClass", null, 0, 1, Association.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getAssociation_AssociationClass().getEKeys().add(this.getNamed_Name());

		initEClass(associationEndPrimaryEClass, AssociationEndPrimary.class, "AssociationEndPrimary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociationEndPrimary_Class(), this.getClass_(), this.getClass_AssociationEndPrimary(), "class", null, 1, 1, AssociationEndPrimary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationEndPrimary_Association(), this.getAssociation(), this.getAssociation_Primary(), "association", null, 1, 1, AssociationEndPrimary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationEndSecondaryEClass, AssociationEndSecondary.class, "AssociationEndSecondary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociationEndSecondary_Class(), this.getClass_(), this.getClass_AssociationEndSecondary(), "class", null, 1, 1, AssociationEndSecondary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationEndSecondary_Association(), this.getAssociation(), this.getAssociation_Secondary(), "association", null, 1, 1, AssociationEndSecondary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationEndEClass, AssociationEnd.class, "AssociationEnd", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssociationEnd_Mandatory(), ecorePackage.getEBoolean(), "mandatory", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociationEnd_Multiple(), ecorePackage.getEBoolean(), "multiple", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociationEnd_VerbClause(), ecorePackage.getEString(), "verbClause", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociationEnd_Role(), ecorePackage.getEString(), "role", null, 1, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAssociationEnd_RolePlural(), ecorePackage.getEString(), "rolePlural", null, 0, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationEnd_DerivedAttribute(), this.getAttributeReferential(), this.getAttributeReferential_AssociationEnd(), "derivedAttribute", null, 0, -1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationEnd_Persistence(), this.getAssociationEndPersistence(), null, "persistence", null, 0, 1, AssociationEnd.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationClassEClass, AssociationClass.class, "AssociationClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssociationClass_Association(), this.getAssociation(), this.getAssociation_AssociationClass(), "association", null, 1, 1, AssociationClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttribute_Class(), this.getClass_(), this.getClass_Attribute(), "class", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_Constraints(), this.getObjectConstraintLanguage(), null, "constraints", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_Type(), this.getPrimitiveType(), null, "type", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Unique(), ecorePackage.getEBoolean(), "unique", null, 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_IdentifierPrimary(), this.getIdentifierPrimary(), this.getIdentifierPrimary_Attribute(), "identifierPrimary", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getAttribute_IdentifierPrimary().getEKeys().add(this.getNamed_Name());
		initEReference(getAttribute_IdentifierNonPrimary(), this.getIdentifierNonPrimary(), this.getIdentifierNonPrimary_Attribute(), "identifierNonPrimary", null, 0, -1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Mandatory(), ecorePackage.getEBoolean(), "mandatory", "true", 1, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getAttribute_Persistence(), this.getAttributePersistence(), null, "persistence", null, 0, 1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttribute_Values(), ecorePackage.getEString(), "values", null, 0, -1, Attribute.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeReferentialEClass, AttributeReferential.class, "AttributeReferential", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeReferential_AssociationEnd(), this.getAssociationEnd(), this.getAssociationEnd_DerivedAttribute(), "associationEnd", null, 0, 1, AttributeReferential.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeReferential_Class(), this.getClass_(), this.getClass_AttributeReferential(), "class", null, 1, 1, AttributeReferential.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeReferential_IdentifierPrimary(), this.getIdentifierPrimary(), this.getIdentifierPrimary_AttributeReferential(), "identifierPrimary", null, 0, -1, AttributeReferential.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeReferential_IdentifierNonPrimary(), this.getIdentifierNonPrimary(), this.getIdentifierNonPrimary_AttributeReferential(), "identifierNonPrimary", null, 0, -1, AttributeReferential.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationSignatureEClass, OperationSignature.class, "OperationSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationSignature_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, OperationSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationSignature_Returns(), this.getType(), null, "returns", null, 0, 1, OperationSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationSignature_ReturnsMultiple(), ecorePackage.getEBoolean(), "returnsMultiple", "false", 0, 1, OperationSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_Action(), this.getActionLanguage(), null, "action", null, 0, 1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(freeTypeEClass, FreeType.class, "FreeType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFreeType_Type(), ecorePackage.getEString(), "type", null, 1, 1, FreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFreeType_Multiple(), ecorePackage.getEBoolean(), "multiple", null, 1, 1, FreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFreeType_System(), this.getSystem(), this.getSystem_FreeType(), "system", null, 1, 1, FreeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeEClass, Type.class, "Type", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Type(), this.getType(), null, "type", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameter_Multiple(), ecorePackage.getEBoolean(), "multiple", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionLanguageEClass, ActionLanguage.class, "ActionLanguage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActionLanguage_Action(), ecorePackage.getEString(), "action", null, 1, 1, ActionLanguage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectConstraintLanguageEClass, ObjectConstraintLanguage.class, "ObjectConstraintLanguage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getObjectConstraintLanguage_Ocl(), ecorePackage.getEString(), "ocl", null, 1, 1, ObjectConstraintLanguage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedEClass, Named.class, "Named", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamed_Name(), ecorePackage.getEString(), "name", null, 1, 1, Named.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamed_Description(), ecorePackage.getEString(), "description", null, 0, 1, Named.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifierEClass, Identifier.class, "Identifier", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(identifierPrimaryEClass, IdentifierPrimary.class, "IdentifierPrimary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifierPrimary_Attribute(), this.getAttribute(), this.getAttribute_IdentifierPrimary(), "attribute", null, 0, -1, IdentifierPrimary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIdentifierPrimary_Attribute().getEKeys().add(this.getNamed_Name());
		initEReference(getIdentifierPrimary_AttributeReferential(), this.getAttributeReferential(), this.getAttributeReferential_IdentifierPrimary(), "attributeReferential", null, 0, -1, IdentifierPrimary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIdentifierPrimary_AttributeReferential().getEKeys().add(this.getNamed_Name());

		initEClass(identifierNonPrimaryEClass, IdentifierNonPrimary.class, "IdentifierNonPrimary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifierNonPrimary_Attribute(), this.getAttribute(), this.getAttribute_IdentifierNonPrimary(), "attribute", null, 0, -1, IdentifierNonPrimary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIdentifierNonPrimary_Attribute().getEKeys().add(this.getNamed_Name());
		initEReference(getIdentifierNonPrimary_AttributeReferential(), this.getAttributeReferential(), this.getAttributeReferential_IdentifierNonPrimary(), "attributeReferential", null, 0, -1, IdentifierNonPrimary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIdentifierNonPrimary_AttributeReferential().getEKeys().add(this.getNamed_Name());

		initEClass(identifierParticipantEClass, IdentifierParticipant.class, "IdentifierParticipant", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEvent_Transition(), this.getTransition(), this.getTransition_Event(), "transition", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getEvent_Transition().getEKeys().add(this.getNamed_Name());
		initEReference(getEvent_Parameter(), this.getParameter(), null, "parameter", null, 0, -1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(signalEventEClass, SignalEvent.class, "SignalEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(timerEventEClass, TimerEvent.class, "TimerEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimerEvent_TimeMs(), ecorePackage.getELong(), "timeMs", null, 1, 1, TimerEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(changeEventEClass, ChangeEvent.class, "ChangeEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(callEventEClass, CallEvent.class, "CallEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(exceptionEventEClass, ExceptionEvent.class, "ExceptionEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveTypeEClass, PrimitiveType.class, "PrimitiveType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveType_Primitive(), this.getPrimitive(), "primitive", null, 1, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPrimitiveType_System(), this.getSystem(), this.getSystem_PrimitiveType(), "system", null, 1, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getPrimitiveType_System().getEKeys().add(this.getNamed_Name());
		initEAttribute(getPrimitiveType_Precision(), ecorePackage.getEIntegerObject(), "precision", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitiveType_Scale(), ecorePackage.getEIntegerObject(), "scale", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitiveType_Utc(), ecorePackage.getEBoolean(), "utc", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitiveType_Length(), ecorePackage.getEIntegerObject(), "length", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrimitiveType_YesNo(), ecorePackage.getEBoolean(), "yesNo", null, 0, 1, PrimitiveType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getState_EntryProcedure(), this.getProcedure(), null, "entryProcedure", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getState_StateMachine(), this.getStateMachine(), this.getStateMachine_State(), "stateMachine", null, 1, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_Event(), this.getEvent(), this.getEvent_Transition(), "event", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_FromState(), this.getFromState(), this.getFromState_TransitionTo(), "fromState", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_ToState(), this.getToState(), this.getToState_TransitionFrom(), "toState", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(procedureEClass, Procedure.class, "Procedure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcedure_Action(), this.getActionLanguage(), null, "action", null, 1, 1, Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initialStateEClass, InitialState.class, "InitialState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInitialState_StateMachine(), this.getStateMachine(), this.getStateMachine_InitialState(), "stateMachine", null, 1, 1, InitialState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(finalStateEClass, FinalState.class, "FinalState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFinalState_StateMachine(), this.getStateMachine(), this.getStateMachine_FinalState(), "stateMachine", null, 1, 1, FinalState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statelyEClass, Stately.class, "Stately", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stateMachineEClass, StateMachine.class, "StateMachine", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStateMachine_Class(), this.getClass_(), this.getClass_StateMachine(), "class", null, 1, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_InitialState(), this.getInitialState(), this.getInitialState_StateMachine(), "initialState", null, 1, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_State(), this.getState(), this.getState_StateMachine(), "state", null, 0, -1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_FinalState(), this.getFinalState(), this.getFinalState_StateMachine(), "finalState", null, 0, 1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStateMachine_Event(), this.getEvent(), null, "event", null, 0, -1, StateMachine.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fromStateEClass, FromState.class, "FromState", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFromState_TransitionTo(), this.getTransition(), this.getTransition_FromState(), "transitionTo", null, 1, -1, FromState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(toStateEClass, ToState.class, "ToState", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getToState_TransitionFrom(), this.getTransition(), this.getTransition_ToState(), "transitionFrom", null, 1, -1, ToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getToState_Event(), this.getEvent(), null, "event", null, 0, -1, ToState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indexEClass, Index.class, "Index", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIndex_Attribute(), this.getAttribute(), null, "attribute", null, 0, -1, Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getIndex_Attribute().getEKeys().add(this.getNamed_Name());

		initEClass(classPersistenceEClass, ClassPersistence.class, "ClassPersistence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassPersistence_Schema(), ecorePackage.getEString(), "schema", null, 0, 1, ClassPersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassPersistence_Table(), ecorePackage.getEString(), "table", null, 0, 1, ClassPersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassPersistence_Index(), this.getIndex(), null, "index", null, 0, -1, ClassPersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getClassPersistence_Index().getEKeys().add(this.getNamed_Name());

		initEClass(attributePersistenceEClass, AttributePersistence.class, "AttributePersistence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributePersistence_Column(), ecorePackage.getEString(), "column", null, 0, 1, AttributePersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributePersistence_GeneratedBySequence(), ecorePackage.getEBoolean(), "generatedBySequence", null, 1, 1, AttributePersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributePersistence_GeneratedValue(), ecorePackage.getEBoolean(), "generatedValue", null, 1, 1, AttributePersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributePersistence_Length(), ecorePackage.getEIntegerObject(), "length", null, 0, 1, AttributePersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributePersistence_Scale(), ecorePackage.getEIntegerObject(), "scale", null, 0, 1, AttributePersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributePersistence_Precision(), ecorePackage.getEIntegerObject(), "precision", null, 0, 1, AttributePersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(associationEndPersistenceEClass, AssociationEndPersistence.class, "AssociationEndPersistence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAssociationEndPersistence_LazyFetch(), ecorePackage.getEBoolean(), "lazyFetch", "true", 1, 1, AssociationEndPersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAssociationEndPersistence_OrderBy(), this.getAttribute(), null, "orderBy", null, 0, -1, AssociationEndPersistence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getAssociationEndPersistence_OrderBy().getEKeys().add(this.getNamed_Name());

		initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataType_Attribute(), this.getType(), null, "attribute", null, 0, -1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getDataType_Attribute().getEKeys().add(this.getNamed_Name());
		initEReference(getDataType_Package(), this.getPackage(), this.getPackage_DataType(), "package", null, 1, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specializationGroupEClass, SpecializationGroup.class, "SpecializationGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecializationGroup_Generalization(), this.getClass_(), this.getClass_SpecializationGroup(), "generalization", null, 1, 1, SpecializationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSpecializationGroup_Specialization(), this.getSpecialization(), this.getSpecialization_Group(), "specialization", null, 1, -1, SpecializationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specializationEClass, Specialization.class, "Specialization", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecialization_Group(), this.getSpecializationGroup(), this.getSpecializationGroup_Specialization(), "group", null, 1, -1, Specialization.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(primitiveEEnum, Primitive.class, "Primitive");
		addEEnumLiteral(primitiveEEnum, Primitive.BOOLEAN);
		addEEnumLiteral(primitiveEEnum, Primitive.INTEGER);
		addEEnumLiteral(primitiveEEnum, Primitive.STRING);
		addEEnumLiteral(primitiveEEnum, Primitive.DECIMAL);
		addEEnumLiteral(primitiveEEnum, Primitive.ARBITRARY_ID);
		addEEnumLiteral(primitiveEEnum, Primitive.LONG);
		addEEnumLiteral(primitiveEEnum, Primitive.DATE);
		addEEnumLiteral(primitiveEEnum, Primitive.TIMESTAMP);
		addEEnumLiteral(primitiveEEnum, Primitive.TIME);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// annotation
		createAnnotationAnnotations();
	}

	/**
	 * Initializes the annotations for <b>annotation</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createAnnotationAnnotations() {
		String source = "annotation";		
		addAnnotation
		  (signalEventEClass, 
		   source, 
		   new String[] {
			 "documentation", "asynchronous"
		   });		
		addAnnotation
		  (timerEventEClass, 
		   source, 
		   new String[] {
			 "documentation", "asynchronous"
		   });		
		addAnnotation
		  (changeEventEClass, 
		   source, 
		   new String[] {
			 "documentation", "asynchronous"
		   });		
		addAnnotation
		  (callEventEClass, 
		   source, 
		   new String[] {
			 "documentation", "synchronous"
		   });		
		addAnnotation
		  (exceptionEventEClass, 
		   source, 
		   new String[] {
			 "documentation", "synchronous"
		   });
	}

} //ModelPackageImpl
