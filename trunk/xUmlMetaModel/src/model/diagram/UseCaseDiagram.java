/**
 * <copyright>
 * </copyright>
 *
 * $Id: UseCaseDiagram.java,v 1.2 2008/05/23 05:15:20 dxm Exp $
 */
package model.diagram;

import model.Named;

import model.use.UseCase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.diagram.UseCaseDiagram#getUseCase <em>Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.diagram.DiagramPackage#getUseCaseDiagram()
 * @model
 * @generated
 */
public interface UseCaseDiagram extends Named {
	/**
	 * Returns the value of the '<em><b>Use Case</b></em>' reference list.
	 * The list contents are of type {@link model.use.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case</em>' reference list.
	 * @see model.diagram.DiagramPackage#getUseCaseDiagram_UseCase()
	 * @model
	 * @generated
	 */
	EList<UseCase> getUseCase();

} // UseCaseDiagram
