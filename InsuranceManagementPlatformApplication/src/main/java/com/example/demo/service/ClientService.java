package com.example.demo.service;

import com.example.demo.model.Claim;
import com.example.demo.model.Client;

import java.util.List;

public interface ClientService {

    public List<Client> findAllClient() ;
    public Client findById(long id) ;
    public String createClient();
    public Client updateClientInfo();
    public String deleteClient();

}
