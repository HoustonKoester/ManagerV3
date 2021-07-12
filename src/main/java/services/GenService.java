package services;

import java.util.ArrayList;

import models.Employee;

public interface GenService {
public Employee loginAttempt(String username, String password);
public boolean updateDatabase(ArrayList<String> information);
public boolean insertReim(String id, String name, String amount);
public int genNewUserID();
public boolean addNewUser(int id, String name, String password, String empname, String empcity, String empstate, String position, String email);
public boolean addPendingEmployee(ArrayList<String> information);
public boolean deletePendingEmployee(ArrayList<String> information);
public boolean getActiveEmployee(String username, String password);
public boolean updateEmp(ArrayList<String> information);
public Employee returnActiveEmp();
public ArrayList<String> returnSpecificReim(int id);
}
