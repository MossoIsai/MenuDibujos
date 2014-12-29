package org.mossin.com.menudibujos.app;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView tv1;
    ImageView imagen;
    private AnimationDrawable salvaAnimacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         tv1 =  (TextView)findViewById(R.id.textView);
        imagen =(ImageView)findViewById(R.id.imageView);
        imagen.setBackgroundResource(R.xml.pajarin);
        salvaAnimacion = (AnimationDrawable)imagen.getBackground();
        salvaAnimacion.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                //No se ase nada
            break;

            case R.id.opcion1:
                Intent intencion1 = new Intent(this,Caballo.class);
                startActivity(intencion1);
            break;

            case R.id.opcion2:
            Intent intencion2 = new Intent(this,Sonido.class);
                startActivity(intencion2);
            break;

            case R.id.opcion3:
             Intent intencion3 = new Intent(this,Dibujo.class);
                startActivity(intencion3);
            break;
        }
        return super.onOptionsItemSelected(item);
    }

}
