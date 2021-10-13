package com.dbc;
import java.util.Scanner;
public class valorpago {
    double valorPago;
    double consumido;
    double troco;
        Scanner input = new Scanner(System.in);
        public void troco (){
            System.out.println("Digite o valor pago");
            valorPago = input.nextDouble();
            System.out.println("Digite o valor consumido");
            consumido = input.nextDouble();
            troco = valorPago - consumido;
            if (valorPago < consumido) {
                System.out.println(" O valor pago deve ser maior ou igual ao valor consumido");
            } else if (valorPago >= consumido) {
                System.out.println("seu troco é:" + troco + "\n");
            }
        }


}
