package com.jedsada.listmovieup.listmovie.adaptermovie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jedsada.listmovieup.R;
import com.jedsada.listmovieup.listmovie.model.MovieDetailModel;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> implements MovieViewHolder.MovieViewHolderListener {

    public interface MovieAdapterListener {
        void movieItemClick(MovieDetailModel model);
    }

    private MovieAdapterListener listener;

    public void setMoviAdapterListener(MovieAdapterListener listener) {
        this.listener = listener;
    }

    private List<MovieDetailModel> list = new ArrayList<>();

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.onBindData(list.get(position), this);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListMovie(List<MovieDetailModel> results) {
        list = results;
        notifyDataSetChanged();
    }

    @Override
    public void onItemClick(int position) {
        if (listener != null) {
            listener.movieItemClick(list.get(position));
        }
    }
}