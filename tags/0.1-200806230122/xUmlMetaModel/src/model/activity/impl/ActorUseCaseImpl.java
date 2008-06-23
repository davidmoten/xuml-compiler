/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActorUseCaseImpl.java,v 1.4 2008/06/11 07:28:47 dxm Exp $
 */
package model.activity.impl;

import model.activity.Activity;
import model.activity.ActivityNode;
import model.activity.ActivityPackage;
import model.activity.ActorUseCase;

import model.use.Actor;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.activity.impl.ActorUseCaseImpl#getActor <em>Actor</em>}</li>
 *   <li>{@link model.activity.impl.ActorUseCaseImpl#getActivity <em>Activity</em>}</li>
 *   <li>{@link model.activity.impl.ActorUseCaseImpl#getNextNode <em>Next Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ActorUseCaseImpl extends ActivityNodeImpl implements ActorUseCase {
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
	protected ActorUseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivityPackage.Literals.ACTOR_USE_CASE;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.ACTOR_USE_CASE__ACTOR, oldActor, actor));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.ACTOR_USE_CASE__ACTOR, oldActor, actor));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.ACTOR_USE_CASE__ACTIVITY, oldActivity, activity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.ACTOR_USE_CASE__ACTIVITY, oldActivity, activity));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivityPackage.ACTOR_USE_CASE__NEXT_NODE, oldNextNode, nextNode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActivityPackage.ACTOR_USE_CASE__NEXT_NODE, oldNextNode, nextNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActivityPackage.ACTOR_USE_CASE__ACTOR:
				if (resolve) return getActor();
				return basicGetActor();
			case ActivityPackage.ACTOR_USE_CASE__ACTIVITY:
				if (resolve) return getActivity();
				return basicGetActivity();
			case ActivityPackage.ACTOR_USE_CASE__NEXT_NODE:
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
			case ActivityPackage.ACTOR_USE_CASE__ACTOR:
				setActor((Actor)newValue);
				return;
			case ActivityPackage.ACTOR_USE_CASE__ACTIVITY:
				setActivity((Activity)newValue);
				return;
			case ActivityPackage.ACTOR_USE_CASE__NEXT_NODE:
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
			case ActivityPackage.ACTOR_USE_CASE__ACTOR:
				setActor((Actor)null);
				return;
			case ActivityPackage.ACTOR_USE_CASE__ACTIVITY:
				setActivity((Activity)null);
				return;
			case ActivityPackage.ACTOR_USE_CASE__NEXT_NODE:
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
			case ActivityPackage.ACTOR_USE_CASE__ACTOR:
				return actor != null;
			case ActivityPackage.ACTOR_USE_CASE__ACTIVITY:
				return activity != null;
			case ActivityPackage.ACTOR_USE_CASE__NEXT_NODE:
				return nextNode != null;
		}
		return super.eIsSet(featureID);
	}

} //ActorUseCaseImpl
