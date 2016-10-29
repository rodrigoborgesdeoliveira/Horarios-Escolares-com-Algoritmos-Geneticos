/*
 * Definição e criação de cada indivíduo da população.
 */
package gerenciarhorarios;

import database.DataAccessObject;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class Individuo {

    private int[] genes;
    private int idTurma;
    private int aptidao = 0; //Considera-se que o indivíduo é inicialmente perfeito.
    private ArrayList<Integer> alelos = new ArrayList<>();
    private int qtdAlelosVazios = 0;

    //Cria um indivíduo a partir de outro indivíduo.
    public Individuo(Individuo individuoBase) {
        this.genes = new int[individuoBase.genes.length];
        System.arraycopy(individuoBase.genes, 0, this.genes, 0, individuoBase.genes.length);
        this.idTurma = individuoBase.idTurma;
        aptidao = individuoBase.getAptidao();
        //alelos = new ArrayList<>(individuoBase.alelos);
        this.qtdAlelosVazios = individuoBase.qtdAlelosVazios;
        
        //geraAptidao();
    }

    //Cria um indivíduo aleatório.
    public Individuo(ArrayList<Disciplina> disciplinas, int idTurma) {
        Random r = new Random();

        this.idTurma = idTurma;
        //System.out.println("Alelos: ");
        //Definição dos alelos.
        for (int i = 0; i < disciplinas.size(); i++) {
            //Cada disciplina será repetida nos alelos de acordo com a quantidade de aulas semanais.
            for (int j = 0; j < disciplinas.get(i).getQtdAulasSemanais(); j++) {
                alelos.add(disciplinas.get(i).getID());
            }
        }

        //Preencher o resto dos alelos com valores vazios (0).
        //Verificar qual é o turno da turma.
        Turma turmaTemp = DataAccessObject.getTurmaByID(idTurma);
        int qtdMaxAulasSemana; //Quantidade máxima de aulas que a turma pode ter na semana, de acordo com o turno.
        if (turmaTemp.getTurno().equals("Matutino") || turmaTemp.getTurno().equals("Vespertino")) {
            qtdMaxAulasSemana = 36;
        } else { //Turno noturno.
            qtdMaxAulasSemana = 24;
        }

        //Se for necessário uma quantidade de aulas além das disponíveis em um único turno.
        if (alelos.size() > qtdMaxAulasSemana) {
            JOptionPane.showMessageDialog(null, "Impossível gerar um horário com essa"
                    + "quantidade de aulas semanais.", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        //Se não tiver atingido o máximo de aulas na semana, completar com valores vazios (0).
        if (alelos.size() != qtdMaxAulasSemana) {
            while (alelos.size() < qtdMaxAulasSemana) {
                alelos.add(0);
                qtdAlelosVazios++;
            }
        }

        //Geração dos genes
        genes = new int[qtdMaxAulasSemana];
//        System.out.println("Genes população inicial: ");
        for (int i = 0; i < genes.length; i++) {
            int aleatorio = r.nextInt(alelos.size());
            genes[i] = alelos.get(aleatorio);
//            System.out.print(genes[i]);
            alelos.remove(aleatorio);
        }

        geraAptidao();

//        System.out.println(" | Minha aptidão: " + aptidao); 
    }

    //Cria um indivíduo com os genes fornecidos.
    public Individuo(int genes[], int idTurma, int qtdAlelosVazios, Populacao novaPopulacao) {
        Random r = new Random();

        this.idTurma = idTurma;
        this.qtdAlelosVazios = qtdAlelosVazios;

        this.genes = genes;
        
        //Faz ou não a mutação de um gene.
        if (r.nextDouble() <= Algoritmo.getTaxaMutacao()) {
            //Faz uma mutação de ordem, ou seja, dois genes aleatórios são trocados de posição entre si.
            int posicaoAleatoria1 = r.nextInt(this.genes.length);
            int posicaoAleatoria2 = r.nextInt(this.genes.length);
            int geneTemp = this.genes[posicaoAleatoria1];
            this.genes[posicaoAleatoria1] = this.genes[posicaoAleatoria2];
            this.genes[posicaoAleatoria2] = geneTemp;
        }
        if (r.nextDouble() <= Algoritmo.getTaxaMutacao()) {
            ArrayList<Aula> aulasTemp = DataAccessObject.getAulasByIDTurma(this.idTurma);
            int posicaoAleatoria = r.nextInt(this.genes.length);
            if (r.nextDouble() <= 0.5) {
                this.genes[posicaoAleatoria] = aulasTemp.get(r.nextInt(aulasTemp.size())).getIDDisciplina();
            } else {
                this.genes[posicaoAleatoria] = 0;
            }
        }
        
        geraAptidao();
    }

    public int getQtdAlelosVazios() {
        return qtdAlelosVazios;
    }

    public void setIDTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIDTurma() {
        return idTurma;
    }

    public void geraAptidao() {
        aptidao = 0;
        //Verificar restrições dos professores das disciplinas.
        int turmaAcrescimo; //Valor para comparação das restrições do professor de acordo com o turno. 
        //Matutino = 0, Vespertino = 36 e Noturno = 72.
        Turma turmaTemp = DataAccessObject.getTurmaByID(idTurma);
        switch (turmaTemp.getTurno()) {
            case "Matutino":
                turmaAcrescimo = 0;
                break;
            case "Vespertino":
                turmaAcrescimo = 36;
                break;
            default:
                //Noturno.
                turmaAcrescimo = 72;
                break;
        }

        int qtdGenesVazios = 0;
        ArrayList<Integer> idsVerificados = new ArrayList<>();
        for (int i = 0; i < genes.length; i++) {
            if (genes[i] != 0) {
                //ID do professor da disciplina na posição i do gene.
                Disciplina disciplinaTemp = DataAccessObject.getDisciplinaByID(genes[i]);
                int idProfessorTemp = disciplinaTemp.getIdProfessor();

                //---------------------------------------------------------------------------
                //Verificar turmas conjuntas.
                //---------------------------------------------------------------------------
                //Verificar se turma atual ou turmas conjuntas possuem horário.
                boolean sair = false; //Variável para sair
                boolean disciplinaConjunta = false; //Variável para saber se essa
                //disciplina é conjunta com outra turma e se essa outra turma já
                //definiu o horário dessa disciplina.

                int idTurmaConjunta = DataAccessObject.getIDTurmaConjunta(genes[i], idTurma);

                if (idTurmaConjunta != 0) {
                    //Essa aula é conjunta com outra turma.
                    ArrayList<Integer> idsTurmasConjuntasVerificadas = new ArrayList<>();
                    //Marcar turma atual para não verificar.
                    idsTurmasConjuntasVerificadas.add(idTurma);
                    while (!sair) {
                        idsTurmasConjuntasVerificadas.add(idTurmaConjunta);
                        if (DataAccessObject.turmaTemHorario(idTurmaConjunta)) {
                            //Turma conjunta possui horário.

                            disciplinaConjunta = true; //Uma turma conjunta
                            //já definiu o horário dessa disciplina.

                            //Verificar se a disciplina da turma atual está na
                            //mesma posição que a da turma conjunta.
                            if (DataAccessObject.getHorarioTurma(idTurmaConjunta).getHorarioTurma()[i]
                                    != genes[i]) {
                                //Disciplina em posições diferentes, penalizar.
                                aptidao++;
                                sair = true;
                            } else {
                                sair = true;
                            }
                        } else {
                            //Turma conjunta não possui horário.
                            //--------------------------------------------------
                            //Verificar se a disciplina pode ser nessa posição.
                            //--------------------------------------------------
                            //Validar aulas geminadas.
                            if (DataAccessObject.getTurmaByID(idTurmaConjunta).getAulasGeminadas()) {
                                //Ter apenas aulas geminadas.
                                if (!turmaTemp.getSemAulasGeminadas()) {
                                    //Turma atual não restringiu que as aulas não sejam
                                    //geminadas, se restringir, ignorar esta validação.
                                    if (i % 2 == 0) {
                                        //Posição par no horário. Comparar com a próxima
                                        //posição.
                                        if (genes[i] != genes[i + 1]) {
                                            //Penalizar se não for geminado.
                                            aptidao += 3;
                                        }
                                    } else //Posição ímpar. Comparar com a posição anterior.
                                    {
                                        if (genes[i] != genes[i - 1]) {
                                            //Penalizar se não for geminado.
                                            aptidao += 3;
                                        }
                                    }
                                }
                            } else if (DataAccessObject.getTurmaByID(idTurmaConjunta)
                                    .getSemAulasGeminadas()) {
                                //Não ter aulas geminadas.
                                if (!turmaTemp.getAulasGeminadas()) {
                                    //Turma atual não restringiu que as aulas sejam
                                    //geminadas, se restringir, ignorar esta validação.
                                    if (i % 2 == 0) {
                                        //Posição par no horário. Comparar com a próxima
                                        //posição.
                                        if (genes[i] == genes[i + 1]) {
                                            //Penalizar se for geminado.
                                            aptidao += 3;
                                        }
                                    } else //Posição ímpar. Comparar com a posição anterior.
                                    {
                                        if (genes[i] == genes[i - 1]) {
                                            //Penalizar se não for geminado.
                                            aptidao += 3;
                                        }
                                    }
                                }
                            }

                            //Validar dias da semana.
                            if (DataAccessObject.getTurmaByID(idTurmaConjunta).getTurno()
                                    .equals("Matutino") || DataAccessObject.getTurmaByID(idTurmaConjunta)
                                    .getTurno().equals("Vespertino")) {
                                if (DataAccessObject.getTurmaByID(idTurmaConjunta)
                                        .getDiasSemana()[i / 6] == '0' && genes[i] != 0) {
                                    //Dia não disponível e aula não vaga, penalizar.
                                    aptidao += 3;
                                }
                            } else if (DataAccessObject.getTurmaByID(idTurmaConjunta)
                                    .getDiasSemana()[i / 4] == '0' && genes[i] != 0) {
                                //Dia não disponível e aula não vaga, penalizar.
                                aptidao += 3;
                            }

                            //Validar janelamento entre disciplinas.
                            if (!DataAccessObject.getTurmaByID(idTurmaConjunta)
                                    .getJanelamentoDisciplinas()) {
                                //Evitar janelamento entre aulas. Janelamento desabilitado.
                                if (DataAccessObject.getTurmaByID(idTurmaConjunta)
                                        .getTurno().equals("Matutino")
                                        || DataAccessObject.getTurmaByID(idTurmaConjunta)
                                        .getTurno().equals("Vespertino")) {
                                    if ((i + 1) < genes.length) {
                                        if (genes[i + 1] != genes[i] && (i / 6) == ((i + 1) / 6)) {
                                            //Possível janelamento.
                                            for (int j = i + 2; j < (6 * ((i / 6) + 1)); j++) {
                                                if (genes[j] == genes[i]) {
                                                    //Houve janelamento. Penalizar.
                                                    aptidao += 3;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } else //Noturno.
                                {
                                    if ((i + 1) < genes.length) {
                                        if (genes[i + 1] != genes[i] && (i / 4) == ((i + 1) / 4)) {
                                            //Possível janelamento.
                                            for (int j = i + 2; j < (4 * ((i / 4) + 1)); j++) {
                                                if (genes[j] == genes[i]) {
                                                    //Houve janelamento. Penalizar.
                                                    aptidao += 3;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            //--------------------------------------------------

                            idTurmaConjunta = DataAccessObject.getIDTurmaConjunta(genes[i], idTurmaConjunta);
                            if (idTurmaConjunta != 0) {
                                //Possui turma conjunta.
                                if (idsTurmasConjuntasVerificadas.contains(idTurmaConjunta)) {
                                    //Turma conjunta já verificada, encerrar verificação 
                                    //para evitar loop infinito.
                                    sair = true;
                                }
                            } else {
                                //Não possui turma conjunta. Encerrar verificação.
                                sair = true;
                            }
                        }
                    }                   
                }

                //Verificar se turma atual é turma conjunta de alguma outra turma
                //na disciplina atual.
                ArrayList<Integer> idsTurmas = DataAccessObject.
                        getIDsTurmasByIDTurmaConjuntaIDDisciplina(idTurma, genes[i]);
                if (!idsTurmas.isEmpty()) {
                    //Turma atual é conjunta de outra turma na disciplina atual.

                    //Verificar se as turmas encontradas possuem horário.
                    for (Integer idsTurma : idsTurmas) {
                        if (DataAccessObject.turmaTemHorario(idsTurma)) {
                            //Turma possui horário.

                            disciplinaConjunta = true; //Uma turma conjunta já
                            //definiu o horário dessa disciplina.

                            //Verificar se a disciplina da turma atual está na
                            //mesma posição que a da turma conjunta.
                            if (DataAccessObject.getHorarioTurma(idsTurma).getHorarioTurma()[i]
                                    != genes[i]) {
                                //Disciplina em posições diferentes, penalizar.
                                aptidao++;
                            }
                        } else {
                            //Turma não possui horário ainda.
                            //--------------------------------------------------
                            //Verificar se a disciplina pode ser nessa posição.
                            //--------------------------------------------------
                            //Validar aulas geminadas.
                            if (DataAccessObject.getTurmaByID(idsTurma).getAulasGeminadas()) {
                                //Ter apenas aulas geminadas.
                                if (!turmaTemp.getSemAulasGeminadas()) {
                                    //Turma atual não restringiu que as aulas não sejam
                                    //geminadas, se restringir, ignorar esta validação.
                                    if (i % 2 == 0) {
                                        //Posição par no horário. Comparar com a próxima
                                        //posição.
                                        if (genes[i] != genes[i + 1]) {
                                            //Penalizar se não for geminado.
                                            aptidao += 3;
                                        }
                                    } else //Posição ímpar. Comparar com a posição anterior.
                                    {
                                        if (genes[i] != genes[i - 1]) {
                                            //Penalizar se não for geminado.
                                            aptidao += 3;
                                        }
                                    }
                                }
                            } else if (DataAccessObject.getTurmaByID(idsTurma)
                                    .getSemAulasGeminadas()) {
                                //Não ter aulas geminadas.
                                if (!turmaTemp.getAulasGeminadas()) {
                                    //Turma atual não restringiu que as aulas sejam
                                    //geminadas, se restringir, ignorar esta validação.
                                    if (i % 2 == 0) {
                                        //Posição par no horário. Comparar com a próxima
                                        //posição.
                                        if (genes[i] == genes[i + 1]) {
                                            //Penalizar se for geminado.
                                            aptidao += 3;
                                        }
                                    } else //Posição ímpar. Comparar com a posição anterior.
                                    {
                                        if (genes[i] == genes[i - 1]) {
                                            //Penalizar se não for geminado.
                                            aptidao += 3;
                                        }
                                    }
                                }
                            }

                            //Validar dias da semana.
                            if (DataAccessObject.getTurmaByID(idsTurma).getTurno()
                                    .equals("Matutino") || DataAccessObject.getTurmaByID(idsTurma)
                                    .getTurno().equals("Vespertino")) {
                                if (DataAccessObject.getTurmaByID(idsTurma)
                                        .getDiasSemana()[i / 6] == '0' && genes[i] != 0) {
                                    //Dia não disponível e aula não vaga, penalizar.
                                    aptidao += 3;
                                }
                            } else if (DataAccessObject.getTurmaByID(idsTurma)
                                    .getDiasSemana()[i / 4] == '0' && genes[i] != 0) {
                                //Dia não disponível e aula não vaga, penalizar.
                                aptidao += 3;
                            }

                            //Validar janelamento entre disciplinas.
                            if (!DataAccessObject.getTurmaByID(idsTurma)
                                    .getJanelamentoDisciplinas()) {
                                //Evitar janelamento entre aulas. Janelamento desabilitado.
                                if (DataAccessObject.getTurmaByID(idsTurma)
                                        .getTurno().equals("Matutino")
                                        || DataAccessObject.getTurmaByID(idsTurma)
                                        .getTurno().equals("Vespertino")) {
                                    if ((i + 1) < genes.length) {
                                        if (genes[i + 1] != genes[i] && (i / 6) == ((i + 1) / 6)) {
                                            //Possível janelamento.
                                            for (int j = i + 2; j < (6 * ((i / 6) + 1)); j++) {
                                                if (genes[j] == genes[i]) {
                                                    //Houve janelamento. Penalizar.
                                                    aptidao += 3;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                } else //Noturno.
                                {
                                    if ((i + 1) < genes.length) {
                                        if (genes[i + 1] != genes[i] && (i / 4) == ((i + 1) / 4)) {
                                            //Possível janelamento.
                                            for (int j = i + 2; j < (4 * ((i / 4) + 1)); j++) {
                                                if (genes[j] == genes[i]) {
                                                    //Houve janelamento. Penalizar.
                                                    aptidao += 3;
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //---------------------------------------------------------------------------------
                
                if (disciplinaConjunta == false) {
                    //Não possui turmas conjuntas que já definiram o horário.

                    //Se o professor possuir restrição nesse horário.
                    if (DataAccessObject.getProfessorByID(idProfessorTemp).getRestricoes()[i + turmaAcrescimo] == '1') {
                        aptidao += 5; //Penaliza com 5 pontos.
                    }
                }

                //Verificar se já foi feita a contagem dessa disciplina.
                if (!idsVerificados.contains(disciplinaTemp.getID())) {
                    //Não verificou ainda.
                    int ocorrencias = 0; //Quantas vezes a disciplina aparece no horário.
                    //Contar as ocorrências.
                    for (int j = 0; j < genes.length; j++) {
                        if (disciplinaTemp.getID() == genes[j]) {
                            ocorrencias++;
                        }
                    }

                    //Verificar se a quantidade de ocorrências é a quantidade certa de vezes
                    //em que a disciplina deve estar presente em um horário. Com base
                    //na quantidade de aulas semanais daquela disciplina.
                    if (ocorrencias != disciplinaTemp.getQtdAulasSemanais()) {
                        aptidao += abs(10 * (ocorrencias - disciplinaTemp.getQtdAulasSemanais())); //Penaliza com 10+ pontos.
                    }
                    idsVerificados.add(disciplinaTemp.getID());
                }                
            } else {
                //Quantidade de genes vazios.
                qtdGenesVazios++;
            }
        }

        if (qtdAlelosVazios != qtdGenesVazios) {
            //Possui mais genes vazios do que deveria.
            //Penaliza com 20+ pontos.
            aptidao += abs(15 * (qtdGenesVazios - qtdAlelosVazios));
        }

        //Validar aulas geminadas.
        if (turmaTemp.getAulasGeminadas()) {
            //Ter apenas aulas geminadas.
            for (int i = 0; i < genes.length; i += 2) {
                if (genes[i] != genes[i + 1]) {
                    //Penalizar se não for geminado.
                    aptidao += 3;
                }
            }
        } else if (turmaTemp.getSemAulasGeminadas()) {
            //Não ter aulas geminadas.
            for (int i = 0; i < genes.length - 1; i++) {
                if (genes[i] != 0) {
                    if (genes[i] == genes[i + 1]) {
                        //Penalizar se for geminado.
                        aptidao += 3;
                    }
                }
            }
        }

        //Validar dias da semana.
        if (turmaTemp.getTurno()
                .equals("Matutino") || turmaTemp.getTurno().equals("Vespertino")) {
            for (int i = 0; i < 6; i++) {
                //Dias da semana.
                for (int j = i * 6; j < ((i * 6) + 6); j++) {
                    //Genes correspondentes ao dia.
                    if (turmaTemp.getDiasSemana()[i] == '0' && genes[j] != 0) {
                        //Dia não disponível e aula não vaga, penalizar.
                        aptidao += 3;
                    }
                }
            }
        } else {
            //Noturno.
            for (int i = 0; i < 6; i++) {
                //Dias da semana.
                for (int j = i * 4; j < ((i * 4) + 4); j++) {
                    //Genes correspondentes ao dia.
                    if (turmaTemp.getDiasSemana()[i] == '0' && genes[j] != 0) {
                        //Dia não disponível e aula não vaga, penalizar.
                        aptidao += 3;
                    }
                }
            }
        }

        //Validar janelamento entre disciplinas.
        if (!turmaTemp.getJanelamentoDisciplinas()) {
            //Evitar janelamento entre aulas. Janelamento desabilitado.
            if (turmaTemp.getTurno().equals("Matutino") || turmaTemp.getTurno().equals("Vespertino")) {
                for (int i = 0; i < 6; i++) {
                    //Dias da semana.
                    for (int j = i * 6; j < ((i * 6) + 4); j++) {
                        //Genes correspondentes ao dia.
                        if (genes[j] != 0 && genes[j + 1] == 0) {
                            //Aula não vaga seguida de aula vaga.

                            for (int k = j + 2; k < ((i * 6) + 6); k++) {
                                //Busca do dia por uma aula não vaga após a aula vaga.
                                if (genes[k] != 0) {
                                    aptidao += 3;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            } else {
                //Noturno.
                for (int i = 0; i < 6; i++) {
                    //Dias da semana.
                    for (int j = i * 4; j < ((i * 4) + 2); j++) {
                        //Genes correspondentes ao dia.
                        if (genes[j] != 0 && genes[j + 1] == 0) {
                            //Aula não vaga seguida de aula vaga.

                            for (int k = j + 2; k < ((i * 4) + 4); k++) {
                                //Busca do dia por uma aula não vaga após a aula vaga.
                                if (genes[k] != 0) {
                                    aptidao += 3;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
    }

    public int getAptidao() {
        return aptidao;
    }

    public int[] getGenes() {
        return genes;
    }
}
