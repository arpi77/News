package com.happypath.news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.happypath.news.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<NewsArticle> newsArticles = new ArrayList<>();
        newsArticles.add(new NewsArticle("Winners and losers in Amazon’s $13.7B purchase of Whole Foods", "Amazon is taking a huge bite out of the fresh food business with its bid for Whole Foods Market for $13.7 billion. But even though this is a deal between two companies, it’s not just the two of them being touched by it.",
                "Today", "https://tctechcrunch2011.files.wordpress.com/2016/06/fresh-97.jpg?w=1029", "https://techcrunch.com/2017/06/16/winners-and-losers-in-amazons-13-7b-purchase-of-whole-foods/"));

        newsArticles.add(new NewsArticle("Amazon buys Whole Foods", "Amazon scared investors away from competing grocery stores today when it acquired Whole Foods for $13.7 billion. Wal-Mart, Target, Costco, Kroger, and more all saw their share prices sink dramatically.",
                "Today", "https://tctechcrunch2011.files.wordpress.com/2017/06/grocery-stores-plummet.jpg?w=1029", "https://techcrunch.com/2017/06/16/foodpocalypse/"));

        NewsStore.setNewsArticles(newsArticles);
        recyclerView = (RecyclerView) findViewById(R.id.activity_main_recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HomeNewsAdapter homeNewsAdapter = new HomeNewsAdapter(NewsStore.getNewsArticles());
        recyclerView.setAdapter(homeNewsAdapter);
    }
}
