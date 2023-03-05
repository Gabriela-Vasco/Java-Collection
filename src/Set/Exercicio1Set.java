package Set;
import java.util.*;


public class Exercicio1Set {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto contendo as cores do arco iris: ");
        Set<String> coresArcoIris = new HashSet<>();
        coresArcoIris.add("Vermelha");
        coresArcoIris.add("Violeta");
        coresArcoIris.add("Azul");
        coresArcoIris.add("Verde");
        coresArcoIris.add("Amarelo");
        coresArcoIris.add("Anil");
        coresArcoIris.add("Laranja");
        System.out.println(coresArcoIris);

        System.out.println("Exiba todas as cores, uma abaixo da outra");
        for (String cor : coresArcoIris) System.out.println(cor);

        System.out.println("Exiba a quantidade de cores: ");
        System.out.println(coresArcoIris.size());

        System.out.println("Exibe as cores em ordem alfabetica: ");
        Set<String> coresArcoIris1 = new TreeSet<>(coresArcoIris);
        System.out.println(coresArcoIris1);

        System.out.println("Exiba as cores na ordem inversa: ");
        Set<String> coresArcoIris2 = new LinkedHashSet<>(
              Arrays.asList("Vermelha", "Violeta", "Azul", "Verde", "Amarelo", "Anil", "Laranja"));

        List<String> coresArcoIrisList = new ArrayList<>(coresArcoIris2);
        Collections.reverse(coresArcoIrisList);
        System.out.println(coresArcoIrisList);

        System.out.println("Exiba as cores que começam com a letra v: ");
        for (String cor : coresArcoIris) {
            if (cor.startsWith("V")) System.out.println(cor);
        }

        System.out.println("Remova as cores que não começam com v: ");
        Iterator<String> iterator2 = coresArcoIris.iterator();
        while (iterator2.hasNext()) {
            if (!iterator2.next().startsWith("V")) iterator2.remove();
        }
        System.out.println(coresArcoIris);

        System.out.println("Limpe o conjunto");
        coresArcoIris.clear();
        System.out.println(coresArcoIris);

        System.out.println("Confira se o conjunto está vazio: ");
        System.out.println(coresArcoIris.isEmpty());

    }
}

