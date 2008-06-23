/**
 * <copyright>
 * </copyright>
 *
 * $Id: System.java,v 1.4 2008/06/11 07:28:41 dxm Exp $
 */
package model;

import model.activity.ActorUseCase;

import model.collaboration.Collaborator;
import model.collaboration.Communication;

import model.domain.Bridge;
import model.domain.Domain;

import model.use.UnitTest;
import model.use.UseCase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.System#getPackage <em>Package</em>}</li>
 *   <li>{@link model.System#getAssociation <em>Association</em>}</li>
 *   <li>{@link model.System#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link model.System#getCollaborator <em>Collaborator</em>}</li>
 *   <li>{@link model.System#getCommunication <em>Communication</em>}</li>
 *   <li>{@link model.System#getDomain <em>Domain</em>}</li>
 *   <li>{@link model.System#getBridge <em>Bridge</em>}</li>
 *   <li>{@link model.System#getUseCase <em>Use Case</em>}</li>
 *   <li>{@link model.System#getActorUseCase <em>Actor Use Case</em>}</li>
 *   <li>{@link model.System#getUnitTest <em>Unit Test</em>}</li>
 *   <li>{@link model.System#getEvent <em>Event</em>}</li>
 *   <li>{@link model.System#getFreeType <em>Free Type</em>}</li>
 *   <li>{@link model.System#getPrimitiveType <em>Primitive Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends Named {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' containment reference list.
	 * The list contents are of type {@link model.Package}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_Package()
	 * @model containment="true"
	 * @generated
	 */
	EList<model.Package> getPackage();

	/**
	 * Returns the value of the '<em><b>Association</b></em>' containment reference list.
	 * The list contents are of type {@link model.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_Association()
	 * @model containment="true"
	 * @generated
	 */
	EList<Association> getAssociation();

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' containment reference list.
	 * The list contents are of type {@link model.ObjectConstraintLanguage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_Constraint()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObjectConstraintLanguage> getConstraint();

	/**
	 * Returns the value of the '<em><b>Collaborator</b></em>' containment reference list.
	 * The list contents are of type {@link model.collaboration.Collaborator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collaborator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collaborator</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_Collaborator()
	 * @model containment="true"
	 * @generated
	 */
	EList<Collaborator> getCollaborator();

	/**
	 * Returns the value of the '<em><b>Communication</b></em>' containment reference list.
	 * The list contents are of type {@link model.collaboration.Communication}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Communication</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Communication</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_Communication()
	 * @model containment="true"
	 * @generated
	 */
	EList<Communication> getCommunication();

	/**
	 * Returns the value of the '<em><b>Domain</b></em>' containment reference list.
	 * The list contents are of type {@link model.domain.Domain}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_Domain()
	 * @model containment="true"
	 * @generated
	 */
	EList<Domain> getDomain();

	/**
	 * Returns the value of the '<em><b>Bridge</b></em>' containment reference list.
	 * The list contents are of type {@link model.domain.Bridge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bridge</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bridge</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_Bridge()
	 * @model containment="true"
	 * @generated
	 */
	EList<Bridge> getBridge();

	/**
	 * Returns the value of the '<em><b>Use Case</b></em>' containment reference list.
	 * The list contents are of type {@link model.use.UseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Case</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Case</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_UseCase()
	 * @model containment="true"
	 * @generated
	 */
	EList<UseCase> getUseCase();

	/**
	 * Returns the value of the '<em><b>Actor Use Case</b></em>' containment reference list.
	 * The list contents are of type {@link model.activity.ActorUseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actor Use Case</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actor Use Case</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_ActorUseCase()
	 * @model containment="true"
	 * @generated
	 */
	EList<ActorUseCase> getActorUseCase();

	/**
	 * Returns the value of the '<em><b>Unit Test</b></em>' containment reference list.
	 * The list contents are of type {@link model.use.UnitTest}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unit Test</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unit Test</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_UnitTest()
	 * @model containment="true"
	 * @generated
	 */
	EList<UnitTest> getUnitTest();

	/**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference list.
	 * The list contents are of type {@link model.Event}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Event</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_Event()
	 * @model containment="true"
	 * @generated
	 */
	EList<Event> getEvent();

	/**
	 * Returns the value of the '<em><b>Free Type</b></em>' containment reference list.
	 * The list contents are of type {@link model.FreeType}.
	 * It is bidirectional and its opposite is '{@link model.FreeType#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Free Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Free Type</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_FreeType()
	 * @see model.FreeType#getSystem
	 * @model opposite="system" containment="true" keys="name"
	 * @generated
	 */
	EList<FreeType> getFreeType();

	/**
	 * Returns the value of the '<em><b>Primitive Type</b></em>' containment reference list.
	 * The list contents are of type {@link model.PrimitiveType}.
	 * It is bidirectional and its opposite is '{@link model.PrimitiveType#getSystem <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Type</em>' containment reference list.
	 * @see model.ModelPackage#getSystem_PrimitiveType()
	 * @see model.PrimitiveType#getSystem
	 * @model opposite="system" containment="true" keys="name"
	 * @generated
	 */
	EList<PrimitiveType> getPrimitiveType();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean passesTest(UnitTest test);

} // System
