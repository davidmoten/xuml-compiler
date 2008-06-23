/**
 * <copyright>
 * </copyright>
 *
 * $Id: ObjectConstraintLanguageImpl.java,v 1.4 2008/06/11 07:28:46 dxm Exp $
 */
package model.impl;

import model.ModelPackage;
import model.ObjectConstraintLanguage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Constraint Language</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.ObjectConstraintLanguageImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.ObjectConstraintLanguageImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.ObjectConstraintLanguageImpl#getOcl <em>Ocl</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectConstraintLanguageImpl extends EObjectImpl implements ObjectConstraintLanguage {
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
	 * The default value of the '{@link #getOcl() <em>Ocl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOcl()
	 * @generated
	 * @ordered
	 */
	protected static final String OCL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOcl() <em>Ocl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOcl()
	 * @generated
	 * @ordered
	 */
	protected String ocl = OCL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectConstraintLanguageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.OBJECT_CONSTRAINT_LANGUAGE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOcl() {
		return ocl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOcl(String newOcl) {
		String oldOcl = ocl;
		ocl = newOcl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__OCL, oldOcl, ocl));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__NAME:
				return getName();
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__DESCRIPTION:
				return getDescription();
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__OCL:
				return getOcl();
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
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__OCL:
				setOcl((String)newValue);
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
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__OCL:
				setOcl(OCL_EDEFAULT);
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
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.OBJECT_CONSTRAINT_LANGUAGE__OCL:
				return OCL_EDEFAULT == null ? ocl != null : !OCL_EDEFAULT.equals(ocl);
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
		result.append(", ocl: ");
		result.append(ocl);
		result.append(')');
		return result.toString();
	}

} //ObjectConstraintLanguageImpl
