package com.example.franklinsierra.labfragments.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.franklinsierra.labfragments.Adapters.MailAdapter;
import com.example.franklinsierra.labfragments.Models.Mail;
import com.example.franklinsierra.labfragments.R;
import com.example.franklinsierra.labfragments.Util.Util;

import java.util.List;

public class ListFragment extends Fragment {

    //LOS ATRIBUTOS QUE ANTES IBAN EN EL MAIN AHORA SE PONEN EN EL FRAGMENT

    //atributos
    private List<Mail> mails;
    private ListView listView;
    private MailAdapter adapter;

    //interfaz
    private OnFragmentIteractionListener mListener;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //inflo la vista
        View vista = inflater.inflate(R.layout.fragment_list, container, false);

        //instancio los elementos
        listView = (ListView) vista.findViewById(R.id.listViewMails);
        mails = Util.correos();
        //le paso al adapter el estilo de como se ve cada email en el inbox
        adapter = new MailAdapter(getContext(), R.layout.list_view_mail, mails);

        listView.setAdapter(adapter);


        //Cuando hagan click en cualquier item de la lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //le paso el item a la interface
                mListener.onListClick(mails.get(position));
            }
        });

        return vista;
    }

    //  ++++    Metodo para comunicarme con el activity ++++    //  COMO FUNCIONA ????
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentIteractionListener) {
            mListener = (OnFragmentIteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement OnFragmentIteractionListener");
        }
    }

    //  ++++    Metodo que limpia el metodo anterior    ++++    //
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentIteractionListener {
        void onListClick(Mail mail);
    }

}
