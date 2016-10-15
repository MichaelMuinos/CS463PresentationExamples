package com.justplaingoatappsgmail.listviewexample;

public class GameListing {

    private int gameImage;
    private double price;
    private String genre;
    private String title;

    public GameListing(int gameImage, double price, String genre, String title) {
        this.gameImage = gameImage;
        this.price = price;
        this.genre = genre;
        this.title = title;
    }

    public int getGameImage() {
        return gameImage;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

}
