package nl.tomvangrinsven.dea.service.logic;

import nl.tomvangrinsven.dea.datasource.interfaces.ITrackContext;
import nl.tomvangrinsven.dea.domain.Track;

import java.sql.SQLException;
import java.util.List;


public class TrackRepository {

    private ITrackContext context;

    public TrackRepository(ITrackContext context) {
        this.context = context;
    }

    public List<Track> getAllTracks() throws SQLException {
        return context.getAllTracks();
    }


    public Track getTrackByID() throws SQLException {
        return context.getTrackByID();
    }


    public boolean updateTrack(String name, Track track) throws SQLException {
        return context.updateTrack(name, track);
    }


    public boolean deleteTrack(String name) throws SQLException {
        return context.deleteTrack(name);
    }


    public boolean insertTrack(Track track) throws SQLException {
        return context.insertTrack(track);
    }
}
