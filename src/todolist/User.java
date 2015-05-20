/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author risol_000
 */
public class User implements Serializable{
    private String username;
    private String password;
    
    private ArrayList<List> listList;

    public ArrayList<List> getListList() {
        return listList;
    }
    
    
    public User(String username, String password){
        this.username = username;
        this.password = password;
        listList = new ArrayList<>();
    }
    
    public int getMaxIndex(){
        return listList.size();
    }
    
    public void addList(String codeList, String nameList){
        List listBaru = new List(codeList, nameList);
        listList.add(listBaru);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Akun berhasil dibuat!" + "\nUsername: " + username + "\nPassword: " + password;
    }
}
