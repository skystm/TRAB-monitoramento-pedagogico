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
        // Verifica se ainda há espaço no vetor
        if (totalAlunos >= MAX) {
            System.out.println("Limite de alunos atingido.");
            return;
        }

        System.out.println("\n--- Cadastrar Aluno ---");

        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();

        System.out.print("Idade: ");
        int idade;
        try {
            idade = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Idade inválida.");
            return;
        }

        System.out.print("Local de nascimento: ");
        String localNascimento = sc.nextLine().trim();

        System.out.print("Curso: ");
        String curso = sc.nextLine().trim();

        System.out.print("Matrícula: ");
        String matricula = sc.nextLine().trim();

        // Validação: matrícula duplicada
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].getMatricula().equals(matricula)) {
                System.out.println("Matrícula já cadastrada.");
                return;
            }
        }

        System.out.print("Semestre: ");
        int semestre;
        try {
            semestre = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Semestre inválido.");
            return;
        }

        System.out.print("Ano: ");
        int ano;
        try {
            ano = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Ano inválido.");
            return;
        }

        System.out.print("É bolsista de IC? (s/n): ");
        boolean bolsistaIC = sc.nextLine().trim().equalsIgnoreCase("s");

        // Cria os objetos usando composição: Pessoa dentro de Aluno
        Pessoa pessoa = new Pessoa(nome, idade, localNascimento);
        Aluno aluno = new Aluno(pessoa, curso, matricula, semestre, ano, bolsistaIC);

        // Insere no vetor na próxima posição disponível
        alunos[totalAlunos] = aluno;
        totalAlunos++;

        System.out.println("Aluno cadastrado com sucesso!");
    }

    static void cadastrarBolsistaIC() {
        // Validação: precisa ter pelo menos um aluno cadastrado
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado. Cadastre um aluno primeiro.");
            return;
        }

        if (totalBolsistas >= MAX) {
            System.out.println("Limite de bolsistas atingido.");
            return;
        }

        System.out.println("\n--- Cadastrar Bolsista de IC ---");
        System.out.print("Matrícula do aluno: ");
        String matricula = sc.nextLine().trim();

        // Busca o aluno pela matrícula no vetor
        Aluno alunoEncontrado = null;
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].getMatricula().equals(matricula)) {
                alunoEncontrado = alunos[i];
                break;
            }
        }

        // Validação: não permite cadastrar bolsista para aluno inexistente
        if (alunoEncontrado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.print("Nome do projeto: ");
        String projeto = sc.nextLine().trim();

        System.out.print("Nome do orientador: ");
        String orientador = sc.nextLine().trim();

        // Cria o bolsista com composição: BolsistaIC "tem um" Aluno
        BolsistaIC bolsista = new BolsistaIC(alunoEncontrado, projeto, orientador);
        bolsistas[totalBolsistas] = bolsista;
        totalBolsistas++;

        // Atualiza o flag no objeto Aluno também
        alunoEncontrado.setBolsistaIC(true);

        System.out.println("Bolsista de IC cadastrado com sucesso!");
    }

    static void registrarAcompanhamento() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado. Cadastre um aluno primeiro.");
            return;
        }

        if (totalAcompanhamentos >= MAX) {
            System.out.println("Limite de acompanhamentos atingido.");
            return;
        }

        System.out.println("\n--- Registrar Acompanhamento de IA ---");
        System.out.print("Matrícula do aluno: ");
        String matricula = sc.nextLine().trim();

        // Busca o aluno pela matrícula
        Aluno alunoEncontrado = null;
        for (int i = 0; i < totalAlunos; i++) {
            if (alunos[i].getMatricula().equals(matricula)) {
                alunoEncontrado = alunos[i];
                break;
            }
        }

        if (alunoEncontrado == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("Aluno: " + alunoEncontrado.getPessoa().getNome());

        try {
            System.out.print("Quantidade de atividades entregues: ");
            int entregues = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Quantidade de atividades com uso declarado de IA: ");
            int comIA = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Quantidade de atividades que o aluno conseguiu explicar: ");
            int explicadas = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Quantidade de códigos que o aluno conseguiu modificar sem ajuda: ");
            int modificados = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Quantidade de entregas com conteúdo ainda não estudado: ");
            int naoVisto = Integer.parseInt(sc.nextLine().trim());

            // Cria o acompanhamento — o risco já é calculado automaticamente no construtor
            AcompanhamentoIA acomp = new AcompanhamentoIA(alunoEncontrado, entregues, comIA,
                                                          explicadas, modificados, naoVisto);
            acompanhamentos[totalAcompanhamentos] = acomp;
            totalAcompanhamentos++;

            System.out.println("Acompanhamento registrado! Risco calculado: " + acomp.getNivelRisco());

        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Acompanhamento não registrado.");
        }
    }

    static void listarAlunos() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\n--- Lista de Alunos ---");
        for (int i = 0; i < totalAlunos; i++) {
            System.out.println((i + 1) + ". " + alunos[i].toString());
        }
    }

    static void listarBolsistas() {
        if (totalBolsistas == 0) {
            System.out.println("Nenhum bolsista de IC cadastrado.");
            return;
        }

        System.out.println("\n--- Bolsistas de IC ---");
        for (int i = 0; i < totalBolsistas; i++) {
            System.out.println((i + 1) + ". " + bolsistas[i].toString());
        }
    }

    static void nomeMaisLongo() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        // Começa assumindo que o primeiro é o mais longo e compara com os demais
        String maisLongo = alunos[0].getPessoa().getNome();
        for (int i = 1; i < totalAlunos; i++) {
            String nome = alunos[i].getPessoa().getNome();
            if (nome.length() > maisLongo.length()) {
                maisLongo = nome;
            }
        }

        System.out.println("\nNome mais longo: " + maisLongo + " (" + maisLongo.length() + " caracteres)");
    }

    static void contarVogais() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        int totalVogais = 0;
        // Percorre cada nome e cada caractere verificando se é vogal
        for (int i = 0; i < totalAlunos; i++) {
            String nome = alunos[i].getPessoa().getNome().toLowerCase();
            for (int j = 0; j < nome.length(); j++) {
                char c = nome.charAt(j);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                    c == 'á' || c == 'é' || c == 'í' || c == 'ó' || c == 'ú' ||
                    c == 'â' || c == 'ê' || c == 'î' || c == 'ô' || c == 'û' ||
                    c == 'ã' || c == 'õ' || c == 'à') {
                    totalVogais++;
                }
            }
        }

        System.out.println("\nTotal de vogais em todos os nomes: " + totalVogais);
    }

    static void percentualPorCurso() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        // Coleta os cursos únicos e conta quantos alunos tem em cada um
        String[] cursos = new String[MAX];
        int[] contagens = new int[MAX];
        int totalCursos = 0;

        for (int i = 0; i < totalAlunos; i++) {
            String curso = alunos[i].getCurso();
            boolean encontrado = false;

            // Verifica se o curso já foi registrado
            for (int j = 0; j < totalCursos; j++) {
                if (cursos[j].equalsIgnoreCase(curso)) {
                    contagens[j]++;
                    encontrado = true;
                    break;
                }
            }

            // Se for um curso novo, adiciona na lista
            if (!encontrado) {
                cursos[totalCursos] = curso;
                contagens[totalCursos] = 1;
                totalCursos++;
            }
        }

        System.out.println("\n--- Percentual de Alunos por Curso ---");
        for (int i = 0; i < totalCursos; i++) {
            double percentual = (double) contagens[i] / totalAlunos * 100;
            System.out.printf("%-30s %d aluno(s) — %.1f%%%n", cursos[i], contagens[i], percentual);
        }
    }

    static void mediaIdade() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        int somaIdades = 0;
        for (int i = 0; i < totalAlunos; i++) {
            somaIdades += alunos[i].getPessoa().getIdade();
        }

        double media = (double) somaIdades / totalAlunos;
        System.out.printf("\nMédia de idade dos alunos: %.1f anos%n", media);
    }

    static void criarListaChamada() {
        if (totalAlunos == 0) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.println("\n--- Criar/Atualizar Lista de Chamada ---");
        System.out.print("Nome da disciplina: ");
        disciplinaChamada = sc.nextLine().trim();

        System.out.print("Nome do professor: ");
        professorChamada = sc.nextLine().trim();

        // Copia os nomes dos alunos para a lista de chamada
        for (int i = 0; i < totalAlunos; i++) {
            listaChamada[i] = alunos[i].getPessoa().getNome();
        }

        // Ordena os nomes em ordem alfabética usando bubble sort
        for (int i = 0; i < totalAlunos - 1; i++) {
            for (int j = 0; j < totalAlunos - i - 1; j++) {
                if (listaChamada[j].compareToIgnoreCase(listaChamada[j + 1]) > 0) {
                    String temp = listaChamada[j];
                    listaChamada[j] = listaChamada[j + 1];
                    listaChamada[j + 1] = temp;
                }
            }
        }

        System.out.println("Lista de chamada criada com sucesso!");
    }

    static void exibirListaChamada() {
        if (disciplinaChamada.isEmpty()) {
            System.out.println("Lista de chamada ainda não foi criada. Use a opção 10.");
            return;
        }

        System.out.println("\n========== LISTA DE CHAMADA ==========");
        System.out.println("Disciplina: " + disciplinaChamada);
        System.out.println("Professor:  " + professorChamada);
        System.out.println("--------------------------------------");
        System.out.printf("%-25s %-12s %-20s%n", "Nome", "Matrícula", "Curso");
        System.out.println("--------------------------------------");

        // Para exibir matrícula e curso, busca o aluno pelo nome ordenado
        for (int i = 0; i < totalAlunos; i++) {
            for (int j = 0; j < totalAlunos; j++) {
                if (alunos[j].getPessoa().getNome().equals(listaChamada[i])) {
                    System.out.printf("%-25s %-12s %-20s%n",
                        listaChamada[i],
                        alunos[j].getMatricula(),
                        alunos[j].getCurso());
                    break;
                }
            }
        }
        System.out.println("======================================");
    }

    static void calcularRiscoPedagogico() {
        if (totalAcompanhamentos == 0) {
            System.out.println("Nenhum acompanhamento registrado.");
            return;
        }

        System.out.println("\n--- Calculando Risco Pedagógico ---");
        // O risco já foi calculado no construtor de AcompanhamentoIA
        // Aqui apenas confirmamos e exibimos um resumo por nível
        int baixo = 0, moderado = 0, alto = 0;
        for (int i = 0; i < totalAcompanhamentos; i++) {
            String risco = acompanhamentos[i].getNivelRisco();
            if (risco.equals("Baixo")) baixo++;
            else if (risco.equals("Moderado")) moderado++;
            else if (risco.equals("Alto")) alto++;
        }

        System.out.println("Risco Baixo:    " + baixo + " aluno(s)");
        System.out.println("Risco Moderado: " + moderado + " aluno(s)");
        System.out.println("Risco Alto:     " + alto + " aluno(s)");
        System.out.println("Total com acompanhamento: " + totalAcompanhamentos);
    }

    static void relatorioGeralRisco() {
        if (totalAcompanhamentos == 0) {
            System.out.println("Nenhum acompanhamento registrado.");
            return;
        }

        System.out.println("\n========== RELATÓRIO GERAL DE RISCO PEDAGÓGICO ==========");
        for (int i = 0; i < totalAcompanhamentos; i++) {
            AcompanhamentoIA a = acompanhamentos[i];
            System.out.println("\nAluno: " + a.getAluno().getPessoa().getNome());
            System.out.println("  Matrícula:          " + a.getAluno().getMatricula());
            System.out.println("  Atividades entregues:    " + a.getAtividadesEntregues());
            System.out.println("  Declarou uso de IA:      " + a.getAtividadesComUsoIA());
            System.out.println("  Conseguiu explicar:      " + a.getAtividadesExplicadas());
            System.out.println("  Conseguiu modificar:     " + a.getCodigosModificados());
            System.out.println("  Conteúdo não visto:      " + a.getEntregasComConteudoNaoVisto());
            System.out.println("  Nível de risco:          " + a.getNivelRisco());
            System.out.println("  ------------------------------------------");
        }
    }

    static void exibirAlunosRiscoAlto() {
        if (totalAcompanhamentos == 0) {
            System.out.println("Nenhum acompanhamento registrado.");
            return;
        }

        System.out.println("\n--- Alunos em Risco Alto ---");
        boolean encontrou = false;
        for (int i = 0; i < totalAcompanhamentos; i++) {
            if (acompanhamentos[i].getNivelRisco().equals("Alto")) {
                System.out.println("- " + acompanhamentos[i].getAluno().getPessoa().getNome() +
                                   " | Matrícula: " + acompanhamentos[i].getAluno().getMatricula());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum aluno em risco alto.");
        }
    }

    // Inovação: recomendação pedagógica personalizada baseada no perfil de cada aluno
    static void inovacao() {
        if (totalAcompanhamentos == 0) {
            System.out.println("Nenhum acompanhamento registrado.");
            return;
        }

        System.out.println("\n========== RECOMENDAÇÕES PEDAGÓGICAS ==========");
        System.out.println("Sugestões automáticas baseadas no nível de risco de cada aluno:");

        for (int i = 0; i < totalAcompanhamentos; i++) {
            AcompanhamentoIA a = acompanhamentos[i];
            String nome = a.getAluno().getPessoa().getNome();
            String risco = a.getNivelRisco();

            System.out.println("\nAluno: " + nome + " | Risco: " + risco);

            if (risco.equals("Baixo")) {
                System.out.println("  Parabéns! O aluno demonstra uso consciente e formativo da IA.");
                System.out.println("  Sugestão: Incentivar o aluno a compartilhar sua experiência com a turma.");
            } else if (risco.equals("Moderado")) {
                System.out.println("  Atenção: O aluno apresenta dependência parcial da IA.");
                System.out.println("  Sugestão: Propor atividades sem uso de IA para fortalecer a autonomia.");
                if (a.getAtividadesExplicadas() < a.getAtividadesEntregues() / 2) {
                    System.out.println("  Sugestão extra: Realizar entrevista oral sobre os códigos entregues.");
                }
            } else if (risco.equals("Alto")) {
                System.out.println("  ALERTA: O aluno demonstra uso não formativo da IA.");
                System.out.println("  Sugestão: Agendar atendimento individual urgente.");
                System.out.println("  Sugestão: Solicitar reentrega comentada e explicação presencial.");
                if (a.getEntregasComConteudoNaoVisto() > 0) {
                    System.out.println("  Sugestão extra: Revisar os conteúdos ainda não estudados com o aluno.");
                }
            }
        }
        System.out.println("\n================================================");
    }
}
