package Models;

import java.util.ArrayList;
import java.util.List;

public class VillesHelper {

    //generate city mock with name and temperature
    public static List<VilleModel> GenerateVilles() {
        List<VilleModel> villeModels = new ArrayList<>();

        //add cities in list
        villeModels.add(new VilleModel("Paris", 15));
        villeModels.add(new VilleModel("Londres", 10));
        villeModels.add(new VilleModel("Lyon", 20));
        villeModels.add(new VilleModel("Marseille", 22));
        villeModels.add(new VilleModel("Los Angeles", 23));
        villeModels.add(new VilleModel("New York", 18));
        villeModels.add(new VilleModel("Miami", 25));
        villeModels.add(new VilleModel("Annecy", 10));
        villeModels.add(new VilleModel("Tunis", 28));
        villeModels.add(new VilleModel("La Havane", 30));
        villeModels.add(new VilleModel("Toulouse", 21));

        return villeModels;
    }

    //generate mock hotel model
    public static List<HotelModel> GeneratesHotel() {
        List<HotelModel> hotelModels = new ArrayList<>();
        hotelModels.add(new HotelModel("Super Hotel", 0));
        hotelModels.add(new HotelModel("Paris Gambetta", 0));
        hotelModels.add(new HotelModel("Modern Hotel", 0));

        hotelModels.add(new HotelModel("Ibis London City", 1));
        hotelModels.add(new HotelModel("George Hotel", 1));
        hotelModels.add(new HotelModel("Alhambra Hotel", 1));

        hotelModels.add(new HotelModel("Axote Lyon Perrache", 2));
        hotelModels.add(new HotelModel("Hotel Lyon Metropole", 2));
        hotelModels.add(new HotelModel("Hotel Lyon Ouest", 2));

        hotelModels.add(new HotelModel("Hotel la residence", 3));
        hotelModels.add(new HotelModel("Hotel Ibis Marseille", 3));
        hotelModels.add(new HotelModel("Hotel Hermes Vieux Port", 3));

        hotelModels.add(new HotelModel("West Beverly Hills", 4));
        hotelModels.add(new HotelModel("Mondrian Los Angeles", 4));
        hotelModels.add(new HotelModel("Holiday Inn", 4));

        hotelModels.add(new HotelModel("the gotham hotel", 5));
        hotelModels.add(new HotelModel("Wellington Hotel New York", 5));
        hotelModels.add(new HotelModel("New York Marriott Marquis", 5));

        hotelModels.add(new HotelModel("New Yorker Boutique Hotel", 6));
        hotelModels.add(new HotelModel("Hotel Urbano", 6));
        hotelModels.add(new HotelModel("The Angler's Hotel", 6));

        hotelModels.add(new HotelModel("Splendid Hotel", 7));
        hotelModels.add(new HotelModel("Hotel des Alpes", 7));
        hotelModels.add(new HotelModel("Hotel Novel - Restaurant La mamma", 7));

        hotelModels.add(new HotelModel("Carlton Hotel", 8));
        hotelModels.add(new HotelModel("Le diplomat Hotel Tunis", 8));
        hotelModels.add(new HotelModel("Hotel Africa", 8));

        hotelModels.add(new HotelModel("Inglaterra Hotel", 9));
        hotelModels.add(new HotelModel("Saratoga Hotel", 9));
        hotelModels.add(new HotelModel("Hotel Plaza", 9));

        hotelModels.add(new HotelModel("Hotel de France", 10));
        hotelModels.add(new HotelModel("Residhome Toulouse Tolosa", 10));
        hotelModels.add(new HotelModel("Hotel Riquet", 10));

        return hotelModels;
    }
}
