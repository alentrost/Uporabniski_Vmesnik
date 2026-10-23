package com.example.uporabniski_vmesnik;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button mZeroButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        mShowCount = findViewById(R.id.show_count);
        mZeroButton = findViewById(R.id.button_zero);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount != null) {
            mShowCount.setText(String.valueOf(mCount));
        }

        // Točka 7 in 8: Spreminjanje barve gumba Count (soda/liha vrednost) z uporabo parametra view (brez findViewById)
        if (mCount % 2 == 0) {
            view.setBackgroundColor(Color.GREEN);
        } else {
            view.setBackgroundColor(Color.BLUE);
        }

        // Točka 9: Sprememba barve gumba Zero na drugo barvo (nakaže aktiven gumb)
        if (mZeroButton != null) {
            mZeroButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    public void zero(View view) {
        mCount = 0;
        if (mShowCount != null) {
            mShowCount.setText(String.valueOf(mCount));
        }

        // Točka 10: Ob ponastavitvi števca vrnemo barvo gumba Zero na sivo
        view.setBackgroundColor(Color.GRAY);
    }
}
