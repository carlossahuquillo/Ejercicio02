package carlossahuquillo.ejercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import carlossahuquillo.ejercicio02.modelos.Coche;

public class CocheActivity extends AppCompatActivity {
    EditText txtMarcaCoche, txtModeloCoche, txtColorCoche;
    Button btnCancelarCoche, btnCrearCoche;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche);

        inicializarVistas();

        btnCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtMarcaCoche.getText() != null && txtModeloCoche.getText() != null && txtColorCoche.getText() != null) {
                    String marca = txtMarcaCoche.getText().toString();
                    String modelo = txtModeloCoche.getText().toString();
                    String color = txtColorCoche.getText().toString();

                    Coche coche = new Coche(marca, modelo, color);

                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", coche);
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();

                } else {
                    Toast.makeText(CocheActivity.this, "Rellena todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCancelarCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void inicializarVistas() {
        txtMarcaCoche = findViewById(R.id.txtMarcaCoche);
        txtModeloCoche = findViewById(R.id.txtModeloCoche);
        txtColorCoche = findViewById(R.id.txtColorCoche);

        btnCancelarCoche = findViewById(R.id.btnCancelarCoche);
        btnCrearCoche = findViewById(R.id.btnCrearCoche);
    }
}