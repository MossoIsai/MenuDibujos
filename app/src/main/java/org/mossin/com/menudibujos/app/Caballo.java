package org.mossin.com.menudibujos.app;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Caballo extends ActionBarActivity  implements View.OnClickListener{
    Button iniciar, detener;
    ImageView img;
    private AnimationDrawable salvaAnimacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caballo);

      iniciar = (Button)findViewById(R.id.button);
      detener = (Button)findViewById(R.id.button2);
        iniciar.setOnClickListener(this);
        detener.setOnClickListener(this);

       img = (ImageView)findViewById(R.id.imageView);
        img.setBackgroundResource(R.xml.animacion);
        salvaAnimacion = (AnimationDrawable)img.getBackground();



    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.button:
            salvaAnimacion.start();
           break;

           case R.id.button2:
           salvaAnimacion.stop();
           break;
       }

    }
}
