package py.com.infopadron.controller;

public class Afiliation {
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

