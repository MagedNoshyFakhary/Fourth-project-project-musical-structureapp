package com.maged.elmagdmusic.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.maged.elmagdmusic.Adapter.AlbumAdapter;
import com.maged.elmagdmusic.Model.Album;
import com.maged.elmagdmusic.R;
import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);


        // set arrayList and add data
        final ArrayList<Album> albums = new ArrayList<Album>();
        albums.add(new Album("7obak sbani", "Al7an Elragaa", R.drawable.img_7obak_sbani));
        albums.add(new Album("Ayam Eleya", "Elrab Rati", R.drawable.img_ayam_eleya));
        albums.add(new Album("Gayart 7yati", "Good News Team", R.drawable.img_gayart_7yati));
        albums.add(new Album("Ja3ltani Mothmeran", "Ereni Abo Gaber", R.drawable.img_ja3ltani_mothmeran));
        albums.add(new Album("khlaeni_a3esh", "Hadee Montser", R.drawable.img_khlaeni_a3esh));
        albums.add(new Album("Tarema Jadeda", "Ledea Sheed", R.drawable.img_tarema_jadeda));
        albums.add(new Album("koraib Menak", "Zead Shata", R.drawable.img_koraib_menak));
        albums.add(new Album("Hwa Abaa", "Hani Romane", R.drawable.img_hewa_abaa));
        //inflate and set listView
        listView =findViewById(R.id.album_listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AlbumActivity.this, PlayActivity.class);
                intent.putExtra("album", albums.get(i).getAlbum_name());
                intent.putExtra("artist", albums.get(i).getAlbumArtist_name());
                intent.putExtra("title", "track 1");
                intent.putExtra("img_res", albums.get(i).getAlbumImageResourceID());
                startActivity(intent);
            }
        });
        AlbumAdapter albumAdapter = new AlbumAdapter(this, albums); //Puts the values into the AlbumAdapter class
        listView.setAdapter(albumAdapter); //Displays the data in the AlbumAdapter

        //inflate and set bottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_menu_album:
                        Toast.makeText(AlbumActivity.this, "fdf", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.bottom_menu_tracks:
                        Intent tracks = new Intent(AlbumActivity.this, TracksActivity.class);
                        startActivity(tracks);
                        ;
                        return true;
                    case R.id.bottom_menu_play:
                        Intent play = new Intent(AlbumActivity.this, PlayActivity.class);
                        startActivity(play);
                        return true;

                    case R.id.bottom_menu_artist:
                        Intent artist = new Intent(AlbumActivity.this, ArtistActivity.class);
                        startActivity(artist);
                        return true;
                }
                return false;
            }
        });

    }

}
