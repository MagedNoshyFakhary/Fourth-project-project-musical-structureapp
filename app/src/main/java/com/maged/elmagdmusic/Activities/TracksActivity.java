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
import com.maged.elmagdmusic.Adapter.TrackAdapter;
import com.maged.elmagdmusic.Model.Tracks;
import com.maged.elmagdmusic.R;

import java.util.ArrayList;

public class TracksActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracks);

        // set arrayList and add data
        final ArrayList<Tracks> tracks = new ArrayList<Tracks>();
        tracks.add(new Tracks("7obak Sbani", "Al7an Elragaa", "7obak sbani", R.drawable.img_7obak_sbani));
        tracks.add(new Tracks("Ayam Eleya", "Elrab Rati", "Ayam_Eleya", R.drawable.img_ayam_eleya));
        tracks.add(new Tracks("Gayart 7yati", "Good News Team", "Gayart_7yati", R.drawable.img_gayart_7yati));
        tracks.add(new Tracks("Ja3ltani Mothmeran", "Ereni Abo Gaber", "Ja3ltani Mothmeran", R.drawable.img_ja3ltani_mothmeran));
        tracks.add(new Tracks("khlaeni_a3esh", "Hadee Montser", "khlaeni_a3esh", R.drawable.img_khlaeni_a3esh));
        tracks.add(new Tracks("Tarema Jadeda", "Ledea Sheed", "Tarema_jadeda", R.drawable.img_tarema_jadeda));
        tracks.add(new Tracks("koraib Menak", "Zead Shata", "koraib Menak", R.drawable.img_koraib_menak));
        tracks.add(new Tracks("Hwa Abaa", "Hani Romane", "Hwa Abaa", R.drawable.img_hewa_abaa));
        //Sets onClick listeners on the buttons and the listViews
        listView = findViewById(R.id.tracks_listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TracksActivity.this, PlayActivity.class);
                intent.putExtra("album", tracks.get(i).getAlbumTitle());
                intent.putExtra("artist", tracks.get(i).getArtist());
                intent.putExtra("title", tracks.get(i).getTitle());
                intent.putExtra("img_res", tracks.get(i).getAlbum_res());
                startActivity(intent);
            }
        });        listView.setAdapter(new TrackAdapter(this, tracks));

        //inflate and set bottomNavigationView
        bottomNavigationView=findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_menu_album:
                        Intent album =new Intent(TracksActivity.this,AlbumActivity.class);
                        startActivity(album);
                        return true;
                    case R.id.bottom_menu_tracks:
                        Toast.makeText(TracksActivity.this,"fdf",Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.bottom_menu_play:
                        Intent play =new Intent(TracksActivity.this,PlayActivity.class);
                        startActivity(play);
                        return true;

                    case R.id.bottom_menu_artist:
                        Intent artist =new Intent(TracksActivity.this,ArtistActivity.class);
                        startActivity(artist);
                        return true;
                }
                return false;
            }
        });
    }
}
