package services;

import java.util.ArrayList;

import models.Employee;

public interface GenService {
public Employee loginAttempt(String username, String password);
public void updateDatabase(ArrayList<String> information);
}
