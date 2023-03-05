package List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ExerciciosList {
    public static void main(String[] args) {
        List <Double> temperaturas = new ArrayList<Double>();
        Scanner scanner = new Scanner(System.in);


        for (int i = 1; i <= 6; i++) {
            System.out.println("Digite a " + i + "ª temperatura: ");
            temperaturas.add(scanner.nextDouble());
        }

        Iterator<Double> iterator = temperaturas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        double media = (soma/temperaturas.size());
        System.out.println("Exiba a média das temperaturas nos últimos 6 meses: " + media);

        System.out.println("As temperaturas acima de " + media + " foram: ");
        Iterator<Double> iterator1 = temperaturas.iterator();
        int count = 0;
        while(iterator1.hasNext()) {
            double next = iterator1.next();
            if (next > media) {
                switch (count) {
                    case (0):
                        System.out.println("1 - janeiro: " + next);
                        break;
                    case (1):
                        System.out.println("2 - fevereiro: " + next);
                        break;
                    case (2):
                        System.out.println("3 - março: " + next);
                        break;
                    case (3):
                        System.out.println("4 - abril: " + next);
                        break;
                    case (4):
                        System.out.println("5 - maio: " + next);
                        break;
                    case (5):
                        System.out.println("6 - junho: " + next);
                        break;
                    default:
                        System.out.println("Não houve temperatura acima da média");
                }
            }
            count++;
        }
    }
}
