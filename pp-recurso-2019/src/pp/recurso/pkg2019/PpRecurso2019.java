/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.recurso.pkg2019;

import interfaces.controller.ITest;
import interfaces.exceptions.TestException;
import views.TestWindow;

/**
 *
 * @author joaosoares
 */
public class PpRecurso2019 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws TestException {
       
        System.out.println("Inicio Teste");
        
        //Carrega o teste
        ITest demoTest = new Test();
        
        //demoTest.loadFromJSONFile("C:\\Users\\Tiago Pinto\\Documents\\NetBeansProjects\\Trabalho_PP_RECURSO_2019\\pp-recurso\\pp-recurso-2019src\\data\\teste_A.json");
        demoTest.loadFromJSONFile("/Users/joaosoares/NetBeansProjects/pp-recurso/pp-recurso-2019/src/data/teste_A.json");
        
        //Executar o teste na camada gráfica
        TestWindow t = new TestWindow();
        t.startTest(demoTest);

        //Obter resultados do teste
        System.out.println("Teste efetuado");
        System.out.println(demoTest.toString());
    }
    
}
