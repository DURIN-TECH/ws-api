package com.websecure.wsapi.Repository;

import com.websecure.wsapi.Document.Dapp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DappRepository extends MongoRepository<Dapp, String>{
    Optional<Dapp> findDappByNameIgnoreCase(String name);
}
