package com.jedsada.listmovieup.listmovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jedsada.listmovieup.R;
import com.jedsada.listmovieup.listmovie.model.MovieDetailModel;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        MovieDetailModel model = getIntent().getParcelableExtra("data");

        Glide.with(this)
                .load(String.format("http://image.tmdb.org/t/p/w780/%s", model.getBackdropPath()))
                .into((AppCompatImageView) findViewById(R.id.img_banner));

        ((TextView) findViewById(R.id.tv_name)).setText(model.getTitle());
        ((TextView) findViewById(R.id.tv_des)).setText(model.getOverview());
    }
}
