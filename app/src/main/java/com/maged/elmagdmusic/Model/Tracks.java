package com.maged.elmagdmusic.Model;

public class Tracks {
    private String title; // Stores the title
    private String artist; // Stores the artist
    private String albumTitle;// Stores the album title
    private int album_res; // Stores the image res id

    /**
     * Creates a constructor of the Tracks class
     * @param title
     * @param artist
     * @param albumTitle
     * @param album_res
     */
    public Tracks(String title, String artist, String albumTitle, int album_res) {
        this.title = title;
        this.artist = artist;
        this.album_res = album_res;
        this.albumTitle = albumTitle;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getAlbum_res() {
        return album_res;
    }
    }




