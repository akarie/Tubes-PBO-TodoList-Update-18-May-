/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author risol_000
 */
public class Task implements Serializable{
    private String nameTask, codeTask;
    private Date dueDate;
    private int prior;
    private boolean isDone;
    private ArrayList<Reminder> listReminder;
    
    public ArrayList<Reminder> getListReminder() {
        return listReminder;
    }
    public int getMaxIndex(){
        return listReminder.size();
    }
    
    public void addReminder(String codeTask, Date dueDate){
        Reminder reminderBaru = new Reminder(codeTask, dueDate);
        listReminder.add(reminderBaru);
    }
    public Task(String codeTask, String nameTask, Date dueDate, int prior) {
        this.nameTask = nameTask;
        this.codeTask = codeTask;
        this.dueDate = dueDate;
        this.prior = prior;
        this.isDone = false;
        listReminder = new ArrayList<>();
    }

    public boolean isIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getNameTask() {
        return nameTask;
    }

    public void setNameTask(String nameTask) {
        this.nameTask = nameTask;
    }

    public String getCodeTask() {
        return codeTask;
    }

    public void setCodeTask(String codeTask) {
        this.codeTask = codeTask;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    } 
    @Override
    public String toString() {
        return "\n\tNama Task: " + nameTask + "\n\tKode Task: " + codeTask + "\n\tDue Date: " + dueDate + "\n\tPriority: " + prior + "\n";
    }
}
