package br.com.zupbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupbank.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
