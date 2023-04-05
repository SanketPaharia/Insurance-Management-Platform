package com.example.service;

import com.example.Dto.ClientDto;
import com.example.model.Client;

import java.util.List;

public interface ClientService {

    public List<Client> findAllClient() ;
    public Client findById(int id) ;
    public Client createClient(ClientDto clientDto);
    public Client updateClientInfo(int id , ClientDto clientDto );
    public String deleteClient(int id);

}

