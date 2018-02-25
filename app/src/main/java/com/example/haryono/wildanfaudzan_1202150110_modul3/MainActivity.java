package com.example.haryono.wildanfaudzan_1202150110_modul3;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {

    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Data> mSportsData;
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dapatkan integer dari file sumber daya integers.xml
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);


        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Initialize the ArrayList that will contain the data
        mSportsData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new DataAdapter(this, mSportsData);
        mRecyclerView.setAdapter(mAdapter);

        //Ubah LinearLayoutManager ke GridLayoutManager, dengan meneruskan konteks dan integer yang baru dibuat:
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        //Get the data
        initializeData();
    }

    /**
     * Method for initializing the sports data from resources.
     */
    private void initializeData() {
        //Get the resources from the XML file
        String[] sportsList = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
        //Clear the existing data (to avoid duplication)
        mSportsData.clear();


        //Create the ArrayList of Sports objects with the titles, images
        // and information about each sport
        for(int i=0; i<sportsList.length; i++){
            mSportsData.add(new Data(sportsList[i], sportsInfo[i],
                    sportsImageResources.getResourceId(i,0)));
        }

        //Recycle the typed array
        sportsImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }

}