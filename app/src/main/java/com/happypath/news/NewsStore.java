package com.happypath.news;

import com.happypath.news.model.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kucserak on 18. 6. 2017.
 */

public class NewsStore {
    private static List<Article> newsArticles = new ArrayList<>();

    public static List<Article> getNewsArticles() {
        return newsArticles;
    }

    public static void setNewsArticles(List<Article> newsArticles) {
        NewsStore.newsArticles = newsArticles;
    }
}
