package com.sistema.venta.jdbc.modelo;

public class Usuario {

	private int id;
	private String nombre;
	private String pass;
	
	public Usuario(int id, String nombre, String contrasena) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = contrasena;
	}
	
	public Usuario(String nombre, String contrasena) {
		super();
		this.nombre = nombre;
		this.pass = contrasena;
	}

	public Usuario() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPass() {
		return pass;
	}
	public void setPass(String contrasena) {
		this.pass = contrasena;
	}
	
	@Override
	public String toString() {
		return String.format(
				"{ id= %d, nombre = %s, contrasena = %s}",
				this.id, this.nombre, this.pass);
	}
	
}
