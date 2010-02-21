/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.activity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fork</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.activity.Fork#getNextNode <em>Next Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.activity.ActivityPackage#getFork()
 * @model
 * @generated
 */
public interface Fork extends ActivityNode {
	/**
	 * Returns the value of the '<em><b>Next Node</b></em>' reference list.
	 * The list contents are of type {@link model.activity.ActivityNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Node</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Node</em>' reference list.
	 * @see model.activity.ActivityPackage#getFork_NextNode()
	 * @model required="true"
	 * @generated
	 */
	EList<ActivityNode> getNextNode();

} // Fork
