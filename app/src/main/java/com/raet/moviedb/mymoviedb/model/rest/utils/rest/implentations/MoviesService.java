package com.raet.moviedb.mymoviedb.model.rest.utils.rest.implentations;

import android.util.Log;

import com.raet.moviedb.mymoviedb.model.entities.ResponsePopularMovie;
import com.raet.moviedb.mymoviedb.model.rest.utils.rest.interfaces.IMovies;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * Created by lourdes on 7/11/16.
 */

public class MoviesService {
    public Observable<ResponsePopularMovie> getPopular(IMovies moviesRest) {
        return moviesRest.getPopular()
                .flatMap(
                        new Func1<ResponsePopularMovie, Observable<ResponsePopularMovie>>() {
                            @Override
                            public Observable<ResponsePopularMovie> call(ResponsePopularMovie results) {
                                Log.d("YUJU", "Yuju");
                                return storePopulars(results);
                            }
                        }
                );
    }

    public Observable<ResponsePopularMovie> storePopulars(final ResponsePopularMovie results) {
        return Observable.create(new Observable.OnSubscribe<ResponsePopularMovie>() {

            @Override
            public void call(Subscriber<? super ResponsePopularMovie> subscriber) {
                // For the moment
                subscriber.onNext(results);
                subscriber.onCompleted();
            }
        });
    }
}
