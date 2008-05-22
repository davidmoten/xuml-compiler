/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.activity.impl;

import model.activity.ActivityNode;
import model.activity.ActivityPackage;
import model.activity.Conditional;

import model.use.Condition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.activity.impl.ConditionalImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link model.activity.impl.ConditionalImpl#getNextNodeOnTrue <em>Next Node On True</em>}</li>
 *   <li>{@link model.activity.impl.ConditionalImpl#getNextNodeOnFalse <em>Next Node On False</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalImpl extends ActivityNodeImpl implements Conditional {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition condition;

	/**
	 * The cached value of the '{@link #getNextNodeOnTrue() <em>Next Node On True</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextNodeOnTrue()
	 * @generated
	 * @ordered
	 */
	protected ActivityNode nextNodeOnTrue;

	/**
	 * The cached value of the '{@link #getNextNodeOnFalse() <em>Next Node On False</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextNodeOnFalse()
	 * @generated
	 * @ordered
	 */
	protected ActivityNode nextNodeOnFalse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityPackage.Literals.CONDITIONAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getCondition() {
		if (condition != null && condition.eIsProxy()) {
			InternalEObject oldCondition = (InternalEObject)condition;
			condition = (Condition)eResolveProxy(oldCondition);
			if (condition != oldCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.CONDITIONAL__CONDITION, oldCondition, condition));
			}
		}
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Condition newCondition) {
		Condition oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.CONDITIONAL__CONDITION, oldCondition, condition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNode getNextNodeOnTrue() {
		if (nextNodeOnTrue != null && nextNodeOnTrue.eIsProxy()) {
			InternalEObject oldNextNodeOnTrue = (InternalEObject)nextNodeOnTrue;
			nextNodeOnTrue = (ActivityNode)eResolveProxy(oldNextNodeOnTrue);
			if (nextNodeOnTrue != oldNextNodeOnTrue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.CONDITIONAL__NEXT_NODE_ON_TRUE, oldNextNodeOnTrue, nextNodeOnTrue));
			}
		}
		return nextNodeOnTrue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNode basicGetNextNodeOnTrue() {
		return nextNodeOnTrue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextNodeOnTrue(ActivityNode newNextNodeOnTrue) {
		ActivityNode oldNextNodeOnTrue = nextNodeOnTrue;
		nextNodeOnTrue = newNextNodeOnTrue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.CONDITIONAL__NEXT_NODE_ON_TRUE, oldNextNodeOnTrue, nextNodeOnTrue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNode getNextNodeOnFalse() {
		if (nextNodeOnFalse != null && nextNodeOnFalse.eIsProxy()) {
			InternalEObject oldNextNodeOnFalse = (InternalEObject)nextNodeOnFalse;
			nextNodeOnFalse = (ActivityNode)eResolveProxy(oldNextNodeOnFalse);
			if (nextNodeOnFalse != oldNextNodeOnFalse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.CONDITIONAL__NEXT_NODE_ON_FALSE, oldNextNodeOnFalse, nextNodeOnFalse));
			}
		}
		return nextNodeOnFalse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNode basicGetNextNodeOnFalse() {
		return nextNodeOnFalse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextNodeOnFalse(ActivityNode newNextNodeOnFalse) {
		ActivityNode oldNextNodeOnFalse = nextNodeOnFalse;
		nextNodeOnFalse = newNextNodeOnFalse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.CONDITIONAL__NEXT_NODE_ON_FALSE, oldNextNodeOnFalse, nextNodeOnFalse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivityPackage.CONDITIONAL__CONDITION:
				if (resolve) return getCondition();
				return basicGetCondition();
			case ActivityPackage.CONDITIONAL__NEXT_NODE_ON_TRUE:
				if (resolve) return getNextNodeOnTrue();
				return basicGetNextNodeOnTrue();
			case ActivityPackage.CONDITIONAL__NEXT_NODE_ON_FALSE:
				if (resolve) return getNextNodeOnFalse();
				return basicGetNextNodeOnFalse();
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
			case ActivityPackage.CONDITIONAL__CONDITION:
				setCondition((Condition)newValue);
				return;
			case ActivityPackage.CONDITIONAL__NEXT_NODE_ON_TRUE:
				setNextNodeOnTrue((ActivityNode)newValue);
				return;
			case ActivityPackage.CONDITIONAL__NEXT_NODE_ON_FALSE:
				setNextNodeOnFalse((ActivityNode)newValue);
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
			case ActivityPackage.CONDITIONAL__CONDITION:
				setCondition((Condition)null);
				return;
			case ActivityPackage.CONDITIONAL__NEXT_NODE_ON_TRUE:
				setNextNodeOnTrue((ActivityNode)null);
				return;
			case ActivityPackage.CONDITIONAL__NEXT_NODE_ON_FALSE:
				setNextNodeOnFalse((ActivityNode)null);
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
			case ActivityPackage.CONDITIONAL__CONDITION:
				return condition != null;
			case ActivityPackage.CONDITIONAL__NEXT_NODE_ON_TRUE:
				return nextNodeOnTrue != null;
			case ActivityPackage.CONDITIONAL__NEXT_NODE_ON_FALSE:
				return nextNodeOnFalse != null;
		}
		return super.eIsSet(featureID);
	}

} //ConditionalImpl
