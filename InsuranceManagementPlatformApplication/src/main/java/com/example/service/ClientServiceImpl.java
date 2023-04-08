package com.example.service;

import com.example.Dto.ClientDto;
import com.example.exception.ClientException;
import com.example.model.Client;
import com.example.model.InsurancePolicy;
import com.example.repository.ClientDao;
import com.example.repository.InsurancePolicyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientDao clientDao ;

    @Autowired
    InsurancePolicyDao insurancePolicyDao;

    @Override
    public List<Client> findAllClient() {

        List<Client> list = new ArrayList<>();

//       list =  clientDao.findAll();
        list =  clientDao.findSortedClientByName();
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
    public Client createClient(ClientDto clientDto) {

        InsurancePolicy insurancePolicy = this.insurancePolicyDao.findById(clientDto.getInsuranceId()).orElseThrow(() -> new RuntimeException("Invalid Insurance Id"));

        Client client = this.dtoToClient(clientDto);

        client.setInsurancePolicies(insurancePolicy);
        insurancePolicy.setClient(client);

//        this.insurancePolicyDao.save(insurancePolicy);

        return clientDao.save(client);
    }

    @Override
    public Client updateClientInfo( int id , ClientDto clientDto) {
        Optional<Client> newClient = clientDao.findById(id);

        if (newClient.isEmpty()) {

            throw new ClientException("no client found with id: " + id );
        }

        Client existingClient = newClient.get();
        existingClient.setName(clientDto.getName());
        existingClient.setDateOfBirth(clientDto.getDateOfBirth());
        existingClient.setAddress(clientDto.getAddress());
        existingClient.setContactInformation(clientDto.getContactInformation());

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
    public Client dtoToClient(ClientDto clientDto){
        Client client = new Client();
        client.setName(clientDto.getName());
        client.setDateOfBirth(clientDto.getDateOfBirth());
        client.setAddress(clientDto.getAddress());
        client.setContactInformation(clientDto.getContactInformation());

        return client;
    }
}
