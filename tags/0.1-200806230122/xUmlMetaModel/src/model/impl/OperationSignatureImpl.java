/**
 * <copyright>
 * </copyright>
 *
 * $Id: OperationSignatureImpl.java,v 1.4 2008/06/11 07:28:43 dxm Exp $
 */
package model.impl;

import java.util.Collection;

import model.ModelPackage;
import model.OperationSignature;
import model.Parameter;
import model.Type;

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
 * An implementation of the model object '<em><b>Operation Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.OperationSignatureImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.OperationSignatureImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.OperationSignatureImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link model.impl.OperationSignatureImpl#getReturns <em>Returns</em>}</li>
 *   <li>{@link model.impl.OperationSignatureImpl#isReturnsMultiple <em>Returns Multiple</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationSignatureImpl extends EObjectImpl implements OperationSignature {
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
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameter;

	/**
	 * The cached value of the '{@link #getReturns() <em>Returns</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturns()
	 * @generated
	 * @ordered
	 */
	protected Type returns;

	/**
	 * The default value of the '{@link #isReturnsMultiple() <em>Returns Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReturnsMultiple()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RETURNS_MULTIPLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReturnsMultiple() <em>Returns Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReturnsMultiple()
	 * @generated
	 * @ordered
	 */
	protected boolean returnsMultiple = RETURNS_MULTIPLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationSignatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.OPERATION_SIGNATURE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_SIGNATURE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_SIGNATURE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, ModelPackage.OPERATION_SIGNATURE__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getReturns() {
		if (returns != null && returns.eIsProxy()) {
			InternalEObject oldReturns = (InternalEObject)returns;
			returns = (Type)eResolveProxy(oldReturns);
			if (returns != oldReturns) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.OPERATION_SIGNATURE__RETURNS, oldReturns, returns));
			}
		}
		return returns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetReturns() {
		return returns;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturns(Type newReturns) {
		Type oldReturns = returns;
		returns = newReturns;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_SIGNATURE__RETURNS, oldReturns, returns));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReturnsMultiple() {
		return returnsMultiple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnsMultiple(boolean newReturnsMultiple) {
		boolean oldReturnsMultiple = returnsMultiple;
		returnsMultiple = newReturnsMultiple;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.OPERATION_SIGNATURE__RETURNS_MULTIPLE, oldReturnsMultiple, returnsMultiple));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.OPERATION_SIGNATURE__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.OPERATION_SIGNATURE__NAME:
				return getName();
			case ModelPackage.OPERATION_SIGNATURE__DESCRIPTION:
				return getDescription();
			case ModelPackage.OPERATION_SIGNATURE__PARAMETER:
				return getParameter();
			case ModelPackage.OPERATION_SIGNATURE__RETURNS:
				if (resolve) return getReturns();
				return basicGetReturns();
			case ModelPackage.OPERATION_SIGNATURE__RETURNS_MULTIPLE:
				return isReturnsMultiple() ? Boolean.TRUE : Boolean.FALSE;
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
			case ModelPackage.OPERATION_SIGNATURE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.OPERATION_SIGNATURE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.OPERATION_SIGNATURE__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case ModelPackage.OPERATION_SIGNATURE__RETURNS:
				setReturns((Type)newValue);
				return;
			case ModelPackage.OPERATION_SIGNATURE__RETURNS_MULTIPLE:
				setReturnsMultiple(((Boolean)newValue).booleanValue());
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
			case ModelPackage.OPERATION_SIGNATURE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.OPERATION_SIGNATURE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.OPERATION_SIGNATURE__PARAMETER:
				getParameter().clear();
				return;
			case ModelPackage.OPERATION_SIGNATURE__RETURNS:
				setReturns((Type)null);
				return;
			case ModelPackage.OPERATION_SIGNATURE__RETURNS_MULTIPLE:
				setReturnsMultiple(RETURNS_MULTIPLE_EDEFAULT);
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
			case ModelPackage.OPERATION_SIGNATURE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.OPERATION_SIGNATURE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.OPERATION_SIGNATURE__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case ModelPackage.OPERATION_SIGNATURE__RETURNS:
				return returns != null;
			case ModelPackage.OPERATION_SIGNATURE__RETURNS_MULTIPLE:
				return returnsMultiple != RETURNS_MULTIPLE_EDEFAULT;
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
		result.append(", returnsMultiple: ");
		result.append(returnsMultiple);
		result.append(')');
		return result.toString();
	}

} //OperationSignatureImpl
