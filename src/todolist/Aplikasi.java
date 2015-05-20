/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author risol_000
 */
public class Aplikasi {
    private ArrayList<User> listUser;
    private ArrayList<Jadwal> listJadwal;
    private ArrayList<List> listList;
    private FileIO koneksiIO;
    private BufferedReader baca;
    private String userCek="";

    /**
     *
     */
    public Aplikasi(){
        listUser = new ArrayList<>();
        listJadwal = new ArrayList<>();
        koneksiIO = new FileIO();
        baca = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     *
     * @throws IOException
     */
    public void saveDataUser() throws IOException {
        try {
            koneksiIO.saveObject(listUser, "User.txt");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File tidak ditemukan.");
        } catch (IOException ex) {
            throw new IOException("IO Exception");
        }
    }

    /**
     *
     * @throws IOException
     */
    public void saveDataList() throws IOException {
        try {
            koneksiIO.saveObject(listList, "List.txt");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File tidak ditemukan.");
        } catch (IOException ex) {
            throw new IOException("IO Exception");
        }
    }

    /**
     *
     * @throws IOException
     */
    public void saveDataJadwal() throws IOException {
        try {
            koneksiIO.saveObject(listJadwal, "Jadwal.txt");
        } catch (FileNotFoundException ex) {
            throw new FileNotFoundException("File tidak ditemukan.");
        } catch (IOException ex) {
            throw new IOException("IO Exception");
        }
    }

    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadDataUser() throws IOException, ClassNotFoundException {
        try {
            listUser = (ArrayList<User>) koneksiIO.getObject("User.txt");
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("No class found.");
        } catch (IOException ex) {
            throw new IOException("IO Exception");
        }
    }

    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadDataJadwal() throws IOException, ClassNotFoundException {
        try {
            listJadwal = (ArrayList<Jadwal>) koneksiIO.getObject("Jadwal.txt");
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("No class found.");
        } catch (IOException ex) {
            throw new IOException("IO Exception");
        }
    }
    
    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void loadDataList() throws IOException, ClassNotFoundException {
        try {
            listList = (ArrayList<List>) koneksiIO.getObject("List.txt");
        } catch (ClassNotFoundException ex) {
            throw new ClassNotFoundException("No class found.");
        } catch (IOException ex) {
            throw new IOException("IO Exception");
        }
    }

    /**
     *
     * @return
     */
    public int currentIndex(){
        int i=0;
        for(User temp : listUser){
            if(userCek == temp.getUsername()){
                return i;
            }
            i++;
        }
        return 0;
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public boolean signUp(String username, String password) throws IOException, ClassNotFoundException{
        boolean cek = true;
        loadDataUser();
        User userBaru = new User(username, password);
        for(User temp : listUser){
            if(temp.getUsername().equals(userBaru.getUsername())){
                cek = false;
            }
        }
        if(cek){
            listUser.add(userBaru);
            saveDataUser();
            
        }
        return cek;
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public boolean signIn(String username, String password) throws IOException, ClassNotFoundException{
        
        loadDataUser();
        for(User temp : listUser){
            if(username.equals(temp.getUsername()) && password.equals(temp.getPassword())){
                userCek = temp.getUsername();
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param userCek
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public int currentIndex(String userCek) throws IOException, ClassNotFoundException{
        int i=0;
        loadDataUser();
        for (User temp : listUser) {
            if(userCek.equals(temp.getUsername())){
                break;
            }
            i++;
        }
        return i;
    }

    /**
     *
     * @return
     */
    public String getUsername(){
        String username="";
        for (User temp : listUser) {      
            username = username + temp.getUsername() + "\n";
        }
        return username;
    }

    /**
     *
     * @param currentIndex
     * @return
     */
    public ArrayList getKodeList(int currentIndex){
        return listUser.get(currentIndex).getListList();
    }

    /**
     *
     * @param currentIndex
     * @return
     */
    public ArrayList viewTask(int currentIndex){
        return listUser.get(currentIndex).getListList();
    }

    /**
     *
     * @param currentIndex
     * @param userCek
     * @param namaList
     * @throws IOException
     */
    public void inputList(int currentIndex, String userCek, String namaList) throws IOException{
        String codeList = userCek + "L" + String.valueOf(listUser.get(currentIndex).getMaxIndex()+1);
        listUser.get(currentIndex).addList(codeList, namaList);
        saveDataUser();
    }

    /**
     *
     * @param currentIndex
     * @param codeList
     * @param nameList
     * @return
     * @throws IOException
     */
    public boolean updateList(int currentIndex, String codeList, String nameList) throws IOException{
        int i = 0;
        boolean cek = false;
        for(List temp : listUser.get(currentIndex).getListList()){
            if(codeList.equals(temp.getCodeList())){
                cek = true;
                break;
            }
            i++;
        }
        if(cek){
            listUser.get(currentIndex).getListList().get(i).setNameList(nameList);
            saveDataUser();
        }
        return cek;
    }

    /**
     *
     * @param currentIndex
     * @param codeList
     * @return
     * @throws IOException
     */
    public boolean deleteList(int currentIndex,String codeList) throws IOException{
        int i = 0;
        boolean cek = false;
        for(List temp : listUser.get(currentIndex).getListList()){
            if(codeList.equals(temp.getCodeList())){
                cek = true;
                System.out.println(i);
                break;
            }
            i++;
        }
        if(cek){
            listUser.get(currentIndex).getListList().remove(i);
        saveDataUser();
        }
        return cek;
    }

    /**
     *
     * @param currentIndex
     * @param codeList
     * @param nameTask
     * @param dueDate
     * @param priorTask
     * @return
     * @throws IOException
     */
    public boolean inputTask(int currentIndex, String codeList, String nameTask, Date dueDate, int priorTask) throws IOException{
        int i = 0;
        boolean cek = false;
        for (List temp : listUser.get(currentIndex).getListList()) {
            if(codeList.equals(temp.getCodeList())){
                cek = true;
                break;
            }
            i++;
        }
        if(cek){
            String codeTask = listUser.get(currentIndex).getListList().get(i).getCodeList() + "T" + String.valueOf(listUser.get(currentIndex).getListList().get(i).getMaxIndex()+1);
            listUser.get(currentIndex).getListList().get(i).addTask(codeTask, nameTask, dueDate, priorTask);
        saveDataUser();
        }
        return cek;
    }

    /**
     *
     * @param currentIndex
     * @param codeList
     * @param codeTask
     * @param nameTask
     * @param dueDate
     * @param priorTask
     * @return
     * @throws IOException
     */
    public boolean updateTask(int currentIndex, String codeList, String codeTask, String nameTask, Date dueDate, int priorTask) throws IOException{
        int i = 0;
        boolean cek = false;
        boolean cek2 = false;
        for(List temp : listUser.get(currentIndex).getListList()){
            if(codeList.equals(temp.getCodeList())){
                cek = true;
                break;
            }
            i++;
        }
        if(cek){
            int j = 0;
            for(Task temp : listUser.get(currentIndex).getListList().get(i).getListTask()){
                if(codeTask.equals(temp.getCodeTask())){
                    cek2 = true;
                    break;
                }
                j++;
            }
            if(cek2){
                listUser.get(currentIndex).getListList().get(i).getListTask().get(j).setNameTask(nameTask);
                listUser.get(currentIndex).getListList().get(i).getListTask().get(j).setDueDate(dueDate);
                listUser.get(currentIndex).getListList().get(i).getListTask().get(j).setPrior(priorTask);
                saveDataUser();
            }
        }
        return cek2;
    }

    /**
     *
     * @param currentIndex
     * @param codeList
     * @param codeTask
     * @return
     * @throws IOException
     */
    public boolean deleteTask(int currentIndex, String codeList, String codeTask) throws IOException{
        int i = 0;
        boolean cek = false;
        boolean cek2 = false;
        for(List temp : listUser.get(currentIndex).getListList()){
            if(codeList.equals(temp.getCodeList())){
                cek = true;
                break;
            }
            i++;
        }
        if(cek){
            int j = 0;
            for(Task temp : listUser.get(currentIndex).getListList().get(i).getListTask()){
                if(codeTask.equals(temp.getCodeTask())){
                    cek2 = true;
                    break;
                }
                j++;
            }
            if(cek2){
                listUser.get(currentIndex).getListList().get(i).getListTask().remove(j);
        saveDataUser();
            }
        }
        return cek2;
    }

    /**
     *
     * @param currentIndex
     * @param shareUserIndex
     * @param codeList
     * @return
     * @throws IOException
     */
    public boolean shareList(int currentIndex, int shareUserIndex, String codeList) throws IOException{
        boolean cek = false;
        List shareList = null;
        for (List temp : listUser.get(currentIndex).getListList()) {
            if(codeList.equals(temp.getCodeList())){
                cek = true;
                shareList = temp;
                break;
            };
        }
        if(cek){
            listUser.get(shareUserIndex).getListList().add(shareList);
            saveDataUser();
        }
        return cek;
    }

    /**
     *
     * @param password
     * @param i
     * @throws IOException
     */
    public void ubahPassword(String password, int i) throws IOException{
        listUser.get(i).setPassword(password);
        saveDataUser();
    }

    /**
     *
     * @param i
     * @param password
     * @return
     * @throws IOException
     */
    public boolean hapusAkun(int i, String password) throws IOException{
        boolean cek = false;
        for(User temp : listUser){
            if(password.equals(temp.getPassword())){
                cek = true;
                listUser.remove(i);
                saveDataUser();
                break;
            }
        }
        return cek;
    }

    /**
     *
     * @param codeList
     * @param codeTask
     * @param date
     * @param currentIndex
     * @return
     * @throws IOException
     */
    public boolean addReminder(String codeList, String codeTask, int date, int currentIndex) throws IOException{
        int i = 0;
        boolean cek = false;
        boolean cek2 = false;
        for(List temp : listUser.get(currentIndex).getListList()){
            if(codeList.equals(temp.getCodeList())){
                cek = true;
                break;
            }
            i++;
        }
        if(cek){
            int j = 0;
            for(Task temp : listUser.get(currentIndex).getListList().get(i).getListTask()){
                if(codeTask.equals(temp.getCodeTask())){
                    cek2 = true;
                    break;
                }
                j++;
            }
            if(cek2){
                Date dateReminder = listUser.get(currentIndex).getListList().get(i).getListTask().get(j).getDueDate();
                if(date==0){
                    dateReminder.setHours(-12);
                }else{
                    dateReminder.setHours(-24);
                }
                listUser.get(currentIndex).getListList().get(i).getListTask().get(j).addReminder(codeTask, dateReminder);
                saveDataUser();
            }
        }
        return cek2;
    }

    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    public void menuAwal() throws IOException, ClassNotFoundException, ParseException{
        int pil = 1;
        while(pil!=0){
            System.out.println("\nMENU LOGIN");
      
            System.out.println("\n1. Login");
            System.out.println("2. Daftar");
            System.out.print("Masukkan pilihan: ");
            pil = Integer.parseInt(baca.readLine());
            if(pil!=1 && pil!=2){
                System.out.println("Error!");
            }else{
                System.out.print("\nUsername: ");
                String user = baca.readLine();
                System.out.print("Password: ");
                String pass = baca.readLine();
                if(pil==2){
                    signUp(user, pass);
                }else{
                    if(signIn(user,pass)){
                        menuMain();
                    }else System.out.println("Login gagal");
                }
            }
        }
    }
    
    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws ParseException
     */
    public void menuMain() throws IOException, ClassNotFoundException, ParseException{
        int pil = 0;
        while(pil != 7){
            System.out.println("\nMAIN MENU");
            System.out.println("\n1. Input List");
            System.out.println("2. Edit List");
            System.out.println("3. Delete List");
            System.out.println("4. View List");
            System.out.println("5. Menu Task");
            System.out.println("6. Settings");
            System.out.println("7. Log out");
            System.out.print("Masukkan pilihan: ");
            pil = Integer.parseInt(baca.readLine());
            if(pil == 1){
                String codeList = userCek + "L" + String.valueOf(listUser.get(currentIndex()).getMaxIndex()+1);
                System.out.print("\n"+currentIndex()+". Masukkan nama list ke- "+(listUser.get(currentIndex()).getMaxIndex()+1)+": ");
                String namaList = baca.readLine();
                listUser.get(currentIndex()).addList(codeList, namaList);
            }else if(pil == 2){
                System.out.println(listUser.get(currentIndex()).getListList());
                System.out.print("\nPilih kode list: ");
                String codeList = baca.readLine();
                int i = 0;
                boolean cek = false;
                for(List temp : listUser.get(currentIndex()).getListList()){
                    if(codeList.equals(temp.getCodeList())){
                        cek = true;
                        break;
                    }
                    i++;
                }
                if(cek){
                    System.out.print("Masukkan nama list: ");
                    String nameList = baca.readLine();
                    listUser.get(currentIndex()).getListList().get(i).setNameList(nameList);
                }else System.out.println("Kode tidak ditemukan!");
            }else if(pil == 3){
                System.out.println(listUser.get(currentIndex()).getListList());
                System.out.print("\nPilih kode list: ");
                String codeList = baca.readLine();
                int i = 0;
                boolean cek = false;
                for(List temp : listUser.get(currentIndex()).getListList()){
                    if(codeList.equals(temp.getCodeList())){
                        cek = true;
                        System.out.println(i);
                        break;
                    }
                    i++;
                }
                if(cek) listUser.get(currentIndex()).getListList().remove(i);
                else System.out.println("Kode tidak ditemukan!");
            }else if(pil == 4){
                System.out.println(listUser.get(currentIndex()).getListList());
            }else if(pil == 5){
                menuTask();
            }else if(pil == 6){
                System.out.println("\nSettings");
                System.out.println("\n1. Change password");
                System.out.println("2. Deactivate account");
            }
        }
    }

    /**
     *
     * @throws IOException
     * @throws ParseException
     */
    public void menuTask() throws IOException, ParseException{
        int pil = 0;
        while(pil != 6){
            System.out.println("\nMENU TASK");
            System.out.println("\n1. Input Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. View Task");
            System.out.println("5. Share Task");
            System.out.println("6. Back to menu");
            System.out.print("Masukkan pilihan: ");
            pil = Integer.parseInt(baca.readLine());
            if(pil == 1){
                System.out.println(listUser.get(currentIndex()).getListList());
                System.out.print("\nPilih kode list: ");
                String codeList = baca.readLine();
                int i = 0;
                boolean cek = false;
                for(List temp : listUser.get(currentIndex()).getListList()){
                    if(codeList.equals(temp.getCodeList())){
                        cek = true;
                        break;
                    }
                    i++;
                }
                if(cek){
                    String codeTask = listUser.get(currentIndex()).getListList().get(i).getCodeList() + "T" + String.valueOf(listUser.get(currentIndex()).getListList().get(i).getMaxIndex()+1);
                    System.out.print("Masukkan nama task: ");
                    String nameTask = baca.readLine();
                    System.out.print("Masukkan tanggal task [MMMM d, yyyy]: ");
                    String string = baca.readLine();
                    DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                    Date date = format.parse(string);
                    System.out.print("Masukkan priority task: ");
                    int priorTask = Integer.parseInt(baca.readLine());
                    listUser.get(currentIndex()).getListList().get(i).addTask(codeTask, nameTask, date, priorTask);
                }else System.out.println("Kode tidak ditemukan!");
            }else if(pil == 2){
                System.out.println(listUser.get(currentIndex()).getListList());
                System.out.print("\nPilih kode list: ");
                String codeList = baca.readLine();
                int i = 0;
                boolean cek = false;
                for(List temp : listUser.get(currentIndex()).getListList()){
                    if(codeList.equals(temp.getCodeList())){
                        cek = true;
                        break;
                    }
                    i++;
                }
                if(cek){
                    System.out.println(listUser.get(currentIndex()).getListList().get(i).getListTask());
                    System.out.print("\nPilih kode task: ");
                    String codeTask = baca.readLine();
                    int j = 0;
                    boolean cek2 = false;
                    for(Task temp : listUser.get(currentIndex()).getListList().get(i).getListTask()){
                        if(codeTask.equals(temp.getCodeTask())){
                            cek2 = true;
                            break;
                        }
                        j++;
                    }
                    if(cek2){
                        System.out.print("Masukkan nama task: ");
                        String nameTask = baca.readLine();
                        System.out.print("Masukkan tanggal task [MMMM d, yyyy]: ");
                        String string = baca.readLine();
                        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                        Date date = format.parse(string);
                        System.out.print("Masukkan priority task: ");
                        int priorTask = Integer.parseInt(baca.readLine());
                        listUser.get(currentIndex()).getListList().get(i).getListTask().get(j).setNameTask(nameTask);
                        listUser.get(currentIndex()).getListList().get(i).getListTask().get(j).setDueDate(date);
                        listUser.get(currentIndex()).getListList().get(i).getListTask().get(j).setPrior(priorTask);
                    }else System.out.println("Kode tidak ditemukan!");
                }else System.out.println("Kode tidak ditemukan!");
            }else if(pil == 4){
                System.out.println(listUser.get(currentIndex()).getListList().toString());
                System.out.print("\nPilih kode list: ");
                String codeList = baca.readLine();
                int i = 0;
                boolean cek = false;
                for(List temp : listUser.get(currentIndex()).getListList()){
                    if(codeList.equals(temp.getCodeList())){
                        cek = true;
                        break;
                    }
                    i++;
                }
                if(cek) System.out.println(listUser.get(currentIndex()).getListList().get(i).getListTask());
                else System.out.println("Kode tidak ditemukan!");
            }
        }
    }
}
