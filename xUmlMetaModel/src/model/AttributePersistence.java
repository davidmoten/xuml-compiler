/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Persistence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.AttributePersistence#getColumn <em>Column</em>}</li>
 *   <li>{@link model.AttributePersistence#isGeneratedBySequence <em>Generated By Sequence</em>}</li>
 *   <li>{@link model.AttributePersistence#isGeneratedValue <em>Generated Value</em>}</li>
 *   <li>{@link model.AttributePersistence#getLength <em>Length</em>}</li>
 *   <li>{@link model.AttributePersistence#getScale <em>Scale</em>}</li>
 *   <li>{@link model.AttributePersistence#getPrecision <em>Precision</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getAttributePersistence()
 * @model
 * @generated
 */
public interface AttributePersistence extends EObject {
	/**
	 * Returns the value of the '<em><b>Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' attribute.
	 * @see #setColumn(String)
	 * @see model.ModelPackage#getAttributePersistence_Column()
	 * @model
	 * @generated
	 */
	String getColumn();

	/**
	 * Sets the value of the '{@link model.AttributePersistence#getColumn <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' attribute.
	 * @see #getColumn()
	 * @generated
	 */
	void setColumn(String value);

	/**
	 * Returns the value of the '<em><b>Generated By Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generated By Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generated By Sequence</em>' attribute.
	 * @see #setGeneratedBySequence(boolean)
	 * @see model.ModelPackage#getAttributePersistence_GeneratedBySequence()
	 * @model required="true"
	 * @generated
	 */
	boolean isGeneratedBySequence();

	/**
	 * Sets the value of the '{@link model.AttributePersistence#isGeneratedBySequence <em>Generated By Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generated By Sequence</em>' attribute.
	 * @see #isGeneratedBySequence()
	 * @generated
	 */
	void setGeneratedBySequence(boolean value);

	/**
	 * Returns the value of the '<em><b>Generated Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Generated Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Generated Value</em>' attribute.
	 * @see #setGeneratedValue(boolean)
	 * @see model.ModelPackage#getAttributePersistence_GeneratedValue()
	 * @model required="true"
	 * @generated
	 */
	boolean isGeneratedValue();

	/**
	 * Sets the value of the '{@link model.AttributePersistence#isGeneratedValue <em>Generated Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generated Value</em>' attribute.
	 * @see #isGeneratedValue()
	 * @generated
	 */
	void setGeneratedValue(boolean value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(Integer)
	 * @see model.ModelPackage#getAttributePersistence_Length()
	 * @model
	 * @generated
	 */
	Integer getLength();

	/**
	 * Sets the value of the '{@link model.AttributePersistence#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Integer value);

	/**
	 * Returns the value of the '<em><b>Scale</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scale</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scale</em>' attribute.
	 * @see #setScale(Integer)
	 * @see model.ModelPackage#getAttributePersistence_Scale()
	 * @model
	 * @generated
	 */
	Integer getScale();

	/**
	 * Sets the value of the '{@link model.AttributePersistence#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Integer value);

	/**
	 * Returns the value of the '<em><b>Precision</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precision</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precision</em>' attribute.
	 * @see #setPrecision(Integer)
	 * @see model.ModelPackage#getAttributePersistence_Precision()
	 * @model
	 * @generated
	 */
	Integer getPrecision();

	/**
	 * Sets the value of the '{@link model.AttributePersistence#getPrecision <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision</em>' attribute.
	 * @see #getPrecision()
	 * @generated
	 */
	void setPrecision(Integer value);

} // AttributePersistence
