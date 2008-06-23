/**
 * <copyright>
 * </copyright>
 *
 * $Id: UsePackage.java,v 1.4 2008/06/11 07:28:42 dxm Exp $
 */
package model.use;

import model.ModelPackage;

import model.collaboration.CollaborationPackage;

import org.eclipse.emf.ecore.EAttribute;
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
 * @see model.use.UseFactory
 * @model kind="package"
 * @generated
 */
public interface UsePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "use";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://davidmoten.homeip.net/uml/executable/model/use";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "model.use";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UsePackage eINSTANCE = model.use.impl.UsePackageImpl.init();

	/**
	 * The meta object id for the '{@link model.use.impl.ActorImpl <em>Actor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.use.impl.ActorImpl
	 * @see model.use.impl.UsePackageImpl#getActor()
	 * @generated
	 */
	int ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__NAME = CollaborationPackage.COLLABORATOR__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR__DESCRIPTION = CollaborationPackage.COLLABORATOR__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Actor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTOR_FEATURE_COUNT = CollaborationPackage.COLLABORATOR_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link model.use.impl.UseCaseImpl <em>Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.use.impl.UseCaseImpl
	 * @see model.use.impl.UsePackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 1;

	/**
	 * The feature id for the '<em><b>Actor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ACTOR = 0;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ACTIVITY = 1;

	/**
	 * The feature id for the '<em><b>Precondition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__PRECONDITION = 2;

	/**
	 * The feature id for the '<em><b>Postcondition</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__POSTCONDITION = 3;

	/**
	 * The number of structural features of the '<em>Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link model.use.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.use.impl.ConditionImpl
	 * @see model.use.impl.UsePackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link model.use.impl.UnitTestImpl <em>Unit Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.use.impl.UnitTestImpl
	 * @see model.use.impl.UsePackageImpl#getUnitTest()
	 * @generated
	 */
	int UNIT_TEST = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TEST__NAME = ModelPackage.NAMED__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TEST__DESCRIPTION = ModelPackage.NAMED__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Use Case</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TEST__USE_CASE = ModelPackage.NAMED_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Data</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TEST__PARAMETER_DATA = ModelPackage.NAMED_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unit Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_TEST_FEATURE_COUNT = ModelPackage.NAMED_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link model.use.impl.ParameterDataImpl <em>Parameter Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.use.impl.ParameterDataImpl
	 * @see model.use.impl.UsePackageImpl#getParameterData()
	 * @generated
	 */
	int PARAMETER_DATA = 4;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DATA__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DATA__DATA = 1;

	/**
	 * The number of structural features of the '<em>Parameter Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DATA_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link model.use.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see model.use.impl.DataImpl
	 * @see model.use.impl.UsePackageImpl#getData()
	 * @generated
	 */
	int DATA = 5;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link model.use.Actor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actor</em>'.
	 * @see model.use.Actor
	 * @generated
	 */
	EClass getActor();

	/**
	 * Returns the meta object for class '{@link model.use.UseCase <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case</em>'.
	 * @see model.use.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the reference '{@link model.use.UseCase#getActor <em>Actor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Actor</em>'.
	 * @see model.use.UseCase#getActor()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Actor();

	/**
	 * Returns the meta object for the reference '{@link model.use.UseCase#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Activity</em>'.
	 * @see model.use.UseCase#getActivity()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Activity();

	/**
	 * Returns the meta object for the reference list '{@link model.use.UseCase#getPrecondition <em>Precondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Precondition</em>'.
	 * @see model.use.UseCase#getPrecondition()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Precondition();

	/**
	 * Returns the meta object for the reference list '{@link model.use.UseCase#getPostcondition <em>Postcondition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Postcondition</em>'.
	 * @see model.use.UseCase#getPostcondition()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Postcondition();

	/**
	 * Returns the meta object for class '{@link model.use.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see model.use.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the attribute '{@link model.use.Condition#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see model.use.Condition#getDescription()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Description();

	/**
	 * Returns the meta object for class '{@link model.use.UnitTest <em>Unit Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Test</em>'.
	 * @see model.use.UnitTest
	 * @generated
	 */
	EClass getUnitTest();

	/**
	 * Returns the meta object for the reference '{@link model.use.UnitTest#getUseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Use Case</em>'.
	 * @see model.use.UnitTest#getUseCase()
	 * @see #getUnitTest()
	 * @generated
	 */
	EReference getUnitTest_UseCase();

	/**
	 * Returns the meta object for the containment reference list '{@link model.use.UnitTest#getParameterData <em>Parameter Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Data</em>'.
	 * @see model.use.UnitTest#getParameterData()
	 * @see #getUnitTest()
	 * @generated
	 */
	EReference getUnitTest_ParameterData();

	/**
	 * Returns the meta object for class '{@link model.use.ParameterData <em>Parameter Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Data</em>'.
	 * @see model.use.ParameterData
	 * @generated
	 */
	EClass getParameterData();

	/**
	 * Returns the meta object for the containment reference '{@link model.use.ParameterData#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Parameter</em>'.
	 * @see model.use.ParameterData#getParameter()
	 * @see #getParameterData()
	 * @generated
	 */
	EReference getParameterData_Parameter();

	/**
	 * Returns the meta object for the containment reference '{@link model.use.ParameterData#getData <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data</em>'.
	 * @see model.use.ParameterData#getData()
	 * @see #getParameterData()
	 * @generated
	 */
	EReference getParameterData_Data();

	/**
	 * Returns the meta object for class '{@link model.use.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see model.use.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UseFactory getUseFactory();

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
		 * The meta object literal for the '{@link model.use.impl.ActorImpl <em>Actor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.use.impl.ActorImpl
		 * @see model.use.impl.UsePackageImpl#getActor()
		 * @generated
		 */
		EClass ACTOR = eINSTANCE.getActor();

		/**
		 * The meta object literal for the '{@link model.use.impl.UseCaseImpl <em>Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.use.impl.UseCaseImpl
		 * @see model.use.impl.UsePackageImpl#getUseCase()
		 * @generated
		 */
		EClass USE_CASE = eINSTANCE.getUseCase();

		/**
		 * The meta object literal for the '<em><b>Actor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__ACTOR = eINSTANCE.getUseCase_Actor();

		/**
		 * The meta object literal for the '<em><b>Activity</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__ACTIVITY = eINSTANCE.getUseCase_Activity();

		/**
		 * The meta object literal for the '<em><b>Precondition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__PRECONDITION = eINSTANCE.getUseCase_Precondition();

		/**
		 * The meta object literal for the '<em><b>Postcondition</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__POSTCONDITION = eINSTANCE.getUseCase_Postcondition();

		/**
		 * The meta object literal for the '{@link model.use.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.use.impl.ConditionImpl
		 * @see model.use.impl.UsePackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__DESCRIPTION = eINSTANCE.getCondition_Description();

		/**
		 * The meta object literal for the '{@link model.use.impl.UnitTestImpl <em>Unit Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.use.impl.UnitTestImpl
		 * @see model.use.impl.UsePackageImpl#getUnitTest()
		 * @generated
		 */
		EClass UNIT_TEST = eINSTANCE.getUnitTest();

		/**
		 * The meta object literal for the '<em><b>Use Case</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_TEST__USE_CASE = eINSTANCE.getUnitTest_UseCase();

		/**
		 * The meta object literal for the '<em><b>Parameter Data</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_TEST__PARAMETER_DATA = eINSTANCE.getUnitTest_ParameterData();

		/**
		 * The meta object literal for the '{@link model.use.impl.ParameterDataImpl <em>Parameter Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.use.impl.ParameterDataImpl
		 * @see model.use.impl.UsePackageImpl#getParameterData()
		 * @generated
		 */
		EClass PARAMETER_DATA = eINSTANCE.getParameterData();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DATA__PARAMETER = eINSTANCE.getParameterData_Parameter();

		/**
		 * The meta object literal for the '<em><b>Data</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DATA__DATA = eINSTANCE.getParameterData_Data();

		/**
		 * The meta object literal for the '{@link model.use.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see model.use.impl.DataImpl
		 * @see model.use.impl.UsePackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();

	}

} //UsePackage
