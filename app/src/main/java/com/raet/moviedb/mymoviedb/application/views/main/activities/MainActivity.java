package com.raet.moviedb.mymoviedb.application.views.main.activities;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.raet.moviedb.mymoviedb.R;
import com.raet.moviedb.mymoviedb.application.views.main.adapters.MovieMainAdapter;
import com.raet.moviedb.mymoviedb.application.views.main.presenter.IMainActivityPresenter;
import com.raet.moviedb.mymoviedb.application.views.main.presenter.MainActivityPresenter;
import com.raet.moviedb.mymoviedb.model.entities.PopularMovie;

import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    IMainActivityPresenter presenter = new MainActivityPresenter();
    // @BindView(R.id.main_activity_popular_movie_recycler)
    RecyclerView mMovieContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        initUi();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void initData() {
        presenter.create(this);
    }

    private void initUi() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMovieContainer = (RecyclerView) findViewById(R.id.main_activity_popular_movie_recycler);
        mMovieContainer.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mMovieContainer.setHasFixedSize(true);
    }

    public void setPopularMovieInformation(List<PopularMovie> popularMovieInformation) {
        MovieMainAdapter movieMainAdapter = new MovieMainAdapter(getApplicationContext(), popularMovieInformation);
        mMovieContainer.setAdapter(movieMainAdapter);
    }
}
