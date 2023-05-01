package DataAccessObject;

import DataObject.AirCraft;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class AirCraftDAO {
/*
    ArrayList<AirCraft> list = new ArrayList<>();
    Connection connection = null;
            try{
        connection= DriverManager.getConnection("jdbc:sqlite:aircraft.db");

    }
            catch (SQLException e) {
        throw new RuntimeException(e);
    }
            finally {
        if(connection!=null)
        {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            connection=null;
        }
    }
            return list;
*/


    public static List<AirCraft> getAllAirCrafts()
        {
            ArrayList<AirCraft> list = new ArrayList<>();
            Connection connection = null;
            try{
                 connection= DriverManager.getConnection("jdbc:sqlite:aircraft.db");
                 PreparedStatement statement = connection.prepareStatement("SELECT * FROM Aircrafts");
                 ResultSet rs =  statement.executeQuery();
                 while(rs.next())
                 {
                     list.add(new AirCraft(
                             rs.getInt("id"),
                             rs.getInt("year"),
                             rs.getString("name"),
                             rs.getString("country")
                     ));
                 }
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }
            finally {
                if(connection!=null)
                {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    connection=null;
                }
            }
            return list;
        }



}
