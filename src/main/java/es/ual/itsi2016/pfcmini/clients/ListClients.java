package es.ual.itsi2016.pfcmini.clients;

import org.json.JSONArray;
import org.mule.api.annotations.param.Payload;

import es.ual.itsi2016.pfcmini.Response;
import es.ual.itsi2016.pfcmini.sugar.SugarConnector;

public class ListClients {

	private SugarConnector conectorSugar;
	
	public Response listClients(@Payload Response response){
		try{
		 
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
