package ville;

import Models.VilleModel;
import Models.VillesHelper;
import com.google.gson.Gson;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "ville.VilleSOAP")
public class VilleImplSOAP implements VilleSOAP {

    private static List<VilleModel> villeModels;

    public VilleImplSOAP() {
        //generate city mock data
        villeModels = VillesHelper.GenerateVilles();
    }

    @Override
    public String getVilles() {
        return convertToJson(villeModels); //convert list to Json
    }

    //return all cities where temperature is higher than min temp requested
    @Override
    public String getVillesMin(int temp) {
        List<VilleModel> newListModel = new ArrayList<>(); //create newList
        for (VilleModel villeModel : villeModels) {
            if (villeModel.getTemp() >= temp) {
                newListModel.add(villeModel); //add city if temp is higher than temp
            }
        }
        return convertToJson(newListModel); //convert list to Json
    }

    private String convertToJson(List<VilleModel> villeModels) {
        return new Gson().toJson(villeModels);
    }

}
