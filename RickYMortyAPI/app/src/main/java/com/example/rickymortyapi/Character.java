package com.example.rickymortyapi;

import com.google.gson.annotations.SerializedName;

public class Character {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("status")
    private String status;

    @SerializedName("species")
    private String species;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return image;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }
}
