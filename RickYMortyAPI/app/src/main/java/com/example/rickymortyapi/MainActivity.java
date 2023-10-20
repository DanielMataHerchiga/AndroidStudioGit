package com.example.rickymortyapi;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String CHARACTER_ID = "CHARACTER_ID";
    private CharacterViewModel characterViewModel;

    private RecyclerView recyclerView;
    private CharacterAdapter characterAdapter;

    private Button prevButton;
    private Button nextButton;

    private int pageNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        characterViewModel = new ViewModelProvider(this).get(CharacterViewModel.class);

        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        characterAdapter = new CharacterAdapter();
        recyclerView.setAdapter(characterAdapter);

        characterViewModel.getCharacterList().observe(this, characters -> {
            characterAdapter.setCharacterList(characters);
            characterAdapter.notifyDataSetChanged();
        });

        characterViewModel.loadCharacters(pageNumber);

        prevButton.setOnClickListener(view -> {
            if (pageNumber > 1) {
                pageNumber--;
                characterViewModel.loadCharacters(pageNumber);
            }
        });

        nextButton.setOnClickListener(view -> {
            pageNumber++;
            characterViewModel.loadCharacters(pageNumber);
        });

        characterAdapter.setClickListener(new CharacterAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, Character character) {
                Log.d(TAG, "Clickando");
                lanzar(character.getId());
            }
        });
    }

    private void lanzar(int id){
        Intent intento =  new Intent(this, Detail.class);
        intento.putExtra(CHARACTER_ID, id);
        startActivity(intento);
    }
}