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

        Card garchomp = new Card("Garchomp", "https://wallpapercave.com/wp/wp8659080.png", dragon, 108, 130, 95, 80, 85,102);
        Card milotic = new Card("Milotic", "https://i.pinimg.com/originals/7a/40/a3/7a40a3fee27f2e18947994b6e2363451.png", water, 95, 60, 79, 100, 125,81);
        Card lucario = new Card("Lucario", "https://image-1.uhdpaper.com/wallpaper/lucario-pokemon-phone-wallpaper-hd-uhdpaper.com-466@1@j.jpg", fighting, 70, 110, 70, 115, 70,90);
        Card roserade = new Card("Roserade", "https://i.pinimg.com/originals/11/4f/cf/114fcf1aeb43384bfb5055bda8d0849b.png", grass, 60, 70, 65, 125, 105,90);
        Card spiritomb = new Card("Spiritomb", "https://wallpapercave.com/wp/wp3186974.jpg", ghost, 50, 92, 108, 92, 108,35);
        Card togekiss = new Card("Togekiss", "https://e0.pxfuel.com/wallpapers/586/880/desktop-wallpaper-togekiss-pokemon-fairy-type-pokemon-cute-pokemon.jpg", fairy, 85, 50, 95, 120, 115,80);

        Card pikachu = new Card("Pikachu", "https://wallpaperaccess.com/full/20999.jpg", electric, 35, 55, 40, 50, 50,90);
        Card charizard = new Card("Charizard", "https://newcdn.mowplayer.com/689084892688/2021/12/08/thumbnails/8hvnfr6ipzxguaoi.jpg", fire, 78, 84, 78, 109, 85,100);
        Card sceptile = new Card("Sceptile", "https://i.pinimg.com/originals/43/8b/cb/438bcb48ef21a8d88249afc6bd06842c.jpg", grass, 70, 85, 65, 105, 85,120);
        Card infernape = new Card("Infernape", "https://64.media.tumblr.com/ab5e1e8b87e0f237a8024bb2972b563d/6c09776eefd9ebd6-b2/s1280x1920/7a9477f8bd9223df48a6a974d62bf2dc52845884.png", fire, 76, 104, 71, 104, 71,108);
        Card greninja = new Card("Greninja", "https://moewalls.com/wp-content/uploads/2021/12/greninja-pokemon-thumb.jpg", water, 72, 95, 67, 103, 71,122);
        Card megaLucario = new Card("Mega Lucario", "https://w0.peakpx.com/wallpaper/511/197/HD-wallpaper-mega-lucario-pokemon.jpg", fighting, 70, 145, 88, 140, 70,112);


        cardRepository.save(garchomp);
        cardRepository.save(milotic);
        cardRepository.save(lucario);
        cardRepository.save(spiritomb);
        cardRepository.save(roserade);
        cardRepository.save(togekiss);
        cardRepository.save(pikachu);
        cardRepository.save(charizard);
        cardRepository.save(sceptile);
        cardRepository.save(infernape);
        cardRepository.save(greninja);
        cardRepository.save(megaLucario);

        Account ash = new Account("Ash","ichooseyouPikachu", "Trainer", false);
        accountRepository.save(ash);
        Account cynthia = new Account("Cynthia", "IChooseYouGible", "Champion", true);
        accountRepository.save(cynthia);

        Ownership cynthiaGarchomp = new Ownership(cynthia, garchomp, true);
        Ownership cynthiaLucario = new Ownership(cynthia, lucario, true);
        Ownership cynthiaRoserade = new Ownership(cynthia, roserade, true);
        Ownership cynthiaSpiritomb = new Ownership(cynthia, spiritomb, true);
        Ownership cynthiaMilotic = new Ownership(cynthia, milotic, true);
        Ownership cynthiaTogekiss = new Ownership(cynthia, togekiss, true);

        Ownership ashPikachu = new Ownership(ash, pikachu, false);
        Ownership ashCharizard = new Ownership(ash, charizard, true);
        Ownership ashSceptile = new Ownership(ash, sceptile, true);
        Ownership ashInfernape = new Ownership(ash, infernape, true);
        Ownership ashGreninja = new Ownership(ash, greninja, true);
        Ownership ashMegaLucario = new Ownership(ash, megaLucario, true);

        ownershipRepository.save(cynthiaGarchomp);
        ownershipRepository.save(cynthiaLucario);
        ownershipRepository.save(cynthiaRoserade);
        ownershipRepository.save(cynthiaSpiritomb);
        ownershipRepository.save(cynthiaMilotic);
        ownershipRepository.save(cynthiaTogekiss);
        
        ownershipRepository.save(ashPikachu);
        ownershipRepository.save(ashCharizard);
        ownershipRepository.save(ashSceptile);
        ownershipRepository.save(ashInfernape);
        ownershipRepository.save(ashGreninja);
        ownershipRepository.save(ashMegaLucario);

    }

}


