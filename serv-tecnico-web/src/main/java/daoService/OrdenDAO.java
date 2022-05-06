package daoService;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Orden;

public interface OrdenDAO {
	public List<Orden> findAllOrden() throws SQLException, NamingException;
	public Orden findOrdenById(int id)throws NamingException, SQLException;
	public void crearOrden(Orden Orden) throws SQLException, NamingException;
	public void editarOrden(Orden orden) throws SQLException, NamingException;
	public void eliminarOrden(int id) throws SQLException, NamingException;

}