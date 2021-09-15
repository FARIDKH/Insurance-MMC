package com.ganbarli.insurance.rest.clients;


import com.ganbarli.insurance.forms.ClientsForm.ClientsForm;
import com.ganbarli.insurance.models.client.Client;
import com.ganbarli.insurance.models.offer.Offer;
import com.ganbarli.insurance.services.clientsService.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ClientsController {


    @Autowired
    private ClientsService clientsService;


    @PostMapping("/public/client/create")
    @ResponseBody
    public Client create(@RequestBody @Validated ClientsForm clientsForm){
        return clientsService.create(clientsForm);
    }

    @GetMapping("/public/client/{clientID}/getInfo")
    @ResponseBody
    public Client getClientInfo(@PathVariable Integer clientID){
        return clientsService.getClientBy(clientID);
    }


    @GetMapping("/public/client/{clientID}/getOffers")
    @ResponseBody
    public Set<Offer> getOffers(@PathVariable Integer clientID){
        return clientsService.getAllOffers(clientID);
    }


    @PutMapping("/public/client/update/{clientID}")
    @ResponseBody
    public Client update(@RequestBody ClientsForm clientsForm, @PathVariable Integer clientID){
        return clientsService.updateClient(clientID,clientsForm);
    }

    @DeleteMapping("/public/client/delete/{clientID}")
    public boolean delete( @PathVariable Integer clientID){
        return clientsService.deleteClient(clientID);
    }

}
