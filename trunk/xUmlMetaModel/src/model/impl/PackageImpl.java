/**
 * <copyright>
 * </copyright>
 *
 * $Id: PackageImpl.java,v 1.4 2008/06/11 07:28:44 dxm Exp $
 */
package model.impl;

import java.util.Collection;

import model.DataType;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.PackageImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.PackageImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.PackageImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.impl.PackageImpl#getSubPackage <em>Sub Package</em>}</li>
 *   <li>{@link model.impl.PackageImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link model.impl.PackageImpl#getDataType <em>Data Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageImpl extends EObjectImpl implements model.Package {
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
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected EList<model.Class> class_;

	/**
	 * The cached value of the '{@link #getSubPackage() <em>Sub Package</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<model.Package> subPackage;

	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> dataType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PACKAGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PACKAGE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PACKAGE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<model.Class> getClass_() {
		if (class_ == null) {
			class_ = new EObjectContainmentWithInverseEList<model.Class>(model.Class.class, this, ModelPackage.PACKAGE__CLASS, ModelPackage.CLASS__PACKAGE);
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<model.Package> getSubPackage() {
		if (subPackage == null) {
			subPackage = new EObjectContainmentWithInverseEList<model.Package>(model.Package.class, this, ModelPackage.PACKAGE__SUB_PACKAGE, ModelPackage.PACKAGE__PARENT);
		}
		return subPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Package getParent() {
		if (eContainerFeatureID != ModelPackage.PACKAGE__PARENT) return null;
		return (model.Package)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(model.Package newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, ModelPackage.PACKAGE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(model.Package newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID != ModelPackage.PACKAGE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, ModelPackage.PACKAGE__SUB_PACKAGE, model.Package.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PACKAGE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getDataType() {
		if (dataType == null) {
			dataType = new EObjectContainmentWithInverseEList<DataType>(DataType.class, this, ModelPackage.PACKAGE__DATA_TYPE, ModelPackage.DATA_TYPE__PACKAGE);
		}
		return dataType;
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
			case ModelPackage.PACKAGE__CLASS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClass_()).basicAdd(otherEnd, msgs);
			case ModelPackage.PACKAGE__SUB_PACKAGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubPackage()).basicAdd(otherEnd, msgs);
			case ModelPackage.PACKAGE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((model.Package)otherEnd, msgs);
			case ModelPackage.PACKAGE__DATA_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDataType()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.PACKAGE__CLASS:
				return ((InternalEList<?>)getClass_()).basicRemove(otherEnd, msgs);
			case ModelPackage.PACKAGE__SUB_PACKAGE:
				return ((InternalEList<?>)getSubPackage()).basicRemove(otherEnd, msgs);
			case ModelPackage.PACKAGE__PARENT:
				return basicSetParent(null, msgs);
			case ModelPackage.PACKAGE__DATA_TYPE:
				return ((InternalEList<?>)getDataType()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.PACKAGE__PARENT:
				return eInternalContainer().eInverseRemove(this, ModelPackage.PACKAGE__SUB_PACKAGE, model.Package.class, msgs);
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
			case ModelPackage.PACKAGE__NAME:
				return getName();
			case ModelPackage.PACKAGE__DESCRIPTION:
				return getDescription();
			case ModelPackage.PACKAGE__CLASS:
				return getClass_();
			case ModelPackage.PACKAGE__SUB_PACKAGE:
				return getSubPackage();
			case ModelPackage.PACKAGE__PARENT:
				return getParent();
			case ModelPackage.PACKAGE__DATA_TYPE:
				return getDataType();
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
			case ModelPackage.PACKAGE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.PACKAGE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.PACKAGE__CLASS:
				getClass_().clear();
				getClass_().addAll((Collection<? extends model.Class>)newValue);
				return;
			case ModelPackage.PACKAGE__SUB_PACKAGE:
				getSubPackage().clear();
				getSubPackage().addAll((Collection<? extends model.Package>)newValue);
				return;
			case ModelPackage.PACKAGE__PARENT:
				setParent((model.Package)newValue);
				return;
			case ModelPackage.PACKAGE__DATA_TYPE:
				getDataType().clear();
				getDataType().addAll((Collection<? extends DataType>)newValue);
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
			case ModelPackage.PACKAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.PACKAGE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.PACKAGE__CLASS:
				getClass_().clear();
				return;
			case ModelPackage.PACKAGE__SUB_PACKAGE:
				getSubPackage().clear();
				return;
			case ModelPackage.PACKAGE__PARENT:
				setParent((model.Package)null);
				return;
			case ModelPackage.PACKAGE__DATA_TYPE:
				getDataType().clear();
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
			case ModelPackage.PACKAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.PACKAGE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.PACKAGE__CLASS:
				return class_ != null && !class_.isEmpty();
			case ModelPackage.PACKAGE__SUB_PACKAGE:
				return subPackage != null && !subPackage.isEmpty();
			case ModelPackage.PACKAGE__PARENT:
				return getParent() != null;
			case ModelPackage.PACKAGE__DATA_TYPE:
				return dataType != null && !dataType.isEmpty();
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

} //PackageImpl
