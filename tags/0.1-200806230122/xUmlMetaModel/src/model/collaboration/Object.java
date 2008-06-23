/**
 * <copyright>
 * </copyright>
 *
 * $Id: Object.java,v 1.4 2008/06/11 07:28:46 dxm Exp $
 */
package model.collaboration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.collaboration.Object#getClass_ <em>Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.collaboration.CollaborationPackage#getObject()
 * @model
 * @generated
 */
public interface Object extends Collaborator {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(model.Class)
	 * @see model.collaboration.CollaborationPackage#getObject_Class()
	 * @model required="true"
	 * @generated
	 */
	model.Class getClass_();

	/**
	 * Sets the value of the '{@link model.collaboration.Object#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(model.Class value);

} // Object
