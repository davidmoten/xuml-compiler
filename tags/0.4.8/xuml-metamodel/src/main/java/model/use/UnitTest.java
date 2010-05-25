/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.use;

import model.Named;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.use.UnitTest#getUseCase <em>Use Case</em>}</li>
 *   <li>{@link model.use.UnitTest#getParameterData <em>Parameter Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.use.UsePackage#getUnitTest()
 * @model
 * @generated
 */
public interface UnitTest extends Named {
	/**
	 * Returns the value of the '<em><b>Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case</em>' reference.
	 * @see #setUseCase(UseCase)
	 * @see model.use.UsePackage#getUnitTest_UseCase()
	 * @model required="true"
	 * @generated
	 */
	UseCase getUseCase();

	/**
	 * Sets the value of the '{@link model.use.UnitTest#getUseCase <em>Use Case</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Case</em>' reference.
	 * @see #getUseCase()
	 * @generated
	 */
	void setUseCase(UseCase value);

	/**
	 * Returns the value of the '<em><b>Parameter Data</b></em>' containment reference list.
	 * The list contents are of type {@link model.use.ParameterData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Data</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Data</em>' containment reference list.
	 * @see model.use.UsePackage#getUnitTest_ParameterData()
	 * @model containment="true"
	 * @generated
	 */
	EList<ParameterData> getParameterData();

} // UnitTest
