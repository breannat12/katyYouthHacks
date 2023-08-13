package com.example.katyyouthhacks;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
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
        ArrayList<DonationEntries> donationEntriesList = getIntent().getParcelableArrayListExtra("donationEntriesList");

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

            Button claimButton = entryView.findViewById(R.id.claimBtn);

            // Set OnClickListener for the claim button
            claimButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Change the background color of the parent entry layout
                    entryView.setBackgroundResource(R.drawable.claimed_bg);
                    claimButton.setText("Claimed!");
                }
            });

            // Add the entry layout to the entriesLayout
            entriesLayout.addView(entryView);
        }
    }
}
