package com.example.user_management.dao.enums;

public enum TaskStatus {
    TO_DO,
    IN_PROGRESS,
    IN_REVIEW,
    DONE;

    public boolean isValidStatus(String text){
        for(var status: TaskStatus.values()){
            if(status.name().equals(text))
                return true;
        }
        return false;
    }
    public static TaskStatus getStatusByLabel(String text){
        for(var status:TaskStatus.values()){
            if(status.name().equals(text))
                return status;
        }
        return null;
    }
}
