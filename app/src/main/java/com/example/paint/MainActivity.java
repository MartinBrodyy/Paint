package com.example.paint;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import static com.example.paint.Display.currentBrush;
import static com.example.paint.Display.brushWidth;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    static Paint paint = new Paint();
    static Path path = new Path();
    SeekBar sizeBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sizeBar = findViewById(R.id.sizeBar);

        sizeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar sizeBar, int progress,
                                          boolean fromUser) {
                brushWidth = progress;
                currentSize(brushWidth);
            }

            public void onStartTrackingTouch(SeekBar sizeBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar sizeBar) {
                // TODO Auto-generated method stub
            }
        });
    }



    public void redColor(View view) {
        paint.setColor(Color.RED);
        currentColor(paint.getColor());
    }

    public void yellowColor(View view) {
        paint.setColor(Color.YELLOW);
        currentColor(paint.getColor());
    }

    public void greenColor(View view) {
        paint.setColor(Color.GREEN);
        currentColor(paint.getColor());
    }

    public void blueColor(View view) {
        paint.setColor(Color.BLUE);
        currentColor(paint.getColor());
    }

    public void purpleColor(View view) {
        paint.setColor(Color.MAGENTA);
        currentColor(paint.getColor());
    }

    public void currentColor(int color) {
        currentBrush = color;
        path = new Path();
    }

    public void currentSize (int size) {
        brushWidth = size;
        path = new Path();
    }
}