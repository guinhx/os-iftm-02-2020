package br.edu.iftm.os.logic;

import br.edu.iftm.os.model.Detalhes;
import br.edu.iftm.os.repository.DetalhesRepository;
import br.edu.iftm.os.util.Transacao;
import br.edu.iftm.os.util.exception.ErroNegocioException;
import br.edu.iftm.os.util.exception.ErroSistemaException;

import javax.inject.Inject;
import java.util.List;

public class DetalhesLogic  implements CrudLogic<Detalhes> {

    @Inject
    private DetalhesRepository repository;

    @Override
    @Transacao
    public Detalhes salvar(Detalhes entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade.getNome() == null || entidade.getNome().equals("")){
            throw new ErroNegocioException("Informe o nome para o detalhe.");
        }
        if(entidade.getTipo() == null || entidade.getTipo().equals("")){
            throw new ErroNegocioException("Informe o tipo para o detalhe.");
        }
        return repository.salvar(entidade);
    }

    @Override
    @Transacao
    public void deletar(Detalhes entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public Detalhes buscarPorId(Detalhes entidade) throws ErroNegocioException, ErroSistemaException {
        if(entidade == null || entidade.getId() == null){
            throw new ErroNegocioException("Detalhes não pode ser carregado.");
        }
        entidade = repository.buscarPorId(entidade.getId());
        return entidade;

    }

    @Override
    public List<Detalhes> buscar(Detalhes entidade) throws ErroNegocioException, ErroSistemaException {
        List detalhesList = repository.listar();
        return detalhesList;
    }
}
