package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText UName, Phone, Email, Description;
    ImageView imageView;
    Button submit, chooseImage;
    androidx.appcompat.widget.Toolbar toolbartwo;
    Spinner spinner;

    String userName, userPhone, userEmail, AnimalDescription;
    private static final int PICK_IMAGE=1;
    Uri imageUri;
    RelativeLayout OuterRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        spinner = (Spinner)findViewById(R.id.speciesSpinner);
        UName=findViewById(R.id.NameOfUSer);
        Phone=findViewById(R.id.PhoneNumber);
        Email=findViewById(R.id.Email);
        imageView=(ImageView) findViewById(R.id.CreatureImage);
        Description=findViewById(R.id.Description);
        submit=(Button)findViewById(R.id.submitButton);
        chooseImage=(Button)findViewById(R.id.chooseImage);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.species_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        OuterRelativeLayout = (RelativeLayout)findViewById(R.id.outerrelativelayout);
        OuterRelativeLayout.setBackgroundResource(R.drawable.gradient_files);
        AnimationDrawable animationDrawable = (AnimationDrawable)OuterRelativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(2000);
        animationDrawable.start();

        toolbartwo =findViewById(R.id.toolbarofregisteractivity);
        toolbartwo.setTitle("Register New Species");
        setSupportActionBar(toolbartwo);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        chooseImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opengallery();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName=UName.getText().toString().trim();
                userPhone=Phone.getText().toString().trim();
                userEmail=Email.getText().toString().trim();
                AnimalDescription=Description.getText().toString().trim();
            }
        });


    }

    private void opengallery() {
        Intent gallery= new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK && requestCode==PICK_IMAGE) {
           try {
                imageUri = data.getData();
                final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                imageView.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(RegisterActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(RegisterActivity.this, "You haven't picked Image",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text + " is selected",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

