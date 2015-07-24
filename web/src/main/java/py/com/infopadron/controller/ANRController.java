package py.com.infopadron.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.api.client.json.Json;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ANRController {
	private static final Logger Logger = LoggerFactory
			.getLogger(ANRController.class);
	private static final String ApiUrl = "http://www.feednoticias.com/app/padrones/anr.php";
	private static final String ApiUser = "";
	private static final String ApiPass = "";

	public Gson request(String cedula) {
		HttpPost post = new HttpPost(ApiUrl);
		HttpClient httpclient = null;
		HttpResponse httpresponse = null;
		String response = "";
		try {
			String s = "cedula=" + cedula;
			StringEntity requestString = new StringEntity(s);

			requestString
					.setContentType("application/x-www-form-urlencoded;charset=UTF-8");
			requestString.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,
					"text/xml;charset=UTF-8"));

			post.addHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=UTF-8");
			post.addHeader("Accept", "text/xml");
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
			parseXML(response);

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
		// Parsear 
		if(response.indexOf("")>-1){
			gson = parseXML(response);
		}
		 
		return gson;
	}

	public Gson parseXML(String xml) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		InputSource is;
		Gson gson = new Gson();
		try {
			builder = factory.newDocumentBuilder();
			is = new InputSource(new StringReader(xml));
			Document doc = builder.parse(is);
			NodeList listCi = doc.getElementsByTagName("ci");
			NodeList listNombre = doc.getElementsByTagName("nombre");
			NodeList listApellido = doc.getElementsByTagName("apellido");
			NodeList listDpto= doc.getElementsByTagName("dpto");
			NodeList listDistrito= doc.getElementsByTagName("districto");
			NodeList listZona= doc.getElementsByTagName("zona");
			NodeList listSeccional= doc.getElementsByTagName("seccional");
			NodeList listLocal= doc.getElementsByTagName("local");
			NodeList listMesa= doc.getElementsByTagName("mesa");
			NodeList listOrden= doc.getElementsByTagName("orden");
			
			Afiliation afiliation = new Afiliation();
			afiliation.setCi(""+listCi.item(0).getTextContent());
			afiliation.setNombre_completo(""+listNombre.item(0).getTextContent()+" "+listApellido.item(0).getTextContent());
			afiliation.setPartido("ANR");
			afiliation.setLugar_votacion("Local: "+listLocal.item(0).getTextContent()+" Seccional: "+listSeccional.item(0).getTextContent()+" Distrito"+listDistrito.item(0).getTextContent()+" Zona: " +listZona.item(0).getTextContent()+" Dpto: "+listDpto.item(0).getTextContent());
			afiliation.setMesa(""+listMesa.item(0).getTextContent());
			afiliation.setOrden(""+listOrden.item(0).getTextContent());
			System.out.println(afiliation.toString());
			
			gson.toJson(afiliation);
			System.out.println(listCi.item(0).getTextContent());
		} catch (ParserConfigurationException e) {
		} catch (SAXException e) {
		} catch (IOException e) {
		}
		return gson;
	}

	public static void main(String[] args) {
		ANRController anrCtrl = new ANRController();
		String cedula = "4942823";// DJALMA
		//String cedula = "9999999";
		Gson gson = anrCtrl.request(cedula);

	}

	
}
