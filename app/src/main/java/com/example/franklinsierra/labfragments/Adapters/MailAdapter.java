package com.example.franklinsierra.labfragments.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.franklinsierra.labfragments.Models.Mail;
import com.example.franklinsierra.labfragments.R;

import java.util.List;

public class MailAdapter extends BaseAdapter {

    //atributos necesarios para el adaptador
    private Context context;
    private int layout;
    private List<Mail> list;

    //atributos propios de la logica del ejercicio
    private int SUBJECT_MAX_LENGHT = 40;
    private int MESSAGE_MAX_LENGHT = 80;

    public MailAdapter(Context context, int layout, List<Mail> mails) {
        this.context = context;
        this.layout = layout;
        this.list = mails;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        viewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(layout, null);
            vh = new viewHolder();
            vh.message = (TextView) convertView.findViewById(R.id.textViewListMessage);
            vh.subject = (TextView) convertView.findViewById(R.id.textViewListSubject);
            vh.sender = (TextView) convertView.findViewById(R.id.textViewListSenderName);

            convertView.setTag(vh);
        } else {
            vh = (viewHolder) convertView.getTag();

        }

        Mail currentMail = list.get(position);

        //logica si el subject es mas largo de 40
        String shortSubject;
        if (currentMail.getSubject().length() > SUBJECT_MAX_LENGHT) {
            //con el substring le digo desde comience hasta donde llegue
            shortSubject = currentMail.getSubject().substring(0, SUBJECT_MAX_LENGHT) + "...";
        } else {
            shortSubject = currentMail.getSubject();
        }
        vh.subject.setText(shortSubject);

        //la misma logica pero con el msj
        String shortMsj;
        if (currentMail.getMsj().length() > MESSAGE_MAX_LENGHT) {
            //recorto el msj desde el caracter 0 hasta el 80
            shortMsj = currentMail.getMsj().substring(0, MESSAGE_MAX_LENGHT);
        } else {
            shortMsj = currentMail.getMsj();
        }
        vh.message.setText(shortMsj);

        //para el sender solo se toma la primer letra del correo
        vh.sender.setText(currentMail.getSenderMail().substring(0, 1));

        //para cada correo el color del sender debe ser diferente y aleatorio
        // COMO FUNCIONA ?????
        vh.sender.getBackground().setColorFilter(Color.parseColor("#" + currentMail.getColor()), PorterDuff.Mode.SRC);


        return convertView;
    }

    private class viewHolder {
        private TextView subject;
        private TextView message;
        private TextView sender;
    }
}



