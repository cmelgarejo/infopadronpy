package py.com.infopadron.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import py.com.infopadron.dto.AfiliedDTO;

import com.google.gson.Gson;


@Controller
@RequestMapping("/api/rcp")

public class UnifiedQueryController {
	private static final Logger Logger = LoggerFactory
			.getLogger(SmsController.class);

	@RequestMapping(method = RequestMethod.GET, value = "/{ci}/afiliations")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody ResponseEntity<List<AfiliedDTO>> getAfiliations() {
		
		ANRController anrCtrl = new ANRController();
		String cedula="4942823";//DJALMA
		anrCtrl.request(cedula);
		
		PLRAController plraCtrl = new PLRAController();
		cedula="2265485";//
		plraCtrl.request(cedula);
		
		RCPController rcpCtrl = new RCPController();
		cedula="2375584";//
		String fn="03/01/76";
		rcpCtrl.request(cedula,fn);
		return null;
		

		//return new ResponseEntity<List<AfiliedDTO>>(afiliations,HttpStatus.OK);
	}

	public static void main(String[] args) {
		
		Gson gson = new Gson();
		List<Gson> afiliations = new ArrayList<Gson>();
		
		ANRController anrCtrl = new ANRController();
		String cedula="4942823";//DJALMA
		Gson gsonANR=anrCtrl.request(cedula);
		if(gsonANR!=null){
			afiliations.add(gsonANR);
		}
		
		PLRAController plraCtrl = new PLRAController();
		cedula="2265485";//
		Gson gsonPLRA=plraCtrl.request(cedula);
		if(gsonPLRA!=null){
			afiliations.add(gsonPLRA);
		}
		
		

//		RCPController rcpCtrl = new RCPController();
//		cedula="2375584";//
//		String fn="03/01/76";
//		rcpCtrl.request(cedula,fn);

		
		
		
		
		
		
//		response json
//		{
//		  "nombre": "Fulano Mortadela",
//		  "ci": 1234567,
//		  "status": 0,
//		  "msg": null,
//		  "afiliaciones": [
//		    {
//		      "partido": "DIVERTIDO",
//		      "nombre_completo": "Fulano Mortadela <concatenar en orden \"normal\": nombre + apellido>",
//		      "ci": "1234567",
//		      "lugar_votacion": "<concatenar + toda + la infomacion + como + departamento + distrito + zona + seccional + etc>",
//		      "mesa": 108,
//		      "orden": 108
//		    }
//		  ]
//		}
		
		
		
		
	}
	
	public class Afiliations {
		String partido;
		String nombre_completo;
		String ci;
		String lugar_votacion;
		String mesa;
		String orden;
		public String getPartido() {
			return partido;
		}
		public void setPartido(String partido) {
			this.partido = partido;
		}
		public String getNombre_completo() {
			return nombre_completo;
		}
		public void setNombre_completo(String nombre_completo) {
			this.nombre_completo = nombre_completo;
		}
		public String getCi() {
			return ci;
		}
		public void setCi(String ci) {
			this.ci = ci;
		}
		public String getLugar_votacion() {
			return lugar_votacion;
		}
		public void setLugar_votacion(String lugar_votacion) {
			this.lugar_votacion = lugar_votacion;
		}
		public String getMesa() {
			return mesa;
		}
		public void setMesa(String mesa) {
			this.mesa = mesa;
		}
		public String getOrden() {
			return orden;
		}
		public void setOrden(String orden) {
			this.orden = orden;
		}
		@Override
		public String toString() {
			return "Afiliations [partido=" + partido + ", nombre_completo="
					+ nombre_completo + ", ci=" + ci + ", lugar_votacion="
					+ lugar_votacion + ", mesa=" + mesa + ", orden=" + orden
					+ "]";
		}

		



	}

}

