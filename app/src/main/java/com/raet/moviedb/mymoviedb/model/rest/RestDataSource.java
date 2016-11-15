package com.raet.moviedb.mymoviedb.model.rest;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.raet.moviedb.mymoviedb.model.rest.utils.interceptors.MyMovieDBSigningInterceptor;

import java.lang.reflect.Modifier;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lourdes on 3/11/16.
 */

public class RestDataSource {
    public static String END_POINT = "https://api.themoviedb.org/";
    private static Retrofit retrofit;

    public RestDataSource() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new MyMovieDBSigningInterceptor())
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create(gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }

    private Gson gson() {
        ExclusionStrategy skipTransientFields = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes attributes) {
                return attributes.hasModifier(Modifier.TRANSIENT);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };
        Gson gson = new GsonBuilder()
                .setExclusionStrategies(skipTransientFields)
                //.registerTypeAdapter(CalendarArgument.class, new CalendarArgumentAdapter())
                // .registerTypeAdapter(DepartmentTeamAvailabilityArgument.class, new DepartmentTeamAvailabilityArgumentAdapter())
                .create();

        return gson;
    }
}
