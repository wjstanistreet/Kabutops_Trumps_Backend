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

        Card venusaur = new Card("Venusaur", "https://assets.pokemon.com/assets//cms2/img/trading-card-game/_downloads/xy1/xy1-wallpaper-venusaur-1920x1200.jpg", grass, 82, 82, 83, 100, 100,80);
        cardRepository.save(venusaur);

        Card charizard = new Card("Charizard", "https://newcdn.mowplayer.com/689084892688/2021/12/08/thumbnails/8hvnfr6ipzxguaoi.jpg", fire, 78, 84, 78, 109, 85,100);

        Card blastoise = new Card("Blastoise", "https://wallpapers.com/images/featured/5bnzajzroy23tzyj.jpg", water, 79, 83, 100, 85, 105,78);
        cardRepository.save(blastoise);

        Card butterfree = new Card("Butterfree", "https://i.kym-cdn.com/photos/images/original/001/029/820/6bf.png", bug, 60, 45, 50, 90, 80,70);
        cardRepository.save(butterfree);

        Card beedrill = new Card("Beedrill", "https://cdn.donmai.us/original/65/63/65636100d5515e5df8d092b485332e24.jpg", bug, 65, 90, 40, 45, 80,75);
        cardRepository.save(beedrill);

        Card pidgeot = new Card("Pidgeot", "https://cdna.artstation.com/p/assets/images/images/028/931/102/large/victor-lin-victor76520-pidgeot-pokemon-1-2a3ad3c5-b4jq.jpg?1595951463", flying, 83, 80, 75, 70, 70,101);
        cardRepository.save(pidgeot);

        Card fearow = new Card("Fearow", "https://cdn.donmai.us/original/fa/d4/fad4272d309efae61a2b4883d6dc8707.png", flying, 65, 90, 65, 61, 61,100);
        cardRepository.save(fearow);

        Card pikachu = new Card("Pikachu", "https://wallpaperaccess.com/full/20999.jpg", electric, 45, 80, 50, 75, 60,120);
        cardRepository.save(pikachu);

        Card redsPikachu = new Card("Red's Pikachu", "https://rare-gallery.com/uploads/posts/329910-Anime-Pokemon-Red-Pikachu-Mega-Charizard-X-4K-iphone-wallpaper.jpg", electric, 65, 160, 80, 125, 90,160);
        cardRepository.save(redsPikachu);

        Card raichu = new Card("Raichu", "https://wallpapercave.com/wp/wp3684826.png", electric, 60, 90, 55, 90, 80,110);
        cardRepository.save(raichu);

        Card sandslash = new Card("Sandslash", "https://preview.redd.it/83gb9vd053951.jpg?width=640&crop=smart&auto=webp&s=d35a1a27b7c87e0fc3db195c5df6fabc5ff8ca6f", ground, 75, 100, 110, 45, 55,65);
        cardRepository.save(sandslash);

        Card alolanSandslash = new Card("Alolan Sandslash", "https://wallpapercave.com/uwp/uwp844564.jpeg", ice, 75, 100, 120, 25, 65,65);
        cardRepository.save(alolanSandslash);

        Card nidoking = new Card("Nidoking", "https://i.kym-cdn.com/photos/images/original/001/968/245/d77", poison, 81, 102, 77, 85, 75,85);
        cardRepository.save(nidoking);

        Card ninetales = new Card("Ninetales", "https://cdn.wallpapersafari.com/27/59/RqUHMc.jpg", fire, 73, 76, 75, 81, 100,100);
        cardRepository.save(ninetales);

        Card alolanNinetales = new Card("Alolan Ninetales", "https://scontent-lhr8-1.xx.fbcdn.net/v/t1.6435-9/107093938_3874921945867749_5064761047748729637_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=973b4a&_nc_ohc=ZGWpSkBe8I0AX_MbMaK&_nc_ht=scontent-lhr8-1.xx&oh=00_AfB-SrCC-lcsHoLJ2wU4pe5wKQeS6MAfLh2HYhSNBPKqgQ&oe=641057F6", ice, 73, 67, 75, 81, 100,109);
        cardRepository.save(alolanNinetales);

        Card parasect = new Card("Parasect", "https://cdn.inprnt.com/thumbs/31/4d/314deb87e2798e0b5debc607c8190ddc.jpg", bug, 60, 95, 80, 60, 80,30);
        cardRepository.save(parasect);

        Card dugtrio = new Card("Dugtrio", "", ground, 35, 100, 50, 50, 70,120);
        cardRepository.save(dugtrio);

        Card meowth = new Card("Meowth", "https://cdn.donmai.us/sample/15/b5/__meowth_pokemon_drawn_by_spareribs__sample-15b5da7bc4b083b866f896f381ed7bea.jpg", normal, 40, 45, 35, 40, 40,90);
        cardRepository.save(meowth);

        Card persian = new Card("Persian", "https://i.pinimg.com/736x/b9/90/a8/b990a800babf67d64fd5230224cba2a0--pay-day-persian.jpg", normal, 65, 70, 60, 65, 65,115);
        cardRepository.save(persian);

        Card golduck = new Card("Golduck", "https://preview.redd.it/gjekkise01061.jpg?auto=webp&s=6a34393f8c9d9abf50aea68ce9a5f0416c618030", water, 80, 82, 78, 95, 80,85);
        cardRepository.save(golduck);

        Card primeape = new Card("Primeape", "https://i.pinimg.com/originals/0d/b4/6f/0db46fc58a41f74cd34ee7605a19390d.jpg", fighting, 65, 105, 60, 60, 70,95);
        cardRepository.save(primeape);

        Card annihilape = new Card("Annihilape", "https://64.media.tumblr.com/a99d1f79e7b0e3e436d3af0da0765e3b/78affbd67926385e-2e/s1280x1920/e04321bc05ed24cd8de2c5269adf843ace144362.jpg", ghost, 110, 115, 80, 50, 90,90);
        cardRepository.save(annihilape);

        Card arcanine = new Card("Arcanine", "https://images5.alphacoders.com/497/497664.png", fire, 90, 110, 80, 100, 80,95);
        cardRepository.save(arcanine);

        Card poliwrath = new Card("Poliwrath", "https://pbs.twimg.com/media/DsTvmtwVYAAulOJ.jpg", water, 90, 95, 95, 70, 90,70);
        cardRepository.save(poliwrath);

        Card alakazam = new Card("Alakazam", "https://cdn.donmai.us/original/55/7c/557c420e22e33b70ce796c96dd0c2382.png", psychic, 55, 50, 45, 135, 95,120);
        cardRepository.save(alakazam);

        Card megaAlakazam = new Card("Mega Alakazam", "https://pbs.twimg.com/media/ECbvMm-XkAA3gdp.jpg:large", psychic, 55, 50, 65, 175, 105,150);
        cardRepository.save(megaAlakazam);

        //Add Pokemon based on trainers

        //Brock's Pokemon
        Card steelix = new Card("Steelix", "https://64.media.tumblr.com/8e687a5cc2ca7f20a571182192df1027/4a15e17d7c405c57-5a/s1280x1920/8d2e677a97e81077f97fa35dac1b0653f6b38820.jpg", steel, 75,85,200,55,65,30,3);
        Card croagunk = new Card("Croagunk", "https://cdn.donmai.us/original/f2/e7/__croagunk_pokemon_drawn_by_kikuyoshi_tracco__f2e73221d43b4bb7aad96a4af623b55d.jpg", poison, 48, 61, 40, 60, 40, 50, 2  );
        Card sudowoodo = new Card("Sudowoodo", "https://cdn.discordapp.com/attachments/1072211977482535013/1074360470162653274/the_woods_doesn_t_let_you_see_the_sudowoodo_by_edonovaillustrator_dehmups-fullview.png", rock, 70, 100, 115, 30, 65,30, 3);
        Card crobat = new Card("Crobat", "https://64.media.tumblr.com/75f5ac2dad6893e30f05c63c54c03b22/tumblr_nebgscyLoR1r1hsklo1_1280.jpg", poison,  85, 90, 80, 70, 80, 130, 2);
        Card geodude = new Card ("Geodude", "https://64.media.tumblr.com/75f5ac2dad6893e30f05c63c54c03b22/tumblr_nebgscyLoR1r1hsklo1_1280.jpg",)

        //Blue's Pokemon



        //Red's Pokemon



        //Cynthia's Pokemon

        Card garchomp = new Card("Garchomp", "https://wallpapercave.com/wp/wp8659080.png", dragon, 108, 130, 95, 80, 85,102);
        Card milotic = new Card("Milotic", "https://i.pinimg.com/originals/7a/40/a3/7a40a3fee27f2e18947994b6e2363451.png", water, 95, 60, 79, 100, 125,81);
        Card lucario = new Card("Lucario", "https://image-1.uhdpaper.com/wallpaper/lucario-pokemon-phone-wallpaper-hd-uhdpaper.com-466@1@j.jpg", fighting, 70, 110, 70, 115, 70,90);
        Card roserade = new Card("Roserade", "https://i.pinimg.com/originals/11/4f/cf/114fcf1aeb43384bfb5055bda8d0849b.png", grass, 60, 70, 65, 125, 105,90);
        Card spiritomb = new Card("Spiritomb", "https://wallpapercave.com/wp/wp3186974.jpg", ghost, 50, 92, 108, 92, 108,35);
        Card togekiss = new Card("Togekiss", "https://e0.pxfuel.com/wallpapers/586/880/desktop-wallpaper-togekiss-pokemon-fairy-type-pokemon-cute-pokemon.jpg", fairy, 85, 50, 95, 120, 115,80);


        //Ash's Pokemon Pikachu and Charizard alrady added
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

        // Cynthia
        Ownership cynthiaGarchomp = new Ownership(cynthia, garchomp, true);
        Ownership cynthiaLucario = new Ownership(cynthia, lucario, true);
        Ownership cynthiaRoserade = new Ownership(cynthia, roserade, true);
        Ownership cynthiaSpiritomb = new Ownership(cynthia, spiritomb, true);
        Ownership cynthiaMilotic = new Ownership(cynthia, milotic, true);
        Ownership cynthiaTogekiss = new Ownership(cynthia, togekiss, true);

        // Ash
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


