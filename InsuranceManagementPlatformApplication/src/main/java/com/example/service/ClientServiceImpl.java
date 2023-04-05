package com.example.service;

import com.example.exception.ClientException;
import com.example.model.Client;
import com.example.repository.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientDao clientDao ;

    @Override
    public List<Client> findAllClient() {

        List<Client> list = new ArrayList<>();

       list =  clientDao.findAll();

        if (list.size()!=0) {

            return list ;
        }

        else {
            throw new ClientException("No client present" );
        }

    }

    @Override
    public Client findById(int id) {

        Optional<Client> client = clientDao.findById(id);

        if (client.isPresent()) {

            return client.get();
        }

        else {
            throw new ClientException("no client found with id: " + id  );
        }

    }


    @Override
    public Client createClient(Client client) {

       Optional<Client> newclient = clientDao.findById(client.getId());

        if (newclient.isEmpty()) {

           return clientDao.save(client);
        }

        else{
            throw new ClientException("Client already registered");

        }
    }

    @Override
    public Client updateClientInfo( int id , Client client) {
        Optional<Client> newClient = clientDao.findById(id);

        if (newClient.isEmpty()) {

            throw new ClientException("no client found with id: " + id );
        }

        Client existingClient = newClient.get();
        existingClient.setName(client.getName());
        existingClient.setDateOfBirth(client.getDateOfBirth());
        existingClient.setAddress(client.getAddress());
        existingClient.setContactInformation(client.getContactInformation());

        return clientDao.save(existingClient);
    }

    @Override
    public String deleteClient(int id) {
        Optional<Client> newclient = clientDao.findById(id);

        if (newclient.isPresent()) {

           clientDao.deleteById(id);
            return "Client with id: " + id + " deleted" ;
        }

        else{
            throw new ClientException("no client found with id: " + id );

        }
    }
}
