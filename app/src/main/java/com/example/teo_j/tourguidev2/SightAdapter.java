package com.example.teo_j.tourguidev2;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class SightAdapter extends ArrayAdapter<Sight> {



    public SightAdapter(Activity context, ArrayList<Sight> sights){
        super (context,0 ,sights);
    }

    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View listItemView = convertView;
        if (listItemView == null);{
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.sight_list_view, parent, false);}


        Sight currentSight = getItem(position);



        ImageView sightImage = listItemView.findViewById(R.id.sightImage);
        int image = currentSight.getSightImage();
        Picasso.with(getContext()).load(image).fit().centerCrop().into(sightImage);

        sightImage.setImageResource(currentSight.getSightImage());

        TextView sightTitle = listItemView.findViewById(R.id.sightTitle);
        sightTitle.setText(currentSight.getSightTitle());

        TextView sightShortDesc = listItemView.findViewById(R.id.sightShortDesc);
        sightShortDesc.setText(currentSight.getSightShortDesc());



        return listItemView;
    }



}




