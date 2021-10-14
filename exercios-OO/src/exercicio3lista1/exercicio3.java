package exercicio3lista1;

import java.util.Scanner;

    public class exercicio3 {
        private float valorpago;
        private float consumido;

        Scanner input = new Scanner(System.in);
        public void calcularTroco() {
            System.out.println("Digite o valor pago");
            double valorpago = input.nextDouble();
            System.out.println("Digite o valor consumido");
            double consumido = input.nextDouble();
            double troco = valorpago - consumido;
            if (valorpago < consumido) {
                System.out.println(" O valor pago deve ser maior ou igual ao valor consumido");
            } else if (valorpago >= consumido) {
                System.out.println("seu troco é:" + troco + "\n");
            }
        }
    }
