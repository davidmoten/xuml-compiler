/**
 * <copyright>
 * </copyright>
 *
 * $Id: IdentifierPrimaryImpl.java,v 1.4 2008/06/11 07:28:43 dxm Exp $
 */
package model.impl;

import java.util.Collection;

import model.Attribute;
import model.AttributeReferential;
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
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Identifier Primary</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.IdentifierPrimaryImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.IdentifierPrimaryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.IdentifierPrimaryImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link model.impl.IdentifierPrimaryImpl#getAttributeReferential <em>Attribute Referential</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IdentifierPrimaryImpl extends EObjectImpl implements IdentifierPrimary {
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
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attribute;

	/**
	 * The cached value of the '{@link #getAttributeReferential() <em>Attribute Referential</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeReferential()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeReferential> attributeReferential;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IdentifierPrimaryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.IDENTIFIER_PRIMARY;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.IDENTIFIER_PRIMARY__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.IDENTIFIER_PRIMARY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectWithInverseResolvingEList<Attribute>(Attribute.class, this, ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE, ModelPackage.ATTRIBUTE__IDENTIFIER_PRIMARY);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AttributeReferential> getAttributeReferential() {
		if (attributeReferential == null) {
			attributeReferential = new EObjectWithInverseResolvingEList.ManyInverse<AttributeReferential>(AttributeReferential.class, this, ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL, ModelPackage.ATTRIBUTE_REFERENTIAL__IDENTIFIER_PRIMARY);
		}
		return attributeReferential;
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
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttribute()).basicAdd(otherEnd, msgs);
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAttributeReferential()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE:
				return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL:
				return ((InternalEList<?>)getAttributeReferential()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.IDENTIFIER_PRIMARY__NAME:
				return getName();
			case ModelPackage.IDENTIFIER_PRIMARY__DESCRIPTION:
				return getDescription();
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE:
				return getAttribute();
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL:
				return getAttributeReferential();
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
			case ModelPackage.IDENTIFIER_PRIMARY__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.IDENTIFIER_PRIMARY__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL:
				getAttributeReferential().clear();
				getAttributeReferential().addAll((Collection<? extends AttributeReferential>)newValue);
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
			case ModelPackage.IDENTIFIER_PRIMARY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.IDENTIFIER_PRIMARY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE:
				getAttribute().clear();
				return;
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL:
				getAttributeReferential().clear();
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
			case ModelPackage.IDENTIFIER_PRIMARY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.IDENTIFIER_PRIMARY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case ModelPackage.IDENTIFIER_PRIMARY__ATTRIBUTE_REFERENTIAL:
				return attributeReferential != null && !attributeReferential.isEmpty();
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

} //IdentifierPrimaryImpl
