package hu.javanetacademy.hoe.armor.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.javanetacademy.hoe.armor.service.ArmorService;
import hu.javanetacademy.hoe.armor.service.imp.ArmorServiceImpl;

/**
 *
 * @author Gonda Gergely
 *
 */
@WebServlet(name = "ArmorServlet", urlPatterns = { "/armor/armor" })
public class ArmorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final ArmorService armorService;

	public ArmorServlet() {
		armorService = new ArmorServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO
		super.doGet(req, resp);
	}

}
