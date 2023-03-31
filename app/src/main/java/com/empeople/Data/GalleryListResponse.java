package com.empeople.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class GalleryListResponse {
    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("Data")
    @Expose
    private ArrayList<Dataum> data = null;

    @SerializedName("doctors")
    @Expose
    private ArrayList<Dataum> doctors = null;




    public ArrayList<Dataum> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Dataum> doctors) {
        this.doctors = doctors;
    }

    @SerializedName("appointment_list")
    @Expose
    private ArrayList<Dataum> appointment_list = null;

    public ArrayList<Dataum> getAppointment_list() {
        return appointment_list;
    }

    public void setAppointment_list(ArrayList<Dataum> appointment_list) {
        this.appointment_list = appointment_list;
    }

    @SerializedName("events")
    @Expose
    private ArrayList<Dataum> events = null;

    public ArrayList<Dataum> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Dataum> events) {
        this.events = events;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Dataum> getData() {
        return data;
    }

    public void setData(ArrayList<Dataum> data) {
        this.data = data;
    }

}


