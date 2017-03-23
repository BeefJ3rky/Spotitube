package nl.tomvangrinsven.dea.domain;


public class Song extends Track {

    private String album;

    public Song(String performer, String title, String url, long duration, String album) {
        super(performer, title, url, duration);
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }



}
