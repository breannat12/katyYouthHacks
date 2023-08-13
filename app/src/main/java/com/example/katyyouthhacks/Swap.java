package com.example.katyyouthhacks;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Swap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swap2);

        LinearLayout entriesLayout = findViewById(R.id.entriesLayout);

        // Retrieve the list of DonationEntries passed from the Donate page
        ArrayList<DonationEntries> donationEntriesList = getIntent().getParcelableArrayListExtra("donationEntriesList");

        // Loop through the list and populate the UI with each entry
        for (DonationEntries entry : donationEntriesList) {
            View entryView = LayoutInflater.from(this).inflate(R.layout.entry_layout, entriesLayout, false);
            TextView entryInfoTextView = entryView.findViewById(R.id.entryInfoTextView);
            ImageView entryImageView = entryView.findViewById(R.id.entryImageView);

            String entryInfo = "Title: " + entry.getTitle() +
                    "\nQuantity: " + entry.getQuantity() +
                    "\nClothing Type: " + entry.getClothingType();
            entryInfoTextView.setText(entryInfo);

            Uri imageUri = entry.getImageUri();
            if (imageUri != null) {
                entryImageView.setImageURI(imageUri);
            }

            // Add the entry layout to the entriesLayout
            entriesLayout.addView(entryView);
        }
    }
}