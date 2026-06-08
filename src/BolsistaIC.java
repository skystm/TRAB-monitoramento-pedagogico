// BolsistaIC representa um aluno que participa de um projeto de Iniciação Científica
// Também usa composição: carrega um objeto Aluno com todos os dados do estudante
public class BolsistaIC {

    // Composição: BolsistaIC "tem um" Aluno, que por sua vez "tem uma" Pessoa
    private Aluno aluno;
    private String projeto;
    private String orientador;

    // Construtor: além dos dados do aluno, precisamos do projeto e do orientador
    public BolsistaIC(Aluno aluno, String projeto, String orientador) {
        this.aluno = aluno;
        this.projeto = projeto;
        this.orientador = orientador;
    }

    // Getters
    public Aluno getAluno() {
        return aluno;
    }

    public String getProjeto() {
        return projeto;
    }

    public String getOrientador() {
        return orientador;
    }

    // toString: reutiliza o toString() de Aluno, que já reutiliza o de Pessoa
    // Cadeia: BolsistaIC -> Aluno -> Pessoa
    public String toString() {
        return aluno.toString() + " | Projeto: " + projeto + " | Orientador: " + orientador;
    }
}
