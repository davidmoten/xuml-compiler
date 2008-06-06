/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import model.Association;
import model.AssociationClass;
import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.AssociationImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.AssociationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.AssociationImpl#getPrimary <em>Primary</em>}</li>
 *   <li>{@link model.impl.AssociationImpl#getSecondary <em>Secondary</em>}</li>
 *   <li>{@link model.impl.AssociationImpl#getAssociationClass <em>Association Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationImpl extends EObjectImpl implements Association {
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
	 * The cached value of the '{@link #getPrimary() <em>Primary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimary()
	 * @generated
	 * @ordered
	 */
	protected AssociationEndPrimary primary;

	/**
	 * The cached value of the '{@link #getSecondary() <em>Secondary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondary()
	 * @generated
	 * @ordered
	 */
	protected AssociationEndSecondary secondary;

	/**
	 * The cached value of the '{@link #getAssociationClass() <em>Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationClass()
	 * @generated
	 * @ordered
	 */
	protected AssociationClass associationClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ASSOCIATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEndPrimary getPrimary() {
		return primary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPrimary(AssociationEndPrimary newPrimary, NotificationChain msgs) {
		AssociationEndPrimary oldPrimary = primary;
		primary = newPrimary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION__PRIMARY, oldPrimary, newPrimary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimary(AssociationEndPrimary newPrimary) {
		if (newPrimary != primary) {
			NotificationChain msgs = null;
			if (primary != null)
				msgs = ((InternalEObject)primary).eInverseRemove(this, ModelPackage.ASSOCIATION_END_PRIMARY__ASSOCIATION, AssociationEndPrimary.class, msgs);
			if (newPrimary != null)
				msgs = ((InternalEObject)newPrimary).eInverseAdd(this, ModelPackage.ASSOCIATION_END_PRIMARY__ASSOCIATION, AssociationEndPrimary.class, msgs);
			msgs = basicSetPrimary(newPrimary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION__PRIMARY, newPrimary, newPrimary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEndSecondary getSecondary() {
		return secondary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondary(AssociationEndSecondary newSecondary, NotificationChain msgs) {
		AssociationEndSecondary oldSecondary = secondary;
		secondary = newSecondary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION__SECONDARY, oldSecondary, newSecondary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondary(AssociationEndSecondary newSecondary) {
		if (newSecondary != secondary) {
			NotificationChain msgs = null;
			if (secondary != null)
				msgs = ((InternalEObject)secondary).eInverseRemove(this, ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION, AssociationEndSecondary.class, msgs);
			if (newSecondary != null)
				msgs = ((InternalEObject)newSecondary).eInverseAdd(this, ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION, AssociationEndSecondary.class, msgs);
			msgs = basicSetSecondary(newSecondary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION__SECONDARY, newSecondary, newSecondary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass getAssociationClass() {
		if (associationClass != null && associationClass.eIsProxy()) {
			InternalEObject oldAssociationClass = (InternalEObject)associationClass;
			associationClass = (AssociationClass)eResolveProxy(oldAssociationClass);
			if (associationClass != oldAssociationClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ASSOCIATION__ASSOCIATION_CLASS, oldAssociationClass, associationClass));
			}
		}
		return associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationClass basicGetAssociationClass() {
		return associationClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociationClass(AssociationClass newAssociationClass, NotificationChain msgs) {
		AssociationClass oldAssociationClass = associationClass;
		associationClass = newAssociationClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION__ASSOCIATION_CLASS, oldAssociationClass, newAssociationClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationClass(AssociationClass newAssociationClass) {
		if (newAssociationClass != associationClass) {
			NotificationChain msgs = null;
			if (associationClass != null)
				msgs = ((InternalEObject)associationClass).eInverseRemove(this, ModelPackage.ASSOCIATION_CLASS__ASSOCIATION, AssociationClass.class, msgs);
			if (newAssociationClass != null)
				msgs = ((InternalEObject)newAssociationClass).eInverseAdd(this, ModelPackage.ASSOCIATION_CLASS__ASSOCIATION, AssociationClass.class, msgs);
			msgs = basicSetAssociationClass(newAssociationClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION__ASSOCIATION_CLASS, newAssociationClass, newAssociationClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION__PRIMARY:
				if (primary != null)
					msgs = ((InternalEObject)primary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ASSOCIATION__PRIMARY, null, msgs);
				return basicSetPrimary((AssociationEndPrimary)otherEnd, msgs);
			case ModelPackage.ASSOCIATION__SECONDARY:
				if (secondary != null)
					msgs = ((InternalEObject)secondary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.ASSOCIATION__SECONDARY, null, msgs);
				return basicSetSecondary((AssociationEndSecondary)otherEnd, msgs);
			case ModelPackage.ASSOCIATION__ASSOCIATION_CLASS:
				if (associationClass != null)
					msgs = ((InternalEObject)associationClass).eInverseRemove(this, ModelPackage.ASSOCIATION_CLASS__ASSOCIATION, AssociationClass.class, msgs);
				return basicSetAssociationClass((AssociationClass)otherEnd, msgs);
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
			case ModelPackage.ASSOCIATION__PRIMARY:
				return basicSetPrimary(null, msgs);
			case ModelPackage.ASSOCIATION__SECONDARY:
				return basicSetSecondary(null, msgs);
			case ModelPackage.ASSOCIATION__ASSOCIATION_CLASS:
				return basicSetAssociationClass(null, msgs);
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
			case ModelPackage.ASSOCIATION__NAME:
				return getName();
			case ModelPackage.ASSOCIATION__DESCRIPTION:
				return getDescription();
			case ModelPackage.ASSOCIATION__PRIMARY:
				return getPrimary();
			case ModelPackage.ASSOCIATION__SECONDARY:
				return getSecondary();
			case ModelPackage.ASSOCIATION__ASSOCIATION_CLASS:
				if (resolve) return getAssociationClass();
				return basicGetAssociationClass();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.ASSOCIATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.ASSOCIATION__PRIMARY:
				setPrimary((AssociationEndPrimary)newValue);
				return;
			case ModelPackage.ASSOCIATION__SECONDARY:
				setSecondary((AssociationEndSecondary)newValue);
				return;
			case ModelPackage.ASSOCIATION__ASSOCIATION_CLASS:
				setAssociationClass((AssociationClass)newValue);
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
			case ModelPackage.ASSOCIATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION__PRIMARY:
				setPrimary((AssociationEndPrimary)null);
				return;
			case ModelPackage.ASSOCIATION__SECONDARY:
				setSecondary((AssociationEndSecondary)null);
				return;
			case ModelPackage.ASSOCIATION__ASSOCIATION_CLASS:
				setAssociationClass((AssociationClass)null);
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
			case ModelPackage.ASSOCIATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.ASSOCIATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.ASSOCIATION__PRIMARY:
				return primary != null;
			case ModelPackage.ASSOCIATION__SECONDARY:
				return secondary != null;
			case ModelPackage.ASSOCIATION__ASSOCIATION_CLASS:
				return associationClass != null;
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
		result.append(')');
		return result.toString();
	}

} //AssociationImpl
