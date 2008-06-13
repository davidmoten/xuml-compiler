/**
 * <copyright>
 * </copyright>
 *
 * $Id: JoinImpl.java,v 1.4 2008/06/11 07:28:47 dxm Exp $
 */
package model.activity.impl;

import model.activity.ActivityNode;
import model.activity.ActivityPackage;
import model.activity.Join;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Join</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.activity.impl.JoinImpl#getNextNode <em>Next Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JoinImpl extends ActivityNodeImpl implements Join {
	/**
	 * The cached value of the '{@link #getNextNode() <em>Next Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextNode()
	 * @generated
	 * @ordered
	 */
	protected ActivityNode nextNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JoinImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityPackage.Literals.JOIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNode getNextNode() {
		if (nextNode != null && nextNode.eIsProxy()) {
			InternalEObject oldNextNode = (InternalEObject)nextNode;
			nextNode = (ActivityNode)eResolveProxy(oldNextNode);
			if (nextNode != oldNextNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.JOIN__NEXT_NODE, oldNextNode, nextNode));
			}
		}
		return nextNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityNode basicGetNextNode() {
		return nextNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNextNode(ActivityNode newNextNode) {
		ActivityNode oldNextNode = nextNode;
		nextNode = newNextNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.JOIN__NEXT_NODE, oldNextNode, nextNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivityPackage.JOIN__NEXT_NODE:
				if (resolve) return getNextNode();
				return basicGetNextNode();
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
			case ActivityPackage.JOIN__NEXT_NODE:
				setNextNode((ActivityNode)newValue);
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
			case ActivityPackage.JOIN__NEXT_NODE:
				setNextNode((ActivityNode)null);
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
			case ActivityPackage.JOIN__NEXT_NODE:
				return nextNode != null;
		}
		return super.eIsSet(featureID);
	}

} //JoinImpl
