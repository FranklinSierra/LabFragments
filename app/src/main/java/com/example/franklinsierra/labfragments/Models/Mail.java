package com.example.franklinsierra.labfragments.Models;

import com.example.franklinsierra.labfragments.Util.Util;

public class Mail  {

    //atributos

    private String subject;
    private String msj;
    private String senderMail;
    private String color;

    public Mail(String subject, String msj, String senderMail) {

        this.subject = subject;
        this.msj = msj;
        this.senderMail = senderMail;
        this.color =Util.getRandomColors();
    }


    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public String getSenderMail() {
        return senderMail;
    }

    public void setSenderMail(String senderMail) {
        this.senderMail = senderMail;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
