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
 * A representation of the model object '<em><b>Identifier Non Primary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.IdentifierNonPrimary#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link model.IdentifierNonPrimary#getDerivedAttribute <em>Derived Attribute</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getIdentifierNonPrimary()
 * @model
 * @generated
 */
public interface IdentifierNonPrimary extends Identifier {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference list.
	 * The list contents are of type {@link model.Attribute}.
	 * It is bidirectional and its opposite is '{@link model.Attribute#getIdentifierNonPrimary <em>Identifier Non Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference list.
	 * @see model.ModelPackage#getIdentifierNonPrimary_Attribute()
	 * @see model.Attribute#getIdentifierNonPrimary
	 * @model opposite="identifierNonPrimary" keys="name"
	 * @generated
	 */
	EList<Attribute> getAttribute();

	/**
	 * Returns the value of the '<em><b>Derived Attribute</b></em>' reference list.
	 * The list contents are of type {@link model.AttributeDerived}.
	 * It is bidirectional and its opposite is '{@link model.AttributeDerived#getIdentifierNonPrimary <em>Identifier Non Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Attribute</em>' reference list.
	 * @see model.ModelPackage#getIdentifierNonPrimary_DerivedAttribute()
	 * @see model.AttributeDerived#getIdentifierNonPrimary
	 * @model opposite="identifierNonPrimary" keys="name"
	 * @generated
	 */
	EList<AttributeDerived> getDerivedAttribute();

} // IdentifierNonPrimary
