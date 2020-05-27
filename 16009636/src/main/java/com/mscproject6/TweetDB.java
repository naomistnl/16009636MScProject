package com.mscproject6;


import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class TweetDB {


    public void createDB()

    //create database in the program
    {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("/users/naomistanley/Tweets.db");
            connection = DriverManager.getConnection("jdbc:sqlite:/Users/naomistanley/Tweets.db");
            System.out.println("Create operation -database successfully opened");

            statement = connection.createStatement();
            String sql = "CREATE TABLE sampletweet " +
                    "(text CHAR(2600)," +
                    " place__fullName        CHAR(50)    NOT NULL, " +
                    " geoLocation__longitude        CHAR(50)     NOT NULL, " +
                    " geoLocation__latitude    CHAR(50) NOT NULL )";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table successfully created");
    }

    //connect to the SQLite database to allow us access to the table
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/users/naomistanley/Tweets.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    //select and output data from table - try and get rid of 0.0 output
    public List<Tweet> selectAll(){
        String sql = "SELECT text, place__fullName, geoLocation__longitude, geoLocation__latitude FROM sampletweet";

        List<Tweet> tweets = new ArrayList<>();

        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            Tweet tweet;
            // loop through the result set
            while (rs.next()) {

                tweet = new Tweet();
                tweet.setPlace__fullName( rs.getString("place__fullName"));
                tweet.setTweet(rs.getString("text"));
                tweet.setGeoLocation__longitude(Double.toString(rs.getDouble("geoLocation__longitude")));
                tweet.setGeoLocation__latitude((Double.toString(rs.getDouble("geoLocation__latitude"))));

                tweets.add(tweet);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return tweets;
    }

    public static void main(String[] args) {
        TweetDB dbselect = new TweetDB();
        dbselect.selectAll();
    }
}