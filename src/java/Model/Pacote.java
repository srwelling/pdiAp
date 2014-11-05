/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;

/**
 *
 * @author amarildo.pena
 */
public class Pacote {

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }

    public int getIdPacote() {
        return idPacote;
    }

    @Override
    public String toString() {
        return "Pacote{" + "idProjeto=" + idProjeto + ", idPacote=" + idPacote + ", nomePacote=" + nomePacote + ", dataFinal=" + dataFinal + ", dataInicial=" + dataInicial + ", tempoReal=" + tempoReal + ", tempoEstimado=" + tempoEstimado + '}';
    }

    public void setIdPacote(int idPacote) {
        this.idPacote = idPacote;
    }

    public String getNomePacote() {
        return nomePacote;
    }

    public void setNomePacote(String nomePacote) {
        this.nomePacote = nomePacote;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public int getTempoReal() {
        return tempoReal;
    }

    public void setTempoReal(int tempoReal) {
        this.tempoReal = tempoReal;
    }

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
    int idProjeto;
    int idPacote;
    String nomePacote;
    Date dataFinal;
    Date dataInicial;
    int tempoReal;
    int tempoEstimado;
}
