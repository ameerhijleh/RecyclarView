package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.example.recyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    RecyclarAdaptar adaptar ;
    List<String> movieList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        movieList = new ArrayList<>();
         init();
        initRecyclarView();
        binding.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                movieList.add("movie 16");
                movieList.add("movie 17");
                movieList.add("movie 18");
                movieList.add("movie 19");
                movieList.add("movie 20");
                movieList.add("movie 21");
                adaptar.notifyDataSetChanged();
                binding.swipeRefreshLayout.setRefreshing(false);

            }
        });

    }
    private void init(){
        movieList.add("movie 1");
        movieList.add("movie 2");
        movieList.add("movie 3");
        movieList.add("movie 4");
        movieList.add("movie 5");
        movieList.add("movie 6");
        movieList.add("movie 7");
        movieList.add("movie 8");
        movieList.add("movie 9");
        movieList.add("movie 10");
        movieList.add("movie 11");
        movieList.add("movie 12");
        movieList.add("movie 13");
        movieList.add("movie 14");
        movieList.add("movie 15");

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.rv.addItemDecoration(dividerItemDecoration);

        adaptar = new RecyclarAdaptar(movieList);

    }
    public void initRecyclarView(){
        binding.rv.setAdapter(adaptar);
    }
}