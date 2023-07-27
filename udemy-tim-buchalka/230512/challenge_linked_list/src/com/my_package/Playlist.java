package com.my_package;

import java.util.LinkedList;

public class Playlist {
    private String name;
    private LinkedList<Song> playlist;

    public Playlist(String name) {
        this.name = name;
        this.playlist = new LinkedList<Song>();
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }
}
