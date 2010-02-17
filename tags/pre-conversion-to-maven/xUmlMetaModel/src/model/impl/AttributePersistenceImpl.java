/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import model.AttributePersistence;
import model.ModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Persistence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.AttributePersistenceImpl#getColumn <em>Column</em>}</li>
 *   <li>{@link model.impl.AttributePersistenceImpl#isGeneratedBySequence <em>Generated By Sequence</em>}</li>
 *   <li>{@link model.impl.AttributePersistenceImpl#isGeneratedValue <em>Generated Value</em>}</li>
 *   <li>{@link model.impl.AttributePersistenceImpl#isGeneratedByIdentity <em>Generated By Identity</em>}</li>
 *   <li>{@link model.impl.AttributePersistenceImpl#getLength <em>Length</em>}</li>
 *   <li>{@link model.impl.AttributePersistenceImpl#getScale <em>Scale</em>}</li>
 *   <li>{@link model.impl.AttributePersistenceImpl#getPrecision <em>Precision</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AttributePersistenceImpl extends EObjectImpl implements AttributePersistence {
	/**
	 * The default value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getColumn() <em>Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColumn()
	 * @generated
	 * @ordered
	 */
	protected String column = COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #isGeneratedBySequence() <em>Generated By Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGeneratedBySequence()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATED_BY_SEQUENCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGeneratedBySequence() <em>Generated By Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGeneratedBySequence()
	 * @generated
	 * @ordered
	 */
	protected boolean generatedBySequence = GENERATED_BY_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isGeneratedValue() <em>Generated Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGeneratedValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATED_VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGeneratedValue() <em>Generated Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGeneratedValue()
	 * @generated
	 * @ordered
	 */
	protected boolean generatedValue = GENERATED_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #isGeneratedByIdentity() <em>Generated By Identity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGeneratedByIdentity()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GENERATED_BY_IDENTITY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGeneratedByIdentity() <em>Generated By Identity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGeneratedByIdentity()
	 * @generated
	 * @ordered
	 */
	protected boolean generatedByIdentity = GENERATED_BY_IDENTITY_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributePersistenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.ATTRIBUTE_PERSISTENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getColumn() {
		return column;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setColumn(String newColumn) {
		String oldColumn = column;
		column = newColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_PERSISTENCE__COLUMN, oldColumn, column));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGeneratedBySequence() {
		return generatedBySequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratedBySequence(boolean newGeneratedBySequence) {
		boolean oldGeneratedBySequence = generatedBySequence;
		generatedBySequence = newGeneratedBySequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_SEQUENCE, oldGeneratedBySequence, generatedBySequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGeneratedValue() {
		return generatedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratedValue(boolean newGeneratedValue) {
		boolean oldGeneratedValue = generatedValue;
		generatedValue = newGeneratedValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_VALUE, oldGeneratedValue, generatedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGeneratedByIdentity() {
		return generatedByIdentity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneratedByIdentity(boolean newGeneratedByIdentity) {
		boolean oldGeneratedByIdentity = generatedByIdentity;
		generatedByIdentity = newGeneratedByIdentity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_IDENTITY, oldGeneratedByIdentity, generatedByIdentity));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_PERSISTENCE__LENGTH, oldLength, length));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_PERSISTENCE__SCALE, oldScale, scale));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.ATTRIBUTE_PERSISTENCE__PRECISION, oldPrecision, precision));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.ATTRIBUTE_PERSISTENCE__COLUMN:
				return getColumn();
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_SEQUENCE:
				return isGeneratedBySequence() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_VALUE:
				return isGeneratedValue() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_IDENTITY:
				return isGeneratedByIdentity() ? Boolean.TRUE : Boolean.FALSE;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__LENGTH:
				return getLength();
			case ModelPackage.ATTRIBUTE_PERSISTENCE__SCALE:
				return getScale();
			case ModelPackage.ATTRIBUTE_PERSISTENCE__PRECISION:
				return getPrecision();
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
			case ModelPackage.ATTRIBUTE_PERSISTENCE__COLUMN:
				setColumn((String)newValue);
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_SEQUENCE:
				setGeneratedBySequence(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_VALUE:
				setGeneratedValue(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_IDENTITY:
				setGeneratedByIdentity(((Boolean)newValue).booleanValue());
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__LENGTH:
				setLength((Integer)newValue);
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__SCALE:
				setScale((Integer)newValue);
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__PRECISION:
				setPrecision((Integer)newValue);
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
			case ModelPackage.ATTRIBUTE_PERSISTENCE__COLUMN:
				setColumn(COLUMN_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_SEQUENCE:
				setGeneratedBySequence(GENERATED_BY_SEQUENCE_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_VALUE:
				setGeneratedValue(GENERATED_VALUE_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_IDENTITY:
				setGeneratedByIdentity(GENERATED_BY_IDENTITY_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__LENGTH:
				setLength(LENGTH_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__SCALE:
				setScale(SCALE_EDEFAULT);
				return;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__PRECISION:
				setPrecision(PRECISION_EDEFAULT);
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
			case ModelPackage.ATTRIBUTE_PERSISTENCE__COLUMN:
				return COLUMN_EDEFAULT == null ? column != null : !COLUMN_EDEFAULT.equals(column);
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_SEQUENCE:
				return generatedBySequence != GENERATED_BY_SEQUENCE_EDEFAULT;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_VALUE:
				return generatedValue != GENERATED_VALUE_EDEFAULT;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__GENERATED_BY_IDENTITY:
				return generatedByIdentity != GENERATED_BY_IDENTITY_EDEFAULT;
			case ModelPackage.ATTRIBUTE_PERSISTENCE__LENGTH:
				return LENGTH_EDEFAULT == null ? length != null : !LENGTH_EDEFAULT.equals(length);
			case ModelPackage.ATTRIBUTE_PERSISTENCE__SCALE:
				return SCALE_EDEFAULT == null ? scale != null : !SCALE_EDEFAULT.equals(scale);
			case ModelPackage.ATTRIBUTE_PERSISTENCE__PRECISION:
				return PRECISION_EDEFAULT == null ? precision != null : !PRECISION_EDEFAULT.equals(precision);
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
		result.append(" (column: ");
		result.append(column);
		result.append(", generatedBySequence: ");
		result.append(generatedBySequence);
		result.append(", generatedValue: ");
		result.append(generatedValue);
		result.append(", generatedByIdentity: ");
		result.append(generatedByIdentity);
		result.append(", length: ");
		result.append(length);
		result.append(", scale: ");
		result.append(scale);
		result.append(", precision: ");
		result.append(precision);
		result.append(')');
		return result.toString();
	}

} //AttributePersistenceImpl