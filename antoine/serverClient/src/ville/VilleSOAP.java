package ville;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService(targetNamespace = "")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface VilleSOAP {

    @WebMethod
    public String getVilles();

    @WebMethod
    public String getVillesMin(int temp);

}
