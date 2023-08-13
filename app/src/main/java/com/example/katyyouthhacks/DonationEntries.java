package com.example.katyyouthhacks;

import android.net.Uri;

public class DonationEntries {
    private String title;
    private int quantity;
    private String clothingType;
    private Uri imageUri;

    public DonationEntries(String title, int quantity, String clothingType, Uri imageUri) {
        this.title = title;
        this.quantity = quantity;
        this.clothingType = clothingType;
        this.imageUri = imageUri;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getClothingType() {
        return clothingType;
    }

    public Uri getImageUri() {
        return imageUri;
    }
}
