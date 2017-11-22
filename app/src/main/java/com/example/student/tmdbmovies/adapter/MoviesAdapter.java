package com.example.student.tmdbmovies.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.student.tmdbmovies.MovieDetailActivity;
import com.example.student.tmdbmovies.R;
import com.example.student.tmdbmovies.models.Movie;
import com.example.student.tmdbmovies.models.MovieResult;
import com.example.student.tmdbmovies.models.Result;

import java.util.List;

/**
 * This class is responsible for styling items in the RecyclerView.
 * Created by Student on 7/15/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private Context mContext;
    private List<Result> moviesList;
    private String posterPath = "http://image.tmdb.org/t/p/w500";

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView posterimageView;
        public View mView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            posterimageView = (ImageView) view.findViewById(R.id.image_view_poster);
            mView = view;
        }
    }


    public MoviesAdapter(Context context, List<Result> moviesResultList) {
        this.moviesList = moviesResultList;
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Result movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie. getOverview());
        holder.year.setText(movie.getReleaseDate());
        //Use glide to load images
        Glide.with(mContext)
                .load(posterPath+movie.getPosterPath())
                .into(holder.posterimageView);
        //Add onClickListener
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(mContext, MovieDetailActivity.class);
               mContext.startActivity(intent);
               //Toast.makeText(mContext, movie.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}

