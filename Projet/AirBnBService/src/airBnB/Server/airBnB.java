package airBnB.Server;

/**
 * Created by Julien on 02/06/2016.
 * Classe : airBnB Interface du fichier Bean airBnBImplement.
 */
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface airBnB {

    // Fonction qui retourne les villes et leur température supérieur ou égale à la valeur spécifiée.
    @WebMethod
    public String getAllAirBnB(int temp);
}
