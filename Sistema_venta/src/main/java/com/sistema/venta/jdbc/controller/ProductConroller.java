package com.sistema.venta.jdbc.controller;

import java.sql.SQLException;
import java.util.List;

import com.sistema.venta.jdbc.dao.ProductDAO;
import com.sistema.venta.jdbc.factory.ConectionFactory;
import com.sistema.venta.jdbc.modelo.Producto;
import com.sistema.venta.jdbc.modelo.Proveedor;

public class ProductConroller {
	
	private ProductDAO productDAO;    

	public ProductConroller() {
//		var factory = new ConectionFactory();
		this.productDAO = new ProductDAO(new ConectionFactory().recuperaConexion());
}

	public void guardar(Producto producto, int proveedorId) {
		
		producto.setProveedor(proveedorId);
		productDAO.guardar(producto);
		
			
		}

	public List<Producto> cargarProduct() {
		
			return productDAO.listarProduct();
		
	}

	public int eliminar(Integer id) {
		try {
			return productDAO.eliminar(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int modificar(String codigo, String descripcion, int proveedor, Integer cantidad, Double precio, Integer id) {
		try {
			return productDAO.modificar(codigo, descripcion, proveedor, cantidad, precio, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

}
