package br.edu.iftm.os.bean;

import br.edu.iftm.os.logic.OSLogic;
import br.edu.iftm.os.model.OS;
import lombok.Getter;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
@Getter
public class OSBean extends CrudBean<OS, OSLogic>{

    @Inject
    private OSLogic logic;

    public OSBean() {
        super(OS.class);
    }

    @Override
    public OSLogic getLogic() {
        return this.logic;
    }
}
