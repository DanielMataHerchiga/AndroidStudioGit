package com.example.rickymortyapi;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("info")
    private Info info;

    @SerializedName("results")
    private List<Character> characters;

    public Info getInfo() {
        return info;
    }

    public List<Character> getCharacters() {
        return characters;
    }
}
