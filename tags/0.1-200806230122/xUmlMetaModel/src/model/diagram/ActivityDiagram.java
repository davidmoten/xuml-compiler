/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActivityDiagram.java,v 1.4 2008/06/11 07:28:48 dxm Exp $
 */
package model.diagram;

import model.Named;

import model.activity.ActorUseCase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.diagram.ActivityDiagram#getActorUseCase <em>Actor Use Case</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.diagram.DiagramPackage#getActivityDiagram()
 * @model
 * @generated
 */
public interface ActivityDiagram extends Named {
	/**
	 * Returns the value of the '<em><b>Actor Use Case</b></em>' reference list.
	 * The list contents are of type {@link model.activity.ActorUseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Use Case</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Use Case</em>' reference list.
	 * @see model.diagram.DiagramPackage#getActivityDiagram_ActorUseCase()
	 * @model
	 * @generated
	 */
	EList<ActorUseCase> getActorUseCase();

} // ActivityDiagram
