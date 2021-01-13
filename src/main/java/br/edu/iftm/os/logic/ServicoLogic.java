package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.Servico;
import br.edu.iftm.os.repository.ServicoRepository;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;

import javax.inject.Inject;
import java.util.List;

public class ServicoLogic implements CrudLogic<Servico> {

    @Inject
    private ServicoRepository repository;

    @Override
    @Transacao
    public Servico salvar(Servico entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade.getDescricao() == null || entidade.getDescricao().equals("")){
            throw new ErroNegocioException("A descrição do serviço é obrigatório");
        }
        return repository.salvar(entidade);
    }

    @Override
    @Transacao
    public void deletar(Servico entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public Servico buscarPorId(Servico entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade == null || entidade.getId() == null){
            throw new ErroNegocioException("Serviço não pode ser carregado.");
        }
        entidade = repository.buscarPorId(entidade.getId());
        return entidade;
        
    }

    @Override
    public List<Servico> buscar(Servico entidade) throws ErroNegocioException, ErroSistemaException {
        List servicos = repository.listar();
        return servicos;
    }
 
    
    
}
