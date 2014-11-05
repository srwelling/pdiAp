
package Model;

import java.sql.Date;

public class Tarefa {
    int idTarefa;
    int tempoprevisto;
    String nomeTarefa;
    int idPacote;

    
    public int getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }
 

    @Override
    public String toString() {
        return "Tarefa{" + "idTarefa=" + idTarefa + ", tempoprevisto=" + tempoprevisto + ", temporeal=" + temporeal + ", datainicio=" + datainicial + ", datatermino=" + datatermino + ", nomeTarefa=" + nomeTarefa + '}';
    }
    int temporeal;
    Date datainicial;

    public int getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }

    public int getTempoprevisto() {
        return tempoprevisto;
    }

    public void setTempoprevisto(int tempoprevisto) {
        this.tempoprevisto = tempoprevisto;
    }

    public int getTemporeal() {
        return temporeal;
    }

    public void setTemporeal(int temporeal) {
        this.temporeal = temporeal;
    }

    public Date getDatainicial() {
        return datainicial;
    }

    public void setDatainicial(Date datainicial) {
        this.datainicial = datainicial;
    }

    public Date getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(Date datatermino) {
        this.datatermino = datatermino;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }
    Date datatermino;
}
