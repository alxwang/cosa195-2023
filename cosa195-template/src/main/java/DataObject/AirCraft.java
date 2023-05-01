package DataObject;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class AirCraft implements Serializable {
    int id;

    public int getId() {
        return id;
    }

    int year;

    public int getYear() {
        return year;
    }

    String name;

    public String getName() {
        return name;
    }

    String country;

    public String getCountry() {
        return country;
    }


//    {
//        "id": 2,
//            "year": 1942,
//            "name": "Ambrosini SAI.207",
//            "country": "Italy"
//    },
    @JsonCreator
    public AirCraft(@JsonProperty("id") int id,
                    @JsonProperty("year") int year,
                    @JsonProperty("name") String name,
                    @JsonProperty("country") String country)
    {
        this.id=id;
        this.year=year;
        this.name=name;
        this.country=country;
    }
}
