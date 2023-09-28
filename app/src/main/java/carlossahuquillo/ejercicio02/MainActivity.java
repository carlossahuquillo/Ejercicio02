package carlossahuquillo.ejercicio02;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import carlossahuquillo.ejercicio02.databinding.ActivityMainBinding;
import carlossahuquillo.ejercicio02.modelos.Bici;
import carlossahuquillo.ejercicio02.modelos.Coche;
import carlossahuquillo.ejercicio02.modelos.Moto;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ArrayList<Coche> coches = new ArrayList<>();
    private ActivityResultLauncher<Intent> launcherCoches;
    private ArrayList<Moto> motos = new ArrayList<>();
    private ActivityResultLauncher<Intent> launcherMotos;
    private ArrayList<Bici> bicis = new ArrayList<>();
    private ActivityResultLauncher<Intent> launcherBicis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inicializarLaunchers();

        binding.btnCrearCocheMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CocheActivity.class);
                launcherCoches.launch(intent);

            }
        });

        binding.btnCrearMotoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MotoActivity.class);
                launcherMotos.launch(intent);

            }
        });
    }

    private void inicializarLaunchers() {
        launcherCoches = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        Bundle bundle = result.getData().getExtras();

                        Coche coche = (Coche) bundle.getSerializable("COCHE");

                        coches.add(coche);
                        binding.lblContadorCochesMain.setText(String.valueOf(coches.size()));

                        Toast.makeText(MainActivity.this, coche.toString(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Ventana Cancelada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        launcherMotos = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        Bundle bundle = result.getData().getExtras();

                        Moto moto = (Moto) bundle.getSerializable("MOTO");

                        motos.add(moto);
                        binding.lblContadorMotosMain.setText(String.valueOf(motos.size()));

                        Toast.makeText(MainActivity.this, moto.toString(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Ventana Cancelada", Toast.LENGTH_SHORT).show();
                }
            }
        });

        launcherBicis = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    if (result.getData() != null) {
                        Bundle bundle = result.getData().getExtras();

                        Bici bici = (Bici) bundle.getSerializable("BICI");

                        bicis.add(bici);
                        binding.lblContadorBicisMain.setText(String.valueOf(bicis.size()));

                        Toast.makeText(MainActivity.this, bici.toString(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "No hay datos", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Ventana Cancelada", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}