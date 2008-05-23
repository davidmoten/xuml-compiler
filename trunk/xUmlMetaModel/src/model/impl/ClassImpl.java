/**
 * <copyright>
 * </copyright>
 *
 * $Id: ClassImpl.java,v 1.2 2008/05/23 05:15:15 dxm Exp $
 */
package model.impl;

import java.util.Collection;

import model.AssociationEndPrimary;
import model.AssociationEndSecondary;
import model.Attribute;
import model.AttributeDerived;
import model.ClassPersistence;
import model.IdentifierNonPrimary;
import model.IdentifierPrimary;
import model.ModelPackage;
import model.ObjectConstraintLanguage;
import model.Operation;
import model.SpecializationGroup;
import model.StateMachine;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.ClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getAttributeDerived <em>Attribute Derived</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getStateMachine <em>State Machine</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getIdentifierPrimary <em>Identifier Primary</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getIdentifierNonPrimary <em>Identifier Non Primary</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getAssociationEndPrimary <em>Association End Primary</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getAssociationEndSecondary <em>Association End Secondary</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getPersistence <em>Persistence</em>}</li>
 *   <li>{@link model.impl.ClassImpl#getSpecializationGroup <em>Specialization Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends EObjectImpl implements model.Class {
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
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attribute;

	/**
	 * The cached value of the '{@link #getAttributeDerived() <em>Attribute Derived</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeDerived()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeDerived> attributeDerived;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected EList<Operation> operation;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected ObjectConstraintLanguage constraints;

	/**
	 * The cached value of the '{@link #getStateMachine() <em>State Machine</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateMachine()
	 * @generated
	 * @ordered
	 */
	protected StateMachine stateMachine;

	/**
	 * The cached value of the '{@link #getIdentifierPrimary() <em>Identifier Primary</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierPrimary()
	 * @generated
	 * @ordered
	 */
	protected IdentifierPrimary identifierPrimary;

	/**
	 * The cached value of the '{@link #getIdentifierNonPrimary() <em>Identifier Non Primary</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierNonPrimary()
	 * @generated
	 * @ordered
	 */
	protected EList<IdentifierNonPrimary> identifierNonPrimary;

	/**
	 * The cached value of the '{@link #getAssociationEndPrimary() <em>Association End Primary</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationEndPrimary()
	 * @generated
	 * @ordered
	 */
	protected EList<AssociationEndPrimary> associationEndPrimary;

	/**
	 * The cached value of the '{@link #getAssociationEndSecondary() <em>Association End Secondary</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationEndSecondary()
	 * @generated
	 * @ordered
	 */
	protected EList<AssociationEndSecondary> associationEndSecondary;

	/**
	 * The cached value of the '{@link #getPersistence() <em>Persistence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistence()
	 * @generated
	 * @ordered
	 */
	protected ClassPersistence persistence;

	/**
	 * The cached value of the '{@link #getSpecializationGroup() <em>Specialization Group</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpecializationGroup()
	 * @generated
	 * @ordered
	 */
	protected EList<SpecializationGroup> specializationGroup;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.CLASS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Package getPackage() {
		if (eContainerFeatureID != ModelPackage.CLASS__PACKAGE) return null;
		return (model.Package)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPackage(model.Package newPackage, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPackage, ModelPackage.CLASS__PACKAGE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackage(model.Package newPackage) {
		if (newPackage != eInternalContainer() || (eContainerFeatureID != ModelPackage.CLASS__PACKAGE && newPackage != null)) {
			if (EcoreUtil.isAncestor(this, newPackage))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPackage != null)
				msgs = ((InternalEObject)newPackage).eInverseAdd(this, ModelPackage.PACKAGE__CLASS, model.Package.class, msgs);
			msgs = basicSetPackage(newPackage, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__PACKAGE, newPackage, newPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectContainmentWithInverseEList<Attribute>(Attribute.class, this, ModelPackage.CLASS__ATTRIBUTE, ModelPackage.ATTRIBUTE__CLASS);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeDerived> getAttributeDerived() {
		if (attributeDerived == null) {
			attributeDerived = new EObjectContainmentWithInverseEList<AttributeDerived>(AttributeDerived.class, this, ModelPackage.CLASS__ATTRIBUTE_DERIVED, ModelPackage.ATTRIBUTE_DERIVED__CLASS);
		}
		return attributeDerived;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Operation> getOperation() {
		if (operation == null) {
			operation = new EObjectContainmentEList<Operation>(Operation.class, this, ModelPackage.CLASS__OPERATION);
		}
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectConstraintLanguage getConstraints() {
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstraints(ObjectConstraintLanguage newConstraints, NotificationChain msgs) {
		ObjectConstraintLanguage oldConstraints = constraints;
		constraints = newConstraints;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__CONSTRAINTS, oldConstraints, newConstraints);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraints(ObjectConstraintLanguage newConstraints) {
		if (newConstraints != constraints) {
			NotificationChain msgs = null;
			if (constraints != null)
				msgs = ((InternalEObject)constraints).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS__CONSTRAINTS, null, msgs);
			if (newConstraints != null)
				msgs = ((InternalEObject)newConstraints).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS__CONSTRAINTS, null, msgs);
			msgs = basicSetConstraints(newConstraints, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__CONSTRAINTS, newConstraints, newConstraints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMachine getStateMachine() {
		return stateMachine;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateMachine(StateMachine newStateMachine, NotificationChain msgs) {
		StateMachine oldStateMachine = stateMachine;
		stateMachine = newStateMachine;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__STATE_MACHINE, oldStateMachine, newStateMachine);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateMachine(StateMachine newStateMachine) {
		if (newStateMachine != stateMachine) {
			NotificationChain msgs = null;
			if (stateMachine != null)
				msgs = ((InternalEObject)stateMachine).eInverseRemove(this, ModelPackage.STATE_MACHINE__CLASS, StateMachine.class, msgs);
			if (newStateMachine != null)
				msgs = ((InternalEObject)newStateMachine).eInverseAdd(this, ModelPackage.STATE_MACHINE__CLASS, StateMachine.class, msgs);
			msgs = basicSetStateMachine(newStateMachine, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__STATE_MACHINE, newStateMachine, newStateMachine));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierPrimary getIdentifierPrimary() {
		return identifierPrimary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifierPrimary(IdentifierPrimary newIdentifierPrimary, NotificationChain msgs) {
		IdentifierPrimary oldIdentifierPrimary = identifierPrimary;
		identifierPrimary = newIdentifierPrimary;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__IDENTIFIER_PRIMARY, oldIdentifierPrimary, newIdentifierPrimary);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifierPrimary(IdentifierPrimary newIdentifierPrimary) {
		if (newIdentifierPrimary != identifierPrimary) {
			NotificationChain msgs = null;
			if (identifierPrimary != null)
				msgs = ((InternalEObject)identifierPrimary).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS__IDENTIFIER_PRIMARY, null, msgs);
			if (newIdentifierPrimary != null)
				msgs = ((InternalEObject)newIdentifierPrimary).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS__IDENTIFIER_PRIMARY, null, msgs);
			msgs = basicSetIdentifierPrimary(newIdentifierPrimary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__IDENTIFIER_PRIMARY, newIdentifierPrimary, newIdentifierPrimary));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdentifierNonPrimary> getIdentifierNonPrimary() {
		if (identifierNonPrimary == null) {
			identifierNonPrimary = new EObjectContainmentEList<IdentifierNonPrimary>(IdentifierNonPrimary.class, this, ModelPackage.CLASS__IDENTIFIER_NON_PRIMARY);
		}
		return identifierNonPrimary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssociationEndPrimary> getAssociationEndPrimary() {
		if (associationEndPrimary == null) {
			associationEndPrimary = new EObjectWithInverseResolvingEList<AssociationEndPrimary>(AssociationEndPrimary.class, this, ModelPackage.CLASS__ASSOCIATION_END_PRIMARY, ModelPackage.ASSOCIATION_END_PRIMARY__CLASS);
		}
		return associationEndPrimary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AssociationEndSecondary> getAssociationEndSecondary() {
		if (associationEndSecondary == null) {
			associationEndSecondary = new EObjectWithInverseResolvingEList<AssociationEndSecondary>(AssociationEndSecondary.class, this, ModelPackage.CLASS__ASSOCIATION_END_SECONDARY, ModelPackage.ASSOCIATION_END_SECONDARY__CLASS);
		}
		return associationEndSecondary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassPersistence getPersistence() {
		return persistence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPersistence(ClassPersistence newPersistence, NotificationChain msgs) {
		ClassPersistence oldPersistence = persistence;
		persistence = newPersistence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__PERSISTENCE, oldPersistence, newPersistence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPersistence(ClassPersistence newPersistence) {
		if (newPersistence != persistence) {
			NotificationChain msgs = null;
			if (persistence != null)
				msgs = ((InternalEObject)persistence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS__PERSISTENCE, null, msgs);
			if (newPersistence != null)
				msgs = ((InternalEObject)newPersistence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS__PERSISTENCE, null, msgs);
			msgs = basicSetPersistence(newPersistence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.CLASS__PERSISTENCE, newPersistence, newPersistence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SpecializationGroup> getSpecializationGroup() {
		if (specializationGroup == null) {
			specializationGroup = new EObjectContainmentWithInverseEList<SpecializationGroup>(SpecializationGroup.class, this, ModelPackage.CLASS__SPECIALIZATION_GROUP, ModelPackage.SPECIALIZATION_GROUP__SUPER_CLASS);
		}
		return specializationGroup;
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
			case ModelPackage.CLASS__PACKAGE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPackage((model.Package)otherEnd, msgs);
			case ModelPackage.CLASS__ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttribute()).basicAdd(otherEnd, msgs);
			case ModelPackage.CLASS__ATTRIBUTE_DERIVED:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributeDerived()).basicAdd(otherEnd, msgs);
			case ModelPackage.CLASS__STATE_MACHINE:
				if (stateMachine != null)
					msgs = ((InternalEObject)stateMachine).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.CLASS__STATE_MACHINE, null, msgs);
				return basicSetStateMachine((StateMachine)otherEnd, msgs);
			case ModelPackage.CLASS__ASSOCIATION_END_PRIMARY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationEndPrimary()).basicAdd(otherEnd, msgs);
			case ModelPackage.CLASS__ASSOCIATION_END_SECONDARY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAssociationEndSecondary()).basicAdd(otherEnd, msgs);
			case ModelPackage.CLASS__SPECIALIZATION_GROUP:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSpecializationGroup()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.CLASS__PACKAGE:
				return basicSetPackage(null, msgs);
			case ModelPackage.CLASS__ATTRIBUTE:
				return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS__ATTRIBUTE_DERIVED:
				return ((InternalEList<?>)getAttributeDerived()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS__OPERATION:
				return ((InternalEList<?>)getOperation()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS__CONSTRAINTS:
				return basicSetConstraints(null, msgs);
			case ModelPackage.CLASS__STATE_MACHINE:
				return basicSetStateMachine(null, msgs);
			case ModelPackage.CLASS__IDENTIFIER_PRIMARY:
				return basicSetIdentifierPrimary(null, msgs);
			case ModelPackage.CLASS__IDENTIFIER_NON_PRIMARY:
				return ((InternalEList<?>)getIdentifierNonPrimary()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS__ASSOCIATION_END_PRIMARY:
				return ((InternalEList<?>)getAssociationEndPrimary()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS__ASSOCIATION_END_SECONDARY:
				return ((InternalEList<?>)getAssociationEndSecondary()).basicRemove(otherEnd, msgs);
			case ModelPackage.CLASS__PERSISTENCE:
				return basicSetPersistence(null, msgs);
			case ModelPackage.CLASS__SPECIALIZATION_GROUP:
				return ((InternalEList<?>)getSpecializationGroup()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case ModelPackage.CLASS__PACKAGE:
				return eInternalContainer().eInverseRemove(this, ModelPackage.PACKAGE__CLASS, model.Package.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.CLASS__NAME:
				return getName();
			case ModelPackage.CLASS__DESCRIPTION:
				return getDescription();
			case ModelPackage.CLASS__PACKAGE:
				return getPackage();
			case ModelPackage.CLASS__ATTRIBUTE:
				return getAttribute();
			case ModelPackage.CLASS__ATTRIBUTE_DERIVED:
				return getAttributeDerived();
			case ModelPackage.CLASS__OPERATION:
				return getOperation();
			case ModelPackage.CLASS__CONSTRAINTS:
				return getConstraints();
			case ModelPackage.CLASS__STATE_MACHINE:
				return getStateMachine();
			case ModelPackage.CLASS__IDENTIFIER_PRIMARY:
				return getIdentifierPrimary();
			case ModelPackage.CLASS__IDENTIFIER_NON_PRIMARY:
				return getIdentifierNonPrimary();
			case ModelPackage.CLASS__ASSOCIATION_END_PRIMARY:
				return getAssociationEndPrimary();
			case ModelPackage.CLASS__ASSOCIATION_END_SECONDARY:
				return getAssociationEndSecondary();
			case ModelPackage.CLASS__PERSISTENCE:
				return getPersistence();
			case ModelPackage.CLASS__SPECIALIZATION_GROUP:
				return getSpecializationGroup();
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
			case ModelPackage.CLASS__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.CLASS__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.CLASS__PACKAGE:
				setPackage((model.Package)newValue);
				return;
			case ModelPackage.CLASS__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ModelPackage.CLASS__ATTRIBUTE_DERIVED:
				getAttributeDerived().clear();
				getAttributeDerived().addAll((Collection<? extends AttributeDerived>)newValue);
				return;
			case ModelPackage.CLASS__OPERATION:
				getOperation().clear();
				getOperation().addAll((Collection<? extends Operation>)newValue);
				return;
			case ModelPackage.CLASS__CONSTRAINTS:
				setConstraints((ObjectConstraintLanguage)newValue);
				return;
			case ModelPackage.CLASS__STATE_MACHINE:
				setStateMachine((StateMachine)newValue);
				return;
			case ModelPackage.CLASS__IDENTIFIER_PRIMARY:
				setIdentifierPrimary((IdentifierPrimary)newValue);
				return;
			case ModelPackage.CLASS__IDENTIFIER_NON_PRIMARY:
				getIdentifierNonPrimary().clear();
				getIdentifierNonPrimary().addAll((Collection<? extends IdentifierNonPrimary>)newValue);
				return;
			case ModelPackage.CLASS__ASSOCIATION_END_PRIMARY:
				getAssociationEndPrimary().clear();
				getAssociationEndPrimary().addAll((Collection<? extends AssociationEndPrimary>)newValue);
				return;
			case ModelPackage.CLASS__ASSOCIATION_END_SECONDARY:
				getAssociationEndSecondary().clear();
				getAssociationEndSecondary().addAll((Collection<? extends AssociationEndSecondary>)newValue);
				return;
			case ModelPackage.CLASS__PERSISTENCE:
				setPersistence((ClassPersistence)newValue);
				return;
			case ModelPackage.CLASS__SPECIALIZATION_GROUP:
				getSpecializationGroup().clear();
				getSpecializationGroup().addAll((Collection<? extends SpecializationGroup>)newValue);
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
			case ModelPackage.CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.CLASS__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.CLASS__PACKAGE:
				setPackage((model.Package)null);
				return;
			case ModelPackage.CLASS__ATTRIBUTE:
				getAttribute().clear();
				return;
			case ModelPackage.CLASS__ATTRIBUTE_DERIVED:
				getAttributeDerived().clear();
				return;
			case ModelPackage.CLASS__OPERATION:
				getOperation().clear();
				return;
			case ModelPackage.CLASS__CONSTRAINTS:
				setConstraints((ObjectConstraintLanguage)null);
				return;
			case ModelPackage.CLASS__STATE_MACHINE:
				setStateMachine((StateMachine)null);
				return;
			case ModelPackage.CLASS__IDENTIFIER_PRIMARY:
				setIdentifierPrimary((IdentifierPrimary)null);
				return;
			case ModelPackage.CLASS__IDENTIFIER_NON_PRIMARY:
				getIdentifierNonPrimary().clear();
				return;
			case ModelPackage.CLASS__ASSOCIATION_END_PRIMARY:
				getAssociationEndPrimary().clear();
				return;
			case ModelPackage.CLASS__ASSOCIATION_END_SECONDARY:
				getAssociationEndSecondary().clear();
				return;
			case ModelPackage.CLASS__PERSISTENCE:
				setPersistence((ClassPersistence)null);
				return;
			case ModelPackage.CLASS__SPECIALIZATION_GROUP:
				getSpecializationGroup().clear();
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
			case ModelPackage.CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.CLASS__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.CLASS__PACKAGE:
				return getPackage() != null;
			case ModelPackage.CLASS__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case ModelPackage.CLASS__ATTRIBUTE_DERIVED:
				return attributeDerived != null && !attributeDerived.isEmpty();
			case ModelPackage.CLASS__OPERATION:
				return operation != null && !operation.isEmpty();
			case ModelPackage.CLASS__CONSTRAINTS:
				return constraints != null;
			case ModelPackage.CLASS__STATE_MACHINE:
				return stateMachine != null;
			case ModelPackage.CLASS__IDENTIFIER_PRIMARY:
				return identifierPrimary != null;
			case ModelPackage.CLASS__IDENTIFIER_NON_PRIMARY:
				return identifierNonPrimary != null && !identifierNonPrimary.isEmpty();
			case ModelPackage.CLASS__ASSOCIATION_END_PRIMARY:
				return associationEndPrimary != null && !associationEndPrimary.isEmpty();
			case ModelPackage.CLASS__ASSOCIATION_END_SECONDARY:
				return associationEndSecondary != null && !associationEndSecondary.isEmpty();
			case ModelPackage.CLASS__PERSISTENCE:
				return persistence != null;
			case ModelPackage.CLASS__SPECIALIZATION_GROUP:
				return specializationGroup != null && !specializationGroup.isEmpty();
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

} //ClassImpl
