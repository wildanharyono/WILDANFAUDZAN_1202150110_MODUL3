package com.example.haryono.wildanfaudzan_1202150110_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by haryono on 2/25/2018.
 */

class DataAdapter extends RecyclerView.Adapter<DataAdapter.dataViewHolder>  {

    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Data> mData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context
     * @param Datas ArrayList containing the sports data
     * @param context Context of the applicationa
     */
    DataAdapter(Context context, ArrayList<Data> Datas) {
        this.mData = Datas;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.amidis);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    /**
     * Required method for creating the viewholder objects.
     * @param parent The ViewGroup into which the new View is added after it is
     *               bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly create SportsViewHolder.
     */
    @Override
    public dataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new dataViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false), mGradientDrawable);
    }

    /**
     * Required method that binds the data to the viewholder.
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(dataViewHolder holder, int position) {

        //Get the current sport
        Data currentData = mData.get(position);

        //Bind the data to the views
        holder.bindTo(currentData);

    }


    /**
     * Required method for determining the size of the data set.
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mData.size();
    }


    /**
     * SportsViewHolder class that represents each row of data in the RecyclerView
     */
    static class dataViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mDatassImage;
        private Context mContext;
        private Data mCurrentData;
        private GradientDrawable mGradientDrawable;

        /**
         * Constructor for the SportsViewHolder, used in onCreateViewHolder().
         * @param itemView The rootview of the list_item.xml layout file
         */
        dataViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mDatassImage = (ImageView)itemView.findViewById(R.id.datasImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Data currentData){
            //Populate the textviews with data
            mTitleText.setText(currentData.getTitle());
            mInfoText.setText(currentData.getInfo());

            //Get the current sport
            mCurrentData = currentData;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentData.
                    getImageResource()).placeholder(mGradientDrawable).into(mDatassImage);
        }

        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Data.starter(mContext, mCurrentData.getTitle(),
                    mCurrentData.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}