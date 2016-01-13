package es.ual.itsi2016.pfcmini.clients;

import org.mule.api.annotations.param.Payload;

import es.ual.itsi2016.pfcmini.Response;

public class DeleteClients {

	public Response DeleteClient(@Payload Response response){
		return response;
	}
}
