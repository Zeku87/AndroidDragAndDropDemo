package com.joseezequielgallardo.draganddropdemo;

import android.content.ClipData;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewOptionA, textViewOptionB, textViewOptionC;
    ImageView imageViewAnswerA, imageViewAnswerB, imageViewAnswerC;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewOptionA = this.findViewById(R.id.textViewA);
        textViewOptionB = this.findViewById(R.id.textViewB);
        textViewOptionC = this.findViewById(R.id.textViewC);

        imageViewAnswerA = this.findViewById(R.id.imageViewA);
        imageViewAnswerB = this.findViewById(R.id.imageViewB);
        imageViewAnswerC = this.findViewById(R.id.imageViewC);

        textViewOptionA.setOnTouchListener(new ChoiceClicked());
        textViewOptionB.setOnTouchListener(new ChoiceClicked());
        textViewOptionC.setOnTouchListener(new ChoiceClicked());

        imageViewAnswerA.setOnDragListener(new ChoiceDragged());
        imageViewAnswerB.setOnDragListener(new ChoiceDragged());
        imageViewAnswerC.setOnDragListener(new ChoiceDragged());


    }

    private class ChoiceClicked implements View.OnTouchListener{

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            }
            return false;
        }
    }

    private class ChoiceDragged implements View.OnDragListener{

        @Override
        public boolean onDrag(View view, DragEvent dragEvent) {
            final String TAG = "ACTION";
            switch (dragEvent.getAction()){
                case DragEvent.ACTION_DRAG_STARTED:
                    Log.d(TAG,"DRAG STARTED");
                    break;

                case DragEvent.ACTION_DRAG_ENTERED:
                    Log.d(TAG,"DRAG ENTERED");
                    break;

                case DragEvent.ACTION_DRAG_LOCATION:
                    Log.d(TAG,"DRAGGING");
                    break;

                case DragEvent.ACTION_DROP:
                    Log.d(TAG,"DROP");
                    View draggedView = (View) dragEvent.getLocalState();
                    TextView textViewChoice = (TextView) draggedView;

                    ImageView imageViewChoice = (ImageView) view;

                    if(imageViewChoice.getContentDescription().toString() == textViewChoice.getText().toString())
                    {
                        draggedView.setVisibility(View.INVISIBLE);
                        view.setVisibility(View.INVISIBLE);
                        Toast.makeText(MainActivity.this, getString(R.string.correct), Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(MainActivity.this, getString(R.string.incorrect), Toast.LENGTH_SHORT).show();
                    }
                    break;

                case DragEvent.ACTION_DRAG_EXITED:
                    Log.d(TAG,"DRAG EXITED");
                    break;

                case DragEvent.ACTION_DRAG_ENDED:
                    Log.d(TAG,"DRAG ENDED");
                    break;

                default:
                    break;
            }

            return true;
        }
    }
}
