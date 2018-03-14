package web.servlet;

import web.jaxws.Contact;
import web.jaxws.ContactWS;
import web.jaxws.ContactWebService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by EGBoldyr on 13.03.18.
 *
 * Альтеранативный вариант обработки POST запроса на создание новой записи
 * без описания в Spring Controller
 *
 * Если необходима замена на Spring Controller (ее нужно будет сделать в index.js)
 */

@WebServlet("/ws/new")
public class ServletNewContact extends HttpServlet {

    private ContactWS contactWS = new ContactWS();
    private ContactWebService ws = contactWS.getContactWSPort();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Contact contact = new Contact();
        contact.setName(req.getParameter("name"));
        contact.setSurname(req.getParameter("surname"));
        contact.setPhone(req.getParameter("phone"));
        contact.setEmail(req.getParameter("email"));
        ws.create(contact);
    }
}
