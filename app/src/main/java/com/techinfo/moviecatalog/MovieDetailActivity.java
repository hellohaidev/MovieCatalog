package com.techinfo.moviecatalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_title";
    
    TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        
        tvTitle = findViewById(R.id.tv_title);
        Movie movie = getIntent().getParcelableExtra("movie");
        tvTitle.setText(movie.getName());
        
    }
}
