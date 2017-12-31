package com.example.xavier.tp1;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class BeerDetailFragment extends Fragment {

    public Beer beer;

    public static BeerDetailFragment newInstance(Beer beer) {
        BeerDetailFragment myFragment = new BeerDetailFragment();

        Bundle args = new Bundle();
        myFragment.beer = beer;
        return myFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_beer_detail, container, false);

        ((ImageView) view.findViewById(R.id.imageBeerDetail)).setImageBitmap(beer.getBm());
        ((TextView) view.findViewById(R.id.titleBeerDetail)).setText(beer.getName());
        ((TextView) view.findViewById(R.id.dateNaissanceBeerDetail)).setText(beer.getFirstBrewed());
        ((TextView) view.findViewById(R.id.abvBeerDetail)).setText("Alc " + beer.getAbv() + "% vol");
        ((TextView) view.findViewById(R.id.ibuBeerDetail)).setText("IBU " + beer.getIbu());
        ((TextView) view.findViewById(R.id.ebcBeerDetail)).setText("EBC " + beer.getEbc());
        ((TextView) view.findViewById(R.id.phBeerDetail)).setText("PH " + beer.getPh());
        ((TextView) view.findViewById(R.id.descriptionBeerDetail)).setText(beer.getDescription());

        return view;
    }

}
