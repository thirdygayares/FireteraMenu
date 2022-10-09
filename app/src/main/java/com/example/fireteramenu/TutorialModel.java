package com.example.fireteramenu;

public class TutorialModel {
    String id;
    String title;
    String link;

    public TutorialModel( String title, String link) {

        this.title = title;
        this.link = link;
    }



    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
