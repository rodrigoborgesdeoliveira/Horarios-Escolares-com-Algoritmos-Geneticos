/*
 * Criação das aulas de uma turma.
 */
package gerenciarhorarios;

/**
 *
 * @author Rodrigo
 */
public class Aula {
    private int idDisciplina;
    private int idTurma;
    private int idTurmaConjunta; //Pode ser vazio se não possuir uma turma conjunta.
            
    public void setIDDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }
    
    public int getIDDisciplina() {
        return idDisciplina;
    }

    public void setIDTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIDTurma() {
        return idTurma;
    }

    public void setIDTurmaConjunta(int idTurmaConjunta) {
        this.idTurmaConjunta = idTurmaConjunta;
    }

    public int getIDTurmaConjunta() {
        return idTurmaConjunta;
    }
}
