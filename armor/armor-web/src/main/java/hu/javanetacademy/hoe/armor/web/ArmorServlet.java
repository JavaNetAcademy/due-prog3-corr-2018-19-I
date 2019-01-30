package hu.javanetacademy.hoe.armor.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.javanetacademy.hoe.armor.service.ArmorHeroXrefService;
import hu.javanetacademy.hoe.armor.service.ArmorPropertiesCodebookXreService;
import hu.javanetacademy.hoe.armor.service.ArmorService;
import hu.javanetacademy.hoe.armor.service.imp.ArmorHeroXrefServiceImpl;
import hu.javanetacademy.hoe.armor.service.imp.ArmorPropertiesCodebookXreServiceImpl;
import hu.javanetacademy.hoe.armor.service.imp.ArmorServiceImpl;
import hu.javanetacademy.hoe.armor.web.enums.Operation;
import hu.javanetacademy.hoe.user.dao.model.User;

/**
 *
 * @author Gonda Gergely
 *
 */
@WebServlet(name = "ArmorServlet", urlPatterns = { "/armor" })
public class ArmorServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String OPERATION_PARAMETER_NAME = "operation";

	private final ArmorService armorService;
	private final ArmorHeroXrefService armorHeroXrefService;
	private final ArmorPropertiesCodebookXreService armorPropertiesCodebookXreService;

	public ArmorServlet() {
		armorService = new ArmorServiceImpl();
		armorHeroXrefService = new ArmorHeroXrefServiceImpl();
		armorPropertiesCodebookXreService = new ArmorPropertiesCodebookXreServiceImpl();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Operation op = Operation.valueOfOperationParamName(req.getParameter(ArmorServlet.OPERATION_PARAMETER_NAME));

		if (op != null) {
			switch (op) {
			case ARMOR_CREATE:
				handleCreateArmor(req, resp);
				break;
			case ARMOR_DELETE:
				handleDeleteArmor(req, resp);
				break;
			case ARMOR_HX_CREATE:
				handleCreateArmorHeroXref(req, resp);
				break;
			case ARMOR_HX_DELETE:
				handleDeleteHeroXref(req, resp);
				break;
			case ARMOR_HX_DELETE_BY_H:
				handleDeleteAllByHeroId(req, resp);
				break;
			case ARMOR_HX_DELETE_BY_A:
				handleDeleteAllByArmorIdHeroXref(req, resp);
				break;
			case ARMOR_PCX_CREATE:
				handleCreatePropertiesCodebookXref(req, resp);
				break;
			case ARMOR_PCX_DELETE:
				handleDeletePropertiesCodebookXref(req, resp);
				break;
			case ARMOR_PCX_DELETE_BY_A:
				handleDeleteAllByArmorIdPropertiesCodebookXref(req, resp);
				break;
			case ARMOR_PCX_DELETE_BY_PC:
				handleDeleteAllByPropertiesCodebookId(req, resp);
				break;
			case ARMOR_UPDATE:
				handleUpdateArmor(req, resp);
				break;
			default:
				throw new ServletException(
						"Not supported operation! operation" + req.getParameter(ArmorServlet.OPERATION_PARAMETER_NAME));
			}
		} else {
			throw new ServletException("No operation parameter given!");
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Operation op = Operation.valueOfOperationParamName(req.getParameter(ArmorServlet.OPERATION_PARAMETER_NAME));

		if (op != null) {
			switch (op) {
			case ARMOR_GET_ALL:
				handleGetAllArmor(req, resp);
				break;
			case ARMOR_GET_BY_ID:
				handleGetArmorById(req, resp);
				break;
			case ARMOR_HX_GET_BY_H:
				handleGetAllArmorHeroXrefByHeroId(req, resp);
				break;
			case ARMOR_PCX_GET_BY_A:
				handleGetAllArmorPropertiesCodebookXrefByArmorId(req, resp);
				break;
			default:
				handleGetAllArmor(req, resp);
			}
		} else {
			handleGetAllArmor(req, resp);
		}

	}

	private boolean isUserLoggedIn(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean result = true;
		User user = (User) req.getSession().getAttribute("user");
		if (user == null) {
			getServletContext().getRequestDispatcher("/armor/errornotlogin.jsp").include(req, resp);
			result = false;
		}
		return result;
	}

	private void handleGetAllArmorPropertiesCodebookXrefByArmorId(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, ServletException, IOException {
		if (isUserLoggedIn(req, resp)) {
			resp.setContentType("text/html;charset=UTF-8");

			req.setAttribute("armorPropertiesCodebookXrefs",
					armorPropertiesCodebookXreService.getAllByArmorId(Long.parseLong(req.getParameter("armorId"))));
			getServletContext().getRequestDispatcher("/armor/armorPropertiesCodebookXrefList.jsp").include(req, resp);
		}
	}

	private void handleGetAllArmorHeroXrefByHeroId(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, ServletException, IOException {
		if (isUserLoggedIn(req, resp)) {
			resp.setContentType("text/html;charset=UTF-8");

			req.setAttribute("armorHeroXrefs",
					armorHeroXrefService.getAllByHeroId(Long.parseLong(req.getParameter("heroId"))));
			getServletContext().getRequestDispatcher("/armor/armorarmorHeroXrefList.jsp").include(req, resp);
		}
	}

	private void handleGetArmorById(HttpServletRequest req, HttpServletResponse resp)
			throws NumberFormatException, ServletException, IOException {
		if (isUserLoggedIn(req, resp)) {
			resp.setContentType("text/html;charset=UTF-8");
			req.setAttribute("armor", armorService.getById(Long.parseLong(req.getParameter("armorId"))));
			getServletContext().getRequestDispatcher("/armor/armor.jsp").include(req, resp);
		}
	}

	private void handleGetAllArmor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (isUserLoggedIn(req, resp)) {
			resp.setContentType("text/html;charset=UTF-8");
			req.setAttribute("armors", armorService.getAll());
			getServletContext().getRequestDispatcher("/armor/armorList.jsp").include(req, resp);
		}
	}

	private void handleCreateArmor(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleDeleteArmor(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleCreateArmorHeroXref(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleUpdateArmor(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleDeleteAllByPropertiesCodebookId(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleDeleteAllByArmorIdPropertiesCodebookXref(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleDeletePropertiesCodebookXref(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleCreatePropertiesCodebookXref(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleDeleteAllByArmorIdHeroXref(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleDeleteAllByHeroId(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

	private void handleDeleteHeroXref(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub

	}

}
