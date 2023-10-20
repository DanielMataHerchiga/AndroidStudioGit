package com.example.rickymortyapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("character")
    Call<ApiResponse> getCharacters(@Query("page") int page);

    @GET("character/{characterId}")
    Call<Character> getCharacter(@Path("characterId") int characterId);
}
