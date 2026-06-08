// AcompanhamentoIA armazena as métricas de uso de IA de um aluno nas atividades
// É a classe central do sistema: com esses dados calculamos o risco pedagógico
public class AcompanhamentoIA {

    // Composição: vinculado a um Aluno já cadastrado no sistema
    private Aluno aluno;

    // Métricas coletadas ao longo das atividades
    private int atividadesEntregues;
    private int atividadesComUsoIA;       // quantas vezes declarou uso de IA
    private int atividadesExplicadas;     // conseguiu explicar o código corretamente
    private int codigosModificados;       // conseguiu modificar sem ajuda
    private int entregasComConteudoNaoVisto; // usou estruturas ainda não estudadas

    // Resultado do cálculo: "Baixo", "Moderado" ou "Alto"
    private String nivelRisco;

    // Construtor: recebe o aluno e as métricas registradas pelo professor
    public AcompanhamentoIA(Aluno aluno, int atividadesEntregues, int atividadesComUsoIA,
                            int atividadesExplicadas, int codigosModificados,
                            int entregasComConteudoNaoVisto) {
        this.aluno = aluno;
        this.atividadesEntregues = atividadesEntregues;
        this.atividadesComUsoIA = atividadesComUsoIA;
        this.atividadesExplicadas = atividadesExplicadas;
        this.codigosModificados = codigosModificados;
        this.entregasComConteudoNaoVisto = entregasComConteudoNaoVisto;
        this.nivelRisco = calcularRisco();
    }

    // Regra de risco pedagógico:
    // Baixo:    declarou IA, explicou >= 70% e modificou >= 70% das entregas
    // Alto:     não declarou IA OU explicou < 40% OU modificou < 40% das entregas
    // Moderado: qualquer caso entre baixo e alto
    private String calcularRisco() {
        if (atividadesEntregues == 0) return "Sem dados";

        double percIA = (double) atividadesComUsoIA / atividadesEntregues;
        double percExplicou = (double) atividadesExplicadas / atividadesEntregues;
        double percModificou = (double) codigosModificados / atividadesEntregues;
        double percNaoVisto = (double) entregasComConteudoNaoVisto / atividadesEntregues;

        if (percIA >= 0.7 && percExplicou >= 0.7 && percModificou >= 0.7 && percNaoVisto <= 0.2) {
            return "Baixo";
        } else if (percIA < 0.3 || percExplicou < 0.4 || percModificou < 0.4 || percNaoVisto > 0.5) {
            return "Alto";
        } else {
            return "Moderado";
        }
    }

    // Getters
    public Aluno getAluno() {
        return aluno;
    }

    public int getAtividadesEntregues() {
        return atividadesEntregues;
    }

    public int getAtividadesComUsoIA() {
        return atividadesComUsoIA;
    }

    public int getAtividadesExplicadas() {
        return atividadesExplicadas;
    }

    public int getCodigosModificados() {
        return codigosModificados;
    }

    public int getEntregasComConteudoNaoVisto() {
        return entregasComConteudoNaoVisto;
    }

    public String getNivelRisco() {
        return nivelRisco;
    }

    public String toString() {
        return aluno.getPessoa().getNome() + " | Entregas: " + atividadesEntregues +
               " | Uso IA: " + atividadesComUsoIA + " | Explicou: " + atividadesExplicadas +
               " | Modificou: " + codigosModificados + " | Conteúdo não visto: " +
               entregasComConteudoNaoVisto + " | Risco: " + nivelRisco;
    }
}
