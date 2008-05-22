/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.activity;

import model.Named;
import model.SignalEvent;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.activity.Activity#getSignalEvent <em>Signal Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.activity.ActivityPackage#getActivity()
 * @model
 * @generated
 */
public interface Activity extends Named {
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
	 * @see model.activity.ActivityPackage#getActivity_SignalEvent()
	 * @model required="true"
	 * @generated
	 */
	SignalEvent getSignalEvent();

	/**
	 * Sets the value of the '{@link model.activity.Activity#getSignalEvent <em>Signal Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signal Event</em>' reference.
	 * @see #getSignalEvent()
	 * @generated
	 */
	void setSignalEvent(SignalEvent value);

} // Activity
