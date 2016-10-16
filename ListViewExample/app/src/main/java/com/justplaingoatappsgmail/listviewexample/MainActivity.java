package com.justplaingoatappsgmail.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<GameListing> gameListings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameListings = new ArrayList<>();
        addAllGameListings();

        ArrayAdapter<GameListing> arrayAdapter = new MyArrayAdapter();
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
    }

    private void addAllGameListings() {
        GameListing counterStrike = new GameListing(R.drawable.csgo, 14.99,
                "FPS", "Counter-Strike: Global Offensive");
        GameListing skyrim = new GameListing(R.drawable.skyrim, 59.99,
                "Adventure", "The Elder Scrolls V: Skyrim");
        GameListing rocketLeague = new GameListing(R.drawable.rocketleague, 19.99,
                "Sports", "Rocket League");
        GameListing portal = new GameListing(R.drawable.portal2, 19.99,
                "Puzzle", "Portal 2");
        GameListing left4Dead = new GameListing(R.drawable.l4d, 19.99,
                "Action", "Left 4 Dead 2");
        GameListing rust = new GameListing(R.drawable.rust, 19.99,
                "Survival", "Rust");
        GameListing crew = new GameListing(R.drawable.crew, 49.99,
                "Racing", "The Crew");
        GameListing garrysMod = new GameListing(R.drawable.garrysmod, 9.99,
                "Sandbox", "Garry's Mod");

        gameListings.add(counterStrike);
        gameListings.add(skyrim);
        gameListings.add(rocketLeague);
        gameListings.add(portal);
        gameListings.add(left4Dead);
        gameListings.add(rust);
        gameListings.add(crew);
        gameListings.add(garrysMod);
    }

    private class MyArrayAdapter extends ArrayAdapter<GameListing> {

        public MyArrayAdapter() {
            // Apply the activity context, layout to display, and the list to read from
            super(MainActivity.this, R.layout.game_listing, gameListings);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;

            if(view == null) {
                view = getLayoutInflater().inflate(R.layout.game_listing, parent, false);
            }

            // Temp object that holds information on the particular game
            final GameListing tempGameListing = gameListings.get(position);

            // Draw image of the game
            ImageView gameImage = (ImageView) view.findViewById(R.id.gameImage);
            gameImage.setImageResource(tempGameListing.getGameImage());

            // Set title of the game
            TextView titleTextView = (TextView) view.findViewById(R.id.titleTextView);
            titleTextView.setText(tempGameListing.getTitle());

            // Set price of the game
            TextView priceTextView = (TextView) view.findViewById(R.id.priceTextView);
            priceTextView.setText("$" + String.valueOf(tempGameListing.getPrice()));

            // Set genre of the game
            TextView genreTextView = (TextView) view.findViewById(R.id.gameGenreTextView);
            genreTextView.setText(tempGameListing.getGenre());

            return view;
        }
    }
}
