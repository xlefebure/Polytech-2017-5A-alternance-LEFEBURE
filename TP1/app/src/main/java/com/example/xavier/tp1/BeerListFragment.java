package com.example.xavier.tp1;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


public class BeerListFragment extends Fragment {

    OnClickBeerListener mListener;

    private ListView mListBeer = null;

    private Beer[] mBeers = new Beer[10];

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnClickBeerListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_beer_list, container, false);

        mListBeer = (ListView) view.findViewById(R.id.listView);

        mListBeer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("Appui", "Click on " + i);
                mListener.OnClickBeer(mBeers[i]);
            }
        });


        mBeers[0] = new Beer();
        mBeers[1] = new Beer();
        mBeers[2] = new Beer();
        mBeers[3] = new Beer();
        mBeers[4] = new Beer();
        mBeers[5] = new Beer();
        mBeers[6] = new Beer();
        mBeers[7] = new Beer();
        mBeers[8] = new Beer();
        mBeers[9] = new Beer();
        mListBeer.setAdapter(new myArrayAdapter(getContext(), R.layout.list_entity_layout, mBeers));
        //mListBeer.setItemChecked(0, true);

        return view;
    }

    public interface OnClickBeerListener {
        void OnClickBeer(Beer b);
    }

}
