package wsclient;

import java.io.StringReader;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.Service.Mode;

import org.apache.cxf.staxutils.StaxUtils;

public class WSConsoleClient {

    public static void main(String[] args) throws Exception {
        String address = "http://localhost:8090/services/web_service_test";
        String request = "<q0:WebTest xmlns:q0=\"http://impl.jaxws.ws/\"></q0:WebTest>";

        StreamSource source = new StreamSource(new StringReader(request));
        Service service = Service.create(new URL(address + "?wsdl"),
                new QName("http://impl.jaxws.ws/" , "WebTest"));
        Dispatch<Source> disp = service.createDispatch(
                new QName("http://impl.jaxws.ws/" , "PortTest"),
                Source.class, Mode.PAYLOAD);

        Source result = disp.invoke(source);
        String resultAsString = StaxUtils.toString(result);
        System.out.println(resultAsString);

    }
}