package com.websecure.wsapi.Controller;

import com.websecure.wsapi.Document.Dapp;
import com.websecure.wsapi.Error.ResourceNotFoundException;
import com.websecure.wsapi.Repository.DappRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RequestMapping("/api/dapps")
@RestController
public class DappController {

    @Autowired
    private DappRepository dappRepository;

    @PostMapping("/{name}")
    public ResponseEntity<Dapp> addDapp(@RequestBody Dapp dapp){
        dappRepository.save(dapp);
        return new ResponseEntity<>(dapp, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> getDapps(){
        return new ResponseEntity<>(dappRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getDapp(@PathVariable String name){
        Dapp dapp = dappRepository.findDappByNameIgnoreCase(name)
                                            .orElseThrow(()
                                                    -> new ResourceNotFoundException("Can't find dapp " + name));
        return new ResponseEntity<>(dapp, HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity<Dapp> updateDapp(@PathVariable String name, Dapp dapp){
        Dapp savedDapp = dappRepository.findDappByNameIgnoreCase(name).
                            orElseThrow(()
                                    -> new ResourceNotFoundException("No dapp with the name: " + name + " found"));

        savedDapp.setName(dapp.getName());
        savedDapp.setUrl(dapp.getUrl());
        savedDapp.setDiscord(dapp.getDiscord());
        savedDapp.setTwitter(dapp.getTwitter());
        savedDapp.setCmc(dapp.getCmc());
        savedDapp.setCgk(dapp.getCgk());

        return new ResponseEntity<>(dappRepository.save(savedDapp), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteDapp(@PathVariable("id") String id) {
            Dapp dapp = dappRepository.findById(id)
                    .orElseThrow(()
                            -> new ResourceNotFoundException("No dapp with the id: " + id + " found"));
            dappRepository.delete(dapp);
        Map<String, Object> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        response.put("dapp", dapp);
        return ResponseEntity.ok(response);
     }
}
