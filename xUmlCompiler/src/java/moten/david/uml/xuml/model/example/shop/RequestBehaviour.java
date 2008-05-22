package moten.david.uml.xuml.model.example.shop;

import shop.Request;
import shop.actions.RequestActions;

public class RequestBehaviour implements RequestActions {

	private Request request;

	@Override
	public void dispatch() {
		System.out.println("dispatching request" + request.getId());
	}

	@Override
	public void setRequest(Request request) {
		this.request = request;
	}

}
