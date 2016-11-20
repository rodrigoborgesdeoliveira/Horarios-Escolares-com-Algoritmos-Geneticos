/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import database.DataAccessObject;
import gerenciarhorarios.Disciplina;
import gerenciarhorarios.Professor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rodrigo
 */
public class DefinirIndisponibilidadesProfessor extends javax.swing.JInternalFrame {

    ArrayList<Professor> professores = null;
    
    Professor professor = null; //Professor selecionado.

    /**
     * Creates new form DefinirIndisponibilidadesProfessor
     */
    public DefinirIndisponibilidadesProfessor() {
        initComponents();

        DataAccessObject.abrirConexao();
        professores = DataAccessObject.getProfessores();
        DataAccessObject.fecharConexao();

        //Adiciona o nome dos professores ao jComboBox.
        for (int i = 0; i < professores.size(); i++) {
            jComboBoxProfessor.addItem(professores.get(i).getNome());
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

        jComboBoxProfessor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVespertino = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButtonConfirmar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMatutino = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableNoturno = new javax.swing.JTable();
        jButtonSelecionar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Definir indisponibilidades do professor");

        jLabel1.setText("Professor");

        jLabel2.setText("Matutino");

        jTableVespertino.setModel(new javax.swing.table.DefaultTableModel(
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
                java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVespertino);

        jLabel3.setText("Selecione as caixas de seleção abaixo para informar as restrições do professor selecionado no campo acima.");

        jButtonConfirmar.setText("Confirmar");
        jButtonConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfirmarActionPerformed(evt);
            }
        });

        jLabel4.setText("Vespertino");

        jTableMatutino.setModel(new javax.swing.table.DefaultTableModel(
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
                java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableMatutino);

        jLabel5.setText("Noturno");

        jTableNoturno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableNoturno);

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonSelecionar))
                                    .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelecionar))
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConfirmar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if(professor == null){
            JOptionPane.showMessageDialog(null, "Por favor, selecione um professor primeiro.",
                    "Nenhum professor selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DataAccessObject.abrirConexao();

        char[] restricoes = professor.getRestricoes(); //Restrições atuais do professor.
        int posRestricao = 0; //Posição da restrição a ser definida.

        DefaultTableModel modelo = (DefaultTableModel) jTableMatutino.getModel(); //Modelo da tabela matutino.

        //Definição das restrições do turno matutino.
        for (int i = 0; i < 6; i++) { //Colunas da tabela.
            for (int j = 0; j < 6; j++) { //Linhas da tabela.
                if ((Boolean) modelo.getValueAt(j, i) == null) {
                    //Se for nulo, transformar em false.
                    modelo.setValueAt(false, j, i);
                }
                if ((Boolean) modelo.getValueAt(j, i)) {
                    //Há restrição nessa posição.
                    restricoes[posRestricao] = '1';
                } else { //Se nulo ou falso.
                    //Não há restrição nessa posição.
                    restricoes[posRestricao] = '0';
                }
                posRestricao++;
                modelo.setValueAt(false, j, i);
            }
        }

        modelo = (DefaultTableModel) jTableVespertino.getModel(); //Modelo da tabela vespertino.

        //Definição das restrições do turno vespertino.        
        for (int i = 0; i < 6; i++) { //Colunas da tabela.
            for (int j = 0; j < 6; j++) { //Linhas da tabela.
                if ((Boolean) modelo.getValueAt(j, i) == null) {
                    //Se for nulo, transformar em false.
                    modelo.setValueAt(false, j, i);
                }
                if ((Boolean) modelo.getValueAt(j, i)) {
                    //Há restrição nessa posição.
                    restricoes[posRestricao] = '1';
                } else { //Se nulo ou falso.
                    //Não há restrição nessa posição.
                    restricoes[posRestricao] = '0';
                }
                posRestricao++;
                modelo.setValueAt(false, j, i);
            }
        }

        modelo = (DefaultTableModel) jTableNoturno.getModel(); //Modelo da tabela noturno.

        //Definição das restrições do turno noturno.
        for (int i = 0; i < 6; i++) { //Colunas da tabela.
            for (int j = 0; j < 4; j++) { //Linhas da tabela.
                if ((Boolean) modelo.getValueAt(j, i) == null) {
                    //Se for nulo, transformar em false.
                    modelo.setValueAt(false, j, i);
                }
                if ((Boolean) modelo.getValueAt(j, i)) {
                    //Há restrição nessa posição.
                    restricoes[posRestricao] = '1';
                } else { //Se nulo ou falso.
                    //Não há restrição nessa posição.
                    restricoes[posRestricao] = '0';
                }
                posRestricao++;
                modelo.setValueAt(false, j, i);
            }
        }

        //Definir restrições de acordo com horários já alocados.
        ArrayList<Disciplina> disciplinas = DataAccessObject.getDisciplinasByIDProfessor(professor.getID());
        for (int i = 0; i < disciplinas.size(); i++) {
            ArrayList<Integer> posicoesHorario = DataAccessObject.
                    getPosicoesHorarioByIDDisciplina(disciplinas.get(i).getID());
            
            //Definir restrições.
            for (int j = 0; j < posicoesHorario.size(); j++) {
                restricoes[posicoesHorario.get(j)] = '1';                
            }
        }
        
        professor.setRestricoes(restricoes); //Define as novas restrições do professor.
        DataAccessObject.update(professor); //Atualiza o professor no banco de dados.

        JOptionPane.showMessageDialog(null, "Restrições atualizadas com sucesso!");
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        professor = professores.get(jComboBoxProfessor.getSelectedIndex());
        
        char[] restricoes = professor.getRestricoes(); //Restrições atuais do professor.
        int posRestricao = 0; //Posição da restrição a ser definida.

        DefaultTableModel modelo = (DefaultTableModel) jTableMatutino.getModel(); //Modelo da tabela matutino.
        
        //Definição das restrições do turno matutino.
        for (int i = 0; i < 6; i++) { //Colunas da tabela.
            for (int j = 0; j < 6; j++) { //Linhas da tabela.
                if (restricoes[posRestricao] == '1') {
                    //Há restrição nessa posição.
                    modelo.setValueAt(true, j, i);
                } else { 
                    //Não há restrição nessa posição.
                    modelo.setValueAt(false, j, i);
                }
                posRestricao++;
            }
        }

        modelo = (DefaultTableModel) jTableVespertino.getModel(); //Modelo da tabela vespertino.

        //Definição das restrições do turno vespertino.
        for (int i = 0; i < 6; i++) { //Colunas da tabela.
            for (int j = 0; j < 6; j++) { //Linhas da tabela.
                if (restricoes[posRestricao] == '1') {
                    //Há restrição nessa posição.
                    modelo.setValueAt(true, j, i);
                } else { 
                    //Não há restrição nessa posição.
                    modelo.setValueAt(false, j, i);
                }
                posRestricao++;
            }
        }

        modelo = (DefaultTableModel) jTableNoturno.getModel(); //Modelo da tabela noturno.

        //Definição das restrições do turno noturno.
        for (int i = 0; i < 6; i++) { //Colunas da tabela.
            for (int j = 0; j < 4; j++) { //Linhas da tabela.
                if (restricoes[posRestricao] == '1') {
                    //Há restrição nessa posição.
                    modelo.setValueAt(true, j, i);
                } else { 
                    //Não há restrição nessa posição.
                    modelo.setValueAt(false, j, i);
                }
                posRestricao++;
            }
        }
    }//GEN-LAST:event_jButtonSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JComboBox<String> jComboBoxProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableMatutino;
    private javax.swing.JTable jTableNoturno;
    private javax.swing.JTable jTableVespertino;
    // End of variables declaration//GEN-END:variables
}
