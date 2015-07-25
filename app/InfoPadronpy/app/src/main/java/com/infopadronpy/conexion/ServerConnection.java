package com.infopadronpy.conexion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;

import com.infopadronpy.entities.Afiliation;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ServerConnection{

    int STATUS_CODE;
    String ERROR_RESULT;
    String host="https://infopadron.cmelgarejo.net/api/afiliaciones/";
   /* public ServerConnection(Context context) {

        // TODO Auto-generated constructor stub
    }*/

    public boolean isConnectedToServer(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()
                    && netInfo.isConnectedOrConnecting()
                    && netInfo.isAvailable()) {
                return true;
            }
        }
        return false;


    }


    public List<Afiliation> getAfiliationFromServer(String ci) throws Exception {
        Afiliation afiliacion= new Afiliation();
        List<Afiliation> afiliationsList= new ArrayList<>();

        String resultset = "";

        try {


            resultset = openConnection("GET", host+ci);



            try {


                if (resultset != null) {

                    Log.i("RESULT AFILIATION", resultset);
                    JSONObject reader = new JSONObject(resultset);

                    String status = reader.getString("status");
                    String message = reader.getString("msg");


                    if (status.equals("0")) {


                        String result = reader.getString("afiliaciones");

                        JSONArray ja = new JSONArray(result);

                        for (int i = 0; i < ja.length(); i++) {
                            afiliacion= new Afiliation();
                            JSONObject jo = (JSONObject) ja.get(i);

                           afiliacion.setPartido(jo.getString("partido"));
                           afiliacion.setNombre_completo(jo.getString("nombre_completo"));
                            afiliacion.setCi(jo.getString("ci"));
                            afiliacion.setLugar_votacion(jo.getString("lugar_votacion"));
                            afiliacion.setMesa(jo.getString("mesa"));
                            afiliacion.setOrden(jo.getString("orden"));
                            afiliacion.setStatus(status);
                            afiliacion.setMsg(message);

                            Log.i("PARTIDO", afiliacion.getPartido());
                            afiliationsList.add(afiliacion);
                        }



                    } else {
                        if(status.equals("-1")) {
                            afiliacion.setStatus(status);
                            afiliacion.setMsg(message);

                            afiliationsList.add(afiliacion);
                        }else{
                            afiliacion.setStatus("ERROR");
                            afiliacion.setMsg("ERROR");
                            afiliationsList.add(afiliacion);
                        }
                    }

                }


            } catch (Exception e) {
                System.out.println(e);
                afiliacion.setStatus("ERROR");
                afiliacion.setMsg("ERROR");
                afiliationsList.add(afiliacion);
            }



        } catch (Exception e) {
            System.out.println(e);
            afiliacion.setStatus("ERROR");
            afiliacion.setMsg("ERROR");
            afiliationsList.add(afiliacion);


        }


        return afiliationsList;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }


    public String openConnection(String method, String host) {
        URL url;
        StringBuffer response = null;
        String resultset="";
        String server;
        try {
            url = new URL(host);
            int currentapiVersion = android.os.Build.VERSION.SDK_INT;

            if (currentapiVersion <= Build.VERSION_CODES.JELLY_BEAN){
                HttpResponse resp=null;
                HttpClient httpclient= new DefaultHttpClient();
                InputStream inputStream = null;
                 server=host.replace("https", "http");
                if(method.equals("GET")) {
                    HttpGet httpGet = new HttpGet(server);

                     resp = httpclient.execute(httpGet);
                }

                inputStream = resp.getEntity().getContent();
               int code = resp.getStatusLine().getStatusCode();
                    Log.i("STATUS CODE", "" + code);

                if (inputStream != null) {
                    resultset = convertInputStreamToString(inputStream);
                    System.out.println("Datos Response: " + resultset);
                }
            } else {


                HttpURLConnection connection = (HttpURLConnection) url.openConnection();


                connection.setRequestMethod(method);

                connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
                connection.setRequestProperty("charset", "utf-8");



                int responseCode = connection.getResponseCode();
                System.out.println("Response Code : " + responseCode);

                if ( responseCode == 200) {


                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));
                    String inputLine;
                    response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();

                    resultset=response.toString();
                    ERROR_RESULT="";
                    STATUS_CODE=0;
                } else {
                   BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getErrorStream()));
                    String inputLine;
                    response = new StringBuffer();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();


                    ERROR_RESULT=response.toString();
                    STATUS_CODE=responseCode;
                    Log.i("[ERROR RESULT]", ERROR_RESULT);
                }

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return resultset;
    }


}
