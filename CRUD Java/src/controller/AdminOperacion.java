package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OperacionDAO;
import model.Operacion;

@WebServlet("/adminOperacion")
public class AdminOperacion extends HttpServlet{
	private static final long serialVersionUID = 1L;
	OperacionDAO operacionDAO;
 
	public void init() {
		String jdbcURL = "jdbc:mysql://localhost:3306/matematica?user=root&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
 
			operacionDAO = new OperacionDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
 
	
	public AdminOperacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		String action = request.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(request, response);
				break;
			case "nuevo":
				nuevo(request, response);
				break;
			case "register":
				System.out.println("entro");
				registrar(request, response);
				break;
			case "mostrar":
				mostrar(request, response);
				break;
			case "showedit":
				showEditar(request, response);
				break;	
			case "editar":
				editar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			default:
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			System.out.println("Hola Servlet..");
			doGet(request, response);
		}
		
		private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	 
		private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {			
			operacionDAO.insertar(Integer.parseInt(request.getParameter("id")), request.getParameter("operacion"), Float.parseFloat(request.getParameter("primero")),Float.parseFloat(request.getParameter("segundo")));		
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/registrar.jsp");
			dispatcher.forward(request, response);
		}
		
		
		private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException , ServletException{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/mostrar.jsp");
			List<Operacion> listaOperaciones= operacionDAO.listarOperaciones();
			request.setAttribute("lista", listaOperaciones);
			dispatcher.forward(request, response);
		}	
		
		private void showEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
			Operacion operacion = operacionDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("operacion", operacion);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/vistas/editar.jsp");
			dispatcher.forward(request, response);
		}
		
		private void editar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			operacionDAO.actualizar(Integer.parseInt(request.getParameter("id")),request.getParameter("operacion"),Float.parseFloat(request.getParameter("primero")),Float.parseFloat(request.getParameter("segundo")));
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);

		}
		
		private void eliminar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
			Operacion operacion = operacionDAO.obtenerPorId(Integer.parseInt(request.getParameter("id")));
			operacionDAO.eliminar(operacion);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
			
		}
}
