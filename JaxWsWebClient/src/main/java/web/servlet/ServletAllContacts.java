package web.servlet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import web.jaxws.Contact;
import web.jaxws.ContactWS;
import web.jaxws.ContactWebService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by EGBoldyr on 13.03.18.
 *
 * Альтернативный вариант GET запроса для получения данных из БД
 * без описания SpringController
 */

@WebServlet("/ws/all")
public class ServletAllContacts extends HttpServlet {

    private ContactWS contactWS = new ContactWS();
    private ContactWebService ws = contactWS.getContactWSPort();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Contact> contacts = ws.findAll().getItem();
        JSONArray jsonArray = new JSONArray();

        for (Contact contact : contacts) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("id", contact.getId());
            jsonObj.put("name", contact.getName());
            jsonObj.put("surname", contact.getSurname());
            jsonObj.put("phone", contact.getPhone());
            jsonObj.put("email", contact.getEmail());
            jsonArray.add(jsonObj);
        }
        /*Тип ответа*/
        resp.setContentType("application/javascript");
        /*Тело ответа*/
        PrintWriter response = resp.getWriter();
        response.println(jsonArray.toJSONString());
        response.close();
    }
}
