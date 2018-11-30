/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sergio.mundo.vo;

/**
 *
 * @author Labing
 */
public class Exercise {
    private char cat;
    private int eno;
    private String topic;
    private double prom;

    public Exercise() {
    }
    
    

    public Exercise(char cat, int eno, String topic, double prom) {
        this.cat = cat;
        this.eno = eno;
        this.topic = topic;
        this.prom = prom;
    }

    public char getCat() {
        return cat;
    }

    public void setCat(char cat) {
        this.cat = cat;
    }

    public int getEno() {
        return eno;
    }

    public void setEno(int eno) {
        this.eno = eno;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public double getProm() {
        return prom;
    }

    public void setProm(double prom) {
        this.prom = prom;
    }
    
    
}
