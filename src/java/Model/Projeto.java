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
public class Projeto {
    int tempoEstimado;
    int tempoReal;

    public int getTempoEstimado() {
        return tempoEstimado;
    }

    @Override
    public String toString() {
        return "Projeto{" + "tempoEstimado=" + tempoEstimado + ", tempoReal=" + tempoReal + ", dataInicial=" + dataInicial + ", dataFinal=" + dataFinal + ", nomeProjeto=" + nomeProjeto + ", idProjeto=" + idProjeto + '}';
    }

    public void setTempoEstimado(int tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public int getTempoReal() {
        return tempoReal;
    }

    public void setTempoReal(int tempoReal) {
        this.tempoReal = tempoReal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public int getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(int idProjeto) {
        this.idProjeto = idProjeto;
    }
    Date dataInicial;
    Date dataFinal;
    String nomeProjeto;
    int idProjeto;
    
    
}
