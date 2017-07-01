package com.happypath.news;

import com.happypath.news.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kucserak on 18. 6. 2017.
 */

public class NewsStore {
    private static List<NewsArticle> newsArticles = new ArrayList<>();

    public static List<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<NewsArticle> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
