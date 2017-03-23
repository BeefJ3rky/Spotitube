package nl.tomvangrinsven.dea.datasource.repository;

import nl.tomvangrinsven.dea.datasource.interfaces.ITrackContext;
import nl.tomvangrinsven.dea.domain.Song;
import nl.tomvangrinsven.dea.domain.Track;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import java.sql.SQLException;
import java.util.ArrayList;

@Alternative
public class TrackLocalDAO implements ITrackContext{
    @Override
    public ArrayList<Track> getAllTracks() throws SQLException {
        ArrayList<Track> returnList = new ArrayList<>();
        returnList.add(new Song("leroy", "leroy", "leroy", 20, "leroy"));
        return returnList;
    }

    @Override
    public Track getTrackByID() throws SQLException {
        return null;
    }

    @Override
    public boolean updateTrack(String name, Track track) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteTrack(String name) throws SQLException {
        return false;
    }

    @Override
    public boolean insertTrack(Track track) throws SQLException {
        return false;
    }
}
