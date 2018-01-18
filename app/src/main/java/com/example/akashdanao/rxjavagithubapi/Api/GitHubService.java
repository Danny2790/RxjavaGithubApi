package com.example.akashdanao.rxjavagithubapi.Api;

import com.example.akashdanao.rxjavagithubapi.Model.GitHubRepo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by akash.danao on 18/01/18.
 */

public interface GitHubService {

    @GET("users/{user}/starred") Observable<List<GitHubRepo>> getStarredRepositories (@Path("user") String  userName);
}
