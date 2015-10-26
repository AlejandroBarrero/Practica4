package com.alejandrobarrero.practica4;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adaptador;
    ListView lstNombres;
    String Aboutapp;

    private Lista_Entrada[] datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Locale.getDefault().getLanguage().equals("en"))
        {
            Aboutapp = "Colombia Turística V.1.0\nEdition: San Agustín, Huila\nCreated by: Alejandro Barrero C.";
            datos =
                    new Lista_Entrada[] {
                            new Lista_Entrada(R.drawable.ciudad,"About San Agustín","Demographic information",1),
                            new Lista_Entrada(R.drawable.escultura1, "Tourist Activities", "Eco tourism, adventure, archeology",3),
                            new Lista_Entrada(R.drawable.bares, "Bars", "Fun at night",4),
                            new Lista_Entrada(R.drawable.hoteles, "Hotels", "The best accommodation",2),
                            new Lista_Entrada(R.drawable.barra, "About...", " ",5)};
        }
        else
        {
            Aboutapp = "Colombia Turística V.1.0\nEdición: San Agustín, Huila\nElaborado por: Alejandro Barrero C.";
            datos =
                    new Lista_Entrada[] {
                            new Lista_Entrada(R.drawable.ciudad,"Sobre San Agustín","Información demográfica",1),
                            new Lista_Entrada(R.drawable.escultura1, "Actividades Turísticas", "Ecoturismo, avenutura, arqueología",3),
                            new Lista_Entrada(R.drawable.bares, "Bares", "Diversión en la noche",4),
                            new Lista_Entrada(R.drawable.hoteles, "Hoteles", "Los mejores hospedajes",2),
                            new Lista_Entrada(R.drawable.barra, "Acerca de...", " ",5)};
        }

        final String[] nombre = new String[] {};

        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nombre);

        Adapter adaptador = new Adapter(this, datos);

        lstNombres = (ListView) findViewById(R.id.Lst);

        lstNombres.setAdapter(adaptador);

        lstNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int seleccion = ((Lista_Entrada) parent.getItemAtPosition(position)).getIdAct();

                switch(seleccion)
                {
                    case 1:
                        Intent inte = new Intent(getApplicationContext(), AboutSA.class);
                        startActivity(inte);
                        break;

                    case 2:
                        Intent inte2 = new Intent(getApplicationContext(), Hotels.class);
                        startActivity(inte2);
                        break;

                    case 3:
                        Intent inte3 = new Intent(getApplicationContext(), TouristSites.class);
                        startActivity(inte3);
                        break;

                    case 4:
                        Intent inte4 = new Intent(getApplicationContext(), Bars.class);
                        startActivity(inte4);
                        break;

                    default:
                        Toast.makeText(MainActivity.this, Aboutapp, Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public class Adapter extends ArrayAdapter<Lista_Entrada> {

        public Adapter(Context context, Lista_Entrada[] datos) {
            super(context, R.layout.layout_item, datos);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.layout_item, null);

            ImageView imagen = (ImageView) item.findViewById(R.id.imagen);
            imagen.setImageResource(datos[position].getIdImagen());

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombreActividad());

            TextView descripcion = (TextView) item.findViewById(R.id.tDescripcion);
            descripcion.setText(datos[position].getDescripcion());

            return item;
        }
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