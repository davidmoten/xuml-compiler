/**
 * <copyright>
 * </copyright>
 *
 * $Id: UnitTestImpl.java,v 1.2 2008/05/23 05:15:20 dxm Exp $
 */
package model.use.impl;

import java.util.Collection;

import model.use.ParameterData;
import model.use.UnitTest;
import model.use.UseCase;
import model.use.UsePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.use.impl.UnitTestImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.use.impl.UnitTestImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.use.impl.UnitTestImpl#getUseCase <em>Use Case</em>}</li>
 *   <li>{@link model.use.impl.UnitTestImpl#getParameterData <em>Parameter Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitTestImpl extends EObjectImpl implements UnitTest {
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
	 * The cached value of the '{@link #getUseCase() <em>Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCase()
	 * @generated
	 * @ordered
	 */
	protected UseCase useCase;

	/**
	 * The cached value of the '{@link #getParameterData() <em>Parameter Data</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterData()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterData> parameterData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitTestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsePackage.Literals.UNIT_TEST;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.UNIT_TEST__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.UNIT_TEST__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getUseCase() {
		if (useCase != null && useCase.eIsProxy()) {
			InternalEObject oldUseCase = (InternalEObject)useCase;
			useCase = (UseCase)eResolveProxy(oldUseCase);
			if (useCase != oldUseCase) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsePackage.UNIT_TEST__USE_CASE, oldUseCase, useCase));
			}
		}
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase basicGetUseCase() {
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUseCase(UseCase newUseCase) {
		UseCase oldUseCase = useCase;
		useCase = newUseCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.UNIT_TEST__USE_CASE, oldUseCase, useCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterData> getParameterData() {
		if (parameterData == null) {
			parameterData = new EObjectContainmentEList<ParameterData>(ParameterData.class, this, UsePackage.UNIT_TEST__PARAMETER_DATA);
		}
		return parameterData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UsePackage.UNIT_TEST__PARAMETER_DATA:
				return ((InternalEList<?>)getParameterData()).basicRemove(otherEnd, msgs);
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
			case UsePackage.UNIT_TEST__NAME:
				return getName();
			case UsePackage.UNIT_TEST__DESCRIPTION:
				return getDescription();
			case UsePackage.UNIT_TEST__USE_CASE:
				if (resolve) return getUseCase();
				return basicGetUseCase();
			case UsePackage.UNIT_TEST__PARAMETER_DATA:
				return getParameterData();
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
			case UsePackage.UNIT_TEST__NAME:
				setName((String)newValue);
				return;
			case UsePackage.UNIT_TEST__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case UsePackage.UNIT_TEST__USE_CASE:
				setUseCase((UseCase)newValue);
				return;
			case UsePackage.UNIT_TEST__PARAMETER_DATA:
				getParameterData().clear();
				getParameterData().addAll((Collection<? extends ParameterData>)newValue);
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
			case UsePackage.UNIT_TEST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UsePackage.UNIT_TEST__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case UsePackage.UNIT_TEST__USE_CASE:
				setUseCase((UseCase)null);
				return;
			case UsePackage.UNIT_TEST__PARAMETER_DATA:
				getParameterData().clear();
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
			case UsePackage.UNIT_TEST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UsePackage.UNIT_TEST__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case UsePackage.UNIT_TEST__USE_CASE:
				return useCase != null;
			case UsePackage.UNIT_TEST__PARAMETER_DATA:
				return parameterData != null && !parameterData.isEmpty();
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

} //UnitTestImpl
