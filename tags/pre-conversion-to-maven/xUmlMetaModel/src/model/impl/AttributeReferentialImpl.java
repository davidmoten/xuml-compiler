/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import java.util.Collection;

import model.AssociationEnd;
import model.AttributeReferential;
import model.IdentifierNonPrimary;
import model.IdentifierPrimary;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Referential</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.AttributeReferentialImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.AttributeReferentialImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.AttributeReferentialImpl#getAssociationEnd <em>Association End</em>}</li>
 *   <li>{@link model.impl.AttributeReferentialImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.impl.AttributeReferentialImpl#getIdentifierPrimary <em>Identifier Primary</em>}</li>
 *   <li>{@link model.impl.AttributeReferentialImpl#getIdentifierNonPrimary <em>Identifier Non Primary</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributeReferentialImpl extends EObjectImpl implements AttributeReferential {
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
	 * The cached value of the '{@link #getAssociationEnd() <em>Association End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociationEnd()
	 * @generated
	 * @ordered
	 */
	protected AssociationEnd associationEnd;

	/**
	 * The cached value of the '{@link #getIdentifierPrimary() <em>Identifier Primary</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierPrimary()
	 * @generated
	 * @ordered
	 */
	protected EList<IdentifierPrimary> identifierPrimary;

	/**
	 * The cached value of the '{@link #getIdentifierNonPrimary() <em>Identifier Non Primary</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifierNonPrimary()
	 * @generated
	 * @ordered
	 */
	protected EList<IdentifierNonPrimary> identifierNonPrimary;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeReferentialImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ATTRIBUTE_REFERENTIAL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_REFERENTIAL__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_REFERENTIAL__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd getAssociationEnd() {
		if (associationEnd != null && associationEnd.eIsProxy()) {
			InternalEObject oldAssociationEnd = (InternalEObject)associationEnd;
			associationEnd = (AssociationEnd)eResolveProxy(oldAssociationEnd);
			if (associationEnd != oldAssociationEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END, oldAssociationEnd, associationEnd));
			}
		}
		return associationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssociationEnd basicGetAssociationEnd() {
		return associationEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociationEnd(AssociationEnd newAssociationEnd, NotificationChain msgs) {
		AssociationEnd oldAssociationEnd = associationEnd;
		associationEnd = newAssociationEnd;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END, oldAssociationEnd, newAssociationEnd);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociationEnd(AssociationEnd newAssociationEnd) {
		if (newAssociationEnd != associationEnd) {
			NotificationChain msgs = null;
			if (associationEnd != null)
				msgs = ((InternalEObject)associationEnd).eInverseRemove(this, ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE, AssociationEnd.class, msgs);
			if (newAssociationEnd != null)
				msgs = ((InternalEObject)newAssociationEnd).eInverseAdd(this, ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE, AssociationEnd.class, msgs);
			msgs = basicSetAssociationEnd(newAssociationEnd, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END, newAssociationEnd, newAssociationEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Class getClass_() {
		if (eContainerFeatureID != ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS) return null;
		return (model.Class)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClass(model.Class newClass, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClass, ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(model.Class newClass) {
		if (newClass != eInternalContainer() || (eContainerFeatureID != ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS && newClass != null)) {
			if (EcoreUtil.isAncestor(this, newClass))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newClass != null)
				msgs = ((InternalEObject)newClass).eInverseAdd(this, ModelPackage.CLASS__ATTRIBUTE_REFERENTIAL, model.Class.class, msgs);
			msgs = basicSetClass(newClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS, newClass, newClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdentifierPrimary> getIdentifierPrimary() {
		if (identifierPrimary == null) {
			identifierPrimary = new EObjectWithInverseResolvingEList.ManyInverse<IdentifierPrimary>(IdentifierPrimary.class, this, ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY, ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL);
		}
		return identifierPrimary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IdentifierNonPrimary> getIdentifierNonPrimary() {
		if (identifierNonPrimary == null) {
			identifierNonPrimary = new EObjectWithInverseResolvingEList.ManyInverse<IdentifierNonPrimary>(IdentifierNonPrimary.class, this, ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY, ModelPackage.IDENTIFIER_NON_PRIMARY__ATTRIBUTE_REFERENTIAL);
		}
		return identifierNonPrimary;
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
			case ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END:
				if (associationEnd != null)
					msgs = ((InternalEObject)associationEnd).eInverseRemove(this, ModelPackage.ASSOCIATION_END__DERIVED_ATTRIBUTE, AssociationEnd.class, msgs);
				return basicSetAssociationEnd((AssociationEnd)otherEnd, msgs);
			case ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetClass((model.Class)otherEnd, msgs);
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIdentifierPrimary()).basicAdd(otherEnd, msgs);
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIdentifierNonPrimary()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END:
				return basicSetAssociationEnd(null, msgs);
			case ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS:
				return basicSetClass(null, msgs);
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY:
				return ((InternalEList<?>)getIdentifierPrimary()).basicRemove(otherEnd, msgs);
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY:
				return ((InternalEList<?>)getIdentifierNonPrimary()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS:
				return eInternalContainer().eInverseRemove(this, ModelPackage.CLASS__ATTRIBUTE_REFERENTIAL, model.Class.class, msgs);
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
			case ModelPackage.ATTRIBUTE_REFERENTIAL__NAME:
				return getName();
			case ModelPackage.ATTRIBUTE_REFERENTIAL__DESCRIPTION:
				return getDescription();
			case ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END:
				if (resolve) return getAssociationEnd();
				return basicGetAssociationEnd();
			case ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS:
				return getClass_();
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY:
				return getIdentifierPrimary();
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY:
				return getIdentifierNonPrimary();
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
			case ModelPackage.ATTRIBUTE_REFERENTIAL__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END:
				setAssociationEnd((AssociationEnd)newValue);
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS:
				setClass((model.Class)newValue);
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY:
				getIdentifierPrimary().clear();
				getIdentifierPrimary().addAll((Collection<? extends IdentifierPrimary>)newValue);
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY:
				getIdentifierNonPrimary().clear();
				getIdentifierNonPrimary().addAll((Collection<? extends IdentifierNonPrimary>)newValue);
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
			case ModelPackage.ATTRIBUTE_REFERENTIAL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END:
				setAssociationEnd((AssociationEnd)null);
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS:
				setClass((model.Class)null);
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY:
				getIdentifierPrimary().clear();
				return;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY:
				getIdentifierNonPrimary().clear();
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
			case ModelPackage.ATTRIBUTE_REFERENTIAL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.ATTRIBUTE_REFERENTIAL__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.ATTRIBUTE_REFERENTIAL__ASSOCIATION_END:
				return associationEnd != null;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__CLASS:
				return getClass_() != null;
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY:
				return identifierPrimary != null && !identifierPrimary.isEmpty();
			case ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_NON_PRIMARY:
				return identifierNonPrimary != null && !identifierNonPrimary.isEmpty();
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

} //AttributeReferentialImpl
