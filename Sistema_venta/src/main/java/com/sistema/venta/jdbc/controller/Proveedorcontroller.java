package com.sistema.venta.jdbc.controller;

import java.sql.SQLException;
import java.util.List;

import com.sistema.venta.jdbc.dao.ProveedorDAO;
import com.sistema.venta.jdbc.modelo.Proveedor;

public class Proveedorcontroller {
	
private ProveedorDAO proveedorDAO;
	
	public Proveedorcontroller() {
		var factory = new com.sistema.venta.jdbc.factory.ConectionFactory();
		this.proveedorDAO = new ProveedorDAO(factory.recuperaConexion());
	}

	public List<Proveedor> mostrarCmb() {
		return proveedorDAO.mostrar();
	}

	public List<Proveedor> mostrarCombo() {
		return proveedorDAO.combo();
	}

}
