package com.example.bookscrapingexampleapp;

import android.util.Log;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Ideally this class will have the scraping code.  Currently it isn't working, so I
 * am trying a modified version of it in the MainActivity.java file
 */

public class JSoupHelper {

    public static void scrapeAmazon()   throws IOException
    {
        String url = "https://www.amazon.com/best-sellers-books-Amazon/zgbs/books/ref=zg_bs_nav_0";

        // this is the line that is throwing the InvocationTargetException error
        Document page = Jsoup.connect(url).get();

        // This is the CSS code to select the title of the book
        String bookSelector = "a-section a-spacing-none aok-relative";

        // gets ALL the titles from the page
        Elements bookElements = page.select(bookSelector);
        Log.d("Amazon", "Got the Elements");

        // Creates an ArrayList that we will fill with the book titles. To fill it,
        // we will iterate through the Elements object and pull out all the
        // text of the bookTitles that were scraped.  We use the .text() method because the
        // scraping gets all the HTML and we don't need it all - we only want the text

        ArrayList<String> bookTitles = new ArrayList<>();
        for (Element e: bookElements)
            bookTitles.add(e.text());

        Log.d("Amazon", "Size of ArrayList: " + bookTitles.size());

                // Print out the book titles to the Log so that we can see what they are
        for (String s: bookTitles)
            Log.d("Amazon", s);
    }
}





















