package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Alumno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlumnosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AlumnosController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1- CREAR INSTANCIAS
		List<Alumno> alumnos = Arrays.asList(
				new Alumno(1, "Pilar Cabas ", " 11111111-1"," Copernico 01867 "," Temuco ")
				,new Alumno(2, "Pedro Escamoso ", " 22222222-2 "," Apoquindo 321 "," Con-Con ")
				,new Alumno(3, "Javier Toribio ", " 33333333-3 "," Laraquete 22 "," Hualqui ")
				,new Alumno(4, "Agusto Glupp ", " 4444444-4 "," Charle 22 "," La Florida ")
				,new Alumno(2, "Pedro Picapiedra ", " 12123456-0 "," Dinosaurio 3 "," Rocapiedra "));
		//2- SETEAR EL ATRIBUTO QUE SE ENVIARA AL JSP
		request.setAttribute("alumnos", alumnos);
		//3- DESPACHAR LA RESPONSABILIDAD AL JSP
		request.getRequestDispatcher("WEB-INF/jsp/view/alumnos.jsp")
		.forward(request, response);
	}


}
