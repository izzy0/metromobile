package com.russwilkie.metrostatemobile;

/**
 * Used to make ListView Child Items into Clickable Links
 */

public class LinkableItem {

    private String mName;
    private String mLink;

    public LinkableItem(String name, String link) {

        this.mName = name;
        this.mLink = link;
    }

    public String getLink() {

        return mLink;
    }

    public void setLink(String link) {

        this.mLink = link;
    }

    public String getName() {

        return mName;
    }

    public void setName(String name) {

        this.mName = name;
    }

    @Override
    public String toString() {

        return this.mName;
    }
}

