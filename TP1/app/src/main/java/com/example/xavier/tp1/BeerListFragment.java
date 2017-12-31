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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BeerListFragment extends Fragment {

    OnClickBeerListener mListener;

    private BeerAPI beerAPI;

    private ListView mListBeer = null;

    private List<Beer> lBeers;

    private myArrayAdapter adapter;


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
                mListener.OnClickBeer(lBeers.get(i));
            }
        });

        if (beerAPI == null) {
            beerAPI = new BeerAPI();
        }
        beerAPI.getBeerList(1,50).enqueue(new Callback<List<Beer>>() {
            @Override
            public void onResponse(Call<List<Beer>> call, Response<List<Beer>> response) {
                if (response.isSuccessful()) {
                    lBeers = response.body();
                    adapter = new myArrayAdapter(getContext(), R.layout.list_entity_layout, response.body());
                    mListBeer.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Beer>> call, Throwable t) {
                Log.d("Failure", t.getLocalizedMessage());
            }
        });

        return view;
    }

    public interface OnClickBeerListener {
        void OnClickBeer(Beer b);
    }

}
