package com.raet.moviedb.mymoviedb.model.rest.utils.rest.interfaces;

import com.raet.moviedb.mymoviedb.model.entities.ResponsePopularMovie;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by lourdes on 7/11/16.
 */

public interface IMovies {
    public static final String MyPath = "/3/movie/";

    @GET(MyPath + "popular")
    Observable<ResponsePopularMovie> getPopular();

}
