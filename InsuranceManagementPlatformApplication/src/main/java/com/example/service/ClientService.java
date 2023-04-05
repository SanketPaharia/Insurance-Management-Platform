package com.example.service;

import com.example.model.Client;

import java.util.List;

public interface ClientService {

    public List<Client> findAllClient() ;
    public Client findById(int id) ;
    public Client createClient(Client client);
    public Client updateClientInfo(int id , Client client );
    public String deleteClient(int id);

}

