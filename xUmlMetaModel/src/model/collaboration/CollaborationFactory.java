/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.collaboration;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see model.collaboration.CollaborationPackage
 * @generated
 */
public interface CollaborationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CollaborationFactory eINSTANCE = model.collaboration.impl.CollaborationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object</em>'.
	 * @generated
	 */
	model.collaboration.Object createObject();

	/**
	 * Returns a new object of class '<em>Collaborator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collaborator</em>'.
	 * @generated
	 */
	Collaborator createCollaborator();

	/**
	 * Returns a new object of class '<em>Communication</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication</em>'.
	 * @generated
	 */
	Communication createCommunication();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CollaborationPackage getCollaborationPackage();

} //CollaborationFactory
