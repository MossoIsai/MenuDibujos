package org.mossin.com.menudibujos.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class Sonido extends ActionBarActivity implements View.OnTouchListener {

    private Drawable miImagen;
    private Resources res;
    private float px=50,py=50,incx=1,incy=1;
    private int idImagen=R.drawable.bird;
    EjemploView lienzo;
    public SoundPool sp;
    public int flujodemusica=0,flujodemusica2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sonido);
        res = getResources();
        lienzo=new EjemploView(this);
        setContentView(lienzo);
        lienzo.setOnTouchListener(this);
        //Sonido
        sp = new SoundPool(8, AudioManager.STREAM_MUSIC,0);
          this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
       flujodemusica = sp.load(this,R.raw.mosquito,1);
        flujodemusica2 = sp.load(this,R.raw.aplastado,1);

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {

            case MotionEvent.ACTION_MOVE:
                idImagen = R.drawable.sangre;
                break;
            case MotionEvent.ACTION_DOWN:
                idImagen = R.drawable.bird2;
                sp.play(flujodemusica,1,1,0,0,1);
                break;
            case MotionEvent.ACTION_UP:
                idImagen = R.drawable.bird;
                sp.play(flujodemusica2,1,1,0,0,1);

                break;
        }
        px = event.getX();
        py = event.getY();
        lienzo.invalidate();
        return true;
    }

    public class EjemploView extends View {
        private Drawable miImagen;
        public EjemploView (Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            miImagen = res.getDrawable(idImagen);
            miImagen.setBounds((int)px-50,(int)py-50,(int)px+50,(int)py+50);
            miImagen.draw(canvas);
        }

    }
}
