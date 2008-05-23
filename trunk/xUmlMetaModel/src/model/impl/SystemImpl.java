/**
 * <copyright>
 * </copyright>
 *
 * $Id: SystemImpl.java,v 1.2 2008/05/23 05:15:17 dxm Exp $
 */
package model.impl;

import java.util.Collection;

import model.Association;
import model.Event;
import model.FreeType;
import model.ModelPackage;
import model.ObjectConstraintLanguage;
import model.PrimitiveType;

import model.activity.ActorUseCase;

import model.collaboration.Collaborator;
import model.collaboration.Communication;

import model.domain.Bridge;
import model.domain.Domain;

import model.use.UnitTest;
import model.use.UseCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.SystemImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getCollaborator <em>Collaborator</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getCommunication <em>Communication</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getBridge <em>Bridge</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getUseCase <em>Use Case</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getActorUseCase <em>Actor Use Case</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getUnitTest <em>Unit Test</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getEvent <em>Event</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getFreeType <em>Free Type</em>}</li>
 *   <li>{@link model.impl.SystemImpl#getPrimitiveType <em>Primitive Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SystemImpl extends EObjectImpl implements model.System {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected EList<model.Package> package_;

	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> association;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectConstraintLanguage> constraint;

	/**
	 * The cached value of the '{@link #getCollaborator() <em>Collaborator</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollaborator()
	 * @generated
	 * @ordered
	 */
	protected EList<Collaborator> collaborator;

	/**
	 * The cached value of the '{@link #getCommunication() <em>Communication</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommunication()
	 * @generated
	 * @ordered
	 */
	protected EList<Communication> communication;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected EList<Domain> domain;

	/**
	 * The cached value of the '{@link #getBridge() <em>Bridge</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBridge()
	 * @generated
	 * @ordered
	 */
	protected EList<Bridge> bridge;

	/**
	 * The cached value of the '{@link #getUseCase() <em>Use Case</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCase()
	 * @generated
	 * @ordered
	 */
	protected EList<UseCase> useCase;

	/**
	 * The cached value of the '{@link #getActorUseCase() <em>Actor Use Case</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActorUseCase()
	 * @generated
	 * @ordered
	 */
	protected EList<ActorUseCase> actorUseCase;

	/**
	 * The cached value of the '{@link #getUnitTest() <em>Unit Test</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnitTest()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitTest> unitTest;

	/**
	 * The cached value of the '{@link #getEvent() <em>Event</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvent()
	 * @generated
	 * @ordered
	 */
	protected EList<Event> event;

	/**
	 * The cached value of the '{@link #getFreeType() <em>Free Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFreeType()
	 * @generated
	 * @ordered
	 */
	protected EList<FreeType> freeType;

	/**
	 * The cached value of the '{@link #getPrimitiveType() <em>Primitive Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveType()
	 * @generated
	 * @ordered
	 */
	protected EList<PrimitiveType> primitiveType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.SYSTEM__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<model.Package> getPackage() {
		if (package_ == null) {
			package_ = new EObjectContainmentEList<model.Package>(model.Package.class, this, ModelPackage.SYSTEM__PACKAGE);
		}
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getAssociation() {
		if (association == null) {
			association = new EObjectContainmentEList<Association>(Association.class, this, ModelPackage.SYSTEM__ASSOCIATION);
		}
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectConstraintLanguage> getConstraint() {
		if (constraint == null) {
			constraint = new EObjectContainmentEList<ObjectConstraintLanguage>(ObjectConstraintLanguage.class, this, ModelPackage.SYSTEM__CONSTRAINT);
		}
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Collaborator> getCollaborator() {
		if (collaborator == null) {
			collaborator = new EObjectContainmentEList<Collaborator>(Collaborator.class, this, ModelPackage.SYSTEM__COLLABORATOR);
		}
		return collaborator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Communication> getCommunication() {
		if (communication == null) {
			communication = new EObjectContainmentEList<Communication>(Communication.class, this, ModelPackage.SYSTEM__COMMUNICATION);
		}
		return communication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Domain> getDomain() {
		if (domain == null) {
			domain = new EObjectContainmentEList<Domain>(Domain.class, this, ModelPackage.SYSTEM__DOMAIN);
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Bridge> getBridge() {
		if (bridge == null) {
			bridge = new EObjectContainmentEList<Bridge>(Bridge.class, this, ModelPackage.SYSTEM__BRIDGE);
		}
		return bridge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UseCase> getUseCase() {
		if (useCase == null) {
			useCase = new EObjectContainmentEList<UseCase>(UseCase.class, this, ModelPackage.SYSTEM__USE_CASE);
		}
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ActorUseCase> getActorUseCase() {
		if (actorUseCase == null) {
			actorUseCase = new EObjectContainmentEList<ActorUseCase>(ActorUseCase.class, this, ModelPackage.SYSTEM__ACTOR_USE_CASE);
		}
		return actorUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitTest> getUnitTest() {
		if (unitTest == null) {
			unitTest = new EObjectContainmentEList<UnitTest>(UnitTest.class, this, ModelPackage.SYSTEM__UNIT_TEST);
		}
		return unitTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Event> getEvent() {
		if (event == null) {
			event = new EObjectContainmentEList<Event>(Event.class, this, ModelPackage.SYSTEM__EVENT);
		}
		return event;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FreeType> getFreeType() {
		if (freeType == null) {
			freeType = new EObjectContainmentWithInverseEList<FreeType>(FreeType.class, this, ModelPackage.SYSTEM__FREE_TYPE, ModelPackage.FREE_TYPE__SYSTEM);
		}
		return freeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrimitiveType> getPrimitiveType() {
		if (primitiveType == null) {
			primitiveType = new EObjectContainmentWithInverseEList<PrimitiveType>(PrimitiveType.class, this, ModelPackage.SYSTEM__PRIMITIVE_TYPE, ModelPackage.PRIMITIVE_TYPE__SYSTEM);
		}
		return primitiveType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean passesTest(UnitTest test) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SYSTEM__FREE_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFreeType()).basicAdd(otherEnd, msgs);
			case ModelPackage.SYSTEM__PRIMITIVE_TYPE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPrimitiveType()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.SYSTEM__PACKAGE:
				return ((InternalEList<?>)getPackage()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__ASSOCIATION:
				return ((InternalEList<?>)getAssociation()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__CONSTRAINT:
				return ((InternalEList<?>)getConstraint()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__COLLABORATOR:
				return ((InternalEList<?>)getCollaborator()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__COMMUNICATION:
				return ((InternalEList<?>)getCommunication()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__DOMAIN:
				return ((InternalEList<?>)getDomain()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__BRIDGE:
				return ((InternalEList<?>)getBridge()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__USE_CASE:
				return ((InternalEList<?>)getUseCase()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__ACTOR_USE_CASE:
				return ((InternalEList<?>)getActorUseCase()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__UNIT_TEST:
				return ((InternalEList<?>)getUnitTest()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__EVENT:
				return ((InternalEList<?>)getEvent()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__FREE_TYPE:
				return ((InternalEList<?>)getFreeType()).basicRemove(otherEnd, msgs);
			case ModelPackage.SYSTEM__PRIMITIVE_TYPE:
				return ((InternalEList<?>)getPrimitiveType()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.SYSTEM__NAME:
				return getName();
			case ModelPackage.SYSTEM__DESCRIPTION:
				return getDescription();
			case ModelPackage.SYSTEM__PACKAGE:
				return getPackage();
			case ModelPackage.SYSTEM__ASSOCIATION:
				return getAssociation();
			case ModelPackage.SYSTEM__CONSTRAINT:
				return getConstraint();
			case ModelPackage.SYSTEM__COLLABORATOR:
				return getCollaborator();
			case ModelPackage.SYSTEM__COMMUNICATION:
				return getCommunication();
			case ModelPackage.SYSTEM__DOMAIN:
				return getDomain();
			case ModelPackage.SYSTEM__BRIDGE:
				return getBridge();
			case ModelPackage.SYSTEM__USE_CASE:
				return getUseCase();
			case ModelPackage.SYSTEM__ACTOR_USE_CASE:
				return getActorUseCase();
			case ModelPackage.SYSTEM__UNIT_TEST:
				return getUnitTest();
			case ModelPackage.SYSTEM__EVENT:
				return getEvent();
			case ModelPackage.SYSTEM__FREE_TYPE:
				return getFreeType();
			case ModelPackage.SYSTEM__PRIMITIVE_TYPE:
				return getPrimitiveType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.SYSTEM__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.SYSTEM__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.SYSTEM__PACKAGE:
				getPackage().clear();
				getPackage().addAll((Collection<? extends model.Package>)newValue);
				return;
			case ModelPackage.SYSTEM__ASSOCIATION:
				getAssociation().clear();
				getAssociation().addAll((Collection<? extends Association>)newValue);
				return;
			case ModelPackage.SYSTEM__CONSTRAINT:
				getConstraint().clear();
				getConstraint().addAll((Collection<? extends ObjectConstraintLanguage>)newValue);
				return;
			case ModelPackage.SYSTEM__COLLABORATOR:
				getCollaborator().clear();
				getCollaborator().addAll((Collection<? extends Collaborator>)newValue);
				return;
			case ModelPackage.SYSTEM__COMMUNICATION:
				getCommunication().clear();
				getCommunication().addAll((Collection<? extends Communication>)newValue);
				return;
			case ModelPackage.SYSTEM__DOMAIN:
				getDomain().clear();
				getDomain().addAll((Collection<? extends Domain>)newValue);
				return;
			case ModelPackage.SYSTEM__BRIDGE:
				getBridge().clear();
				getBridge().addAll((Collection<? extends Bridge>)newValue);
				return;
			case ModelPackage.SYSTEM__USE_CASE:
				getUseCase().clear();
				getUseCase().addAll((Collection<? extends UseCase>)newValue);
				return;
			case ModelPackage.SYSTEM__ACTOR_USE_CASE:
				getActorUseCase().clear();
				getActorUseCase().addAll((Collection<? extends ActorUseCase>)newValue);
				return;
			case ModelPackage.SYSTEM__UNIT_TEST:
				getUnitTest().clear();
				getUnitTest().addAll((Collection<? extends UnitTest>)newValue);
				return;
			case ModelPackage.SYSTEM__EVENT:
				getEvent().clear();
				getEvent().addAll((Collection<? extends Event>)newValue);
				return;
			case ModelPackage.SYSTEM__FREE_TYPE:
				getFreeType().clear();
				getFreeType().addAll((Collection<? extends FreeType>)newValue);
				return;
			case ModelPackage.SYSTEM__PRIMITIVE_TYPE:
				getPrimitiveType().clear();
				getPrimitiveType().addAll((Collection<? extends PrimitiveType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.SYSTEM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.SYSTEM__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.SYSTEM__PACKAGE:
				getPackage().clear();
				return;
			case ModelPackage.SYSTEM__ASSOCIATION:
				getAssociation().clear();
				return;
			case ModelPackage.SYSTEM__CONSTRAINT:
				getConstraint().clear();
				return;
			case ModelPackage.SYSTEM__COLLABORATOR:
				getCollaborator().clear();
				return;
			case ModelPackage.SYSTEM__COMMUNICATION:
				getCommunication().clear();
				return;
			case ModelPackage.SYSTEM__DOMAIN:
				getDomain().clear();
				return;
			case ModelPackage.SYSTEM__BRIDGE:
				getBridge().clear();
				return;
			case ModelPackage.SYSTEM__USE_CASE:
				getUseCase().clear();
				return;
			case ModelPackage.SYSTEM__ACTOR_USE_CASE:
				getActorUseCase().clear();
				return;
			case ModelPackage.SYSTEM__UNIT_TEST:
				getUnitTest().clear();
				return;
			case ModelPackage.SYSTEM__EVENT:
				getEvent().clear();
				return;
			case ModelPackage.SYSTEM__FREE_TYPE:
				getFreeType().clear();
				return;
			case ModelPackage.SYSTEM__PRIMITIVE_TYPE:
				getPrimitiveType().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.SYSTEM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.SYSTEM__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.SYSTEM__PACKAGE:
				return package_ != null && !package_.isEmpty();
			case ModelPackage.SYSTEM__ASSOCIATION:
				return association != null && !association.isEmpty();
			case ModelPackage.SYSTEM__CONSTRAINT:
				return constraint != null && !constraint.isEmpty();
			case ModelPackage.SYSTEM__COLLABORATOR:
				return collaborator != null && !collaborator.isEmpty();
			case ModelPackage.SYSTEM__COMMUNICATION:
				return communication != null && !communication.isEmpty();
			case ModelPackage.SYSTEM__DOMAIN:
				return domain != null && !domain.isEmpty();
			case ModelPackage.SYSTEM__BRIDGE:
				return bridge != null && !bridge.isEmpty();
			case ModelPackage.SYSTEM__USE_CASE:
				return useCase != null && !useCase.isEmpty();
			case ModelPackage.SYSTEM__ACTOR_USE_CASE:
				return actorUseCase != null && !actorUseCase.isEmpty();
			case ModelPackage.SYSTEM__UNIT_TEST:
				return unitTest != null && !unitTest.isEmpty();
			case ModelPackage.SYSTEM__EVENT:
				return event != null && !event.isEmpty();
			case ModelPackage.SYSTEM__FREE_TYPE:
				return freeType != null && !freeType.isEmpty();
			case ModelPackage.SYSTEM__PRIMITIVE_TYPE:
				return primitiveType != null && !primitiveType.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //SystemImpl
