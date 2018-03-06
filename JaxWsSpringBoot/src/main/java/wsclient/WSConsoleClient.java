package wsclient;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;

public class WSConsoleClient {

    public static void main(String[] args) throws Exception {

        String address = "http://localhost:8090/services/web_service_test";

        Service service = Service.create(new URL(address + "?wsdl"),
                new QName("http://impl.jaxws.ws/" , "WebTest"));
        Dispatch<Source> disp = service.createDispatch(
                new QName("http://impl.jaxws.ws/" , "PortTest"),
                Source.class, Mode.PAYLOAD);

        /*Осталось распарсить результат :)*/

    }
}