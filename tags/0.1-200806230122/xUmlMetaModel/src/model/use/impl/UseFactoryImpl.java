/**
 * <copyright>
 * </copyright>
 *
 * $Id: UseFactoryImpl.java,v 1.4 2008/06/11 07:28:47 dxm Exp $
 */
package model.use.impl;

import model.use.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UseFactoryImpl extends EFactoryImpl implements UseFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UseFactory init() {
		try {
			UseFactory theUseFactory = (UseFactory)EPackage.Registry.INSTANCE.getEFactory("http://davidmoten.homeip.net/uml/executable/model/use"); 
			if (theUseFactory != null) {
				return theUseFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UseFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UsePackage.ACTOR: return createActor();
			case UsePackage.USE_CASE: return createUseCase();
			case UsePackage.CONDITION: return createCondition();
			case UsePackage.UNIT_TEST: return createUnitTest();
			case UsePackage.PARAMETER_DATA: return createParameterData();
			case UsePackage.DATA: return createData();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actor createActor() {
		ActorImpl actor = new ActorImpl();
		return actor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase createUseCase() {
		UseCaseImpl useCase = new UseCaseImpl();
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitTest createUnitTest() {
		UnitTestImpl unitTest = new UnitTestImpl();
		return unitTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterData createParameterData() {
		ParameterDataImpl parameterData = new ParameterDataImpl();
		return parameterData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Data createData() {
		DataImpl data = new DataImpl();
		return data;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsePackage getUsePackage() {
		return (UsePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UsePackage getPackage() {
		return UsePackage.eINSTANCE;
	}

} //UseFactoryImpl
