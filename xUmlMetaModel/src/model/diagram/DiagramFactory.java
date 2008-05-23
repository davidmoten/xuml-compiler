/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramFactory.java,v 1.2 2008/05/23 05:15:20 dxm Exp $
 */
package model.diagram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see model.diagram.DiagramPackage
 * @generated
 */
public interface DiagramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagramFactory eINSTANCE = model.diagram.impl.DiagramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Class Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Diagram</em>'.
	 * @generated
	 */
	ClassDiagram createClassDiagram();

	/**
	 * Returns a new object of class '<em>State Machine Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Machine Diagram</em>'.
	 * @generated
	 */
	StateMachineDiagram createStateMachineDiagram();

	/**
	 * Returns a new object of class '<em>Collaboration Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collaboration Diagram</em>'.
	 * @generated
	 */
	CollaborationDiagram createCollaborationDiagram();

	/**
	 * Returns a new object of class '<em>Domain Chart</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Domain Chart</em>'.
	 * @generated
	 */
	DomainChart createDomainChart();

	/**
	 * Returns a new object of class '<em>Use Case Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Case Diagram</em>'.
	 * @generated
	 */
	UseCaseDiagram createUseCaseDiagram();

	/**
	 * Returns a new object of class '<em>Activity Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Diagram</em>'.
	 * @generated
	 */
	ActivityDiagram createActivityDiagram();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiagramPackage getDiagramPackage();

} //DiagramFactory
