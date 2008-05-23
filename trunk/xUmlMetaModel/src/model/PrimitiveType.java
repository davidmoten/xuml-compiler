/**
 * <copyright>
 * </copyright>
 *
 * $Id: PrimitiveType.java,v 1.2 2008/05/23 05:15:11 dxm Exp $
 */
package model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.PrimitiveType#getPrimitive <em>Primitive</em>}</li>
 *   <li>{@link model.PrimitiveType#getSystem <em>System</em>}</li>
 *   <li>{@link model.PrimitiveType#getPrecision <em>Precision</em>}</li>
 *   <li>{@link model.PrimitiveType#getScale <em>Scale</em>}</li>
 *   <li>{@link model.PrimitiveType#isUtc <em>Utc</em>}</li>
 *   <li>{@link model.PrimitiveType#getLength <em>Length</em>}</li>
 *   <li>{@link model.PrimitiveType#isYesNo <em>Yes No</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends Type {
	/**
	 * Returns the value of the '<em><b>Primitive</b></em>' attribute.
	 * The literals are from the enumeration {@link model.Primitive}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive</em>' attribute.
	 * @see model.Primitive
	 * @see #setPrimitive(Primitive)
	 * @see model.ModelPackage#getPrimitiveType_Primitive()
	 * @model required="true"
	 * @generated
	 */
	Primitive getPrimitive();

	/**
	 * Sets the value of the '{@link model.PrimitiveType#getPrimitive <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive</em>' attribute.
	 * @see model.Primitive
	 * @see #getPrimitive()
	 * @generated
	 */
	void setPrimitive(Primitive value);

	/**
	 * Returns the value of the '<em><b>System</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link model.System#getPrimitiveType <em>Primitive Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>System</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>System</em>' container reference.
	 * @see #setSystem(model.System)
	 * @see model.ModelPackage#getPrimitiveType_System()
	 * @see model.System#getPrimitiveType
	 * @model opposite="primitiveType" keys="name" required="true" transient="false"
	 * @generated
	 */
	model.System getSystem();

	/**
	 * Sets the value of the '{@link model.PrimitiveType#getSystem <em>System</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' container reference.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(model.System value);

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
	 * @see model.ModelPackage#getPrimitiveType_Precision()
	 * @model
	 * @generated
	 */
	Integer getPrecision();

	/**
	 * Sets the value of the '{@link model.PrimitiveType#getPrecision <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precision</em>' attribute.
	 * @see #getPrecision()
	 * @generated
	 */
	void setPrecision(Integer value);

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
	 * @see model.ModelPackage#getPrimitiveType_Scale()
	 * @model
	 * @generated
	 */
	Integer getScale();

	/**
	 * Sets the value of the '{@link model.PrimitiveType#getScale <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scale</em>' attribute.
	 * @see #getScale()
	 * @generated
	 */
	void setScale(Integer value);

	/**
	 * Returns the value of the '<em><b>Utc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Utc</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Utc</em>' attribute.
	 * @see #setUtc(boolean)
	 * @see model.ModelPackage#getPrimitiveType_Utc()
	 * @model
	 * @generated
	 */
	boolean isUtc();

	/**
	 * Sets the value of the '{@link model.PrimitiveType#isUtc <em>Utc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Utc</em>' attribute.
	 * @see #isUtc()
	 * @generated
	 */
	void setUtc(boolean value);

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
	 * @see model.ModelPackage#getPrimitiveType_Length()
	 * @model
	 * @generated
	 */
	Integer getLength();

	/**
	 * Sets the value of the '{@link model.PrimitiveType#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(Integer value);

	/**
	 * Returns the value of the '<em><b>Yes No</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yes No</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Yes No</em>' attribute.
	 * @see #setYesNo(boolean)
	 * @see model.ModelPackage#getPrimitiveType_YesNo()
	 * @model
	 * @generated
	 */
	boolean isYesNo();

	/**
	 * Sets the value of the '{@link model.PrimitiveType#isYesNo <em>Yes No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Yes No</em>' attribute.
	 * @see #isYesNo()
	 * @generated
	 */
	void setYesNo(boolean value);

} // PrimitiveType
