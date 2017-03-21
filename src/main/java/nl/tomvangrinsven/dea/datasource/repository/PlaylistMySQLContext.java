package nl.tomvangrinsven.dea.datasource.repository;

import nl.tomvangrinsven.dea.datasource.interfaces.IPlaylistContext;
import nl.tomvangrinsven.dea.domain.Playlist;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlaylistMySQLContext implements IPlaylistContext {
    @Override
    public ArrayList<Playlist> getAllPlaylists() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Playlist> getAllPlayListsByID(int id) throws SQLException {
        return null;
    }

    @Override
    public Playlist getPlaylistByID(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean updatePlaylist(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean insertPlaylist() throws SQLException {
        return false;
    }

    @Override
    public boolean deletePlaylist(int id) throws SQLException {
        return false;
    }
}
