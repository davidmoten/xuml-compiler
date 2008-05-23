/**
 * <copyright>
 * </copyright>
 *
 * $Id: UseCase.java,v 1.2 2008/05/23 05:15:14 dxm Exp $
 */
package model.use;

import model.activity.Activity;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.use.UseCase#getActor <em>Actor</em>}</li>
 *   <li>{@link model.use.UseCase#getActivity <em>Activity</em>}</li>
 *   <li>{@link model.use.UseCase#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link model.use.UseCase#getPostcondition <em>Postcondition</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.use.UsePackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends EObject {
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
	 * @see model.use.UsePackage#getUseCase_Actor()
	 * @model required="true"
	 * @generated
	 */
	Actor getActor();

	/**
	 * Sets the value of the '{@link model.use.UseCase#getActor <em>Actor</em>}' reference.
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
	 * @see model.use.UsePackage#getUseCase_Activity()
	 * @model required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link model.use.UseCase#getActivity <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Precondition</b></em>' reference list.
	 * The list contents are of type {@link model.use.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precondition</em>' reference list.
	 * @see model.use.UsePackage#getUseCase_Precondition()
	 * @model
	 * @generated
	 */
	EList<Condition> getPrecondition();

	/**
	 * Returns the value of the '<em><b>Postcondition</b></em>' reference list.
	 * The list contents are of type {@link model.use.Condition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcondition</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postcondition</em>' reference list.
	 * @see model.use.UsePackage#getUseCase_Postcondition()
	 * @model
	 * @generated
	 */
	EList<Condition> getPostcondition();

} // UseCase
