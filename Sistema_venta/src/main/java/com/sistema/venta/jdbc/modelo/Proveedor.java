package com.sistema.venta.jdbc.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Proveedor {
	
	private int id;
	private int ruc;
	private String nombre;
	private int telefono;
	private String direccion;
	private String razon;
	private LocalDate fecha;
	
	private List<Proveedor> proveedors;
	
	
	public Proveedor(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public Proveedor() {
		
	}


	public Proveedor(int id, int ruc, String nombre, int telefono, String direccion, String razon, LocalDate fecha) {
		this.id = id;
		this.ruc = ruc;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.razon = razon;
		this.fecha = fecha;
		
	}
	
	public Proveedor(String text, String text2, String text3, String text4, String text5) {
		// TODO Auto-generated constructor stub
	}


	public void agregar(Proveedor proveedor) {
		if (this.proveedors == null) {
			this.proveedors = new ArrayList<>();
		}
		this.proveedors.add(proveedor);
		
	}
	
	public int getRuc() {
		return ruc;
	}


	public void setRuc(int ruc) {
		this.ruc = ruc;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getRazon() {
		return razon;
	}


	public void setRazon(String razon) {
		this.razon = razon;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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


	@Override
	public String toString() {
		return this.nombre;
	}
	

}
