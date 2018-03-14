package web.servlet;

import web.jaxws.ContactWS;
import web.jaxws.ContactWebService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by EGBoldyr on 14.03.18.
 */

@WebServlet("/ws/delete")
public class ServletDeleteContact extends HttpServlet {

    private ContactWS contactWS = new ContactWS();
    private ContactWebService ws = contactWS.getContactWSPort();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ws.delete(ws.read(Long.parseLong(req.getParameter("id"))));
    }
}
