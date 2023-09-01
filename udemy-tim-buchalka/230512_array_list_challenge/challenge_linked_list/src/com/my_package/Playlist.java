package com.my_package;

import java.util.Iterator;
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

    public void addSong(Song song) {
        this.playlist.add(song);
    }

    public void addWholeAlbum(Album album) {
        Iterator<Song> iterator = album.getListOfSongs().iterator();
        while (iterator.hasNext()){
            Song song = iterator.next();
            this.playlist.add(song);
        }
    }
}
