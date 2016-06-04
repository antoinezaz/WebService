package ville;

import Models.HotelModel;
import Models.User;
import Models.VilleModel;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClientTest {
    private static String token;

    public static void main(String[] argv) throws MalformedURLException, XmlRpcException {

        if (isAuthenticated()) {
            List<VilleModel> villeModels = getVilles(20);
            List<Integer> ids = new ArrayList<>();
            for (VilleModel villeModel: villeModels) {
                ids.add(villeModel.getId());
            }
            List<HotelModel> hotelModels = getHotels(ids);
            System.out.println(hotelModels);
        }
    }

    private static List<VilleModel> getVilles(int minTemp) throws MalformedURLException {
        URL wsdlURL = new URL("http://localhost:8080/services/VilleSOAP?wsdl");
        //creating QName using targetNamespace and name
        QName qname = new QName("http://ville/", "VilleImplSOAPService");
        //creating service with wsdURL and qname
        Service service = Service.create(wsdlURL, qname);

        //We need to pass interface and model beans to client
        VilleSOAP hw = service.getPort(VilleSOAP.class);

        //Cast the getVillesMin result to List of StringMap, then Cast List to List<VilleModel>
        return VilleModel.CastList(new Gson().fromJson(hw.getVillesMin(minTemp), List.class));
    }

    private static List<HotelModel> getHotels(List<Integer> ids) throws MalformedURLException, XmlRpcException {
        // create configuration
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://127.0.0.1:18080/xmlrpc"));
        config.setEnabledForExtensions(true);

        XmlRpcClient client = new XmlRpcClient();

        // use Commons HttpClient as transport
        client.setTransportFactory(new XmlRpcCommonsTransportFactory(client));
        // set configuration
        client.setConfig(config);

        // make the a regular call
        Object[] params = new Object[] {
                ids
        };

        //get Json string from the webServer
        String result = (String) client.execute("HotelServer.getHotels", params);

        //Cast the result to List of StringMap, then Cast List to List<HotelModel>
         return HotelModel.CastList(new Gson().fromJson(result, List.class));

    }

    private static boolean isAuthenticated() {
        //Init web resource to post login
        Client client = Client.create();
        WebResource webResource = client.resource("http://localhost:28080/login");

        //Prepare the request params
        User user = new User();
        user.setEmail("antoine@antoine.fr");
        user.setPassword("antoine");

        //The rest service accept only Json
        ClientResponse response = webResource.accept("application/json")
                .type("application/json").post(ClientResponse.class, new Gson().toJson(user));

        //get the result from the rest server
        int status = response.getStatus();
        token = response.getEntity(String.class);

        //return true if user is connected
        return status == 200;
    }
}

