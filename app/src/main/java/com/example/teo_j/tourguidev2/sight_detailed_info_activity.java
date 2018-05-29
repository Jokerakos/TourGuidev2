package com.example.teo_j.tourguidev2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class sight_detailed_info_activity extends AppCompatActivity {

    int position;
    TextView sightTitle;
    ImageView sightImage;
    TextView sightDesc;
    ArrayList<Sight> sightsList = new ArrayList<>();
    TextView mapLink;
    TextView webPage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sightsList = getIntent().getParcelableArrayListExtra("sights");
        position = getIntent().getIntExtra("sightToDisplay", 0);
        setContentView(R.layout.activity_sight_detailed_info_activity);
        sightTitle = findViewById(R.id.sightTitle);
        sightImage = findViewById(R.id.sightImage);
        sightDesc = findViewById(R.id.sightDesc);
        mapLink = findViewById(R.id.mapLink);
        webPage = findViewById(R.id.webPage);
        setData();
        webPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = getString(sightsList.get(position).getmSightWeb());
                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                webIntent.setData(Uri.parse(url));
                startActivity(webIntent);
            }
        });

        mapLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri gmmIntentUri = Uri.parse(getString(sightsList.get(position).getSightLocation()));

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }

            }
        });

    }

    public void setData() {

        sightTitle.setText(sightsList.get(position).getSightTitle());
        sightImage.setImageResource(sightsList.get(position).getSightImage());
        sightDesc.setText(sightsList.get(position).getSightDesc());


    }
}
