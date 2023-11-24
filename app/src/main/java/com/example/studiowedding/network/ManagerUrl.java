package com.example.studiowedding.network;

public class ManagerUrl {
    public static final String BASE_URL = "http://192.168.1.12:3000/api/";

  // Account
    public static final String ACCOUNT = "account/Login";
  // Task
    public static final String READ_TASKS = "tasks";
    public static final String READ_TASKS_ROLE = "tasks/role";
    public static final String UPDATE_TASKS = "update/task/{id}";
    public static final String DELETE_TASKS = "delete/task/{id}";
}
