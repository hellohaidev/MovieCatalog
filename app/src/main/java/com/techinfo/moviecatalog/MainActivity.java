package com.techinfo.moviecatalog;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    
    private String[] dataName;
    private String[] dataDesc;
    private TypedArray dataPhoto;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);
        prepare();
        addItem();
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,movies.get(position).getName(),Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(MainActivity.this,MovieDetailActivity.class);
                intent.putExtra("movie",movies.get(position));
                startActivity(intent);
                
                
            }
        });
    }
    
    private void addItem(){
        movies = new ArrayList<>();
        for (int i = 0;i<dataName.length;i++){
            Movie movie = new Movie();
            movie.setName(dataName[i]);
            movie.setDescription(dataDesc[i]);
            movie.setPhoto(dataPhoto.getResourceId(i,-1));
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
    
    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_title);
        dataPhoto = getResources().obtainTypedArray(R.array.data_pict);
        dataDesc = getResources().getStringArray(R.array.data_desc);
    }
}
