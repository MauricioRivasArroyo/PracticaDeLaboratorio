package test;

import org.junit.Assert;
import org.junit.Test;

import dao.OperacionDAO;
import model.Operacion;

public class OperacionTest {
	Operacion operacion;
	OperacionDAO operacionDAO;
	
	@Test
	public void registroExitoso() {
	  try {
		 String jdbcURL = "jdbc:mysql://localhost:3306/matematica?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 String jdbcUsername = "root";
		 String jdbcPassword = "";
		 System.out.println("Metodo insertar"); 		  
		 operacionDAO = new OperacionDAO(jdbcURL, jdbcUsername, jdbcPassword);		 ;		 
		  Assert.assertTrue(operacionDAO.insertar(2,"suma",2,4));
		  operacionDAO.eliminar(operacionDAO.obtenerPorId(2));
	  }	  catch (Exception e){
		  e.printStackTrace();
		  Assert.fail("Fallo la prueba:" + e.getMessage());
	  }
  }	
	
	@Test
	public void registroConOperacionInvalida() {
	  try {
		 String jdbcURL = "jdbc:mysql://localhost:3306/matematica?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 String jdbcUsername = "root";
		 String jdbcPassword = "";
		 System.out.println("Metodo insertar"); 		  
		 operacionDAO = new OperacionDAO(jdbcURL, jdbcUsername, jdbcPassword);		 ;		 
		  Assert.assertFalse(operacionDAO.insertar(2,"suma1",2,4));
	  }	  catch (Exception e){
		  e.printStackTrace();
		  Assert.fail("Fallo la prueba:" + e.getMessage());
	  }
  }	
	
	@Test
	public void actualizarExitoso() {
	  try {
		 String jdbcURL = "jdbc:mysql://localhost:3306/matematica?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 String jdbcUsername = "root";
		 String jdbcPassword = "";
		 System.out.println("Metodo actualizar"); 
		 operacionDAO = new OperacionDAO(jdbcURL, jdbcUsername, jdbcPassword); 
		 operacionDAO.insertar(3,"suma",8,4);	 
		  Assert.assertTrue(operacionDAO.actualizar(3,"resta",8,4));
			operacionDAO.eliminar(operacionDAO.obtenerPorId(3));
	  }	  catch (Exception e){
		  e.printStackTrace();
		  Assert.fail("Fallo la prueba:" + e.getMessage());
	  }
  }
	@Test
	public void sumaExitoso() {
	  try {
		 String jdbcURL = "jdbc:mysql://localhost:3306/matematica?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 String jdbcUsername = "root";
		 String jdbcPassword = "";
		 System.out.println("Sumar"); 
		 operacionDAO = new OperacionDAO(jdbcURL, jdbcUsername, jdbcPassword); 
		 operacionDAO.insertar(5,"suma",8,4);	 
		  Assert.assertTrue(operacionDAO.obtenerPorId(5).getResultado() == 12);
			operacionDAO.eliminar(operacionDAO.obtenerPorId(5));
	  }	  catch (Exception e){
		  e.printStackTrace();
		  Assert.fail("Fallo la prueba:" + e.getMessage());
	  }
  }
	@Test
	public void multiplicacionExitoso() {
	  try {
		 String jdbcURL = "jdbc:mysql://localhost:3306/matematica?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 String jdbcUsername = "root";
		 String jdbcPassword = "";
		 System.out.println("Multiplicar"); 
		 operacionDAO = new OperacionDAO(jdbcURL, jdbcUsername, jdbcPassword); 
		 operacionDAO.insertar(6,"multiplicacion",8,4);	 
		  Assert.assertTrue(operacionDAO.obtenerPorId(6).getResultado() == 32);
			operacionDAO.eliminar(operacionDAO.obtenerPorId(6));
	  }	  catch (Exception e){
		  e.printStackTrace();
		  Assert.fail("Fallo la prueba:" + e.getMessage());
	  }
  }
	@Test
	public void restaExitoso() {
	  try {
		 String jdbcURL = "jdbc:mysql://localhost:3306/matematica?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 String jdbcUsername = "root";
		 String jdbcPassword = "";
		 System.out.println("Restar"); 
		 operacionDAO = new OperacionDAO(jdbcURL, jdbcUsername, jdbcPassword); 
		 operacionDAO.insertar(7,"resta",8,4);	 
		  Assert.assertTrue(operacionDAO.obtenerPorId(7).getResultado() == 4);
			operacionDAO.eliminar(operacionDAO.obtenerPorId(7));
	  }	  catch (Exception e){
		  e.printStackTrace();
		  Assert.fail("Fallo la prueba:" + e.getMessage());
	  }
  }
	@Test
	public void divisionExitoso() {
	  try {
		 String jdbcURL = "jdbc:mysql://localhost:3306/matematica?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 String jdbcUsername = "root";
		 String jdbcPassword = "";
		 System.out.println("Dividir"); 
		 operacionDAO = new OperacionDAO(jdbcURL, jdbcUsername, jdbcPassword); 
		 operacionDAO.insertar(9,"division",8,4);	 
		  Assert.assertTrue(operacionDAO.obtenerPorId(9).getResultado() == 2);
			operacionDAO.eliminar(operacionDAO.obtenerPorId(9));
	  }	  catch (Exception e){
		  e.printStackTrace();
		  Assert.fail("Fallo la prueba:" + e.getMessage());
	  }
  }
	
	@Test
	public void eliminarExitoso() {
	  try {
		 String jdbcURL = "jdbc:mysql://localhost:3306/matematica?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 String jdbcUsername = "root";
		 String jdbcPassword = "";
		 System.out.println("Metodo eliminar"); 
		 operacionDAO = new OperacionDAO(jdbcURL, jdbcUsername, jdbcPassword);
		 operacionDAO.insertar(4,"suma",6,7);				 
		  Assert.assertTrue(operacionDAO.eliminar(operacionDAO.obtenerPorId(4)));	
	  }	  catch (Exception e){
		  e.printStackTrace();
		  Assert.fail("Fallo la prueba:" + e.getMessage());
	  }
  }
}

