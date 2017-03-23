package nl.tomvangrinsven.dea.datasource.repository;

import nl.tomvangrinsven.dea.domain.Song;
import nl.tomvangrinsven.dea.domain.Track;
import nl.tomvangrinsven.dea.datasource.MySQLConnectionFactory;
import nl.tomvangrinsven.dea.datasource.interfaces.ITrackContext;

import javax.enterprise.inject.Default;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Default
public class TrackMySQLDAO implements ITrackContext {

    private MySQLConnectionFactory connectionFactory = new MySQLConnectionFactory();
    private Statement stmt = null;
    private String query = null;
    private ArrayList<Track> returnList = null;
    private Track track = null;

    @Override
    public ArrayList<Track> getAllTracks() throws SQLException{
        returnList = new ArrayList<>();
        String sqlQuery = "select * from track where type = 0";
        try(
                Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sqlQuery);
                ResultSet rs = ps.executeQuery();
        ){ while(rs.next()){
            returnList.add(new Song(
                    rs.getString("performer"),
                    rs.getString("title"),
                    rs.getString("url"),
                    rs.getLong("duration"),
                    rs.getString("album")
                    ));
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
        //try {

            //catch (SQLException e){e.printStackTrace();}
            //finally {closeConnection(conn);}

        return null;
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
