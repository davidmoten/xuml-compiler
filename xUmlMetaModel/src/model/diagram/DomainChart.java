/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.diagram;

import model.Named;

import model.domain.Bridge;
import model.domain.Domain;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Chart</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.diagram.DomainChart#getDomain <em>Domain</em>}</li>
 *   <li>{@link model.diagram.DomainChart#getBridge <em>Bridge</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.diagram.DiagramPackage#getDomainChart()
 * @model
 * @generated
 */
public interface DomainChart extends Named {
	/**
	 * Returns the value of the '<em><b>Domain</b></em>' reference list.
	 * The list contents are of type {@link model.domain.Domain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' reference list.
	 * @see model.diagram.DiagramPackage#getDomainChart_Domain()
	 * @model
	 * @generated
	 */
	EList<Domain> getDomain();

	/**
	 * Returns the value of the '<em><b>Bridge</b></em>' reference list.
	 * The list contents are of type {@link model.domain.Bridge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bridge</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bridge</em>' reference list.
	 * @see model.diagram.DiagramPackage#getDomainChart_Bridge()
	 * @model
	 * @generated
	 */
	EList<Bridge> getBridge();

} // DomainChart
