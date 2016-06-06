package airBnB.Server;

/**
 * Created by Julien on 03/06/2016.
 * Classe : RPCServer est un serveur contenant un service qui contient une base de données sur les hotels.
 */

import com.google.gson.Gson;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.server.XmlRpcServer;
import org.apache.xmlrpc.server.XmlRpcServerConfigImpl;
import org.apache.xmlrpc.webserver.WebServer;

import java.util.HashMap;

public class RPCServer {
    private static final int port = 18081;
    HashMap<String,String> listHotel = new HashMap();

    // Construction de la base de données
    public RPCServer () {
        listHotel.put("AccordHotel", "Paris");
        listHotel.put("Hotel Paris Gambette", "Paris");

        listHotel.put("Hotel Riquet", "Toulouse");
        listHotel.put("Hotel Saint sermin", "Toulouse");

        listHotel.put("Alhambre Hotel", "Londre");
        listHotel.put("Palace court Hotel", "Londre");

        listHotel.put("Hotel d'Orsay", "Orsay");

        listHotel.put("Hotel Novotel Massy", "Palaiseau");
        listHotel.put("La Cabane", "Palaiseau");
        listHotel.put("Hôtel Mercure", "Palaiseau");

        listHotel.put("Hôtel le Village", "Gif-Sur-Yvette");
        listHotel.put("Residhome Bures sur Yvette", "Bure-Sur-Yvette");
        listHotel.put("B&B Hôtel Saclay", "Saclay");
    }

    /* Fonction principal permettant de configurer le serveur et de le démarer */
    public static void main(String[] args) throws Exception {
        // Attribution d'un port au serveur
        WebServer webServer = new WebServer(port);

        XmlRpcServer xmlRpcServer = webServer.getXmlRpcServer();

        PropertyHandlerMapping phm = new PropertyHandlerMapping();

        // Liaison de la classe au serveur
        phm.addHandler("RPCServer", RPCServer.class);

        xmlRpcServer.setHandlerMapping(phm);

        XmlRpcServerConfigImpl serverConfig =
                (XmlRpcServerConfigImpl) xmlRpcServer.getConfig();
        serverConfig.setEnabledForExtensions(true);
        serverConfig.setContentLengthOptional(false);

        // Démarage du serveur
        webServer.start();
    }

    public String getHotel() {
        return new Gson().toJson(listHotel);
    }
}
