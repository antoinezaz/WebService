package Models;

import com.google.gson.internal.StringMap;

import java.util.ArrayList;
import java.util.List;

public class VilleModel {
    private int id;
    private String name;
    private int temp;

    private static int ID = 0;

    public VilleModel() {}

    public VilleModel(String name, int temp) {
        this.id = ID++; // increment ID to allow unique ID
        this.name = name;
        this.temp = temp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    //method to cast List to List<VilleModel>
    public static List<VilleModel> CastList(List list) {
        List<VilleModel> villeModels = new ArrayList<>();

        //it's a list of StringMap with id->double, name->String and temp->double
        for (Object object : list) {
            StringMap stringMap = (StringMap) object;
            //create villeModel from stringMap
            VilleModel villeModel = new VilleModel();
            villeModel.setId((int) (double) stringMap.get("id"));
            villeModel.setName((String) stringMap.get("name"));
            villeModel.setTemp((int) (double) stringMap.get("temp"));
            villeModels.add(villeModel);
        }
        return villeModels;
    }
}
