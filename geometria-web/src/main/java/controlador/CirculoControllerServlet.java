package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Circulo;

import java.io.IOException;

/**
 * Servlet implementation class CirculoControllerServlet
 */
public class CirculoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CirculoControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 RECUPERAR LOS VALORES ENVIADOS DESDE EL FORMULARIO
		String operacion = request.getParameter("operacion");
		String diametroStr = request.getParameter("diametro");
		//2 CONVERTIR AL TIPO DE DATO DESEADO
		double diametro = Double.parseDouble(diametroStr);
		//3 UTILIZAR LAS CLASES MODELO PARA HACER CALCULOS O ACCIONES
		Circulo circulo = new Circulo(diametro);
		
		if(operacion.equalsIgnoreCase("area")) {
			double area = circulo.calcularAreaC();//CALCULARAREA ES UN MIEMBRO
			request.setAttribute("resultado", area);
			request.setAttribute("operacion", "area");
		}else {
			Double perimetro = circulo.calcularPerimetro();
			request.setAttribute("resultado",perimetro);
			request.setAttribute("operacion", "perimetro");//PARA ADECUAR LAS PALABRAS QUE SE PONGAN CON TILDE
		}
		//4 DELEGAR A UNA VISTA PARA QUE MUESTRE EL O LOS RESULTADOS
		String rutaJSPC = "WEB-INF/jsp/view/circulo.jsp";
		//PASAMOS LOS DATOS A JSP
		request.getRequestDispatcher(rutaJSPC).forward(request,response);
			
		}


}
