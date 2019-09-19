package com.sikesalnew.myapplication.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sikesalnew.myapplication.Model.Movie;
import com.sikesalnew.myapplication.R;

public class MovieDetail extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        TextView title = findViewById(R.id.tv_title);
        TextView date = findViewById(R.id.tv_date);
        TextView desc = findViewById(R.id.tv_desc);
        ImageView poster = (ImageView) findViewById(R.id.img_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        String s_title = movie.getTitle_movie();
        String s_moviedesc = movie.getMovie_desc();
        String s_moviedate = movie.getDate_movie();
        int poster_movie = movie.getPhoto();


        title.setText(s_title);
        desc.setText(s_moviedesc);
        date.setText(s_moviedate);
        poster.setImageResource(poster_movie);

    }
}
