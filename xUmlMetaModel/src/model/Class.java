/**
 * <copyright>
 * </copyright>
 *
 * $Id: Class.java,v 1.2 2008/05/23 05:15:11 dxm Exp $
 */
package model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Class#getPackage <em>Package</em>}</li>
 *   <li>{@link model.Class#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link model.Class#getAttributeDerived <em>Attribute Derived</em>}</li>
 *   <li>{@link model.Class#getOperation <em>Operation</em>}</li>
 *   <li>{@link model.Class#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link model.Class#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link model.Class#getIdentifierPrimary <em>Identifier Primary</em>}</li>
 *   <li>{@link model.Class#getIdentifierNonPrimary <em>Identifier Non Primary</em>}</li>
 *   <li>{@link model.Class#getAssociationEndPrimary <em>Association End Primary</em>}</li>
 *   <li>{@link model.Class#getAssociationEndSecondary <em>Association End Secondary</em>}</li>
 *   <li>{@link model.Class#getPersistence <em>Persistence</em>}</li>
 *   <li>{@link model.Class#getSpecializationGroup <em>Specialization Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Named {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.Package#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(model.Package)
	 * @see model.ModelPackage#getClass_Package()
	 * @see model.Package#getClass_
	 * @model opposite="class" transient="false"
	 * @generated
	 */
	model.Package getPackage();

	/**
	 * Sets the value of the '{@link model.Class#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(model.Package value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link model.Attribute}.
	 * It is bidirectional and its opposite is '{@link model.Attribute#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see model.ModelPackage#getClass_Attribute()
	 * @see model.Attribute#getClass_
	 * @model opposite="class" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttribute();

	/**
	 * Returns the value of the '<em><b>Attribute Derived</b></em>' containment reference list.
	 * The list contents are of type {@link model.AttributeDerived}.
	 * It is bidirectional and its opposite is '{@link model.AttributeDerived#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Derived</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Derived</em>' containment reference list.
	 * @see model.ModelPackage#getClass_AttributeDerived()
	 * @see model.AttributeDerived#getClass_
	 * @model opposite="class" containment="true"
	 * @generated
	 */
	EList<AttributeDerived> getAttributeDerived();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' containment reference list.
	 * The list contents are of type {@link model.Operation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' containment reference list.
	 * @see model.ModelPackage#getClass_Operation()
	 * @model containment="true"
	 * @generated
	 */
	EList<Operation> getOperation();

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
	 * @see model.ModelPackage#getClass_Constraints()
	 * @model containment="true"
	 * @generated
	 */
	ObjectConstraintLanguage getConstraints();

	/**
	 * Sets the value of the '{@link model.Class#getConstraints <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' containment reference.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(ObjectConstraintLanguage value);

	/**
	 * Returns the value of the '<em><b>State Machine</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link model.StateMachine#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Machine</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Machine</em>' containment reference.
	 * @see #setStateMachine(StateMachine)
	 * @see model.ModelPackage#getClass_StateMachine()
	 * @see model.StateMachine#getClass_
	 * @model opposite="class" containment="true"
	 * @generated
	 */
	StateMachine getStateMachine();

	/**
	 * Sets the value of the '{@link model.Class#getStateMachine <em>State Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Machine</em>' containment reference.
	 * @see #getStateMachine()
	 * @generated
	 */
	void setStateMachine(StateMachine value);

	/**
	 * Returns the value of the '<em><b>Identifier Primary</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Primary</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Primary</em>' containment reference.
	 * @see #setIdentifierPrimary(IdentifierPrimary)
	 * @see model.ModelPackage#getClass_IdentifierPrimary()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IdentifierPrimary getIdentifierPrimary();

	/**
	 * Sets the value of the '{@link model.Class#getIdentifierPrimary <em>Identifier Primary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier Primary</em>' containment reference.
	 * @see #getIdentifierPrimary()
	 * @generated
	 */
	void setIdentifierPrimary(IdentifierPrimary value);

	/**
	 * Returns the value of the '<em><b>Identifier Non Primary</b></em>' containment reference list.
	 * The list contents are of type {@link model.IdentifierNonPrimary}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier Non Primary</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier Non Primary</em>' containment reference list.
	 * @see model.ModelPackage#getClass_IdentifierNonPrimary()
	 * @model containment="true" keys="name"
	 * @generated
	 */
	EList<IdentifierNonPrimary> getIdentifierNonPrimary();

	/**
	 * Returns the value of the '<em><b>Association End Primary</b></em>' reference list.
	 * The list contents are of type {@link model.AssociationEndPrimary}.
	 * It is bidirectional and its opposite is '{@link model.AssociationEndPrimary#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association End Primary</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association End Primary</em>' reference list.
	 * @see model.ModelPackage#getClass_AssociationEndPrimary()
	 * @see model.AssociationEndPrimary#getClass_
	 * @model opposite="class"
	 * @generated
	 */
	EList<AssociationEndPrimary> getAssociationEndPrimary();

	/**
	 * Returns the value of the '<em><b>Association End Secondary</b></em>' reference list.
	 * The list contents are of type {@link model.AssociationEndSecondary}.
	 * It is bidirectional and its opposite is '{@link model.AssociationEndSecondary#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association End Secondary</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association End Secondary</em>' reference list.
	 * @see model.ModelPackage#getClass_AssociationEndSecondary()
	 * @see model.AssociationEndSecondary#getClass_
	 * @model opposite="class"
	 * @generated
	 */
	EList<AssociationEndSecondary> getAssociationEndSecondary();

	/**
	 * Returns the value of the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistence</em>' containment reference.
	 * @see #setPersistence(ClassPersistence)
	 * @see model.ModelPackage#getClass_Persistence()
	 * @model containment="true"
	 * @generated
	 */
	ClassPersistence getPersistence();

	/**
	 * Sets the value of the '{@link model.Class#getPersistence <em>Persistence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistence</em>' containment reference.
	 * @see #getPersistence()
	 * @generated
	 */
	void setPersistence(ClassPersistence value);

	/**
	 * Returns the value of the '<em><b>Specialization Group</b></em>' containment reference list.
	 * The list contents are of type {@link model.SpecializationGroup}.
	 * It is bidirectional and its opposite is '{@link model.SpecializationGroup#getSuperClass <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Specialization Group</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Specialization Group</em>' containment reference list.
	 * @see model.ModelPackage#getClass_SpecializationGroup()
	 * @see model.SpecializationGroup#getSuperClass
	 * @model opposite="superClass" containment="true" keys="name"
	 * @generated
	 */
	EList<SpecializationGroup> getSpecializationGroup();

} // Class
