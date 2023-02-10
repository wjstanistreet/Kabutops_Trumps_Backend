package com.example.kabutops_trumps.components;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Card;
import com.example.kabutops_trumps.models.Ownership;
import com.example.kabutops_trumps.models.PokeType;
import com.example.kabutops_trumps.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    GameRepository gameRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    OwnershipRepository ownershipRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        PokeType normal = new PokeType("Normal", new ArrayList<>(List.of()),new ArrayList<>(List.of("Rock","Ghost","Steel")));
        PokeType fighting = new PokeType("Fighting", new ArrayList<>(List.of("Normal","Dark","Ice","Rock","Steel")),new ArrayList<>(List.of("Bug","Fairy","Psychic","Poison","Flying","Ghost")));
        PokeType flying = new PokeType("Flying", new ArrayList<>(List.of("Fighting","Bug","Grass")),new ArrayList<>(List.of("Rock","Electric","Steel")));
        PokeType poison = new PokeType("Poison", new ArrayList<>(List.of("Grass","Fairy")),new ArrayList<>(List.of("Steel","Rock","Ground","Poison","Ghost")));
        PokeType ground = new PokeType("Ground", new ArrayList<>(List.of("Fire","Rock","Poison","Steel","Electric")),new ArrayList<>(List.of("Bug","Grass","Flying")));
        PokeType rock = new PokeType("Rock", new ArrayList<>(List.of("Bug","Fire","Flying","Ice")),new ArrayList<>(List.of("Fighting","Ground","Steel")));
        PokeType bug = new PokeType("Bug", new ArrayList<>(List.of("Dark", "Grass", "Psychic")),new ArrayList<>(List.of("Fire","Flying","Fairy","Fighting","Ghost","Poison","Steel")));
        PokeType ghost = new PokeType("Ghost", new ArrayList<>(List.of("Ghost","Psychic")),new ArrayList<>(List.of("Dark","Normal")));
        PokeType steel = new PokeType("Steel", new ArrayList<>(List.of("Fairy","Ice","Rock")),new ArrayList<>(List.of("Electric","Fire","Steel","Water")));
        PokeType fire = new PokeType("Fire", new ArrayList<>(List.of("Bug","Grass","Ice","Steel")),new ArrayList<>(List.of("Dragon","Fire","Rock","Water")));
        PokeType water = new PokeType("Water", new ArrayList<>(List.of("Rock","Ground","Fire")),new ArrayList<>(List.of("Dragon","Grass","Water")));
        PokeType grass = new PokeType("Grass", new ArrayList<>(List.of("Ground","Rock","Water")),new ArrayList<>(List.of("Flying","Poison","Bug","Steel","Fire","Grass","Dragon")));
        PokeType electric = new PokeType("Electric", new ArrayList<>(List.of("Flying","Water")),new ArrayList<>(List.of("Ground","Grass","Electric","Dragon")));
        PokeType psychic = new PokeType("Psychic", new ArrayList<>(List.of("Fighting","Poison")),new ArrayList<>(List.of("Steel","Psychic","Dark")));
        PokeType ice = new PokeType("Ice", new ArrayList<>(List.of("Flying","Ground","Grass","Dragon")),new ArrayList<>(List.of("Steel","Fire","Water","Ice")));
        PokeType dragon = new PokeType("Dragon", new ArrayList<>(List.of("Dragon")),new ArrayList<>(List.of("Steel","Fairy")));
        PokeType dark = new PokeType("Dark", new ArrayList<>(List.of("Ghost","Psychic")),new ArrayList<>(List.of("Fighting","Dark","Fairy")));
        PokeType fairy = new PokeType("Fairy", new ArrayList<>(List.of("Fighting","Dragon","Dark")),new ArrayList<>(List.of("Poison","Steel","Fire")));

        typeRepository.save(normal);
        typeRepository.save(fighting);
        typeRepository.save(flying);
        typeRepository.save(poison);
        typeRepository.save(ground);
        typeRepository.save(rock);
        typeRepository.save(bug);
        typeRepository.save(ghost);
        typeRepository.save(steel);
        typeRepository.save(fire);
        typeRepository.save(water);
        typeRepository.save(grass);
        typeRepository.save(electric);
        typeRepository.save(psychic);
        typeRepository.save(ice);
        typeRepository.save(dragon);
        typeRepository.save(dark);
        typeRepository.save(fairy);
//
        Card garchomp = new Card("Garchomp", "https://wallpapercave.com/wp/wp8659080.png", "Dragon", 108, 130, 95, 80, 85,102);
        Card lucario = new Card("Lucario", "https://image-1.uhdpaper.com/wallpaper/lucario-pokemon-phone-wallpaper-hd-uhdpaper.com-466@1@j.jpg", "Fighting", 70, 110, 70, 115, 70,90);
//
        cardRepository.save(garchomp);
        cardRepository.save(lucario);

        Account cynthia = new Account("Cynthia", "IChooseYouGible");
        accountRepository.save(cynthia);

        Ownership cynthiaGarchomp = new Ownership(cynthia, garchomp);
        Ownership cynthiaLucario = new Ownership(cynthia, lucario);
        ownershipRepository.save(cynthiaGarchomp);
        ownershipRepository.save(cynthiaLucario);


    }

}


