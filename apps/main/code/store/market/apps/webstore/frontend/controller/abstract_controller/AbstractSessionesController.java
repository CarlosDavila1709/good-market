package store.market.apps.webstore.frontend.controller.abstract_controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;

public abstract class AbstractSessionesController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private void generarSessionId(HttpSession session) {	
		
		session.setAttribute("session_id", getSessionId());
	}
	
	public String sessionId(HttpSession session) {
		String sessionActual = (String)session.getAttribute("session_id");
		
		if(sessionActual == null) {
			generarSessionId(session);
		}
		
		return (String)session.getAttribute("session_id");
	}

	public void inicializacionSessionCarrito(HttpSession session) {
		session.setAttribute("cart_items", "0");
		session.setAttribute("cart_total", "0.00");
	}
	public void actualizarSessionCarrito(HttpSession session,Double monto,int items) {
		session.setAttribute("cart_items", items);
		session.setAttribute("cart_total", monto);
	}
	
	private String getSessionId() {

		System.out.println("session id: " + RequestContextHolder.currentRequestAttributes().getSessionId());
		return RequestContextHolder.currentRequestAttributes().getSessionId();

	}
}
