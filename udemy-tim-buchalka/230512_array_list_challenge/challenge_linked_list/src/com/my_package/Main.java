package com.my_package;

public class Main {

    // Create a program that implements a playlist for songs
    // Create a Song class having Title and Duration for a song.
    // The program will have an Album class containing a list of songs.
    // The albums will be stored in an ArrayList
    // Songs from different albums can be added to the playlist and will appear in the list in the order
    // they are added.
    // Once the songs have been added to the playlist, create a menu of options to:-
    // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
    // List the songs in the playlist
    // A song must exist in an album before it can be added to the playlist (so you can only play songs that
    // you own).
    // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
    // started tracking the direction we were going.
    // As an optional extra, provide an option to remove the current song from the playlist
    // (hint: listiterator.remove()

    // TODO: we could try to build this application using C also.
    public static void main(String[] args) {
        // Just creating some Songs
        // Linkin Park
        Album meteora = SongManager.addNewAlbum("Meteora");
        SongManager.addNewSong(meteora, "Numb", 188);
        SongManager.addNewSong(meteora, "Faint", 231);
        SongManager.addNewSong(meteora, "In the end", 131);
        SongManager.addNewSong(meteora, "Somewhere I belong", 431);

        // Foo Fighters
        Album inYourHonour = SongManager.addNewAlbum("In Your Honour");
        SongManager.addNewSong(inYourHonour, "Best of you", 188);
        SongManager.addNewSong(inYourHonour, "No way back", 188);
        System.out.println("------------------------------------------------------------------------------");

        // Run UserInteractionPlaylist
        UserInteractionPlaylist.commandLineUserInterface();
    }


}
