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


public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.sight_list, container, false);
        final ArrayList<Sight> sights = new ArrayList<Sight>();
        sights.add(new Sight(R.drawable.sky, R.string.dinner_sky_title, R.string.dinner_sky_short_desc, R.string.cat_restaurants, R.string.dinner_sky_desc, R.string.dinner_sky_location, R.string.dinner_sky_web));
        sights.add(new Sight(R.drawable.maya, R.string.maya_title, R.string.maya_short_desc, R.string.cat_restaurants, R.string.maya_desc, R.string.maya_location, R.string.maya_web));
        sights.add(new Sight(R.drawable.psarras, R.string.psarras_title, R.string.psarras_short_desc, R.string.cat_restaurants, R.string.psarras_desc, R.string.psarras_location, R.string.psarras_web));
        sights.add(new Sight(R.drawable.hothot, R.string.hothot_title, R.string.hothot_short_desc, R.string.cat_restaurants, R.string.hothot_desc, R.string.hothot_location, R.string.hothot_web));
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
