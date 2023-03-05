package Map;
import java.util.*;

public class Exercicio01Map {
    public static void main(String[] args) {
        Map<String, Integer> estados = new HashMap<>() {{
           put("PE", 9616621);
           put("AL", 3351543);
           put("CE", 9187103);
           put("RN", 3534265);
        }};
        System.out.println(estados.toString());

        estados.put("RN", 3534165);
        System.out.println(estados.toString());

        System.out.println("Confira se o estado PB está no dicionário: " + estados.containsKey("PB"));

        estados.put("PB", 4039277);
        System.out.println(estados.toString());

        System.out.println("Exiba a população de PE: " + estados.get("PE"));

        System.out.println("Exiba todos os estados e suas populações na ordem em que foram informados: ");
        Map<String, Integer> estados1 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(estados1.toString());

        System.out.println("Exiba todos os estados e suas populações em ordem alfabética: ");
        Map<String, Integer> estados2 = new TreeMap<>(estados);

        System.out.println(estados2.toString());

        Integer quantidadeMenorPopulacao = Collections.min(estados.values());
        Set<Map.Entry<String, Integer>> entries = estados.entrySet();
        String estadoMenorPopulacao = " ";

        for (Map.Entry<String, Integer> entry: entries) {
            if (entry.getValue().equals(quantidadeMenorPopulacao)) estadoMenorPopulacao = entry.getKey();
        }

        System.out.println("Exiba o estado com a menor população: " + estadoMenorPopulacao + " " + quantidadeMenorPopulacao);

        Integer quantidadeMaiorPopulacao = Collections.max(estados.values());
        String estadoMaiorPopulacao = " ";

        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue().equals(quantidadeMaiorPopulacao)) estadoMaiorPopulacao = entry.getKey();
        }

        System.out.println("Exiba o estado com a maior população: " + estadoMaiorPopulacao + " " + quantidadeMaiorPopulacao);

        Iterator<Integer> iterator = estados.values().iterator();
        Integer soma = 0;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }

        System.out.println("Exiba a soma das populações: " + soma);

        System.out.println("Exiba a média da soma das populações: " + Double.valueOf(soma/estados.size()));

        Iterator<Integer> iterator1 = estados.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next() <= 4000000) iterator1.remove();
        }

        System.out.println("Remova os estados com população menor que 4.000.000: ");
        System.out.println(estados.toString());

        estados.clear();

        System.out.println("Confira se o dicionário está vazio: " + estados.isEmpty());
    }
}

