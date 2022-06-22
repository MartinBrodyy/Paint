package com.example.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import static com.example.paint.MainActivity.paint;
import static com.example.paint.MainActivity.path;

public class Display extends View {

    public static ArrayList<Path> pathList = new ArrayList<android.graphics.Path>();
    public static ArrayList<Integer> colorList = new ArrayList<>();
    public static ArrayList<Integer> sizeList = new ArrayList<>();
    public static int currentBrush = Color.BLACK;
    public static int brushWidth = 20;

    public Display(Context context) {
        super(context);
        init(context);
    }

    public Display(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Display(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x, y);
                pathList.add(path);
                colorList.add(currentBrush);
                sizeList.add(brushWidth);
                break;
            case MotionEvent.ACTION_UP:
                break;
            default: return false;
        }
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(int i=0; i<pathList.size();i++) {
            paint.setColor(colorList.get(i));
            paint.setStrokeWidth(sizeList.get(i));
            canvas.drawPath(pathList.get(i), paint);
            invalidate();
        }
    }
}
