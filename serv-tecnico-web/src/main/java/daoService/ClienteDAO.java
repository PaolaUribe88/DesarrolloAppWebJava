package daoService;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Cliente;



public interface ClienteDAO {
	public List<Cliente> findAllCliente() throws SQLException, NamingException;
	public Cliente findClienteById(int id)throws NamingException, SQLException;
	public void crearCliente(Cliente cliente) throws SQLException, NamingException;
	public void editarCliente(Cliente cliente) throws SQLException, NamingException;
	public void eliminarCliente(int id) throws SQLException, NamingException;
	public Cliente UltimoClienteCreado()throws SQLException, NamingException;
}
