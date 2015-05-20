/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author risol_000
 */
public class FileIO {
    public void saveObject(Object o, String fileName) throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.flush();
        }
    }

    public Object getObject(String fileName) throws ClassNotFoundException, IOException {
        Object o;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            o = ois.readObject();
        }
        return o;
    }
}
