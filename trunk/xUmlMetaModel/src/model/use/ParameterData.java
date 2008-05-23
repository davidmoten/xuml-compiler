/**
 * <copyright>
 * </copyright>
 *
 * $Id: ParameterData.java,v 1.2 2008/05/23 05:15:14 dxm Exp $
 */
package model.use;

import model.FreeType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.use.ParameterData#getParameter <em>Parameter</em>}</li>
 *   <li>{@link model.use.ParameterData#getData <em>Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.use.UsePackage#getParameterData()
 * @model
 * @generated
 */
public interface ParameterData extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference.
	 * @see #setParameter(FreeType)
	 * @see model.use.UsePackage#getParameterData_Parameter()
	 * @model containment="true" required="true"
	 * @generated
	 */
	FreeType getParameter();

	/**
	 * Sets the value of the '{@link model.use.ParameterData#getParameter <em>Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' containment reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(FreeType value);

	/**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(Data)
	 * @see model.use.UsePackage#getParameterData_Data()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Data getData();

	/**
	 * Sets the value of the '{@link model.use.ParameterData#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
	void setData(Data value);

} // ParameterData
