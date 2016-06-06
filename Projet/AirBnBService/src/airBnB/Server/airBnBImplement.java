package airBnB.Server;


import com.google.gson.Gson;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Julien on 02/06/2016.
 * Classe : airBnBImplement classe Bean permettant de récupérer les villes et leur température.
 */

@WebService(endpointInterface = "airBnB.Server.airBnB")
public class airBnBImplement implements airBnB {
    HashMap<String, Double> listCity = new HashMap();

    // Initialisation de la base de données.
    public airBnBImplement () {
        listCity.put("Paris", 30.00);
        listCity.put("Londre", 77.00);
        listCity.put("Toulouse", 25.00);
        listCity.put("Orsay", 12.00);
        listCity.put("Palaiseau", 55.00);
        listCity.put("Gif-Sur-Yvette", 39.00);
        listCity.put("Bure-sur-Yvette", 13.00);
        listCity.put("Saclay", 22.00);
    }

    /* Fonction qui retourne une nouvelle liste des ville dont la température est supérieur ou égale à la valeur spécifié*/
    @Override
    public String getAllAirBnB(int temp) {
        // Déclaration de la nouvelle liste
        HashMap<String,Double> listCityValide = new HashMap<>();
        // Parcourt de la base de données
        for (Map.Entry<String, Double> entry: listCity.entrySet()) {
            // Remplissage de la nouvelle liste.
            if (entry.getValue() >= temp)
                listCityValide.put(entry.getKey(), entry.getValue());
        }

        // Envoie de la nouvelle liste sous forme de String pour permettre la conversion JSON.
        return new Gson().toJson(listCityValide);
    }

    /* Fonction principal qui permet de construire le Endpoint pour envoyer la liste au  client */
    public static void main(String[] argv) {
        Object implementor = new airBnBImplement();
        String address = "http://localhost:9000/airBnBImplement";
        Endpoint.publish(address, implementor);
    }
}
