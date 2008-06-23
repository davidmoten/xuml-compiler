/**
 * <copyright>
 * </copyright>
 *
 * $Id: AssociationEndSecondaryImpl.java,v 1.4 2008/06/11 07:28:43 dxm Exp $
 */
package model.impl;

import model.Association;
import model.AssociationEndSecondary;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Association End Secondary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.AssociationEndSecondaryImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.impl.AssociationEndSecondaryImpl#getAssociation <em>Association</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssociationEndSecondaryImpl extends AssociationEndImpl implements AssociationEndSecondary {
	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected model.Class class_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AssociationEndSecondaryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ASSOCIATION_END_SECONDARY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Class getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject)class_;
			class_ = (model.Class)eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.ASSOCIATION_END_SECONDARY__CLASS, oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.Class basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClass(model.Class newClass, NotificationChain msgs) {
		model.Class oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END_SECONDARY__CLASS, oldClass, newClass);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(model.Class newClass) {
		if (newClass != class_) {
			NotificationChain msgs = null;
			if (class_ != null)
				msgs = ((InternalEObject)class_).eInverseRemove(this, ModelPackage.CLASS__ASSOCIATION_END_SECONDARY, model.Class.class, msgs);
			if (newClass != null)
				msgs = ((InternalEObject)newClass).eInverseAdd(this, ModelPackage.CLASS__ASSOCIATION_END_SECONDARY, model.Class.class, msgs);
			msgs = basicSetClass(newClass, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END_SECONDARY__CLASS, newClass, newClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Association getAssociation() {
		if (eContainerFeatureID != ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION) return null;
		return (Association)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAssociation(Association newAssociation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAssociation, ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssociation(Association newAssociation) {
		if (newAssociation != eInternalContainer() || (eContainerFeatureID != ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION && newAssociation != null)) {
			if (EcoreUtil.isAncestor(this, newAssociation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAssociation != null)
				msgs = ((InternalEObject)newAssociation).eInverseAdd(this, ModelPackage.ASSOCIATION__SECONDARY, Association.class, msgs);
			msgs = basicSetAssociation(newAssociation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION, newAssociation, newAssociation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION_END_SECONDARY__CLASS:
				if (class_ != null)
					msgs = ((InternalEObject)class_).eInverseRemove(this, ModelPackage.CLASS__ASSOCIATION_END_SECONDARY, model.Class.class, msgs);
				return basicSetClass((model.Class)otherEnd, msgs);
			case ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAssociation((Association)otherEnd, msgs);
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
			case ModelPackage.ASSOCIATION_END_SECONDARY__CLASS:
				return basicSetClass(null, msgs);
			case ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION:
				return basicSetAssociation(null, msgs);
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
			case ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION:
				return eInternalContainer().eInverseRemove(this, ModelPackage.ASSOCIATION__SECONDARY, Association.class, msgs);
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
			case ModelPackage.ASSOCIATION_END_SECONDARY__CLASS:
				if (resolve) return getClass_();
				return basicGetClass();
			case ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION:
				return getAssociation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.ASSOCIATION_END_SECONDARY__CLASS:
				setClass((model.Class)newValue);
				return;
			case ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION:
				setAssociation((Association)newValue);
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
			case ModelPackage.ASSOCIATION_END_SECONDARY__CLASS:
				setClass((model.Class)null);
				return;
			case ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION:
				setAssociation((Association)null);
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
			case ModelPackage.ASSOCIATION_END_SECONDARY__CLASS:
				return class_ != null;
			case ModelPackage.ASSOCIATION_END_SECONDARY__ASSOCIATION:
				return getAssociation() != null;
		}
		return super.eIsSet(featureID);
	}

} //AssociationEndSecondaryImpl
