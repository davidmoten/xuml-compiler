/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.collaboration.impl;

import model.ModelPackage;

import model.activity.ActivityPackage;

import model.activity.impl.ActivityPackageImpl;

import model.collaboration.CollaborationFactory;
import model.collaboration.CollaborationPackage;
import model.collaboration.Collaborator;
import model.collaboration.Communication;

import model.diagram.DiagramPackage;

import model.diagram.impl.DiagramPackageImpl;

import model.domain.DomainPackage;

import model.domain.impl.DomainPackageImpl;

import model.impl.ModelPackageImpl;

import model.use.UsePackage;

import model.use.impl.UsePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CollaborationPackageImpl extends EPackageImpl implements CollaborationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collaboratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass communicationEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see model.collaboration.CollaborationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CollaborationPackageImpl() {
		super(eNS_URI, CollaborationFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CollaborationPackage init() {
		if (isInited) return (CollaborationPackage)EPackage.Registry.INSTANCE.getEPackage(CollaborationPackage.eNS_URI);

		// Obtain or create and register package
		CollaborationPackageImpl theCollaborationPackage = (CollaborationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof CollaborationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new CollaborationPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		DomainPackageImpl theDomainPackage = (DomainPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) instanceof DomainPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DomainPackage.eNS_URI) : DomainPackage.eINSTANCE);
		DiagramPackageImpl theDiagramPackage = (DiagramPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI) instanceof DiagramPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI) : DiagramPackage.eINSTANCE);
		UsePackageImpl theUsePackage = (UsePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsePackage.eNS_URI) instanceof UsePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsePackage.eNS_URI) : UsePackage.eINSTANCE);
		ActivityPackageImpl theActivityPackage = (ActivityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI) instanceof ActivityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActivityPackage.eNS_URI) : ActivityPackage.eINSTANCE);

		// Create package meta-data objects
		theCollaborationPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theDomainPackage.createPackageContents();
		theDiagramPackage.createPackageContents();
		theUsePackage.createPackageContents();
		theActivityPackage.createPackageContents();

		// Initialize created meta-data
		theCollaborationPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theDomainPackage.initializePackageContents();
		theDiagramPackage.initializePackageContents();
		theUsePackage.initializePackageContents();
		theActivityPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCollaborationPackage.freeze();

		return theCollaborationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObject() {
		return objectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObject_Class() {
		return (EReference)objectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollaborator() {
		return collaboratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommunication() {
		return communicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunication_FromCollaborator() {
		return (EReference)communicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunication_ToCollaborator() {
		return (EReference)communicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCommunication_SignalEvent() {
		return (EReference)communicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCommunication_Order() {
		return (EAttribute)communicationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollaborationFactory getCollaborationFactory() {
		return (CollaborationFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		objectEClass = createEClass(OBJECT);
		createEReference(objectEClass, OBJECT__CLASS);

		collaboratorEClass = createEClass(COLLABORATOR);

		communicationEClass = createEClass(COMMUNICATION);
		createEReference(communicationEClass, COMMUNICATION__FROM_COLLABORATOR);
		createEReference(communicationEClass, COMMUNICATION__TO_COLLABORATOR);
		createEReference(communicationEClass, COMMUNICATION__SIGNAL_EVENT);
		createEAttribute(communicationEClass, COMMUNICATION__ORDER);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		objectEClass.getESuperTypes().add(this.getCollaborator());
		collaboratorEClass.getESuperTypes().add(theModelPackage.getNamed());
		communicationEClass.getESuperTypes().add(theModelPackage.getNamed());

		// Initialize classes and features; add operations and parameters
		initEClass(objectEClass, model.collaboration.Object.class, "Object", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObject_Class(), theModelPackage.getClass_(), null, "class", null, 1, 1, model.collaboration.Object.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collaboratorEClass, Collaborator.class, "Collaborator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(communicationEClass, Communication.class, "Communication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCommunication_FromCollaborator(), this.getCollaborator(), null, "fromCollaborator", null, 1, 1, Communication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommunication_ToCollaborator(), this.getCollaborator(), null, "toCollaborator", null, 1, 1, Communication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCommunication_SignalEvent(), theModelPackage.getSignalEvent(), null, "signalEvent", null, 1, 1, Communication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCommunication_Order(), ecorePackage.getEInt(), "order", null, 0, 1, Communication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //CollaborationPackageImpl
