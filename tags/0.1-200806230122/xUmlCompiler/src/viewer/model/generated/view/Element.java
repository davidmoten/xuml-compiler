/**
 * <copyright>
 * </copyright>
 *
 * $Id: Element.java,v 1.1 2008/06/18 06:18:12 dxm Exp $
 */
package view;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link view.Element#getName <em>Name</em>}</li>
 *   <li>{@link view.Element#getFixedTo <em>Fixed To</em>}</li>
 *   <li>{@link view.Element#getDimension <em>Dimension</em>}</li>
 * </ul>
 * </p>
 *
 * @see view.ViewPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends Location {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see view.ViewPackage#getElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link view.Element#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Fixed To</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fixed To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fixed To</em>' reference.
	 * @see #setFixedTo(Location)
	 * @see view.ViewPackage#getElement_FixedTo()
	 * @model
	 * @generated
	 */
	Location getFixedTo();

	/**
	 * Sets the value of the '{@link view.Element#getFixedTo <em>Fixed To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fixed To</em>' reference.
	 * @see #getFixedTo()
	 * @generated
	 */
	void setFixedTo(Location value);

	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' reference.
	 * @see #setDimension(Dimension)
	 * @see view.ViewPackage#getElement_Dimension()
	 * @model
	 * @generated
	 */
	Dimension getDimension();

	/**
	 * Sets the value of the '{@link view.Element#getDimension <em>Dimension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dimension</em>' reference.
	 * @see #getDimension()
	 * @generated
	 */
	void setDimension(Dimension value);

} // Element
