package daoService;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import modelo.Electrodomestico;

public interface ElectrodomesticoDAO {
	public List<Electrodomestico> findAllElectrodomesticos() throws SQLException, NamingException;
	public Electrodomestico findElectrodomesticoById(int electrodomesticoId)throws SQLException, NamingException;
	public void crearElectrodomestico(Electrodomestico electrodomestico)throws SQLException, NamingException;
	public void editarElectrodomestico(Electrodomestico electrodomestico)throws SQLException, NamingException;
	public void eliminarElectrodomestico(int electrodomesticoId)throws SQLException, NamingException;

}
