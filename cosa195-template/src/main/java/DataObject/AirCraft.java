package DataObject;

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

    public AirCraft(int id, int year,String name,String country)
    {
        this.id=id;
        this.year=year;
        this.name=name;
        this.country=country;
    }
}
