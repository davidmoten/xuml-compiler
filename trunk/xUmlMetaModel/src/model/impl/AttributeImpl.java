/**
 * <copyright>
 * </copyright>
 *
 * $Id: AttributeImpl.java,v 1.2 2008/05/23 05:15:15 dxm Exp $
 */
package model.impl;

import java.util.Collection;

import model.Attribute;
import model.AttributePersistence;
import model.IdentifierNonPrimary;
import model.IdentifierPrimary;
import model.ModelPackage;
import model.ObjectConstraintLanguage;
import model.PrimitiveType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#isUnique <em>Unique</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#getIdentifierPrimary <em>Identifier Primary</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#getIdentifierNonPrimary <em>Identifier Non Primary</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#getPersistence <em>Persistence</em>}</li>
 *   <li>{@link model.impl.AttributeImpl#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeImpl extends EObjectImpl implements Attribute {
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
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected ObjectConstraintLanguage constraints;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected PrimitiveType type;

	/**
	 * The default value of the '{@link #isUnique() <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UNIQUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUnique() <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean unique = UNIQUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIdentifierPrimary() <em>Identifier Primary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierPrimary()
	 * @generated
	 * @ordered
	 */
	protected IdentifierPrimary identifierPrimary;

	/**
	 * The cached value of the '{@link #getIdentifierNonPrimary() <em>Identifier Non Primary</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierNonPrimary()
	 * @generated
	 * @ordered
	 */
	protected EList<IdentifierNonPrimary> identifierNonPrimary;

	/**
	 * The default value of the '{@link #isMandatory() <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMandatory()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MANDATORY_EDEFAULT = true;

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
	 * The cached value of the '{@link #getPersistence() <em>Persistence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistence()
	 * @generated
	 * @ordered
	 */
	protected AttributePersistence persistence;

	/**
	 * The cached value of the '{@link #getValues() <em>Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValues()
	 * @generated
	 * @ordered
	 */
	protected EList<String> values;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ATTRIBUTE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Class getClass_() {
		if (eContainerFeatureID != ModelPackage.ATTRIBUTE__CLASS) return null;
		return (model.Class)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClass(model.Class newClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClass, ModelPackage.ATTRIBUTE__CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(model.Class newClass) {
		if (newClass != eInternalContainer() || (eContainerFeatureID != ModelPackage.ATTRIBUTE__CLASS && newClass != null)) {
			if (EcoreUtil.isAncestor(this, newClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newClass != null)
				msgs = ((InternalEObject)newClass).eInverseAdd(this, ModelPackage.CLASS__ATTRIBUTE, model.Class.class, msgs);
			msgs = basicSetClass(newClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__CLASS, newClass, newClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectConstraintLanguage getConstraints() {
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraints(ObjectConstraintLanguage newConstraints, NotificationChain msgs) {
		ObjectConstraintLanguage oldConstraints = constraints;
		constraints = newConstraints;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__CONSTRAINTS, oldConstraints, newConstraints);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraints(ObjectConstraintLanguage newConstraints) {
		if (newConstraints != constraints) {
			NotificationChain msgs = null;
			if (constraints != null)
				msgs = ((InternalEObject)constraints).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ATTRIBUTE__CONSTRAINTS, null, msgs);
			if (newConstraints != null)
				msgs = ((InternalEObject)newConstraints).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ATTRIBUTE__CONSTRAINTS, null, msgs);
			msgs = basicSetConstraints(newConstraints, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__CONSTRAINTS, newConstraints, newConstraints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (PrimitiveType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ATTRIBUTE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(PrimitiveType newType) {
		PrimitiveType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUnique() {
		return unique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnique(boolean newUnique) {
		boolean oldUnique = unique;
		unique = newUnique;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__UNIQUE, oldUnique, unique));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierPrimary getIdentifierPrimary() {
		if (identifierPrimary != null && identifierPrimary.eIsProxy()) {
			InternalEObject oldIdentifierPrimary = (InternalEObject)identifierPrimary;
			identifierPrimary = (IdentifierPrimary)eResolveProxy(oldIdentifierPrimary);
			if (identifierPrimary != oldIdentifierPrimary) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY, oldIdentifierPrimary, identifierPrimary));
			}
		}
		return identifierPrimary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierPrimary basicGetIdentifierPrimary() {
		return identifierPrimary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifierPrimary(IdentifierPrimary newIdentifierPrimary, NotificationChain msgs) {
		IdentifierPrimary oldIdentifierPrimary = identifierPrimary;
		identifierPrimary = newIdentifierPrimary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY, oldIdentifierPrimary, newIdentifierPrimary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifierPrimary(IdentifierPrimary newIdentifierPrimary) {
		if (newIdentifierPrimary != identifierPrimary) {
			NotificationChain msgs = null;
			if (identifierPrimary != null)
				msgs = ((InternalEObject)identifierPrimary).eInverseRemove(this, ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE, IdentifierPrimary.class, msgs);
			if (newIdentifierPrimary != null)
				msgs = ((InternalEObject)newIdentifierPrimary).eInverseAdd(this, ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE, IdentifierPrimary.class, msgs);
			msgs = basicSetIdentifierPrimary(newIdentifierPrimary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY, newIdentifierPrimary, newIdentifierPrimary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdentifierNonPrimary> getIdentifierNonPrimary() {
		if (identifierNonPrimary == null) {
			identifierNonPrimary = new EObjectWithInverseResolvingEList.ManyInverse<IdentifierNonPrimary>(IdentifierNonPrimary.class, this, ModelPackage.ATTRIBUTE__IDENTIFIER_NON_PRIMARY, ModelPackage.IDENTIFIER_NON_PRIMARY__ATTRIBUTE);
		}
		return identifierNonPrimary;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__MANDATORY, oldMandatory, mandatory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributePersistence getPersistence() {
		return persistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPersistence(AttributePersistence newPersistence, NotificationChain msgs) {
		AttributePersistence oldPersistence = persistence;
		persistence = newPersistence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__PERSISTENCE, oldPersistence, newPersistence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistence(AttributePersistence newPersistence) {
		if (newPersistence != persistence) {
			NotificationChain msgs = null;
			if (persistence != null)
				msgs = ((InternalEObject)persistence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ATTRIBUTE__PERSISTENCE, null, msgs);
			if (newPersistence != null)
				msgs = ((InternalEObject)newPersistence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ATTRIBUTE__PERSISTENCE, null, msgs);
			msgs = basicSetPersistence(newPersistence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE__PERSISTENCE, newPersistence, newPersistence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getValues() {
		if (values == null) {
			values = new EDataTypeUniqueEList<String>(String.class, this, ModelPackage.ATTRIBUTE__VALUES);
		}
		return values;
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
			case ModelPackage.ATTRIBUTE__CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetClass((model.Class)otherEnd, msgs);
			case ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY:
				if (identifierPrimary != null)
					msgs = ((InternalEObject)identifierPrimary).eInverseRemove(this, ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE, IdentifierPrimary.class, msgs);
				return basicSetIdentifierPrimary((IdentifierPrimary)otherEnd, msgs);
			case ModelPackage.ATTRIBUTE__IDENTIFIER_NON_PRIMARY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIdentifierNonPrimary()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.ATTRIBUTE__CLASS:
				return basicSetClass(null, msgs);
			case ModelPackage.ATTRIBUTE__CONSTRAINTS:
				return basicSetConstraints(null, msgs);
			case ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY:
				return basicSetIdentifierPrimary(null, msgs);
			case ModelPackage.ATTRIBUTE__IDENTIFIER_NON_PRIMARY:
				return ((InternalEList<?>)getIdentifierNonPrimary()).basicRemove(otherEnd, msgs);
			case ModelPackage.ATTRIBUTE__PERSISTENCE:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ModelPackage.ATTRIBUTE__CLASS:
				return eInternalContainer().eInverseRemove(this, ModelPackage.CLASS__ATTRIBUTE, model.Class.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ATTRIBUTE__NAME:
				return getName();
			case ModelPackage.ATTRIBUTE__DESCRIPTION:
				return getDescription();
			case ModelPackage.ATTRIBUTE__CLASS:
				return getClass_();
			case ModelPackage.ATTRIBUTE__CONSTRAINTS:
				return getConstraints();
			case ModelPackage.ATTRIBUTE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ModelPackage.ATTRIBUTE__UNIQUE:
				return isUnique() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY:
				if (resolve) return getIdentifierPrimary();
				return basicGetIdentifierPrimary();
			case ModelPackage.ATTRIBUTE__IDENTIFIER_NON_PRIMARY:
				return getIdentifierNonPrimary();
			case ModelPackage.ATTRIBUTE__MANDATORY:
				return isMandatory() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ATTRIBUTE__PERSISTENCE:
				return getPersistence();
			case ModelPackage.ATTRIBUTE__VALUES:
				return getValues();
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
			case ModelPackage.ATTRIBUTE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.ATTRIBUTE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.ATTRIBUTE__CLASS:
				setClass((model.Class)newValue);
				return;
			case ModelPackage.ATTRIBUTE__CONSTRAINTS:
				setConstraints((ObjectConstraintLanguage)newValue);
				return;
			case ModelPackage.ATTRIBUTE__TYPE:
				setType((PrimitiveType)newValue);
				return;
			case ModelPackage.ATTRIBUTE__UNIQUE:
				setUnique(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY:
				setIdentifierPrimary((IdentifierPrimary)newValue);
				return;
			case ModelPackage.ATTRIBUTE__IDENTIFIER_NON_PRIMARY:
				getIdentifierNonPrimary().clear();
				getIdentifierNonPrimary().addAll((Collection<? extends IdentifierNonPrimary>)newValue);
				return;
			case ModelPackage.ATTRIBUTE__MANDATORY:
				setMandatory(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ATTRIBUTE__PERSISTENCE:
				setPersistence((AttributePersistence)newValue);
				return;
			case ModelPackage.ATTRIBUTE__VALUES:
				getValues().clear();
				getValues().addAll((Collection<? extends String>)newValue);
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
			case ModelPackage.ATTRIBUTE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE__CLASS:
				setClass((model.Class)null);
				return;
			case ModelPackage.ATTRIBUTE__CONSTRAINTS:
				setConstraints((ObjectConstraintLanguage)null);
				return;
			case ModelPackage.ATTRIBUTE__TYPE:
				setType((PrimitiveType)null);
				return;
			case ModelPackage.ATTRIBUTE__UNIQUE:
				setUnique(UNIQUE_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY:
				setIdentifierPrimary((IdentifierPrimary)null);
				return;
			case ModelPackage.ATTRIBUTE__IDENTIFIER_NON_PRIMARY:
				getIdentifierNonPrimary().clear();
				return;
			case ModelPackage.ATTRIBUTE__MANDATORY:
				setMandatory(MANDATORY_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE__PERSISTENCE:
				setPersistence((AttributePersistence)null);
				return;
			case ModelPackage.ATTRIBUTE__VALUES:
				getValues().clear();
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
			case ModelPackage.ATTRIBUTE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.ATTRIBUTE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.ATTRIBUTE__CLASS:
				return getClass_() != null;
			case ModelPackage.ATTRIBUTE__CONSTRAINTS:
				return constraints != null;
			case ModelPackage.ATTRIBUTE__TYPE:
				return type != null;
			case ModelPackage.ATTRIBUTE__UNIQUE:
				return unique != UNIQUE_EDEFAULT;
			case ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY:
				return identifierPrimary != null;
			case ModelPackage.ATTRIBUTE__IDENTIFIER_NON_PRIMARY:
				return identifierNonPrimary != null && !identifierNonPrimary.isEmpty();
			case ModelPackage.ATTRIBUTE__MANDATORY:
				return mandatory != MANDATORY_EDEFAULT;
			case ModelPackage.ATTRIBUTE__PERSISTENCE:
				return persistence != null;
			case ModelPackage.ATTRIBUTE__VALUES:
				return values != null && !values.isEmpty();
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
		result.append(", unique: ");
		result.append(unique);
		result.append(", mandatory: ");
		result.append(mandatory);
		result.append(", values: ");
		result.append(values);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl
