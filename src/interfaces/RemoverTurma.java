/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import database.DataAccessObject;
import gerenciarhorarios.Aula;
import gerenciarhorarios.Disciplina;
import gerenciarhorarios.Professor;
import gerenciarhorarios.Turma;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rodrigo
 */
public class RemoverTurma extends javax.swing.JInternalFrame {

    ArrayList<Turma> turmas = new ArrayList<>(); //Turmas cadastradas.

    Turma turma = null; //Turma selecionada.

    /**
     * Creates new form RemoverTurma
     */
    public RemoverTurma() {
        initComponents();

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
        jButtonConfirmar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabelTurma.setText("Turma");

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
                        .addGap(0, 457, Short.MAX_VALUE)
                        .addComponent(jButtonConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTurma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTurmas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTurma)
                    .addComponent(jComboBoxTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButtonConfirmar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfirmarActionPerformed
        DataAccessObject.abrirConexao();

        turma = turmas.get(jComboBoxTurmas.getSelectedIndex()); //Turma selecionada.
        ArrayList<Aula> aulas = DataAccessObject.getAulasByIDTurma(turma.getID()); //Aulas que contém essa turma.

        for (int i = 0; i < aulas.size(); i++) {
            //Remover as aulas da turma.
            DataAccessObject.remove(aulas.get(i));

            //Verificar se turma atual é turma conjunta de alguma outra turma
            //na disciplina atual.
            ArrayList<Integer> idsTurmas = DataAccessObject.
                    getIDsTurmasByIDTurmaConjuntaIDDisciplina(turma.getID(), aulas.get(i).getIDDisciplina());
            //Remover turma do campo turma conjunta de outras turmas para 
            //essa disciplina.
            if (!idsTurmas.isEmpty()) {
                for (int j = 0; j < idsTurmas.size(); j++) {
                    Aula aula = new Aula();
                    aula.setIDTurma(idsTurmas.get(j));
                    aula.setIDDisciplina(aulas.get(i).getIDDisciplina());
                    aula.setIDTurmaConjunta(0);

                    DataAccessObject.update(aula);
                }
            }
        }

        //Se já tiver cadastrado um horário da turma antes, remover e editar as
        //restrições dos professores.
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
            //Apaga o horário da turma.
            DataAccessObject.removeHorarioByIDTurma(turma.getID());
        }
        
        DataAccessObject.remove(turma); //Remover a turma da tabela turma.

        JOptionPane.showMessageDialog(null, "Turma removida com sucesso!");

        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jButtonConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfirmar;
    private javax.swing.JComboBox<String> jComboBoxTurmas;
    private javax.swing.JLabel jLabelTurma;
    // End of variables declaration//GEN-END:variables
}
