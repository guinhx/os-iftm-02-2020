package br.edu.iftm.os.bean;

import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;


@Named
@SessionScoped
@Getter @Setter
public class TesteBean implements Serializable {
    
    
    public void teste(){
        long tempoEspera = new Date().getTime()+4000;
        while(tempoEspera > new Date().getTime()) { }  
    }
    
}