package com.example.xavier.tp1;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        ((TextView) view.findViewById(R.id.titleBeerDetail)).setText("Titre " + beer.name);

        return view;
    }

}
