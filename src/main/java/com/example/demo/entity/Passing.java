package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passing{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String passYds;
    private String YdsAtt;
    private String Att;

    public Passing(String name, String passYds, String ydsAtt, String att) {
        this.name = name;
        this.passYds = passYds;
        YdsAtt = ydsAtt;
        Att = att;
    }

    public Passing() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassYds() {
        return passYds;
    }

    public void setPassYds(String passYds) {
        this.passYds = passYds;
    }

    public String getYdsAtt() {
        return YdsAtt;
    }

    public void setYdsAtt(String ydsAtt) {
        YdsAtt = ydsAtt;
    }

    public String getAtt() {
        return Att;
    }

    public void setAtt(String att) {
        Att = att;
    }

}
