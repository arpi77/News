package com.happypath.news;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.happypath.news.model.Article;
import com.happypath.news.utils.DateUtils;

import java.util.List;

/**
 * Created by kucserak on 18. 6. 2017.
 */

public class HomeNewsAdapter extends RecyclerView.Adapter<HomeNewsAdapter.HomeNewsViewHolder> {
    private List<Article> newsArticles;

    public HomeNewsAdapter(List<Article> newsArticles) {
        this.newsArticles = newsArticles;
    }

    public static class HomeNewsViewHolder extends RecyclerView.ViewHolder {
        ImageView cardImageView;
        TextView cardTitleTextView;
        TextView cardTimeTextView;
        TextView cardDescriptionTextView;

        public HomeNewsViewHolder(View itemView) {
            super(itemView);
            cardImageView = (ImageView) itemView.findViewById(R.id.card_news_image);
            cardTitleTextView = (TextView) itemView.findViewById(R.id.card_news_title);
            cardTimeTextView = (TextView) itemView.findViewById(R.id.card_news_time);
            cardDescriptionTextView = (TextView) itemView.findViewById(R.id.card_news_content);
        }
    }

    @Override
    public HomeNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_news, parent, false);
        HomeNewsViewHolder homeNewsViewHolder = new HomeNewsViewHolder(view);
        return homeNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(HomeNewsViewHolder holder, final int position) {
        Article newsArticle = newsArticles.get(position);
        Glide.with(holder.cardImageView.getContext()).load(newsArticle.getUrlToImage())
                .centerCrop()
                .into(holder.cardImageView);

        holder.cardTitleTextView.setText(newsArticle.getTitle());
        holder.cardTimeTextView.setText(DateUtils.formatNewsApiDate(newsArticle.getPublishedAt()));
        holder.cardDescriptionTextView.setText(newsArticle.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAnalytics instance = FirebaseAnalytics.getInstance(v.getContext());
                Bundle bundle = new Bundle();
                bundle.putString("index", String.valueOf(position));
                instance.logEvent("cardClicked", bundle);
                NewsDetailsActivity.launch(v.getContext(), position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsArticles.size();
    }
}
