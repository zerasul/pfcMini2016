package es.ual.itsi2016.pfcmini.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

import es.ual.itsi2016.pfcmini.Response;

@WebService
public interface PfcMiniSoapService {
	@WebMethod
	public Response createClient(String nombre,String apelidos, String dni,String direccion, String email, String telefono);
}
