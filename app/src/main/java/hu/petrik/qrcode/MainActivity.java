package hu.petrik.qrcode;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;


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
        buttonGenerate.setOnClickListener(view -> {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            String data = editTextQRData.getText().toString().trim();
            if (data.isEmpty()) {
                Toast.makeText(this, "Kötelező adatot megadni", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    BitMatrix bitMatrix = multiFormatWriter.encode(data, BarcodeFormat.QR_CODE, 250, 250);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    imageViewQRResult.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void init() {
        editTextQRData = findViewById(R.id.editTextQRData);
        buttonGenerate = findViewById(R.id.buttonGenerate);
        buttonScan = findViewById(R.id.buttonScan);
        imageViewQRResult = findViewById(R.id.imageViewQRResult);
        textViewQRResult = findViewById(R.id.textViewQRResult);
    }
}