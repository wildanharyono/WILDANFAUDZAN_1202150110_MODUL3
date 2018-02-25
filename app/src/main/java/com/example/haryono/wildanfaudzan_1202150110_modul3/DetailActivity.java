package com.example.haryono.wildanfaudzan_1202150110_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private static int values = 0;
    private Button plus, minus;
    private TextView value;
    private ImageView imgBattery;
    /**
     * Initializes the activity, filling in the data from the Intent.
     * @param savedInstanceState Contains information about the saved state of the activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Initialize the views
        TextView datasTitle = (TextView)findViewById(R.id.titleDetail);
        ImageView datasImage = (ImageView)findViewById(R.id.datasImageDetail);

        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Data.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set the text from the Intent extra
        datasTitle.setText(getIntent().getStringExtra(Data.TITLE_KEY));

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Data.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(datasImage);

        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        value = findViewById(R.id.textView);
        imgBattery = findViewById(R.id.imageView);

        imgBattery.setImageResource(R.drawable.img_battery);
        value.setText(Integer.toString(values) + "Liter");
    }

    public void plus(View view) {
        values++;
        if (value != null) {
            switch (values) {
                case 1:
                    imgBattery.setImageResource(R.drawable.ic_battery_20);
                    value.setText(Integer.toString(values) + "Liter");
                    Toast.makeText(this, "Air Sedikit", Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    imgBattery.setImageResource(R.drawable.ic_battery_30);
                    value.setText(Integer.toString(values) + "Liter");
                    break;
                case 3:
                    imgBattery.setImageResource(R.drawable.ic_battery_50);
                    value.setText(Integer.toString(values) + "Liter");
                    break;
                case 4:
                    imgBattery.setImageResource(R.drawable.ic_battery_60);
                    value.setText(Integer.toString(values) + "Liter");
                    break;
                case 5:
                    imgBattery.setImageResource(R.drawable.ic_battery_80);
                    value.setText(Integer.toString(values) + "Liter");
                    break;
                case 6:
                    imgBattery.setImageResource(R.drawable.ic_battery_full);
                    value.setText(Integer.toString(values) + "Liter");
                    Toast.makeText(this, "Air Sudah Full", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    }

    public void minus(View view) {
        values--;
        if (value != null) {
            switch (values) {
                case 1:
                    imgBattery.setImageResource(R.drawable.ic_battery_20);
                    value.setText(Integer.toString(values) + "Liter");
                    Toast.makeText(this, "Air Sedikit", Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    imgBattery.setImageResource(R.drawable.ic_battery_30);
                    value.setText(Integer.toString(values) + "Liter");
                    break;
                case 3:
                    imgBattery.setImageResource(R.drawable.ic_battery_50);
                    value.setText(Integer.toString(values) + "Liter");
                    break;
                case 4:
                    imgBattery.setImageResource(R.drawable.ic_battery_60);
                    value.setText(Integer.toString(values) + "Liter");
                    break;
                case 5:
                    imgBattery.setImageResource(R.drawable.ic_battery_80);
                    value.setText(Integer.toString(values) + "Liter");
                    break;
                case 6:
                    imgBattery.setImageResource(R.drawable.ic_battery_full);
                    value.setText(Integer.toString(values) + "Liter");
                    Toast.makeText(this, "Full", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    }
}

