package com.example.testlaravelapi.model.local;

import com.google.gson.annotations.SerializedName;

public class Event {
    @SerializedName("")
    String title;
    @SerializedName("")
    String description;
    @SerializedName("")
    String created_by;
    @SerializedName("")
    String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
