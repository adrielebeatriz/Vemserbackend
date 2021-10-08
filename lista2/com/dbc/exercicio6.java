package com.dbc;
import java.util.Scanner;
public class exercicio6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] v = {2, 10, 17, 35, 16, 40, 60, 50, 20, 30};
        String valor = null;

        System.out.printf("Informe um número " + "\n");
        int num = input.nextInt();
        input.next();

        for(int i = 0; i < v.length; i++){
            if(v[i] != num) {
                valor = "o valor é inexistente";
            }
            else{
                System.exit(0);
            }
        }

        System.out.print(valor);
    }
}
