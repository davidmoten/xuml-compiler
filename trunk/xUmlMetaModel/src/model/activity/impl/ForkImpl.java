/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.activity.impl;

import java.util.Collection;

import model.activity.ActivityNode;
import model.activity.ActivityPackage;
import model.activity.Fork;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Fork</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.activity.impl.ForkImpl#getNextNode <em>Next Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForkImpl extends ActivityNodeImpl implements Fork {
	/**
	 * The cached value of the '{@link #getNextNode() <em>Next Node</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNextNode()
	 * @generated
	 * @ordered
	 */
	protected EList<ActivityNode> nextNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForkImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityPackage.Literals.FORK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActivityNode> getNextNode() {
		if (nextNode == null) {
			nextNode = new EObjectResolvingEList<ActivityNode>(ActivityNode.class, this, ActivityPackage.FORK__NEXT_NODE);
		}
		return nextNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivityPackage.FORK__NEXT_NODE:
				return getNextNode();
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
			case ActivityPackage.FORK__NEXT_NODE:
				getNextNode().clear();
				getNextNode().addAll((Collection<? extends ActivityNode>)newValue);
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
			case ActivityPackage.FORK__NEXT_NODE:
				getNextNode().clear();
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
			case ActivityPackage.FORK__NEXT_NODE:
				return nextNode != null && !nextNode.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ForkImpl
