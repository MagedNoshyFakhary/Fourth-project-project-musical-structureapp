package com.maged.elmagdmusic.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.maged.elmagdmusic.Adapter.AlbumAdapter;
import com.maged.elmagdmusic.Model.Album;
import com.maged.elmagdmusic.R;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);

        // set arrayList and add data
        final ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album("7obak sbani", "Al7an Elragaa", R.drawable.img_al7an_el_rajaa));
        albums.add(new Album("Ayam Eleya", "Elrab Rati", R.drawable.img_alrab_rayati));
        albums.add(new Album("Gayart 7yati", "Good News Team", R.drawable.img_alakhbar_2lsarrra));
        albums.add(new Album("Ja3ltani Mothmeran", "Ereni Abo Gaber", R.drawable.img_erenii));
        albums.add(new Album("khlaeni_a3esh", "Hadee Montser", R.drawable.img_haidy_muntaser));
        albums.add(new Album("Tarema Jadeda", "Ledea Sheed", R.drawable.img_ledaa));
        albums.add(new Album("koraib Menak", "Zead Shata", R.drawable.img_ziad));
        albums.add(new Album("Hwa Abaa", "Hani Romane", R.drawable.img_hani_romani));

        //inflate and set listView
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums); //Puts the values into the AlbumAdapter class
        listView= findViewById(R.id.artist_listView);
        listView.setAdapter(albumAdapter);

        //inflate and set bottomNavigationView
        bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_menu_album:
                        Intent album =new Intent(ArtistActivity.this,AlbumActivity.class);
                        startActivity(album);
                        return true;
                    case R.id.bottom_menu_tracks:
                        Intent tracks =new Intent(ArtistActivity.this,TracksActivity.class);
                        startActivity(tracks);;
                        return true;
                    case R.id.bottom_menu_play:
                        Intent play =new Intent(ArtistActivity.this,PlayActivity.class);
                        startActivity(play);
                        return true;

                    case R.id.bottom_menu_artist:
                        Toast.makeText(ArtistActivity.this,"fdf",Toast.LENGTH_LONG).show();
                        return true;
                }
                return false;
            }
        });
    }
}
