package C07_Generics;

/* Ao definir "N" como um tipo genérico que estende "Number", 
 * estamos especificando que "N" deve ser uma subclasse de "Number".
 * Isso significa que "N" pode ser qualquer tipo numérico como Integer, Double, etc.
 * Dessa forma, garantimos que somente tipos numéricos (ou subclasses de "Number") 
 * possam ser utilizados com a classe "CaixaNum".
 */
public class A04_CaixaNum<N extends Number> extends A02_Caixa<N> {

}
