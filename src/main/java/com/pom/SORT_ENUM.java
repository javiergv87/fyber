package com.pom;

/**
 * Created by Javi on 26/11/2016.
 */
public class SORT_ENUM {
    public enum SORT_BY {
        RANKING("Ranking"),
        IMDB_RATING("IMDb Rating"),
        NUMBER_OF_RATINGS("Number of Ratings"),
        YOUR_RATING("Your Rating"),
        POPULARITY("Popularity"),
        ALPHABETICAL("Alphabetical"),
        NUMBER_OF_VOTES("Number of Votes"),
        US_BOX_OFFICE("US Box Office"),
        RUNTIME("Runtime"),
        YEAR("Year"),
        RELEASE_DATE("Release Date");

        private final String trip;

        private SORT_BY(String s){
            trip=s;
        }

        public String getName() {
            return trip;
        }

        public boolean equals(String tr){
            return (tr==null) ? false : trip.equalsIgnoreCase(tr);
        }
    }




}
