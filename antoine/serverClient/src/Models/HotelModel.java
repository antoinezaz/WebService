package Models;

import com.google.gson.internal.StringMap;

import java.util.ArrayList;
import java.util.List;

public class HotelModel {
    private String name;
    private int idVille;

    public HotelModel(String name, int idVille) {
        this.name = name;
        this.idVille = idVille;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    //method to cast List to List<HotelModel>
    public static List<HotelModel> CastList(List list) {
        List<HotelModel> modelList = new ArrayList<>();
        // it's a list of stringMap object with name->String and idVille->Double
        for (Object object : list) {
            StringMap stringMap = (StringMap) object;
            HotelModel hotelModel = new HotelModel((String) stringMap.get("name"), (int)((double) stringMap.get("idVille")));
            modelList.add(hotelModel);
        }
        return modelList;
    }
}
