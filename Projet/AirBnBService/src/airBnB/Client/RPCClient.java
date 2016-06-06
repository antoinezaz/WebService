package airBnB.Client;

/**
 * Created by Julien on 03/06/2016.
 * Classe : RPCClient qui permet de récupérer les données des hotels sur le serveur.
 */

import java.net.URL;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcCommonsTransportFactory;

public class RPCClient {

    public static void main(String[] args) throws Exception {
        // Création et configuration de la connexion au serveur
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://127.0.0.1:18081/xmlrpc"));
        config.setEnabledForExtensions(true);
        config.setConnectionTimeout(60 * 1000);
        config.setReplyTimeout(60 * 1000);

        XmlRpcClient client = new XmlRpcClient();

        // Utilisation d'un HttpClient pour créer la passerelle entre le client et le serveur
        client.setTransportFactory(
                new XmlRpcCommonsTransportFactory(client));
        // Configuration client/serveur
        client.setConfig(config);

        // Appelle du serveur pour récupérer les hotels.
        Object[] params = null;
        String result = (String) client.execute("RPCServer.getHotel", params);
        System.out.println(result);

    }
}
