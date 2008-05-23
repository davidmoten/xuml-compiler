/**
 * <copyright>
 * </copyright>
 *
 * $Id: StateMachineImpl.java,v 1.2 2008/05/23 05:15:17 dxm Exp $
 */
package model.impl;

import java.util.Collection;

import model.Event;
import model.FinalState;
import model.InitialState;
import model.ModelPackage;
import model.State;
import model.StateMachine;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Machine</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.StateMachineImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.impl.StateMachineImpl#getInitialState <em>Initial State</em>}</li>
 *   <li>{@link model.impl.StateMachineImpl#getState <em>State</em>}</li>
 *   <li>{@link model.impl.StateMachineImpl#getFinalState <em>Final State</em>}</li>
 *   <li>{@link model.impl.StateMachineImpl#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateMachineImpl extends EObjectImpl implements StateMachine {
	/**
	 * The cached value of the '{@link #getInitialState() <em>Initial State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialState()
	 * @generated
	 * @ordered
	 */
	protected InitialState initialState;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected EList<State> state;

	/**
	 * The cached value of the '{@link #getFinalState() <em>Final State</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFinalState()
	 * @generated
	 * @ordered
	 */
	protected FinalState finalState;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> event;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateMachineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.STATE_MACHINE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Class getClass_() {
		if (eContainerFeatureID != ModelPackage.STATE_MACHINE__CLASS) return null;
		return (model.Class)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClass(model.Class newClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClass, ModelPackage.STATE_MACHINE__CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(model.Class newClass) {
		if (newClass != eInternalContainer() || (eContainerFeatureID != ModelPackage.STATE_MACHINE__CLASS && newClass != null)) {
			if (EcoreUtil.isAncestor(this, newClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newClass != null)
				msgs = ((InternalEObject)newClass).eInverseAdd(this, ModelPackage.CLASS__STATE_MACHINE, model.Class.class, msgs);
			msgs = basicSetClass(newClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STATE_MACHINE__CLASS, newClass, newClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitialState getInitialState() {
		return initialState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialState(InitialState newInitialState, NotificationChain msgs) {
		InitialState oldInitialState = initialState;
		initialState = newInitialState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.STATE_MACHINE__INITIAL_STATE, oldInitialState, newInitialState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialState(InitialState newInitialState) {
		if (newInitialState != initialState) {
			NotificationChain msgs = null;
			if (initialState != null)
				msgs = ((InternalEObject)initialState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.STATE_MACHINE__INITIAL_STATE, null, msgs);
			if (newInitialState != null)
				msgs = ((InternalEObject)newInitialState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.STATE_MACHINE__INITIAL_STATE, null, msgs);
			msgs = basicSetInitialState(newInitialState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STATE_MACHINE__INITIAL_STATE, newInitialState, newInitialState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<State> getState() {
		if (state == null) {
			state = new EObjectContainmentEList<State>(State.class, this, ModelPackage.STATE_MACHINE__STATE);
		}
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalState getFinalState() {
		return finalState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFinalState(FinalState newFinalState, NotificationChain msgs) {
		FinalState oldFinalState = finalState;
		finalState = newFinalState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.STATE_MACHINE__FINAL_STATE, oldFinalState, newFinalState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFinalState(FinalState newFinalState) {
		if (newFinalState != finalState) {
			NotificationChain msgs = null;
			if (finalState != null)
				msgs = ((InternalEObject)finalState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.STATE_MACHINE__FINAL_STATE, null, msgs);
			if (newFinalState != null)
				msgs = ((InternalEObject)newFinalState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.STATE_MACHINE__FINAL_STATE, null, msgs);
			msgs = basicSetFinalState(newFinalState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.STATE_MACHINE__FINAL_STATE, newFinalState, newFinalState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvent() {
		if (event == null) {
			event = new EObjectContainmentEList<Event>(Event.class, this, ModelPackage.STATE_MACHINE__EVENT);
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.STATE_MACHINE__CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetClass((model.Class)otherEnd, msgs);
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
			case ModelPackage.STATE_MACHINE__CLASS:
				return basicSetClass(null, msgs);
			case ModelPackage.STATE_MACHINE__INITIAL_STATE:
				return basicSetInitialState(null, msgs);
			case ModelPackage.STATE_MACHINE__STATE:
				return ((InternalEList<?>)getState()).basicRemove(otherEnd, msgs);
			case ModelPackage.STATE_MACHINE__FINAL_STATE:
				return basicSetFinalState(null, msgs);
			case ModelPackage.STATE_MACHINE__EVENT:
				return ((InternalEList<?>)getEvent()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.STATE_MACHINE__CLASS:
				return eInternalContainer().eInverseRemove(this, ModelPackage.CLASS__STATE_MACHINE, model.Class.class, msgs);
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
			case ModelPackage.STATE_MACHINE__CLASS:
				return getClass_();
			case ModelPackage.STATE_MACHINE__INITIAL_STATE:
				return getInitialState();
			case ModelPackage.STATE_MACHINE__STATE:
				return getState();
			case ModelPackage.STATE_MACHINE__FINAL_STATE:
				return getFinalState();
			case ModelPackage.STATE_MACHINE__EVENT:
				return getEvent();
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
			case ModelPackage.STATE_MACHINE__CLASS:
				setClass((model.Class)newValue);
				return;
			case ModelPackage.STATE_MACHINE__INITIAL_STATE:
				setInitialState((InitialState)newValue);
				return;
			case ModelPackage.STATE_MACHINE__STATE:
				getState().clear();
				getState().addAll((Collection<? extends State>)newValue);
				return;
			case ModelPackage.STATE_MACHINE__FINAL_STATE:
				setFinalState((FinalState)newValue);
				return;
			case ModelPackage.STATE_MACHINE__EVENT:
				getEvent().clear();
				getEvent().addAll((Collection<? extends Event>)newValue);
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
			case ModelPackage.STATE_MACHINE__CLASS:
				setClass((model.Class)null);
				return;
			case ModelPackage.STATE_MACHINE__INITIAL_STATE:
				setInitialState((InitialState)null);
				return;
			case ModelPackage.STATE_MACHINE__STATE:
				getState().clear();
				return;
			case ModelPackage.STATE_MACHINE__FINAL_STATE:
				setFinalState((FinalState)null);
				return;
			case ModelPackage.STATE_MACHINE__EVENT:
				getEvent().clear();
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
			case ModelPackage.STATE_MACHINE__CLASS:
				return getClass_() != null;
			case ModelPackage.STATE_MACHINE__INITIAL_STATE:
				return initialState != null;
			case ModelPackage.STATE_MACHINE__STATE:
				return state != null && !state.isEmpty();
			case ModelPackage.STATE_MACHINE__FINAL_STATE:
				return finalState != null;
			case ModelPackage.STATE_MACHINE__EVENT:
				return event != null && !event.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StateMachineImpl
