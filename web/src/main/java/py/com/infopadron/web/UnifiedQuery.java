package py.com.infopadron.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import py.com.infopadron.controller.ANRController;
import py.com.infopadron.controller.Afiliation;
import py.com.infopadron.controller.PLRAController;
import py.com.infopadron.controller.PPQController;
import py.com.infopadron.controller.RCPController;
import py.com.infopadron.dto.AfiliedDTO;

import com.google.api.client.json.Json;
import com.google.gson.Gson;

@Controller
@RequestMapping("/api/afiliaciones")
public class UnifiedQuery {
	private static final Logger logger = LoggerFactory
			.getLogger(UnifiedQuery.class);

	@RequestMapping(method = RequestMethod.GET, value = "/{cedula}")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody ResponseEntity<AfiliedDTO> getAfiliations(
			@PathVariable String cedula) {
		logger.info("------------------------------");
		logger.info("Afiliacion Cedula: " + cedula);
		Gson gson = new Gson();
		List<Afiliation> afiliations = new ArrayList<Afiliation>();

		ANRController anrCtrl = new ANRController();
		// String cedula = "4942823";// DJALMA
		Afiliation afiliationANR = anrCtrl.request(cedula);
		if (afiliationANR.getPartido() != null) {
			afiliations.add(afiliationANR);
		}

		PLRAController plraCtrl = new PLRAController();
		// cedula = "2265485";//
		Afiliation afiliationPLRA = plraCtrl.request(cedula);
		if (afiliationPLRA.getPartido() != null) {
			afiliations.add(afiliationPLRA);
		}
		
		PPQController ppqCtrl = new PPQController();
		// cedula = "434900";//
		Afiliation afiliationPPQ = ppqCtrl.request(cedula);
		if (afiliationPPQ.getPartido() != null) {
			afiliations.add(afiliationPPQ);
		}

		String nombre = "";
		if (afiliationANR.getNombre_completo() != null) {
			nombre = afiliationANR.getNombre_completo();
		} else if (afiliationPLRA.getNombre_completo() != null) {
			nombre = afiliationPLRA.getNombre_completo();
		}else if (afiliationPPQ.getNombre_completo() != null) {
			nombre = afiliationPPQ.getNombre_completo();
		}

		AfiliedDTO dto = new AfiliedDTO();
		dto.setCi(cedula);
		dto.setNombre_completo(nombre);
		
		if(afiliations.size()==0){
			dto.setMsg("No posee afiliaciones");
			dto.setStatus("-1");
		}else{
			dto.setStatus("0");
			dto.setMsg("Posee las siguientes afiliaciones");
		}
		
		
		dto.setAfiliaciones(afiliations);
		logger.info("ANR: " + afiliationANR.toString());
		logger.info("PLRA: " + afiliationPLRA.toString());
		logger.info("PPQ: " + afiliationPPQ.toString());
		logger.info("------------------------------");
		return new ResponseEntity<AfiliedDTO>(dto, HttpStatus.OK);

	}

	public static void main(String[] args) {
		String cedula = "1111111";
		List<Afiliation> afiliations = new ArrayList<Afiliation>();
		ANRController anrCtrl = new ANRController();
		
		Afiliation afiliationANR = anrCtrl.request(cedula);
		if (afiliationANR.getPartido() != null) {
			afiliations.add(afiliationANR);
		}
		PLRAController plraCtrl = new PLRAController();
		
		Afiliation afiliationPLRA = plraCtrl.request(cedula);
		if (afiliationPLRA.getPartido() != null) {
			afiliations.add(afiliationPLRA);
		}
		
		PPQController ppqCtrl = new PPQController();
		Afiliation afiliationPPQ = ppqCtrl.request(cedula);
		if (afiliationPPQ.getPartido() != null) {
			afiliations.add(afiliationPPQ);
		}
		if(afiliations.size()>1){
			
		}
		
		System.out.println("ANR " + afiliationANR.toString());
		System.out.println("PLRA: " + afiliationPLRA.toString());
		System.out.println("PPQ: " + afiliationPPQ.toString());
	}

}
