package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.Caixa;
import br.edu.iftm.os.model.Detalhes;
import br.edu.iftm.os.repository.CaixaRepository;
import br.edu.iftm.os.util.StringHelper;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;

import javax.inject.Inject;
import java.util.List;

public class CaixaLogic implements CrudLogic<Caixa> {

    @Inject
    private CaixaRepository repository;

    @Override
    @Transacao
    public Caixa salvar(Caixa entidade) throws ErroNegocioException, ErroSistemaException {
        if(StringHelper.isEmpty(entidade.getDescricao())){
            throw new ErroNegocioException("Informe a descrição da caixa..");
        }
        if(StringHelper.isEmpty(entidade.getTipoMovimento())){
            throw new ErroNegocioException("Informe o tipo de movimentação da caixa..");
        }
        return repository.salvar(entidade);
    }

    @Override
    @Transacao
    public void deletar(Caixa entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public Caixa buscarPorId(Caixa entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade == null || entidade.getId() == null){
            throw new ErroNegocioException("Caixa não pode ser carregado.");
        }
        entidade = repository.buscarPorId(entidade.getId());
        return entidade;

    }

    @Override
    public List<Caixa> buscar(Caixa entidade) throws ErroNegocioException, ErroSistemaException {
        List caixas = repository.listar();
        return caixas;
    }
}
