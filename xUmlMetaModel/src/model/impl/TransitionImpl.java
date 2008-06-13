/**
 * <copyright>
 * </copyright>
 *
 * $Id: TransitionImpl.java,v 1.4 2008/06/11 07:28:45 dxm Exp $
 */
package model.impl;

import model.Event;
import model.FromState;
import model.ModelPackage;
import model.ToState;
import model.Transition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.TransitionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.TransitionImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link model.impl.TransitionImpl#getFromState <em>From State</em>}</li>
 *   <li>{@link model.impl.TransitionImpl#getToState <em>To State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransitionImpl extends EObjectImpl implements Transition {
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
	 * The cached value of the '{@link #getFromState() <em>From State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromState()
	 * @generated
	 * @ordered
	 */
	protected FromState fromState;

	/**
	 * The cached value of the '{@link #getToState() <em>To State</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToState()
	 * @generated
	 * @ordered
	 */
	protected ToState toState;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TRANSITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Event getEvent() {
		if (eContainerFeatureID != ModelPackage.TRANSITION__EVENT) return null;
		return (Event)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEvent(Event newEvent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newEvent, ModelPackage.TRANSITION__EVENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvent(Event newEvent) {
		if (newEvent != eInternalContainer() || (eContainerFeatureID != ModelPackage.TRANSITION__EVENT && newEvent != null)) {
			if (EcoreUtil.isAncestor(this, newEvent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newEvent != null)
				msgs = ((InternalEObject)newEvent).eInverseAdd(this, ModelPackage.EVENT__TRANSITION, Event.class, msgs);
			msgs = basicSetEvent(newEvent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION__EVENT, newEvent, newEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromState getFromState() {
		if (fromState != null && fromState.eIsProxy()) {
			InternalEObject oldFromState = (InternalEObject)fromState;
			fromState = (FromState)eResolveProxy(oldFromState);
			if (fromState != oldFromState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.TRANSITION__FROM_STATE, oldFromState, fromState));
			}
		}
		return fromState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FromState basicGetFromState() {
		return fromState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFromState(FromState newFromState, NotificationChain msgs) {
		FromState oldFromState = fromState;
		fromState = newFromState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION__FROM_STATE, oldFromState, newFromState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromState(FromState newFromState) {
		if (newFromState != fromState) {
			NotificationChain msgs = null;
			if (fromState != null)
				msgs = ((InternalEObject)fromState).eInverseRemove(this, ModelPackage.FROM_STATE__TRANSITION_TO, FromState.class, msgs);
			if (newFromState != null)
				msgs = ((InternalEObject)newFromState).eInverseAdd(this, ModelPackage.FROM_STATE__TRANSITION_TO, FromState.class, msgs);
			msgs = basicSetFromState(newFromState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION__FROM_STATE, newFromState, newFromState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToState getToState() {
		if (toState != null && toState.eIsProxy()) {
			InternalEObject oldToState = (InternalEObject)toState;
			toState = (ToState)eResolveProxy(oldToState);
			if (toState != oldToState) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.TRANSITION__TO_STATE, oldToState, toState));
			}
		}
		return toState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ToState basicGetToState() {
		return toState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetToState(ToState newToState, NotificationChain msgs) {
		ToState oldToState = toState;
		toState = newToState;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION__TO_STATE, oldToState, newToState);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToState(ToState newToState) {
		if (newToState != toState) {
			NotificationChain msgs = null;
			if (toState != null)
				msgs = ((InternalEObject)toState).eInverseRemove(this, ModelPackage.TO_STATE__TRANSITION_FROM, ToState.class, msgs);
			if (newToState != null)
				msgs = ((InternalEObject)newToState).eInverseAdd(this, ModelPackage.TO_STATE__TRANSITION_FROM, ToState.class, msgs);
			msgs = basicSetToState(newToState, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TRANSITION__TO_STATE, newToState, newToState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.TRANSITION__EVENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetEvent((Event)otherEnd, msgs);
			case ModelPackage.TRANSITION__FROM_STATE:
				if (fromState != null)
					msgs = ((InternalEObject)fromState).eInverseRemove(this, ModelPackage.FROM_STATE__TRANSITION_TO, FromState.class, msgs);
				return basicSetFromState((FromState)otherEnd, msgs);
			case ModelPackage.TRANSITION__TO_STATE:
				if (toState != null)
					msgs = ((InternalEObject)toState).eInverseRemove(this, ModelPackage.TO_STATE__TRANSITION_FROM, ToState.class, msgs);
				return basicSetToState((ToState)otherEnd, msgs);
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
			case ModelPackage.TRANSITION__EVENT:
				return basicSetEvent(null, msgs);
			case ModelPackage.TRANSITION__FROM_STATE:
				return basicSetFromState(null, msgs);
			case ModelPackage.TRANSITION__TO_STATE:
				return basicSetToState(null, msgs);
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
			case ModelPackage.TRANSITION__EVENT:
				return eInternalContainer().eInverseRemove(this, ModelPackage.EVENT__TRANSITION, Event.class, msgs);
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
			case ModelPackage.TRANSITION__NAME:
				return getName();
			case ModelPackage.TRANSITION__DESCRIPTION:
				return getDescription();
			case ModelPackage.TRANSITION__EVENT:
				return getEvent();
			case ModelPackage.TRANSITION__FROM_STATE:
				if (resolve) return getFromState();
				return basicGetFromState();
			case ModelPackage.TRANSITION__TO_STATE:
				if (resolve) return getToState();
				return basicGetToState();
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
			case ModelPackage.TRANSITION__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.TRANSITION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.TRANSITION__EVENT:
				setEvent((Event)newValue);
				return;
			case ModelPackage.TRANSITION__FROM_STATE:
				setFromState((FromState)newValue);
				return;
			case ModelPackage.TRANSITION__TO_STATE:
				setToState((ToState)newValue);
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
			case ModelPackage.TRANSITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.TRANSITION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.TRANSITION__EVENT:
				setEvent((Event)null);
				return;
			case ModelPackage.TRANSITION__FROM_STATE:
				setFromState((FromState)null);
				return;
			case ModelPackage.TRANSITION__TO_STATE:
				setToState((ToState)null);
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
			case ModelPackage.TRANSITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.TRANSITION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.TRANSITION__EVENT:
				return getEvent() != null;
			case ModelPackage.TRANSITION__FROM_STATE:
				return fromState != null;
			case ModelPackage.TRANSITION__TO_STATE:
				return toState != null;
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

} //TransitionImpl
