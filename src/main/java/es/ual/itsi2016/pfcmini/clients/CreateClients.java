package es.ual.itsi2016.pfcmini.clients;

import org.mule.api.annotations.param.Payload;

import es.ual.itsi2016.pfcmini.Request;
import es.ual.itsi2016.pfcmini.Response;
import es.ual.itsi2016.pfcmini.dolibar.DolibarConnector;
import es.ual.itsi2016.pfcmini.sugar.SugarConnector;

public class CreateClients {

	private SugarConnector sugarcrm;
	private DolibarConnector dolibarConnector;
	
	public Response createClient(@Payload Response response){
		Request request = response.getRequest();
		dolibarConnector= new DolibarConnector((String)request.getParameters().get("login"), (String)request.getParameters().get("password"));
		sugarcrm = new SugarConnector((String)request.getParameters().get("login"), (String)request.getParameters().get("password"));
		sugarcrm.createAccount(response);
		String ref= (String)request.getParameters().get("name");
		String email= (String)request.getParameters().get("email");
		String direccion= (String)request.getParameters().get("direccion");
		if(dolibarConnector.CreateClient(ref, email, direccion)){
			response.setResult(Response.OK);
		}else{
			response.setResult(Response.KO);
		}
		return response;
	}
}
