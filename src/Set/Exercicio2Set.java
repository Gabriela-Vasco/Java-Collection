package Set;
import java.util.*;

public class Exercicio2Set {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto com 3 linguagens: ");
        Set<LinguagemFavorita> linguagemFavoritas = new HashSet<>() {{
            add(new LinguagemFavorita("Java", "Intellij", 1995));
            add(new LinguagemFavorita("JavaScript", "VSCode", 1999));
            add(new LinguagemFavorita("C#", "Visual Studio", 1993));
        }};
        for (LinguagemFavorita linguagemFavorita : linguagemFavoritas) System.out.println(linguagemFavorita.getNome() + " " + linguagemFavorita.getIde() + " " + linguagemFavorita.getAnoDeCriacao());

        System.out.println(" ");

        System.out.println("Ordem de inserção: ");
        Set<LinguagemFavorita> linguagemFavoritas1 = new LinkedHashSet<>(){{
            add(new LinguagemFavorita("Java", "Intellij", 1995));
            add(new LinguagemFavorita("JavaScript", "VSCode", 1999));
            add(new LinguagemFavorita("C#", "Visual Studio", 1993));
        }};
        for (LinguagemFavorita linguagemFavorita : linguagemFavoritas1) System.out.println(linguagemFavorita.getNome() + " " + linguagemFavorita.getIde() + " " + linguagemFavorita.getAnoDeCriacao());

        System.out.println(" ");

        System.out.println("Ordem natural (nome)");
        Set<LinguagemFavorita> linguagemFavoritas5 = new TreeSet<>(linguagemFavoritas1);
        for (LinguagemFavorita linguagemFavorita : linguagemFavoritas5) System.out.println(linguagemFavorita.getNome() + " " + linguagemFavorita.getIde() + " " + linguagemFavorita.getAnoDeCriacao());

        System.out.println(" ");

        System.out.println("Ordem IDE: ");
        Set<LinguagemFavorita> linguagemFavoritas2 = new TreeSet<> (new ComparatorIDE());
        linguagemFavoritas2.addAll(linguagemFavoritas);
        for (LinguagemFavorita linguagemFavorita : linguagemFavoritas2) System.out.println(linguagemFavorita.getNome() + " " + linguagemFavorita.getIde() + " " + linguagemFavorita.getAnoDeCriacao());

        System.out.println(" ");

        System.out.println("Ordem Ano de criação e nome: ");
        Set<LinguagemFavorita> linguagemFavoritas3 = new TreeSet<>(new ComparatorAnoCriacaoNome());
        linguagemFavoritas3.addAll(linguagemFavoritas);
        for (LinguagemFavorita linguagemFavorita : linguagemFavoritas3) System.out.println(linguagemFavorita.getNome() + " " + linguagemFavorita.getIde() + " " + linguagemFavorita.getAnoDeCriacao());

        System.out.println(" ");

        System.out.println("Ordem Nome, Ano de Criação e IDE: ");
        Set<LinguagemFavorita> linguagemFavoritas4 = new TreeSet<>(new ComparatorNomeAnoCriacaoIde());
        linguagemFavoritas4.addAll(linguagemFavoritas);
        for (LinguagemFavorita linguagemFavorita : linguagemFavoritas4) System.out.println(linguagemFavorita.getNome() + " " + linguagemFavorita.getIde() + " " + linguagemFavorita.getAnoDeCriacao());


    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita>{
    String nome, ide;
    int anoDeCriacao;

    public LinguagemFavorita(String nome, String ide, int anoDeCriacao) {
        this.nome = nome;
        this.ide = ide;
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getNome() {
        return nome;
    }

    public String getIde() {
        return ide;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    @Override
    public int compareTo(LinguagemFavorita linguagemFavorita) {
        return this.nome.compareTo(linguagemFavorita.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita>{

    @Override
    public int compare (LinguagemFavorita l1, LinguagemFavorita l2) {
            return l1.getIde().compareToIgnoreCase(l2.getIde());
        }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());
        if (anoCriacao != 0) return anoCriacao;

        return l1.getNome().compareTo(l2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIde implements Comparator<LinguagemFavorita> {

    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int nome = l1.getNome().compareTo(l2.getNome());
        if (nome != 0) return nome;

        int anoCriacao = Integer.compare(l1.getAnoDeCriacao(), l2.getAnoDeCriacao());

        return l1.getIde().compareTo(l2.getIde());
    }
}
