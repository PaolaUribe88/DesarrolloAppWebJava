package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Rectangulo;

import java.io.IOException;

/**
 * Servlet implementation class RectanguloControllerServlet
 */
public class RectanguloControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RectanguloControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 RECUPERAR LOS VALORES ENVIADOS DESDE EL FORMULARIO
		String operacion = request.getParameter("operacion");
		String baseStr = request.getParameter("base");
		String alturaStr = request.getParameter("altura");
		//2 CONVERTIR AL TIPO DE DATO DESEADO
		double base = Double.parseDouble(baseStr);//PARSEINT ES UN MIEMBRO DE CLASE (STATIC)
		double altura = Double.parseDouble(alturaStr);
		//3 UTILIZAR LAS CLASES MODELO PARA HACER CALCULOS O ACCIONES
		Rectangulo rectangulo = new Rectangulo(base, altura);
	
		if(operacion.equalsIgnoreCase("area")) {
			double area = rectangulo.calcularArea();//CALCULARAREA ES UN MIEMBRO
			request.setAttribute("resultado", area);
			request.setAttribute("operacion", "area");
		}else {
			Double perimetro = rectangulo.calcularPerimetro();
			request.setAttribute("resultado",perimetro);
			request.setAttribute("operacion", "perimetro");//PARA ADECUAR LAS PALABRAS QUE SE PONGAN CON TILDE
		}
						
		//4 DELEGAR A UNA VISTA PARA QUE MUESTRE EL O LOS RESULTADOS
		String rutaJSP = "/WEB-INF/jsp/view/rectangulo.jsp";
		//PASAMOS LOS DATOS A JSP
		request.getRequestDispatcher(rutaJSP).forward(request,response);
		
			
				
		//
		/**response.getWriter()
		.append("Base = "+base+"\n")
		.append("Altura = "+altura);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
