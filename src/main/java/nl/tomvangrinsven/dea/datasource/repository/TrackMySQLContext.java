package nl.tomvangrinsven.dea.datasource.repository;

import nl.tomvangrinsven.dea.domain.Track;
import nl.tomvangrinsven.dea.datasource.MySQLConnectionFactory;
import nl.tomvangrinsven.dea.datasource.interfaces.ITrackContext;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrackMySQLContext implements ITrackContext {

    private MySQLConnectionFactory connectionFactory = new MySQLConnectionFactory();
    private Statement stmt = null;
    private String query = null;
    private ArrayList<Track> returnList = null;
    private Track track = null;

    @Override
    public List<Track> getAllTracks() throws SQLException{
        return returnList;
    }

    public List<Track> gettracks() throws SQLException {
        String sqlQuery = "";
        try(
                Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlQuery);
                ResultSet rs = ps.executeQuery();
                ){ while(rs.next()){
                   returnList.add(new Track());
        }

        }
        return returnList;
    }

    @Override
    public Track getTrackByID() throws SQLException {
        Connection conn = connectionFactory.getConnection();
        Statement stmt = conn.createStatement();
        String query = "select Code, Name from Country";
        ResultSet rs = stmt.executeQuery(query);
        try {
            track = new Track(/*rs.getString("Code"), rs.getString("Name")*/);}
        //catch (SQLException e){e.printStackTrace();}
        finally {closeConnection(conn);}
        return track;
    }

    public boolean updateTrack(String name, Track track) throws SQLException{
        Connection conn = connectionFactory.getConnection();
        PreparedStatement p = conn.prepareStatement("Update Country set Name = ? where Name = ?");
        p.setString(1, name);
        //p.setString(2, track.getName());
        if (executeNonQuery(p)){
            closeConnection(conn);
            return true;
        }
        return false;
    }

    public boolean deleteTrack(String name) throws SQLException {
        Connection conn = connectionFactory.getConnection();
        PreparedStatement p = conn.prepareStatement("Delete from Country where Name = ?");
        p.setString(1, name);
        if (executeNonQuery(p)){
            closeConnection(conn);
            return true;
        }
        return false;
    }

    public boolean insertTrack(Track track) throws SQLException {
        Connection conn = connectionFactory.getConnection();
        PreparedStatement p = conn.prepareStatement("Insert into Country values ?, ?");
        //p.setString(1, track.getCode());
        //p.setString(2, track.getName());
        if (executeNonQuery(p)){
            closeConnection(conn);
            return true;
        }
        return false;
    }

    public boolean executeNonQuery(PreparedStatement p) throws SQLException{
        try { p.executeUpdate(); return true; }
        catch (SQLException e){e.printStackTrace();}
        return false;
    }

    public void closeConnection(Connection conn) throws SQLException {
        if (conn != null){ conn.close();}
    }
}
