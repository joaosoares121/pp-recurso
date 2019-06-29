/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.recurso.pkg2019;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author Tiago Pinto
 */
public class TestJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pessoa pessoas[] = new Pessoa[2];
        //String path = "/Users/joaosoares/NetBeansProjects/pp-recurso/pp-recurso-2019/src/pp/recurso/pkg2019/exemplo.json";
        String path = "C:\\Users\\Tiago Pinto\\Documents\\NetBeansProjects\\Trabalho_PP_RECURSO_2019\\pp-recurso\\pp-recurso-2019\\src\\pp\\recurso\\pkg2019\\exemplo.json";
        BufferedReader reader = null;
        
        try {
            reader = new BufferedReader(new FileReader(path));
            
            JsonStreamParser p = new JsonStreamParser(reader);
            
            JsonArray arr = (JsonArray) p.next();
            int arr_size = arr.size();
            
            for (int i = 0; i < arr_size; i++) {
                JsonElement arrayElement = arr.get(i);
                JsonObject obj = arrayElement.getAsJsonObject();
                
                if(obj.has("nome") && obj.has("idade")){
                    String temp_nome = obj.get("nome").getAsString();
                    int temp_idade = obj.get("idade").getAsInt();
                    
                    pessoas[i] = new Pessoa(temp_nome, temp_idade);
                    System.out.println("" + temp_nome);
                    System.out.println("" + temp_idade);
                    System.out.println("" + pessoas[i].toString());
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }finally{
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
}
