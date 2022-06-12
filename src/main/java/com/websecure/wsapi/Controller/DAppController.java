package com.websecure.wsapi.Controller;

import com.websecure.wsapi.Document.DApp;
import com.websecure.wsapi.Repository.DAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class DAppController {

    @Autowired
    private DAppRepository dAppRepository;

    @PostMapping("/addDApp")
    private String addDApp(@RequestBody DApp dApp){
        dAppRepository.save(dApp);
        return "Added dApp " + dApp.getId();
    }

    @GetMapping("/getDApps")
    private List<DApp> getDApps(){
        return dAppRepository.findAll();
    }

    @GetMapping("/getDApps/{url}")
    private Optional<DApp> getDApps(@PathVariable String url){
        return dAppRepository.findDAppByUrl(url);
    }
}
