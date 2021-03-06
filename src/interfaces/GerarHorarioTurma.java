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
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTDConstants;

/**
 *
 * @author Rodrigo
 */
public class GerarHorarioTurma extends javax.swing.JInternalFrame {

    ArrayList<Turma> turmas = new ArrayList<>();
    Turma turma = null;
    
    Thread T1;

    /**
     * Creates new form GerarHorario
     */
    public GerarHorarioTurma() {
        initComponents();
        jProgressBarGeracao.setVisible(false);

        turmas = DataAccessObject.getTurmas();

        //Adicionar as turmas ao jComboBox.
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getNivelEnsino().equals("Superior")) {
                jComboBoxTurmas.addItem("Curso: " + turmas.get(i).getCurso() + " | Nível de ensino: "
                        + turmas.get(i).getNivelEnsino() + " | Turma: " + turmas.get(i).getNome()
                        + " | Semestre: " + turmas.get(i).getAno() + " | Turno: " + turmas.get(i).getTurno());
            } else {
                jComboBoxTurmas.addItem("Nível de ensino: "
                        + turmas.get(i).getNivelEnsino() + " | Turma: " + turmas.get(i).getNome()
                        + " | Série: " + turmas.get(i).getAno() + " | Turno: " + turmas.get(i).getTurno());
            }
        }
        
        addInternalFrameListener(new InternalFrameAdapter(){
            public void internalFrameClosing(InternalFrameEvent e) {
                T1.stop();
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTurma = new javax.swing.JLabel();
        jComboBoxTurmas = new javax.swing.JComboBox<>();
        jButtonGerar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableHorario = new javax.swing.JTable();
        jButtonConfirmar = new javax.swing.JButton();
        jProgressBarGeracao = new javax.swing.JProgressBar();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gerar horário por turma");

        jLabelTurma.setText("Turma");

        jButtonGerar.setText("Gerar");
        jButtonGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerarActionPerformed(evt);
            }
        });

        jTableHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableHorario);

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jProgressBarGeracao.setIndeterminate(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelTurma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTurmas, 0, 576, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jProgressBarGeracao, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelTurma))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonGerar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jProgressBarGeracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerarActionPerformed
        jProgressBarGeracao.setVisible(true);
        jButtonGerar.setEnabled(false);
        //Executor executor = java.util.concurrent.Executors.newSingleThreadExecutor();
        T1 = new Thread(new Runnable() {
            public void run() {

                DataAccessObject.abrirConexao();

                turma = turmas.get(jComboBoxTurmas.getSelectedIndex()); //Turma selecionada.
                if (DataAccessObject.turmaTemHorario(turma.getID())) {
                    //Turma já possui horário cadastrado.
                    Object[] opcoes = {"Sim", "Não"};
                    int opcao = JOptionPane.showOptionDialog(null, "A turma selecionada já possui "
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

                //Limpar o conteúdo da tabela.
                DefaultTableModel modelo = (DefaultTableModel) jTableHorario.getModel();
                for (int i = 0; i < 6; i++) { //Colunas da tabela.
                    for (int j = 0; j < 6; j++) { //Linhas da tabela.
                        modelo.setValueAt("", j, i);
                    }
                }

                ArrayList<Aula> aulas = DataAccessObject.getAulasByIDTurma(turma.getID()); //Aulas que contém essa turma.
                ArrayList<Disciplina> disciplinas = new ArrayList<>(); //Disciplinas da turma.

                //Adicionar as disciplinas das aulas ao array list.
                for (int i = 0; i < aulas.size(); i++) {
                    disciplinas.add(DataAccessObject.getDisciplinaByID(aulas.get(i).getIDDisciplina()));
                }

                long inicio = System.nanoTime();
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

                    System.out.println("Genes: ");
                    for (int i = 0; i < populacao.getMelhorIndividuo().getGenes().length; i++) {
                        System.out.print(populacao.getMelhorIndividuo().getGenes()[i] + " ");
                    }

                    System.out.println("| Geração = " + geracao + "| Aptidão = " + populacao.getMelhorIndividuo().getAptidao());
                    //Analisar se a nova população possui um indivíduo que é a solução (aptidão = 0).
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
                long fim = System.nanoTime();
                jProgressBarGeracao.setVisible(false);
                jButtonGerar.setEnabled(true);
                long duracao = (fim - inicio) / 1000000000; //Duraçao em segundos.
                if (duracao < 60) {
                    System.out.println("Gerado em: " + duracao + " segundos.");
                } else {
                    //Passou de um minuto.
                    int minutos = (int) (duracao / 60);
                    int segundos = (int) (duracao - minutos * 60);
                    System.out.println("Gerado em: " + minutos + " minutos e " + segundos + " segundos.");
                }
                if (geracao >= numMaxGeracoes) {
                    turma.setHorarioTurma(populacao.getMelhorIndividuo().getGenes());
                    JOptionPane.showMessageDialog(null, "Nenhuma solução encontrada."
                            + "\nExibindo solução mais adequada.");
                }

                //Modelo para manipular tabela.
                modelo = (DefaultTableModel) jTableHorario.getModel();

                //Adicionar disciplinas à tabela.
                int posicaoHorario = 0; //Contador da posição no horário.
                if (turma.getHorarioTurma().length == 36) { //Matutino ou vespertino.
                    for (int i = 0; i < 6; i++) { //Colunas da tabela.
                        for (int j = 0; j < 6; j++) { //Linhas da tabela.
                            if (turma.getHorarioTurma()[posicaoHorario] != 0) {
                                modelo.setValueAt(DataAccessObject.getDisciplinaByID(
                                        turma.getHorarioTurma()[posicaoHorario]).getNome(), j, i);
                            }
                            posicaoHorario++;
                        }
                    }
                } else { //Noturno
                    for (int i = 0; i < 6; i++) { //Colunas da tabela.
                        for (int j = 0; j < 4; j++) { //Linhas da tabela.
                            if (turma.getHorarioTurma()[posicaoHorario] != 0) {
                                modelo.setValueAt(DataAccessObject.getDisciplinaByID(
                                        turma.getHorarioTurma()[posicaoHorario]).getNome(), j, i);
                            }
                            posicaoHorario++;
                        }
                    }
                }

                DataAccessObject.fecharConexao();
            }
        });
        
        T1.start();
    }//GEN-LAST:event_jButtonGerarActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        DataAccessObject.abrirConexao();

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
            for (int i = 0; i < horario.length; i++) {
                if (horario[i] != 0) {
                    //Se não for uma aula vazia, editar restrição do professor.
                    Disciplina disciplina = DataAccessObject.getDisciplinaByID(horario[i]);
                    Professor professor = DataAccessObject.getProfessorByID(disciplina.getIdProfessor());

                    char[] restricoes = professor.getRestricoes();
                    restricoes[i + turmaAcrescimo] = '0'; //Disponibilidade de horário.
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
        for (int i = 0; i < turma.getHorarioTurma().length; i++) {
            if (turma.getHorarioTurma()[i] != 0) {
                //Se não for uma aula vazia, adicionar restrição ao professor.
                Disciplina disciplina = DataAccessObject.getDisciplinaByID(turma.getHorarioTurma()[i]);
                Professor professor = DataAccessObject.getProfessorByID(disciplina.getIdProfessor());

                char[] restricoes = professor.getRestricoes();
                restricoes[i + turmaAcrescimo] = '1';
                professor.setRestricoes(restricoes);

                DataAccessObject.update(professor);
            }
        }

        JOptionPane.showMessageDialog(null, "Horário cadastrado com sucesso!");

        //Limpar o conteúdo da tabela.
        DefaultTableModel modelo = (DefaultTableModel) jTableHorario.getModel();
        for (int i = 0; i < 6; i++) { //Colunas da tabela.
            for (int j = 0; j < 6; j++) { //Linhas da tabela.
                modelo.setValueAt("", j, i);
            }
        }

        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonGerar;
    private javax.swing.JComboBox<String> jComboBoxTurmas;
    private javax.swing.JLabel jLabelTurma;
    private javax.swing.JProgressBar jProgressBarGeracao;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableHorario;
    // End of variables declaration//GEN-END:variables
}
