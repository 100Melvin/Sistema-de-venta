package com.sistema.venta.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sistema.venta.jdbc.factory.ConectionFactory;
import com.sistema.venta.jdbc.modelo.Usuario;

public class LoginDAO {
	
private Connection con = null;
	
	public LoginDAO() {
		this.con = con;
	}

	public Usuario obtenerUsuario(Usuario usu) {
		ConectionFactory factory = new ConectionFactory();
        final Connection con = factory.recuperaConexion();
		
		Usuario usuarioLG = null;
		ResultSet rs = null;
		
		PreparedStatement statement = null;
		
		
		String sql = "select * from usuarios where nombre = ? and pass = ?";
		
			
			
			try {
				statement = con.prepareStatement(sql);
				
				statement.setString(1, usu.getNombre());
				statement.setString(2, usu.getPass());
				
				rs = statement.executeQuery();
				
				while (rs.next()) {
					
			usuarioLG = new Usuario(rs.getString(1), rs.getString(2));
					
				}
				
				
			} catch (SQLException e) {
				System.out.println("Error en conectar");
			}
			
			return usuarioLG;
	}

}
