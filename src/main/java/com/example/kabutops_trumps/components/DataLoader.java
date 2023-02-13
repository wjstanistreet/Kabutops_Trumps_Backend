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

        Card venusaur = new Card("Venusaur", "https://assets.pokemon.com/assets//cms2/img/trading-card-game/_downloads/xy1/xy1-wallpaper-venusaur-1920x1200.jpg", grass, 82, 82, 83, 100, 100, 80, 4);
        cardRepository.save(venusaur);

        Card charizard = new Card("Charizard", "https://newcdn.mowplayer.com/689084892688/2021/12/08/thumbnails/8hvnfr6ipzxguaoi.jpg", fire, 78, 84, 78, 109, 85, 100, 4);

        Card blastoise = new Card("Blastoise", "https://wallpapers.com/images/featured/5bnzajzroy23tzyj.jpg", water, 79, 83, 100, 85, 105, 78, 4);
        cardRepository.save(blastoise);

        Card butterfree = new Card("Butterfree", "https://i.kym-cdn.com/photos/images/original/001/029/820/6bf.png", bug, 60, 45, 50, 90, 80, 70, 1);
        cardRepository.save(butterfree);

        Card beedrill = new Card("Beedrill", "https://cdn.donmai.us/original/65/63/65636100d5515e5df8d092b485332e24.jpg", bug, 65, 90, 40, 45, 80, 75, 1);
        cardRepository.save(beedrill);

        Card pidgeot = new Card("Pidgeot", "https://cdna.artstation.com/p/assets/images/images/028/931/102/large/victor-lin-victor76520-pidgeot-pokemon-1-2a3ad3c5-b4jq.jpg?1595951463", flying, 83, 80, 75, 70, 70, 101, 2);
        cardRepository.save(pidgeot);

        Card fearow = new Card("Fearow", "https://cdn.donmai.us/original/fa/d4/fad4272d309efae61a2b4883d6dc8707.png", flying, 65, 90, 65, 61, 61, 100, 1);
        cardRepository.save(fearow);

        Card pikachu = new Card("Pikachu", "https://wallpaperaccess.com/full/20999.jpg", electric, 45, 80, 50, 75, 60, 120, 2);
        cardRepository.save(pikachu);

        Card redsPikachu = new Card("Red's Pikachu", "https://rare-gallery.com/uploads/posts/329910-Anime-Pokemon-Red-Pikachu-Mega-Charizard-X-4K-iphone-wallpaper.jpg", electric, 65, 160, 80, 125, 90, 160, 4);
        cardRepository.save(redsPikachu);

        Card raichu = new Card("Raichu", "https://wallpapercave.com/wp/wp3684826.png", electric, 60, 90, 55, 90, 80, 110, 3);
        cardRepository.save(raichu);

        Card sandslash = new Card("Sandslash", "https://preview.redd.it/83gb9vd053951.jpg?width=640&crop=smart&auto=webp&s=d35a1a27b7c87e0fc3db195c5df6fabc5ff8ca6f", ground, 75, 100, 110, 45, 55, 65, 2);
        cardRepository.save(sandslash);

        Card alolanSandslash = new Card("Alolan Sandslash", "https://wallpapercave.com/uwp/uwp844564.jpeg", ice, 75, 100, 120, 25, 65, 65, 3);
        cardRepository.save(alolanSandslash);

        Card nidoking = new Card("Nidoking", "https://i.kym-cdn.com/photos/images/original/001/968/245/d77", poison, 81, 102, 77, 85, 75, 85, 2);
        cardRepository.save(nidoking);

        Card ninetales = new Card("Ninetales", "https://cdn.wallpapersafari.com/27/59/RqUHMc.jpg", fire, 73, 76, 75, 81, 100, 100, 2);
        cardRepository.save(ninetales);

        Card alolanNinetales = new Card("Alolan Ninetales", "https://scontent-lhr8-1.xx.fbcdn.net/v/t1.6435-9/107093938_3874921945867749_5064761047748729637_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=973b4a&_nc_ohc=ZGWpSkBe8I0AX_MbMaK&_nc_ht=scontent-lhr8-1.xx&oh=00_AfB-SrCC-lcsHoLJ2wU4pe5wKQeS6MAfLh2HYhSNBPKqgQ&oe=641057F6", ice, 73, 67, 75, 81, 100, 109, 2);
        cardRepository.save(alolanNinetales);

        Card parasect = new Card("Parasect", "https://cdn.inprnt.com/thumbs/31/4d/314deb87e2798e0b5debc607c8190ddc.jpg", bug, 60, 95, 80, 60, 80, 30, 1);
        cardRepository.save(parasect);

        Card dugtrio = new Card("Dugtrio", "", ground, 35, 100, 50, 50, 70, 120, 1);
        cardRepository.save(dugtrio);

        Card meowth = new Card("Meowth", "https://cdn.donmai.us/sample/15/b5/__meowth_pokemon_drawn_by_spareribs__sample-15b5da7bc4b083b866f896f381ed7bea.jpg", normal, 40, 45, 35, 40, 40, 90, 1);
        cardRepository.save(meowth);

        Card persian = new Card("Persian", "https://i.pinimg.com/736x/b9/90/a8/b990a800babf67d64fd5230224cba2a0--pay-day-persian.jpg", normal, 65, 70, 60, 65, 65, 115, 1);
        cardRepository.save(persian);

        Card golduck = new Card("Golduck", "https://preview.redd.it/gjekkise01061.jpg?auto=webp&s=6a34393f8c9d9abf50aea68ce9a5f0416c618030", water, 80, 82, 78, 95, 80, 85, 2);
        cardRepository.save(golduck);

        Card primeape = new Card("Primeape", "https://i.pinimg.com/originals/0d/b4/6f/0db46fc58a41f74cd34ee7605a19390d.jpg", fighting, 65, 105, 60, 60, 70, 95, 1);
        cardRepository.save(primeape);

        Card annihilape = new Card("Annihilape", "https://64.media.tumblr.com/a99d1f79e7b0e3e436d3af0da0765e3b/78affbd67926385e-2e/s1280x1920/e04321bc05ed24cd8de2c5269adf843ace144362.jpg", ghost, 110, 115, 80, 50, 90, 90, 3);
        cardRepository.save(annihilape);

        Card arcanine = new Card("Arcanine", "https://images5.alphacoders.com/497/497664.png", fire, 90, 110, 80, 100, 80, 95, 3);
        cardRepository.save(arcanine);

        Card poliwrath = new Card("Poliwrath", "https://pbs.twimg.com/media/DsTvmtwVYAAulOJ.jpg", water, 90, 95, 95, 70, 90, 70, 2);
        cardRepository.save(poliwrath);

        Card alakazam = new Card("Alakazam", "https://cdn.donmai.us/original/55/7c/557c420e22e33b70ce796c96dd0c2382.png", psychic, 55, 50, 45, 135, 95, 120, 2);
        cardRepository.save(alakazam);

        Card megaAlakazam = new Card("Mega Alakazam", "https://pbs.twimg.com/media/ECbvMm-XkAA3gdp.jpg:large", psychic, 55, 50, 65, 175, 105, 150, 4);
        cardRepository.save(megaAlakazam);

        //Add Pokemon based on trainers

        //Brock's Pokemon
        Card steelix = new Card("Steelix", "https://64.media.tumblr.com/8e687a5cc2ca7f20a571182192df1027/4a15e17d7c405c57-5a/s1280x1920/8d2e677a97e81077f97fa35dac1b0653f6b38820.jpg", steel, 75,85,200,55,65,30,4);
        cardRepository.save(steelix);
        Card croagunk = new Card("Croagunk", "https://cdn.donmai.us/original/f2/e7/__croagunk_pokemon_drawn_by_kikuyoshi_tracco__f2e73221d43b4bb7aad96a4af623b55d.jpg", poison, 48, 61, 40, 60, 40, 50, 2);
        cardRepository.save(croagunk);
        Card sudowoodo = new Card("Sudowoodo", "https://cdn.discordapp.com/attachments/1072211977482535013/1074360470162653274/the_woods_doesn_t_let_you_see_the_sudowoodo_by_edonovaillustrator_dehmups-fullview.png", rock, 70, 100, 115, 30, 65,30, 3);
        cardRepository.save(sudowoodo);
        Card crobat = new Card("Crobat", "https://64.media.tumblr.com/75f5ac2dad6893e30f05c63c54c03b22/tumblr_nebgscyLoR1r1hsklo1_1280.jpg", poison,  85, 90, 80, 70, 80, 130, 2);
        cardRepository.save(crobat);
        Card geodude = new Card ("Geodude", "https://pm1.narvii.com/6568/e84d2668884576df48cd72a627ae7f7d40c698f1_00.jpg",rock, 40, 80,100,30,30,20,1);
        cardRepository.save(geodude);
        Card marshtomp = new Card ("Marshtomp", "https://i.pinimg.com/564x/b1/5c/08/b15c0817328a1697a3ca42c2f323b157.jpg", ground, 70, 85, 70, 60, 70 , 50, 3);
        cardRepository.save(marshtomp);
        Card ludicolo = new Card("Ludicolo", "https://i.pinimg.com/originals/d2/d5/17/d2d5173fa29b1fb81cffebce7ecceaee.png", water, 80, 70, 70, 90, 100, 70, 3);
        cardRepository.save(ludicolo);
        Card blissey = new Card("Blissey", "https://pbs.twimg.com/media/FnHtBQqXoAAPyE6?format=jpg&name=medium", normal, 255, 10, 10, 75, 135, 55, 4);
        cardRepository.save(blissey);
        Card forretress = new Card("Forretress", "https://cdn.wallpapersafari.com/90/33/neb0Ro.jpg", bug, 75, 90, 140, 60, 60, 40, 2);
        cardRepository.save(forretress);
        Card vulpix = new Card("Vulpix", "https://cdn.donmai.us/original/d3/55/d3554825bc8d5dd0b9c1c8f1fde55c47.png", fire, 38, 41 ,40, 50, 65, 65, 1);
        cardRepository.save(vulpix);
        Card kabutops = new Card("Kabutops", "https://cdn.donmai.us/original/f0/24/f02412f7644f79fe0183cc4c69a3edf6.jpg", rock, 60, 115, 105, 65, 70, 80, 2);
        cardRepository.save(kabutops);

        // Brock
        Account brock = new Account("Brock", "fryingToDryingPan", "Leader", true);
        accountRepository.save(brock);

        ownershipRepository.save(new Ownership(brock, steelix, true));
        ownershipRepository.save(new Ownership(brock, croagunk, true));
        ownershipRepository.save(new Ownership(brock, sudowoodo, true));
        ownershipRepository.save(new Ownership(brock, crobat, true));
        ownershipRepository.save(new Ownership(brock, geodude, true));
        ownershipRepository.save(new Ownership(brock, marshtomp, true));
        ownershipRepository.save(new Ownership(brock, ludicolo, true));
        ownershipRepository.save(new Ownership(brock, blissey, true));
        ownershipRepository.save(new Ownership(brock, forretress, true));
        ownershipRepository.save(new Ownership(brock, vulpix, true));
        ownershipRepository.save(new Ownership(brock, kabutops, true));

        // ------------ Blue's Pokemon ------------
        Card rhyperior = new Card("Rhyperior", "https://external-preview.redd.it/Hqdvy8jkjKdiiejjXgXt7DJ-VwAGHHIUQ6tGh7zIzjE.png?auto=webp&s=aa5a79afec74dd5dc44fb1740bd4c456217c605e", ground, 115, 140, 130, 55, 55, 40, 4);
        cardRepository.save(rhyperior);

        Card machamp = new Card("Machamp", "https://i.pinimg.com/originals/7e/da/0a/7eda0a28d0266ee13436d22e4d94b806.jpg", fighting, 90, 130, 80, 65, 85, 55, 4);
        cardRepository.save(machamp);

        Card alolanExeggutor = new Card("Exeggutor", "https://pbs.twimg.com/media/DYQe2geW4AISDYb?format=jpg&name=4096x4096", grass, 95, 95, 85, 125, 75, 55, 4);
        cardRepository.save(alolanExeggutor);

        Card shinyGyarados = new Card("Lake of Rage Gyarados", "https://pbs.twimg.com/media/Eb0PkgQU8AA8h77?format=jpg&name=medium", water, 95, 125, 79, 60, 100, 81, 4);
        cardRepository.save(shinyGyarados);

        Card heracross = new Card("Heracross", "https://cdn.donmai.us/sample/7a/0e/__heracross_pokemon_drawn_by_tsukkon__sample-7a0e358e5afaea1c3d7e6d9866d8b1fc.jpg", bug, 80, 125, 75, 40, 95, 85, 4);
        cardRepository.save(heracross);

        Card magnezone = new Card("Magnezone", "https://cdn.donmai.us/original/bf/56/bf56efa1e33d390366936817de7367e6.jpg", electric, 70, 70, 115, 130, 90, 60, 4 );
        cardRepository.save(magnezone);

        // Blue
        Account blue = new Account("Blue","smellYaLater", "Champion", true);
        accountRepository.save(blue);

        ownershipRepository.save(new Ownership(blue, blastoise, true));
        ownershipRepository.save(new Ownership(blue, pidgeot, true));
        ownershipRepository.save(new Ownership(blue, arcanine, true));
        ownershipRepository.save(new Ownership(blue, alakazam, true));
        ownershipRepository.save(new Ownership(blue, alolanExeggutor, true));
        ownershipRepository.save(new Ownership(blue, rhyperior, true));
        ownershipRepository.save(new Ownership(blue, magnezone, true));
        ownershipRepository.save(new Ownership(blue, heracross, true));
        ownershipRepository.save(new Ownership(blue, machamp, true));
        ownershipRepository.save(new Ownership(blue, sandslash, true));
        ownershipRepository.save(new Ownership(blue, shinyGyarados, true));

        // ------------ Red's Pokemon ------------

        //mega charizard X

        Card megaCharizardX = new Card("Mega Charizard X", "https://i.pinimg.com/originals/bd/e1/54/bde154723b4d09a6eab43748f1c12ac5.jpg", fire, 78, 130, 111, 85,85,100,5);
        cardRepository.save(megaCharizardX);

        Card megaBlastoise = new Card("Mega Blastoise","https://wallpaper.dog/large/10911396.jpg",water,79, 103, 120, 135, 115, 78,5);
        cardRepository.save(megaBlastoise);

        Card mewTwo = new Card("MewTwo","https://external-preview.redd.it/yni5ckiWnLLgVx-bs--uiS2xajFOPpMGxBrefVV2sTk.jpg?auto=webp&s=11c00e88538210ac3760133ff37b292bf55d91f3",psychic,106, 110, 90, 154, 90, 130,5);
        cardRepository.save(mewTwo);

        Card megaVenusar = new Card("Mega Venusar","https://assets.pokemon.com/assets//cms2/img/trading-card-game/_downloads/xy1/xy1-wallpaper-venusaur-th-169.jpg",psychic,80, 100, 123, 122, 120, 80,5);
        cardRepository.save(megaVenusar);

        Card snorlax = new Card("Snorlax", "https://www.pngitem.com/pimgs/m/102-1023845_pic-pokemon-sun-and-moon-snorlax-hd-png.png", normal,160, 110, 65,65,110,30,5);
        cardRepository.save(snorlax);

        Card lapras = new Card("Lapras","https://i.pinimg.com/736x/85/36/8e/85368e255b067f9b3495022cb2118b15.jpg", water,130,85,80,85,95,60,5);
        cardRepository.save(lapras);

        Card espeon = new Card("Espeon","https://cdnb.artstation.com/p/assets/images/images/017/288/281/large/april-seymour-espeon-seyumei2.jpg?1555374729", psychic,65,65,60,130,95,110,5);
        cardRepository.save(espeon);

        Card articuno = new Card("articuno","https://wallpaperaccess.com/full/1668732.jpg",ice,90,85,100,95,125,85,5);
        cardRepository.save(articuno);

        Card zapdos = new Card("Zapdos","https://w0.peakpx.com/wallpaper/390/304/HD-wallpaper-zapdos-pokemon-anime-pokemon-zapdos.jpg", electric,90,90,85,125,90,100,5);
        cardRepository.save(zapdos);

        Card moltres = new Card("Moltress","https://wallpaperaccess.com/full/1993616.jpg", fire,90,100,90,125,85,90,5);
        cardRepository.save(moltres);

        // Red
        Account red = new Account("Red", ".....", "Champion", true);
        accountRepository.save(red);

        ownershipRepository.save(new Ownership(red, redsPikachu, true));
        ownershipRepository.save(new Ownership(red, megaCharizardX, true));
        ownershipRepository.save(new Ownership(red, megaBlastoise, true));
        ownershipRepository.save(new Ownership(red, megaVenusar, true));
        ownershipRepository.save(new Ownership(red, mewTwo, true));
        ownershipRepository.save(new Ownership(red, snorlax, true));
        ownershipRepository.save(new Ownership(red, lapras, true));
        ownershipRepository.save(new Ownership(red, espeon, true));
        ownershipRepository.save(new Ownership(red, articuno, true));
        ownershipRepository.save(new Ownership(red, zapdos, true));
        ownershipRepository.save(new Ownership(red, moltres, true));

        // Cynthia's Pokemon
        Card garchomp = new Card("Garchomp", "https://wallpapercave.com/wp/wp8659080.png", dragon, 108, 130, 95, 80, 85, 102, 5);
        Card milotic = new Card("Milotic", "https://i.pinimg.com/originals/7a/40/a3/7a40a3fee27f2e18947994b6e2363451.png", water, 95, 60, 79, 100, 125, 81, 4);
        Card lucario = new Card("Lucario", "https://image-1.uhdpaper.com/wallpaper/lucario-pokemon-phone-wallpaper-hd-uhdpaper.com-466@1@j.jpg", fighting, 70, 110, 70, 115, 70, 90, 4);
        Card roserade = new Card("Roserade", "https://i.pinimg.com/originals/11/4f/cf/114fcf1aeb43384bfb5055bda8d0849b.png", grass, 60, 70, 65, 125, 105, 90, 3);
        Card spiritomb = new Card("Spiritomb", "https://wallpapercave.com/wp/wp3186974.jpg", ghost, 50, 92, 108, 92, 108, 35, 3);
        Card togekiss = new Card("Togekiss", "https://e0.pxfuel.com/wallpapers/586/880/desktop-wallpaper-togekiss-pokemon-fairy-type-pokemon-cute-pokemon.jpg", fairy, 85, 50, 95, 120, 115, 80, 4);

        cardRepository.save(garchomp);
        cardRepository.save(milotic);
        cardRepository.save(lucario);
        cardRepository.save(spiritomb);
        cardRepository.save(roserade);
        cardRepository.save(togekiss);

        // Cynthia
        Account cynthia = new Account("Cynthia", "IChooseYouGible", "Champion", true);
        accountRepository.save(cynthia);

        Ownership cynthiaGarchomp = new Ownership(cynthia, garchomp, true);
        Ownership cynthiaLucario = new Ownership(cynthia, lucario, true);
        Ownership cynthiaRoserade = new Ownership(cynthia, roserade, true);
        Ownership cynthiaSpiritomb = new Ownership(cynthia, spiritomb, true);
        Ownership cynthiaMilotic = new Ownership(cynthia, milotic, true);
        Ownership cynthiaTogekiss = new Ownership(cynthia, togekiss, true);

        ownershipRepository.save(cynthiaGarchomp);
        ownershipRepository.save(cynthiaLucario);
        ownershipRepository.save(cynthiaRoserade);
        ownershipRepository.save(cynthiaSpiritomb);
        ownershipRepository.save(cynthiaMilotic);
        ownershipRepository.save(cynthiaTogekiss);

        // ------------ Ash's Pokemon Pikachu and Charizard alrady added ------------
        Card sceptile = new Card("Sceptile", "https://i.pinimg.com/originals/43/8b/cb/438bcb48ef21a8d88249afc6bd06842c.jpg", grass, 70, 85, 65, 105, 85, 120, 4);
        Card infernape = new Card("Infernape", "https://64.media.tumblr.com/ab5e1e8b87e0f237a8024bb2972b563d/6c09776eefd9ebd6-b2/s1280x1920/7a9477f8bd9223df48a6a974d62bf2dc52845884.png", fire, 76, 104, 71, 104, 71, 108, 4);
        Card greninja = new Card("Greninja", "https://moewalls.com/wp-content/uploads/2021/12/greninja-pokemon-thumb.jpg", water, 72, 95, 67, 103, 71, 122, 4);
        Card megaLucario = new Card("Mega Lucario", "https://w0.peakpx.com/wallpaper/511/197/HD-wallpaper-mega-lucario-pokemon.jpg", fighting, 70, 145, 88, 140, 70, 112, 5);

        cardRepository.save(pikachu);
        cardRepository.save(charizard);
        cardRepository.save(sceptile);
        cardRepository.save(infernape);
        cardRepository.save(greninja);
        cardRepository.save(megaLucario);

        // Ash
        Account ash = new Account("Ash","ichooseyouPikachu", "Trainer", false);
        accountRepository.save(ash);

        Ownership ashPikachu = new Ownership(ash, pikachu, false);
        Ownership ashCharizard = new Ownership(ash, charizard, true);
        Ownership ashSceptile = new Ownership(ash, sceptile, true);
        Ownership ashInfernape = new Ownership(ash, infernape, true);
        Ownership ashGreninja = new Ownership(ash, greninja, true);
        Ownership ashMegaLucario = new Ownership(ash, megaLucario, true);
        
        ownershipRepository.save(ashPikachu);
        ownershipRepository.save(ashCharizard);
        ownershipRepository.save(ashSceptile);
        ownershipRepository.save(ashInfernape);
        ownershipRepository.save(ashGreninja);
        ownershipRepository.save(ashMegaLucario);

    }

}


