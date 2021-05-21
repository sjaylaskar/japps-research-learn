/*
 * $$ Id: ArticleTitleFetcher.java 25-Mar-2021 11:59:00 pm SubhajoyLaskar $$
 * Copyright (©) 2021 Subhajoy Laskar
 * https://www.linkedin.com/in/subhajoylaskar
 */
package com.japps.learn.algorithm.tg.virtusa.mar2021;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;


/**
 * The article title fetcher.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
public final class ArticleTitleFetcher {

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] args) throws IOException {

        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final String author = bufferedReader.readLine();

        final List<String> result = Result.getArticleTitles(author);

        System.out.println(result.stream()
            .collect(joining("\n"))
            + "\n");

        bufferedReader.close();

    }
}

/**
 * The result.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
class Result {

    /** The article url. */
    private static final String ARTICLE_URL = "https://restmock.techgig.com/news?author=<authorName>&page=<pageNum>";

    /** The total pages. */
    private static int totalPages = Integer.MAX_VALUE;

    /**
     * Gets the article titles.
     *
     * @param author the author
     * @return the article titles
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static List<String> getArticleTitles(final String author) throws IOException {

        final List<String> articleTitles = new ArrayList<>();

        for (int i = 1; i <= totalPages; i++) {
            articleTitles.addAll(getArticleTitles(author, i));
        }

        Collections.sort(articleTitles);
        totalPages = Integer.MAX_VALUE;
        return articleTitles;

    }

    /**
     * Gets the article titles by page.
     *
     * @param author the author
     * @param pageNumber the page number
     * @return the article titles by page
     * @throws IOException Signals that an I/O exception has occurred.
     */
    private static List<String> getArticleTitles(final String author, final int pageNumber) throws IOException {

        final List<String> articleTitles = new ArrayList<>();

        BufferedReader reader = null;
        try {
            final String parameterizedURL = ARTICLE_URL.replace("<authorName>", author).replace("<pageNum>", Integer.toString(
                pageNumber));

            final URL url = new URL(parameterizedURL);
            final HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");

            final int responseCode = httpURLConnection.getResponseCode();

            reader =
                isSuccessResponse(responseCode)
                    ? new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()))
                    : new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));

            if (isSuccessResponse(responseCode)) {
                getArticleTitles(articleTitles, reader);
            }

        } catch (final Exception exception) {
            // Ignore
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return articleTitles;
    }

    /**
     * Gets the article titles.
     *
     * @param articleTitles the article titles
     * @param reader the reader
     * @return the article titles
     */
    private static void getArticleTitles(final List<String> articleTitles, final BufferedReader reader) {

        final String response = reader.lines().collect(joining());

        final ArticleResponse articleResponse = new Gson().fromJson(response, ArticleResponse.class);

        totalPages = articleResponse.getTotal_page();

        if (articleResponse.getContent() != null && articleResponse.getContent().length > 0) {

            Arrays.asList(articleResponse.getContent())
                .stream()
                .filter(content -> isNotNullOrBlank(content.getTitle())
                    || isNotNullOrBlank(content.getLink()))
                .map(content -> isNotNullOrBlank(content.getTitle()) ? content.getTitle() : content.getLink())
                .forEach(articleTitle -> {
                    articleTitles.add(articleTitle);
                });
        }
    }

    /**
     * Indicates if is success response.
     *
     * @param responseCode the response code
     * @return {@code true}, if is success response
     */
    private static boolean isSuccessResponse(final int responseCode) {

        return responseCode >= 200 && responseCode <= 299;
    }

    /**
     * Indicates if is not null or blank.
     *
     * @param value the value
     * @return {@code true}, if is not null or blank
     */
    private static boolean isNotNullOrBlank(final String value) {

        return (value != null && value != "");
    }
}

/**
 * The article response.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
class ArticleResponse {

    /** The page. */
    private int page;

    /** The total page. */
    private int total_page;

    /** The per page. */
    private int per_page;

    /** The total. */
    private int total;

    /** The content. */
    private Article[] content;

    /**
     * Instantiates a new article response.
     */
    public ArticleResponse() {

        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new article response.
     *
     * @param page the page
     * @param total_page the total page
     * @param per_page the per page
     * @param total the total
     * @param content the content
     */
    public ArticleResponse(final int page, final int total_page, final int per_page, final int total, final Article[] content) {

        this.page = page;
        this.total_page = total_page;
        this.per_page = per_page;
        this.total = total;
        this.content = content;
    }

    /**
     * Gets the page.
     *
     * @return the page
     */
    public int getPage() {

        return page;
    }

    /**
     * Sets the page.
     *
     * @param page the page to set
     */
    public void setPage(final int page) {

        this.page = page;
    }

    /**
     * Gets the total page.
     *
     * @return the total_page
     */
    public int getTotal_page() {

        return total_page;
    }

    /**
     * Sets the total page.
     *
     * @param total_page the total_page to set
     */
    public void setTotal_page(final int total_page) {

        this.total_page = total_page;
    }

    /**
     * Gets the per page.
     *
     * @return the per_page
     */
    public int getPer_page() {

        return per_page;
    }

    /**
     * Sets the per page.
     *
     * @param per_page the per_page to set
     */
    public void setPer_page(final int per_page) {

        this.per_page = per_page;
    }

    /**
     * Gets the total.
     *
     * @return the total
     */
    public int getTotal() {

        return total;
    }

    /**
     * Sets the total.
     *
     * @param total the total to set
     */
    public void setTotal(final int total) {

        this.total = total;
    }

    /**
     * Gets the content.
     *
     * @return the content
     */
    public Article[] getContent() {

        return content;
    }

    /**
     * Sets the content.
     *
     * @param content the content to set
     */
    public void setContent(final Article[] content) {

        this.content = content;
    }

}

/**
 * The article.
 *
 * @author Subhajoy Laskar
 * @version 1.0 $ Revision: $
 */
class Article {

    /** The title. */
    private String title;

    /** The link. */
    private String link;

    /** The num comments. */
    private int num_comments;

    /** The author. */
    private String author;

    /** The created date. */
    private String created_date;

    /** The created time. */
    private String created_time;

    /** The day of the week. */
    private String day_of_the_week;

    /**
     * Instantiates a new article.
     */
    public Article() {

        // TODO Auto-generated constructor stub
    }

    /**
     * Instantiates a new article.
     *
     * @param title the title
     * @param link the link
     * @param num_comments the num comments
     * @param author the author
     * @param created_date the created date
     * @param created_time the created time
     * @param day_of_the_week the day of the week
     */
    public Article(final String title, final String link, final int num_comments, final String author, final String created_date,
            final String created_time,
            final String day_of_the_week) {

        this.title = title;
        this.link = link;
        this.num_comments = num_comments;
        this.author = author;
        this.created_date = created_date;
        this.created_time = created_time;
        this.day_of_the_week = day_of_the_week;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {

        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the title to set
     */
    public void setTitle(final String title) {

        this.title = title;
    }

    /**
     * Gets the link.
     *
     * @return the link
     */
    public String getLink() {

        return link;
    }

    /**
     * Sets the link.
     *
     * @param link the link to set
     */
    public void setLink(final String link) {

        this.link = link;
    }

    /**
     * Gets the num comments.
     *
     * @return the num_comments
     */
    public int getNum_comments() {

        return num_comments;
    }

    /**
     * Sets the num comments.
     *
     * @param num_comments the num_comments to set
     */
    public void setNum_comments(final int num_comments) {

        this.num_comments = num_comments;
    }

    /**
     * Gets the author.
     *
     * @return the author
     */
    public String getAuthor() {

        return author;
    }

    /**
     * Sets the author.
     *
     * @param author the author to set
     */
    public void setAuthor(final String author) {

        this.author = author;
    }

    /**
     * Gets the created date.
     *
     * @return the created_date
     */
    public String getCreated_date() {

        return created_date;
    }

    /**
     * @param created_date the created_date to set
     */
    public void setCreated_date(final String created_date) {

        this.created_date = created_date;
    }

    /**
     * @return the created_time
     */
    public String getCreated_time() {

        return created_time;
    }

    /**
     * @param created_time the created_time to set
     */
    public void setCreated_time(final String created_time) {

        this.created_time = created_time;
    }

    /**
     * @return the day_of_the_week
     */
    public String getDay_of_the_week() {

        return day_of_the_week;
    }

    /**
     * @param day_of_the_week the day_of_the_week to set
     */
    public void setDay_of_the_week(final String day_of_the_week) {

        this.day_of_the_week = day_of_the_week;
    }

}
