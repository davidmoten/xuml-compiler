/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.AssociationClass#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getAssociationClass()
 * @model
 * @generated
 */
public interface AssociationClass extends model.Class {
	/**
	 * Returns the value of the '<em><b>Association</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.Association#getAssociationClass <em>Association Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' reference.
	 * @see #setAssociation(Association)
	 * @see model.ModelPackage#getAssociationClass_Association()
	 * @see model.Association#getAssociationClass
	 * @model opposite="associationClass" required="true"
	 * @generated
	 */
	Association getAssociation();

	/**
	 * Sets the value of the '{@link model.AssociationClass#getAssociation <em>Association</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(Association value);

} // AssociationClass
