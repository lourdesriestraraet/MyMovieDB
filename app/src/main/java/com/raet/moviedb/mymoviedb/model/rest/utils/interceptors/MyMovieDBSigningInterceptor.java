package com.raet.moviedb.mymoviedb.model.rest.utils.interceptors;


import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lourdes on 3/11/16.
 */

public class MyMovieDBSigningInterceptor implements Interceptor {
    private static String PARAM_API_KEY = "api_key";
    private static String VALUE_API_KEY = "435f3644abcd49312b72d1ed0d583364";
    private static String PARAM_LANGUAJE = "language";
    private static String VALUE_LANGUAJE = "en-US";

    public MyMovieDBSigningInterceptor() {
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request oldRequest = chain.request();

        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url().newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host());

        authorizedUrlBuilder.addQueryParameter(PARAM_API_KEY, VALUE_API_KEY);
        authorizedUrlBuilder.addQueryParameter(PARAM_LANGUAJE, VALUE_LANGUAJE);

        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}
