# Sistema de Monitoramento Pedagógico do Uso de IA

## Autores

| Nome | Matrícula |
|------|-----------|
| Rafael Radomsky | 25204017 |
| Julia de Oliveira | 261092704 |

---

## Descrição Geral do Sistema

O sistema foi desenvolvido em Java como trabalho final da disciplina de Fundamentos de Programação (PUCRS). O objetivo é auxiliar professores a monitorar como os estudantes de uma turma estão utilizando ferramentas de inteligência artificial no processo de aprendizagem.

O sistema não trata o uso de IA como problema — ele identifica situações em que o uso pode ser pouco formativo, como quando o aluno entrega um código que não consegue explicar ou modificar. A partir de métricas registradas pelo professor, o sistema calcula um nível de risco pedagógico para cada aluno.

Todas as estruturas de dados foram implementadas com arrays de objetos de tamanho fixo, conforme exigido pelo enunciado. O uso de ArrayList ou qualquer outra coleção dinâmica é proibido e não foi utilizado.

---

## Classes Criadas

### `Pessoa`
Representa os dados pessoais básicos de um estudante: nome, idade e local de nascimento. É a classe mais simples do sistema e serve como base para a composição com `Aluno`.

### `Aluno`
Representa um estudante cadastrado na turma. Contém os dados acadêmicos (curso, matrícula, semestre, ano) e um atributo booleano indicando se é bolsista de IC. Utiliza composição com `Pessoa`.

### `BolsistaIC`
Representa um aluno que participa de um projeto de Iniciação Científica. Armazena o nome do projeto e do orientador. Utiliza composição com `Aluno`.

### `AcompanhamentoIA`
Classe central do sistema. Armazena as métricas de uso de IA por aluno: quantidade de atividades entregues, uso declarado de IA, atividades explicadas, códigos modificados e entregas com conteúdo ainda não estudado. Calcula automaticamente o nível de risco pedagógico no momento em que o objeto é criado.

### `Main`
Classe principal com o menu interativo e todos os vetores de objetos. Contém os 15 métodos correspondentes às operações obrigatórias do sistema.

---

## Composição entre as Classes

O sistema utiliza composição em cadeia:

```
Pessoa
  └── é parte de Aluno
        └── é parte de BolsistaIC
        └── é parte de AcompanhamentoIA
```

Isso significa que para acessar o nome de um bolsista, por exemplo, navegamos assim:

```java
bolsista.getAluno().getPessoa().getNome()
```

A composição foi escolhida porque cada classe representa uma responsabilidade diferente: dados pessoais, dados acadêmicos, dados de IC e dados de acompanhamento de IA. Separar essas responsabilidades torna o código mais organizado e fácil de entender.

---

## Regra de Cálculo do Risco Pedagógico

O risco é calculado automaticamente no construtor de `AcompanhamentoIA` com base em proporções entre as métricas registradas e o total de atividades entregues.

### Risco Baixo
O aluno declarou uso de IA em pelo menos 70% das entregas, conseguiu explicar pelo menos 70% dos códigos, conseguiu modificar pelo menos 70% dos códigos sem ajuda, e usou conteúdo não estudado em no máximo 20% das entregas.

### Risco Alto
O aluno declarou uso de IA em menos de 30% das entregas **ou** explicou menos de 40% dos códigos **ou** modificou menos de 40% dos códigos **ou** usou conteúdo não estudado em mais de 50% das entregas.

### Risco Moderado
Qualquer situação que não se encaixe nos critérios de risco baixo nem de risco alto.

A lógica foi pensada para ser simples, proporcional e baseada apenas nos dados disponíveis no sistema, sem julgamentos absolutos — um aluno com risco alto não é necessariamente desonesto, apenas precisa de acompanhamento mais próximo.

---

## Inovação do Grupo

A inovação implementada é o sistema de **Recomendações Pedagógicas Automáticas** (opção 15 do menu).

Com base no nível de risco calculado para cada aluno, o sistema gera sugestões práticas e personalizadas para o professor:

- **Risco Baixo**: incentiva o professor a destacar o aluno como exemplo positivo de uso de IA.
- **Risco Moderado**: sugere atividades sem IA para fortalecer a autonomia e, se o aluno explicou menos da metade das atividades, recomenda entrevista oral.
- **Risco Alto**: recomenda atendimento individual urgente, reentrega comentada e, se houver conteúdo não visto, revisão dos tópicos com o aluno.

A inovação está diretamente integrada ao sistema — utiliza os vetores de `AcompanhamentoIA` já existentes e as métricas registradas pelo professor, contribuindo diretamente para o monitoramento pedagógico.

---

## Fontes de Consulta

- Material de aula da disciplina de Fundamentos de Programação (PUCRS)
- Slides e anotações das aulas da Profa. Lucia Giraffa e Prof. Gabriel Fonseca Silva
- Claude (Anthropic) — utilizado como ferramenta de apoio ao desenvolvimento

---

## Ferramentas de IA Utilizadas

- **Claude (Anthropic)** — utilizado via Claude Code (interface de linha de comando)

---

## Prompts Utilizados

A conversa completa com o Claude, incluindo todos os prompts utilizados durante o desenvolvimento, está disponível no histórico da sessão do Claude Code. Os principais prompts foram:

- Solicitação de leitura e interpretação do enunciado
- Criação das classes `Pessoa`, `Aluno`, `BolsistaIC` e `AcompanhamentoIA` com comentários explicativos
- Criação do esqueleto do `Main` com menu e vetores
- Implementação de cada operação do menu individualmente
- Criação deste README

---

## Principais Respostas Obtidas com Apoio de IA

- Estrutura completa das 4 classes com atributos, construtores, getters e comentários
- Lógica do menu interativo com `switch` e tratamento de entrada inválida
- Algoritmo de busca por matrícula nos vetores
- Algoritmo de ordenação (bubble sort) para a lista de chamada
- Lógica de cálculo do risco pedagógico com proporções
- Sistema de recomendações pedagógicas da inovação

---

## O que Foi Aceito, Alterado ou Descartado

**Aceito:** A estrutura geral das classes, a cadeia de composição, o menu interativo e a lógica do bubble sort para ordenação.

**Alterado:** Os comentários nas classes foram revisados para ficar em linguagem mais próxima do que usamos nas aulas. A regra de risco pedagógico foi discutida e ajustada para usar proporções em vez de valores absolutos, tornando-a mais justa para turmas de tamanhos diferentes.

**Descartado:** Uma versão inicial da inovação sugeria comparar risco por semestre, mas foi descartada pois exigiria mais dados do que o sistema coleta. A recomendação pedagógica foi escolhida por ser mais útil e direta para o professor.

---

## Lições Aprendidas

- Composição entre classes é uma forma poderosa de organizar responsabilidades sem duplicar atributos.
- Arrays de tamanho fixo exigem atenção constante aos contadores — esquecer de incrementar ou decrementar pode causar bugs difíceis de encontrar.
- Separar a lógica de negócio (cálculo do risco) na própria classe `AcompanhamentoIA` deixa o `Main` mais limpo e fácil de ler.
- Usar IA como apoio é produtivo quando entendemos o que está sendo gerado — simplesmente copiar sem compreender criaria problemas na apresentação.

---

## Dificuldades Encontradas

- Entender a diferença entre composição e herança no início foi confuso — chegamos a pensar em fazer `Aluno extends Pessoa`, mas o enunciado deixa claro que deve ser composição.
- Implementar o percentual por curso sem usar HashMap foi desafiador, pois exigiu criar dois arrays paralelos para relacionar curso e contagem.
- A ordenação alfabética da lista de chamada exigiu entender o funcionamento do bubble sort e do método `compareToIgnoreCase`.

---

## Como as Dificuldades Foram Superadas

- A dúvida sobre composição vs herança foi resolvida relendo o enunciado e conversando com o Claude, que explicou a diferença com exemplos práticos.
- Os arrays paralelos para o percentual por curso foram compreendidos ao desenhar no papel o que cada posição representava antes de escrever o código.
- O bubble sort foi entendido acompanhando passo a passo a lógica de comparação e troca antes de implementar.

---

## Divisão de Tarefas entre os Integrantes

| Tarefa | Responsável |
|--------|-------------|
| Classes `Pessoa` e `Aluno` | Rafael Radomsky |
| Classes `BolsistaIC` e `AcompanhamentoIA` | Julia de Oliveira |
| Menu principal e operações 1 a 5 | Rafael Radomsky |
| Operações 6 a 10 | Julia de Oliveira |
| Operações 11 a 15 e inovação | Rafael Radomsky |
| README | Rafael Radomsky e Julia de Oliveira |
| Vídeo pitch | Rafael Radomsky e Julia de Oliveira |
