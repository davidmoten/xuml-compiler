/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import model.ModelPackage;
import model.Primitive;
import model.PrimitiveType;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.PrimitiveTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.PrimitiveTypeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.PrimitiveTypeImpl#getPrimitive <em>Primitive</em>}</li>
 *   <li>{@link model.impl.PrimitiveTypeImpl#getSystem <em>System</em>}</li>
 *   <li>{@link model.impl.PrimitiveTypeImpl#getPrecision <em>Precision</em>}</li>
 *   <li>{@link model.impl.PrimitiveTypeImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link model.impl.PrimitiveTypeImpl#isUtc <em>Utc</em>}</li>
 *   <li>{@link model.impl.PrimitiveTypeImpl#getLength <em>Length</em>}</li>
 *   <li>{@link model.impl.PrimitiveTypeImpl#isYesNo <em>Yes No</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrimitiveTypeImpl extends EObjectImpl implements PrimitiveType {
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
	 * The default value of the '{@link #getPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final Primitive PRIMITIVE_EDEFAULT = Primitive.BOOLEAN;

	/**
	 * The cached value of the '{@link #getPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected Primitive primitive = PRIMITIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrecision() <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecision()
	 * @generated
	 * @ordered
	 */
	protected static final Integer PRECISION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrecision() <em>Precision</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrecision()
	 * @generated
	 * @ordered
	 */
	protected Integer precision = PRECISION_EDEFAULT;

	/**
	 * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected static final Integer SCALE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected Integer scale = SCALE_EDEFAULT;

	/**
	 * The default value of the '{@link #isUtc() <em>Utc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUtc()
	 * @generated
	 * @ordered
	 */
	protected static final boolean UTC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isUtc() <em>Utc</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isUtc()
	 * @generated
	 * @ordered
	 */
	protected boolean utc = UTC_EDEFAULT;

	/**
	 * The default value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected static final Integer LENGTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLength() <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLength()
	 * @generated
	 * @ordered
	 */
	protected Integer length = LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isYesNo() <em>Yes No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isYesNo()
	 * @generated
	 * @ordered
	 */
	protected static final boolean YES_NO_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isYesNo() <em>Yes No</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isYesNo()
	 * @generated
	 * @ordered
	 */
	protected boolean yesNo = YES_NO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PrimitiveTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PRIMITIVE_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_TYPE__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_TYPE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Primitive getPrimitive() {
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitive(Primitive newPrimitive) {
		Primitive oldPrimitive = primitive;
		primitive = newPrimitive == null ? PRIMITIVE_EDEFAULT : newPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_TYPE__PRIMITIVE, oldPrimitive, primitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public model.System getSystem() {
		if (eContainerFeatureID != ModelPackage.PRIMITIVE_TYPE__SYSTEM) return null;
		return (model.System)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSystem(model.System newSystem, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSystem, ModelPackage.PRIMITIVE_TYPE__SYSTEM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSystem(model.System newSystem) {
		if (newSystem != eInternalContainer() || (eContainerFeatureID != ModelPackage.PRIMITIVE_TYPE__SYSTEM && newSystem != null)) {
			if (EcoreUtil.isAncestor(this, newSystem))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSystem != null)
				msgs = ((InternalEObject)newSystem).eInverseAdd(this, ModelPackage.SYSTEM__PRIMITIVE_TYPE, model.System.class, msgs);
			msgs = basicSetSystem(newSystem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_TYPE__SYSTEM, newSystem, newSystem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getPrecision() {
		return precision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrecision(Integer newPrecision) {
		Integer oldPrecision = precision;
		precision = newPrecision;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_TYPE__PRECISION, oldPrecision, precision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getScale() {
		return scale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScale(Integer newScale) {
		Integer oldScale = scale;
		scale = newScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_TYPE__SCALE, oldScale, scale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isUtc() {
		return utc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUtc(boolean newUtc) {
		boolean oldUtc = utc;
		utc = newUtc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_TYPE__UTC, oldUtc, utc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Integer getLength() {
		return length;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLength(Integer newLength) {
		Integer oldLength = length;
		length = newLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_TYPE__LENGTH, oldLength, length));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isYesNo() {
		return yesNo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYesNo(boolean newYesNo) {
		boolean oldYesNo = yesNo;
		yesNo = newYesNo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PRIMITIVE_TYPE__YES_NO, oldYesNo, yesNo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PRIMITIVE_TYPE__SYSTEM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSystem((model.System)otherEnd, msgs);
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
			case ModelPackage.PRIMITIVE_TYPE__SYSTEM:
				return basicSetSystem(null, msgs);
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
			case ModelPackage.PRIMITIVE_TYPE__SYSTEM:
				return eInternalContainer().eInverseRemove(this, ModelPackage.SYSTEM__PRIMITIVE_TYPE, model.System.class, msgs);
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
			case ModelPackage.PRIMITIVE_TYPE__NAME:
				return getName();
			case ModelPackage.PRIMITIVE_TYPE__DESCRIPTION:
				return getDescription();
			case ModelPackage.PRIMITIVE_TYPE__PRIMITIVE:
				return getPrimitive();
			case ModelPackage.PRIMITIVE_TYPE__SYSTEM:
				return getSystem();
			case ModelPackage.PRIMITIVE_TYPE__PRECISION:
				return getPrecision();
			case ModelPackage.PRIMITIVE_TYPE__SCALE:
				return getScale();
			case ModelPackage.PRIMITIVE_TYPE__UTC:
				return isUtc() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.PRIMITIVE_TYPE__LENGTH:
				return getLength();
			case ModelPackage.PRIMITIVE_TYPE__YES_NO:
				return isYesNo() ? Boolean.TRUE : Boolean.FALSE;
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
			case ModelPackage.PRIMITIVE_TYPE__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.PRIMITIVE_TYPE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.PRIMITIVE_TYPE__PRIMITIVE:
				setPrimitive((Primitive)newValue);
				return;
			case ModelPackage.PRIMITIVE_TYPE__SYSTEM:
				setSystem((model.System)newValue);
				return;
			case ModelPackage.PRIMITIVE_TYPE__PRECISION:
				setPrecision((Integer)newValue);
				return;
			case ModelPackage.PRIMITIVE_TYPE__SCALE:
				setScale((Integer)newValue);
				return;
			case ModelPackage.PRIMITIVE_TYPE__UTC:
				setUtc(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.PRIMITIVE_TYPE__LENGTH:
				setLength((Integer)newValue);
				return;
			case ModelPackage.PRIMITIVE_TYPE__YES_NO:
				setYesNo(((Boolean)newValue).booleanValue());
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
			case ModelPackage.PRIMITIVE_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.PRIMITIVE_TYPE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.PRIMITIVE_TYPE__PRIMITIVE:
				setPrimitive(PRIMITIVE_EDEFAULT);
				return;
			case ModelPackage.PRIMITIVE_TYPE__SYSTEM:
				setSystem((model.System)null);
				return;
			case ModelPackage.PRIMITIVE_TYPE__PRECISION:
				setPrecision(PRECISION_EDEFAULT);
				return;
			case ModelPackage.PRIMITIVE_TYPE__SCALE:
				setScale(SCALE_EDEFAULT);
				return;
			case ModelPackage.PRIMITIVE_TYPE__UTC:
				setUtc(UTC_EDEFAULT);
				return;
			case ModelPackage.PRIMITIVE_TYPE__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case ModelPackage.PRIMITIVE_TYPE__YES_NO:
				setYesNo(YES_NO_EDEFAULT);
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
			case ModelPackage.PRIMITIVE_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.PRIMITIVE_TYPE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.PRIMITIVE_TYPE__PRIMITIVE:
				return primitive != PRIMITIVE_EDEFAULT;
			case ModelPackage.PRIMITIVE_TYPE__SYSTEM:
				return getSystem() != null;
			case ModelPackage.PRIMITIVE_TYPE__PRECISION:
				return PRECISION_EDEFAULT == null ? precision != null : !PRECISION_EDEFAULT.equals(precision);
			case ModelPackage.PRIMITIVE_TYPE__SCALE:
				return SCALE_EDEFAULT == null ? scale != null : !SCALE_EDEFAULT.equals(scale);
			case ModelPackage.PRIMITIVE_TYPE__UTC:
				return utc != UTC_EDEFAULT;
			case ModelPackage.PRIMITIVE_TYPE__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case ModelPackage.PRIMITIVE_TYPE__YES_NO:
				return yesNo != YES_NO_EDEFAULT;
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
		result.append(", primitive: ");
		result.append(primitive);
		result.append(", precision: ");
		result.append(precision);
		result.append(", scale: ");
		result.append(scale);
		result.append(", utc: ");
		result.append(utc);
		result.append(", length: ");
		result.append(length);
		result.append(", yesNo: ");
		result.append(yesNo);
		result.append(')');
		return result.toString();
	}

} //PrimitiveTypeImpl
