package hu.javanetacademy.hoe.goodsOfEmpires.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.javanetacademy.hoe.goodsOfEmpires.dao.model.GoodsOfEmpires;
import hu.javanetacademy.hoe.goodsOfEmpires.service.object.GoodsOfEmpiresService;
import hu.javanetacademy.hoe.user.dao.model.User;

/**
 * @author adam
 */
@WebServlet(name = "GoodsOfEmpiresServlet", urlPatterns = { "/goodsOfEmpires/goodsOfEmpires" })
public class GoodsOfEmpiresServlet extends HttpServlet {

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
	// + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		GoodsOfEmpiresService hs = new GoodsOfEmpiresService();
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("goodsOfEmpireses", hs.getGoodsOfEmpiresByUser(user.getId()));

		getServletContext().getRequestDispatcher("/goodsOfEmpires/list.jsp").include(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		GoodsOfEmpires newGoodsOfEmpires = new GoodsOfEmpires();
		newGoodsOfEmpires.setName(request.getParameter("pname"));
		newGoodsOfEmpires.setDescription(request.getParameter("pdesc"));
		newGoodsOfEmpires.setGoodid(user.getId());
		GoodsOfEmpiresService hs = new GoodsOfEmpiresService();
		hs.create(newGoodsOfEmpires);
		doGet(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
