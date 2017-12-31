package com.example.xavier.tp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

    private List<Beer> beers;

    public myArrayAdapter(@NonNull Context context, int resource, @NonNull List<Beer> objects) {
        super(context, resource, objects);
        beers = objects;

        for (int i = 0; i < beers.size(); i++) {
            new Download().execute(beers.get(i));
        }
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_entity_layout, parent, false);
        }

        ((TextView) convertView.findViewById(R.id.BeerName)).setText(beers.get(position).getName());
        ((TextView) convertView.findViewById(R.id.BeerContent)).setText(beers.get(position).getTagline());
        if (beers.get(position).getBm() == null) {
            ((ImageView) convertView.findViewById(R.id.ImageBeer)).setImageResource(R.drawable.ic_launcher_background);
        } else {
            ((ImageView) convertView.findViewById(R.id.ImageBeer)).setImageBitmap(beers.get(position).getBm());
        }


        return convertView;
    }

}
