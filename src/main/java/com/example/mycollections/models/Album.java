package com.example.mycollections.models;

public class Album extends LibraryItem {
    private String artist;
    private int tracks;

    public Album(String name, int year, String artist, int tracks) {
        super(name, year);
        this.artist = artist;
        this.tracks = tracks;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getTracks() {
        return tracks;
    }

    public void setTracks(int tracks) {
        this.tracks = tracks;
    }
}
