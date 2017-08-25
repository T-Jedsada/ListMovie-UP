package com.jedsada.listmovieup.listmovie.adaptermovie;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jedsada.listmovieup.R;
import com.jedsada.listmovieup.listmovie.model.MovieDetailModel;

class MovieViewHolder extends RecyclerView.ViewHolder {

    private AppCompatImageView imgMovie;
    private TextView tvNameMovie;
    private TextView tvDesMovie;

    public interface MovieViewHolderListener {

        void onItemClick(int position);
    }

    MovieViewHolder(View itemView) {
        super(itemView);
        imgMovie = itemView.findViewById(R.id.img_movie);
        tvNameMovie = itemView.findViewById(R.id.tv_name_movie);
        tvDesMovie = itemView.findViewById(R.id.tv_des_movie);
    }

    void onBindData(MovieDetailModel movieDetailModel, final MovieViewHolderListener listener) {
        tvNameMovie.setText(movieDetailModel.getTitle());
        tvDesMovie.setText(movieDetailModel.getOverview());

        Glide.with(itemView.getContext())
                .load(String.format("http://image.tmdb.org/t/p/w780/%s", movieDetailModel.getBackdropPath()))
                .into(imgMovie);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(getAdapterPosition());
                }
            }
        });
    }
}
