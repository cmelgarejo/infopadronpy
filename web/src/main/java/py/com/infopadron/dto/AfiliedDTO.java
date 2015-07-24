package py.com.infopadron.dto;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by Willynx 
 */
public class AfiliedDTO extends BaseDTO {

	String ci;
	String nombre_completo;
	String status;
	String msg;
	List afiliaciones;
	
	public String getCi() {
		return ci;
	}
	public void setCi(String ci) {
		this.ci = ci;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List getAfiliaciones() {
		return afiliaciones;
	}
	public void setAfiliaciones(List afiliaciones) {
		this.afiliaciones = afiliaciones;
	}
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "AfiliedDTO [ci=" + ci + ", nombre_completo=" + nombre_completo
				+ ", status=" + status + ", msg=" + msg + ", afiliaciones="
				+ afiliaciones + "]";
	}
	


	
	
}
