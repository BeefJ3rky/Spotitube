package nl.tomvangrinsven.dea.service.logic;

import nl.tomvangrinsven.dea.datasource.interfaces.IPlaylistContext;
import nl.tomvangrinsven.dea.domain.Playlist;

import javax.enterprise.inject.Default;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaylistRepository implements IPlaylistRepository {
    private IPlaylistContext context;

    public PlaylistRepository(IPlaylistContext context) {
        this.context = context;
    }

    @Override
    public ArrayList<Playlist> getAllPlaylists() throws SQLException {
        return context.getAllPlaylists();
    }


    @Override
    public ArrayList<Playlist> getAllPlayListsByID(int id) throws SQLException {
        return context.getAllPlayListsByID(id);
    }


    @Override
    public Playlist getPlaylistByID(int id) throws SQLException {
        return context.getPlaylistByID(id);
    }


    @Override
    public boolean updatePlaylist(int id) throws SQLException {
        return context.updatePlaylist(id);
    }


    @Override
    public boolean insertPlaylist() throws SQLException {
        return context.insertPlaylist();
    }


    @Override
    public boolean deletePlaylist(int id) throws SQLException {
        return context.deletePlaylist(id);
    }
}
