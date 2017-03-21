package nl.tomvangrinsven.dea.datasource.interfaces;

import nl.tomvangrinsven.dea.domain.Playlist;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPlaylistContext {
    ArrayList<Playlist> getAllPlaylists() throws SQLException;
    ArrayList<Playlist> getAllPlayListsByID(int id) throws SQLException;
    Playlist getPlaylistByID(int id) throws SQLException;
    boolean updatePlaylist(int id) throws SQLException;
    boolean insertPlaylist() throws SQLException;
    boolean deletePlaylist(int id) throws SQLException;
}
