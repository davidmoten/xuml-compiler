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
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Attribute#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.Attribute#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link model.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link model.Attribute#isUnique <em>Unique</em>}</li>
 *   <li>{@link model.Attribute#getIdentifierPrimary <em>Identifier Primary</em>}</li>
 *   <li>{@link model.Attribute#getIdentifierNonPrimary <em>Identifier Non Primary</em>}</li>
 *   <li>{@link model.Attribute#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link model.Attribute#getPersistence <em>Persistence</em>}</li>
 *   <li>{@link model.Attribute#getValues <em>Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends IdentifierParticipant {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.Class#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' container reference.
	 * @see #setClass(model.Class)
	 * @see model.ModelPackage#getAttribute_Class()
	 * @see model.Class#getAttribute
	 * @model opposite="attribute" required="true" transient="false"
	 * @generated
	 */
	model.Class getClass_();

	/**
	 * Sets the value of the '{@link model.Attribute#getClass_ <em>Class</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' container reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(model.Class value);

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' containment reference.
	 * @see #setConstraints(ObjectConstraintLanguage)
	 * @see model.ModelPackage#getAttribute_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	ObjectConstraintLanguage getConstraints();

	/**
	 * Sets the value of the '{@link model.Attribute#getConstraints <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' containment reference.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(ObjectConstraintLanguage value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(PrimitiveType)
	 * @see model.ModelPackage#getAttribute_Type()
	 * @model required="true"
	 * @generated
	 */
	PrimitiveType getType();

	/**
	 * Sets the value of the '{@link model.Attribute#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(PrimitiveType value);

	/**
	 * Returns the value of the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique</em>' attribute.
	 * @see #setUnique(boolean)
	 * @see model.ModelPackage#getAttribute_Unique()
	 * @model required="true"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link model.Attribute#isUnique <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Identifier Primary</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link model.IdentifierPrimary#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Primary</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Primary</em>' reference.
	 * @see #setIdentifierPrimary(IdentifierPrimary)
	 * @see model.ModelPackage#getAttribute_IdentifierPrimary()
	 * @see model.IdentifierPrimary#getAttribute
	 * @model opposite="attribute" keys="name"
	 * @generated
	 */
	IdentifierPrimary getIdentifierPrimary();

	/**
	 * Sets the value of the '{@link model.Attribute#getIdentifierPrimary <em>Identifier Primary</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier Primary</em>' reference.
	 * @see #getIdentifierPrimary()
	 * @generated
	 */
	void setIdentifierPrimary(IdentifierPrimary value);

	/**
	 * Returns the value of the '<em><b>Identifier Non Primary</b></em>' reference list.
	 * The list contents are of type {@link model.IdentifierNonPrimary}.
	 * It is bidirectional and its opposite is '{@link model.IdentifierNonPrimary#getAttribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Non Primary</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Non Primary</em>' reference list.
	 * @see model.ModelPackage#getAttribute_IdentifierNonPrimary()
	 * @see model.IdentifierNonPrimary#getAttribute
	 * @model opposite="attribute"
	 * @generated
	 */
	EList<IdentifierNonPrimary> getIdentifierNonPrimary();

	/**
	 * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mandatory</em>' attribute.
	 * @see #setMandatory(boolean)
	 * @see model.ModelPackage#getAttribute_Mandatory()
	 * @model default="true" required="true" derived="true"
	 * @generated
	 */
	boolean isMandatory();

	/**
	 * Sets the value of the '{@link model.Attribute#isMandatory <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mandatory</em>' attribute.
	 * @see #isMandatory()
	 * @generated
	 */
	void setMandatory(boolean value);

	/**
	 * Returns the value of the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistence</em>' containment reference.
	 * @see #setPersistence(AttributePersistence)
	 * @see model.ModelPackage#getAttribute_Persistence()
	 * @model containment="true"
	 * @generated
	 */
	AttributePersistence getPersistence();

	/**
	 * Sets the value of the '{@link model.Attribute#getPersistence <em>Persistence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistence</em>' containment reference.
	 * @see #getPersistence()
	 * @generated
	 */
	void setPersistence(AttributePersistence value);

	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see model.ModelPackage#getAttribute_Values()
	 * @model
	 * @generated
	 */
	EList<String> getValues();

} // Attribute
