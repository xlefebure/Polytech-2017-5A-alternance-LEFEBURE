package com.example.xavier.tp1;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Epulapp on 29/11/2017.
 */

public class myArrayAdapter extends ArrayAdapter<Beer> {

    public myArrayAdapter(@NonNull Context context, int resource, @NonNull Beer[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("Nb", " P : "+position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_entity_layout, parent, false);
        }
        ((ImageView)convertView.findViewById(R.id.ImageBeer)).setImageResource(R.drawable.ic_launcher_background);
        ((TextView) convertView.findViewById(R.id.BeerName)).setText("Titre " + position);
        ((TextView) convertView.findViewById(R.id.BeerContent)).setText("Content " + position);
        return convertView;
    }
}
