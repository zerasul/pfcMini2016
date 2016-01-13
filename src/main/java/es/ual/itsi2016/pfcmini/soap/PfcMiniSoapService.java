package es.ual.itsi2016.pfcmini.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import es.ual.itsi2016.pfcmini.Response;

@WebService
public interface PfcMiniSoapService {
	@WebMethod
	public Response createClient(@WebParam(name="login")String login,@WebParam(name="password")String password,@WebParam(name="nombre")String nombre,@WebParam(name="apellidos") String apelidos,@WebParam(name="dni") String dni,
			@WebParam(name="direccion")String direccion, @WebParam(name="email")String email,@WebParam(name="telefono") String telefono);
}
