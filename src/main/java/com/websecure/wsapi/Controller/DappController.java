package com.websecure.wsapi.Controller;

import com.websecure.wsapi.Document.Dapp;
import com.websecure.wsapi.Repository.DappRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/dapps")
@RestController
public class DappController {

    @Autowired
    private DappRepository dappRepository;

    @PostMapping("/{name}")
    private String addDapp(@RequestBody Dapp dapp){
        dappRepository.save(dapp);
        return "Added dapp " + dapp.getId();
    }

    @GetMapping()
    private ResponseEntity<List<Dapp>> getDapps(){
        return new ResponseEntity<>(dappRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    private Optional<Dapp> getDapp(@PathVariable String name){
        return dappRepository.findDappByName(name.toLowerCase());
    }
    
    @DeleteMapping("/{id}")
    private String deleteDapp (@PathVariable("id) BigInteger id) {
            dappRepository.deleteById(id);
            return "dapp "+id+" deleted sucessfully";
     }                                         
}
