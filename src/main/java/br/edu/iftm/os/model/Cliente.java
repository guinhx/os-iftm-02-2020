/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.iftm.os.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Diego
 */

@Getter @Setter
public class Cliente implements Serializable {
    private Integer id;
    private String nome_fantasia;
    private String sobrenome_razao;
    private Date data_nascimento;
    private LocalDateTime data_cadastro;
    private String cpf_cnpj;
    private String rg_inscricao;
    private String email;
    private String sexo;
}
