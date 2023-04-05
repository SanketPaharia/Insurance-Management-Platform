package com.example.controller;

import com.example.Dto.ClientDto;
import com.example.model.Client;
import com.example.service.ClientService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController

public class ClientController {

    @Autowired
    ClientService clientService ;


    @PostMapping("/api/clients")
    public ResponseEntity<Client> addClientHandler(  @RequestBody ClientDto clientDto) {
        Client newClient = clientService.createClient(clientDto);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }


    @GetMapping("/api/clients/{id}")
    public ResponseEntity<Client> findClientHandler(@Valid  @PathVariable Integer id){
        Client client = clientService.findById(id);

        return new ResponseEntity<>(client,HttpStatus.FOUND);
    }

    @GetMapping("/api/clients")
    public ResponseEntity<List<Client>> getListOfAllClientsHandler(){

        List<Client> list = clientService.findAllClient();

        return new ResponseEntity<>(list ,HttpStatus.FOUND);
    }

    @PutMapping(" /api/clients/{id}")
    public ResponseEntity<Client> updateClient(@Valid  @PathVariable Integer id, @RequestBody ClientDto clientDto) {

        return new ResponseEntity<>(clientService.updateClientInfo(id , clientDto ),HttpStatus.OK);
    }

    @DeleteMapping("/api/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable int id) {
      String result =  clientService.deleteClient(id);

        return new ResponseEntity<>(result , HttpStatus.ACCEPTED );
    }

}
