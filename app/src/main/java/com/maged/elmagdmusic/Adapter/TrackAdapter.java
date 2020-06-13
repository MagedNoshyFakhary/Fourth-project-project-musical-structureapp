package com.maged.elmagdmusic.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.maged.elmagdmusic.Model.Tracks;
import com.maged.elmagdmusic.R;


import java.util.ArrayList;


public class TrackAdapter extends ArrayAdapter {
//add tracks
    ArrayList<Tracks> tracks;

    /**
     * adding constructor
     * @param context
     * @param tracks
     */
    public TrackAdapter(@NonNull Context context, ArrayList<Tracks> tracks) {
        super(context, 0);
        this.tracks = tracks;
    }

    @Override
    public int getCount() {
        return tracks.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //inflate views
        View v = convertView;
        if (v == null)
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tracks_list_item, null);

        TextView title = v.findViewById(R.id.title_text_view);
        TextView album = v.findViewById(R.id.album_text_view);
        TextView artist = v.findViewById(R.id.artist_text_view);
        ImageView img = v.findViewById(R.id.list_item_icon);
        //set data in views
        title.setText(tracks.get(position).getTitle());
        artist.setText(tracks.get(position).getArtist());
        img.setImageResource(tracks.get(position).getAlbum_res());
        return v;
    }
}