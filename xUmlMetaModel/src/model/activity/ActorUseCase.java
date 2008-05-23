/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActorUseCase.java,v 1.2 2008/05/23 05:15:15 dxm Exp $
 */
package model.activity;

import model.use.Actor;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actor Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.activity.ActorUseCase#getActor <em>Actor</em>}</li>
 *   <li>{@link model.activity.ActorUseCase#getActivity <em>Activity</em>}</li>
 *   <li>{@link model.activity.ActorUseCase#getNextNode <em>Next Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.activity.ActivityPackage#getActorUseCase()
 * @model
 * @generated
 */
public interface ActorUseCase extends ActivityNode {
	/**
	 * Returns the value of the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor</em>' reference.
	 * @see #setActor(Actor)
	 * @see model.activity.ActivityPackage#getActorUseCase_Actor()
	 * @model required="true"
	 * @generated
	 */
	Actor getActor();

	/**
	 * Sets the value of the '{@link model.activity.ActorUseCase#getActor <em>Actor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Actor</em>' reference.
	 * @see #getActor()
	 * @generated
	 */
	void setActor(Actor value);

	/**
	 * Returns the value of the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' reference.
	 * @see #setActivity(Activity)
	 * @see model.activity.ActivityPackage#getActorUseCase_Activity()
	 * @model required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link model.activity.ActorUseCase#getActivity <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Next Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Node</em>' reference.
	 * @see #setNextNode(ActivityNode)
	 * @see model.activity.ActivityPackage#getActorUseCase_NextNode()
	 * @model
	 * @generated
	 */
	ActivityNode getNextNode();

	/**
	 * Sets the value of the '{@link model.activity.ActorUseCase#getNextNode <em>Next Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Node</em>' reference.
	 * @see #getNextNode()
	 * @generated
	 */
	void setNextNode(ActivityNode value);

} // ActorUseCase
