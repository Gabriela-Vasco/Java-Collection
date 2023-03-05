package Map;

import java.util.Objects;
import java.util.*;

public class ExemploOrdenaçãoMap {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");

        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen ", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles ", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah ", new Livro("21 lições para o século 21", 432));
        }};
        for ( Map.Entry<String, Livro> livro : meusLivros.entrySet())
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());

        System.out.println("--\tOrdem de inserção\t--");

        Map<String, Livro> meusLivros2 = new LinkedHashMap<>() {{
            put("Hawking, Stephen ", new Livro("Uma Breve História do Tempo", 256));
            put("Duhigg, Charles ", new Livro("O Poder do Hábito", 408));
            put("Harari, Yuval Noah ", new Livro("21 lições para o século 21", 432));
        }};

        for (Map.Entry<String, Livro> livro2 : meusLivros2.entrySet())
            System.out.println(livro2.getKey() + " - " + livro2.getValue().getNome());

        System.out.println("--\tOrdem alfabética dos autores\t--");
        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);
        for (Map.Entry<String, Livro> livro3 : meusLivros3.entrySet())
            System.out.println(livro3.getKey() + " - " + livro3.getValue().getNome());

        System.out.println("--\tOrdem alfabética nomes dos livros\t--");

        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro4 : meusLivros4)
            System.out.println(livro4.getKey() + " - " + livro4.getValue().getNome());

        System.out.println("--\tOrdem do número de páginas\t--");
        Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorPaginas());
        meusLivros5.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro5 : meusLivros5) System.out.println(livro5.getKey() + " - " + livro5.getValue().getPaginas());


    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}