package nl.tomvangrinsven.dea.datasource.interfaces;

import nl.tomvangrinsven.dea.domain.Track;


import java.sql.SQLException;
import java.util.ArrayList;



public interface ITrackContext {
    ArrayList<Track> getAllTracks() throws SQLException;
    Track getTrackByID() throws SQLException;
    boolean updateTrack(String name, Track track) throws SQLException;
    boolean deleteTrack(String name) throws SQLException;
    boolean insertTrack(Track track) throws SQLException;


}
