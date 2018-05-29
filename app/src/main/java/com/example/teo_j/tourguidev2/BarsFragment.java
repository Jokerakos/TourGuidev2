package com.example.teo_j.tourguidev2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class BarsFragment extends Fragment {


    public BarsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.sight_list, container, false);

        final ArrayList<Sight> sights = new ArrayList<Sight>();
        sights.add(new Sight(R.drawable.speakeasy, R.string.speakeasy_title, R.string.speakeasy_short_desc, R.string.cat_bars, R.string.speakeasy_desc, R.string.speakeasy_location, R.string.speakeasy_web));
        sights.add(new Sight(R.drawable.berlin, R.string.berlin_title, R.string.berlin_short_desc, R.string.cat_bars, R.string.berlin_desc, R.string.berlin_location, R.string.berlin_web));
        sights.add(new Sight(R.drawable.bartesera, R.string.bartesera_title, R.string.bartesera_short_desc, R.string.cat_bars, R.string.bartesera_desc, R.string.bartesera_location, R.string.bartesera_web));
        sights.add(new Sight(R.drawable.dogs, R.string.dogs_title, R.string.dogs_short_desc, R.string.cat_bars, R.string.dogs_desc, R.string.dogs_location, R.string.dogs_web));
        sights.add(new Sight(R.drawable.couleur, R.string.couleur_title, R.string.couleur_short_desc, R.string.cat_bars, R.string.couleur_desc, R.string.couleur_location, R.string.couleur_web));

        SightAdapter adapter = new SightAdapter(getActivity(), sights);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Sight sight = sights.get(position);
                Intent sightSend = new Intent(getActivity().getApplication(), sight_detailed_info_activity.class);
                sightSend.putExtra("sights",sights);
                sightSend.putExtra("sightToDisplay", position);
                startActivity(sightSend);

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
