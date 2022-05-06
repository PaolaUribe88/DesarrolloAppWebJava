package controlador;



import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.naming.NamingException;

import daoService.ClienteDAO;
import daoService.ClienteDAOImp;
import daoService.OrdenDAO;
import daoService.OrdenDAOImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Cliente;
import modelo.Orden;

/**
 * Servlet implementation class OrdenController
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ClienteDAO clienteDAO;
	private OrdenDAO ordenDAO;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.clienteDAO = new ClienteDAOImp(ordenDAO);
		this.ordenDAO = new OrdenDAOImp();
		
	}
	
    public Controller() {
       
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("accion") == null ? "": request.getParameter("accion") ;
		String vistaJSP ="";
		switch (accion) {
			case "eliminar":
				try {		
					int ordenId = Integer.parseInt( request.getParameter("id"));
					ordenDAO.eliminarOrden(ordenId);
					vistaJSP = "/WEB-INF/jsp/vista/orden/orden-form.jsp";
					response.sendRedirect("/serv-tecnico-web/OrdenController?accion=listar");
					} catch (SQLException sqle) {
						sqle.printStackTrace();
						response.sendError(100);
					} catch (NamingException e1) {
						e1.printStackTrace();
						response.sendError(200);
					}				
					break;
			case "editar":
				try {
					int ordenId = Integer.parseInt( request.getParameter("id") );	
					List<Cliente> clientes = clienteDAO.findAllCliente();					
					Orden orden = ordenDAO.findOrdenById(ordenId);
					request.setAttribute("clientes", clientes);
					vistaJSP = "/WEB-INF/jsp/vista/orden/orden-form.jsp";
					request
						.getRequestDispatcher(vistaJSP)
						.forward(request, response);
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					response.sendError(500);
				} catch (NamingException ne) {
					ne.printStackTrace();
					response.sendError(500);
				}
				break;
			case "form":
					vistaJSP= "/WEB-INF/jsp/vista/orden/orden-form.jsp";
					List<Cliente> clientes = null;			
				
					try {
						clientes = clienteDAO.findAllCliente();
						request.setAttribute("clientes", clientes);
					} catch(SQLException | NamingException e) {
						e.printStackTrace();
						response.sendError(300);
						return;
					}
					request
					.getRequestDispatcher(vistaJSP)
					.forward(request, response);	
					break;
			case "listar":
				try {
						List<Orden> ordenes =ordenDAO.findAllOrden();
						request.setAttribute("ordenes", ordenes);
						vistaJSP="/WEB-INF/jsp/vista/orden/orden-listar.jsp";
						request
								.getRequestDispatcher(vistaJSP)
								.forward(request, response);
					} catch ( SQLException| NamingException e) {
							e.printStackTrace();
							response.sendError(500);
					}
					break;
				default:
						response.sendError(600);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt( request.getParameter("id") );
		} catch (NumberFormatException e) {
			System.err.println("id se setea a 0 de manera automática.");
		}
		
		String tipoElectrodomestico    = request.getParameter("tipo_electrodomestico");
		String estado = request.getParameter("estado");
		
		String descripcionProblema = request.getParameter("descripcion_problema");
		
		Cliente cliente = null;
		try {
			int clienteId = Integer.parseInt(request.getParameter("cliente_id"));
		     	cliente   = clienteDAO.findClienteById(clienteId);
		} catch (SQLException | NamingException e1 ) {
				e1.printStackTrace();
				response.sendError(500);
				return;
		} 
		LocalDate fechaSolicitud = LocalDate.parse(request.getParameter("fecha_solicitud"));
		LocalDate fechaUltimaActualizacion = LocalDate.parse(request.getParameter("fecha_ultima_actualizacion"));
		
		if(id == 0) {
			Orden ordenNuevo = new Orden (tipoElectrodomestico, estado, fechaSolicitud, fechaUltimaActualizacion, descripcionProblema);
			try {
				ordenDAO.crearOrden(ordenNuevo);
				response.sendRedirect("/serv-tecnico-web/ClienteController?accion=listar");
			} catch (SQLException | NamingException e) {
				e.printStackTrace();
				response.sendError(500);
			}
		} else {
			Orden ordenAEditar = new Orden (tipoElectrodomestico, estado, fechaSolicitud, fechaUltimaActualizacion, descripcionProblema);
			try {
			ordenDAO.crearOrden(ordenAEditar);
			response.sendRedirect("/serv-tecnico-web/ClienteController?accion=listar");
		}catch(SQLException| NamingException e) {
			e.printStackTrace();
			response.sendError(500);
		}
		}	
	}
}