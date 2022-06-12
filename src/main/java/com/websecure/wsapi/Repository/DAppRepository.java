package com.websecure.wsapi.Repository;

import com.websecure.wsapi.Document.DApp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface DAppRepository extends MongoRepository<DApp, BigInteger>{
    Optional<DApp> findDAppByUrl(String url);
}
