package Hotel;

import Models.HotelModel;
import Models.VillesHelper;
import com.google.gson.Gson;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;
import java.util.List;
import java.util.stream.Collectors;

public class HotelServer {
    private List<HotelModel> hotelModels;

    public HotelServer() {
        hotelModels = VillesHelper.GeneratesHotel();
    }

    public String getHotels(List<Integer> ids) {
        //filter list. Return all elements match with ids and convert to Json
        return convertToJson(hotelModels.stream().filter(hotelModel -> ids.contains(hotelModel.getIdVille())).collect(Collectors.toList()));
    }

    private String convertToJson(List<HotelModel> hotelModels) {
        return new Gson().toJson(hotelModels);
    }

    public static void main(String[] args) {
        try {
            System.out.println("Attempting to start XML-RPC Server...");
            WebServer webServer = new WebServer(18080);

            XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

            //Add Handler to rcpServer. The handler is itself
            PropertyHandlerMapping phm = new PropertyHandlerMapping();
            phm.addHandler("HotelServer", HotelServer.class);
            xmlRpcServer.setHandlerMapping(phm);

            //add config for rcp server
            XmlRpcServerConfigImpl serverConfig =
                    (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
            serverConfig.setEnabledForExtensions(true);
            serverConfig.setContentLengthOptional(false);

            //start server
            webServer.start();
            System.out.println("Started successfully.");

        } catch (Exception e) {
            System.err.println("Java Server: " + e);
        }
    }
}
