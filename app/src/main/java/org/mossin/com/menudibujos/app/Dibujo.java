package org.mossin.com.menudibujos.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Dibujo extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo);
        setContentView(new CanvasDibuja(this));
    }
     public class CanvasDibuja extends View{
         private ShapeDrawable miImagen;


         public CanvasDibuja(Context context){
             super(context);
             miImagen = new ShapeDrawable( new RectShape());
             miImagen.getPaint().setColor(0XFF0FFF0);
             miImagen.setBounds(100,100,300,400);

         }

         @Override
         protected void onDraw(Canvas canvas) {
             Paint pincel = new Paint();
             Paint pincel2 = new Paint();
             RectF rectf = new RectF();
             Paint rectangulo = new Paint();
             rectangulo.setColor( Color.MAGENTA);
             rectangulo.setStrokeWidth(6);
             pincel2.setColor(Color.RED);
             pincel.setColor(Color.YELLOW);
             pincel.setStrokeWidth(8);
             pincel2.setStrokeWidth(6);
             rectangulo.setStyle(Paint.Style.FILL_AND_STROKE);
             pincel2.setStyle(Paint.Style.FILL);
             pincel.setStyle(Paint.Style.FILL_AND_STROKE);
             canvas.drawRoundRect(rectf,600,1200,rectangulo);
             canvas.drawCircle(150, 150, 50, pincel);

             canvas.drawLine(30,70,200,300,pincel2);
             canvas.drawLine(100,150,500,100,rectangulo);
             canvas.drawCircle(400,400,200,rectangulo);
             canvas.drawRect(100,300,200,400,pincel2);
             canvas.drawRect(100,500,400,600,pincel);
             canvas.drawPoint(300,150,pincel);
             canvas.drawText("PRIMITIVAS",100,100,pincel2);
             miImagen.draw(canvas);
         }

     }// fin de la clase de dibujo



}
