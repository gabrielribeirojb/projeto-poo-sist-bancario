package com.projetocontabancaria.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetocontabancaria.domain.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
