/**
 * <copyright>
 * </copyright>
 *
 * $Id: IdentifierPrimary.java,v 1.4 2008/06/11 07:28:39 dxm Exp $
 */
package model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identifier Primary</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.IdentifierPrimary#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link model.IdentifierPrimary#getAttributeReferential <em>Attribute Referential</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getIdentifierPrimary()
 * @model
 * @generated
 */
public interface IdentifierPrimary extends Identifier {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference list.
	 * The list contents are of type {@link model.Attribute}.
	 * It is bidirectional and its opposite is '{@link model.Attribute#getIdentifierPrimary <em>Identifier Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' reference list.
	 * @see model.ModelPackage#getIdentifierPrimary_Attribute()
	 * @see model.Attribute#getIdentifierPrimary
	 * @model opposite="identifierPrimary" keys="name"
	 * @generated
	 */
	EList<Attribute> getAttribute();

	/**
	 * Returns the value of the '<em><b>Attribute Referential</b></em>' reference list.
	 * The list contents are of type {@link model.AttributeReferential}.
	 * It is bidirectional and its opposite is '{@link model.AttributeReferential#getIdentifierPrimary <em>Identifier Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Referential</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Referential</em>' reference list.
	 * @see model.ModelPackage#getIdentifierPrimary_AttributeReferential()
	 * @see model.AttributeReferential#getIdentifierPrimary
	 * @model opposite="identifierPrimary" keys="name"
	 * @generated
	 */
	EList<AttributeReferential> getAttributeReferential();

} // IdentifierPrimary
