/**
 * <copyright>
 * </copyright>
 *
 * $Id: Bridge.java,v 1.2 2008/05/23 05:15:22 dxm Exp $
 */
package model.domain;

import model.Named;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bridge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.domain.Bridge#getADomain <em>ADomain</em>}</li>
 *   <li>{@link model.domain.Bridge#getBDomain <em>BDomain</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.domain.DomainPackage#getBridge()
 * @model
 * @generated
 */
public interface Bridge extends Named {
	/**
	 * Returns the value of the '<em><b>ADomain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ADomain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ADomain</em>' reference.
	 * @see #setADomain(Domain)
	 * @see model.domain.DomainPackage#getBridge_ADomain()
	 * @model required="true"
	 * @generated
	 */
	Domain getADomain();

	/**
	 * Sets the value of the '{@link model.domain.Bridge#getADomain <em>ADomain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ADomain</em>' reference.
	 * @see #getADomain()
	 * @generated
	 */
	void setADomain(Domain value);

	/**
	 * Returns the value of the '<em><b>BDomain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>BDomain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>BDomain</em>' reference.
	 * @see #setBDomain(Domain)
	 * @see model.domain.DomainPackage#getBridge_BDomain()
	 * @model required="true"
	 * @generated
	 */
	Domain getBDomain();

	/**
	 * Sets the value of the '{@link model.domain.Bridge#getBDomain <em>BDomain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>BDomain</em>' reference.
	 * @see #getBDomain()
	 * @generated
	 */
	void setBDomain(Domain value);

} // Bridge
