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

    public static List<AirCraft> getAllAirCrafts(String country)
    {
        ArrayList<AirCraft> list = new ArrayList<>();
        Connection connection = null;
        try{
            connection= DriverManager.getConnection("jdbc:sqlite:aircraft.db");
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Aircrafts WHERE country=?");
            statement.setString(1,country);
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

    public static void delAirCraft(int id)
    {
        Connection connection = null;
        try{
            connection= DriverManager.getConnection("jdbc:sqlite:aircraft.db");
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Aircrafts WHERE id=?");
            statement.setInt(1,id);
            statement.executeUpdate();
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
    }

    public  static  void addAirCraft(AirCraft airCraft)
    {
        Connection connection = null;
        try{
            connection= DriverManager.getConnection("jdbc:sqlite:aircraft.db");

            PreparedStatement statement;
            if(airCraft.getId()==0) {
                statement = connection.prepareStatement("INSERT INTO Aircrafts(year,name,country) VALUES(?,?,?)");
            }
            else
            {
                statement = connection.prepareStatement("UPDATE Aircrafts SET year=?, name=?, country=? WHERE id=?");
                statement.setInt(4,airCraft.getId());
            }
            statement.setInt(1,airCraft.getYear());
            statement.setString(2,airCraft.getName());
            statement.setString(3,airCraft.getCountry());
            statement.executeUpdate();
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

    }


}
