package com.example.katyyouthhacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.os.Parcelable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Donate extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 1;

    private EditText titleEditText, quantityInput;
    private ImageView imageView;
    private Uri imageUri;
    private Spinner typeSpinner;

    private List<DonationEntries> donationEntriesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate);

        titleEditText = findViewById(R.id.titleEditText);
        quantityInput = findViewById(R.id.quantityEditText);
        imageView = findViewById(R.id.imageView);
        typeSpinner = findViewById(R.id.typeSpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.clothing_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        Button uploadButton = findViewById(R.id.uploadButton);
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagePicker();
            }
        });

        Button submitButton = findViewById(R.id.submitBtn);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });

        Button swapButton = findViewById(R.id.swapButton);
        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent swapIntent = new Intent(Donate.this, Swap.class);
                swapIntent.putParcelableArrayListExtra("donationEntriesList", new ArrayList<>(donationEntriesList));
                startActivity(swapIntent);
            }
        });
    }

    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
    }

    private void submitData() {
        String title = titleEditText.getText().toString();
        int quantity = Integer.parseInt(quantityInput.getText().toString());
        String clothingType = typeSpinner.getSelectedItem().toString();

        DonationEntries donationEntry = new DonationEntries(title, quantity, clothingType, imageUri); // Use the selected imageUri
        donationEntriesList.add(donationEntry);

        // Clear input fields after submission
        titleEditText.setText("");
        quantityInput.setText("");
        imageView.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageUri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}