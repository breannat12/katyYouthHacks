package com.example.katyyouthhacks;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Swap extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap2);

        // Find your TextView and ImageView in the Swap page layout
        TextView swapInfoTextView = findViewById(R.id.swapInfoTextView);
        ImageView swapImageView = findViewById(R.id.swapImageView);

        // Retrieve the data passed from the Donate page
        String title = getIntent().getStringExtra("title");
        int quantity = getIntent().getIntExtra("quantity", 0);
        String clothingType = getIntent().getStringExtra("clothingType");
        String imageUriString = getIntent().getStringExtra("imageUri");

        // Display the received data in the TextView
        String swapInfo = "Donated Item:\nTitle: " + title +
                "\nQuantity: " + quantity +
                "\nClothing Type: " + clothingType;
        swapInfoTextView.setText(swapInfo);

        // Load the image into the ImageView
        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);
            swapImageView.setImageURI(imageUri);
        }
    }
}