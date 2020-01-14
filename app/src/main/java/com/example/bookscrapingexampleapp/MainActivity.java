package com.example.bookscrapingexampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Amazon", "Loaded main activity");

    }

    /**
     * Trying to put minor amounts of code in this method and through debugging I can see where it
     * is crashing (line 40), but not sure how to fix it.
     * @param v
     */

    public void scrapeOne(View v) {
        Document document;
        Element book;

        String url = "https://www.amazon.com/best-sellers-books-Amazon/zgbs/books/ref=zg_bs_nav_0";
        try {
            Log.d("Amazon", "ScrapeOne: inside try");

            // THIS IS THE LINE THAT CAUSES IT TO JUMP TO THE CATCH
            document = Jsoup.connect(url).get();
            book = document.selectFirst("a-section a-spacing-none aok-relative");
            Log.d("Amazon", "ScrapeOne: executed selectFirst");
            Log.d("Amazon", "Length of book is: " + book.text().length());
        }
        catch (Exception e) {
            Log.d("error", "nullPointerException");
        }

    }

    /**
     * Ideally I will call this method to connect the Jsoup scraping code - when it is working.
     * @param v
     */

    public void scrape(View v) {
        try {
            JSoupHelper.scrapeAmazon();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
