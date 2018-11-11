package com.app.landlordcommunication.views.ChatScreen;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

import com.app.landlordcommunication.R;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PictureActivity extends AppCompatActivity {

    @BindView(R.id.img_ImageView)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);

        ButterKnife.bind(this);

        Intent intent = getIntent();

        String messagePicture = intent.getStringExtra("messagePicture");
        InputStream stream = new ByteArrayInputStream(Base64.decode(messagePicture.getBytes(), Base64.DEFAULT));
        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        mImageView.setImageBitmap(bitmap);
    }
}
