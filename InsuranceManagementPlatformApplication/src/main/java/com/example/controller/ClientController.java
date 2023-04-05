package com.example.controller;

import com.example.model.Client;
import com.example.service.ClientService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ClientController {

    @Autowired
    ClientService clientService ;


    @PostMapping("/clients")
    public ResponseEntity<Client> addClientHandler(@RequestBody Client client) {
        Client newClient = clientService.createClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }


    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> findClientHandler(@PathVariable Integer id){
        Client client = clientService.findById(id);

        return new ResponseEntity<>(client,HttpStatus.FOUND);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getListOfAllClientsHandler(){

        List<Client> list = clientService.findAllClient();

        return new ResponseEntity<>(list ,HttpStatus.FOUND);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Integer id, @RequestBody Client client) {

        clientService.updateClientInfo(id , client );

        return new ResponseEntity<>(client ,HttpStatus.OK);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable int id) {
      String result =  clientService.deleteClient(id);

        return new ResponseEntity<>(result , HttpStatus.ACCEPTED );
    }

}
