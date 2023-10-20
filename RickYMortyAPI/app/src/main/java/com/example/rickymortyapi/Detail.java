package com.example.rickymortyapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

public class Detail extends AppCompatActivity {

    TextView specie, name, status;
    ImageView image;
    CharacterViewModel vm;
    LiveData<Character> data;
    Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();
        Integer characterId = i.getIntExtra(MainActivity.CHARACTER_ID, 0);
        Log.d("ID", characterId + "");

        name = findViewById(R.id.name);
        specie = findViewById(R.id.specie);
        status = findViewById(R.id.status);
        image = findViewById(R.id.image);

        vm = new ViewModelProvider(this).get(CharacterViewModel.class);
        //vm.init();
        data = vm.getCharacter();
        vm.loadCharacter(characterId);
        //vm.searchVolumesById(2);

        data.observe(this, (data)-> {
            //Log.d("Fallo", data.getItems().toString());
            character = data;
            specie.setText(specie.getText().toString() + ": " + character.getSpecies());
            status.setText(status.getText().toString() + ": " + character.getStatus());
            name.setText(name.getText().toString() + ": " + character.getName());
            if (character.getImageUrl() != null) {
                Glide.with(this).load(character.getImageUrl()).override(Target.SIZE_ORIGINAL).into(image);
            }
        });

    }
}