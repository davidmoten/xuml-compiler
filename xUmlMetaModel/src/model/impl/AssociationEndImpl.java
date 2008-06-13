/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationEndImpl.java,v 1.4 2008/06/11 07:28:43 dxm Exp $
 */
package model.impl;

import java.util.Collection;

import model.AssociationEnd;
import model.AssociationEndPersistence;
import model.AttributeReferential;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.AssociationEndImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.AssociationEndImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.AssociationEndImpl#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link model.impl.AssociationEndImpl#isMultiple <em>Multiple</em>}</li>
 *   <li>{@link model.impl.AssociationEndImpl#getVerbClause <em>Verb Clause</em>}</li>
 *   <li>{@link model.impl.AssociationEndImpl#getRole <em>Role</em>}</li>
 *   <li>{@link model.impl.AssociationEndImpl#getRolePlural <em>Role Plural</em>}</li>
 *   <li>{@link model.impl.AssociationEndImpl#getDerivedAttribute <em>Derived Attribute</em>}</li>
 *   <li>{@link model.impl.AssociationEndImpl#getPersistence <em>Persistence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AssociationEndImpl extends EObjectImpl implements AssociationEnd {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMandatory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANDATORY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMandatory()
	 * @generated
	 * @ordered
	 */
	protected boolean mandatory = MANDATORY_EDEFAULT;

	/**
	 * The default value of the '{@link #isMultiple() <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiple()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MULTIPLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isMultiple() <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMultiple()
	 * @generated
	 * @ordered
	 */
	protected boolean multiple = MULTIPLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVerbClause() <em>Verb Clause</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbClause()
	 * @generated
	 * @ordered
	 */
	protected static final String VERB_CLAUSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVerbClause() <em>Verb Clause</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVerbClause()
	 * @generated
	 * @ordered
	 */
	protected String verbClause = VERB_CLAUSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRole() <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected String role = ROLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRolePlural() <em>Role Plural</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRolePlural()
	 * @generated
	 * @ordered
	 */
	protected static final String ROLE_PLURAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRolePlural() <em>Role Plural</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRolePlural()
	 * @generated
	 * @ordered
	 */
	protected String rolePlural = ROLE_PLURAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDerivedAttribute() <em>Derived Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDerivedAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeReferential> derivedAttribute;

	/**
	 * The cached value of the '{@link #getPersistence() <em>Persistence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistence()
	 * @generated
	 * @ordered
	 */
	protected AssociationEndPersistence persistence;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ASSOCIATION_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMandatory() {
		return mandatory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMandatory(boolean newMandatory) {
		boolean oldMandatory = mandatory;
		mandatory = newMandatory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END__MANDATORY, oldMandatory, mandatory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isMultiple() {
		return multiple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMultiple(boolean newMultiple) {
		boolean oldMultiple = multiple;
		multiple = newMultiple;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END__MULTIPLE, oldMultiple, multiple));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVerbClause() {
		return verbClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVerbClause(String newVerbClause) {
		String oldVerbClause = verbClause;
		verbClause = newVerbClause;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END__VERB_CLAUSE, oldVerbClause, verbClause));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(String newRole) {
		String oldRole = role;
		role = newRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END__ROLE, oldRole, role));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRolePlural() {
		return rolePlural;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRolePlural(String newRolePlural) {
		String oldRolePlural = rolePlural;
		rolePlural = newRolePlural;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END__ROLE_PLURAL, oldRolePlural, rolePlural));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeReferential> getDerivedAttribute() {
		if (derivedAttribute == null) {
			derivedAttribute = new EObjectWithInverseResolvingEList<AttributeReferential>(AttributeReferential.class, this, ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE, ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END);
		}
		return derivedAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEndPersistence getPersistence() {
		return persistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPersistence(AssociationEndPersistence newPersistence, NotificationChain msgs) {
		AssociationEndPersistence oldPersistence = persistence;
		persistence = newPersistence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END__PERSISTENCE, oldPersistence, newPersistence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistence(AssociationEndPersistence newPersistence) {
		if (newPersistence != persistence) {
			NotificationChain msgs = null;
			if (persistence != null)
				msgs = ((InternalEObject)persistence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ASSOCIATION_END__PERSISTENCE, null, msgs);
			if (newPersistence != null)
				msgs = ((InternalEObject)newPersistence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ASSOCIATION_END__PERSISTENCE, null, msgs);
			msgs = basicSetPersistence(newPersistence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END__PERSISTENCE, newPersistence, newPersistence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDerivedAttribute()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE:
				return ((InternalEList<?>)getDerivedAttribute()).basicRemove(otherEnd, msgs);
			case ModelPackage.ASSOCIATION_END__PERSISTENCE:
				return basicSetPersistence(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION_END__NAME:
				return getName();
			case ModelPackage.ASSOCIATION_END__DESCRIPTION:
				return getDescription();
			case ModelPackage.ASSOCIATION_END__MANDATORY:
				return isMandatory() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ASSOCIATION_END__MULTIPLE:
				return isMultiple() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ASSOCIATION_END__VERB_CLAUSE:
				return getVerbClause();
			case ModelPackage.ASSOCIATION_END__ROLE:
				return getRole();
			case ModelPackage.ASSOCIATION_END__ROLE_PLURAL:
				return getRolePlural();
			case ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE:
				return getDerivedAttribute();
			case ModelPackage.ASSOCIATION_END__PERSISTENCE:
				return getPersistence();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION_END__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.ASSOCIATION_END__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.ASSOCIATION_END__MANDATORY:
				setMandatory(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ASSOCIATION_END__MULTIPLE:
				setMultiple(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ASSOCIATION_END__VERB_CLAUSE:
				setVerbClause((String)newValue);
				return;
			case ModelPackage.ASSOCIATION_END__ROLE:
				setRole((String)newValue);
				return;
			case ModelPackage.ASSOCIATION_END__ROLE_PLURAL:
				setRolePlural((String)newValue);
				return;
			case ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE:
				getDerivedAttribute().clear();
				getDerivedAttribute().addAll((Collection<? extends AttributeReferential>)newValue);
				return;
			case ModelPackage.ASSOCIATION_END__PERSISTENCE:
				setPersistence((AssociationEndPersistence)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION_END__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION_END__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION_END__MANDATORY:
				setMandatory(MANDATORY_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION_END__MULTIPLE:
				setMultiple(MULTIPLE_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION_END__VERB_CLAUSE:
				setVerbClause(VERB_CLAUSE_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION_END__ROLE:
				setRole(ROLE_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION_END__ROLE_PLURAL:
				setRolePlural(ROLE_PLURAL_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE:
				getDerivedAttribute().clear();
				return;
			case ModelPackage.ASSOCIATION_END__PERSISTENCE:
				setPersistence((AssociationEndPersistence)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION_END__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.ASSOCIATION_END__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.ASSOCIATION_END__MANDATORY:
				return mandatory != MANDATORY_EDEFAULT;
			case ModelPackage.ASSOCIATION_END__MULTIPLE:
				return multiple != MULTIPLE_EDEFAULT;
			case ModelPackage.ASSOCIATION_END__VERB_CLAUSE:
				return VERB_CLAUSE_EDEFAULT == null ? verbClause != null : !VERB_CLAUSE_EDEFAULT.equals(verbClause);
			case ModelPackage.ASSOCIATION_END__ROLE:
				return ROLE_EDEFAULT == null ? role != null : !ROLE_EDEFAULT.equals(role);
			case ModelPackage.ASSOCIATION_END__ROLE_PLURAL:
				return ROLE_PLURAL_EDEFAULT == null ? rolePlural != null : !ROLE_PLURAL_EDEFAULT.equals(rolePlural);
			case ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE:
				return derivedAttribute != null && !derivedAttribute.isEmpty();
			case ModelPackage.ASSOCIATION_END__PERSISTENCE:
				return persistence != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(", mandatory: ");
		result.append(mandatory);
		result.append(", multiple: ");
		result.append(multiple);
		result.append(", verbClause: ");
		result.append(verbClause);
		result.append(", role: ");
		result.append(role);
		result.append(", rolePlural: ");
		result.append(rolePlural);
		result.append(')');
		return result.toString();
	}

} //AssociationEndImpl
