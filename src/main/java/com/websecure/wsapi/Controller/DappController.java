package com.websecure.wsapi.Controller;

import com.websecure.wsapi.Document.Dapp;
import com.websecure.wsapi.Error.ResourceNotFoundException;
import com.websecure.wsapi.Repository.DappRepository;
import com.websecure.wsapi.Response.ErrorResponse;
import com.websecure.wsapi.Response.SuccessResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger LOGGER = LoggerFactory.getLogger(DappController.class);

    @PostMapping("/{name}")
    public ResponseEntity<Object> addDapp(@RequestBody Dapp dapp){
        LOGGER.info("Saving Dapp into Database Zone");
        dappRepository.save(dapp);
        return new ResponseEntity<>(new SuccessResponse(dapp), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Object> getDapps(){
        LOGGER.info("Fetch All Dapps Zone");
        return new ResponseEntity<>(new SuccessResponse(dappRepository.findAll()), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Object> getDapp(@PathVariable String name){
        Dapp dapp = dappRepository.findDappByNameIgnoreCase(name).orElse(null);
        if(dapp != null){
            return new ResponseEntity<>(new SuccessResponse(dapp), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse(
                new ResourceNotFoundException("No dapp with name: " + name + " found").getMessage()), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDapp(@PathVariable String id, @RequestBody Dapp dapp){
        Dapp savedDapp = dappRepository.findById(id).orElse(null);
        if(savedDapp != null){
            savedDapp.setName(dapp.getName());
            savedDapp.setUrl(dapp.getUrl());
            savedDapp.setDiscord(dapp.getDiscord());
            savedDapp.setTwitter(dapp.getTwitter());
            savedDapp.setCmc(dapp.getCmc());
            savedDapp.setCgk(dapp.getCgk());

            return new ResponseEntity<>(new SuccessResponse(dappRepository.save(savedDapp)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse(
                new ResourceNotFoundException("No dapp with id: " + id + " found").getMessage()), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDapp(@PathVariable("id") String id) {
        LOGGER.info("Delete Dapp Zone");
            Dapp dapp = dappRepository.findById(id).orElse(null);
            if(dapp != null){
                dappRepository.delete(dapp);
                return new ResponseEntity<>(new SuccessResponse(), HttpStatus.NO_CONTENT);
            }
        return new ResponseEntity(new ErrorResponse(new ResourceNotFoundException("No dapp with id: " + id + " found").getMessage()), HttpStatus.NOT_FOUND);
     }
}
