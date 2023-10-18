package com.example.rickymortyapi;

import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterViewModel extends ViewModel {

    private MutableLiveData<List<Character>> characterList = new MutableLiveData<>();
    private MutableLiveData<Character> character = new MutableLiveData<>();

    public LiveData<List<Character>> getCharacterList() {
        return characterList;
    }

    public LiveData<Character> getCharacter() {
        return character;
    }

    public void loadCharacters(int page) {
        Call<ApiResponse> call = RetrofitInstance.getRetrofitInstance().create(ApiService.class).getCharacters(page);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Character> characters = response.body().getCharacters();
                    characterList.postValue(characters);
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                //Toast.makeText(App.getContext(), "Error al cargar los personajes", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void loadCharacter(int characterId) {
        Call<Character> call = RetrofitInstance.getRetrofitInstance().create(ApiService.class).getCharacter(characterId);
        call.enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                Character ch = response.body();
                character.postValue(ch);
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                //Toast.makeText(App.getContext(), "Error al cargar los personajes", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
