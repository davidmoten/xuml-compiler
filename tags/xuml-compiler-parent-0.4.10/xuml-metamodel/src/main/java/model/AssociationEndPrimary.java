/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End Primary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.AssociationEndPrimary#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.AssociationEndPrimary#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getAssociationEndPrimary()
 * @model
 * @generated
 */
public interface AssociationEndPrimary extends AssociationEnd {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.Class#getAssociationEndPrimary <em>Association End Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(model.Class)
	 * @see model.ModelPackage#getAssociationEndPrimary_Class()
	 * @see model.Class#getAssociationEndPrimary
	 * @model opposite="associationEndPrimary" required="true"
	 * @generated
	 */
	model.Class getClass_();

	/**
	 * Sets the value of the '{@link model.AssociationEndPrimary#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(model.Class value);

	/**
	 * Returns the value of the '<em><b>Association</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.Association#getPrimary <em>Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' container reference.
	 * @see #setAssociation(Association)
	 * @see model.ModelPackage#getAssociationEndPrimary_Association()
	 * @see model.Association#getPrimary
	 * @model opposite="primary" required="true" transient="false"
	 * @generated
	 */
	Association getAssociation();

	/**
	 * Sets the value of the '{@link model.AssociationEndPrimary#getAssociation <em>Association</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association</em>' container reference.
	 * @see #getAssociation()
	 * @generated
	 */
	void setAssociation(Association value);

} // AssociationEndPrimary
