/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationEnd.java,v 1.4 2008/06/11 07:28:39 dxm Exp $
 */
package model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.AssociationEnd#isMandatory <em>Mandatory</em>}</li>
 *   <li>{@link model.AssociationEnd#isMultiple <em>Multiple</em>}</li>
 *   <li>{@link model.AssociationEnd#getVerbClause <em>Verb Clause</em>}</li>
 *   <li>{@link model.AssociationEnd#getRole <em>Role</em>}</li>
 *   <li>{@link model.AssociationEnd#getRolePlural <em>Role Plural</em>}</li>
 *   <li>{@link model.AssociationEnd#getDerivedAttribute <em>Derived Attribute</em>}</li>
 *   <li>{@link model.AssociationEnd#getPersistence <em>Persistence</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getAssociationEnd()
 * @model abstract="true"
 * @generated
 */
public interface AssociationEnd extends Named {
	/**
	 * Returns the value of the '<em><b>Mandatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mandatory</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mandatory</em>' attribute.
	 * @see #setMandatory(boolean)
	 * @see model.ModelPackage#getAssociationEnd_Mandatory()
	 * @model required="true"
	 * @generated
	 */
	boolean isMandatory();

	/**
	 * Sets the value of the '{@link model.AssociationEnd#isMandatory <em>Mandatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mandatory</em>' attribute.
	 * @see #isMandatory()
	 * @generated
	 */
	void setMandatory(boolean value);

	/**
	 * Returns the value of the '<em><b>Multiple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multiple</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multiple</em>' attribute.
	 * @see #setMultiple(boolean)
	 * @see model.ModelPackage#getAssociationEnd_Multiple()
	 * @model required="true"
	 * @generated
	 */
	boolean isMultiple();

	/**
	 * Sets the value of the '{@link model.AssociationEnd#isMultiple <em>Multiple</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multiple</em>' attribute.
	 * @see #isMultiple()
	 * @generated
	 */
	void setMultiple(boolean value);

	/**
	 * Returns the value of the '<em><b>Verb Clause</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verb Clause</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verb Clause</em>' attribute.
	 * @see #setVerbClause(String)
	 * @see model.ModelPackage#getAssociationEnd_VerbClause()
	 * @model required="true"
	 * @generated
	 */
	String getVerbClause();

	/**
	 * Sets the value of the '{@link model.AssociationEnd#getVerbClause <em>Verb Clause</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verb Clause</em>' attribute.
	 * @see #getVerbClause()
	 * @generated
	 */
	void setVerbClause(String value);

	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute.
	 * @see #setRole(String)
	 * @see model.ModelPackage#getAssociationEnd_Role()
	 * @model required="true"
	 * @generated
	 */
	String getRole();

	/**
	 * Sets the value of the '{@link model.AssociationEnd#getRole <em>Role</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' attribute.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(String value);

	/**
	 * Returns the value of the '<em><b>Role Plural</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Plural</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Plural</em>' attribute.
	 * @see #setRolePlural(String)
	 * @see model.ModelPackage#getAssociationEnd_RolePlural()
	 * @model
	 * @generated
	 */
	String getRolePlural();

	/**
	 * Sets the value of the '{@link model.AssociationEnd#getRolePlural <em>Role Plural</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Plural</em>' attribute.
	 * @see #getRolePlural()
	 * @generated
	 */
	void setRolePlural(String value);

	/**
	 * Returns the value of the '<em><b>Derived Attribute</b></em>' reference list.
	 * The list contents are of type {@link model.AttributeReferential}.
	 * It is bidirectional and its opposite is '{@link model.AttributeReferential#getAssociationEnd <em>Association End</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived Attribute</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Derived Attribute</em>' reference list.
	 * @see model.ModelPackage#getAssociationEnd_DerivedAttribute()
	 * @see model.AttributeReferential#getAssociationEnd
	 * @model opposite="associationEnd"
	 * @generated
	 */
	EList<AttributeReferential> getDerivedAttribute();

	/**
	 * Returns the value of the '<em><b>Persistence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Persistence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Persistence</em>' containment reference.
	 * @see #setPersistence(AssociationEndPersistence)
	 * @see model.ModelPackage#getAssociationEnd_Persistence()
	 * @model containment="true"
	 * @generated
	 */
	AssociationEndPersistence getPersistence();

	/**
	 * Sets the value of the '{@link model.AssociationEnd#getPersistence <em>Persistence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Persistence</em>' containment reference.
	 * @see #getPersistence()
	 * @generated
	 */
	void setPersistence(AssociationEndPersistence value);

} // AssociationEnd
