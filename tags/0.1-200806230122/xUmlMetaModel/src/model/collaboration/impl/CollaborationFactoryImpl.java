/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollaborationFactoryImpl.java,v 1.4 2008/06/11 07:28:47 dxm Exp $
 */
package model.collaboration.impl;

import model.collaboration.CollaborationFactory;
import model.collaboration.CollaborationPackage;
import model.collaboration.Collaborator;
import model.collaboration.Communication;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CollaborationFactoryImpl extends EFactoryImpl implements CollaborationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CollaborationFactory init() {
		try {
			CollaborationFactory theCollaborationFactory = (CollaborationFactory)EPackage.Registry.INSTANCE.getEFactory("http://davidmoten.homeip.net/uml/executable/model/collaboration"); 
			if (theCollaborationFactory != null) {
				return theCollaborationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CollaborationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollaborationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CollaborationPackage.OBJECT: return createObject();
			case CollaborationPackage.COLLABORATOR: return createCollaborator();
			case CollaborationPackage.COMMUNICATION: return createCommunication();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.collaboration.Object createObject() {
		ObjectImpl object = new ObjectImpl();
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collaborator createCollaborator() {
		CollaboratorImpl collaborator = new CollaboratorImpl();
		return collaborator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Communication createCommunication() {
		CommunicationImpl communication = new CommunicationImpl();
		return communication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollaborationPackage getCollaborationPackage() {
		return (CollaborationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CollaborationPackage getPackage() {
		return CollaborationPackage.eINSTANCE;
	}

} //CollaborationFactoryImpl
