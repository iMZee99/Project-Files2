package com.example.b6015413.usbtourteam6;

import android.app.SearchManager;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

public class LevelX extends AppCompatActivity {

    TextView levelX, tutorRoomsTitle, row1TR, row2TR, studySpacesTitle, row1SS, row2SS;
    RecyclerView tutorRoomRV, studySpaceRV;
    Button floorPlan;
    String[] Items = {"Tutor x - Room y - Floor z","Tutor x - Room y - Floor z","Tutor x - Room y - Floor z",
    "Tutor x - Room y - Floor z", "Tutor x - Room y - Floor z"};
    String[] studySpaceItems = {"Space x - Room y - Floor z","Space x - Room y - Floor z","Space x - Room y - Floor z",
            "Space x - Room y - Floor z", "Space x - Room y - Floor z"};
    String floorValue;
    RelativeLayout tutorRoomsRL, studySpacesRL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_x);

        //to find out which level was clicked on
        floorValue = getIntent().getStringExtra("floor value");

        //region importing fonts
        AssetManager am = this.getApplicationContext().getAssets();
        Typeface robotoLight = Typeface.createFromAsset(am,String.format(Locale.UK,"fonts/%s","Roboto-Light.ttf"));
        //endregion

        //region findViewByIDs
        levelX = findViewById(R.id.levelXTxt);
        tutorRoomsTitle = findViewById(R.id.tutorRoomTitle);
//        row1TR = findViewById(R.id.firstRow);
//        row2TR = findViewById(R.id.secondRow);
        studySpacesTitle = findViewById(R.id.studySpaceTitle);
//        row1SS = findViewById(R.id.firstRowSS);
//        row2SS = findViewById(R.id.secondRowSS);
        floorPlan = findViewById(R.id.floorPlanBtn);
        tutorRoomsRL = findViewById(R.id.tutorRoomsRL);
        studySpacesRL = findViewById(R.id.studySpacesRL);
        //endregion

        //region setting Typefaces
        levelX.setTypeface(robotoLight);
        tutorRoomsTitle.setTypeface(robotoLight);
        studySpacesTitle.setTypeface(robotoLight);
//        row1TR.setTypeface(robotoLight);
        levelX.setTypeface(robotoLight);
//        row2TR.setTypeface(robotoLight);
//        row1SS.setTypeface(robotoLight);
//        row2SS.setTypeface(robotoLight);
        floorPlan.setTypeface(robotoLight);
        //endregion

        //region RecyclerViews
        //Tutor Rooms RV
        tutorRoomRV = findViewById(R.id.tutorRV);
        //set the layout of the recycler view as the
        tutorRoomRV.setLayoutManager(new LinearLayoutManager(this));
        //populate the recycler view with this class as context and string[] Items as data
        tutorRoomRV.setAdapter(new TutorRoomAdapter(this,Items));

        //Study Spaces RV
        studySpaceRV = findViewById(R.id.studySpaceRV);
        studySpaceRV.setLayoutManager(new LinearLayoutManager(this));
        studySpaceRV.setAdapter(new StudySpaceAdapter(this,studySpaceItems));
        //endregion

        //Change the layout of page based on which floor is selected
        floorSelected(floorValue);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }
    }

    private void floorSelected(String floorValue) {
        //change text at top of page
        levelX. setText(floorValue);

        //change colour of views on page

        switch (floorValue) {
            case "First Floor":
                tutorRoomsRL.setBackground(getDrawable(R.drawable.orange_rounded));
                studySpacesRL.setBackground(getDrawable(R.drawable.orange_rounded));
                break;
            case "Second Floor":
                tutorRoomsRL.setBackground(getDrawable(R.drawable.yellow_rounded));
                studySpacesRL.setBackground(getDrawable(R.drawable.yellow_rounded));
                break;
            case "Third Floor":
                tutorRoomsRL.setBackground(getDrawable(R.drawable.yellow_rounded));
                studySpacesRL.setBackground(getDrawable(R.drawable.yellow_rounded));
                break;
            case "Fourth Floor":
                tutorRoomsRL.setBackground(getDrawable(R.drawable.green_rounded));
                studySpacesRL.setBackground(getDrawable(R.drawable.green_rounded));
                break;
            case "Fifth Floor":
                tutorRoomsRL.setBackground(getDrawable(R.drawable.green_rounded));
                studySpacesRL.setBackground(getDrawable(R.drawable.green_rounded));
                break;
            case "Sixth Floor":
                tutorRoomsRL.setBackground(getDrawable(R.drawable.green_rounded));
                studySpacesRL.setBackground(getDrawable(R.drawable.green_rounded));
                break;
        }


        //change data in recycler view
    }
}
