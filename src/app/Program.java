package app;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = sc.nextInt();
        System.out.println();

        for(int i=0; i<n; i++) {
            System.out.printf("Digite os dados do contribuinte:%d\n ", i + 1);
            System.out.print("Renda anual com salário: ");
            double salary = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double services = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capital = sc.nextDouble();
            System.out.print("Gastos médicos: ");
            double gMedicos = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double gEducacao = sc.nextDouble();
            System.out.println();

            TaxPayer payer = new TaxPayer(salary, services, capital, gMedicos ,gEducacao );

            list.add(payer);
        }

        int i = 1;
        for (TaxPayer payer  : list) {
            System.out.printf("\nResumo do %dº. contribuinte:\n", i++);
            System.out.println(payer.toString());
        }


        sc.close();

    }
}
