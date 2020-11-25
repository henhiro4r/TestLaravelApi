package com.example.testlaravelapi.ui.login;

import androidx.lifecycle.ViewModel;

import com.example.testlaravelapi.repository.AuthRepository;

public class LoginViewModel extends ViewModel {

    private AuthRepository repository;

    public LoginViewModel() {
        repository = AuthRepository.getInstance();
    }
}
