package List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Exercício2List {
    public static void main(String[] args) {
        List<String> perguntasCrime = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Telefonou para a vítima? S/N ");
        perguntasCrime.add(scanner.next());

        System.out.println("Esteve no local do crime? S/N ");
        perguntasCrime.add(scanner.next());

        System.out.println("Mora perto da vítima? S/N ");
        perguntasCrime.add(scanner.next());

        System.out.println("Devia para a vítima? S/N ");
        perguntasCrime.add(scanner.next());

        System.out.println("Já trabalhou com a vítima? S/N ");
        perguntasCrime.add(scanner.next());

        int count = 0;
        Iterator<String> contador = perguntasCrime.iterator();
        while (contador.hasNext()) {
            String resposta = contador.next();
            if (resposta.contains("S")){
                count++;
            }
        }

        switch (count) {
            case 2:
                System.out.println("SUSPEITA"); break;
            case 3:
            case 4:
                System.out.println("CÚMPLICE"); break;
            case 5:
                System.out.println("ASSASSINO"); break;
            default:
                System.out.println("INOCENTE"); break;
        }


    }
}
