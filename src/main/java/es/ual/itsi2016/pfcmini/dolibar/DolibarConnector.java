package es.ual.itsi2016.pfcmini.dolibar;

import java.rmi.RemoteException;

import javax.xml.rpc.holders.StringHolder;

import org.dolibarr.www.ns.Authentication;
import org.dolibarr.www.ns.Result;
import org.dolibarr.www.ns.Thirdparty;
import org.dolibarr.www.ns.WebServicesDolibarrThirdPartyPortTypeProxy;
import org.dolibarr.www.ns.holders.ResultHolder;

public class DolibarConnector {

	private String APIKEY = "5f0e8977e74a3203a9e9d301b4067270";

	private Authentication autenticate;

	public DolibarConnector(String login, String password) {
		autenticate = new Authentication(APIKEY, "", login, password, "");

	}

	public Boolean DeleteClient(String ref) {
		WebServicesDolibarrThirdPartyPortTypeProxy proxy = new WebServicesDolibarrThirdPartyPortTypeProxy();
		StringHolder holder = new StringHolder();
		Result result = new Result();
		try {
			result = proxy.deleteThirdParty(autenticate, holder, ref, "");
			if (result.getResult_code().equals("OK")) {
				return true;
			} else {
				return false;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public Boolean CreateClient(String ref, String email, String direccion) {
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
			proxy.createThirdParty(autenticate, thirdparty, resultado,
					new StringHolder(), new StringHolder());
			if (resultado.value.getResult_code().equals("OK")) {
				return true;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
}
