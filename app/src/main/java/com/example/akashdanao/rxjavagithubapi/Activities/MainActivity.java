package com.example.akashdanao.rxjavagithubapi.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.akashdanao.rxjavagithubapi.Api.GithubClient;
import com.example.akashdanao.rxjavagithubapi.Model.GitHubRepo;
import com.example.akashdanao.rxjavagithubapi.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_fetch_git)
    Button buttonFetch;
    String  TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_fetch_git)
    public void setButtonFetch(View v){
        Toast.makeText(this, " Button clicked ", Toast.LENGTH_SHORT).show();
        Subscription subscription = GithubClient.getInstance()
                                    .getStarredRepos("danny")
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(new Observer<List<GitHubRepo>>() {
                                        @Override
                                        public void onCompleted() {
                                            Log.d(TAG, "onCompleted: ");
                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Log.d(TAG, "onError: " );
                                            e.printStackTrace();
                                        }

                                        @Override
                                        public void onNext(List<GitHubRepo> gitHubRepos) {
                                            Log.d(TAG, "onNext: " + gitHubRepos.toString());
                                        }
                                    });
    }
}
