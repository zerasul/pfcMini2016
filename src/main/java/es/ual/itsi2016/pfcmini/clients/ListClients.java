package es.ual.itsi2016.pfcmini.clients;

import org.json.JSONArray;
import org.mule.api.annotations.param.Payload;

import es.ual.itsi2016.pfcmini.Request;
import es.ual.itsi2016.pfcmini.Response;
import es.ual.itsi2016.pfcmini.sugar.SugarConnector;


public class ListClients {

	private SugarConnector conectorSugar;
	
	public Response listClients(@Payload Response response){
		try{
		Request request = new Request();
		String login=(String)request.getParameters().get("login");
		String password = (String)request.getParameters().get("password");
		conectorSugar= new SugarConnector(login, password);
		JSONArray object = new JSONArray(conectorSugar.listarCuentas());
		
		response.setResponse(object.toString());
		response.setResult(Response.OK);
		return response;
		}catch(Exception e){
			
		}
		response.setResult(Response.KO);
		return response;
	}
}
