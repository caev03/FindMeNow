package cevaps.findmenow;

import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity
{
    public boolean encontrado = true;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String IP = "localhost";
        Button boton = (Button) findViewById(R.id.btnFound);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Vibrator vbr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                if(encontrado)
                {
                    encontrado=false;
                    while(!encontrado)
                    {
                        v.setBackgroundColor(Color.argb((int)Math.random()*255,(int)Math.random()*255,(int)Math.random()*255,(int)Math.random()*255));
                        vbr.vibrate(100);
                    }
                }
                else
                {
                    encontrado=true;
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
