package com.my_package;

public class SongManager {

    public static Album addNewAlbum(String name) {
        System.out.println("Creating new Album: " + name);
        return new Album(name);
    }

    public static void addNewSong(Album album, String title, Integer duration) {
        System.out.println("Creating new song: " + title + "; In album: " + album.getName());
        Song newSong = new Song(title, duration);
        album.addNewSongToAlbum(newSong);
    }


}
