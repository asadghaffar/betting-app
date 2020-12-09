package com.fcodex.maxbetfreetips.Modal;

import java.util.ArrayList;

public class ModalByDate {
    private String dateString;
    private ArrayList<Modal> modalsList;

    public ModalByDate() {
    }

    public ModalByDate(String dateString, ArrayList<Modal> modalsList) {
        this.dateString = dateString;
        this.modalsList = modalsList;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public ArrayList<Modal> getModalsList() {
        return modalsList;
    }

    public void setModalsList(ArrayList<Modal> modalsList) {
        this.modalsList = modalsList;
    }
}
