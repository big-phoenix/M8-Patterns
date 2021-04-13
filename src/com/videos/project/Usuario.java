package com.videos.project;

import java.sql.Timestamp;
import java.util.*;

public class Usuario {
	
	private String nombre;
	private String apellido;
	private String passw;
	private Date fecha_rg;
	private Timestamp times;
	private Estado estado;
	public enum Estado{Uploading,Verifying,Public};
	
	public Usuario(String nombre, String apellido, String passw, int ano, int mes, int dia) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.passw = passw;
		
		GregorianCalendar calendario = new GregorianCalendar(ano,mes-1,dia);
		this.fecha_rg = calendario.getTime();
		
		this.times = new Timestamp(System.currentTimeMillis());
		this.estado = Estado.Uploading;
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	public void setPassw(String passw) {
		this.passw = passw;
	}
	
	public Date getFecha_rg() {
		return fecha_rg;
	}
	
	public Timestamp getTimes() {
		return times;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public String nombreCompleto() {
	
		return nombre+""+apellido;
	}
	
	public String getDatosUsuario() {
		return "Usuario: [Nombre : " + nombre + ", Apellido : " + apellido + 
				", Fecha de Registro : " + fecha_rg + ", Tiempo : " + times + ", Estado : " + estado + "  ]";
	}

}
