package com.example.akashdanao.rxjavagithubapi.Api;

import com.example.akashdanao.rxjavagithubapi.Model.GitHubRepo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by akash.danao on 18/01/18.
 */

public class GithubClient {

    private static final String BASE_URL = "https://api.github.com/";
    private GitHubService gitHubService;
    private static GithubClient mInstance;

    public GithubClient(){
        final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
        final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                                                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                                .addConverterFactory(GsonConverterFactory.create(gson))
                                                .build();
        gitHubService = retrofit.create(GitHubService.class);
    }

    public static GithubClient getInstance(){
        if (mInstance == null){
            mInstance = new GithubClient();
        }
        return  mInstance;
    }

    public rx.Observable<List<GitHubRepo>> getStarredRepos(String usernsame){
       return gitHubService.getStarredRepositories(usernsame);
    }
}
