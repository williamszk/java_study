package com.my_package;

import java.util.ArrayList;

public class Album {
    // TODO: we can add later the name of the band
    // TODO: we can add the year of release of the album
    private String name;
    private ArrayList<Song> listOfSongs;

    public Album(String name) {
        this.name = name;
        this.listOfSongs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getListOfSongs() {
        return listOfSongs;
    }

    public void addNewSongToAlbum(Song song) {
        this.listOfSongs.add(song);
    }
}
