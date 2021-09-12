package com.ganbarli.insurance.repositories.clientRepository;

import com.ganbarli.insurance.models.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Optional<Client> findByPhone(String phone);

}
