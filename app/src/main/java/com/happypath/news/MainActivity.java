package com.happypath.news;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BaseTransientBottomBar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.happypath.news.model.GetArticlesResponse;
import com.happypath.news.networking.NewsAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CoordinatorLayout coordinatorLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.activity_main_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.activity_main_progressbar);

        Call<GetArticlesResponse> call = NewsAPI.getApi().getArticles("reuters", "top");
        call.enqueue(new Callback<GetArticlesResponse>() {
            @Override
            public void onResponse(Call<GetArticlesResponse> call, Response<GetArticlesResponse> response) {
                progressBar.setVisibility(View.GONE);
                showNewsApiSnack();
                GetArticlesResponse body = response.body();
                NewsStore.setNewsArticles(body.getArticles());
                Toast.makeText(MainActivity.this, "Response received", Toast.LENGTH_SHORT).show();
                HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getNewsArticles());
                recyclerView.setAdapter(homeNewsAdapter);
            }

            @Override
            public void onFailure(Call<GetArticlesResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Response failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showNewsApiSnack() {
        Snackbar.make(coordinatorLayout, "Powered by NewsApi.org", BaseTransientBottomBar.LENGTH_LONG)
                .setAction("visit", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loadNewsApiWebsite();
                    }
                }).show();
    }

    private void loadNewsApiWebsite() {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://newsapi.org")));
    }
}
