/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ECAD.ApiECAD.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author lpela
 */
@Entity
@Table(name="FileInfo")
public class FileInfo {

    private @Id @GeneratedValue Long id;
    private String banco;
    private String tipo;
    private String arquivo;
    private String dtGeracao;
    private String geradoPor;
    private String dtEnvio;
    private int qtdLinhas;
    private int carteira;
    private double vlrTotal;
    private String url;

    public FileInfo(String banco, String tipo, String arquivo, String dtGeracao, String geradoPor, String dtEnvio, int qtdLinhas, int carteira, double vlrTotal, String url) {
        this.banco = banco;
        this.tipo = tipo;
        this.arquivo = arquivo;
        this.dtGeracao = dtGeracao;
        this.geradoPor = geradoPor;
        this.dtEnvio = dtEnvio;
        this.qtdLinhas = qtdLinhas;
        this.carteira = carteira;
        this.vlrTotal = vlrTotal;
        this.url = url;
    }
    
    public FileInfo(String banco, String tipo, String arquivo, String dtGeracao, String geradoPor, String dtEnvio) {
        this.banco = banco;
        this.tipo = tipo;
        this.arquivo = arquivo;
        this.dtGeracao = dtGeracao;
        this.geradoPor = geradoPor;
        this.dtEnvio = dtEnvio;
    }
    
    public FileInfo() {
        
    }
    
    @Override
    public String toString () {
        return "File{"
                +"id:"+this.id
                +",banco:"+this.banco
                +",tipo:"+this.tipo
                +",arquivo:"+this.arquivo
                +",dtGeraco:"+this.dtGeracao
                +",geradoPor:"+this.geradoPor
                +",dtEnvio:"+this.dtEnvio
                +",qtdLinhas:"+this.qtdLinhas
                +",carteira:"+this.carteira
                +",vlrTotal:"+this.vlrTotal
                +",url:"+this.url
                +"}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getDtGeracao() {
        return dtGeracao;
    }

    public void setDtGeracao(String dtGeracao) {
        this.dtGeracao = dtGeracao;
    }

    public String getGeradoPor() {
        return geradoPor;
    }

    public void setGeradoPor(String geradoPor) {
        this.geradoPor = geradoPor;
    }

    public String getDtEnvio() {
        return dtEnvio;
    }

    public void setDtEnvio(String dtEnvio) {
        this.dtEnvio = dtEnvio;
    }

    public int getQtdLinhas() {
        return qtdLinhas;
    }

    public void setQtdLinhas(int qtdLinhas) {
        this.qtdLinhas = qtdLinhas;
    }

    public int getCarteira() {
        return carteira;
    }

    public void setCarteira(int carteira) {
        this.carteira = carteira;
    }

    public double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
}
