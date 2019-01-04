package com.example.franklinsierra.labfragments.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.franklinsierra.labfragments.Models.Mail;
import com.example.franklinsierra.labfragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    //elementos de la UI
    private TextView textViewSubject;
    private TextView textViewSender;
    private TextView textViewMessage;
    private LinearLayout wrapper;


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_content, container, false);

        //ubico los elementos de la UI por id con la vista
        textViewSubject = vista.findViewById(R.id.textViewFragmentSubject);
        textViewSender = vista.findViewById(R.id.textViewFragmentSenderName);
        textViewMessage = vista.findViewById(R.id.textViewFragmentMessage);
        wrapper = (LinearLayout) vista.findViewById(R.id.fragmentDetailsMailWrapper);

        return vista;
    }

    //  ++++    Metodo para adaptar el mensaje en el segundo fragment   ++++    //
    public void renderMail(Mail mail) {
        wrapper.setVisibility(View.VISIBLE);
        textViewSubject.setText(mail.getSubject());
        textViewSender.setText(mail.getSenderMail());
        textViewMessage.setText(mail.getMsj());
    }

}
