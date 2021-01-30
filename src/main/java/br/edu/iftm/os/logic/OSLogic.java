package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.OS;
import br.edu.iftm.os.repository.OSRepository;
import br.edu.iftm.os.util.StringHelper;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;

import javax.inject.Inject;
import java.util.List;

public class OSLogic implements CrudLogic<OS> {

    @Inject
    private OSRepository repository;

    @Override
    @Transacao
    public OS salvar(OS entidade) throws ErroNegocioException, ErroSistemaException {
        if(StringHelper.isEmpty(entidade.getDescricaoEquipamento())){
            throw new ErroNegocioException("Informe a descrição do equipamento.");
        }
        if(StringHelper.isEmpty(entidade.getCodigoOS())){
            throw new ErroNegocioException("Informe o código do OS.");
        }
        if(entidade.getCliente() == null) {
            throw new ErroNegocioException("Informe o ID do cliente.");
        }
        return repository.salvar(entidade);
    }

    @Override
    @Transacao
    public void deletar(OS entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public OS buscarPorId(OS entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade == null || entidade.getId() == null){
            throw new ErroNegocioException("OS não pode ser carregado.");
        }
        entidade = repository.buscarPorId(entidade.getId());
        return entidade;

    }

    @Override
    public List<OS> buscar(OS entidade) throws ErroNegocioException, ErroSistemaException {
        List osList = repository.listar();
        return osList;
    }
}
