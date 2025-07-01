package C03_OO.Encapsulamento.CasaB;

import C03_OO.Encapsulamento.CasaA.A01_Ana;

public class A01_Pedro  extends A01_Ana{


        void TesteAcessos(){
        
        A01_Ana ana = new A01_Ana();
        System.out.println(ana.TodosSabem);
        //Como eu herdo atributos de "ana" eu posso acessa-los diretamente.
        System.out.println(formaDeFalar);
    }
}
