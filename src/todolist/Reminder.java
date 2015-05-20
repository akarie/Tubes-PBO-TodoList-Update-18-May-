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
public class Reminder implements Serializable{
    private String codeTask;
    private Date reminder;

    public Reminder(String codeTask, Date reminder) {
        this.codeTask = codeTask;
        this.reminder = reminder;
    }

    public String getCodeTask() {
        return codeTask;
    }

    public void setCodeTask(String codeTask) {
        this.codeTask = codeTask;
    }

    public Date getReminder() {
        return reminder;
    }

    public void setReminder(Date reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "Reminder{" + "codeTask=" + codeTask + ", reminder=" + reminder + '}';
    }
    
}
