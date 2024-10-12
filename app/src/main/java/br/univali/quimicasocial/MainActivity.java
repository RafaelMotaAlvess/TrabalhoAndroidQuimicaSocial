package br.univali.quimicasocial;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button youtubeButton = findViewById(R.id.button2);
        Button instagramButton = findViewById(R.id.button);

        youtubeButton.setOnClickListener(v -> {
            String youtubeUrl = "https://www.youtube.com/@quimicasocial7191";
            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(youtubeUrl));
            startActivity(youtubeIntent);
        });

        instagramButton.setOnClickListener(v -> {
            String instagramUrl = "https://www.instagram.com/quimicasocial/";
            Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl));
            startActivity(instagramIntent);
        });

        ImageView imageView2 = findViewById(R.id.imageView2);

        imageView2.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });

        imageView2.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    v.setScaleX(1.05f);
                    v.setScaleY(1.05f);
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    v.setScaleX(1.0f);
                    v.setScaleY(1.0f);
                    break;
            }
            return false;
        });
    }
}
