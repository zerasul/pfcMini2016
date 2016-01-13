package es.ual.itsi2016.pfcmini.sugar;

import java.io.UnsupportedEncodingException;
import java.rmi.RemoteException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.sugarcrm.www.sugarcrm.Entry_value;
import com.sugarcrm.www.sugarcrm.Get_entry_result_version2;
import com.sugarcrm.www.sugarcrm.Name_value;
import com.sugarcrm.www.sugarcrm.New_set_entry_result;
import com.sugarcrm.www.sugarcrm.Sugarsoap;
import com.sugarcrm.www.sugarcrm.SugarsoapPortTypeProxy;
import com.sugarcrm.www.sugarcrm.User_auth;

import es.ual.itsi2016.pfcmini.Response;

public class SugarConnector {

	private String session;
	
	private String login;
	private String Md5password;
	private SugarsoapPortTypeProxy soapClient;
	
	
	
	public SugarConnector(String usuario,String password){
		try {
			MessageDigest md5=MessageDigest.getInstance("MD5");
			this.login=usuario;
			this.Md5password=new String(md5.digest(password.getBytes("UTF-8")),"UTF-8");
			 soapClient= new SugarsoapPortTypeProxy();
			User_auth ususarioauth = new User_auth(usuario, Md5password);
			Entry_value value=soapClient.login(ususarioauth, "", null);
			this.session=value.getId();
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Entry_value[] listarCuentas(){
		
		Get_entry_result_version2 result;
		try {
			result = soapClient.get_entries(this.session, "Accounts", null, null, null, true);
			return result.getEntry_list();
		} catch (RemoteException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	
	public String createAccount(Response response){
		Name_value[] valuesList = new Name_value[1];
		String nombre = (String)response.getRequest().getParameters().get("name");
		valuesList[0]= new Name_value("name", nombre);
		try {
			New_set_entry_result result=soapClient.set_entry(session, "Accounts", valuesList);
			return result.getId();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			
			
		}
		return null;
	}
}
