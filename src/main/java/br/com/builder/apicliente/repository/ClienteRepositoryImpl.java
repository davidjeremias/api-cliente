package br.com.builder.apicliente.repository;

import br.com.builder.apicliente.entity.Cliente;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepositoryCustom{

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Cliente> findByNomeOrCpfCnpjOrDataNascimentoOrAtivo(String nome, String cpfCnpj, String dataNascimento, Boolean ativo) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Cliente> cq = cb.createQuery(Cliente.class);

            Root<Cliente> cliente = cq.from(Cliente.class);
            List<Predicate> predicates = new ArrayList<>();

            if (nome != null)
                predicates.add(cb.like(cliente.get("nome"), "%" + nome + "%"));
            if (cpfCnpj != null)
                predicates.add(cb.equal(cliente.get("cpfCnpj"), cpfCnpj));
            if (dataNascimento != null)
                predicates.add(cb.equal(cliente.get("dataNascimento"), LocalDate.parse(dataNascimento)));
            if (ativo != null)
                predicates.add(cb.equal(cliente.get("ativo"), ativo));
            cq.where(predicates.toArray(new Predicate[0]));

            return em.createQuery(cq).getResultList();

    }
}
