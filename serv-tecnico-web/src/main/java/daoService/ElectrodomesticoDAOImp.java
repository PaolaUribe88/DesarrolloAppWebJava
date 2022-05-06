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

import modelo.Cliente;
import modelo.Electrodomestico;


public class ElectrodomesticoDAOImp  implements ElectrodomesticoDAO{
		ClienteDAO clienteDAO;
	
	public ElectrodomesticoDAOImp(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	@Override
	public List<Electrodomestico> findAllElectrodomesticos() throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();		
				Statement declaracion = conexion.createStatement();
		){
			ResultSet rs = declaracion.executeQuery("SELECT FROM st_cliente");
			List<Electrodomestico> electrodomesticos = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String tipo = rs.getString("tipo");
				String descripcionProblema = rs.getString("descripcion_problema");
				Electrodomestico electrodomestico= new Electrodomestico(id, nombre, tipo, descripcionProblema );
				electrodomesticos.add(electrodomestico);
			}
			return electrodomesticos;
		}
	}

	@Override
	public Electrodomestico findElectrodomesticoById(int electrodomesticoId) throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();
				PreparedStatement  declaracion = conexion.prepareStatement("SELECT * FROM st_cliente WHERE ID =?");
			) {		
				declaracion.setInt(1, electrodomesticoId);
				ResultSet rs = declaracion.executeQuery();
				
				if(rs.next()) {
					// recuperar a variables datos de la tabla 
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					String tipo = rs.getString("tipo");
					String descripcionProblema = rs.getString("descripcion_problema");
					Cliente cliente = clienteDAO.findClienteById(id);
										// instanciar objeto Cliente
					return new Electrodomestico(id,nombre ,tipo ,descripcionProblema);
				
				}else {
				return null;
				}
		}
	}

	@Override
	public void crearElectrodomestico(Electrodomestico electrodomestico) throws SQLException, NamingException {
		try(
				Connection conexion = DBUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("INSERT INTO st_electrodomestico(nombre, tipo, descripcion_porblema)VALUES (?,?,?)")
			){
				declaracion.setString(1,electrodomestico.getNombre());
				declaracion.setString(2,electrodomestico.getTipo());
				declaracion.setString(3,electrodomestico.getDescripcionProblema());
				declaracion.setObject(4,electrodomestico.getCliente_id());
				int filasInsertadas = declaracion.executeUpdate();
		}

		
	}

	@Override
	public void editarElectrodomestico(Electrodomestico electrodomestico) throws SQLException, NamingException {
		String sql = "UPDATE st_electrodomestico"
				+" SET  nombre = ?, tipo = ?, descripcion_problema = ?, cliente_id =?"
				+" WHERE id = ?";
		try (
			Connection conexion = DBUtils.getConexion();
			PreparedStatement declaracion = conexion.prepareStatement(sql);
		) {
			declaracion.setString(1, electrodomestico.getNombre());
			declaracion.setString(2,electrodomestico.getTipo());
			declaracion.setString(3,electrodomestico.getDescripcionProblema());
			declaracion.setObject(4,electrodomestico.getCliente_id());
			declaracion.executeUpdate();
			
		}
	}

	@Override
	public void eliminarElectrodomestico(int electrodomesticoId) throws SQLException, NamingException {
		try (
				Connection conexion = DBUtils.getConexion();
				PreparedStatement declaracion = conexion.prepareStatement("DELETE FROM st_electrodomestico WHERE id = ?");	
			){
			declaracion.setInt(1, electrodomesticoId);
		}
	}

}
