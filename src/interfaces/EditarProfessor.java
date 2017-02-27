/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import database.DataAccessObject;
import gerenciarhorarios.Professor;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class EditarProfessor extends javax.swing.JInternalFrame {

    ArrayList<Professor> professores = null; //Lista de professores cadastrados.
    Professor professor = null; //Professor selecionado.

    /**
     * Creates new form EditarProfessor
     */
    public EditarProfessor() {
        initComponents();

        DataAccessObject.abrirConexao();
        professores = DataAccessObject.getProfessores();
        DataAccessObject.fecharConexao();

        //Adiciona o nome dos professores ao jComboBox.
        for (int i = 0; i < professores.size(); i++) {
            jComboBoxProfessores.addItem(professores.get(i).getNome());
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

        jLabelProfessor = new javax.swing.JLabel();
        jComboBoxProfessores = new javax.swing.JComboBox<>();
        jButtonSelecionar = new javax.swing.JButton();
        jLabelNomeProfessor = new javax.swing.JLabel();
        jTextFieldNomeProfessor = new javax.swing.JTextField();
        jButtonConfirmar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar Professor");

        jLabelProfessor.setText("Professor");

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jLabelNomeProfessor.setText("Nome completo do professor");

        jTextFieldNomeProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeProfessorActionPerformed(evt);
            }
        });
        jTextFieldNomeProfessor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNomeProfessorKeyPressed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelProfessor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProfessores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSelecionar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelNomeProfessor)
                        .addGap(4, 4, 4)
                        .addComponent(jTextFieldNomeProfessor)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelProfessor)
                    .addComponent(jComboBoxProfessores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSelecionar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabelNomeProfessor))
                    .addComponent(jTextFieldNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeProfessorActionPerformed

    private void jTextFieldNomeProfessorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNomeProfessorKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (professor == null) {
                JOptionPane.showMessageDialog(null, "Por favor, selecione um professor primeiro.",
                        "Nenhum professor selecionado", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String nomeProfessor = jTextFieldNomeProfessor.getText();

            nomeProfessor = nomeProfessor.trim().replaceAll("\\s+", " "); //Remover espaços em branco
            //no início e final da string, e tratar espaços duplicados no meio da string.

            //Tratar casos em que o campo Nome completo do professor está vazio.
            if (nomeProfessor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O campo 'Nome completo do "
                        + "professor' não pode ser vazio", "Campo vazio", JOptionPane.ERROR_MESSAGE);
                jTextFieldNomeProfessor.requestFocus();
                return;
            }

            professor.setNome(nomeProfessor);

            DataAccessObject.abrirConexao();
            DataAccessObject.update(professor); //Inserir no banco de dados.

            //Atualizar professores para corresponder ao novo professor.
            professores = DataAccessObject.getProfessores();
            DataAccessObject.fecharConexao();

            JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");
            jTextFieldNomeProfessor.setText("");

            //Atualizar o jComboBox para corresponder ao novo professor.
            jComboBoxProfessores.removeAllItems();
            //Adiciona o nome dos professores ao jComboBox.
            for (int i = 0; i < professores.size(); i++) {
                jComboBoxProfessores.addItem(professores.get(i).getNome());
            }

            jTextFieldNomeProfessor.requestFocus();
            
            professor = null;
        }
    }//GEN-LAST:event_jTextFieldNomeProfessorKeyPressed

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        if (professor == null) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione um professor primeiro.",
                    "Nenhum professor selecionado", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nomeProfessor = jTextFieldNomeProfessor.getText();

        nomeProfessor = nomeProfessor.trim().replaceAll("\\s+", " "); //Remover espaços em branco
        //no início e final da string, e tratar espaços duplicados no meio da string.

        //Tratar casos em que o campo Nome completo do professor está vazio.
        if (nomeProfessor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "O campo 'Nome completo do "
                    + "professor' não pode ser vazio", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            jTextFieldNomeProfessor.requestFocus();
            return;
        }

        professor.setNome(nomeProfessor);

        DataAccessObject.abrirConexao();
        DataAccessObject.update(professor); //Inserir no banco de dados.

        //Atualizar professores para corresponder ao novo professor.
        professores = DataAccessObject.getProfessores();
        DataAccessObject.fecharConexao();

        JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso!");
        jTextFieldNomeProfessor.setText("");

        //Atualizar o jComboBox para corresponder ao novo professor.
        jComboBoxProfessores.removeAllItems();
        //Adiciona o nome dos professores ao jComboBox.
        for (int i = 0; i < professores.size(); i++) {
            jComboBoxProfessores.addItem(professores.get(i).getNome());
        }

        jTextFieldNomeProfessor.requestFocus();
        
        professor = null;
    }//GEN-LAST:event_jButtonConfirmarActionPerformed

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        professor = professores.get(jComboBoxProfessores.getSelectedIndex());

        jTextFieldNomeProfessor.setText(professor.getNome());
    }//GEN-LAST:event_jButtonSelecionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JComboBox<String> jComboBoxProfessores;
    private javax.swing.JLabel jLabelNomeProfessor;
    private javax.swing.JLabel jLabelProfessor;
    private javax.swing.JTextField jTextFieldNomeProfessor;
    // End of variables declaration//GEN-END:variables
}
