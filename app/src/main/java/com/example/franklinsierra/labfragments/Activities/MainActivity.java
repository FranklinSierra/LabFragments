package com.example.franklinsierra.labfragments.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.franklinsierra.labfragments.Fragments.DetailsFragment;
import com.example.franklinsierra.labfragments.Fragments.ListFragment;
import com.example.franklinsierra.labfragments.Models.Mail;
import com.example.franklinsierra.labfragments.R;

public class MainActivity extends AppCompatActivity implements ListFragment.OnFragmentIteractionListener {

    private boolean isMultipanel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultipanel();

    }

    //  ++++    Metodo que interactua fragment-activity ++++    //
    @Override
    public void onListClick(Mail mail) {
        if (isMultipanel) {
            //es una tablet
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.FragmentDetailsEmail);
            detailsFragment.renderMail(mail);
        } else {
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("subject", mail.getSubject());
            intent.putExtra("message", mail.getMsj());
            intent.putExtra("senderName", mail.getSenderMail());
            startActivity(intent);
        }
    }

    //  ++++    metodo para ver si hay mas de un fragment en un solo activity   ++++    //
    private void setMultipanel() {
        isMultipanel = (getSupportFragmentManager().findFragmentById(R.id.FragmentDetailsEmail) != null);
    }
}
