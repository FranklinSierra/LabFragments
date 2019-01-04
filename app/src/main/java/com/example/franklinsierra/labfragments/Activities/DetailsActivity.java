package com.example.franklinsierra.labfragments.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.franklinsierra.labfragments.Fragments.DetailsFragment;
import com.example.franklinsierra.labfragments.Models.Mail;
import com.example.franklinsierra.labfragments.R;

public class DetailsActivity extends AppCompatActivity {

    //elementos de la UI
    private String subject;
    private String senderName;
    private String msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if (getIntent().getExtras() != null) {
            subject = getIntent().getStringExtra("subject");
            senderName = getIntent().getStringExtra("senderName");
            msj = getIntent().getStringExtra("message");
        }

        Mail mail = new Mail(subject, msj, senderName);
        DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.FragmentDetailsEmail);
        detailsFragment.renderMail(mail);
    }
}
