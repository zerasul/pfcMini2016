package es.ual.itsi2016.pfcmini.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;

import es.ual.itsi2016.pfcmini.Response;

public class PfcMiniSoapServiceImpl implements PfcMiniSoapService {

	@Override
	@WebMethod
	public Response createClient(@WebParam(name="nombre")String nombre,@WebParam(name="apellidos") String apelidos,@WebParam(name="dni") String dni,
			@WebParam(name="direccion")String direccion, @WebParam(name="email")String email,@WebParam(name="telefono") String telefono) {
		
		return null;
	}

}
