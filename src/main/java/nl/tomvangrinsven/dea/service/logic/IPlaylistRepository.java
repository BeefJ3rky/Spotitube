package nl.tomvangrinsven.dea.service.logic;

import nl.tomvangrinsven.dea.domain.Playlist;

import javax.enterprise.inject.Default;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Tom van Grinsven on 3/21/2017.
 */
public interface IPlaylistRepository {
    ArrayList<Playlist> getAllPlaylists() throws SQLException;

    ArrayList<Playlist> getAllPlayListsByID(int id) throws SQLException;

    Playlist getPlaylistByID(int id) throws SQLException;

    boolean updatePlaylist(int id) throws SQLException;

    boolean insertPlaylist() throws SQLException;

    boolean deletePlaylist(int id) throws SQLException;
}
