import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sarasb
 */
public class Utility {
    
    public static ArrayList<Accounts> readFile(String fileName){
     
        ArrayList<Accounts> accounts = new ArrayList<>();
        try {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null){
            String[] currentAccount = line.split("<>");
            String accNumber = currentAccount[0];
            String accHolder = currentAccount[1];
            double balance = Double.parseDouble(currentAccount[2]);
            Accounts acc = new Accounts(accNumber, accHolder, balance);
            accounts.add(acc);
        }
        br.close();
    }
     catch(Exception e){
         System.out.println(e);
     }   
        return accounts;
    
                }
    
    public static void writeFile(ArrayList<Accounts> accounts,String fileName) {
        
            try {
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw);
                for (Accounts a : accounts) {
                bw.write(a.toString() + "<>" + a.getAccountHolder() + "<>" + String.valueOf(a.getBalance()) +"\n") ;
               
                }
                bw.close();
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
        
    }

 
