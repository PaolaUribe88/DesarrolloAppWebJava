package daoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import modelo.Cliente;
import modelo.Orden;

public class ClienteDAOImp implements ClienteDAO {
	
	private OrdenDAO ordenDAO;
	
	public ClienteDAOImp(OrdenDAO ordenDAO){
		this.ordenDAO = ordenDAO;
	}	
	@Override
	public List<Cliente> findAllCliente() throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();		
				Statement declaracion = conexion.createStatement();
		){
			ResultSet rs = declaracion.executeQuery("SELECT FROM st_cliente");
			List<Cliente> clientes = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int telefono = rs.getInt("telefono");
				String direccion = rs.getString("direccion");
				Cliente cliente = new Cliente(id, nombre, telefono, direccion);
				clientes.add(cliente);
			}
			return clientes;
		}
	}

	@Override
	public Cliente findClienteById(int clienteId) throws NamingException, SQLException {
		try (
				Connection conexion = DBUtils.getConexion();
				PreparedStatement  declaracion = conexion.prepareStatement("SELECT * FROM st_cliente WHERE ID =?");
			) {		
				declaracion.setInt(1, clienteId);
				ResultSet rs = declaracion.executeQuery();
				
				if(rs.next()) {
					// recuperar a variables datos de la tabla 
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					int telefono     = Integer.parseInt(rs.getString("telefono"));
					String direccion = rs.getString("direccion");
					Orden orden = ordenDAO.findOrdenById(id);
					// instanciar objeto Cliente
					return new Cliente(id, nombre, telefono, direccion);
				
				}else {
				return null;
				}
		}
	}

	@Override
	public void crearCliente(Cliente cliente) throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("INSERT INTO st_cliente(nombre, telefono, direccion) VALUES(?, ?, ?)");
			) {
				declaracion.setString(1, cliente.getNombre());
				declaracion.setInt(2, cliente.getTelefono());
				declaracion.setString(3,cliente.getDireccion());
				int filasInsertadas = declaracion.executeUpdate();
			}		
		}

	@Override
	public void editarCliente(Cliente cliente) throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement
						("UPDATE st_cliente SET  nombre = ?, telefono = ?, direccion = ?  WHERE id ?");
			) {
				declaracion.setString(1, cliente.getNombre());
				declaracion.setInt(2, cliente.getTelefono());
				declaracion.setString(3,cliente.getDireccion());
				declaracion.setInt(4, cliente.getId());
				declaracion.executeUpdate();
			}
	}
	
	@Override
	public void eliminarCliente(int clienteId) throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("DELETE INTO st_cliente WHERE id ?");
			) {
			declaracion.setInt(1, clienteId);
			int filasEliminadas = declaracion.executeUpdate();
	}
	}
	@Override
	public Cliente UltimoClienteCreado() throws SQLException, NamingException {
		try(
				Connection conn = DBUtils.getConexion();
				Statement st = conn.createStatement();
			) {
			ResultSet rs = st.executeQuery("SELECT * FROM st_cliente ORDER BY id_cliente DESC LIMIT 1");
			if(rs.next()) {
				int id 				= rs.getInt("id_cliente");
				String nombre 		= rs.getString("nombre");
				int telefono 	    = rs.getInt("telefono");
				String direccion 	= rs.getString("direccion");
				return new Cliente(id,nombre,telefono,direccion);
			}
			
		}
		return null;
	}		
}
