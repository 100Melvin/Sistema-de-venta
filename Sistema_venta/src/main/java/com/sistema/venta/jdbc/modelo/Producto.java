package com.sistema.venta.jdbc.modelo;

import java.time.LocalDate;

public class Producto {
	
	private int id;
	private String codigo;
	private String nombre;
	private int proveedor;
	private int cantidad;
	private String precio;
	private LocalDate fecha;
	
	
	public Producto(int id, int codigo, String nombre, int proveedor, int cantidad, double precio) {
		
		this.id = id;
		this.codigo = String.valueOf(codigo);
		this.nombre = nombre;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.precio = String.valueOf(precio);
		this.fecha = fecha;
		
		
	}


	public Producto(String codigo, String nombre, int cantidad, String precio, int proveedor) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.precio = precio;
//		this.fecha = fecha;
	}
	
	public Producto(String codigo, String nombre, int cantidad, String precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return nombre;
	}


	public void setDescripcion(String descripcion) {
		this.nombre = descripcion;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getProveedor() {
		return proveedor;
	}


	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", proveedor=" + proveedor
				+ ", cantidad=" + cantidad + ", precio=" + precio + ", fecha=" + fecha + "]";
	}


	
	

}
