package infopadronpy.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AnrController {
	private static final Logger Logger = LoggerFactory
			.getLogger(AnrController.class);
	private static final String ApiUrl = "http://www.my-cool-sms.com/api-socket.php";
	private static final String ApiUser = "enlineapy";
	private static final String ApiPass = "SMSEnLinea2012";

	public static void main(String[] args) {
		AnrController sms = new AnrController();
		// String number = "+595984511774"; //Jorge Martinez
		// String number = "+595981257581";//Rodri
		//String number = "+595971410692"; //Will
		// String message =
		// "Su registro a Agriket ha sido completado correctamente, para empezar a utilizar la aplicación recomendamos acceder a ella desde www.agriket.com. Gracias.";
		//String message = "Queda menos de 1 hora para finalizar la subasta Nro. 159 de POLLPAR S.A. en Agriket.com";
//		String message = "Queda 1 hora para finalizar la subasta Nro. 160 de Katupyry Constructora Parana S.A en Agriket.com";
//		String message="Granja Avicola San Carlos ha creado el ticket de subasta Nro. 161 con una duracion de 8 horas en Agriket.com  ";		 
//		String message = "Queda 1 hora para finalizar la subasta Nro. 161 de Granja Avicola San Carlos en Agriket.com";
//		String message="Paraguay Agricultural Holdings SA ha creado el ticket de subasta Nro. 162 con una duracion de 4 horas en Agriket.com";
		
		//String message = "Queda menos de 1 hora para finalizar la subasta Nro. 162 de Paraguay Agricultural Holdings SA en Agriket.com";
		//String message = "Queda menos de 1 hora para finalizar la subasta Nro. 163 de POLLPAR S.A. en Agriket.com";
		//String message = "Queda menos de 1 hora para finalizar la subasta Nro. 164 de Ganadera El Fogon S.A. en Agriket.com";
		//String message = "Queda menos de 1 hora para finalizar la subasta Nro. 165 de ECOP en Agriket.com";
		//String message = "Queda menos de 1 hora para finalizar la subasta Nro. 166 de ECOP en Agriket.com";
		String message = "Queda menos de 1 hora para finalizar la subasta Nro. 169 de ECOP en Agriket.com";
		String senderid = "+131961708970";
		// String response = sms.SendSms(number, message, senderid);
		// System.out.println("Result: " + response);

		// create list
		List<String> CrunchifyList = new ArrayList<String>();

		
		//mensaje oferta minima superada
//		String message = "Estimado vendedor, su oferta minima ha sido superada por otro vendedor. Agriket.com";
//		CrunchifyList.add("+595971393020");
		
		
		//Acceso incorrecto
		//mensaje oferta minima superada
		//String message = "El sistema ha detectado que ha intentando ingresar con otra direccion de correo. Le recordamos que su usuario registrado es granos3p@gmail.com ";
		//CrunchifyList.add("+595971402560");//leonard friessen
		
		
		// add values to list
		CrunchifyList.add("+595981119750");//Gero
		CrunchifyList.add("+595971410692");//Will		
		CrunchifyList.add("+595985600003");//Sebas
		CrunchifyList.add("+595983356002");//		Agrokoner	Agrokoner
		CrunchifyList.add("+595985519001");//		Activa S.A.	Fabio	Matrakas
		CrunchifyList.add("+595984452015");//		Probal S.A.	Billy	Friesen
		CrunchifyList.add("+595981119750");//		Nu Hovy	Geronimo	Vargas
		CrunchifyList.add("+595984401522");//		Agro Panambi S.A.	BILLIE	HILDEBRAND
		CrunchifyList.add("+595982695100");//		Transagro S.A.	Ronny	Hildebrand	
		CrunchifyList.add("+595971402560");//		Granos Tres Palmas S.A.	Leonard	Friesen	
		CrunchifyList.add("+595972147117");//		Nuevo Mejico	Juan	Giesbrecht	0
		CrunchifyList.add("+595971393020");//		Paraguay Agricultural Corporation S.A.	Ana	Silvero	
		CrunchifyList.add("+595971233399");//		DAP	Carlos	Cristaldo	
		CrunchifyList.add("+595971819901");//		Francisco Vierci & Cia	Francisco	Vierci	
		CrunchifyList.add("+595981277125");//		Cooperativa Friesland Ltda	Rafael	Wiens	
		CrunchifyList.add("+595981165718");//		Cooperativa Friesland Ltda	Florian	Weiss	
		CrunchifyList.add("+595981509176");//		Cooperativa Friesland Ltda	Udo	Bergen	
		CrunchifyList.add("+595976310010");//		Silo 63	Enrique	Unger	
		CrunchifyList.add("+595983309826");//		Agroganadera Aguaray S.A.	Henrique	Junqueira	
		CrunchifyList.add("+595983632585");//		Cereall S.A.	Clayr	Marca
		CrunchifyList.add("+595971281924");//		Agricola Yguazu	Enrique	Rogalski	
		CrunchifyList.add("+595983632585");//		CEREALL S.A.	Clayr	Marca	
		CrunchifyList.add("+595971400750");//		Eddy Neufeld	Eddy	Neufeld	
		CrunchifyList.add("+595981252200");//		GPSA	Martin	Pereira	
		CrunchifyList.add("+595982264444");//		DYPSA	Santiago	Yegros	
		CrunchifyList.add("+595981404753");//		Conagro S.A.	Hugo	Rickmann	
		CrunchifyList.add("+595981715468");//		Rendy Penner	Rendy	Penner	
		CrunchifyList.add("+595971407710");//		David Friessen	David	Friessen	
		CrunchifyList.add("+595983665061");//		Agro Santa Catarina S.A.	Paulo	Rocha	
		CrunchifyList.add("+595985902100");//		Agrícola Entre Ríos S.A.	Jose	Lopes	
		CrunchifyList.add("+595983160000");//		Dekalpar S.A.	Jesús Isauro	Larré	
		//CrunchifyList.add("+595");

		// iterate via "for loop"
		System.out.println("==> For Loop Example.");
		for (int i = 0; i < CrunchifyList.size(); i++) {
			System.out.println(CrunchifyList.get(i));
			String response = sms.SendSms(CrunchifyList.get(i), message,
					senderid);
			System.out.println("Result: " + response);
		}

		// // iterate via "New way to loop"
		// System.out.println("\n==> Advance For Loop Example..");
		// for (String temp : CrunchifyList) {
		// System.out.println(temp);
		// }
		//
		// // iterate via "iterator loop"
		// System.out.println("\n==> Iterator Example...");
		// Iterator<String> CrunchifyIterator = CrunchifyList.iterator();
		// while (CrunchifyIterator.hasNext()) {
		// System.out.println(CrunchifyIterator.next());
		//
		// }
		//
		// // iterate via "while loop"
		// System.out.println("\n==> While Loop Example....");
		// int i = 0;
		// while (i < CrunchifyList.size()) {
		// System.out.println(CrunchifyList.get(i));
		// i++;
		// }

	}

	public String SendSms(String number, String message, String senderid) {

		Gson gson = new Gson();
		HttpPost post = new HttpPost(ApiUrl);
		HttpClient httpclient = null;
		HttpResponse httpresponse = null;
		Success success = new Success();
		Params params = new Params();
		params.setUsername(ApiUser);
		params.setPassword(ApiPass);
		params.setFunction("sendSms");
		String sender="+131961708970";
		params.setSenderid(sender);
		params.setMessage(message);
		params.setNumber(number);
		System.out.println("requestString: " + gson.toJson(params));
		String response = "";
		try {
			StringEntity requestString = new StringEntity(gson.toJson(params));
			requestString.setContentType("application/json;charset=UTF-8");
			requestString.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"application/json;charset=UTF-8"));
			post.addHeader("Content-Type", "application/json;charset=UTF-8");
			post.addHeader("Accept", "application/json");
			// post.addHeader("Accept-Charset", "UTF-8");

			post.setEntity(requestString);
			httpclient = new DefaultHttpClient();

			httpresponse = httpclient.execute(post);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(httpresponse.getEntity().getContent())));
			String output = "";
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				response += output;
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}

		return response;
	}

	// {
	// Json request
	// "username":"xxx",
	// "password":"yyy",
	// "function":"sendSms",
	// "number":"+491234567890",
	// "message":"Have a nice day!",
	// "senderid":"+449876543210",
	// "callbackurl":"http://www.my-server.com/callback.php"
	// }
	public class Params {
		String username;
		String password;
		String function;
		String number;
		String message;
		String senderid;
		String callbackurl;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFunction() {
			return function;
		}

		public void setFunction(String function) {
			this.function = function;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getSenderid() {
			return senderid;
		}

		public void setSenderid(String senderid) {
			this.senderid = senderid;
		}

		public String getCallbackurl() {
			return callbackurl;
		}

		public void setCallbackurl(String callbackurl) {
			this.callbackurl = callbackurl;
		}

		@Override
		public String toString() {
			return "params [username=" + username + ", password=" + password
					+ ", function=" + function + ", number=" + number
					+ ", message=" + message + ", senderid=" + senderid
					+ ", callbackurl=" + callbackurl + "]";
		}

	}

	// "success":true,
	// "smsid":"ce184cc0a6d1714d1ac763f4fe89f521",
	// "body":"Have a nice day!",
	// "bodyucs2":"0048006100760065002000610020006E00690063006500200064",
	// "bodygsm7":"486176652061206E6963652064617921",
	// "number":"+491234567890"
	// "senderid":"+449876543210",
	// "senderidenabled":true,
	// "unicode":false,
	// "numchars":321,
	// "escapenumchars":0,
	// "smscount":3,
	// "charge":0.112,
	// "balance":752.121,
	// "callbackurl":"http://www.my-server.com/callback.php"
	public class Success {
		boolean success;
		String smsid;
		String body;
		String bodyucs2;
		String bodygsm7;
		String number;
		String senderid;
		String senderidenabled;
		boolean unicode;
		String numchars;
		String escapenumchars;
		String smscount;
		String charge;
		String balance;
		String callbackurl;

		public boolean isSuccess() {
			return success;
		}

		public void setSuccess(boolean success) {
			this.success = success;
		}

		public String getSmsid() {
			return smsid;
		}

		public void setSmsid(String smsid) {
			this.smsid = smsid;
		}

		public String getBody() {
			return body;
		}

		public void setBody(String body) {
			this.body = body;
		}

		public String getBodyucs2() {
			return bodyucs2;
		}

		public void setBodyucs2(String bodyucs2) {
			this.bodyucs2 = bodyucs2;
		}

		public String getBodygsm7() {
			return bodygsm7;
		}

		public void setBodygsm7(String bodygsm7) {
			this.bodygsm7 = bodygsm7;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getSenderid() {
			return senderid;
		}

		public void setSenderid(String senderid) {
			this.senderid = senderid;
		}

		public String getSenderidenabled() {
			return senderidenabled;
		}

		public void setSenderidenabled(String senderidenabled) {
			this.senderidenabled = senderidenabled;
		}

		public boolean isUnicode() {
			return unicode;
		}

		public void setUnicode(boolean unicode) {
			this.unicode = unicode;
		}

		public String getNumchars() {
			return numchars;
		}

		public void setNumchars(String numchars) {
			this.numchars = numchars;
		}

		public String getEscapenumchars() {
			return escapenumchars;
		}

		public void setEscapenumchars(String escapenumchars) {
			this.escapenumchars = escapenumchars;
		}

		public String getSmscount() {
			return smscount;
		}

		public void setSmscount(String smscount) {
			this.smscount = smscount;
		}

		public String getCharge() {
			return charge;
		}

		public void setCharge(String charge) {
			this.charge = charge;
		}

		public String getBalance() {
			return balance;
		}

		public void setBalance(String balance) {
			this.balance = balance;
		}

		public String getCallbackurl() {
			return callbackurl;
		}

		public void setCallbackurl(String callbackurl) {
			this.callbackurl = callbackurl;
		}

		@Override
		public String toString() {
			return "Succes [success=" + success + ", smsid=" + smsid
					+ ", body=" + body + ", bodyucs2=" + bodyucs2
					+ ", bodygsm7=" + bodygsm7 + ", number=" + number
					+ ", senderid=" + senderid + ", senderidenabled="
					+ senderidenabled + ", unicode=" + unicode + ", numchars="
					+ numchars + ", escapenumchars=" + escapenumchars
					+ ", smscount=" + smscount + ", charge=" + charge
					+ ", balance=" + balance + ", callbackurl=" + callbackurl
					+ "]";
		}

	}

}
