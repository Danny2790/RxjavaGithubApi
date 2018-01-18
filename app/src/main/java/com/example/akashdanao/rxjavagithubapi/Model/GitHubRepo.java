package com.example.akashdanao.rxjavagithubapi.Model;

/**
 * Created by akash.danao on 18/01/18.
 */

public class GitHubRepo {

    public int id;
    public String name;
    public  String description;

    public GitHubRepo(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "GitHubRepo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
