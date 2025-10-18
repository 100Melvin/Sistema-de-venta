package com.sistema.venta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sistema.venta.jdbc.modelo.Producto;
import com.sistema.venta.jdbc.modelo.Proveedor;

public class ProductDAO {
	
	final private Connection con;

	public ProductDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Producto producto) {
		try  {
			
			String sqlGuardar = "INSERT INTO productos (codigo, nombre, proveedor, stock, precio, fecha) VALUES (?, ?, ?, ?, ?, ?)";
			
			final PreparedStatement statement = con.prepareStatement(
				sqlGuardar, Statement.RETURN_GENERATED_KEYS);
			
			
			statement.setString(1, producto.getCodigo());
			statement.setString(2, producto.getNombre());
			statement.setInt(3, producto.getProveedor());
			statement.setInt(4, producto.getCantidad());
			statement.setString(5, producto.getPrecio());
			statement.setObject(6, producto.getFecha());

			statement.execute();

			ResultSet resulsSet = statement.getGeneratedKeys();

			try (resulsSet) {

				while (resulsSet.next()) {
					producto.setId(resulsSet.getInt(1));
					System.out.println(String.format("Fue insertado el producto %s", producto));
				}
			}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

	}

	public List<Producto> listarProduct() {
		
		List<Producto> resultadoProducto = new ArrayList<>();

		try {
			var querySelect = "SELECT ID, CODIGO, NOMBRE, PROVEEDOR, STOCK, PRECIO, FECHA FROM PRODUCTOS";
			System.out.println(querySelect);
			final PreparedStatement statement = con.prepareStatement(querySelect);
			final ResultSet resultSet = statement.executeQuery();

			try (statement) {

				try (resultSet) {
					while (resultSet.next()) {
						var prov = new Producto(resultSet.getInt("ID"),
								resultSet.getInt("CODIGO"),
								resultSet.getString("NOMBRE"),
								resultSet.getInt("PROVEEDOR"),
								resultSet.getInt("STOCK"),
								resultSet.getDouble("PRECIO")
//								resultSet.getDate("FECHA").toLocalDate().plusDays(0)
								);

						resultadoProducto.add(prov);
					}
				}
			}
			
			return resultadoProducto;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int eliminar(Integer id) throws SQLException {
		try {

			final PreparedStatement statement = con.prepareStatement("DELETE FROM PRODUCTOS  WHERE ID = ?");

			try (statement) {
				statement.setInt(1, id);

				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
				}
			}catch (SQLException e) {
				throw new RuntimeException(e);
			}
	}

	public int modificar(String codigo, String descripcion, int proveedor, Integer cantidad, Double precio, Integer id) throws SQLException {
		
		try {
			
			final PreparedStatement statement = con
					.prepareStatement("UPDATE PRODUCTOS SET CODIGO = ?, NOMBRE = ?, PROVEEDOR = ?, STOCK = ?, PRECIO = ? WHERE ID = ?");


			try (statement) {
			statement.setString(1, codigo);
			statement.setString(2, descripcion);
			statement.setInt(3, proveedor);
			statement.setObject(4, cantidad);
			statement.setObject(5, precio);
			statement.setInt(6, id);
			statement.execute();

			int updateCount = statement.getUpdateCount();

			return updateCount;	
			} 
			} catch (SQLException e) {
				throw new RuntimeException(e);
				
			}
	}

}
