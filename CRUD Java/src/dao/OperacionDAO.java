package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Conexion;
import model.Operacion;

public class OperacionDAO {
	private Conexion con;
	private Connection connection;
 
	public OperacionDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	public boolean ValidacionLetras(String cad) {
		boolean num = false;
		boolean str = false;
		boolean ex = false;
		for(int i = 0;i<cad.length();i++) {
			if(Character.isDigit(cad.charAt(i)) == true) {
				num = true;
			}else if (Character.isLetter(cad.charAt(i)) == true){
				str = true;
			}else { 
				ex = true;
			}
			
		}		
		if (num == false && str == true && ex == false) {
			return true;
		}else {
			return false;
		}
	}
	
	float operar(float a,float b,String operacion) {
		switch(operacion) {
		case "suma":
			return a+b;
		case "resta":
			return a-b;	
		case "multiplicacion":
			return a*b;	
		case "division":
			return a/b;	
		default:		
			return 0;
		}
	}
	
	public boolean insertar(int id,String operacion,float primero,float segundo) throws SQLException {		
		boolean registrar = false;		
		if (ValidacionLetras(operacion)) {
			String sql = "INSERT INTO operaciones values ('"+id+"','"+operacion+"','"+primero+"','"+segundo+"','"+operar(primero,segundo,operacion)+"')";
		try {
			con.conectar();
			connection = con.getJdbcConnection();
			Statement stm= connection.createStatement();
			stm.execute(sql);
			registrar=true;
			stm.close();
			connection.close();
			} catch (SQLException e) {
				System.out.println("Error: método registrar");
				e.printStackTrace();
			}
		return registrar;
		}else {
			return registrar;
		}
		
		
	}
	public List<Operacion> listarOperaciones() throws SQLException {
		 
		List<Operacion> listaOperacion = new ArrayList<Operacion>();
		String sql = "SELECT * FROM operaciones";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);
 
		while (resulSet.next()) {
			int id = resulSet.getInt("id");
			String operacion = resulSet.getString("operacion");
			float primero = resulSet.getFloat("primero");
			float segundo = resulSet.getFloat("segundo");
			float resultado = resulSet.getFloat("resultado");
			Operacion operacion_obj = new Operacion(id, operacion, primero,segundo,resultado);
			listaOperacion.add(operacion_obj);
		}
		con.desconectar();
		return listaOperacion;
	}
 
	public Operacion obtenerPorId(int id) throws SQLException {
		Operacion operacion = null;
 
		String sql = "SELECT * FROM operaciones WHERE id= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
 
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			operacion = new Operacion(res.getInt("id"),  res.getString("operacion"),
					res.getFloat("primero"),res.getFloat("segundo"),res.getFloat("resultado"));
		}
		res.close();
		con.desconectar();
 
		return operacion;
	}
	public boolean actualizar(int id,String operacion,float primero,float segundo) throws SQLException {
		boolean rowActualizar = false;		
		String sql = "UPDATE operaciones SET operacion=?,primero=?,segundo=?,resultado=? WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, operacion);
		statement.setFloat(2, primero);
		statement.setFloat(3, segundo);
		statement.setFloat(4, operar(primero,segundo,operacion));
		statement.setInt(5, id);
 
		rowActualizar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowActualizar;
		
	}
	
	public boolean eliminar(Operacion operacion) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM operaciones WHERE id=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, operacion.getId());
 
		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
 
		return rowEliminar;
	}
}
