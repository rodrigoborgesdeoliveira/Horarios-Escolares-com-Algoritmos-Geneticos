/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import database.DataAccessObject;
import gerenciarhorarios.Aula;
import gerenciarhorarios.Disciplina;
import gerenciarhorarios.Turma;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rodrigo
 */
public class EditarAulaConjunta extends javax.swing.JInternalFrame {

    //Variáveis para controle de turma.
    ArrayList<Turma> turmas = new ArrayList<>();
    ArrayList<Turma> turmasConjuntas = new ArrayList<>();
    Turma turma = null, turmaConjunta = null;

    //Variáveis para controle de disciplina.
    ArrayList<Disciplina> disciplinas = new ArrayList<>();
    Disciplina disciplinaSelecionada = null;

    /**
     * Creates new form EditarAulaConjunta
     */
    public EditarAulaConjunta() {
        initComponents();

        ArrayList<Aula> aulas = DataAccessObject.getAulas();

        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getIDTurmaConjunta() != 0) {
                //Possui turma conjunta.
                turmas.add(DataAccessObject.getTurmaByID(aulas.get(i).getIDTurma()));
            }
        }

        //Adicionar as turmas ao jComboBox.
        for (int i = 0; i < turmas.size(); i++) {
            if (turmas.get(i).getNivelEnsino().equals("Superior")) {
                jComboBoxTurma.addItem("Curso: " + turmas.get(i).getCurso() + " | Nível de ensino: "
                        + turmas.get(i).getNivelEnsino() + " | Turma: " + turmas.get(i).getNome()
                        + " | Semestre: " + turmas.get(i).getAno() + " | Turno: " + turmas.get(i).getTurno());
            } else {
                jComboBoxTurma.addItem("Nível de ensino: "
                        + turmas.get(i).getNivelEnsino() + " | Turma: " + turmas.get(i).getNome()
                        + " | Série: " + turmas.get(i).getAno() + " | Turno: " + turmas.get(i).getTurno());
            }
        }
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
        jComboBoxTurma = new javax.swing.JComboBox<>();
        jButtonSelecionarTurma = new javax.swing.JButton();
        jLabelDisciplinaConjunta = new javax.swing.JLabel();
        jComboBoxDisciplinaConjunta = new javax.swing.JComboBox<>();
        jButtonSelecionarDisciplinaConjunta = new javax.swing.JButton();
        jLabelTurmaConjunta = new javax.swing.JLabel();
        jComboBoxTurmaConjunta = new javax.swing.JComboBox<>();
        jButtonConfirmar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar aula conjunta");

        jLabelTurma.setText("Turma");

        jComboBoxTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurmaActionPerformed(evt);
            }
        });

        jButtonSelecionarTurma.setText("Selecionar");
        jButtonSelecionarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarTurmaActionPerformed(evt);
            }
        });

        jLabelDisciplinaConjunta.setText("Disciplina conjunta");

        jButtonSelecionarDisciplinaConjunta.setText("Selecionar");
        jButtonSelecionarDisciplinaConjunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarDisciplinaConjuntaActionPerformed(evt);
            }
        });

        jLabelTurmaConjunta.setText("Turma conjunta");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDisciplinaConjunta)
                            .addComponent(jLabelTurma)
                            .addComponent(jLabelTurmaConjunta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxTurmaConjunta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxTurma, 0, 426, Short.MAX_VALUE)
                                    .addComponent(jComboBoxDisciplinaConjunta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonSelecionarTurma)
                                    .addComponent(jButtonSelecionarDisciplinaConjunta, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTurma)
                    .addComponent(jComboBoxTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelecionarTurma))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDisciplinaConjunta)
                    .addComponent(jComboBoxDisciplinaConjunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelecionarDisciplinaConjunta))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTurmaConjunta)
                    .addComponent(jComboBoxTurmaConjunta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTurmaActionPerformed

    private void jButtonSelecionarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarTurmaActionPerformed
        DataAccessObject.abrirConexao();

        turma = turmas.get(jComboBoxTurma.getSelectedIndex()); //Turma selecionada.
        ArrayList<Aula> aulas = DataAccessObject.getAulasByIDTurma(turma.getID()); //Aulas que contém essa turma.

        jComboBoxDisciplinaConjunta.removeAllItems(); //Limpa o jComboBox.
        disciplinas.clear(); //Limpar as disciplinas.
        jComboBoxTurmaConjunta.removeAllItems(); //Limpa o jComboBox.
        turmasConjuntas.clear(); //Limpar as turmas conjuntas.

        //Adicionar as disciplinas das aulas ao array list.
        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getIDTurmaConjunta() != 0) {
                //Possui turma conjunta para essa disciplina,
                //fornecer como opção.
                Disciplina disciplina = DataAccessObject.getDisciplinaByID(aulas.get(i).getIDDisciplina());
                disciplinas.add(disciplina);
                jComboBoxDisciplinaConjunta.addItem(disciplina.getNome() + " (Professor(a): "
                        + DataAccessObject.getProfessorByID(disciplina.getIdProfessor()).getNome() + ")");
            }
        }

        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jButtonSelecionarTurmaActionPerformed

    private void jButtonSelecionarDisciplinaConjuntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarDisciplinaConjuntaActionPerformed
        DataAccessObject.abrirConexao();

        jComboBoxTurmaConjunta.removeAllItems(); //Limpar jComboBox.
        turmasConjuntas.clear(); //Limpar turmas conjuntas.

        disciplinaSelecionada = disciplinas
                .get(jComboBoxDisciplinaConjunta.getSelectedIndex());
        ArrayList<Aula> aulas = DataAccessObject.getAulasByIDDisciplina(disciplinaSelecionada.getID()); //Aulas que contém essa disciplina.

        for (int i = 0; i < aulas.size(); i++) {
            if (aulas.get(i).getIDTurma() != turma.getID()) {
                //Turma não é a selecionada, adicionar à lista de possíveis turmas conjuntas.
                turmaConjunta = DataAccessObject.getTurmaByID(aulas.get(i).getIDTurma());
                //Apenas adicionar turmas do mesmo nível de ensino e do mesmo turno.
                if (turma.getNivelEnsino().equals(turmaConjunta.getNivelEnsino()) &&
                        turma.getTurno().equals(turmaConjunta.getTurno())) {
                    turmasConjuntas.add(turmaConjunta);
                }
            }
        }

        //Adicionar as turmas ao jComboBox.
        for (int i = 0; i < turmasConjuntas.size(); i++) {

            if (turmasConjuntas.get(i).getNivelEnsino().equals("Superior")) {
                jComboBoxTurmaConjunta.addItem("Curso: " + turmasConjuntas.get(i).getCurso() + " | Nível de ensino: "
                        + turmasConjuntas.get(i).getNivelEnsino() + " | Turma: " + turmasConjuntas.get(i).getNome()
                        + " | Semestre: " + turmasConjuntas.get(i).getAno() + " | Turno: "
                        + turmasConjuntas.get(i).getTurno());
            } else {
                jComboBoxTurmaConjunta.addItem("Nível de ensino: "
                        + turmasConjuntas.get(i).getNivelEnsino() + " | Turma: " + turmasConjuntas.get(i).getNome()
                        + " | Série: " + turmasConjuntas.get(i).getAno() + " | Turno: "
                        + turmasConjuntas.get(i).getTurno());

            }
        }

        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jButtonSelecionarDisciplinaConjuntaActionPerformed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if(turma == null){
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma turma primeiro.",
                    "Nenhuma turma selecionada", JOptionPane.WARNING_MESSAGE);
            return;
        } else if(disciplinaSelecionada == null){
            JOptionPane.showMessageDialog(null, "Por favor, selecione uma disciplina conjunta primeiro.",
                    "Nenhuma disciplina conjunta selecionada", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DataAccessObject.abrirConexao();

        Aula aula = new Aula();
        aula.setIDDisciplina(disciplinaSelecionada.getID());
        aula.setIDTurma(turma.getID());
        aula.setIDTurmaConjunta(turmasConjuntas.get(jComboBoxTurmaConjunta.getSelectedIndex()).getID());

        DataAccessObject.update(aula);

        JOptionPane.showMessageDialog(null, "Aula conjunta cadastrada com sucesso!");

        jComboBoxDisciplinaConjunta.removeAllItems();
        jComboBoxTurmaConjunta.removeAllItems();
        disciplinas.clear();
        turmasConjuntas.clear();

        DataAccessObject.fecharConexao();
        
        turma = null;
        disciplinaSelecionada = null;
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonSelecionarDisciplinaConjunta;
    private javax.swing.JButton jButtonSelecionarTurma;
    private javax.swing.JComboBox<String> jComboBoxDisciplinaConjunta;
    private javax.swing.JComboBox<String> jComboBoxTurma;
    private javax.swing.JComboBox<String> jComboBoxTurmaConjunta;
    private javax.swing.JLabel jLabelDisciplinaConjunta;
    private javax.swing.JLabel jLabelTurma;
    private javax.swing.JLabel jLabelTurmaConjunta;
    // End of variables declaration//GEN-END:variables
}
