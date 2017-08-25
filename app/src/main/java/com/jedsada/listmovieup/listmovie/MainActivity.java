package com.jedsada.listmovieup.listmovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jedsada.listmovieup.R;
import com.jedsada.listmovieup.listmovie.adaptermovie.MovieAdapter;
import com.jedsada.listmovieup.listmovie.model.MovieDetailModel;
import com.jedsada.listmovieup.listmovie.model.MovieModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieAdapterListener {

    private RecyclerView listMovie;
    private View loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_movie);

        listMovie = (RecyclerView) findViewById(R.id.list_movie);
        loading = findViewById(R.id.loading);

        setupListMovie();
    }

    private void setupListMovie() {
        final MovieAdapter movieAdapter = new MovieAdapter();
        movieAdapter.setMoviAdapterListener(this);

        listMovie.setLayoutManager(new LinearLayoutManager(this));
        listMovie.setAdapter(movieAdapter);

        HttpManager.getInstance().getService().loadListMovie()
                .enqueue(new Callback<MovieModel>() {
                    @Override
                    public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                        if (response.isSuccessful()) {
                            loading.setVisibility(View.GONE);
                            movieAdapter.setListMovie(response.body().getResults());
                        } else {
                            // TODO : handler error
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieModel> call, Throwable t) {
                        // TODO : handler error
                    }
                });
    }

    @Override
    public void movieItemClick(MovieDetailModel model) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("data", model);
        startActivity(intent);
    }
}
