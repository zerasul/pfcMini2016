package es.ual.itsi2016.pfcmini.soap;

import java.net.Authenticator.RequestorType;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import es.ual.itsi2016.pfcmini.Request;
import es.ual.itsi2016.pfcmini.Response;

public class PfcMiniSoapServiceImpl implements PfcMiniSoapService {

	

	@Override
	@WebMethod
	public Response createClient(@WebParam(name = "login") String login,
			@WebParam(name = "password") String password,
			@WebParam(name = "nombre") String nombre,
			@WebParam(name = "apellidos") String apelidos,
			@WebParam(name = "dni") String dni,
			@WebParam(name = "direccion") String direccion,
			@WebParam(name = "email") String email,
			@WebParam(name = "telefono") String telefono) {
		Request request = new Request();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("login", login);
		parameters.put("password", password);
		parameters.put("name", nombre);
		parameters.put("direccion", direccion);
		parameters.put("email", email);
		request.setBackend(Request.BACKEND.CLIENTS);
		request.setOperation(Request.OPERATION.CREATE);
		Response response = new Response();
		response.setRequest(request);
		return response;
	}

}
