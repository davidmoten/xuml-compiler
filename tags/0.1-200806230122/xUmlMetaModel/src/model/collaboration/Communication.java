/**
 * <copyright>
 * </copyright>
 *
 * $Id: Communication.java,v 1.4 2008/06/11 07:28:46 dxm Exp $
 */
package model.collaboration;

import model.Named;
import model.SignalEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Communication</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.collaboration.Communication#getFromCollaborator <em>From Collaborator</em>}</li>
 *   <li>{@link model.collaboration.Communication#getToCollaborator <em>To Collaborator</em>}</li>
 *   <li>{@link model.collaboration.Communication#getSignalEvent <em>Signal Event</em>}</li>
 *   <li>{@link model.collaboration.Communication#getOrder <em>Order</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.collaboration.CollaborationPackage#getCommunication()
 * @model
 * @generated
 */
public interface Communication extends Named {
	/**
	 * Returns the value of the '<em><b>From Collaborator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Collaborator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Collaborator</em>' reference.
	 * @see #setFromCollaborator(Collaborator)
	 * @see model.collaboration.CollaborationPackage#getCommunication_FromCollaborator()
	 * @model required="true"
	 * @generated
	 */
	Collaborator getFromCollaborator();

	/**
	 * Sets the value of the '{@link model.collaboration.Communication#getFromCollaborator <em>From Collaborator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Collaborator</em>' reference.
	 * @see #getFromCollaborator()
	 * @generated
	 */
	void setFromCollaborator(Collaborator value);

	/**
	 * Returns the value of the '<em><b>To Collaborator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Collaborator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Collaborator</em>' reference.
	 * @see #setToCollaborator(Collaborator)
	 * @see model.collaboration.CollaborationPackage#getCommunication_ToCollaborator()
	 * @model required="true"
	 * @generated
	 */
	Collaborator getToCollaborator();

	/**
	 * Sets the value of the '{@link model.collaboration.Communication#getToCollaborator <em>To Collaborator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Collaborator</em>' reference.
	 * @see #getToCollaborator()
	 * @generated
	 */
	void setToCollaborator(Collaborator value);

	/**
	 * Returns the value of the '<em><b>Signal Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal Event</em>' reference.
	 * @see #setSignalEvent(SignalEvent)
	 * @see model.collaboration.CollaborationPackage#getCommunication_SignalEvent()
	 * @model required="true"
	 * @generated
	 */
	SignalEvent getSignalEvent();

	/**
	 * Sets the value of the '{@link model.collaboration.Communication#getSignalEvent <em>Signal Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal Event</em>' reference.
	 * @see #getSignalEvent()
	 * @generated
	 */
	void setSignalEvent(SignalEvent value);

	/**
	 * Returns the value of the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order</em>' attribute.
	 * @see #setOrder(int)
	 * @see model.collaboration.CollaborationPackage#getCommunication_Order()
	 * @model
	 * @generated
	 */
	int getOrder();

	/**
	 * Sets the value of the '{@link model.collaboration.Communication#getOrder <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Order</em>' attribute.
	 * @see #getOrder()
	 * @generated
	 */
	void setOrder(int value);

} // Communication
