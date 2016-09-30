/*
 * Classe turma. Cada turma contém uma ou mais disciplinas.
 */
package gerenciarhorarios;

/**
 *
 * @author Rodrigo
 */
public class Turma {
    private int id; //id da turma.
    private String curso; //nome do curso. Ex.: Engenharia da computação.
    private String nivelEnsino; //nível do ensino. Ex.: Ensino fundamental.
    private String nome; //nome da turma. Ex.: Turma A.
    private int ano; //semestre ou série.
    private String turno; //matutino, vespertino ou noturno.
    private int[] horarioTurma; //Guarda os IDs das disciplinas.
    private boolean janelamentoDisciplinas = true; //Inicialmente considera-se que não há importância se há janelamento ou não.
    //Se false, tenta evitar janelamento entre aulas.
    
    private char[] diasSemana = new char[6]; //Dias da semana em que não deseja-se ter aula (dia = '0').
    //'1' significa que aquele dia está disponível para aulas.
    
    private boolean aulasGeminadas = false; //Inicialmente considera-se que não há importância se as aulas são ou não geminadas.
    //Se true, evita aulas não geminadas. Se semAulasGeminadas = true, aulasGeminadas não pode ser true.
    
    private boolean semAulasGeminadas = false; //Inicialmente considera-se que não há importância se as aulas são ou não geminadas.
    //Se true, evita aulas geminadas. Se aulasGeminadas = true, semAulasGeminadas não pode ser true.

    public Turma(String curso, String nivelEnsino, String nome, int ano, String turno) {
        this.curso = curso; //Se for uma escola, curso = null.
        this.nivelEnsino = nivelEnsino;
        this.nome = nome;
        this.ano = ano;
        this.turno = turno;
        
        //Definição do tamanho do horário.
        if(turno.equals("Matutino") || turno.equals("Vespertino")){
            horarioTurma = new int[36]; //36 aulas para turno matutino e vespertino.
        } else{
            horarioTurma = new int[24]; //24 aulas para turno noturno.
        }
        
        //Inicialmente, todos os dias são considerados como disponíveis para aulas.
        for (int i = 0; i < diasSemana.length; i++) {
            diasSemana[i] = '1';
        }
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getID(){
        return id;
    }
    
    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    public String getCurso() {
        return curso;
    }
    
    public void setNivelEnsino(String nivelEnsino){
        this.nivelEnsino = nivelEnsino;
    }
       
    public String getNivelEnsino(){
        return nivelEnsino;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }
    
    public void setHorarioTurma(int[] horarioTurma){
        this.horarioTurma = horarioTurma;
    }
    
    public int[] getHorarioTurma(){
        return horarioTurma;
    }
    
    public void setJanelamentoDisciplinas(boolean janelamentoDisciplinas){
        this.janelamentoDisciplinas = janelamentoDisciplinas;
    }
    
    public boolean getJanelamentoDisciplinas(){
        return janelamentoDisciplinas;
    }
    
    public void alterarDiasSemana(char dia, int posicao){
        diasSemana[posicao] = dia;
    }
    
    public void setDiasSemana(char[] diasSemana){
        this.diasSemana = diasSemana;
    }
    
    public char[] getDiasSemana(){
        return diasSemana;
    }
    
    public void setAulasGeminadas(boolean aulasGeminadas){
        this.aulasGeminadas = aulasGeminadas;
    }
    
    public boolean getAulasGeminadas(){
        return aulasGeminadas;
    }
    
    public void setSemAulasGeminadas(boolean semAulasGeminadas){
        this.semAulasGeminadas = semAulasGeminadas;
    }
    
    public boolean getSemAulasGeminadas(){
        return semAulasGeminadas;
    }
}
