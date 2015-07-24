package py.com.infopadron.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class RCPController {
	private static final Logger Logger = LoggerFactory
			.getLogger(SmsController.class);


	public void request(String cedula,String fechanacimiento){
		String s="ci="+cedula+"&fn="+fechanacimiento;
		String ApiUrl = "http://rcp.tsje.gov.py/dinamico.php";
		HttpPost post = new HttpPost(ApiUrl);
		
		HttpClient httpclient = null;
		HttpResponse httpresponse = null;
		HttpParams params=new BasicHttpParams();
		params.setParameter("ci", cedula);
		params.setParameter("fn", fechanacimiento);
		System.out.println("cedula: "+cedula+" fn: "+fechanacimiento);
		String response = "";
		try {
			
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("ci",cedula));
            nameValuePairs.add(new BasicNameValuePair("fn",fechanacimiento));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			post.setParams(params);

			post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			post.addHeader("Accept", "*/*");
			post.addHeader("Accept-Encoding", "gzip, deflate");
			post.addHeader("X-Requested-With", "XMLHttpRequest");
			post.addHeader("Referer","http://rcp.tsje.gov.py/");
			post.addHeader("Origin", "http://rcp.tsje.gov.py");
			// post.addHeader("Accept-Charset", "UTF-8");
			//post.setParams(params);
			
			//post.setEntity(requestString);
			httpclient = new DefaultHttpClient();
			
			System.out.println("httpclient.getParams().toString(): "+httpclient.getParams().toString());
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
	}
	public static void main(String[] args) {
		RCPController anrctrl = new RCPController();
		String cedula="2375584";//
		String fn="03/01/76";
		anrctrl.request(cedula,fn);
		

//		###PLRA
//
//		URL: http://190.128.194.162/ws/rcp/consulta.php?cc=9999999&op=1
//
//		GET /ws/rcp/consulta.php?cc=9999999&op=1 HTTP/1.1
//		Host: 190.128.194.162
//		Connection: Keep-Alive
//		User-Agent: Apache-HttpClient/UNAVAILABLE (java 1.4)
//
//		HTTP/1.1 200 OK
//		Date: Thu, 23 Jul 2015 14:49:35 GMT
//		Server: Apache/2.2.24 (PowerStack)
//		Content-Length: 145
//		Connection: close
//		Content-Type: text/html; charset=UTF-8
//		```json
//		["9999999","CHRISTIAN","MELGAREJO","SAN LORENZO N\u00c2\u00ba5                      ","COL.NAC.CONCEPCION L.DE CHAVEZ","9","999"]
//		```

	}




}

