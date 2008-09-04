/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timer Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.TimerEvent#getTimeMs <em>Time Ms</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getTimerEvent()
 * @model annotation="annotation documentation='asynchronous'"
 * @generated
 */
public interface TimerEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Time Ms</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Ms</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Ms</em>' attribute.
	 * @see #setTimeMs(long)
	 * @see model.ModelPackage#getTimerEvent_TimeMs()
	 * @model required="true"
	 * @generated
	 */
	long getTimeMs();

	/**
	 * Sets the value of the '{@link model.TimerEvent#getTimeMs <em>Time Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Ms</em>' attribute.
	 * @see #getTimeMs()
	 * @generated
	 */
	void setTimeMs(long value);

} // TimerEvent
