/*
 * Arquivo referente à criação da tela principal.
 */
package interfaces;

import database.DataAccessObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.DesktopPaneUI;
import javax.swing.plaf.InternalFrameUI;

/**
 *
 * @author Rodrigo
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Tela
     */
    public Principal() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jDesktopPanePrincipal = new javax.swing.JDesktopPane();
        jMenuBarPrincipal = new javax.swing.JMenuBar();
        jMenuGerenciarProfessores = new javax.swing.JMenu();
        jMenuItemCadastrarProfessor = new javax.swing.JMenuItem();
        jMenuItemEditarProfessor = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuGerenciarDisciplinas = new javax.swing.JMenu();
        jMenuItemCadastrarDisciplina = new javax.swing.JMenuItem();
        jMenuItemEditarDisciplina = new javax.swing.JMenuItem();
        jMenuItemListarDisciplinas = new javax.swing.JMenuItem();
        jMenuItemRemoverDisciplina = new javax.swing.JMenuItem();
        jMenuGerenciarTurmas = new javax.swing.JMenu();
        jMenuItemCadastrarTurma = new javax.swing.JMenuItem();
        jMenuItemEditarTurma = new javax.swing.JMenuItem();
        jMenuItemListarTurmas = new javax.swing.JMenuItem();
        jMenuItemRemoverTurma = new javax.swing.JMenuItem();
        jMenuGerenciarRestricoes = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemDefinirIndisponibilidadesProfessor = new javax.swing.JMenuItem();
        jMenuItemHabilitarDesabilitarRestricoesTurma = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemExibirIndisponibilidadesProfessor = new javax.swing.JMenuItem();
        jMenuItemExibirRestricoesTurma = new javax.swing.JMenuItem();
        jMenuGerenciarAulasConjuntas = new javax.swing.JMenu();
        jMenuItemAdicionarAulaConjunta = new javax.swing.JMenuItem();
        jMenuItemEditarAulaConjunta = new javax.swing.JMenuItem();
        jMenuItemListarAulasConjuntas = new javax.swing.JMenuItem();
        jMenuItemRemoverAulaConjunta = new javax.swing.JMenuItem();
        jMenuGerenciarHorarios = new javax.swing.JMenu();
        jMenuItemGerarHorarioCurso = new javax.swing.JMenuItem();
        jMenuItemGerarHorarioTurma = new javax.swing.JMenuItem();
        jMenuItemExibirHorario = new javax.swing.JMenuItem();
        jMenuItemRemoverHorário = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gerenciamento de horários escolares");

        jDesktopPanePrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPanePrincipalLayout = new javax.swing.GroupLayout(jDesktopPanePrincipal);
        jDesktopPanePrincipal.setLayout(jDesktopPanePrincipalLayout);
        jDesktopPanePrincipalLayout.setHorizontalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
        );
        jDesktopPanePrincipalLayout.setVerticalGroup(
            jDesktopPanePrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        jMenuGerenciarProfessores.setText("Gerenciar professores");

        jMenuItemCadastrarProfessor.setText("Cadastrar professor");
        jMenuItemCadastrarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarProfessorActionPerformed(evt);
            }
        });
        jMenuGerenciarProfessores.add(jMenuItemCadastrarProfessor);

        jMenuItemEditarProfessor.setText("Editar professor");
        jMenuItemEditarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarProfessorActionPerformed(evt);
            }
        });
        jMenuGerenciarProfessores.add(jMenuItemEditarProfessor);

        jMenuItem6.setText("Listar professores");
        jMenuGerenciarProfessores.add(jMenuItem6);

        jMenuItem7.setText("Remover professor");
        jMenuGerenciarProfessores.add(jMenuItem7);

        jMenuBarPrincipal.add(jMenuGerenciarProfessores);

        jMenuGerenciarDisciplinas.setText("Gerenciar disciplinas");

        jMenuItemCadastrarDisciplina.setText("Cadastrar disciplina");
        jMenuItemCadastrarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarDisciplinaActionPerformed(evt);
            }
        });
        jMenuGerenciarDisciplinas.add(jMenuItemCadastrarDisciplina);

        jMenuItemEditarDisciplina.setText("Editar disciplina");
        jMenuItemEditarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarDisciplinaActionPerformed(evt);
            }
        });
        jMenuGerenciarDisciplinas.add(jMenuItemEditarDisciplina);

        jMenuItemListarDisciplinas.setText("Listar disciplinas");
        jMenuItemListarDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarDisciplinasActionPerformed(evt);
            }
        });
        jMenuGerenciarDisciplinas.add(jMenuItemListarDisciplinas);

        jMenuItemRemoverDisciplina.setText("Remover disciplina");
        jMenuItemRemoverDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverDisciplinaActionPerformed(evt);
            }
        });
        jMenuGerenciarDisciplinas.add(jMenuItemRemoverDisciplina);

        jMenuBarPrincipal.add(jMenuGerenciarDisciplinas);

        jMenuGerenciarTurmas.setText("Gerenciar turmas");

        jMenuItemCadastrarTurma.setText("Cadastrar turma");
        jMenuItemCadastrarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarTurmaActionPerformed(evt);
            }
        });
        jMenuGerenciarTurmas.add(jMenuItemCadastrarTurma);

        jMenuItemEditarTurma.setText("Editar turma");
        jMenuItemEditarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarTurmaActionPerformed(evt);
            }
        });
        jMenuGerenciarTurmas.add(jMenuItemEditarTurma);

        jMenuItemListarTurmas.setText("Listar turmas");
        jMenuItemListarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarTurmasActionPerformed(evt);
            }
        });
        jMenuGerenciarTurmas.add(jMenuItemListarTurmas);

        jMenuItemRemoverTurma.setText("Remover turma");
        jMenuItemRemoverTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverTurmaActionPerformed(evt);
            }
        });
        jMenuGerenciarTurmas.add(jMenuItemRemoverTurma);

        jMenuBarPrincipal.add(jMenuGerenciarTurmas);

        jMenuGerenciarRestricoes.setText("Gerenciar restrições");

        jMenu1.setText("Definir restrições");

        jMenuItemDefinirIndisponibilidadesProfessor.setText("Definir indisponibilidades do professor");
        jMenuItemDefinirIndisponibilidadesProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDefinirIndisponibilidadesProfessorActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemDefinirIndisponibilidadesProfessor);

        jMenuItemHabilitarDesabilitarRestricoesTurma.setText("Habilitar/desabilitar restrições de uma turma");
        jMenuItemHabilitarDesabilitarRestricoesTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemHabilitarDesabilitarRestricoesTurmaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemHabilitarDesabilitarRestricoesTurma);

        jMenuGerenciarRestricoes.add(jMenu1);

        jMenu2.setText("Listar restrições");

        jMenuItemExibirIndisponibilidadesProfessor.setText("Exibir indisponibilidades de um professor");
        jMenuItemExibirIndisponibilidadesProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExibirIndisponibilidadesProfessorActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemExibirIndisponibilidadesProfessor);

        jMenuItemExibirRestricoesTurma.setText("Exibir restrições de uma turma");
        jMenuItemExibirRestricoesTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExibirRestricoesTurmaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemExibirRestricoesTurma);

        jMenuGerenciarRestricoes.add(jMenu2);

        jMenuBarPrincipal.add(jMenuGerenciarRestricoes);

        jMenuGerenciarAulasConjuntas.setText("Gerenciar aulas conjuntas");

        jMenuItemAdicionarAulaConjunta.setText("Adicionar aula conjunta");
        jMenuItemAdicionarAulaConjunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAdicionarAulaConjuntaActionPerformed(evt);
            }
        });
        jMenuGerenciarAulasConjuntas.add(jMenuItemAdicionarAulaConjunta);

        jMenuItemEditarAulaConjunta.setText("Editar aula conjunta");
        jMenuItemEditarAulaConjunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarAulaConjuntaActionPerformed(evt);
            }
        });
        jMenuGerenciarAulasConjuntas.add(jMenuItemEditarAulaConjunta);

        jMenuItemListarAulasConjuntas.setText("Listar aulas conjuntas");
        jMenuItemListarAulasConjuntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarAulasConjuntasActionPerformed(evt);
            }
        });
        jMenuGerenciarAulasConjuntas.add(jMenuItemListarAulasConjuntas);

        jMenuItemRemoverAulaConjunta.setText("Remover aula conjunta");
        jMenuItemRemoverAulaConjunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverAulaConjuntaActionPerformed(evt);
            }
        });
        jMenuGerenciarAulasConjuntas.add(jMenuItemRemoverAulaConjunta);

        jMenuBarPrincipal.add(jMenuGerenciarAulasConjuntas);

        jMenuGerenciarHorarios.setText("Gerenciar horários");

        jMenuItemGerarHorarioCurso.setText("Gerar horário por curso");
        jMenuItemGerarHorarioCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerarHorarioCursoActionPerformed(evt);
            }
        });
        jMenuGerenciarHorarios.add(jMenuItemGerarHorarioCurso);

        jMenuItemGerarHorarioTurma.setText("Gerar horário por turma");
        jMenuItemGerarHorarioTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerarHorarioTurmaActionPerformed(evt);
            }
        });
        jMenuGerenciarHorarios.add(jMenuItemGerarHorarioTurma);

        jMenuItemExibirHorario.setText("Exibir horário");
        jMenuItemExibirHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExibirHorarioActionPerformed(evt);
            }
        });
        jMenuGerenciarHorarios.add(jMenuItemExibirHorario);

        jMenuItemRemoverHorário.setText("Remover horário");
        jMenuItemRemoverHorário.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRemoverHorárioActionPerformed(evt);
            }
        });
        jMenuGerenciarHorarios.add(jMenuItemRemoverHorário);

        jMenuBarPrincipal.add(jMenuGerenciarHorarios);

        setJMenuBar(jMenuBarPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanePrincipal)
        );

        setBounds(0, 0, 889, 538);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastrarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarDisciplinaActionPerformed
        DataAccessObject.abrirConexao();
        if (DataAccessObject.getProfessores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "um professor primeiro.", "Nenhum professor cadastrado", JOptionPane.ERROR_MESSAGE);
        } else {
            CadastrarDisciplina cadastrarDisciplina = new CadastrarDisciplina();
            jDesktopPanePrincipal.add(cadastrarDisciplina);
            cadastrarDisciplina.setVisible(true);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemCadastrarDisciplinaActionPerformed

    private void jMenuItemCadastrarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarProfessorActionPerformed
        CadastrarProfessor cadastrarProfessor = new CadastrarProfessor();
        jDesktopPanePrincipal.add(cadastrarProfessor);
        cadastrarProfessor.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarProfessorActionPerformed

    private void jMenuItemEditarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarDisciplinaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getDisciplinas().isEmpty()) {
            EditarDisciplina editarDisciplina = new EditarDisciplina();
            jDesktopPanePrincipal.add(editarDisciplina);
            editarDisciplina.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma disciplina primeiro.", "Nenhuma disciplina cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemEditarDisciplinaActionPerformed

    private void jMenuItemListarDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarDisciplinasActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getDisciplinas().isEmpty()) {
            ListarDisciplinas listarDisciplinas = new ListarDisciplinas();
            jDesktopPanePrincipal.add(listarDisciplinas);
            listarDisciplinas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma disciplina primeiro.", "Nenhuma disciplina cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemListarDisciplinasActionPerformed

    private void jMenuItemCadastrarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarTurmaActionPerformed
        CadastrarTurma cadastrarTurma = new CadastrarTurma();
        jDesktopPanePrincipal.add(cadastrarTurma);
        cadastrarTurma.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarTurmaActionPerformed

    private void jMenuItemGerarHorarioTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerarHorarioTurmaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            GerarHorarioTurma gerarHorario = new GerarHorarioTurma();
            jDesktopPanePrincipal.add(gerarHorario);
            gerarHorario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemGerarHorarioTurmaActionPerformed

    private void jMenuItemDefinirIndisponibilidadesProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDefinirIndisponibilidadesProfessorActionPerformed
        DataAccessObject.abrirConexao();
        if (DataAccessObject.getProfessores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "um professor primeiro.", "Nenhum professor cadastrado", JOptionPane.ERROR_MESSAGE);
        } else {
            DefinirIndisponibilidadesProfessor definirIndisponibilidadesProfessor
                    = new DefinirIndisponibilidadesProfessor();
            jDesktopPanePrincipal.add(definirIndisponibilidadesProfessor);
            definirIndisponibilidadesProfessor.setVisible(true);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemDefinirIndisponibilidadesProfessorActionPerformed

    private void jMenuItemRemoverHorárioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverHorárioActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            RemoverHorario removerHorario = new RemoverHorario();
            jDesktopPanePrincipal.add(removerHorario);
            removerHorario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos"
                    + " uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemRemoverHorárioActionPerformed

    private void jMenuItemGerarHorarioCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerarHorarioCursoActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            GerarHorarioCurso gerarHorario = new GerarHorarioCurso();
            jDesktopPanePrincipal.add(gerarHorario);
            gerarHorario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemGerarHorarioCursoActionPerformed

    private void jMenuItemExibirHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExibirHorarioActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            ExibirHorario exibirHorario = new ExibirHorario();
            jDesktopPanePrincipal.add(exibirHorario);
            exibirHorario.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemExibirHorarioActionPerformed

    private void jMenuItemHabilitarDesabilitarRestricoesTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemHabilitarDesabilitarRestricoesTurmaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            HabilitarDesabilitarRestricoesTurma habilitarDesabilitarRestricoesTurma
                    = new HabilitarDesabilitarRestricoesTurma();
            jDesktopPanePrincipal.add(habilitarDesabilitarRestricoesTurma);
            habilitarDesabilitarRestricoesTurma.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemHabilitarDesabilitarRestricoesTurmaActionPerformed

    private void jMenuItemAdicionarAulaConjuntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAdicionarAulaConjuntaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            AdicionarAulaConjunta adicionarAulaConjunta
                    = new AdicionarAulaConjunta();
            jDesktopPanePrincipal.add(adicionarAulaConjunta);
            adicionarAulaConjunta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemAdicionarAulaConjuntaActionPerformed

    private void jMenuItemEditarAulaConjuntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarAulaConjuntaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            EditarAulaConjunta editarAulaConjunta
                    = new EditarAulaConjunta();
            jDesktopPanePrincipal.add(editarAulaConjunta);
            editarAulaConjunta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemEditarAulaConjuntaActionPerformed

    private void jMenuItemListarAulasConjuntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarAulasConjuntasActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            ListarAulasConjuntas listarAulasConjuntas
                    = new ListarAulasConjuntas();
            jDesktopPanePrincipal.add(listarAulasConjuntas);
            listarAulasConjuntas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemListarAulasConjuntasActionPerformed

    private void jMenuItemRemoverAulaConjuntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverAulaConjuntaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            RemoverAulaConjunta removerAulaConjunta
                    = new RemoverAulaConjunta();
            jDesktopPanePrincipal.add(removerAulaConjunta);
            removerAulaConjunta.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemRemoverAulaConjuntaActionPerformed

    private void jMenuItemExibirIndisponibilidadesProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExibirIndisponibilidadesProfessorActionPerformed
        DataAccessObject.abrirConexao();
        if (DataAccessObject.getProfessores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "um professor primeiro.", "Nenhum professor cadastrado", JOptionPane.ERROR_MESSAGE);
        } else {
            ExibirIndisponibilidadesProfessor exibirIndisponibilidadesProfessor
                    = new ExibirIndisponibilidadesProfessor();
            jDesktopPanePrincipal.add(exibirIndisponibilidadesProfessor);
            exibirIndisponibilidadesProfessor.setVisible(true);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemExibirIndisponibilidadesProfessorActionPerformed

    private void jMenuItemExibirRestricoesTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExibirRestricoesTurmaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            ExibirRestricoesTurma exibirRestricoesTurma
                    = new ExibirRestricoesTurma();
            jDesktopPanePrincipal.add(exibirRestricoesTurma);
            exibirRestricoesTurma.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemExibirRestricoesTurmaActionPerformed

    private void jMenuItemEditarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarTurmaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            EditarTurma editarTurma = new EditarTurma();
            jDesktopPanePrincipal.add(editarTurma);
            editarTurma.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemEditarTurmaActionPerformed

    private void jMenuItemListarTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarTurmasActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            ListarTurmas listarTurmas = new ListarTurmas();
            jDesktopPanePrincipal.add(listarTurmas);
            listarTurmas.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemListarTurmasActionPerformed

    private void jMenuItemRemoverTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverTurmaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getTurmas().isEmpty()) {
            RemoverTurma removerTurma = new RemoverTurma();
            jDesktopPanePrincipal.add(removerTurma);
            removerTurma.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma turma primeiro.", "Nenhuma turma cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemRemoverTurmaActionPerformed

    private void jMenuItemRemoverDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRemoverDisciplinaActionPerformed
        DataAccessObject.abrirConexao();
        if (!DataAccessObject.getDisciplinas().isEmpty()) {
            RemoverDisciplina removerDisciplina = new RemoverDisciplina();
            jDesktopPanePrincipal.add(removerDisciplina);
            removerDisciplina.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "uma disciplina primeiro.", "Nenhuma disciplina cadastrada", JOptionPane.ERROR_MESSAGE);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemRemoverDisciplinaActionPerformed

    private void jMenuItemEditarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarProfessorActionPerformed
        DataAccessObject.abrirConexao();
        if (DataAccessObject.getProfessores().isEmpty()) {
            JOptionPane.showMessageDialog(null, "É necessário cadastrar ao menos "
                    + "um professor primeiro.", "Nenhum professor cadastrado", JOptionPane.ERROR_MESSAGE);
        } else {
            EditarProfessor editarProfessor = new EditarProfessor();
            jDesktopPanePrincipal.add(editarProfessor);
            editarProfessor.setVisible(true);
        }
        DataAccessObject.fecharConexao();
    }//GEN-LAST:event_jMenuItemEditarProfessorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPanePrincipal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBarPrincipal;
    private javax.swing.JMenu jMenuGerenciarAulasConjuntas;
    private javax.swing.JMenu jMenuGerenciarDisciplinas;
    private javax.swing.JMenu jMenuGerenciarHorarios;
    private javax.swing.JMenu jMenuGerenciarProfessores;
    private javax.swing.JMenu jMenuGerenciarRestricoes;
    private javax.swing.JMenu jMenuGerenciarTurmas;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItemAdicionarAulaConjunta;
    private javax.swing.JMenuItem jMenuItemCadastrarDisciplina;
    private javax.swing.JMenuItem jMenuItemCadastrarProfessor;
    private javax.swing.JMenuItem jMenuItemCadastrarTurma;
    private javax.swing.JMenuItem jMenuItemDefinirIndisponibilidadesProfessor;
    private javax.swing.JMenuItem jMenuItemEditarAulaConjunta;
    private javax.swing.JMenuItem jMenuItemEditarDisciplina;
    private javax.swing.JMenuItem jMenuItemEditarProfessor;
    private javax.swing.JMenuItem jMenuItemEditarTurma;
    private javax.swing.JMenuItem jMenuItemExibirHorario;
    private javax.swing.JMenuItem jMenuItemExibirIndisponibilidadesProfessor;
    private javax.swing.JMenuItem jMenuItemExibirRestricoesTurma;
    private javax.swing.JMenuItem jMenuItemGerarHorarioCurso;
    private javax.swing.JMenuItem jMenuItemGerarHorarioTurma;
    private javax.swing.JMenuItem jMenuItemHabilitarDesabilitarRestricoesTurma;
    private javax.swing.JMenuItem jMenuItemListarAulasConjuntas;
    private javax.swing.JMenuItem jMenuItemListarDisciplinas;
    private javax.swing.JMenuItem jMenuItemListarTurmas;
    private javax.swing.JMenuItem jMenuItemRemoverAulaConjunta;
    private javax.swing.JMenuItem jMenuItemRemoverDisciplina;
    private javax.swing.JMenuItem jMenuItemRemoverHorário;
    private javax.swing.JMenuItem jMenuItemRemoverTurma;
    private javax.swing.JPopupMenu jPopupMenu1;
    // End of variables declaration//GEN-END:variables
}
