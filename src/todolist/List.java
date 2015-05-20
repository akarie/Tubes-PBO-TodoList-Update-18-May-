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
public class List implements Serializable{
    private String nameList;
    private String codeList;
    private ArrayList<Task> listTask;
    
    public ArrayList<Task> getListTask() {
        return listTask;
    }
    public int getMaxIndex(){
        return listTask.size();
    }
    
    public void addTask(String codeTask, String nameTask, Date dueDate, int prior){
        Task taskBaru = new Task(codeTask, nameTask, dueDate, prior);
        listTask.add(taskBaru);
    }
    
    public List(String codeList, String nameList) {
        this.nameList = nameList;
        this.codeList = codeList;
        listTask = new ArrayList<>();
    }
    

    public String getNameList() {
        return nameList;
    }

    public void setNameList(String nameList) {
        this.nameList = nameList;
    }

    public String getCodeList() {
        return codeList;
    }

    public void setCodeList(String codeList) {
        this.codeList = codeList;
    }

    @Override
    public String toString() {
        return "\nNama List: " + nameList + "\nKode List: " + codeList + "\n" + getListTask();
    }

    
    
}
