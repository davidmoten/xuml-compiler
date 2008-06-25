/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramAdapterFactory.java,v 1.6 2008/06/25 06:33:25 dxm Exp $
 */
package model.diagram.util;

import model.Named;

import model.diagram.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see model.diagram.DiagramPackage
 * @generated
 */
public class DiagramAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DiagramPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DiagramPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramSwitch<Adapter> modelSwitch =
		new DiagramSwitch<Adapter>() {
			@Override
			public Adapter caseClassDiagram(ClassDiagram object) {
				return createClassDiagramAdapter();
			}
			@Override
			public Adapter caseStateMachineDiagram(StateMachineDiagram object) {
				return createStateMachineDiagramAdapter();
			}
			@Override
			public Adapter caseCollaborationDiagram(CollaborationDiagram object) {
				return createCollaborationDiagramAdapter();
			}
			@Override
			public Adapter caseDomainChart(DomainChart object) {
				return createDomainChartAdapter();
			}
			@Override
			public Adapter caseUseCaseDiagram(UseCaseDiagram object) {
				return createUseCaseDiagramAdapter();
			}
			@Override
			public Adapter caseActivityDiagram(ActivityDiagram object) {
				return createActivityDiagramAdapter();
			}
			@Override
			public Adapter caseNamed(Named object) {
				return createNamedAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link model.diagram.ClassDiagram <em>Class Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.diagram.ClassDiagram
	 * @generated
	 */
	public Adapter createClassDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.diagram.StateMachineDiagram <em>State Machine Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.diagram.StateMachineDiagram
	 * @generated
	 */
	public Adapter createStateMachineDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.diagram.CollaborationDiagram <em>Collaboration Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.diagram.CollaborationDiagram
	 * @generated
	 */
	public Adapter createCollaborationDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.diagram.DomainChart <em>Domain Chart</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.diagram.DomainChart
	 * @generated
	 */
	public Adapter createDomainChartAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.diagram.UseCaseDiagram <em>Use Case Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.diagram.UseCaseDiagram
	 * @generated
	 */
	public Adapter createUseCaseDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.diagram.ActivityDiagram <em>Activity Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.diagram.ActivityDiagram
	 * @generated
	 */
	public Adapter createActivityDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link model.Named <em>Named</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see model.Named
	 * @generated
	 */
	public Adapter createNamedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DiagramAdapterFactory
