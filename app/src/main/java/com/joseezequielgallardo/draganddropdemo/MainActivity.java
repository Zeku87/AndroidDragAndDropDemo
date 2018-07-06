package com.joseezequielgallardo.draganddropdemo;

import android.content.ClipData;
import android.content.ClipDescription;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imageViewLauncher;
    TextView textViewInfo;

    private RelativeLayout.LayoutParams layoutParams;

    /** Tags get widgets identified in the drag process **/
    private final String IMAGE_VIEW_LAUNCHER_TAG = "LAUNCHER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
