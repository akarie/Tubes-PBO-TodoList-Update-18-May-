/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author risol_000
 */
public class ToDoList {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        // TODO code application logic here
        Aplikasi app = new Aplikasi();
        app.menuAwal();
    }
    
}
