/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.collaboration.impl;

import model.SignalEvent;

import model.collaboration.CollaborationPackage;
import model.collaboration.Collaborator;
import model.collaboration.Communication;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Communication</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.collaboration.impl.CommunicationImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.collaboration.impl.CommunicationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.collaboration.impl.CommunicationImpl#getFromCollaborator <em>From Collaborator</em>}</li>
 *   <li>{@link model.collaboration.impl.CommunicationImpl#getToCollaborator <em>To Collaborator</em>}</li>
 *   <li>{@link model.collaboration.impl.CommunicationImpl#getSignalEvent <em>Signal Event</em>}</li>
 *   <li>{@link model.collaboration.impl.CommunicationImpl#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CommunicationImpl extends EObjectImpl implements Communication {
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
	 * The cached value of the '{@link #getFromCollaborator() <em>From Collaborator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromCollaborator()
	 * @generated
	 * @ordered
	 */
	protected Collaborator fromCollaborator;

	/**
	 * The cached value of the '{@link #getToCollaborator() <em>To Collaborator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToCollaborator()
	 * @generated
	 * @ordered
	 */
	protected Collaborator toCollaborator;

	/**
	 * The cached value of the '{@link #getSignalEvent() <em>Signal Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSignalEvent()
	 * @generated
	 * @ordered
	 */
	protected SignalEvent signalEvent;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final int ORDER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected int order = ORDER_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CommunicationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CollaborationPackage.Literals.COMMUNICATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CollaborationPackage.COMMUNICATION__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, CollaborationPackage.COMMUNICATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaborator getFromCollaborator() {
		if (fromCollaborator != null && fromCollaborator.eIsProxy()) {
			InternalEObject oldFromCollaborator = (InternalEObject)fromCollaborator;
			fromCollaborator = (Collaborator)eResolveProxy(oldFromCollaborator);
			if (fromCollaborator != oldFromCollaborator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CollaborationPackage.COMMUNICATION__FROM_COLLABORATOR, oldFromCollaborator, fromCollaborator));
			}
		}
		return fromCollaborator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaborator basicGetFromCollaborator() {
		return fromCollaborator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromCollaborator(Collaborator newFromCollaborator) {
		Collaborator oldFromCollaborator = fromCollaborator;
		fromCollaborator = newFromCollaborator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CollaborationPackage.COMMUNICATION__FROM_COLLABORATOR, oldFromCollaborator, fromCollaborator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaborator getToCollaborator() {
		if (toCollaborator != null && toCollaborator.eIsProxy()) {
			InternalEObject oldToCollaborator = (InternalEObject)toCollaborator;
			toCollaborator = (Collaborator)eResolveProxy(oldToCollaborator);
			if (toCollaborator != oldToCollaborator) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CollaborationPackage.COMMUNICATION__TO_COLLABORATOR, oldToCollaborator, toCollaborator));
			}
		}
		return toCollaborator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaborator basicGetToCollaborator() {
		return toCollaborator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToCollaborator(Collaborator newToCollaborator) {
		Collaborator oldToCollaborator = toCollaborator;
		toCollaborator = newToCollaborator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CollaborationPackage.COMMUNICATION__TO_COLLABORATOR, oldToCollaborator, toCollaborator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalEvent getSignalEvent() {
		if (signalEvent != null && signalEvent.eIsProxy()) {
			InternalEObject oldSignalEvent = (InternalEObject)signalEvent;
			signalEvent = (SignalEvent)eResolveProxy(oldSignalEvent);
			if (signalEvent != oldSignalEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CollaborationPackage.COMMUNICATION__SIGNAL_EVENT, oldSignalEvent, signalEvent));
			}
		}
		return signalEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalEvent basicGetSignalEvent() {
		return signalEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSignalEvent(SignalEvent newSignalEvent) {
		SignalEvent oldSignalEvent = signalEvent;
		signalEvent = newSignalEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CollaborationPackage.COMMUNICATION__SIGNAL_EVENT, oldSignalEvent, signalEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(int newOrder) {
		int oldOrder = order;
		order = newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CollaborationPackage.COMMUNICATION__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CollaborationPackage.COMMUNICATION__NAME:
				return getName();
			case CollaborationPackage.COMMUNICATION__DESCRIPTION:
				return getDescription();
			case CollaborationPackage.COMMUNICATION__FROM_COLLABORATOR:
				if (resolve) return getFromCollaborator();
				return basicGetFromCollaborator();
			case CollaborationPackage.COMMUNICATION__TO_COLLABORATOR:
				if (resolve) return getToCollaborator();
				return basicGetToCollaborator();
			case CollaborationPackage.COMMUNICATION__SIGNAL_EVENT:
				if (resolve) return getSignalEvent();
				return basicGetSignalEvent();
			case CollaborationPackage.COMMUNICATION__ORDER:
				return new Integer(getOrder());
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
			case CollaborationPackage.COMMUNICATION__NAME:
				setName((String)newValue);
				return;
			case CollaborationPackage.COMMUNICATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case CollaborationPackage.COMMUNICATION__FROM_COLLABORATOR:
				setFromCollaborator((Collaborator)newValue);
				return;
			case CollaborationPackage.COMMUNICATION__TO_COLLABORATOR:
				setToCollaborator((Collaborator)newValue);
				return;
			case CollaborationPackage.COMMUNICATION__SIGNAL_EVENT:
				setSignalEvent((SignalEvent)newValue);
				return;
			case CollaborationPackage.COMMUNICATION__ORDER:
				setOrder(((Integer)newValue).intValue());
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
			case CollaborationPackage.COMMUNICATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CollaborationPackage.COMMUNICATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case CollaborationPackage.COMMUNICATION__FROM_COLLABORATOR:
				setFromCollaborator((Collaborator)null);
				return;
			case CollaborationPackage.COMMUNICATION__TO_COLLABORATOR:
				setToCollaborator((Collaborator)null);
				return;
			case CollaborationPackage.COMMUNICATION__SIGNAL_EVENT:
				setSignalEvent((SignalEvent)null);
				return;
			case CollaborationPackage.COMMUNICATION__ORDER:
				setOrder(ORDER_EDEFAULT);
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
			case CollaborationPackage.COMMUNICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CollaborationPackage.COMMUNICATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case CollaborationPackage.COMMUNICATION__FROM_COLLABORATOR:
				return fromCollaborator != null;
			case CollaborationPackage.COMMUNICATION__TO_COLLABORATOR:
				return toCollaborator != null;
			case CollaborationPackage.COMMUNICATION__SIGNAL_EVENT:
				return signalEvent != null;
			case CollaborationPackage.COMMUNICATION__ORDER:
				return order != ORDER_EDEFAULT;
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
		result.append(", order: ");
		result.append(order);
		result.append(')');
		return result.toString();
	}

} //CommunicationImpl
