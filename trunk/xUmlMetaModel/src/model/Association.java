/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Association#getPrimary <em>Primary</em>}</li>
 *   <li>{@link model.Association#getSecondary <em>Secondary</em>}</li>
 *   <li>{@link model.Association#getAssociationClass <em>Association Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getAssociation()
 * @model
 * @generated
 */
public interface Association extends Named {
	/**
	 * Returns the value of the '<em><b>Primary</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link model.AssociationEndPrimary#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primary</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary</em>' containment reference.
	 * @see #setPrimary(AssociationEndPrimary)
	 * @see model.ModelPackage#getAssociation_Primary()
	 * @see model.AssociationEndPrimary#getAssociation
	 * @model opposite="association" containment="true" required="true"
	 * @generated
	 */
	AssociationEndPrimary getPrimary();

	/**
	 * Sets the value of the '{@link model.Association#getPrimary <em>Primary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' containment reference.
	 * @see #getPrimary()
	 * @generated
	 */
	void setPrimary(AssociationEndPrimary value);

	/**
	 * Returns the value of the '<em><b>Secondary</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link model.AssociationEndSecondary#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Secondary</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Secondary</em>' containment reference.
	 * @see #setSecondary(AssociationEndSecondary)
	 * @see model.ModelPackage#getAssociation_Secondary()
	 * @see model.AssociationEndSecondary#getAssociation
	 * @model opposite="association" containment="true" required="true"
	 * @generated
	 */
	AssociationEndSecondary getSecondary();

	/**
	 * Sets the value of the '{@link model.Association#getSecondary <em>Secondary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Secondary</em>' containment reference.
	 * @see #getSecondary()
	 * @generated
	 */
	void setSecondary(AssociationEndSecondary value);

	/**
	 * Returns the value of the '<em><b>Association Class</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.AssociationClass#getAssociation <em>Association</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association Class</em>' reference.
	 * @see #setAssociationClass(AssociationClass)
	 * @see model.ModelPackage#getAssociation_AssociationClass()
	 * @see model.AssociationClass#getAssociation
	 * @model opposite="association" keys="name"
	 * @generated
	 */
	AssociationClass getAssociationClass();

	/**
	 * Sets the value of the '{@link model.Association#getAssociationClass <em>Association Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association Class</em>' reference.
	 * @see #getAssociationClass()
	 * @generated
	 */
	void setAssociationClass(AssociationClass value);

} // Association
