// Pessoa representa os dados pessoais básicos de qualquer estudante
public class Pessoa {

    // Atributos privados: só acessados pelos métodos abaixo, não diretamente
    private String nome;
    private int idade;
    private String localNascimento;

    // Construtor: chamado quando criamos um objeto Pessoa com os 3 dados
    public Pessoa(String nome, int idade, String localNascimento) {
        this.nome = nome;
        this.idade = idade;
        this.localNascimento = localNascimento;
    }

    // Getters: única forma de ler os dados de fora da classe
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getLocalNascimento() {
        return localNascimento;
    }

    // toString: quando imprimimos um objeto Pessoa, mostra isso automaticamente
    public String toString() {
        return "Nome: " + nome + " | Idade: " + idade + " | Nascimento: " + localNascimento;
    }
}
