package es.ual.itsi2016.pfcmini.dolibar;

import java.rmi.RemoteException;

import javax.xml.rpc.holders.StringHolder;

import org.dolibarr.www.ns.Authentication;
import org.dolibarr.www.ns.Result;
import org.dolibarr.www.ns.Thirdparty;
import org.dolibarr.www.ns.WebServicesDolibarrThirdPartyPortTypeProxy;
import org.dolibarr.www.ns.holders.ResultHolder;

public class DolibarConnector {

	private String APIKEY="";
	
	private Authentication autenticate;
	
	public DolibarConnector(String login, String password){
		autenticate= new Authentication(APIKEY,"",login,password,"");
		
	}
	
	public Boolean CreateClient(String ref, String email, String direccion){
		WebServicesDolibarrThirdPartyPortTypeProxy proxy = new WebServicesDolibarrThirdPartyPortTypeProxy();
		Thirdparty thirdparty = new Thirdparty();
		thirdparty.setRef(ref);
		thirdparty.setAddress(direccion);
		thirdparty.setEmail(email);
		thirdparty.setUrl("http://booleanbite.com");
		thirdparty.setStatus("1");
		thirdparty.setFk_user_author(autenticate.getLogin());
		thirdparty.setClient("1");
		ResultHolder resultado = new ResultHolder();
		try {
			proxy.createThirdParty(autenticate, thirdparty, resultado, new StringHolder(), new StringHolder());
			if(resultado.value.getResult_code().equals("OK")){
				return true;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
