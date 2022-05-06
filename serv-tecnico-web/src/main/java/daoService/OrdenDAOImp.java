package daoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import modelo.Electrodomestico;
import modelo.Orden;

public class OrdenDAOImp implements OrdenDAO {
	ElectrodomesticoDAO electrodomesticosDAO;
	
	public OrdenDAOImp(ElectrodomesticoDAO electrodomesticosDAO) {
		this.electrodomesticosDAO = electrodomesticosDAO;
	}

	@Override
	public List<Orden> findAllOrden() throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();		
				Statement declaracion = conexion.createStatement();
		){
			ResultSet rs = declaracion.executeQuery("SELECT FROM st_cliente");
			List<Orden> ordenes = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String estado = rs.getString("estado");
				LocalDate fechaSolicitud = rs.getObject("fecha_solicitud", LocalDate.class);
				LocalDate fechaUltimaActualizacion = rs.getObject("fecha_ultima_actualizacion", LocalDate.class);
				int id_electrodomestico 		   = rs.getInt("id_electrodomestico");
				Electrodomestico electrodomestico  = electrodomesticosDAO.findElectrodomesticoById(id_electrodomestico);
				
				Orden orden= new Orden(id, estado, fechaSolicitud , fechaUltimaActualizacion );
				ordenes.add(orden);
			}
			return ordenes;
		}
	}

	@Override
	public Orden findOrdenById(int ordenId) throws NamingException, SQLException {
		try (
				Connection conexion = DBUtils.getConexion();
				PreparedStatement  declaracion = conexion.prepareStatement("SELECT * FROM st_cliente WHERE ID =?");
			) {		
				declaracion.setInt(1, ordenId);
				ResultSet rs = declaracion.executeQuery();
				
				if(rs.next()) {
					// recuperar a variables datos de la tabla 
					int id = rs.getInt("id");
					String estado = rs.getString("estado");
					LocalDate fechaSolicitud = rs.getObject("fecha_solicitud", LocalDate.class);
					LocalDate fechaUltimaActualizacion = rs.getObject("fecha_ultima_actualizacion", LocalDate.class);
					int id_electrodomestico 		   = rs.getInt("id_electrodomestico");
					Electrodomestico electrodomestico  = electrodomesticosDAO.findElectrodomesticoById(id_electrodomestico);
					// instanciar objeto Cliente
					return new Orden(id, estado, fechaSolicitud , fechaUltimaActualizacion, electrodomestico );
				
				}else {
				return null;
				}
		}
	}

	@Override
	public void crearOrden(Orden orden) throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("INSERT INTO st_orden(estado, fecha_solicitud, fecha_ultima_actualizacion, electrodomestico) VALUES(?, ?, ?, ?)");
			) {
				
				declaracion.setString(1, orden.getEstado());
				declaracion.setObject(2,orden.getFechaSolicitud());
				declaracion.setObject(3,orden.getFechaUltimaActualizacion());
				declaracion.setInt(4,orden.getElectrodomestico_id().getId());
				int filasInsertadas = declaracion.executeUpdate();
			}		
		}

	@Override
	public void editarOrden(Orden orden) throws SQLException, NamingException {
		String sql = "UPDATE st_orden"
				+" SET  estado = ?, fecha_solicitud = ?, fecha_ultima_actualizacion = ?"
				+" WHERE id = ?";
		try (
			Connection conexion = DBUtils.getConexion();
			PreparedStatement declaracion = conexion.prepareStatement(sql);
		) {
			declaracion.setString(1, orden.getEstado());
			declaracion.setObject(2,orden.getFechaSolicitud());
			declaracion.setObject(3,orden.getFechaUltimaActualizacion());
			declaracion.setInt(4,orden.getId());
			declaracion.executeUpdate();
		}
	}

	@Override
	public void eliminarOrden(int ordenId) throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("DELETE FROM st_orden WHERE id = ?");	
			){
				declaracion.setInt(1,ordenId);
				int filasEliminadas = declaracion.executeUpdate();
			} 
	}

}
