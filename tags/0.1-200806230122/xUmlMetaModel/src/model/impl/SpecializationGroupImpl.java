/**
 * <copyright>
 * </copyright>
 *
 * $Id: SpecializationGroupImpl.java,v 1.3 2008/06/11 07:28:44 dxm Exp $
 */
package model.impl;

import java.util.Collection;

import model.ModelPackage;
import model.Specialization;
import model.SpecializationGroup;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specialization Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.SpecializationGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.SpecializationGroupImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.SpecializationGroupImpl#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link model.impl.SpecializationGroupImpl#getSpecialization <em>Specialization</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecializationGroupImpl extends EObjectImpl implements SpecializationGroup {
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
	 * The cached value of the '{@link #getSpecialization() <em>Specialization</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecialization()
	 * @generated
	 * @ordered
	 */
	protected EList<Specialization> specialization;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpecializationGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SPECIALIZATION_GROUP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SPECIALIZATION_GROUP__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SPECIALIZATION_GROUP__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Class getSuperClass() {
		if (eContainerFeatureID != ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS) return null;
		return (model.Class)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperClass(model.Class newSuperClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSuperClass, ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClass(model.Class newSuperClass) {
		if (newSuperClass != eInternalContainer() || (eContainerFeatureID != ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS && newSuperClass != null)) {
			if (EcoreUtil.isAncestor(this, newSuperClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSuperClass != null)
				msgs = ((InternalEObject)newSuperClass).eInverseAdd(this, ModelPackage.CLASS__SPECIALIZATION_GROUP, model.Class.class, msgs);
			msgs = basicSetSuperClass(newSuperClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS, newSuperClass, newSuperClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Specialization> getSpecialization() {
		if (specialization == null) {
			specialization = new EObjectWithInverseResolvingEList<Specialization>(Specialization.class, this, ModelPackage.SPECIALIZATION_GROUP__SPECIALIZATION, ModelPackage.SPECIALIZATION__GROUP);
		}
		return specialization;
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
			case ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSuperClass((model.Class)otherEnd, msgs);
			case ModelPackage.SPECIALIZATION_GROUP__SPECIALIZATION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecialization()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS:
				return basicSetSuperClass(null, msgs);
			case ModelPackage.SPECIALIZATION_GROUP__SPECIALIZATION:
				return ((InternalEList<?>)getSpecialization()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS:
				return eInternalContainer().eInverseRemove(this, ModelPackage.CLASS__SPECIALIZATION_GROUP, model.Class.class, msgs);
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
			case ModelPackage.SPECIALIZATION_GROUP__NAME:
				return getName();
			case ModelPackage.SPECIALIZATION_GROUP__DESCRIPTION:
				return getDescription();
			case ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS:
				return getSuperClass();
			case ModelPackage.SPECIALIZATION_GROUP__SPECIALIZATION:
				return getSpecialization();
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
			case ModelPackage.SPECIALIZATION_GROUP__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.SPECIALIZATION_GROUP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS:
				setSuperClass((model.Class)newValue);
				return;
			case ModelPackage.SPECIALIZATION_GROUP__SPECIALIZATION:
				getSpecialization().clear();
				getSpecialization().addAll((Collection<? extends Specialization>)newValue);
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
			case ModelPackage.SPECIALIZATION_GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.SPECIALIZATION_GROUP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS:
				setSuperClass((model.Class)null);
				return;
			case ModelPackage.SPECIALIZATION_GROUP__SPECIALIZATION:
				getSpecialization().clear();
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
			case ModelPackage.SPECIALIZATION_GROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.SPECIALIZATION_GROUP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS:
				return getSuperClass() != null;
			case ModelPackage.SPECIALIZATION_GROUP__SPECIALIZATION:
				return specialization != null && !specialization.isEmpty();
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

} //SpecializationGroupImpl
