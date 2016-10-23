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
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Rodrigo
 */
public class ListarTurmas extends javax.swing.JInternalFrame {

    ArrayList<Turma> turmas = new ArrayList<>();
    DefaultListModel listModel = new DefaultListModel(); //Modelo para o JList.
    ArrayList<Aula> aulas = new ArrayList<>(); //Aulas da turma.

    /**
     * Creates new form ListarTurmas
     */
    public ListarTurmas() {
        initComponents();

        DataAccessObject.abrirConexao();

        jListTurmas.setModel(listModel);

        turmas = DataAccessObject.getTurmas();

        //Adicionar as turmas ao jComboBox.
        for (int i = 0; i < turmas.size(); i++) {
            aulas = DataAccessObject.getAulasByIDTurma(turmas.get(i).getID()); //Aulas que contém essa turma.

            if (turmas.get(i).getNivelEnsino().equals("Superior")) {
                listModel.addElement("Curso: " + turmas.get(i).getCurso() + " | Nível de ensino: "
                        + turmas.get(i).getNivelEnsino() + " | Turma: " + turmas.get(i).getNome()
                        + " | Semestre: " + turmas.get(i).getAno() + " | Turno: " + turmas.get(i).getTurno());
            } else {
                listModel.addElement("Nível de ensino: "
                        + turmas.get(i).getNivelEnsino() + " | Turma: " + turmas.get(i).getNome()
                        + " | Série: " + turmas.get(i).getAno() + " | Turno: " + turmas.get(i).getTurno());
            }
            
            listModel.addElement("Disciplinas:");
            //Adicionar as disciplinas que a turma possui ao jList.
            for (int j = 0; j < aulas.size(); j++) {
                Disciplina disciplina = DataAccessObject.getDisciplinaByID(aulas.get(j).getIDDisciplina());
                listModel.addElement("      -> " + disciplina.getNome() + " (Professor(a): "
                        + DataAccessObject.getProfessorByID(disciplina.getIdProfessor()).getNome() + ")");
            }
            
            listModel.addElement("_____________________________________________"
                    + "________________________________________________________"); //Adicionar uma quebra de linha à lista.
        }

        DataAccessObject.fecharConexao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListTurmas = new javax.swing.JList<>();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listar turmas");

        jScrollPane1.setViewportView(jListTurmas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jListTurmas;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
