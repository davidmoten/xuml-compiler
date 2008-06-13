/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActivityPackage.java,v 1.4 2008/06/11 07:28:43 dxm Exp $
 */
package model.activity;

import model.ModelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see model.activity.ActivityFactory
 * @model kind="package"
 * @generated
 */
public interface ActivityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "activity";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://davidmoten.homeip.net/uml/executable/model/activity";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model.activity";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ActivityPackage eINSTANCE = model.activity.impl.ActivityPackageImpl.init();

	/**
	 * The meta object id for the '{@link model.activity.impl.ActivityImpl <em>Activity</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.activity.impl.ActivityImpl
	 * @see model.activity.impl.ActivityPackageImpl#getActivity()
	 * @generated
	 */
	int ACTIVITY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__NAME = ModelPackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__DESCRIPTION = ModelPackage.NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Signal Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY__SIGNAL_EVENT = ModelPackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Activity</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_FEATURE_COUNT = ModelPackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.activity.impl.ActivityNodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.activity.impl.ActivityNodeImpl
	 * @see model.activity.impl.ActivityPackageImpl#getActivityNode()
	 * @generated
	 */
	int ACTIVITY_NODE = 5;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVITY_NODE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link model.activity.impl.ActorUseCaseImpl <em>Actor Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.activity.impl.ActorUseCaseImpl
	 * @see model.activity.impl.ActivityPackageImpl#getActorUseCase()
	 * @generated
	 */
	int ACTOR_USE_CASE = 1;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_USE_CASE__ACTOR = ACTIVITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_USE_CASE__ACTIVITY = ACTIVITY_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Next Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_USE_CASE__NEXT_NODE = ACTIVITY_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Actor Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_USE_CASE_FEATURE_COUNT = ACTIVITY_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link model.activity.impl.ConditionalImpl <em>Conditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.activity.impl.ConditionalImpl
	 * @see model.activity.impl.ActivityPackageImpl#getConditional()
	 * @generated
	 */
	int CONDITIONAL = 2;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL__CONDITION = ACTIVITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Next Node On True</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL__NEXT_NODE_ON_TRUE = ACTIVITY_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Next Node On False</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL__NEXT_NODE_ON_FALSE = ACTIVITY_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Conditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_FEATURE_COUNT = ACTIVITY_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link model.activity.impl.ForkImpl <em>Fork</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.activity.impl.ForkImpl
	 * @see model.activity.impl.ActivityPackageImpl#getFork()
	 * @generated
	 */
	int FORK = 3;

	/**
	 * The feature id for the '<em><b>Next Node</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK__NEXT_NODE = ACTIVITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fork</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FORK_FEATURE_COUNT = ACTIVITY_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link model.activity.impl.JoinImpl <em>Join</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.activity.impl.JoinImpl
	 * @see model.activity.impl.ActivityPackageImpl#getJoin()
	 * @generated
	 */
	int JOIN = 4;

	/**
	 * The feature id for the '<em><b>Next Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN__NEXT_NODE = ACTIVITY_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Join</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOIN_FEATURE_COUNT = ACTIVITY_NODE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link model.activity.Activity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Activity</em>'.
	 * @see model.activity.Activity
	 * @generated
	 */
	EClass getActivity();

	/**
	 * Returns the meta object for the reference '{@link model.activity.Activity#getSignalEvent <em>Signal Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Signal Event</em>'.
	 * @see model.activity.Activity#getSignalEvent()
	 * @see #getActivity()
	 * @generated
	 */
	EReference getActivity_SignalEvent();

	/**
	 * Returns the meta object for class '{@link model.activity.ActorUseCase <em>Actor Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor Use Case</em>'.
	 * @see model.activity.ActorUseCase
	 * @generated
	 */
	EClass getActorUseCase();

	/**
	 * Returns the meta object for the reference '{@link model.activity.ActorUseCase#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see model.activity.ActorUseCase#getActor()
	 * @see #getActorUseCase()
	 * @generated
	 */
	EReference getActorUseCase_Actor();

	/**
	 * Returns the meta object for the reference '{@link model.activity.ActorUseCase#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity</em>'.
	 * @see model.activity.ActorUseCase#getActivity()
	 * @see #getActorUseCase()
	 * @generated
	 */
	EReference getActorUseCase_Activity();

	/**
	 * Returns the meta object for the reference '{@link model.activity.ActorUseCase#getNextNode <em>Next Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Node</em>'.
	 * @see model.activity.ActorUseCase#getNextNode()
	 * @see #getActorUseCase()
	 * @generated
	 */
	EReference getActorUseCase_NextNode();

	/**
	 * Returns the meta object for class '{@link model.activity.Conditional <em>Conditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional</em>'.
	 * @see model.activity.Conditional
	 * @generated
	 */
	EClass getConditional();

	/**
	 * Returns the meta object for the reference '{@link model.activity.Conditional#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see model.activity.Conditional#getCondition()
	 * @see #getConditional()
	 * @generated
	 */
	EReference getConditional_Condition();

	/**
	 * Returns the meta object for the reference '{@link model.activity.Conditional#getNextNodeOnTrue <em>Next Node On True</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Node On True</em>'.
	 * @see model.activity.Conditional#getNextNodeOnTrue()
	 * @see #getConditional()
	 * @generated
	 */
	EReference getConditional_NextNodeOnTrue();

	/**
	 * Returns the meta object for the reference '{@link model.activity.Conditional#getNextNodeOnFalse <em>Next Node On False</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Node On False</em>'.
	 * @see model.activity.Conditional#getNextNodeOnFalse()
	 * @see #getConditional()
	 * @generated
	 */
	EReference getConditional_NextNodeOnFalse();

	/**
	 * Returns the meta object for class '{@link model.activity.Fork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fork</em>'.
	 * @see model.activity.Fork
	 * @generated
	 */
	EClass getFork();

	/**
	 * Returns the meta object for the reference list '{@link model.activity.Fork#getNextNode <em>Next Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Next Node</em>'.
	 * @see model.activity.Fork#getNextNode()
	 * @see #getFork()
	 * @generated
	 */
	EReference getFork_NextNode();

	/**
	 * Returns the meta object for class '{@link model.activity.Join <em>Join</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Join</em>'.
	 * @see model.activity.Join
	 * @generated
	 */
	EClass getJoin();

	/**
	 * Returns the meta object for the reference '{@link model.activity.Join#getNextNode <em>Next Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Node</em>'.
	 * @see model.activity.Join#getNextNode()
	 * @see #getJoin()
	 * @generated
	 */
	EReference getJoin_NextNode();

	/**
	 * Returns the meta object for class '{@link model.activity.ActivityNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see model.activity.ActivityNode
	 * @generated
	 */
	EClass getActivityNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActivityFactory getActivityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link model.activity.impl.ActivityImpl <em>Activity</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.activity.impl.ActivityImpl
		 * @see model.activity.impl.ActivityPackageImpl#getActivity()
		 * @generated
		 */
		EClass ACTIVITY = eINSTANCE.getActivity();

		/**
		 * The meta object literal for the '<em><b>Signal Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTIVITY__SIGNAL_EVENT = eINSTANCE.getActivity_SignalEvent();

		/**
		 * The meta object literal for the '{@link model.activity.impl.ActorUseCaseImpl <em>Actor Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.activity.impl.ActorUseCaseImpl
		 * @see model.activity.impl.ActivityPackageImpl#getActorUseCase()
		 * @generated
		 */
		EClass ACTOR_USE_CASE = eINSTANCE.getActorUseCase();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_USE_CASE__ACTOR = eINSTANCE.getActorUseCase_Actor();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_USE_CASE__ACTIVITY = eINSTANCE.getActorUseCase_Activity();

		/**
		 * The meta object literal for the '<em><b>Next Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTOR_USE_CASE__NEXT_NODE = eINSTANCE.getActorUseCase_NextNode();

		/**
		 * The meta object literal for the '{@link model.activity.impl.ConditionalImpl <em>Conditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.activity.impl.ConditionalImpl
		 * @see model.activity.impl.ActivityPackageImpl#getConditional()
		 * @generated
		 */
		EClass CONDITIONAL = eINSTANCE.getConditional();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL__CONDITION = eINSTANCE.getConditional_Condition();

		/**
		 * The meta object literal for the '<em><b>Next Node On True</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL__NEXT_NODE_ON_TRUE = eINSTANCE.getConditional_NextNodeOnTrue();

		/**
		 * The meta object literal for the '<em><b>Next Node On False</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL__NEXT_NODE_ON_FALSE = eINSTANCE.getConditional_NextNodeOnFalse();

		/**
		 * The meta object literal for the '{@link model.activity.impl.ForkImpl <em>Fork</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.activity.impl.ForkImpl
		 * @see model.activity.impl.ActivityPackageImpl#getFork()
		 * @generated
		 */
		EClass FORK = eINSTANCE.getFork();

		/**
		 * The meta object literal for the '<em><b>Next Node</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FORK__NEXT_NODE = eINSTANCE.getFork_NextNode();

		/**
		 * The meta object literal for the '{@link model.activity.impl.JoinImpl <em>Join</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.activity.impl.JoinImpl
		 * @see model.activity.impl.ActivityPackageImpl#getJoin()
		 * @generated
		 */
		EClass JOIN = eINSTANCE.getJoin();

		/**
		 * The meta object literal for the '<em><b>Next Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOIN__NEXT_NODE = eINSTANCE.getJoin_NextNode();

		/**
		 * The meta object literal for the '{@link model.activity.impl.ActivityNodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.activity.impl.ActivityNodeImpl
		 * @see model.activity.impl.ActivityPackageImpl#getActivityNode()
		 * @generated
		 */
		EClass ACTIVITY_NODE = eINSTANCE.getActivityNode();

	}

} //ActivityPackage
