package com.infopadronpy.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.infopadronpy.R;
import com.infopadronpy.conexion.ServerConnection;
import com.infopadronpy.entities.Afiliation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    Button buscar;
    EditText ci;
    ListAdapter listAdapter;
    ListView listview;
    List<String> afiliadodLista=new ArrayList<>();
    List<Afiliation> afiliationObjList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buscar= (Button) findViewById(R.id.btnbuscar);
        ci=(EditText) findViewById(R.id.editbuscar);
        listview=(ListView) findViewById(R.id.list);



        buscar.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
              String Cedula= ci.getText().toString().trim();
        if(!Cedula.equals("")) {
        new AfiliationThread(Cedula).execute();
        }else{

            Toast.makeText(getBaseContext(), "Ingresar Cedula", Toast.LENGTH_SHORT).show();
        }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //HILO DE SINCRONIZACION DE TODOS LOS DATOS
    private class AfiliationThread extends AsyncTask<String, Void, String> {
        ProgressDialog myPd_ring2;
        String estado = "";
        String ci;
        public AfiliationThread(String Ci){
            this.ci=Ci;
        }
        protected void onPreExecute() {

            try {

                myPd_ring2 = ProgressDialog.show(MainActivity.this, "Por Favor Espere", "Procesando...", true);
                myPd_ring2.setCancelable(true);

            } catch (Exception e) {

                System.out.println(e);
            }

        }

        @Override
        protected String doInBackground(String... params) {

            try {
                ServerConnection con = new ServerConnection();
                if (!con.isConnectedToServer(getApplicationContext())) {
                    estado = "Error de Conexion a Internet";
                } else {

                    Afiliation afiliation= new Afiliation();

                    afiliationObjList =  con.getAfiliationFromServer(ci);

                    if(!afiliation.getStatus().equals("ERROR")){



                    }


                }
            } catch (Exception e) {

                System.out.println(e);
            }
            return null;
        }


        @Override
        protected void onPostExecute(String result) {
            myPd_ring2.dismiss();
            switch (estado) {


                case "Error de Conexion a Internet":
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                    alert.setTitle("Mensaje");
                    alert.setMessage(estado);
                    alert.setPositiveButton("Aceptar", null);
                    alert.show();
                    break;
                default:



                        if (afiliationObjList.size() > 0) {
                            if(afiliationObjList.get(0).getStatus().equals("0")) {
                                listAdapter = new ListAdapter(getApplicationContext(), afiliationObjList);

                                listview.setAdapter(listAdapter);
                            }else{

                                    alert = new AlertDialog.Builder(MainActivity.this);
                                    alert.setTitle("Mensaje");
                                    alert.setMessage(afiliationObjList.get(0).getMsg());
                                    alert.setPositiveButton("Aceptar", null);
                                    alert.show();


                            }

                    }
                    break;
            }
        }
    }
}
