/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package model;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association End Persistence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link model.AssociationEndPersistence#isLazyFetch <em>Lazy Fetch</em>}</li>
 *   <li>{@link model.AssociationEndPersistence#getOrderBy <em>Order By</em>}</li>
 * </ul>
 * </p>
 *
 * @see model.ModelPackage#getAssociationEndPersistence()
 * @model
 * @generated
 */
public interface AssociationEndPersistence extends EObject {
	/**
	 * Returns the value of the '<em><b>Lazy Fetch</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lazy Fetch</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lazy Fetch</em>' attribute.
	 * @see #setLazyFetch(boolean)
	 * @see model.ModelPackage#getAssociationEndPersistence_LazyFetch()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isLazyFetch();

	/**
	 * Sets the value of the '{@link model.AssociationEndPersistence#isLazyFetch <em>Lazy Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lazy Fetch</em>' attribute.
	 * @see #isLazyFetch()
	 * @generated
	 */
	void setLazyFetch(boolean value);

	/**
	 * Returns the value of the '<em><b>Order By</b></em>' reference list.
	 * The list contents are of type {@link model.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Order By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Order By</em>' reference list.
	 * @see model.ModelPackage#getAssociationEndPersistence_OrderBy()
	 * @model keys="name"
	 * @generated
	 */
	EList<Attribute> getOrderBy();

} // AssociationEndPersistence
