package nl.tomvangrinsven.dea.service;

import com.google.inject.Inject;
import nl.tomvangrinsven.dea.datasource.interfaces.IPlaylistContext;
import nl.tomvangrinsven.dea.datasource.repository.PlaylistMySQLContext;
import nl.tomvangrinsven.dea.domain.Playlist;
import nl.tomvangrinsven.dea.service.logic.IPlaylistRepository;
import nl.tomvangrinsven.dea.service.logic.PlaylistRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.SQLException;
import java.util.ArrayList;


@Path("/playlist")
public class PlaylistService {

    @Inject
    private IPlaylistRepository repo = new PlaylistRepository(new PlaylistMySQLContext());

    @GET
    @Produces("application/json")
    public ArrayList<Playlist> getLists() throws SQLException {
        return repo.getAllPlaylists();
    }



}
