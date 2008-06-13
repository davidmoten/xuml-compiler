/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActorImpl.java,v 1.4 2008/06/11 07:28:48 dxm Exp $
 */
package model.use.impl;

import model.collaboration.impl.CollaboratorImpl;

import model.use.Actor;
import model.use.UsePackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Actor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class ActorImpl extends CollaboratorImpl implements Actor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UsePackage.Literals.ACTOR;
	}

} //ActorImpl
