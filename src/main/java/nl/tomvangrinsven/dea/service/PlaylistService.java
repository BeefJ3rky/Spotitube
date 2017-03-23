package nl.tomvangrinsven.dea.service;

import com.google.inject.Inject;
import nl.tomvangrinsven.dea.datasource.interfaces.IPlaylistContext;
import nl.tomvangrinsven.dea.domain.Playlist;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.SQLException;
import java.util.ArrayList;


@Path("/playlists")
public class PlaylistService {

    @Inject
    private IPlaylistContext context;

    @GET
    @Produces("application/json")
    public ArrayList<Playlist> getLists() throws SQLException {
        return context.getAllPlaylists();
    }



}
