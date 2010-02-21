/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import java.util.Collection;

import model.AssociationEndPersistence;
import model.Attribute;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End Persistence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.AssociationEndPersistenceImpl#isLazyFetch <em>Lazy Fetch</em>}</li>
 *   <li>{@link model.impl.AssociationEndPersistenceImpl#getOrderBy <em>Order By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationEndPersistenceImpl extends EObjectImpl implements AssociationEndPersistence {
	/**
	 * The default value of the '{@link #isLazyFetch() <em>Lazy Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLazyFetch()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LAZY_FETCH_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isLazyFetch() <em>Lazy Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLazyFetch()
	 * @generated
	 * @ordered
	 */
	protected boolean lazyFetch = LAZY_FETCH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOrderBy() <em>Order By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrderBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> orderBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationEndPersistenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ASSOCIATION_END_PERSISTENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isLazyFetch() {
		return lazyFetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLazyFetch(boolean newLazyFetch) {
		boolean oldLazyFetch = lazyFetch;
		lazyFetch = newLazyFetch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END_PERSISTENCE__LAZY_FETCH, oldLazyFetch, lazyFetch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getOrderBy() {
		if (orderBy == null) {
			orderBy = new EObjectResolvingEList<Attribute>(Attribute.class, this, ModelPackage.ASSOCIATION_END_PERSISTENCE__ORDER_BY);
		}
		return orderBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION_END_PERSISTENCE__LAZY_FETCH:
				return isLazyFetch() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ASSOCIATION_END_PERSISTENCE__ORDER_BY:
				return getOrderBy();
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
			case ModelPackage.ASSOCIATION_END_PERSISTENCE__LAZY_FETCH:
				setLazyFetch(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ASSOCIATION_END_PERSISTENCE__ORDER_BY:
				getOrderBy().clear();
				getOrderBy().addAll((Collection<? extends Attribute>)newValue);
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
			case ModelPackage.ASSOCIATION_END_PERSISTENCE__LAZY_FETCH:
				setLazyFetch(LAZY_FETCH_EDEFAULT);
				return;
			case ModelPackage.ASSOCIATION_END_PERSISTENCE__ORDER_BY:
				getOrderBy().clear();
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
			case ModelPackage.ASSOCIATION_END_PERSISTENCE__LAZY_FETCH:
				return lazyFetch != LAZY_FETCH_EDEFAULT;
			case ModelPackage.ASSOCIATION_END_PERSISTENCE__ORDER_BY:
				return orderBy != null && !orderBy.isEmpty();
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
		result.append(" (lazyFetch: ");
		result.append(lazyFetch);
		result.append(')');
		return result.toString();
	}

} //AssociationEndPersistenceImpl
