import java.util.Scanner;

public class Main {

    // Tamanho máximo dos vetores — definido pelo enunciado
    static final int MAX = 10;

    // Vetores de objetos: sem ArrayList, sem listas dinâmicas
    static Aluno[] alunos = new Aluno[MAX];
    static BolsistaIC[] bolsistas = new BolsistaIC[MAX];
    static AcompanhamentoIA[] acompanhamentos = new AcompanhamentoIA[MAX];

    // Contadores: controlam quantos itens foram cadastrados em cada vetor
    static int totalAlunos = 0;
    static int totalBolsistas = 0;
    static int totalAcompanhamentos = 0;

    // Lista de chamada: disciplina e professor informados pelo usuário
    static String[] listaChamada = new String[MAX]; // nomes em ordem alfabética
    static String disciplinaChamada = "";
    static String professorChamada = "";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        // Loop principal: o programa só encerra quando o usuário escolher 0
        while (opcao != 0) {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:  cadastrarAluno();            break;
                case 2:  cadastrarBolsistaIC();       break;
                case 3:  registrarAcompanhamento();   break;
                case 4:  listarAlunos();              break;
                case 5:  listarBolsistas();           break;
                case 6:  nomeMaisLongo();             break;
                case 7:  contarVogais();              break;
                case 8:  percentualPorCurso();        break;
                case 9:  mediaIdade();                break;
                case 10: criarListaChamada();         break;
                case 11: exibirListaChamada();        break;
                case 12: calcularRiscoPedagogico();   break;
                case 13: relatorioGeralRisco();       break;
                case 14: exibirAlunosRiscoAlto();     break;
                case 15: inovacao();                  break;
                case 0:  System.out.println("Encerrando o sistema. Até mais!"); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
        }

        sc.close();
    }

    // Exibe o menu de opções
    static void exibirMenu() {
        System.out.println("\n========== SISTEMA DE MONITORAMENTO PEDAGÓGICO ==========");
        System.out.println(" 1. Cadastrar aluno");
        System.out.println(" 2. Cadastrar bolsista de IC");
        System.out.println(" 3. Registrar acompanhamento do uso de IA");
        System.out.println(" 4. Listar todos os alunos");
        System.out.println(" 5. Listar bolsistas de IC");
        System.out.println(" 6. Mostrar nome mais longo");
        System.out.println(" 7. Contar vogais nos nomes cadastrados");
        System.out.println(" 8. Percentual de alunos por curso");
        System.out.println(" 9. Média de idade dos alunos");
        System.out.println("10. Criar ou atualizar lista de chamada");
        System.out.println("11. Exibir lista de chamada");
        System.out.println("12. Calcular risco pedagógico");
        System.out.println("13. Exibir relatório geral de risco por aluno");
        System.out.println("14. Exibir alunos em risco alto");
        System.out.println("15. Inovação do grupo");
        System.out.println(" 0. Sair");
        System.out.println("==========================================================");
        System.out.print("Escolha uma opção: ");
    }

    // Lê a opção do menu com tratamento para entrada inválida
    static int lerOpcao() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1; // força o "default" do switch
        }
    }

    // ==================== OPERAÇÕES (a implementar) ====================

    static void cadastrarAluno() {
        System.out.println("[em breve] Cadastrar aluno");
    }

    static void cadastrarBolsistaIC() {
        System.out.println("[em breve] Cadastrar bolsista de IC");
    }

    static void registrarAcompanhamento() {
        System.out.println("[em breve] Registrar acompanhamento");
    }

    static void listarAlunos() {
        System.out.println("[em breve] Listar alunos");
    }

    static void listarBolsistas() {
        System.out.println("[em breve] Listar bolsistas");
    }

    static void nomeMaisLongo() {
        System.out.println("[em breve] Nome mais longo");
    }

    static void contarVogais() {
        System.out.println("[em breve] Contar vogais");
    }

    static void percentualPorCurso() {
        System.out.println("[em breve] Percentual por curso");
    }

    static void mediaIdade() {
        System.out.println("[em breve] Média de idade");
    }

    static void criarListaChamada() {
        System.out.println("[em breve] Criar lista de chamada");
    }

    static void exibirListaChamada() {
        System.out.println("[em breve] Exibir lista de chamada");
    }

    static void calcularRiscoPedagogico() {
        System.out.println("[em breve] Calcular risco pedagógico");
    }

    static void relatorioGeralRisco() {
        System.out.println("[em breve] Relatório geral de risco");
    }

    static void exibirAlunosRiscoAlto() {
        System.out.println("[em breve] Alunos em risco alto");
    }

    static void inovacao() {
        System.out.println("[em breve] Inovação do grupo");
    }
}
