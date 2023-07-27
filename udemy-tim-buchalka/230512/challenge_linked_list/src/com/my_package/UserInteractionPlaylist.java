package com.my_package;

import java.util.LinkedList;
import java.util.Scanner;

public class UserInteractionPlaylist {
    // Add new song
    // a song can be added if it belongs to a album
    // remove the song from the playlist
    // create a menu to the user to choose:
    // play song
    // quit app
    // skip forward
    // next song
    // previous song
    // replay current song
    // list the songs in the playlist


    // for now we'll suppose that we have just playlist
    // but later we can add more playlists

    /*
    * This is where the user will give commands to the application this is only to be used in the CLI.
    * */
    public static void commandLineUserInterface(){
        // for now we'll use just one playlist for everything but later we can add the option to create more
        // playlists, later we can add commands to create, rename, delete a playlist
        Playlist defaultPlaylist = new Playlist("Default Playlist");

        // At the start we should list all commands
        listOptions();
        Scanner scanner = new Scanner(System.in);
        Boolean isRunning = true;
        while (isRunning){
            // quit:         q
            // list options: l
            //
            System.out.println("What is your command? Type here: ");
            String userCommand = scanner.next();
            switch (userCommand){
                case "q":
                    isRunning = false;
                    quitApp();
                    break;
                case "h":
                    listOptions();
                    break;
                case "l":
                    showAllSongsInPlaylist(defaultPlaylist);
                    break;
            }
        }
    }

    public static void showAllSongsInPlaylist(Playlist defaultPlaylist){
        System.out.println("List all songs in play list...");

        LinkedList<Song> linkedList = defaultPlaylist.getPlaylist();

    }

    public static void addNewSongToPlaylist() {
    }

    public static void deleteSongFromPlaylist() {
    }

    public static void playSong() {
    }

    public static void nextSong() {
    }

    public static void previousSong() {
    }

    public static void listOptions(){
        System.out.println("+-----------------------------------------------------+");
        System.out.println("| Those are all possible commands that you can use:   |");
        System.out.println("| - 'h' : list all commands                           |");
        System.out.println("| - 'q' : quit program                                |");
        System.out.println("| - 'l' : list all songs in playlist                  |");
        System.out.println("+-----------------------------------------------------+");
    }

    public static void quitApp() {
        System.out.println("Quiting...");
    }

}
