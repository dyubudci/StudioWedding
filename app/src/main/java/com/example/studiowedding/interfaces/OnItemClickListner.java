package com.example.studiowedding.interfaces;

import com.example.studiowedding.model.Task;

public interface OnItemClickListner {
    void onItemClick(int position);

    interface TaskI{
      void nextUpdateScreenTask(Task task);
      void showConfirmDelete();
    }

}
