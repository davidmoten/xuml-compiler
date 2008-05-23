/**
 * <copyright>
 * </copyright>
 *
 * $Id: UseCaseImpl.java,v 1.2 2008/05/23 05:15:20 dxm Exp $
 */
package model.use.impl;

import java.util.Collection;

import model.activity.Activity;

import model.use.Actor;
import model.use.Condition;
import model.use.UseCase;
import model.use.UsePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.use.impl.UseCaseImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link model.use.impl.UseCaseImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link model.use.impl.UseCaseImpl#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link model.use.impl.UseCaseImpl#getPostcondition <em>Postcondition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UseCaseImpl extends EObjectImpl implements UseCase {
	/**
	 * The cached value of the '{@link #getActor() <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActor()
	 * @generated
	 * @ordered
	 */
	protected Actor actor;

	/**
	 * The cached value of the '{@link #getActivity() <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivity()
	 * @generated
	 * @ordered
	 */
	protected Activity activity;

	/**
	 * The cached value of the '{@link #getPrecondition() <em>Precondition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecondition()
	 * @generated
	 * @ordered
	 */
	protected EList<Condition> precondition;

	/**
	 * The cached value of the '{@link #getPostcondition() <em>Postcondition</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostcondition()
	 * @generated
	 * @ordered
	 */
	protected EList<Condition> postcondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsePackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor getActor() {
		if (actor != null && actor.eIsProxy()) {
			InternalEObject oldActor = (InternalEObject)actor;
			actor = (Actor)eResolveProxy(oldActor);
			if (actor != oldActor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsePackage.USE_CASE__ACTOR, oldActor, actor));
			}
		}
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor basicGetActor() {
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActor(Actor newActor) {
		Actor oldActor = actor;
		actor = newActor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.USE_CASE__ACTOR, oldActor, actor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity getActivity() {
		if (activity != null && activity.eIsProxy()) {
			InternalEObject oldActivity = (InternalEObject)activity;
			activity = (Activity)eResolveProxy(oldActivity);
			if (activity != oldActivity) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsePackage.USE_CASE__ACTIVITY, oldActivity, activity));
			}
		}
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Activity basicGetActivity() {
		return activity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActivity(Activity newActivity) {
		Activity oldActivity = activity;
		activity = newActivity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UsePackage.USE_CASE__ACTIVITY, oldActivity, activity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Condition> getPrecondition() {
		if (precondition == null) {
			precondition = new EObjectResolvingEList<Condition>(Condition.class, this, UsePackage.USE_CASE__PRECONDITION);
		}
		return precondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Condition> getPostcondition() {
		if (postcondition == null) {
			postcondition = new EObjectResolvingEList<Condition>(Condition.class, this, UsePackage.USE_CASE__POSTCONDITION);
		}
		return postcondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UsePackage.USE_CASE__ACTOR:
				if (resolve) return getActor();
				return basicGetActor();
			case UsePackage.USE_CASE__ACTIVITY:
				if (resolve) return getActivity();
				return basicGetActivity();
			case UsePackage.USE_CASE__PRECONDITION:
				return getPrecondition();
			case UsePackage.USE_CASE__POSTCONDITION:
				return getPostcondition();
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
			case UsePackage.USE_CASE__ACTOR:
				setActor((Actor)newValue);
				return;
			case UsePackage.USE_CASE__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case UsePackage.USE_CASE__PRECONDITION:
				getPrecondition().clear();
				getPrecondition().addAll((Collection<? extends Condition>)newValue);
				return;
			case UsePackage.USE_CASE__POSTCONDITION:
				getPostcondition().clear();
				getPostcondition().addAll((Collection<? extends Condition>)newValue);
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
			case UsePackage.USE_CASE__ACTOR:
				setActor((Actor)null);
				return;
			case UsePackage.USE_CASE__ACTIVITY:
				setActivity((Activity)null);
				return;
			case UsePackage.USE_CASE__PRECONDITION:
				getPrecondition().clear();
				return;
			case UsePackage.USE_CASE__POSTCONDITION:
				getPostcondition().clear();
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
			case UsePackage.USE_CASE__ACTOR:
				return actor != null;
			case UsePackage.USE_CASE__ACTIVITY:
				return activity != null;
			case UsePackage.USE_CASE__PRECONDITION:
				return precondition != null && !precondition.isEmpty();
			case UsePackage.USE_CASE__POSTCONDITION:
				return postcondition != null && !postcondition.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UseCaseImpl
