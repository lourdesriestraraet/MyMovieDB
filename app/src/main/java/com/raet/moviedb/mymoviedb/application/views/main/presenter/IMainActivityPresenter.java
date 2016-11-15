package com.raet.moviedb.mymoviedb.application.views.main.presenter;

import com.raet.moviedb.mymoviedb.application.views.main.activities.MainActivity;
import com.raet.moviedb.mymoviedb.model.entities.PopularMovie;

import java.util.List;

/**
 * Created by lourdes on 14/11/16.
 */
public interface IMainActivityPresenter {
    void create(MainActivity mainActivity);

    void getMoviesData();

    void setPopularMovieInformation(List<PopularMovie> results);
}
