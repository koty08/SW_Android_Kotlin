package com.example.week13ex03;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Pair;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Locale;

public class FashionActivity extends AppCompatActivity {
    public static final String TAG = "[IC]FashionActivity";
    public static final int GALLERY_IMAGE_REQUEST_CODE = 1;

    Classifier cls;
    Bitmap bitmap = null;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion);

        Button selectBtn = findViewById(R.id.selectBtn);
        selectBtn.setOnClickListener(v -> getImageFromGallery());


        imageView = findViewById(R.id.imageView);
        TextView resultView = findViewById(R.id.textView);
        Button classifyBtn = findViewById(R.id.classifyBtn);
        classifyBtn.setOnClickListener(view -> {
            if(bitmap != null){
                Pair<Integer, Float> res = cls.classify(bitmap);

                String outStr = String.format(
                        Locale.ENGLISH,
                        "%s, %.0f%%",
                        convertLabelToString(res.first), res.second * 100.0f);
                resultView.setText(outStr);
            }
        });

        cls = new Classifier(this);
        try {
            cls.init();
        } catch (IOException ioe){
            Log.d("DigitClassifier", "failed to init classifier", ioe);
        }
    }

    private String convertLabelToString(Integer label){
        switch (label){
            case 0: return "T-shirt/top";
            case 1: return "Trouser";
            case 2: return "Pullover";
            case 3: return "Dress";
            case 4: return "Coat";
            case 5: return "Sandal";
            case 6: return "Shirt";
            case 7: return "Sneaker";
            case 8: return "Bag";
            case 9: return "Ankle boot";
            default: return "none";
        }
    }

    private void getImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT).setType("image/*");
        startActivityForResult(intent, GALLERY_IMAGE_REQUEST_CODE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode ==  GALLERY_IMAGE_REQUEST_CODE) {
            if(data == null) {
                return;
            }

            Uri selectedImage = data.getData();

            try {
                if(Build.VERSION.SDK_INT >= 29) {
                    ImageDecoder.Source src =
                            ImageDecoder.createSource(getContentResolver(), selectedImage);
                    bitmap = ImageDecoder.decodeBitmap(src).copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                }
            } catch (IOException ioe) {
                Log.e(TAG, "Failed to read Image", ioe);
            }
        }

        if(bitmap != null){
            imageView.setImageBitmap(bitmap);
        }
    }

    @Override
    protected void onDestroy() {
        cls.finish();
        super.onDestroy();
    }
}
