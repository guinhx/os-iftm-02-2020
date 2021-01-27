package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.ClienteLogic;
import br.edu.iftm.os.model.Cliente;
import br.edu.iftm.os.model.Endereco;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

@Named
@SessionScoped
@Getter
public class ClienteBean extends CrudBean<Cliente, ClienteLogic>{

    @Inject
    private ClienteLogic logic;
    
    private Endereco endereco;

    @Override
    public void novo() {
        super.novo();
        this.endereco = new Endereco();
    }

    @Override
    public void editar(Cliente entidade) {
        super.editar(entidade);
        this.endereco = new Endereco();
    }
    
    public void adicionarEndereco() {
//        this.endereco.setCliente(getEntidade());
        getEntidade().getEnderecos().add(this.endereco);
        this.endereco = new Endereco();
    }

    public ClienteBean() {
        super(Cliente.class);
    }
    
    @Override
    public ClienteLogic getLogic() {
        return this.logic;
    }
    
}
