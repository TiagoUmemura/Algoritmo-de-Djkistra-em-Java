/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caminhominimo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Documentois
 */
public class Arquivo {
    public Arquivo(){
        
    }
    
    public List TxtToString() throws FileNotFoundException{
        List<String> arquivo = new ArrayList<String>();
        File arquivotxt = new File("base.txt");//arquivo txt para ler LDGraph20_20certoHDGraph100_25
        InputStream in = new FileInputStream(arquivotxt);
        Scanner scan = new Scanner(in);
        
        while(scan.hasNext()){
            arquivo.add(scan.nextLine());//linhas do arquivo serão salvas na lista de string
        }
        
        return arquivo;
    }
}
