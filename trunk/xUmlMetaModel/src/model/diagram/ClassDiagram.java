/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model.diagram;

import model.Association;
import model.Named;
import model.ObjectConstraintLanguage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.diagram.ClassDiagram#getClass_ <em>Class</em>}</li>
 *   <li>{@link model.diagram.ClassDiagram#getAssociation <em>Association</em>}</li>
 *   <li>{@link model.diagram.ClassDiagram#getConstraints <em>Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.diagram.DiagramPackage#getClassDiagram()
 * @model
 * @generated
 */
public interface ClassDiagram extends Named {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference list.
	 * The list contents are of type {@link model.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference list.
	 * @see model.diagram.DiagramPackage#getClassDiagram_Class()
	 * @model
	 * @generated
	 */
	EList<model.Class> getClass_();

	/**
	 * Returns the value of the '<em><b>Association</b></em>' reference list.
	 * The list contents are of type {@link model.Association}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Association</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Association</em>' reference list.
	 * @see model.diagram.DiagramPackage#getClassDiagram_Association()
	 * @model
	 * @generated
	 */
	EList<Association> getAssociation();

	/**
	 * Returns the value of the '<em><b>Constraints</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraints</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraints</em>' reference.
	 * @see #setConstraints(ObjectConstraintLanguage)
	 * @see model.diagram.DiagramPackage#getClassDiagram_Constraints()
	 * @model
	 * @generated
	 */
	ObjectConstraintLanguage getConstraints();

	/**
	 * Sets the value of the '{@link model.diagram.ClassDiagram#getConstraints <em>Constraints</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Constraints</em>' reference.
	 * @see #getConstraints()
	 * @generated
	 */
	void setConstraints(ObjectConstraintLanguage value);

} // ClassDiagram
