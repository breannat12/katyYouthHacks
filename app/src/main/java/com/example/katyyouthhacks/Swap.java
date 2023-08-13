package com.example.katyyouthhacks;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Swap extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap2);

        LinearLayout entriesLayout = findViewById(R.id.entriesLayout);

        // Retrieve the data passed from the Donate page
        String title = getIntent().getStringExtra("title");
        int quantity = getIntent().getIntExtra("quantity", 0);
        String clothingType = getIntent().getStringExtra("clothingType");
        String imageUriString = getIntent().getStringExtra("imageUri");

        // Inflate the entry layout and populate it with data
        View entryView = LayoutInflater.from(this).inflate(R.layout.entry_layout, entriesLayout, false);
        TextView entryInfoTextView = entryView.findViewById(R.id.entryInfoTextView);
        ImageView entryImageView = entryView.findViewById(R.id.entryImageView);

        String entryInfo = "Donated Item:\nTitle: " + title +
                "\nQuantity: " + quantity +
                "\nClothing Type: " + clothingType;
        entryInfoTextView.setText(entryInfo);

        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            entryImageView.setImageURI(imageUri);
        }

        // Add the entry layout to the entriesLayout
        entriesLayout.addView(entryView);
    }
}