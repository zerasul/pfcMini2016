package es.ual.itsi2016.pfcmini;

import java.util.Map;

public class Request {

	public enum BACKEND{
		CLIENTS,
		PRODUCTS,
		SALES
	};
	
	public enum OPERATION{
		LIST,
		CREATE,
		UPDATE,
		DELETE,
		
	}
	
	private BACKEND backend;
	private OPERATION operation;
	private Map<String,Object> parameters;
	
	
	public BACKEND getBackend() {
		return backend;
	}
	public void setBackend(BACKEND backend) {
		this.backend = backend;
	}
	public OPERATION getOperation() {
		return operation;
	}
	public void setOperation(OPERATION operation) {
		this.operation = operation;
	}
	public Map<String, Object> getParameters() {
		return parameters;
	}
	public void setParameters(Map<String, Object> parameters) {
		this.parameters = parameters;
	}
	
	
	
	
	
}
