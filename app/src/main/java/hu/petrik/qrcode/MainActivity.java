package hu.petrik.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextQRData;
    private Button buttonGenerate;
    private Button buttonScan;
    private ImageView imageViewQRResult;
    private TextView textViewQRResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        editTextQRData = findViewById(R.id.editTextQRData);
        buttonGenerate = findViewById(R.id.buttonGenerate);
        buttonScan = findViewById(R.id.buttonScan);
        imageViewQRResult = findViewById(R.id.imageViewQRResult);
        textViewQRResult = findViewById(R.id.textViewQRResult);
    }
}