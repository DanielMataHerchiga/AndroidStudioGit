package com.example.rickymortyapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private List<Character> characters = new ArrayList<>();


    public void setCharacterList(List<Character> characters) {
        this.characters = characters;
        notifyDataSetChanged();
    }

    public interface ItemClickListener {
        void onClick(View view, Character character);
    }

    private ItemClickListener clickListener;

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.nameTextView.setText(character.getName());
        holder.speciesTextView.setText(character.getSpecies());
        holder.statusTextView.setText(character.getStatus());
        Glide.with(holder.itemView.getContext()).load(character.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView nameTextView;
        TextView speciesTextView;
        TextView statusTextView;

        CharacterViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            speciesTextView = itemView.findViewById(R.id.speciesTextView);
            statusTextView = itemView.findViewById(R.id.statusTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Character ch = characters.get(getAdapterPosition());
            ch.getId();
            if (clickListener != null) clickListener.onClick(view, ch);
        }
    }
}
