/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.impl;

import java.util.Collection;

import model.ModelPackage;
import model.Parameter;
import model.TimerEvent;
import model.Transition;

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
 * An implementation of the model object '<em><b>Timer Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.impl.TimerEventImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.impl.TimerEventImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.impl.TimerEventImpl#getTransition <em>Transition</em>}</li>
 *   <li>{@link model.impl.TimerEventImpl#getParameter <em>Parameter</em>}</li>
 *   <li>{@link model.impl.TimerEventImpl#getTimeMs <em>Time Ms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimerEventImpl extends EObjectImpl implements TimerEvent {
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
	 * The cached value of the '{@link #getTransition() <em>Transition</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransition()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> transition;

	/**
	 * The cached value of the '{@link #getParameter() <em>Parameter</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameter;

	/**
	 * The default value of the '{@link #getTimeMs() <em>Time Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeMs()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_MS_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTimeMs() <em>Time Ms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeMs()
	 * @generated
	 * @ordered
	 */
	protected long timeMs = TIME_MS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimerEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.TIMER_EVENT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TIMER_EVENT__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TIMER_EVENT__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getTransition() {
		if (transition == null) {
			transition = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, ModelPackage.TIMER_EVENT__TRANSITION, ModelPackage.TRANSITION__EVENT);
		}
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameter() {
		if (parameter == null) {
			parameter = new EObjectContainmentEList<Parameter>(Parameter.class, this, ModelPackage.TIMER_EVENT__PARAMETER);
		}
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimeMs() {
		return timeMs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeMs(long newTimeMs) {
		long oldTimeMs = timeMs;
		timeMs = newTimeMs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.TIMER_EVENT__TIME_MS, oldTimeMs, timeMs));
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
			case ModelPackage.TIMER_EVENT__TRANSITION:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTransition()).basicAdd(otherEnd, msgs);
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
			case ModelPackage.TIMER_EVENT__TRANSITION:
				return ((InternalEList<?>)getTransition()).basicRemove(otherEnd, msgs);
			case ModelPackage.TIMER_EVENT__PARAMETER:
				return ((InternalEList<?>)getParameter()).basicRemove(otherEnd, msgs);
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
			case ModelPackage.TIMER_EVENT__NAME:
				return getName();
			case ModelPackage.TIMER_EVENT__DESCRIPTION:
				return getDescription();
			case ModelPackage.TIMER_EVENT__TRANSITION:
				return getTransition();
			case ModelPackage.TIMER_EVENT__PARAMETER:
				return getParameter();
			case ModelPackage.TIMER_EVENT__TIME_MS:
				return new Long(getTimeMs());
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
			case ModelPackage.TIMER_EVENT__NAME:
				setName((String)newValue);
				return;
			case ModelPackage.TIMER_EVENT__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ModelPackage.TIMER_EVENT__TRANSITION:
				getTransition().clear();
				getTransition().addAll((Collection<? extends Transition>)newValue);
				return;
			case ModelPackage.TIMER_EVENT__PARAMETER:
				getParameter().clear();
				getParameter().addAll((Collection<? extends Parameter>)newValue);
				return;
			case ModelPackage.TIMER_EVENT__TIME_MS:
				setTimeMs(((Long)newValue).longValue());
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
			case ModelPackage.TIMER_EVENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelPackage.TIMER_EVENT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ModelPackage.TIMER_EVENT__TRANSITION:
				getTransition().clear();
				return;
			case ModelPackage.TIMER_EVENT__PARAMETER:
				getParameter().clear();
				return;
			case ModelPackage.TIMER_EVENT__TIME_MS:
				setTimeMs(TIME_MS_EDEFAULT);
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
			case ModelPackage.TIMER_EVENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelPackage.TIMER_EVENT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ModelPackage.TIMER_EVENT__TRANSITION:
				return transition != null && !transition.isEmpty();
			case ModelPackage.TIMER_EVENT__PARAMETER:
				return parameter != null && !parameter.isEmpty();
			case ModelPackage.TIMER_EVENT__TIME_MS:
				return timeMs != TIME_MS_EDEFAULT;
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
		result.append(", timeMs: ");
		result.append(timeMs);
		result.append(')');
		return result.toString();
	}

} //TimerEventImpl
