/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.diagram;

import model.Named;

import model.collaboration.Collaborator;
import model.collaboration.Communication;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collaboration Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.diagram.CollaborationDiagram#getCollaborator <em>Collaborator</em>}</li>
 *   <li>{@link model.diagram.CollaborationDiagram#getCommunication <em>Communication</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.diagram.DiagramPackage#getCollaborationDiagram()
 * @model
 * @generated
 */
public interface CollaborationDiagram extends Named {
	/**
	 * Returns the value of the '<em><b>Collaborator</b></em>' reference list.
	 * The list contents are of type {@link model.collaboration.Collaborator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collaborator</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collaborator</em>' reference list.
	 * @see model.diagram.DiagramPackage#getCollaborationDiagram_Collaborator()
	 * @model
	 * @generated
	 */
	EList<Collaborator> getCollaborator();

	/**
	 * Returns the value of the '<em><b>Communication</b></em>' reference list.
	 * The list contents are of type {@link model.collaboration.Communication}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communication</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication</em>' reference list.
	 * @see model.diagram.DiagramPackage#getCollaborationDiagram_Communication()
	 * @model
	 * @generated
	 */
	EList<Communication> getCommunication();

} // CollaborationDiagram
