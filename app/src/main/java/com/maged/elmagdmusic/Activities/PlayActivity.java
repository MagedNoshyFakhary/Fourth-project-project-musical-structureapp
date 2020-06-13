package com.maged.elmagdmusic.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.maged.elmagdmusic.R;

public class PlayActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
MaterialCardView cardView;
    TextView songName;
    TextView artistName;
    TextView titleName;
    ImageView albumImage;
    Button play;

    boolean playing = true;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //inflate views
        songName=findViewById(R.id.songName);
        artistName=findViewById(R.id.artistName);
        albumImage=findViewById(R.id.nowPlayingImage);
        titleName=findViewById(R.id.titleName);
        //set intent data
        if (getIntent().hasExtra("album"))
            songName.setText(getIntent().getStringExtra("album"));
        if (getIntent().hasExtra("artist"))
            artistName.setText(getIntent().getStringExtra("artist"));
        if (getIntent().hasExtra("title"))
            titleName.setText(getIntent().getStringExtra("title"));
        if (getIntent().hasExtra("img_res"))
            albumImage.setImageResource(getIntent().getIntExtra("img_res", R.drawable.ic_album));

        //inflate and set bottomNavigationView
        bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_menu_album:
                        Intent album =new Intent(PlayActivity.this,AlbumActivity.class);
                        startActivity(album);
                        return true;
                    case R.id.bottom_menu_tracks:
                        Intent tracks =new Intent(PlayActivity.this,TracksActivity.class);
                        startActivity(tracks);;
                        return true;
                    case R.id.bottom_menu_play:
                        Toast.makeText(PlayActivity.this,"fdf",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.bottom_menu_artist:
                        Intent artist =new Intent(PlayActivity.this,ArtistActivity.class);
                        startActivity(artist);
                        return true;
                }
                return false;
            }
        });
play=findViewById(R.id.play_iv);
play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PlayActivity.this,"Now Playing",Toast.LENGTH_SHORT).show();

            }
        });
    }

}
