package com.sikesalnew.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sikesalnew.myapplication.Model.Movie;
import com.sikesalnew.myapplication.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ListViewHolder> {
    private ArrayList<Movie> listMovie;
    private OnItemClickCallback onItemClickCallback;

    public MovieAdapter(ArrayList<Movie> list) {
        this.listMovie = list;
    }


    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Movie movie = listMovie.get(position);
        holder.title_movie.setText(movie.getTitle_movie());
        holder.release_date.setText(movie.getDate_movie());
        holder.desc_movie.setText(movie.getMovie_desc());
        holder.img_movie.setImageResource(movie.getPhoto());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMovie.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView img_movie;
        TextView title_movie, release_date, desc_movie;


        ListViewHolder(View itemView) {
            super(itemView);
            img_movie = itemView.findViewById(R.id.img_movie);
            title_movie = itemView.findViewById(R.id.txt_title_movie);
            release_date = itemView.findViewById(R.id.txt_release_date);
            desc_movie = itemView.findViewById(R.id.txt_desc_movie);
            img_movie = itemView.findViewById(R.id.img_movie);

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Movie data);
    }


}


