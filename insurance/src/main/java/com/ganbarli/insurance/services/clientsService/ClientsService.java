package com.ganbarli.insurance.services.clientsService;


import com.ganbarli.insurance.exceptions.UserAlreadyExistException;
import com.ganbarli.insurance.forms.AuthForms.UserRegister;
import com.ganbarli.insurance.models.client.Client_Type;
import com.ganbarli.insurance.models.offer.Offer;
import com.ganbarli.insurance.models.user.User;
import com.ganbarli.insurance.repositories.clientRepository.ClientRepository;
import com.ganbarli.insurance.forms.ClientsForm.ClientsForm;
import com.ganbarli.insurance.models.client.Client;
import com.ganbarli.insurance.repositories.userRepository.UserRepository;
import com.ganbarli.insurance.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientsService {


    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserService userService;


    public Set<Offer> getAllOffers(Integer clientID){
        Client client = clientRepository.findById(clientID).get();
        return client.getOffers();
    }

    public Client getClientBy(Integer clientID){
        return clientRepository.findById(clientID).get();
    }



    public Client create(ClientsForm clientsForm){
        Client client = new Client();
        User user = new User();

        if (!clientRepository.findByEmail(clientsForm.getEmail()).isEmpty()){
            client = clientRepository.findByEmail(clientsForm.getEmail()).get();
        }

        client.setClient_type(clientsForm.getClient_type());
        if(clientsForm.getClient_type() == Client_Type.COMPANY ){
            client.setSsn_number(clientsForm.getSsn_number());
        }else if(clientsForm.getClient_type() == Client_Type.ENTREPRENEUR ){
            client.setSsn_number(clientsForm.getSsn_number());
        } else if(clientsForm.getClient_type() == Client_Type.INDIVIDUAL ){
            client.setId_number(clientsForm.getId_number());
            client.setFin_code(clientsForm.getFin_code());
            client.setFirst_name(clientsForm.getFirst_name());
            client.setLast_name(clientsForm.getLast_name());
        }
        client.setAddress(clientsForm.getAddress()); 
        client.setEmail(clientsForm.getEmail());
        client.setPhone(clientsForm.getPhone());
        client = clientRepository.save(client);

        UserRegister userRegister = new UserRegister();
        userRegister.setEmail(clientsForm.getEmail());
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        String x =  String.format("%06d", number);
        userRegister.setPassword(x);
        userRegister.setClient_id(client.getId());
        try {
            if (!clientRepository.findByEmail(client.getEmail()).isEmpty()){
                user = userService.registerNewUserAccount(userRegister);
                client.setCode(x);
            } else {
                user = userService.getUserByID(client.getUser().getId()).get();
            }
            client.setUser(user);
        } catch (UserAlreadyExistException e) {
            System.out.println(e.getMessage());
        }

        client = clientRepository.save(client);

        return client;
    }





    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Client updateClient(Integer clientID, ClientsForm clientsForm){
        Client client = clientRepository.findById(clientID).get();
        client.setAddress(clientsForm.getAddress());
        client.setEmail(clientsForm.getEmail());
        client.setPhone(clientsForm.getPhone());
        if (client.getClient_type() == Client_Type.COMPANY){
            client.setSsn_number(clientsForm.getSsn_number());
        } else {
            client.setFirst_name(clientsForm.getFirst_name());
            clientsForm.setLast_name(clientsForm.getLast_name());
        }
        clientsForm.setLast_name(clientsForm.getLast_name());
        return client;
    }

    public boolean deleteClient(Integer clientID){
        Optional<Client> clients = clientRepository.findById(clientID);
        if(clients.isEmpty()){
            return false;
        } else {
            clientRepository.delete(clients.get());
            return true;
        }
    }

}
