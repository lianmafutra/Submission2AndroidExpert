package com.sikesalnew.myapplication.Fragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sikesalnew.myapplication.Activity.MovieDetail;
import com.sikesalnew.myapplication.Adapter.MovieAdapter;
import com.sikesalnew.myapplication.Model.Movie;
import com.sikesalnew.myapplication.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_movie extends Fragment {

    private RecyclerView rvHeroes;
    private ArrayList<Movie> list = new ArrayList<>();
    MovieAdapter adapter;
    private TypedArray movieposter;

    private String[] movietitle, moviedate, moviedesc;
    String txt_action_bar;


    public Fragment_movie() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment_movie, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        prepare();
        rvHeroes = view.findViewById(R.id.rv_movie);
        rvHeroes.setHasFixedSize(true);
        addItem();
        rvHeroes.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new MovieAdapter(list);
        rvHeroes.setAdapter(adapter);
        adapter.setOnItemClickCallback(new MovieAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Movie data) {
                showSelectedHero(data);
            }
        });
        getActivity().getActionBar();
        getActivity().setTitle(txt_action_bar);

    }


    private void showSelectedHero(Movie hero) {
        Movie movie = new Movie();
        movie.setTitle_movie(hero.getTitle_movie());
        movie.setDate_movie(hero.getDate_movie());
        movie.setMovie_desc(hero.getMovie_desc());
        movie.setPhoto(hero.getPhoto());
        Intent moveWithObjectIntent = new Intent(getContext(), MovieDetail.class);
        moveWithObjectIntent.putExtra(MovieDetail.EXTRA_MOVIE, movie);
        startActivity(moveWithObjectIntent);
    }

    private void prepare() {
        if (getArguments().getString("type").equals("1")) {
            movietitle = getResources().getStringArray(R.array.movie_title);
            moviedate = getResources().getStringArray(R.array.movie_date);
            moviedesc = getResources().getStringArray(R.array.movie_desc);
            movieposter = getResources().obtainTypedArray(R.array.data_photo);
            txt_action_bar = "Movie List";
        }
        if (getArguments().getString("type").equals("2")) {
            movietitle = getResources().getStringArray(R.array.tv_title);
            moviedate = getResources().getStringArray(R.array.tv_date);
            moviedesc = getResources().getStringArray(R.array.tv_desc);
            movieposter = getResources().obtainTypedArray(R.array.tv_data_photo);
            txt_action_bar = "TV Show List";
        }
    }


    private void addItem() {
        list = new ArrayList<>();
        for (int i = 0; i < movietitle.length; i++) {
            Movie movie = new Movie();
            movie.setPhoto(movieposter.getResourceId(i, -1));
            movie.setTitle_movie(movietitle[i]);
            movie.setDate_movie(moviedate[i]);
            movie.setMovie_desc(moviedesc[i]);
            list.add(movie);
        }
    }


}
