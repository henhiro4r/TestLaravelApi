package com.example.testlaravelapi.repository;

import com.example.testlaravelapi.network.RetrofitService;

public class EventRepository {

    private static EventRepository eventRepository;
    private RetrofitService apiService;
    private static final String TAG = "EventRepository";

    private EventRepository() {
        apiService = RetrofitService.getInstance();
    }

    public static EventRepository getInstance() {
        if (eventRepository == null) {
            eventRepository = new EventRepository();
        }
        return eventRepository;
    }
}
