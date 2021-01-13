package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.ClienteLogic;
import br.edu.iftm.os.model.Cliente;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


@Named
@SessionScoped
public class ServicoBean extends CrudBean<Cliente, ClienteLogic> {

    public ServicoBean() {
        super(Cliente.class);
    }
    
    @Override
    public ClienteLogic getLogic() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
