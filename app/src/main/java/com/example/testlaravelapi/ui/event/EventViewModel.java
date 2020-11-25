package com.example.testlaravelapi.ui.event;

import androidx.lifecycle.ViewModel;

import com.example.testlaravelapi.repository.EventRepository;

public class EventViewModel extends ViewModel {

    private EventRepository repository;

    public EventViewModel() {
        repository = EventRepository.getInstance();
    }
}
