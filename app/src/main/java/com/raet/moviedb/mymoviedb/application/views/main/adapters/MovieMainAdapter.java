package com.raet.moviedb.mymoviedb.application.views.main.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.raet.moviedb.mymoviedb.R;
import com.raet.moviedb.mymoviedb.model.entities.PopularMovie;
import com.raet.moviedb.mymoviedb.model.images.ImagesDataSource;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lourdes on 15/11/16.
 */

public class MovieMainAdapter extends RecyclerView.Adapter<MovieMainAdapter.MovieCardViewHolder> {
    private static final int TOTAL_START_NUMBER = 5;
    private List<PopularMovie> mPopularMovieList = new ArrayList<>();
    private Context mContext;

    // Provide a suitable constructor (depends on the kind of mPopularMovieList)
    public MovieMainAdapter(Context context, List<PopularMovie> popularMovieList) {
        mContext = context;
        mPopularMovieList = popularMovieList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MovieMainAdapter.MovieCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie_card, parent, false);
        MovieCardViewHolder vh = new MovieCardViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MovieCardViewHolder holder, int position) {
        // - get element from your mPopularMovieList at this position
        // - replace the contents of the view with that element
        holder.mTitleMovie.setText(mPopularMovieList.get(position).getTitle());
        holder.mDescriptionMovie.setText(mPopularMovieList.get(position).getOverview());
        float rating = ((mPopularMovieList.get(position).getVote_average() * TOTAL_START_NUMBER) / 10);
        holder.mRatingMovie.setNumStars(TOTAL_START_NUMBER);
        holder.mRatingMovie.setRating(rating);
        ImagesDataSource.getInstance().putImage(mContext, mPopularMovieList.get(position).getPoster_path(), holder.mPorterMovie);

    }

    // Return the size of your mPopularMovieList (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPopularMovieList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MovieCardViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        @BindView(R.id.item_layout_image_poster_iv)
        ImageView mPorterMovie;
        @BindView(R.id.item_layout_movie_rating_bar)
        RatingBar mRatingMovie;
        @BindView(R.id.item_layout_movie_title_tv)
        TextView mTitleMovie;
        @BindView(R.id.item_layout_movie_description_tv)
        TextView mDescriptionMovie;


        public MovieCardViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

