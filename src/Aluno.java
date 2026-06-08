// Aluno representa um estudante cadastrado na turma
// Usa composição: em vez de repetir nome/idade aqui, carrega um objeto Pessoa
public class Aluno {

    // Composição: Aluno "tem uma" Pessoa com os dados pessoais
    private Pessoa pessoa;
    private String curso;
    private String matricula;
    private int semestre;
    private int ano;
    private boolean bolsistaIC;

    // Construtor: precisamos de todos os dados para cadastrar um aluno
    public Aluno(Pessoa pessoa, String curso, String matricula, int semestre, int ano, boolean bolsistaIC) {
        this.pessoa = pessoa;
        this.curso = curso;
        this.matricula = matricula;
        this.semestre = semestre;
        this.ano = ano;
        this.bolsistaIC = bolsistaIC;
    }

    // Getters: leitura dos dados do aluno
    public Pessoa getPessoa() {
        return pessoa;
    }

    public String getCurso() {
        return curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getSemestre() {
        return semestre;
    }

    public int getAno() {
        return ano;
    }

    // Para boolean, convenção Java é usar "is" em vez de "get"
    public boolean isBolsistaIC() {
        return bolsistaIC;
    }

    // Setters apenas onde faz sentido alterar depois do cadastro
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public void setBolsistaIC(boolean bolsistaIC) {
        this.bolsistaIC = bolsistaIC;
    }

    // Reutiliza o toString() de Pessoa para não repetir código
    public String toString() {
        return pessoa.toString() + " | Curso: " + curso + " | Matrícula: " + matricula +
               " | Semestre: " + semestre + " | Ano: " + ano +
               " | Bolsista IC: " + (bolsistaIC ? "Sim" : "Não");
    }
}
