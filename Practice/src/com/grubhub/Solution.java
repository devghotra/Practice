package com.grubhub;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Solution {

    private static boolean isValid(List<String> tasks){
        HashMap<Integer, Task> taskMap = new HashMap<>();
        for(String str : tasks){
            int id = getTaskId(str);
            Task task = taskMap.get(id);
            if(task == null){
                task = new Task();
                taskMap.put(id, task);
            }

            char taskType = str.charAt(0);
            if(taskType == 'p'){
                task.addPickup();
            }
            if(taskType == 'd'){
                boolean valid = task.addDropoff();
                if(!valid)
                    return false;
            }
        }
        return true;
    }

    private static int getTaskId(String task){
        String id = task.substring(1);
        return Integer.parseInt(id);
    }


    static class Task {

        private boolean pickup;
        private boolean dropoff;

        public boolean addPickup(){
            this.pickup = true;
            return true;
        }
        public boolean addDropoff(){
            if(!pickup)
                return false;

            dropoff = true;
            return dropoff;
        }

    }

    public static void main(String args[]){
        ArrayList<String> input = new ArrayList<>();
        input.add("p1");
        input.add("d1");
        System.out.println(isValid(input));
    }


}
