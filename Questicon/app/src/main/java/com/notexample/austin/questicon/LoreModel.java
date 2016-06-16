package com.notexample.austin.questicon;

/**
 * Created by austin on 6/16/16.
 */
public class LoreModel {
    String titleLore, movieIMAGE, URLVideo;



    public LoreModel(String titleLore, String movieID, String URLVideo) {
        this.titleLore = titleLore;
        this.movieIMAGE = movieID;
        this.URLVideo = URLVideo;
    }

    public String getURLVideo() {
        return URLVideo;
    }

    public void setURLVideo(String URLVideo) {
        this.URLVideo = URLVideo;
    }

    public String getTitleLore() {
        return titleLore;
    }

    public void setTitleLore(String titleLore) {
        this.titleLore = titleLore;
    }

    public String getMovieIMAGE() {
        return movieIMAGE;
    }

    public void setMovieIMAGE(String movieID) {
        this.movieIMAGE = movieID;
    }
}
