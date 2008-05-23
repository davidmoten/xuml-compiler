/**
 * <copyright>
 * </copyright>
 *
 * $Id: CollaborationPackage.java,v 1.2 2008/05/23 05:15:18 dxm Exp $
 */
package model.collaboration;

import model.ModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see model.collaboration.CollaborationFactory
 * @model kind="package"
 * @generated
 */
public interface CollaborationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "collaboration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://davidmoten.homeip.net/uml/executable/model/collaboration";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model.collaboration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CollaborationPackage eINSTANCE = model.collaboration.impl.CollaborationPackageImpl.init();

	/**
	 * The meta object id for the '{@link model.collaboration.impl.CollaboratorImpl <em>Collaborator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.collaboration.impl.CollaboratorImpl
	 * @see model.collaboration.impl.CollaborationPackageImpl#getCollaborator()
	 * @generated
	 */
	int COLLABORATOR = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATOR__NAME = ModelPackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATOR__DESCRIPTION = ModelPackage.NAMED__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Collaborator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLABORATOR_FEATURE_COUNT = ModelPackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.collaboration.impl.ObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.collaboration.impl.ObjectImpl
	 * @see model.collaboration.impl.CollaborationPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__NAME = COLLABORATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__DESCRIPTION = COLLABORATOR__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__CLASS = COLLABORATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FEATURE_COUNT = COLLABORATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.collaboration.impl.CommunicationImpl <em>Communication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.collaboration.impl.CommunicationImpl
	 * @see model.collaboration.impl.CollaborationPackageImpl#getCommunication()
	 * @generated
	 */
	int COMMUNICATION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__NAME = ModelPackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__DESCRIPTION = ModelPackage.NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>From Collaborator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__FROM_COLLABORATOR = ModelPackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To Collaborator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__TO_COLLABORATOR = ModelPackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Signal Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__SIGNAL_EVENT = ModelPackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION__ORDER = ModelPackage.NAMED_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Communication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_FEATURE_COUNT = ModelPackage.NAMED_FEATURE_COUNT + 4;


	/**
	 * Returns the meta object for class '{@link model.collaboration.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see model.collaboration.Object
	 * @generated
	 */
	EClass getObject();

	/**
	 * Returns the meta object for the reference '{@link model.collaboration.Object#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see model.collaboration.Object#getClass_()
	 * @see #getObject()
	 * @generated
	 */
	EReference getObject_Class();

	/**
	 * Returns the meta object for class '{@link model.collaboration.Collaborator <em>Collaborator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collaborator</em>'.
	 * @see model.collaboration.Collaborator
	 * @generated
	 */
	EClass getCollaborator();

	/**
	 * Returns the meta object for class '{@link model.collaboration.Communication <em>Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication</em>'.
	 * @see model.collaboration.Communication
	 * @generated
	 */
	EClass getCommunication();

	/**
	 * Returns the meta object for the reference '{@link model.collaboration.Communication#getFromCollaborator <em>From Collaborator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>From Collaborator</em>'.
	 * @see model.collaboration.Communication#getFromCollaborator()
	 * @see #getCommunication()
	 * @generated
	 */
	EReference getCommunication_FromCollaborator();

	/**
	 * Returns the meta object for the reference '{@link model.collaboration.Communication#getToCollaborator <em>To Collaborator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>To Collaborator</em>'.
	 * @see model.collaboration.Communication#getToCollaborator()
	 * @see #getCommunication()
	 * @generated
	 */
	EReference getCommunication_ToCollaborator();

	/**
	 * Returns the meta object for the reference '{@link model.collaboration.Communication#getSignalEvent <em>Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal Event</em>'.
	 * @see model.collaboration.Communication#getSignalEvent()
	 * @see #getCommunication()
	 * @generated
	 */
	EReference getCommunication_SignalEvent();

	/**
	 * Returns the meta object for the attribute '{@link model.collaboration.Communication#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see model.collaboration.Communication#getOrder()
	 * @see #getCommunication()
	 * @generated
	 */
	EAttribute getCommunication_Order();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CollaborationFactory getCollaborationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link model.collaboration.impl.ObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.collaboration.impl.ObjectImpl
		 * @see model.collaboration.impl.CollaborationPackageImpl#getObject()
		 * @generated
		 */
		EClass OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT__CLASS = eINSTANCE.getObject_Class();

		/**
		 * The meta object literal for the '{@link model.collaboration.impl.CollaboratorImpl <em>Collaborator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.collaboration.impl.CollaboratorImpl
		 * @see model.collaboration.impl.CollaborationPackageImpl#getCollaborator()
		 * @generated
		 */
		EClass COLLABORATOR = eINSTANCE.getCollaborator();

		/**
		 * The meta object literal for the '{@link model.collaboration.impl.CommunicationImpl <em>Communication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.collaboration.impl.CommunicationImpl
		 * @see model.collaboration.impl.CollaborationPackageImpl#getCommunication()
		 * @generated
		 */
		EClass COMMUNICATION = eINSTANCE.getCommunication();

		/**
		 * The meta object literal for the '<em><b>From Collaborator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION__FROM_COLLABORATOR = eINSTANCE.getCommunication_FromCollaborator();

		/**
		 * The meta object literal for the '<em><b>To Collaborator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION__TO_COLLABORATOR = eINSTANCE.getCommunication_ToCollaborator();

		/**
		 * The meta object literal for the '<em><b>Signal Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION__SIGNAL_EVENT = eINSTANCE.getCommunication_SignalEvent();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION__ORDER = eINSTANCE.getCommunication_Order();

	}

} //CollaborationPackage
