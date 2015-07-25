package py.com.infopadron.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PPQController {
	private static final Logger logger = LoggerFactory
			.getLogger(PPQController.class);


	public Afiliation request(String cedula){
		
		String ApiUrl = "http://www.patriaquerida.org/padronpq.php";
		HttpPost post = new HttpPost(ApiUrl);
		
		HttpClient httpclient = null;
		HttpResponse httpresponse = null;
		HttpParams params=new BasicHttpParams();
		params.setParameter("Cedula_Identidad", cedula);
		params.setParameter("btn_verificar", "Verificar%BB");
		String response = "";
		try {
			
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("Cedula_Identidad",cedula));
            nameValuePairs.add(new BasicNameValuePair("btn_verificar", "Verificar%BB"));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			post.setParams(params);

			post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
			post.addHeader("Accept", "*/*");
			post.addHeader("Accept-Encoding", "gzip, deflate");
			post.addHeader("X-Requested-With", "XMLHttpRequest");
			post.addHeader("Referer","http://www.patriaquerida.org/padronpq.php");
			post.addHeader("Origin", "http://www.patriaquerida.org");
			httpclient = new DefaultHttpClient();

			httpresponse = httpclient.execute(post);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(httpresponse.getEntity().getContent())));
			String output = "";
			
			while ((output = br.readLine()) != null) {
				
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
		Afiliation afiliation = new Afiliation();
		// Parsear 
		if(response.indexOf("no existen registros")>-1){
			logger.info("no esta afiliado en PPQ");
		}else{
			afiliation = parseXML(response);
		}
		return afiliation;
	}
	
	public Afiliation parseXML(String html) {

		Document doc;
		String[] fila = new String[10];
		Afiliation afiliation = new Afiliation();
		
		doc=Jsoup.parse(html);
		String ci = doc.select("div#zfrmright").get(0).text();
		String  apellidos = doc.select("div#zfrmright").get(1).text();
		String  nombres = doc.select("div#zfrmright").get(2).text();
		String  departamento = doc.select("div#zfrmright").get(3).text();
		String  distrito = doc.select("div#zfrmright").get(4).text();
		
		afiliation.setCi(""+ci);
		afiliation.setNombre_completo(""+nombres+" "+apellidos);
		afiliation.setPartido("PPQ");
		afiliation.setLugar_votacion("Departamento: "+departamento+" Distrito: "+distrito);
		afiliation.setMesa("");
		afiliation.setOrden("");
		return afiliation;
	}
	
	
	public static void main(String[] args) {
		PPQController ppqctrl = new PPQController();
		//String cedula="434900";// Carrizosa
		String cedula="99999999";
		
		ppqctrl.request(cedula);
		

	}




}

