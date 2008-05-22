/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Derived</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.AttributeDerived#getAssociationEnd <em>Association End</em>}</li>
 *   <li>{@link model.AttributeDerived#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.AttributeDerived#getIdentifierPrimary <em>Identifier Primary</em>}</li>
 *   <li>{@link model.AttributeDerived#getIdentifierNonPrimary <em>Identifier Non Primary</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getAttributeDerived()
 * @model
 * @generated
 */
public interface AttributeDerived extends IdentifierParticipant {
	/**
	 * Returns the value of the '<em><b>Association End</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.AssociationEnd#getDerivedAttribute <em>Derived Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association End</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association End</em>' reference.
	 * @see #setAssociationEnd(AssociationEnd)
	 * @see model.ModelPackage#getAttributeDerived_AssociationEnd()
	 * @see model.AssociationEnd#getDerivedAttribute
	 * @model opposite="derivedAttribute"
	 * @generated
	 */
	AssociationEnd getAssociationEnd();

	/**
	 * Sets the value of the '{@link model.AttributeDerived#getAssociationEnd <em>Association End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Association End</em>' reference.
	 * @see #getAssociationEnd()
	 * @generated
	 */
	void setAssociationEnd(AssociationEnd value);

	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.Class#getAttributeDerived <em>Attribute Derived</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass(model.Class)
	 * @see model.ModelPackage#getAttributeDerived_Class()
	 * @see model.Class#getAttributeDerived
	 * @model opposite="attributeDerived" required="true" transient="false"
	 * @generated
	 */
	model.Class getClass_();

	/**
	 * Sets the value of the '{@link model.AttributeDerived#getClass_ <em>Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(model.Class value);

	/**
	 * Returns the value of the '<em><b>Identifier Primary</b></em>' reference list.
	 * The list contents are of type {@link model.IdentifierPrimary}.
	 * It is bidirectional and its opposite is '{@link model.IdentifierPrimary#getDerivedAttribute <em>Derived Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Primary</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Primary</em>' reference list.
	 * @see model.ModelPackage#getAttributeDerived_IdentifierPrimary()
	 * @see model.IdentifierPrimary#getDerivedAttribute
	 * @model opposite="derivedAttribute"
	 * @generated
	 */
	EList<IdentifierPrimary> getIdentifierPrimary();

	/**
	 * Returns the value of the '<em><b>Identifier Non Primary</b></em>' reference list.
	 * The list contents are of type {@link model.IdentifierNonPrimary}.
	 * It is bidirectional and its opposite is '{@link model.IdentifierNonPrimary#getDerivedAttribute <em>Derived Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Non Primary</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Non Primary</em>' reference list.
	 * @see model.ModelPackage#getAttributeDerived_IdentifierNonPrimary()
	 * @see model.IdentifierNonPrimary#getDerivedAttribute
	 * @model opposite="derivedAttribute"
	 * @generated
	 */
	EList<IdentifierNonPrimary> getIdentifierNonPrimary();

} // AttributeDerived
