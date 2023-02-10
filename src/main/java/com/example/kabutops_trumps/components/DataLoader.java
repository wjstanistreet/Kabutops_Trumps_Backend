package com.example.kabutops_trumps.components;

import com.example.kabutops_trumps.models.Account;
import com.example.kabutops_trumps.models.Card;
import com.example.kabutops_trumps.models.Type;
import com.example.kabutops_trumps.repositories.AccountRepository;
import com.example.kabutops_trumps.repositories.CardRepository;
import com.example.kabutops_trumps.repositories.GameRepository;
import com.example.kabutops_trumps.repositories.TypeRepository;
import com.example.kabutops_trumps.models.Ownership;
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

        Type normal = new Type("Normal", new ArrayList<>(List.of()),new ArrayList<>(List.of("Rock","Ghost","Steel")));
        Type fighting = new Type("Fighting", new ArrayList<>(List.of("Normal","Dark","Ice","Rock","Steel")),new ArrayList<>(List.of("Bug","Fairy","Psychic","Poison","Flying","Ghost")));
        Type flying = new Type("Flying", new ArrayList<>(List.of("Fighting","Bug","Grass")),new ArrayList<>(List.of("Rock","Electric","Steel")));
        Type poison = new Type("Poison", new ArrayList<>(List.of("Grass","Fairy")),new ArrayList<>(List.of("Steel","Rock","Ground","Poison","Ghost")));
        Type ground = new Type("Ground", new ArrayList<>(List.of("Fire","Rock","Poison","Steel","Electric")),new ArrayList<>(List.of("Bug","Grass","Flying")));
        Type rock = new Type("Rock", new ArrayList<>(List.of("Bug","Fire","Flying","Ice")),new ArrayList<>(List.of("Fighting","Ground","Steel")));
        Type bug = new Type("Bug", new ArrayList<>(List.of("Dark", "Grass", "Psychic")),new ArrayList<>(List.of("Fire","Flying","Fairy","Fighting","Ghost","Poison","Steel")));
        Type ghost = new Type("Ghost", new ArrayList<>(List.of("Ghost","Psychic")),new ArrayList<>(List.of("Dark","Normal")));
        Type steel = new Type("Steel", new ArrayList<>(List.of("Fairy","Ice","Rock")),new ArrayList<>(List.of("Electric","Fire","Steel","Water")));
        Type fire = new Type("Fire", new ArrayList<>(List.of("Bug","Grass","Ice","Steel")),new ArrayList<>(List.of("Dragon","Fire","Rock","Water")));
        Type water = new Type("Water", new ArrayList<>(List.of("Rock","Ground","Fire")),new ArrayList<>(List.of("Dragon","Grass","Water")));
        Type grass = new Type("Grass", new ArrayList<>(List.of("Ground","Rock","Water")),new ArrayList<>(List.of("Flying","Poison","Bug","Steel","Fire","Grass","Dragon")));
        Type electric = new Type("Electric", new ArrayList<>(List.of("Flying","Water")),new ArrayList<>(List.of("Ground","Grass","Electric","Dragon")));
        Type psychic = new Type("Psychic", new ArrayList<>(List.of("Fighting","Poison")),new ArrayList<>(List.of("Steel","Psychic","Dark")));
        Type ice = new Type("Ice", new ArrayList<>(List.of("Flying","Ground","Grass","Dragon")),new ArrayList<>(List.of("Steel","Fire","Water","Ice")));
        Type dragon = new Type("Dragon", new ArrayList<>(List.of("Dragon")),new ArrayList<>(List.of("Steel","Fairy")));
        Type dark = new Type("Dark", new ArrayList<>(List.of("Ghost","Psychic")),new ArrayList<>(List.of("Fighting","Dark","Fairy")));
        Type fairy = new Type("Fairy", new ArrayList<>(List.of("Fighting","Dragon","Dark")),new ArrayList<>(List.of("Poison","Steel","Fire")));

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

        Account ash = new Account("Ash","ichooseyouPikachu");
        accountRepository.save(ash);


        Account cynthia = new Account("Cynthia", "IChooseYouGible");
        accountRepository.save(cynthia);

        Ownership cynthiaGarchomp = new Ownership(cynthia, garchomp);
        Ownership cynthiaLucario = new Ownership(cynthia, lucario);
        ownershipRepository.save(cynthiaGarchomp);
        ownershipRepository.save(cynthiaLucario);

    }

}


