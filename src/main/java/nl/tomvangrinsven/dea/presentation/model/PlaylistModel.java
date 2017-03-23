package nl.tomvangrinsven.dea.presentation.model;


import nl.tomvangrinsven.dea.domain.Track;

import java.util.ArrayList;

public class PlaylistModel {
    public void setTracks(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }

    private ArrayList<Track> tracks;

    public PlaylistModel(ArrayList<Track> tracks) {
        this.tracks = tracks;
    }


}
