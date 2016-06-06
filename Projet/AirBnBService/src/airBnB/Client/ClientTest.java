package airBnB.Client;

import airBnB.Server.airBnB;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Created by Julien on 02/06/2016.
 * Classe : ClientTest permet d'appeler le service web et de récupérer les informations sur le serveur.
 */
public class ClientTest {
    public static void main(String[] argv) throws MalformedURLException {

        // Déclaration de l'url sur serveur Tomcat
        URL wsdlURL = new URL("http://localhost:18080/services/airBnB?wsdl");

        // Déclaration d'un QName en utilisant un chemin d'accès et un nom
        QName qname = new QName("http://airBnB/", "airBnBImplementService");

        // Création et appel du service
        Service service = Service.create(wsdlURL, qname);

        // Passage de l'interface et de la classe Bean au client
        airBnB adressI = service.getPort(airBnB.class);

        // Déclaration d'une liste pour récupérer les informations
        HashMap<String, Double> list;

        // Récupération des villes et de leur température
        list = new Gson().fromJson(adressI.getAllAirBnB(25), HashMap.class);

        // Affichage des données
        System.out.println(list);

        // Tentative de connexion sur le serveur du binome
        Client client = Client.create();
        WebResource webResource = client.resource("http://10.33.1.53:28080/login");
        User user = new User();
        user.setEmail("antoine@antoine.fr");
        user.setPwd("antoine");
        ClientResponse response = webResource.accept("application/json")
                .type("application/json").post(ClientResponse.class, new Gson().toJson(user));

        int status = response.getStatus();
    }


}
