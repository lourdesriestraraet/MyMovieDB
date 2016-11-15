package com.raet.moviedb.mymoviedb.model.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lourdes on 7/11/16.
 */

public class ResponsePopularMovie {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<PopularMovie> results;
    @SerializedName("total_results")
    private int total_results;
    @SerializedName("total_pages")
    private int total_pages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<PopularMovie> getResults() {
        return results;
    }

    public void setResults(List<PopularMovie> results) {
        this.results = results;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    @Override
    public String toString() {
        return "ResponsePopularMovie{" +
                "page=" + page +
                ", results=" + results.toString() +
                ", total_results=" + total_results +
                ", total_pages=" + total_pages +
                '}';
    }
}
