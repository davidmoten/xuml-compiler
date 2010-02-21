/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.diagram.impl;

import java.util.Collection;

import model.Association;
import model.ObjectConstraintLanguage;

import model.diagram.ClassDiagram;
import model.diagram.DiagramPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link model.diagram.impl.ClassDiagramImpl#getName <em>Name</em>}</li>
 *   <li>{@link model.diagram.impl.ClassDiagramImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link model.diagram.impl.ClassDiagramImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.diagram.impl.ClassDiagramImpl#getAssociation <em>Association</em>}</li>
 *   <li>{@link model.diagram.impl.ClassDiagramImpl#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassDiagramImpl extends EObjectImpl implements ClassDiagram {
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
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected EList<model.Class> class_;

	/**
	 * The cached value of the '{@link #getAssociation() <em>Association</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociation()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> association;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected ObjectConstraintLanguage constraints;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.CLASS_DIAGRAM;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.CLASS_DIAGRAM__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.CLASS_DIAGRAM__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<model.Class> getClass_() {
		if (class_ == null) {
			class_ = new EObjectResolvingEList<model.Class>(model.Class.class, this, DiagramPackage.CLASS_DIAGRAM__CLASS);
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getAssociation() {
		if (association == null) {
			association = new EObjectResolvingEList<Association>(Association.class, this, DiagramPackage.CLASS_DIAGRAM__ASSOCIATION);
		}
		return association;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectConstraintLanguage getConstraints() {
		if (constraints != null && constraints.eIsProxy()) {
			InternalEObject oldConstraints = (InternalEObject)constraints;
			constraints = (ObjectConstraintLanguage)eResolveProxy(oldConstraints);
			if (constraints != oldConstraints) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagramPackage.CLASS_DIAGRAM__CONSTRAINTS, oldConstraints, constraints));
			}
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectConstraintLanguage basicGetConstraints() {
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstraints(ObjectConstraintLanguage newConstraints) {
		ObjectConstraintLanguage oldConstraints = constraints;
		constraints = newConstraints;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.CLASS_DIAGRAM__CONSTRAINTS, oldConstraints, constraints));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramPackage.CLASS_DIAGRAM__NAME:
				return getName();
			case DiagramPackage.CLASS_DIAGRAM__DESCRIPTION:
				return getDescription();
			case DiagramPackage.CLASS_DIAGRAM__CLASS:
				return getClass_();
			case DiagramPackage.CLASS_DIAGRAM__ASSOCIATION:
				return getAssociation();
			case DiagramPackage.CLASS_DIAGRAM__CONSTRAINTS:
				if (resolve) return getConstraints();
				return basicGetConstraints();
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
			case DiagramPackage.CLASS_DIAGRAM__NAME:
				setName((String)newValue);
				return;
			case DiagramPackage.CLASS_DIAGRAM__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DiagramPackage.CLASS_DIAGRAM__CLASS:
				getClass_().clear();
				getClass_().addAll((Collection<? extends model.Class>)newValue);
				return;
			case DiagramPackage.CLASS_DIAGRAM__ASSOCIATION:
				getAssociation().clear();
				getAssociation().addAll((Collection<? extends Association>)newValue);
				return;
			case DiagramPackage.CLASS_DIAGRAM__CONSTRAINTS:
				setConstraints((ObjectConstraintLanguage)newValue);
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
			case DiagramPackage.CLASS_DIAGRAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagramPackage.CLASS_DIAGRAM__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DiagramPackage.CLASS_DIAGRAM__CLASS:
				getClass_().clear();
				return;
			case DiagramPackage.CLASS_DIAGRAM__ASSOCIATION:
				getAssociation().clear();
				return;
			case DiagramPackage.CLASS_DIAGRAM__CONSTRAINTS:
				setConstraints((ObjectConstraintLanguage)null);
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
			case DiagramPackage.CLASS_DIAGRAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagramPackage.CLASS_DIAGRAM__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DiagramPackage.CLASS_DIAGRAM__CLASS:
				return class_ != null && !class_.isEmpty();
			case DiagramPackage.CLASS_DIAGRAM__ASSOCIATION:
				return association != null && !association.isEmpty();
			case DiagramPackage.CLASS_DIAGRAM__CONSTRAINTS:
				return constraints != null;
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

} //ClassDiagramImpl
