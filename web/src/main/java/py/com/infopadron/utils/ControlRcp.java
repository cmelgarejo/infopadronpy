package py.com.infopadron.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import py.com.infopadron.controller.ANRController;
import py.com.infopadron.controller.Afiliation;
import py.com.infopadron.controller.PLRAController;
import py.com.infopadron.controller.PPQController;
import py.com.infopadron.helper.Conexiones;

public class ControlRcp {
	private static final Logger logger = LoggerFactory
			.getLogger(ControlRcp.class);

	public static void controlDobleAfiliacion() {
		
// Crear la DB con el nombre infopadron en Postgres 9.3 y la siguiente tabla
//		CREATE TABLE dobleafiliacion
//		(
//		  id serial NOT NULL,
//		  ci character varying(50),
//		  nombre_completo character varying(150),
//		  localidad character varying(150),
//		  mesa character varying(50),
//		  orden character varying(10),
//		  partido character varying(30),
//		  CONSTRAINT dobleafiliacion_pkey PRIMARY KEY (id)
//		)
//		WITH (
//		  OIDS=FALSE
//		);
//		ALTER TABLE dobleafiliacion
//		  OWNER TO postgres;

		for (int i = 0; i < 7000000; i++) {
			
			List<Afiliation> afiliations = new ArrayList<Afiliation>();
			
			ANRController anrCtrl = new ANRController();
			Afiliation afiliationANR = anrCtrl.request(String.valueOf(i));
			if (afiliationANR.getPartido() != null) {
				afiliations.add(afiliationANR);
			}

			PLRAController plraCtrl = new PLRAController();
			Afiliation afiliationPLRA = plraCtrl.request(String.valueOf(i));
			if (afiliationPLRA.getPartido() != null) {
				afiliations.add(afiliationPLRA);
			}

			PPQController ppqCtrl = new PPQController();
			Afiliation afiliationPPQ = ppqCtrl.request(String.valueOf(i));
			if (afiliationPPQ.getPartido() != null) {
				afiliations.add(afiliationPPQ);
			}

			if (afiliations.size() > 1) {
				logger.info("-------------------------");
				logger.info("Doble afiliacion : " + i);
				Conexiones db = new Conexiones();
				Connection conn = db.connect();
				PreparedStatement pst = null;
				String sqlInsert = "insert into dobleafiliacion (ci,nombre_completo,localidad,mesa,orden,partido) values(?,?,?,?,?,?)";
				try {
					pst = conn.prepareStatement(sqlInsert);
					if (afiliationANR.getPartido() != null) {
						pst.setString(1, String.valueOf(i));
						pst.setString(2, afiliationANR.getNombre_completo());
						pst.setString(3, afiliationANR.getLugar_votacion());
						pst.setString(4, afiliationANR.getMesa());
						pst.setString(5, afiliationANR.getOrden());
						pst.setString(6, afiliationANR.getPartido());
						pst.executeUpdate();
					}

					if (afiliationPLRA.getPartido() != null) {
						pst.setString(1, String.valueOf(i));
						pst.setString(2, afiliationPLRA.getNombre_completo());
						pst.setString(3, afiliationPLRA.getLugar_votacion());
						pst.setString(4, afiliationPLRA.getMesa());
						pst.setString(5, afiliationPLRA.getOrden());
						pst.setString(6, afiliationPLRA.getPartido());
						pst.executeUpdate();
					}

					if (afiliationPPQ.getPartido() != null) {
						pst.setString(1, String.valueOf(i));
						pst.setString(2, afiliationPPQ.getNombre_completo());
						pst.setString(3, afiliationPPQ.getLugar_votacion());
						pst.setString(4, afiliationPPQ.getMesa());
						pst.setString(5, afiliationPPQ.getOrden());
						pst.setString(6, afiliationPPQ.getPartido());
						pst.executeUpdate();
					}

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				logger.info("ANR: " + afiliationANR.toString());
				logger.info("PLRA: " + afiliationPLRA.toString());
				logger.info("PPQ: " + afiliationPPQ.toString());
				logger.info("-------------------------");
			}
		}
	}

	public void insertarEnDB() {

	}

	public static void main(String[] args) {

		String cedula = "4426816";
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

		if (afiliations.size() > 1) {
			Conexiones db = new Conexiones();
			Connection conn = db.connect();
			PreparedStatement pst = null;
			String sqlInsert = "insert into dobleafiliacion (ci,nombre_completo,localidad,mesa,orden,partido) values(?,?,?,?,?,?)";
			// ci character varying(50),
			// nombre_completo character varying(150),
			// localidad character varying(150),
			// mesa character varying(50),
			// orden character varying(10),
			// partido character varying(30),
			try {
				pst = conn.prepareStatement(sqlInsert);
				pst.setString(1, afiliationANR.getCi());
				pst.setString(2, afiliationANR.getNombre_completo());
				pst.setString(3, afiliationANR.getLugar_votacion());
				pst.setString(4, afiliationANR.getMesa());
				pst.setString(5, afiliationANR.getOrden());
				pst.setString(6, afiliationANR.getPartido());
				pst.executeUpdate();

				pst.setString(1, afiliationPLRA.getCi());
				pst.setString(2, afiliationPLRA.getNombre_completo());
				pst.setString(3, afiliationPLRA.getLugar_votacion());
				pst.setString(4, afiliationPLRA.getMesa());
				pst.setString(5, afiliationPLRA.getOrden());
				pst.setString(6, afiliationPLRA.getPartido());
				pst.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
