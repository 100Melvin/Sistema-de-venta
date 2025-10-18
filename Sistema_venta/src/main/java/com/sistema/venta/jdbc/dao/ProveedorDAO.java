package com.sistema.venta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.sistema.venta.jdbc.modelo.Proveedor;

public class ProveedorDAO {
	
	final private Connection con;

	public ProveedorDAO(Connection con) {
		this.con = con;
	}

	public List<Proveedor> mostrar() {
		List<Proveedor> resultado = new ArrayList<>();

		try {
			var querySelect = "SELECT ID, RUC, NOMBRE, TELEFONO, DIRECCION, RAZON, FECHA FROM PROVEEDOR";
			System.out.println(querySelect);
			final PreparedStatement statement = con.prepareStatement(querySelect);
			final ResultSet resultSet = statement.executeQuery();

			try (statement) {

				try (resultSet) {
					while (resultSet.next()) {
						var prov = new Proveedor(resultSet.getInt("ID"),
								resultSet.getInt("RUC"),
								resultSet.getString("NOMBRE"),
								resultSet.getInt("TELEFONO"),
								resultSet.getString("DIRECCION"),
								resultSet.getString("RAZON"),
								resultSet.getDate("FECHA").toLocalDate().plusDays(0)
								);

						resultado.add(prov);
					}
				}
			}
			
			return resultado;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Proveedor> combo() {
		List<Proveedor> resultadoCombo = new ArrayList<>();

		try {
			var querySelect = "SELECT ID, NOMBRE FROM PROVEEDOR";
			System.out.println(querySelect);
			final PreparedStatement statement = con.prepareStatement(querySelect);
			final ResultSet resultSet = statement.executeQuery();

			try (statement) {

				try (resultSet) {
					while (resultSet.next()) {
						var provCombo = new Proveedor(resultSet.getInt("ID"),
								resultSet.getString("NOMBRE")
								);

						resultadoCombo.add(provCombo);
					}
				}
			}
			
			return resultadoCombo;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


}
