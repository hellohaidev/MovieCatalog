package com.techinfo.moviecatalog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieDetailActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_title";
    
    TextView tvTitle,tvDescription;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        
        tvTitle = findViewById(R.id.tv_title);
        tvDescription = findViewById(R.id.tv_desc);
        imageView = findViewById(R.id.img_photo);
        
        Movie movie = getIntent().getParcelableExtra("movie");
        tvTitle.setText(movie.getName());
        tvDescription.setText(movie.getDescription());
        Glide.with(this)
                .load(movie.getPhoto())
                .apply(new RequestOptions())
                .into(imageView);
        
        
    }
}
