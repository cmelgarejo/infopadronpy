package py.com.infopadron.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

public class PLRAController {
	private static final Logger Logger = LoggerFactory
			.getLogger(SmsController.class);


	public Gson request(String cedula){
		String ApiUrl = "http://190.128.194.162/ws/rcp/consulta.php?cc="+cedula+"&op=1";
		HttpPost post = new HttpPost(ApiUrl);
		HttpClient httpclient = null;
		HttpResponse httpresponse = null;
		String response = "";
		try {
			String s="cedula="+cedula;
			StringEntity requestString = new StringEntity(s);
			
			requestString.setContentType("application/text/html;charset=UTF-8");
			requestString.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"text/html;charset=UTF-8"));
			
			post.addHeader("Content-Type", "text/html;charset=UTF-8");
			post.addHeader("Accept", "text/html");
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
			//parseArray(response);
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
		Gson gson=null;
		System.out.println(response);
		// Parsear 
		if(response.indexOf("-1")>-1){
			System.out.println("no esta afiliado");
			
		}else{
			gson = parseArray(response);
		}
		 
		return gson;
	}
	public static StringBuffer removeUTFCharacters(String data){
		Pattern p = Pattern.compile("\\\\u(\\p{XDigit}{4})");
		Matcher m = p.matcher(data);
		StringBuffer buf = new StringBuffer(data.length());
		while (m.find()) {
		String ch = String.valueOf((char) Integer.parseInt(m.group(1), 16));
		m.appendReplacement(buf, Matcher.quoteReplacement(ch));
		}
		m.appendTail(buf);
		return buf;
		}

	public Gson parseArray(String array){
		//["2265485","BERNARDA ANASTASIA","OVELAR","CAACUPE","ESC GRAD N\u00c2\u00ba40 TTE JOSE MARIA FARI\u00c3\u0091A","19","21"]
		System.out.println("array: "+array);
//		String regexpStr = "[\"0-9a-zA-Z\"+,\\s*(\"0-9a-zA-Z\"+),\\s*(\"0-9a-zA-Z\"+),\\s*(\"0-9a-zA-Z\"+),\\s*(\"0-9a-zA-Z\"+),\\s*(\"0-9a-zA-Z\"+),\"0-9a-zA-Z\"]";
//		    String inputData = "[11, john,][23, Adam,][88, Angie,]";
//
//		    Pattern regexp = Pattern.compile(regexpStr);
//		    Matcher matcher = regexp.matcher(array);
//		    while (matcher.find()) {
//		        MatchResult result = matcher.toMatchResult();
//		        String id = result.group(0);
//		        //String name = result.group(1);
//		        System.out.println("id: "+id);
//		        //System.out.println("id: "+id+" name: "+name);
//		    }
//		
		
		String [] cortado = array.split(",");
		System.out.println(cortado[0].replace("\"", "").replace("[", ""));
		System.out.println(cortado[1].replace("\"", ""));
		System.out.println(cortado[2].replace("\"", ""));
		System.out.println(cortado[3].replace("\"", ""));
		System.out.println(cortado[4].replace("\"", ""));
		System.out.println(cortado[5].replace("\"", ""));
		System.out.println(cortado[6].replace("\"", "").replace("]", ""));
		
		StringBuffer escuela=removeUTFCharacters(cortado[4].replace("\"", "").toString());
		String esc= escuela.toString();
				
		
		System.out.println(esc);
		
		Afiliation afiliation = new Afiliation();
		afiliation.setCi(""+cortado[0].replace("\"", "").replace("[", ""));
		afiliation.setNombre_completo(""+cortado[1].replace("\"", "")+", "+cortado[2].replace("\"", ""));
		afiliation.setPartido("PLRA");
		afiliation.setLugar_votacion(""+escuela +" "+cortado[3].replace("\"", "") );
		afiliation.setMesa(""+cortado[5].replace("\"", ""));
		afiliation.setOrden(""+cortado[6].replace("\"", ""));
		System.out.println(afiliation.toString());
		
		
		return null;
		
		
	}
	public static void main(String[] args) {
		PLRAController anrctrl = new PLRAController();
		//String cedula="2265485";//
		String cedula="99999999";//
		anrctrl.request(cedula);
		

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

