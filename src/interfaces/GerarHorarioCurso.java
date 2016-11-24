/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import database.DataAccessObject;
import gerenciarhorarios.Algoritmo;
import gerenciarhorarios.Aula;
import gerenciarhorarios.Disciplina;
import gerenciarhorarios.Populacao;
import gerenciarhorarios.Professor;
import gerenciarhorarios.Turma;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class GerarHorarioCurso extends javax.swing.JInternalFrame {

    ArrayList<Turma> turmasGeral = new ArrayList<>();
    ArrayList<Turma> turmasCurso = new ArrayList<>();
    ArrayList<Turma> turmasSelecionadas = new ArrayList<>();
    ArrayList<String> cursos = new ArrayList<>();

    String nivelSelecionado; //Nível de ensino selecionado.
    DefaultListModel listModel = new DefaultListModel(); //Modelo para o JList.

    /**
     * Creates new form GerarHorarioCurso
     */
    public GerarHorarioCurso() {
        initComponents();

        jListTurmas.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCurso = new javax.swing.JLabel();
        jComboBoxCurso = new javax.swing.JComboBox<>();
        jButtonSelecionarCurso = new javax.swing.JButton();
        jLabelTurmasCurso = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxTurmas = new javax.swing.JComboBox<>();
        jButtonAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTurmas = new javax.swing.JList<>();
        jButtonRemover = new javax.swing.JButton();
        jButtonGerar = new javax.swing.JButton();
        jLabelNivelEnsino = new javax.swing.JLabel();
        jComboBoxNivelEnsino = new javax.swing.JComboBox<>();
        jButtonSelecionarNivelEnsino = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerar horário por curso");

        jLabelCurso.setText("Curso");

        jButtonSelecionarCurso.setText("Selecionar");
        jButtonSelecionarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarCursoActionPerformed(evt);
            }
        });

        jLabelTurmasCurso.setText("Turmas do curso");

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListTurmas);

        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonGerar.setText("Gerar");
        jButtonGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarActionPerformed(evt);
            }
        });

        jLabelNivelEnsino.setText("Nível de ensino");

        jComboBoxNivelEnsino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fundamental", "Médio", "Superior" }));

        jButtonSelecionarNivelEnsino.setText("Selecionar");
        jButtonSelecionarNivelEnsino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarNivelEnsinoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNivelEnsino)
                                    .addComponent(jLabelCurso))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxCurso, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxNivelEnsino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonSelecionarNivelEnsino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonSelecionarCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabelTurmasCurso)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                                    .addComponent(jComboBoxTurmas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNivelEnsino)
                    .addComponent(jComboBoxNivelEnsino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelecionarNivelEnsino))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCurso)
                    .addComponent(jButtonSelecionarCurso))
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTurmasCurso)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAdicionar))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonRemover))
                .addGap(30, 30, 30)
                .addComponent(jButtonGerar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelecionarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarCursoActionPerformed
        if (nivelSelecionado.equals("Superior")) {
            DataAccessObject.abrirConexao();
            turmasCurso = DataAccessObject.getTurmasByCurso(jComboBoxCurso.getSelectedItem().toString());

            //Limpar o jComboBox e a lista de turmas.
            jComboBoxTurmas.removeAllItems();
            listModel.clear();

            for (int i = 0; i < turmasCurso.size(); i++) {
                jComboBoxTurmas.addItem("Curso: " + turmasCurso.get(i).getCurso() + " | Nível de ensino: "
                        + turmasCurso.get(i).getNivelEnsino() + " | Turma: " + turmasCurso.get(i).getNome()
                        + " | Semestre: " + turmasCurso.get(i).getAno() + " | Turno: " + turmasCurso.get(i).getTurno());
            }

            DataAccessObject.fecharConexao();
        }
    }//GEN-LAST:event_jButtonSelecionarCursoActionPerformed

    private void jButtonSelecionarNivelEnsinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarNivelEnsinoActionPerformed
        DataAccessObject.abrirConexao();
        if (jComboBoxNivelEnsino.getSelectedItem().equals("Fundamental")
                || jComboBoxNivelEnsino.getSelectedItem().equals("Médio")) {
            JOptionPane.showMessageDialog(null, "Selecione a opção gerar para "
                    + "continuar.");
            nivelSelecionado = jComboBoxNivelEnsino.getSelectedItem().toString();

            //Limpar jComboBox de turmas e de curso, e jComboList.
            listModel.clear();
            jComboBoxCurso.removeAllItems();
            jComboBoxTurmas.removeAllItems();
        } else {
            nivelSelecionado = jComboBoxNivelEnsino.getSelectedItem().toString();

            turmasGeral = DataAccessObject.getTurmas();
            cursos = new ArrayList<>(); //Esvaziar array list.

            boolean jaTemCurso = false; //Já adicionou ou não o curso ao ArrayList.

            //Adicionar os cursos ao jComboBox de cursos.
            for (int i = 0; i < turmasGeral.size(); i++) {
                if (turmasGeral.get(i).getNivelEnsino().equals("Superior")) {
                    for (int j = 0; j < cursos.size(); j++) {
                        if (turmasGeral.get(i).getCurso().toLowerCase().equals(cursos.get(j).toLowerCase())) {
                            //Já adicionou o curso ao ArrayList antes.
                            jaTemCurso = true;
                            break;
                        }
                    }
                    if (jaTemCurso == false) {
                        //Se não adicionou o curso, adicionar.
                        cursos.add(turmasGeral.get(i).getCurso());
                    }
                    jaTemCurso = false;
                }
            }
//            cursos.sort(c);
            for (int i = 0; i < cursos.size(); i++) {
                jComboBoxCurso.addItem(cursos.get(i));
            }
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jButtonSelecionarNivelEnsinoActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        DataAccessObject.abrirConexao();
        Turma turma = turmasCurso.get(jComboBoxTurmas.getSelectedIndex()); //Turma selecionada.
        turmasSelecionadas.add(turma);

        //Não adicionar se o item já tiver sido adicionado.
        for (int i = 0; i < listModel.size(); i++) {
            if (listModel.get(i).equals("Curso: " + turma.getCurso() + " | Nível de ensino: "
                    + turma.getNivelEnsino() + " | Turma: " + turma.getNome()
                    + " | Semestre: " + turma.getAno() + " | Turno: " + turma.getTurno())) {
                return;
            }
        }

        listModel.addElement("Curso: " + turma.getCurso() + " | Nível de ensino: "
                + turma.getNivelEnsino() + " | Turma: " + turma.getNome()
                + " | Semestre: " + turma.getAno() + " | Turno: " + turma.getTurno());

        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        turmasSelecionadas.remove(jListTurmas.getSelectedIndex());
        listModel.remove(jListTurmas.getSelectedIndex());
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarActionPerformed
        if (nivelSelecionado.equals("Superior")) {
            if (listModel.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione pelo menos uma turma "
                        + "para gerar o horário.", "Nenhuma turma selecionada", JOptionPane.ERROR_MESSAGE);
            } else {
                //Gerar o horário das turmas.
                DataAccessObject.abrirConexao();
                ordenarTurmasSelecionadas(); //Organizar as turmas selecionadas
                //pela quantidade de restrições, do maior para o menor.

                long inicio = System.nanoTime();

                for (int i = 0; i < turmasSelecionadas.size(); i++) {
                    Turma turma = turmasSelecionadas.get(i); //Turma selecionada.
                    if (DataAccessObject.turmaTemHorario(turma.getID())) {
                        //Turma já possui horário cadastrado.
                        Object[] opcoes = {"Sim", "Não"};
                        if (turma.getNivelEnsino().equals("Superior")) {
                            // Nível superior.

                            int opcao = JOptionPane.showOptionDialog(null, "A turma (Curso: "
                                    + turma.getCurso() + " | Nível de ensino: "
                                    + turma.getNivelEnsino() + " | Turma: " + turma.getNome()
                                    + " | Semestre: " + turma.getAno() + " | Turno: " + turma.getTurno() + ") já possui "
                                    + "um horário definido. \nPara que o horário seja gerado corretamente, "
                                    + "por favor, remova-o primeiro através da opção "
                                    + "'Remover horário' localizada no menu 'Gerenciar horários'."
                                    + "\nDeseja continuar mesmo assim?",
                                    "Horário da turma já cadastrado", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
                            if (opcao != 0) {
                                //Se não pressionar a opção sim.
                                return; //Interromper execução da geração de horários.
                            }
                        } else {
                            // Nível fundamental ou médio.

                            int opcao = JOptionPane.showOptionDialog(null, "A turma (Nível de ensino: "
                                    + turma.getNivelEnsino() + " | Turma: " + turma.getNome()
                                    + " | Série: " + turma.getAno() + " | Turno: " + turma.getTurno() + ") já possui "
                                    + "um horário definido. \nPara que o horário seja gerado corretamente, "
                                    + "por favor, remova-o primeiro através da opção "
                                    + "'Remover horário' localizada no menu 'Gerenciar horários'."
                                    + "\nDeseja continuar mesmo assim?",
                                    "Horário da turma já cadastrado", JOptionPane.DEFAULT_OPTION,
                                    JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
                            if (opcao != 0) {
                                //Se não pressionar a opção sim.
                                return; //Interromper execução da geração de horários.
                            }
                        }
                    }

                    ArrayList<Aula> aulas = DataAccessObject.getAulasByIDTurma(turma.getID()); //Aulas que contém essa turma.
                    ArrayList<Disciplina> disciplinas = new ArrayList<>(); //Disciplinas da turma.

                    //Adicionar as disciplinas das aulas ao array list.
                    for (int j = 0; j < aulas.size(); j++) {
                        disciplinas.add(DataAccessObject.getDisciplinaByID(aulas.get(j).getIDDisciplina()));
                    }
                    //Geração dos horários utilizando o algoritmo genético.
                    Algoritmo.setTaxaCrossover(0.5); //50% de chance de realizar o cruzamento.
                    Algoritmo.setTaxaMutacao(0.35); //35% de chance de mutar.

                    boolean elitismo = true; //Realizar elitismo (preservar melhor elitismo).

                    int tamanhoPopulacao = 5; //Quantidade de indivíduos por população.
                    int numMaxGeracoes = 30000; //Número máximo de gerações.

                    //População inicial aleatória.
                    Populacao populacao = new Populacao(tamanhoPopulacao, disciplinas, turma.getID());

                    boolean temSolucao = false; //Variável para verificar se há solução.
                    int geracao = 1; //Contagem de gerações.

                    int reiniciaBanco = 1; //Variável para reiniciar a conexão com o banco a cada 100 gerações.

                    //Enquanto não encontrar uma solução ou não atingir o máximo de gerações.
                    while (!(temSolucao || geracao > numMaxGeracoes)) {
                        //Criar nova população para substituir a população inicial aleatória.
                        populacao = new Populacao(Algoritmo.gerarNovaGeracao(populacao, elitismo));
                        //Analisar se a nova população possui um indivíduo que é a solução (aptidão = 0).
                        //populacao.getMelhorIndividuo().geraAptidao();

                        System.out.println("Genes: ");
                        for (int j = 0; j < populacao.getMelhorIndividuo().getGenes().length; j++) {
                            System.out.print(populacao.getMelhorIndividuo().getGenes()[j]);
                        }

                        System.out.println(" | Geração = " + geracao + "| Aptidão = " + populacao.getMelhorIndividuo().getAptidao());
                        if (populacao.getMelhorIndividuo().getAptidao() == 0) {
                            //Indivíduo é a solução.
                            //Armazenar os genes do indivíduo (solução) no horário da turma.
                            turma.setHorarioTurma(populacao.getMelhorIndividuo().getGenes());
                            temSolucao = true;
                        }

                        geracao++;
                        if (geracao == reiniciaBanco * 100) {
                            reiniciaBanco++;

                            //Fecha e abre a conexão novamente.
                            DataAccessObject.fecharConexao();
                            DataAccessObject.abrirConexao();
                        }
                    }

                    //Se já tiver cadastrado um horário da turma antes, remover para que
                    //seja inserido um novo horário.
                    if (DataAccessObject.turmaTemHorario(turma.getID())) {
                        //Antes de remover, dizer que os professores possuem disponibilidade
                        //nesses horários. 
                        int turmaAcrescimo; //Acréscimo para definir as restrições de acordo com o turno.
                        switch (turma.getTurno()) {
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

                        int[] horario = DataAccessObject.getHorarioTurma(turma.getID()).getHorarioTurma();
                        for (int j = 0; j < horario.length; j++) {
                            if (horario[j] != 0) {
                                //Se não for uma aula vazia, editar restrição do professor.
                                Disciplina disciplina = DataAccessObject.getDisciplinaByID(horario[j]);
                                Professor professor = DataAccessObject.getProfessorByID(disciplina.getIdProfessor());

                                char[] restricoes = professor.getRestricoes();
                                restricoes[j + turmaAcrescimo] = '0'; //Disponibilidade de horário.
                                professor.setRestricoes(restricoes);

                                DataAccessObject.update(professor);
                            }
                        }

                        DataAccessObject.removeHorarioByIDTurma(turma.getID());
                    }
                    DataAccessObject.insertHorario(turma); //Inserir horário no banco.

                    int turmaAcrescimo; //Acréscimo para definir as restrições de acordo com o turno.
                    switch (turma.getTurno()) {
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

                    //Inserir as novas restrições dos professores, de acordo com o novo horário gerado.
                    for (int j = 0; j < turma.getHorarioTurma().length; j++) {
                        if (turma.getHorarioTurma()[j] != 0) {
                            //Se não for uma aula vazia, adicionar restrição ao professor.
                            Disciplina disciplina = DataAccessObject.getDisciplinaByID(turma.getHorarioTurma()[j]);
                            Professor professor = DataAccessObject.getProfessorByID(disciplina.getIdProfessor());

                            char[] restricoes = professor.getRestricoes();
                            restricoes[j + turmaAcrescimo] = '1';
                            professor.setRestricoes(restricoes);

                            DataAccessObject.update(professor);
                        }
                    }

                    if (geracao >= numMaxGeracoes) {
                        turma.setHorarioTurma(populacao.getMelhorIndividuo().getGenes());
                        JOptionPane.showMessageDialog(null, "Nenhuma solução encontrada para"
                                + " a turma '" + "Curso: " + turma.getCurso() + " | Nível de ensino: "
                                + turma.getNivelEnsino() + " | Turma: " + turma.getNome()
                                + " | Série/Semestre: " + turma.getAno() + " | Turno: " + turma.getTurno()
                                + "'\nArmazenado a solução mais adequada.");
                    }
                }
                long fim = System.nanoTime();
                long duracao = (fim - inicio) / 1000000000; //Duraçao em segundos.
                if (duracao < 60) {
                    System.out.println("Gerado em: " + duracao + " segundos.");
                } else {
                    //Passou de um minuto.
                    int minutos = (int) (duracao / 60);
                    int segundos = (int) (duracao - minutos * 60);
                    System.out.println("Gerado em: " + minutos + " minutos e " + segundos + " segundos.");
                }

                JOptionPane.showMessageDialog(null, "Horários gerados e armazenados "
                        + "com sucesso!");

                DataAccessObject.fecharConexao();
            }
        } else {
            //Nível fundamental ou médio.
            //Gerar o horário das turmas.
            DataAccessObject.abrirConexao();
            turmasSelecionadas = DataAccessObject.getTurmasByNivelEnsino(nivelSelecionado);
            ordenarTurmasSelecionadas(); //Organizar as turmas selecionadas
            //pela quantidade de restrições, do maior para o menor.

            for (int i = 0; i < turmasSelecionadas.size(); i++) {
                Turma turma = turmasSelecionadas.get(i); //Turma selecionada.
                if (DataAccessObject.turmaTemHorario(turma.getID())) {
                    //Turma já possui horário cadastrado.
                    Object[] opcoes = {"Sim", "Não"};
                    int opcao = JOptionPane.showOptionDialog(null, "Uma das turmas selecionadas já possui "
                            + "um horário definido. \nPara que o horário seja gerado corretamente, "
                            + "por favor, remova-o primeiro através da opção "
                            + "'Remover horário' localizada no menu 'Gerenciar horários'."
                            + "\nDeseja continuar mesmo assim?",
                            "Horário da turma já cadastrado", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);
                    if (opcao != 0) {
                        //Se não pressionar a opção sim.
                        return; //Interromper execução da geração de horários.
                    }
                }

                ArrayList<Aula> aulas = DataAccessObject.getAulasByIDTurma(turma.getID()); //Aulas que contém essa turma.
                ArrayList<Disciplina> disciplinas = new ArrayList<>(); //Disciplinas da turma.

                //Adicionar as disciplinas das aulas ao array list.
                for (int j = 0; j < aulas.size(); j++) {
                    disciplinas.add(DataAccessObject.getDisciplinaByID(aulas.get(j).getIDDisciplina()));
                }
                //Geração dos horários utilizando o algoritmo genético.
                Algoritmo.setTaxaCrossover(0.5); //50% de chance de realizar o cruzamento.
                Algoritmo.setTaxaMutacao(0.35); //35% de chance de mutar.

                boolean elitismo = true; //Realizar elitismo (preservar melhor elitismo).

                int tamanhoPopulacao = 5; //Quantidade de indivíduos por população.
                int numMaxGeracoes = 30000; //Número máximo de gerações.

                //População inicial aleatória.
                Populacao populacao = new Populacao(tamanhoPopulacao, disciplinas, turma.getID());

                boolean temSolucao = false; //Variável para verificar se há solução.
                int geracao = 1; //Contagem de gerações.

                int reiniciaBanco = 1; //Variável para reiniciar a conexão com o banco a cada 100 gerações.

                //Enquanto não encontrar uma solução ou não atingir o máximo de gerações.
                while (!(temSolucao || geracao > numMaxGeracoes)) {
                    //Criar nova população para substituir a população inicial aleatória.
                    populacao = new Populacao(Algoritmo.gerarNovaGeracao(populacao, elitismo));
                    //Analisar se a nova população possui um indivíduo que é a solução (aptidão = 0).
                    //populacao.getMelhorIndividuo().geraAptidao();

                    System.out.println("Genes: ");
                    for (int j = 0; j < populacao.getMelhorIndividuo().getGenes().length; j++) {
                        System.out.print(populacao.getMelhorIndividuo().getGenes()[j]);
                    }

                    System.out.println(" | Geração = " + geracao + "| Aptidão = " + populacao.getMelhorIndividuo().getAptidao());
                    if (populacao.getMelhorIndividuo().getAptidao() == 0) {
                        //Indivíduo é a solução.
                        //Armazenar os genes do indivíduo (solução) no horário da turma.
                        turma.setHorarioTurma(populacao.getMelhorIndividuo().getGenes());
                        temSolucao = true;
                    }

                    geracao++;
                    if (geracao == reiniciaBanco * 100) {
                        reiniciaBanco++;

                        //Fecha e abre a conexão novamente.
                        DataAccessObject.fecharConexao();
                        DataAccessObject.abrirConexao();
                    }
                }

                //Se já tiver cadastrado um horário da turma antes, remover para que
                //seja inserido um novo horário.
                if (DataAccessObject.turmaTemHorario(turma.getID())) {
                    //Antes de remover, dizer que os professores possuem disponibilidade
                    //nesses horários. 
                    int turmaAcrescimo; //Acréscimo para definir as restrições de acordo com o turno.
                    switch (turma.getTurno()) {
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

                    int[] horario = DataAccessObject.getHorarioTurma(turma.getID()).getHorarioTurma();
                    for (int j = 0; j < horario.length; j++) {
                        if (horario[j] != 0) {
                            //Se não for uma aula vazia, editar restrição do professor.
                            Disciplina disciplina = DataAccessObject.getDisciplinaByID(horario[j]);
                            Professor professor = DataAccessObject.getProfessorByID(disciplina.getIdProfessor());

                            char[] restricoes = professor.getRestricoes();
                            restricoes[j + turmaAcrescimo] = '0'; //Disponibilidade de horário.
                            professor.setRestricoes(restricoes);

                            DataAccessObject.update(professor);
                        }
                    }

                    DataAccessObject.removeHorarioByIDTurma(turma.getID());
                }
                DataAccessObject.insertHorario(turma); //Inserir horário no banco.

                int turmaAcrescimo; //Acréscimo para definir as restrições de acordo com o turno.
                switch (turma.getTurno()) {
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

                //Inserir as novas restrições dos professores, de acordo com o novo horário gerado.
                for (int j = 0; j < turma.getHorarioTurma().length; j++) {
                    if (turma.getHorarioTurma()[j] != 0) {
                        //Se não for uma aula vazia, adicionar restrição ao professor.
                        Disciplina disciplina = DataAccessObject.getDisciplinaByID(turma.getHorarioTurma()[j]);
                        Professor professor = DataAccessObject.getProfessorByID(disciplina.getIdProfessor());

                        char[] restricoes = professor.getRestricoes();
                        restricoes[j + turmaAcrescimo] = '1';
                        professor.setRestricoes(restricoes);

                        DataAccessObject.update(professor);
                    }
                }

                if (geracao >= numMaxGeracoes) {
                    turma.setHorarioTurma(populacao.getMelhorIndividuo().getGenes());
                    JOptionPane.showMessageDialog(null, "Nenhuma solução encontrada para"
                            + " a turma '" + "Curso: " + turma.getCurso() + " | Nível de ensino: "
                            + turma.getNivelEnsino() + " | Turma: " + turma.getNome()
                            + " | Série/Semestre: " + turma.getAno() + " | Turno: " + turma.getTurno()
                            + "'\nArmazenado a solução mais adequada.");
                }
            }

            JOptionPane.showMessageDialog(null, "Horários gerados e armazenados "
                    + "com sucesso!");

            //Limpar campos.
            jComboBoxCurso.removeAllItems();
            jComboBoxTurmas.removeAllItems();
            listModel.clear();

            DataAccessObject.fecharConexao();
        }
    }//GEN-LAST:event_jButtonGerarActionPerformed

    //Organiza as turmas selecionadas pela quantidade de restrições, do maior 
    //para o menor.
    private void ordenarTurmasSelecionadas() {
        int qtdRestricoesTurmaAnterior = 0, qtdRestricoesTurmaAtual = 0;
        boolean trocou;
        do {
            trocou = false;
            for (int i = 1; i < turmasSelecionadas.size(); i++) {
                //Contagem de restrições da turma anterior.
                if (!turmasSelecionadas.get(i - 1).getJanelamentoDisciplinas()) {
                    //Possui restrição de janelamento de disciplinas.
                    qtdRestricoesTurmaAnterior++;
                }
                char[] diasSemana = turmasSelecionadas.get(i - 1).getDiasSemana();
                for (int j = 0; j < diasSemana.length; j++) {
                    if (diasSemana[j] == '0') {
                        //Possui restrição nesse dia.
                        qtdRestricoesTurmaAnterior++;
                    }
                }
                if (turmasSelecionadas.get(i - 1).getAulasGeminadas()
                        || turmasSelecionadas.get(i - 1).getSemAulasGeminadas()) {
                    //Possui restrição de aulas geminadas.
                    qtdRestricoesTurmaAnterior++;
                }

                //Contagem de restrições da turma atual.
                if (!turmasSelecionadas.get(i).getJanelamentoDisciplinas()) {
                    //Possui restrição de janelamento de disciplinas.
                    qtdRestricoesTurmaAtual++;
                }
                diasSemana = turmasSelecionadas.get(i).getDiasSemana();
                for (int j = 0; j < diasSemana.length; j++) {
                    if (diasSemana[j] == '0') {
                        //Possui restrição nesse dia.
                        qtdRestricoesTurmaAtual++;
                    }
                }
                if (turmasSelecionadas.get(i).getAulasGeminadas()
                        || turmasSelecionadas.get(i).getSemAulasGeminadas()) {
                    //Possui restrição de aulas geminadas.
                    qtdRestricoesTurmaAtual++;
                }

                if (qtdRestricoesTurmaAnterior < qtdRestricoesTurmaAtual) {
                    Turma temp = turmasSelecionadas.get(i);
                    turmasSelecionadas.set(i, turmasSelecionadas.get(i - 1));
                    turmasSelecionadas.set(i - 1, temp);
                    trocou = true;
                }
            }
        } while (trocou);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonGerar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonSelecionarCurso;
    private javax.swing.JButton jButtonSelecionarNivelEnsino;
    private javax.swing.JComboBox<String> jComboBoxCurso;
    private javax.swing.JComboBox<String> jComboBoxNivelEnsino;
    private javax.swing.JComboBox<String> jComboBoxTurmas;
    private javax.swing.JLabel jLabelCurso;
    private javax.swing.JLabel jLabelNivelEnsino;
    private javax.swing.JLabel jLabelTurmasCurso;
    private javax.swing.JList<String> jListTurmas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
