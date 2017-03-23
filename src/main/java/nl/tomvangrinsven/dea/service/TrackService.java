package nl.tomvangrinsven.dea.service;


import nl.tomvangrinsven.dea.datasource.interfaces.ITrackContext;
import nl.tomvangrinsven.dea.domain.Track;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.sql.SQLException;
import java.util.List;


@Path("/tracks")
public class TrackService {

    @Inject
    ITrackContext context;

    @GET
    @Produces("application/json")
    public List<Track> getTracks() throws SQLException{
        return context.getAllTracks();
    }
}
