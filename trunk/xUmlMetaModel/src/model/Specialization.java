/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specialization</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.Specialization#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getSpecialization()
 * @model
 * @generated
 */
public interface Specialization extends model.Class {
	/**
	 * Returns the value of the '<em><b>Group</b></em>' reference list.
	 * The list contents are of type {@link model.SpecializationGroup}.
	 * It is bidirectional and its opposite is '{@link model.SpecializationGroup#getSpecialization <em>Specialization</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group</em>' reference list.
	 * @see model.ModelPackage#getSpecialization_Group()
	 * @see model.SpecializationGroup#getSpecialization
	 * @model opposite="specialization" required="true"
	 * @generated
	 */
	EList<SpecializationGroup> getGroup();

} // Specialization
