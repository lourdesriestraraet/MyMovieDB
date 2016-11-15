package com.raet.moviedb.mymoviedb.application.views.main.services;

import android.util.Log;

import com.raet.moviedb.mymoviedb.application.views.main.activities.MainActivity;
import com.raet.moviedb.mymoviedb.application.views.main.presenter.IMainActivityPresenter;
import com.raet.moviedb.mymoviedb.model.entities.ResponsePopularMovie;
import com.raet.moviedb.mymoviedb.model.rest.RestDataSource;
import com.raet.moviedb.mymoviedb.model.rest.utils.rest.implentations.MoviesService;
import com.raet.moviedb.mymoviedb.model.rest.utils.rest.interfaces.IMovies;

import rx.Observer;

/**
 * Created by lourdes on 14/11/16.
 */

public class PopularMoviesServices implements IPopularMoviesServices {
    private static final String TAG = PopularMoviesServices.class.getSimpleName();
    private MainActivity mActivity;
    private IMainActivityPresenter mPresenter;

    public PopularMoviesServices(MainActivity mainActivity, IMainActivityPresenter mainActivityPresenter) {
        mPresenter = mainActivityPresenter;
        mActivity = mainActivity;
    }

    @Override
    public void getPopularMovies() {
        RestDataSource restDataSource = new RestDataSource();
        MoviesService movies = new MoviesService();

        movies.getPopular(restDataSource.create(IMovies.class)).subscribe(
                new Observer<ResponsePopularMovie>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted getPopularMovies");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "onError getPopularMovies", e);
                    }

                    @Override
                    public void onNext(ResponsePopularMovie response) {
                        Log.d(TAG, "onNext getPopularMovies");
                        mPresenter.setPopularMovieInformation(response.getResults());
                    }

                }
        );
    }
}
