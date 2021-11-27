package com.example.fitness_center.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
