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

        //type
        Type normal = new Type("Normal", new ArrayList<>(List.of()),new ArrayList<>(List.of("Rock","Ghost","Steel")), "#9099a1");
        Type fighting = new Type("Fighting", new ArrayList<>(List.of("Normal","Dark","Ice","Rock","Steel")),new ArrayList<>(List.of("Bug","Fairy","Psychic","Poison","Flying","Ghost")), "#ce4069");
        Type flying = new Type("Flying", new ArrayList<>(List.of("Fighting","Bug","Grass")),new ArrayList<>(List.of("Rock","Electric","Steel")), "#8fa8dd");
        Type poison = new Type("Poison", new ArrayList<>(List.of("Grass","Fairy")),new ArrayList<>(List.of("Steel","Rock","Ground","Poison","Ghost")), "#ad6dc9");
        Type ground = new Type("Ground", new ArrayList<>(List.of("Fire","Rock","Poison","Steel","Electric")),new ArrayList<>(List.of("Bug","Grass","Flying")), "#d97746");
        Type rock = new Type("Rock", new ArrayList<>(List.of("Bug","Fire","Flying","Ice")),new ArrayList<>(List.of("Fighting","Ground","Steel")), "#c7b78b");
        Type bug = new Type("Bug", new ArrayList<>(List.of("Dark", "Grass", "Psychic")),new ArrayList<>(List.of("Fire","Flying","Fairy","Fighting","Ghost","Poison","Steel")), "#90c12c");
        Type ghost = new Type("Ghost", new ArrayList<>(List.of("Ghost","Psychic")),new ArrayList<>(List.of("Dark","Normal")), "#5369ac");
        Type steel = new Type("Steel", new ArrayList<>(List.of("Fairy","Ice","Rock")),new ArrayList<>(List.of("Electric","Fire","Steel","Water")), "#5a8ea1");
        Type fire = new Type("Fire", new ArrayList<>(List.of("Bug","Grass","Ice","Steel")),new ArrayList<>(List.of("Dragon","Fire","Rock","Water")), "#ff9c54");
        Type water = new Type("Water", new ArrayList<>(List.of("Rock","Ground","Fire")),new ArrayList<>(List.of("Dragon","Grass","Water")), "#4c90d6");
        Type grass = new Type("Grass", new ArrayList<>(List.of("Ground","Rock","Water")),new ArrayList<>(List.of("Flying","Poison","Bug","Steel","Fire","Grass","Dragon")), "#63bb5b");
        Type electric = new Type("Electric", new ArrayList<>(List.of("Flying","Water")),new ArrayList<>(List.of("Ground","Grass","Electric","Dragon")), "#f4d23b");
        Type psychic = new Type("Psychic", new ArrayList<>(List.of("Fighting","Poison")),new ArrayList<>(List.of("Steel","Psychic","Dark")), "#f97177");
        Type ice = new Type("Ice", new ArrayList<>(List.of("Flying","Ground","Grass","Dragon")),new ArrayList<>(List.of("Steel","Fire","Water","Ice")), "#74cec0");
        Type dragon = new Type("Dragon", new ArrayList<>(List.of("Dragon")),new ArrayList<>(List.of("Steel","Fairy")), "#0a6dc4");
        Type dark = new Type("Dark", new ArrayList<>(List.of("Ghost","Psychic")),new ArrayList<>(List.of("Fighting","Dark","Fairy")), "#5a5366");
        Type fairy = new Type("Fairy", new ArrayList<>(List.of("Fighting","Dragon","Dark")),new ArrayList<>(List.of("Poison","Steel","Fire")), "#ec8fe6");

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

        //default pokemon

        Card venusaur = new Card("Venusaur", "https://external-preview.redd.it/2H0zAhwtKjbgPvij_aEp-5FVrQUdohH4YK_JPtDY3JI.png?auto=webp&s=d0b707a274da6c4ee5782286c0e3ab2a8a554dda", grass, 82, 82, 83, 100, 100, 80, 4);
        cardRepository.save(venusaur);

        Card charizard = new Card("Charizard", "https://newcdn.mowplayer.com/689084892688/2021/12/08/thumbnails/8hvnfr6ipzxguaoi.jpg", fire, 78, 84, 78, 109, 85, 100, 4);
        cardRepository.save(charizard);

        Card blastoise = new Card("Blastoise", "https://e1.pxfuel.com/desktop-wallpaper/780/410/desktop-wallpaper-%E3%83%86%E3%83%83%E3%82%B7%E3%83%BC-on-twitter-pokemon-blastoise.jpg", water, 79, 83, 100, 85, 105, 78, 4);
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

        Card redsPikachu = new Card("Red's Pikachu", "https://rare-gallery.com/uploads/posts/329910-Anime-Pokemon-Red-Pikachu-Mega-Charizard-X-4K-iphone-wallpaper.jpg", electric, 65, 160, 80, 125, 90, 160, 6);
        cardRepository.save(redsPikachu);

        Card raichu = new Card("Raichu", "https://wallpapercave.com/wp/wp3684826.png", electric, 60, 90, 55, 90, 80, 110, 3);
        cardRepository.save(raichu);

        Card sandslash = new Card("Sandslash", "https://preview.redd.it/83gb9vd053951.jpg?width=640&crop=smart&auto=webp&s=d35a1a27b7c87e0fc3db195c5df6fabc5ff8ca6f", ground, 75, 100, 110, 45, 55, 65, 2);
        cardRepository.save(sandslash);

        Card alolanSandslash = new Card("Alolan Sandslash", "https://wallpapercave.com/uwp/uwp844564.jpeg", ice, 75, 100, 120, 25, 65, 65, 3);
        cardRepository.save(alolanSandslash);

        Card nidoking = new Card("Nidoking", "https://i.kym-cdn.com/photos/images/original/001/968/245/d77", poison, 81, 102, 77, 85, 75, 85, 2);
        cardRepository.save(nidoking);

        Card ninetales = new Card("Ninetales", "https://cdn.wallpapersafari.com/27/59/RqUHMc.jpg", fire, 73, 76, 75, 81, 100, 100, 4);
        cardRepository.save(ninetales);

        Card alolanNinetales = new Card("Alolan Ninetales", "https://scontent-lhr8-1.xx.fbcdn.net/v/t1.6435-9/107093938_3874921945867749_5064761047748729637_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=973b4a&_nc_ohc=ZGWpSkBe8I0AX_MbMaK&_nc_ht=scontent-lhr8-1.xx&oh=00_AfB-SrCC-lcsHoLJ2wU4pe5wKQeS6MAfLh2HYhSNBPKqgQ&oe=641057F6", ice, 73, 67, 75, 81, 100, 109, 4);
        cardRepository.save(alolanNinetales);

        Card parasect = new Card("Parasect", "https://cdn.inprnt.com/thumbs/31/4d/314deb87e2798e0b5debc607c8190ddc.jpg", bug, 60, 95, 80, 60, 80, 30, 1);
        cardRepository.save(parasect);

        Card dugtrio = new Card("Dugtrio", "https://www.smogon.com/articles/images/ou-spotlight-dugtrio.png", ground, 35, 100, 50, 50, 70, 120, 1);
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

        Card mewTwo = new Card("Mewtwo","https://external-preview.redd.it/yni5ckiWnLLgVx-bs--uiS2xajFOPpMGxBrefVV2sTk.jpg?auto=webp&s=11c00e88538210ac3760133ff37b292bf55d91f3",psychic,106, 110, 90, 154, 90, 130,5);
        cardRepository.save(mewTwo);

        Card megaVenusar = new Card("Mega Venusaur","\"https://assets.pokemon.com/assets//cms2/img/trading-card-game/_downloads/xy1/xy1-wallpaper-venusaur-1920x1200.jpg\"",psychic,80, 100, 123, 122, 120, 80,5);
        cardRepository.save(megaVenusar);

        Card snorlax = new Card("Snorlax", "https://www.pngitem.com/pimgs/m/102-1023845_pic-pokemon-sun-and-moon-snorlax-hd-png.png", normal,160, 110, 65,65,110,30,5);
        cardRepository.save(snorlax);

        Card lapras = new Card("Lapras","https://i.pinimg.com/736x/85/36/8e/85368e255b067f9b3495022cb2118b15.jpg", water,130,85,80,85,95,60,5);
        cardRepository.save(lapras);

        Card espeon = new Card("Espeon","https://cdnb.artstation.com/p/assets/images/images/017/288/281/large/april-seymour-espeon-seyumei2.jpg?1555374729", psychic,65,65,60,130,95,110,5);
        cardRepository.save(espeon);

        Card articuno = new Card("Articuno","https://wallpaperaccess.com/full/1668732.jpg",ice,90,85,100,95,125,85,5);
        cardRepository.save(articuno);

        Card zapdos = new Card("Zapdos","https://w0.peakpx.com/wallpaper/390/304/HD-wallpaper-zapdos-pokemon-anime-pokemon-zapdos.jpg", electric,90,90,85,125,90,100,5);
        cardRepository.save(zapdos);

        Card moltres = new Card("Moltres","https://wallpaperaccess.com/full/1993616.jpg", fire,90,100,90,125,85,90,5);
        cardRepository.save(moltres);

        // Red
        Account red = new Account("Red", ".....", "Champion", true);
        accountRepository.save(red);

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
        ownershipRepository.save(new Ownership(red, redsPikachu, true));

        // Cynthia's Pokemon
        Card garchomp = new Card("Garchomp", "https://wallpapercave.com/wp/wp8659080.png", dragon, 108, 130, 95, 80, 85, 102, 5);
        Card milotic = new Card("Milotic", "https://i.pinimg.com/originals/7a/40/a3/7a40a3fee27f2e18947994b6e2363451.png", water, 95, 60, 79, 100, 125, 81, 4);
        Card lucario = new Card("Lucario", "https://i.kym-cdn.com/photos/images/original/002/196/102/6fa.png", fighting, 70, 110, 70, 115, 70, 90, 4);
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
        Card infernape = new Card("Infernape", "https://cdn.donmai.us/original/64/1d/641d772e66791f08271247595a9ae98d.png", fire, 76, 104, 71, 104, 71, 108, 4);
        Card ashGreninja = new Card("Ash's Greninja", "https://preview.redd.it/fnq1rnmoy5n51.jpg?auto=webp&s=a83f2a577d6f5ba134e953847a45b7579a5d19bd", water, 72, 145, 67, 153, 71, 132, 5);
        Card megaLucario = new Card("Mega Lucario", "https://c-ssl.duitang.com/uploads/item/202002/27/20200227204435_C2KZL.jpeg", fighting, 70, 145, 88, 140, 70, 112, 5);

        cardRepository.save(pikachu);
        cardRepository.save(sceptile);
        cardRepository.save(infernape);
        cardRepository.save(ashGreninja);
        cardRepository.save(megaLucario);

        // Ash
        Account ash = new Account("Ash","ichooseyouPikachu", "Trainer", false);
        accountRepository.save(ash);

        Ownership ashPikachu = new Ownership(ash, pikachu, false);
        Ownership ashCharizard = new Ownership(ash, charizard, true);
        Ownership ashSceptile = new Ownership(ash, sceptile, true);
        Ownership ashInfernape = new Ownership(ash, infernape, true);
        Ownership ashAshGreninja = new Ownership(ash, ashGreninja, true);
        Ownership ashMegaLucario = new Ownership(ash, megaLucario, true);

        ownershipRepository.save(ashCharizard);
        ownershipRepository.save(ashSceptile);
        ownershipRepository.save(ashInfernape);
        ownershipRepository.save(ashAshGreninja);
        ownershipRepository.save(ashMegaLucario);

        // ------------ Steven's Pokemon ------------
        Card skarmory = new Card("Skarmory", "https://cdn.donmai.us/original/fb/26/fb2656c1584bd31bb854e8f3b1a183fd.jpg", steel, 65, 80, 140, 40, 70, 70, 3);
        cardRepository.save(skarmory);
        Card claydol = new Card("Claydol", "https://cdn.donmai.us/original/ee/4d/ee4d92f3002bb0ec1febe829306d5c90.jpg", ground, 60, 70, 105, 70, 120, 75, 3);
        cardRepository.save(claydol);
        Card aggron = new Card("Aggron", "https://pbs.twimg.com/media/E8rTR5WUUAcaq7g?format=jpg&name=4096x4096", steel, 70, 110, 180, 60, 60, 50, 4);
        cardRepository.save(aggron);
        Card cradily = new Card("Cradily", "https://i.pinimg.com/564x/05/13/f9/0513f921d923afc1d4828562c07faa94.jpg", rock, 86, 81, 97, 81, 107, 43, 3);
        cardRepository.save(cradily);
        Card armaldo = new Card("Armaldo", "https://i.pinimg.com/originals/8d/c1/97/8dc1971cc5b59fa1ed6936b148afcffd.png", rock, 75, 125, 100, 70, 80, 45, 3);
        cardRepository.save(armaldo);
        Card megaMetagross = new Card("Mega Metagross", "https://cdn.donmai.us/original/ec/5c/ec5c5ea24165aa0ef102f174005a4283.jpg", steel, 80, 145, 150, 105, 110, 110, 5);
        cardRepository.save(megaMetagross);
        Card aerodactyl = new Card("Aerodactyl", "https://staticg.sportskeeda.com/editor/2023/01/dffa4-16746432089401-1920.jpg", rock, 80, 105, 65, 60, 75, 130, 4);
        cardRepository.save(aerodactyl);
        Card excadrill = new Card("Excadrill", "https://cdn.donmai.us/original/de/bd/debd4d2a8633ebb72a93b1e9c39509b3.jpg", ground, 110, 135, 60, 50, 65, 88, 3);
        cardRepository.save(excadrill);
        Card archeops = new Card("Archeops", "https://i.pinimg.com/originals/f4/2d/0a/f42d0a3bf3a6db220bbb82ae1be5cca2.jpg", flying, 75, 140, 65, 112, 65, 110, 5);
        cardRepository.save(archeops);
        Card bastiodon = new Card("Bastiodon", "https://i.pinimg.com/736x/53/69/42/5369426751676c4e849957a9fbf42e03.jpg", rock, 60, 52, 168, 47, 138, 30, 3);
        cardRepository.save(bastiodon);


        // Steven
        Account steven = new Account("Steven", "loveMeSomeStones", "Champion", true);
        accountRepository.save(steven);

        ownershipRepository.save(new Ownership(steven, steelix, true));
        ownershipRepository.save(new Ownership(steven, skarmory, true));
        ownershipRepository.save(new Ownership(steven, claydol, true));
        ownershipRepository.save(new Ownership(steven, aerodactyl, true));
        ownershipRepository.save(new Ownership(steven, excadrill, true));
        ownershipRepository.save(new Ownership(steven, archeops, true));
        ownershipRepository.save(new Ownership(steven, bastiodon, true));
        ownershipRepository.save(new Ownership(steven, armaldo, true));
        ownershipRepository.save(new Ownership(steven, cradily, true));
        ownershipRepository.save(new Ownership(steven, aggron, true));
        ownershipRepository.save(new Ownership(steven, megaMetagross, true));

        // ------------ N's Pokemon ------------
        Account N = new Account("N", "aNaturalHarmoniaGropius", "Team Plasma King", true);
        accountRepository.save(N);

        Card reshiram = new Card("N's Reshiram", "https://cdn.donmai.us/original/fb/f2/fbf2f631e65d09e67c6e596196154485.jpg", dragon, 100, 120, 100, 150, 120, 90, 6);
        cardRepository.save(reshiram);
        Card carracosta = new Card("Carracosta", "https://i.pinimg.com/236x/1f/e2/a0/1fe2a0f02b1307ad0cc37234615125ad--shelters-pokemon-fan-art.jpg", water, 74, 108, 133, 83, 65, 32, 4);
        cardRepository.save(carracosta);
        Card vanilluxe = new Card("Vanilluxe", "https://cdn.donmai.us/original/02/67/0267d9a777bc8139311d582b8a09a900.jpg", ice, 71, 95, 85, 110, 95, 79, 5);
        cardRepository.save(vanilluxe);
        Card klinklang = new Card("Klinklang", "https://i.pinimg.com/originals/4f/18/69/4f18698d32e0566f24d9c98efb476599.jpg", steel, 60, 100, 115, 70, 85, 90, 5);
        cardRepository.save(klinklang);
        Card zoroark = new Card("Zoroark", "https://wallpaper.dog/large/5551321.jpg", dark, 60, 105, 60, 120, 60, 105, 5);
        cardRepository.save(zoroark);
        Card darmanitan = new Card("Darmanitan", "https://i.pinimg.com/originals/95/e3/54/95e354f8c3634d6dfe595a20ef37ae8b.jpg", fire, 105, 140, 55, 30, 55, 95, 4);
        cardRepository.save(darmanitan);
        Card liepard = new Card("Liepard", "https://preview.redd.it/tv6ep3sxlmt91.jpg?auto=webp&s=3cf5b0ad5908034d416a7b070bad09e257572b37", dark, 64, 88, 50, 88, 50, 106, 4);
        cardRepository.save(liepard);
        Card gigalith = new Card("Gigalith", "https://64.media.tumblr.com/d451810ccec25220c41569b90da77129/82e8229bcbe25def-73/s1280x1920/d1886cd45df4b9f97952e894d5ecca0e33e42270.pnj", rock, 85, 135, 130, 60, 80, 25, 5);
        cardRepository.save(gigalith);
        Card ferrothorn = new Card("Ferrothorn", "https://external-preview.redd.it/ByXmjXb5eCpMRKiW2zXCoDw5jLRlAG1jwwBMVvMcLeY.jpg?auto=webp&s=dc9a15b07e1dbc40ef14fffa83d4124b4d883f01", grass, 74, 94, 131, 54, 116, 20, 4);
        cardRepository.save(ferrothorn);
        Card sigilyph = new Card("Sigilyph", "https://64.media.tumblr.com/f96bba1a55de28b8a603d42fdee1fb8d/tumblr_p6y0y35MrS1uqt6s9o1_1280.jpg", psychic, 72, 58, 80, 103, 80, 97, 4);
        cardRepository.save(sigilyph);

        ownershipRepository.save(new Ownership(N, liepard, true));
        ownershipRepository.save(new Ownership(N, sigilyph, true));
        ownershipRepository.save(new Ownership(N, ferrothorn, true));
        ownershipRepository.save(new Ownership(N, gigalith, true));
        ownershipRepository.save(new Ownership(N, darmanitan, true));
        ownershipRepository.save(new Ownership(N, carracosta, true));
        ownershipRepository.save(new Ownership(N, archeops, true));
        ownershipRepository.save(new Ownership(N, vanilluxe, true));
        ownershipRepository.save(new Ownership(N, klinklang, true));
        ownershipRepository.save(new Ownership(N, zoroark, true));
        ownershipRepository.save(new Ownership(N, reshiram, true));


        //------------------- Leons Pokemon -------------------



          Account leon = new Account("Leon", "championOfGalar", "Wyndon Stadium", true);
        accountRepository.save(leon);


        Card aegislash = new Card("Aegislash","https://wallpapercave.com/wp/wp3740180.jpg", steel, 60,50,140,50,140,60,4);
        cardRepository.save(aegislash);

        Card coalossal = new Card("Coalossal","https://pbs.twimg.com/media/ENtVrMqWsAQW-5b.jpg",rock, 110,80,120,80,90,30,4);
        cardRepository.save(coalossal);

        Card dragapult = new Card("Dragapult", "https://cardboardwarriors.net/assets/dragapult.png",dragon, 88,120,75,100,75,142,5);
        cardRepository.save(dragapult);


        Card inteleon = new Card("Inteleon", "https://cdn.donmai.us/original/18/b2/18b2f7e41340bd9aec0fc287eae238ff.jpg", water, 70,85,65,125,65,120,4);
        cardRepository.save(inteleon);

        Card rillaboom = new Card("Rillaboom","https://cdnb.artstation.com/p/assets/images/images/023/610/581/large/lucas-riquenes-rillaboom.jpg?1579764181",grass,100,125,90,60,70,85,4);
        cardRepository.save(rillaboom);


        Card haxorus = new Card("Haxorus", "https://i.pinimg.com/550x/2b/a0/58/2ba0582b3c5371e0d87396c915f8d1a1.jpg", dragon, 76,147,90,60,70,97,4);
        cardRepository.save(haxorus);


        Card mrRime = new Card("Mr.Rime", "https://images5.alphacoders.com/120/thumb-1920-1207177.jpg", psychic,80,85,75,110,100,70,4);
        cardRepository.save(mrRime);

        Card cinderace = new Card("Cinderace","https://e1.pxfuel.com/desktop-wallpaper/150/332/desktop-wallpaper-90-cinderace-ideas-in-2022-pokemon-cinderace.jpg", fire,80,116,75,65,75,119,4);
        cardRepository.save(cinderace);

        Card seismitoad = new Card("Seismitoad","https://wallpapercave.com/wp/wp3611413.jpg",water,105,95,75,85,75,74,4);
        cardRepository.save(seismitoad);

        ownershipRepository.save(new Ownership(leon, aegislash, true));
        ownershipRepository.save(new Ownership(leon, coalossal, true));
        ownershipRepository.save(new Ownership(leon, dragapult, true));
        ownershipRepository.save(new Ownership(leon, haxorus, true));
        ownershipRepository.save(new Ownership(leon, mrRime, true));
        ownershipRepository.save(new Ownership(leon, seismitoad, true));
        ownershipRepository.save(new Ownership(leon, rhyperior, true));
        ownershipRepository.save(new Ownership(leon, rillaboom, true));
        ownershipRepository.save(new Ownership(leon, cinderace, true));
        ownershipRepository.save(new Ownership(leon, inteleon, true));
        ownershipRepository.save(new Ownership(leon, charizard, true));

        // Eesaa's Pokemon
        Account eesaa = new Account("Eesaa", "", "Pokemon Master (?)", false);
        accountRepository.save(eesaa);

        Card gengar = new Card("Gengar", "https://pbs.twimg.com/media/EHvW_w0XYAAD7EG.jpg:large", ghost, 60, 65, 60, 130, 75, 110, 4);
        cardRepository.save(gengar);
        Card megaCharizardY = new Card("Mega Charizard Y", "https://i.pinimg.com/originals/81/91/34/81913402a0f8d4a2ca634b9e78cee769.jpg", fire, 78, 104, 78, 159, 115, 100, 5);
        cardRepository.save(megaCharizardY);
        Card darkrai = new Card("Darkrai", "https://rare-gallery.com/uploads/posts/966716-Pokmon-Darkrai-digital-digital-art-artwork-fantasy-art.jpg", dark, 70, 90, 90, 135, 90, 125, 5);
        cardRepository.save(darkrai);
        Card jolteon = new Card("Jolteon", "https://i.pinimg.com/originals/36/fa/2a/36fa2ab7d8462587384d30874183a06b.png", electric, 65, 65, 60, 110, 95, 130, 4);
        cardRepository.save(jolteon);
        Card metapod = new Card("Metapod", "https://64.media.tumblr.com/77b6e01e99db3755b554d76f17a65a17/tumblr_p6a6hhJJTH1twwdivo1_500.png", bug, 50, 20, 55, 25, 25, 30, 1);
        cardRepository.save(metapod);
        Card dragonite = new Card("Dragonite", "https://preview.redd.it/dragonite-v-alt-art-text-borders-removed-ai-upscaled-v0-d8pz4yjgab5a1.png?auto=webp&s=de7d95efc6cb03e356f812b2286a4848fd32580d", dragon, 91, 134, 95, 100, 100, 80, 5);
        cardRepository.save(dragonite);
        Card noivern = new Card("Noivern", "https://64.media.tumblr.com/3020758ba8c72b424abe5726851316c9/5008cabf4f35adb5-c7/s1280x1920/dadf8865b50b8e5dff86fdd12095bff0da6d1afd.png", dragon, 85, 70, 80, 97, 80, 123, 4);
        cardRepository.save(noivern);
        Card lunala = new Card("Lunala", "https://i.pinimg.com/550x/7c/4c/fa/7c4cfae595b8f0f02f5fe1cda22936e3.jpg", psychic, 137, 113, 89, 137, 107, 97, 6);
        cardRepository.save(lunala);
        Card swampert = new Card("Swampert", "https://cdn.donmai.us/original/6f/56/6f560b0260c4634d090568e9cad91b8a.jpg", water, 100, 110, 90, 85, 90, 60, 4);
        cardRepository.save(swampert);

        ownershipRepository.save(new Ownership(eesaa, metapod, true));
        ownershipRepository.save(new Ownership(eesaa, jolteon, true));
        ownershipRepository.save(new Ownership(eesaa, gengar, true));
        ownershipRepository.save(new Ownership(eesaa, noivern, true));
        ownershipRepository.save(new Ownership(eesaa, swampert, true));
        ownershipRepository.save(new Ownership(eesaa, infernape, true));
        ownershipRepository.save(new Ownership(eesaa, inteleon, true));
        ownershipRepository.save(new Ownership(eesaa, dragonite, true));
        ownershipRepository.save(new Ownership(eesaa, megaCharizardY, true));
        ownershipRepository.save(new Ownership(eesaa, darkrai, true));
        ownershipRepository.save(new Ownership(eesaa, lunala, true));

        // Will's Pokemon
        Account will = new Account("Will", "", "Pokemon Breeder", false);
        accountRepository.save(will);

        Card vaporeon = new Card("Vaporeon", "https://i.pinimg.com/564x/f7/35/e1/f735e17c0402769543d7c1eaf27fa72b.jpg", water, 130, 65, 60, 110, 95, 65, 4);
        cardRepository.save(vaporeon);
        Card torterra = new Card("Torterra", "https://wallpapers.com/images/hd/torterra-under-the-sun-og65p5y1q4j4pcq0.jpg", grass, 95, 109, 105, 75, 85, 56, 4);
        cardRepository.save(torterra);
        Card tyranitar = new Card("Tyranitar", "https://digwallpapers.com/wallpapers/full/c/c/0/110058-1400x1920-tyranitar-wallpaper-image-phone-hd.jpg", rock, 100, 134, 110, 95, 100, 61, 5);
        cardRepository.save(tyranitar);
        Card salamence = new Card("Salamence", "https://mfiles.alphacoders.com/789/789858.jpg", dragon, 95, 135, 80, 110, 80, 100, 5);
        cardRepository.save(salamence);
        Card chandelure = new Card("Chandelure", "https://i.pinimg.com/originals/8c/25/4f/8c254ff8a1bab1e7abda2e2dcc713b76.jpg", ghost, 60, 55, 90, 145, 90, 80, 4);
        cardRepository.save(chandelure);
        Card gallade = new Card("Gallade", "https://images4.alphacoders.com/838/838811.png", psychic, 68, 125, 65, 65, 115, 80, 4);
        cardRepository.save(gallade);
        Card rotomWash = new Card("Rotom-Wash", "https://i.pinimg.com/736x/03/85/20/038520bbed02136ffc4f083560ee7130.jpg", water, 50, 65, 107, 105, 107, 86, 4);
        cardRepository.save(rotomWash);
        Card rayquaza = new Card("Rayquaza", "https://newcdn.mowplayer.com/689084892688/2021/12/09/thumbnails/b1onbjgveic4ysde.jpg", dragon, 105, 150, 90, 150, 90, 95, 6);
        cardRepository.save(rayquaza);

        ownershipRepository.save(new Ownership(will, vaporeon, true));
        ownershipRepository.save(new Ownership(will, magnezone, true));
        ownershipRepository.save(new Ownership(will, garchomp, true));
        ownershipRepository.save(new Ownership(will, torterra, true));
        ownershipRepository.save(new Ownership(will, tyranitar, true));
        ownershipRepository.save(new Ownership(will, salamence, true));
        ownershipRepository.save(new Ownership(will, chandelure, true));
        ownershipRepository.save(new Ownership(will, gallade, true));
        ownershipRepository.save(new Ownership(will, rotomWash, true));
        ownershipRepository.save(new Ownership(will, megaLucario, true));
        ownershipRepository.save(new Ownership(will, rayquaza, true));

        // Bav's Pokemon
        Account bav = new Account("Bav", "", "Veteran", false);
        accountRepository.save(bav);

        Card scizor = new Card("Scizor", "https://cdn.donmai.us/original/57/c8/57c82e4b88edf513efbcf55b9de9300c.jpg", bug, 70, 130, 100, 55, 80, 65, 4 );
        cardRepository.save(scizor);
        Card electivire = new Card("Electivire", "https://i.kym-cdn.com/photos/images/original/001/968/248/393", electric, 75, 123, 67, 95, 85, 95, 4);
        cardRepository.save(electivire);
        Card umbreon = new Card("Umbreon", "https://tcg.pokemon.com/assets/img/home/wallpapers/wallpaper-46.jpg", dark, 95, 65, 110, 60, 130, 65, 4);
        cardRepository.save(umbreon);
        Card empoleon = new Card("Empoleon", "https://staticg.sportskeeda.com/editor/2021/11/3c58d-16377935023661-1920.jpg", water, 84, 86, 88, 111, 101, 60, 4);
        cardRepository.save(empoleon);
        Card staraptor = new Card("Staraptor", "https://w0.peakpx.com/wallpaper/124/232/HD-wallpaper-staraptor-pokemon-flying-game-pokemon-staraptor.jpg", flying, 85, 120, 70, 50, 60, 100, 4);
        cardRepository.save(staraptor);
        Card bisharp = new Card("Bisharp", "https://cdna.artstation.com/p/assets/images/images/032/093/650/large/nicolas-ahumada-bisharp-artstation.jpg?1605465015", dark, 65, 125, 100, 60, 70, 70, 4);
        cardRepository.save(bisharp);
        Card metagross = new Card("Metagross", "https://cdn.donmai.us/sample/f3/40/__metagross_pokemon_drawn_by_penta_oekaki__sample-f340ea4abdf2bf69b2ebedd0241fc5eb.jpg", steel, 80, 135, 130, 95, 90, 70, 5);
        cardRepository.save(metagross);
        Card megaBlaziken = new Card("Mega Blaziken", "https://cdn.donmai.us/original/f9/15/f915ee93b28704b053c1289016a9fe85.jpg", fire, 80, 160, 80, 130, 80, 100, 5);
        cardRepository.save(megaBlaziken);
        Card zekrom = new Card("Zekrom", "https://cdn.donmai.us/original/65/bd/65bdfdc631b0040b90b16c6006314f9f.png", dragon, 100, 150, 120, 120, 100, 90, 6);
        cardRepository.save(zekrom);

        ownershipRepository.save(new Ownership(bav, aggron, true));
        ownershipRepository.save(new Ownership(bav, heracross, true));
        ownershipRepository.save(new Ownership(bav, umbreon, true));
        ownershipRepository.save(new Ownership(bav, staraptor, true));
        ownershipRepository.save(new Ownership(bav, bisharp, true));
        ownershipRepository.save(new Ownership(bav, electivire, true));
        ownershipRepository.save(new Ownership(bav, empoleon, true));
        ownershipRepository.save(new Ownership(bav, scizor, true));
        ownershipRepository.save(new Ownership(bav, metagross, true));
        ownershipRepository.save(new Ownership(bav, megaBlaziken, true));
        ownershipRepository.save(new Ownership(bav, zekrom, true));



        // Shawn
        Account shawn = new Account("Shawn", "password", "Leader", false);
        accountRepository.save(shawn);

        Card serperior = new Card("Serperior", "https://jutsume.com/images/2022/05/07/pokemon-serperior-wallpaper.jpg", grass, 75, 75, 95, 75, 95, 113, 4);
        cardRepository.save(serperior);
        Card grovyle = new Card("Grovyle", "https://i.pinimg.com/564x/47/da/fd/47dafdfb41bfbd39b005bcb2845f6d02.jpg", grass, 50, 65, 45, 85, 65, 95, 3);
        cardRepository.save(grovyle);
        Card delphox = new Card("Delphox", "https://i.pinimg.com/originals/32/b0/5d/32b05dd63ce945f12b26bfde77b8f339.jpg", fire, 75, 69, 72, 114, 100, 104, 4);
        cardRepository.save(delphox);
        Card krookodile = new Card("Krookodile", "https://cdna.artstation.com/p/assets/images/images/030/409/838/large/korey-penney-krookodile.jpg?1600520162", ground, 95, 117, 80, 65, 70, 92, 4);
        cardRepository.save(krookodile);
        Card feraligatr = new Card("Feraligatr", "https://cdn.donmai.us/original/d8/e4/d8e4b7e543048cc920553d2afbb18bfe.png", water, 85, 105, 100, 79, 83, 78, 4);
        cardRepository.save(feraligatr);
        Card gardevoir = new Card("Gardevoir", "https://tcg.pokemon.com/assets/img/home/wallpapers/wallpaper-22.jpg", psychic, 68, 65, 65, 125, 115, 80, 4);
        cardRepository.save(gardevoir);
        Card glaceon = new Card("Glaceon", "https://cdn.donmai.us/original/fa/3a/fa3a5710cf3bd5797e327218933e1b8e.jpg", ice, 65, 60, 110, 130, 95, 65, 4);
        cardRepository.save(glaceon);
        Card sableye = new Card("Sableye", "https://pbs.twimg.com/media/E2-hdaDWUAoz-TP.jpg", dark, 50, 75, 75, 65, 65, 50, 3);
        cardRepository.save(sableye);
        Card zygarde = new Card("Zygarde", "https://i.pinimg.com/736x/a3/aa/f3/a3aaf32f69125b55475ad4324b93f601.jpg", dragon, 108, 100, 121, 81, 95, 95, 5);
        cardRepository.save(zygarde);


        ownershipRepository.save(new Ownership(shawn, serperior, true));
        ownershipRepository.save(new Ownership(shawn, grovyle, true));
        ownershipRepository.save(new Ownership(shawn, delphox, true));
        ownershipRepository.save(new Ownership(shawn, krookodile, true));
        ownershipRepository.save(new Ownership(shawn, feraligatr, true));
        ownershipRepository.save(new Ownership(shawn, gardevoir, true));
        ownershipRepository.save(new Ownership(shawn, machamp, true));
        ownershipRepository.save(new Ownership(shawn, glaceon, true));
        ownershipRepository.save(new Ownership(shawn, sableye, true));
        ownershipRepository.save(new Ownership(shawn, zoroark, true));
        ownershipRepository.save(new Ownership(shawn, zygarde, true));

        //Losh
        Account losh = new Account("Losh", "", "Pokemon Connoisseur", false);
        accountRepository.save(losh);

        Card hooh = new Card("Ho-oh", "https://i.pinimg.com/originals/df/e7/e0/dfe7e004027fbf880e39836bf221f4f2.jpg", fire, 106, 130, 90, 110, 154, 90, 6);
        cardRepository.save(hooh);
        Card giratina = new Card("Giratina", "https://pbs.twimg.com/media/FXuZqr-aIAA1yhR.jpg:large", ghost, 150, 100, 120, 100, 120, 90, 6 );
        cardRepository.save(giratina);
        Card sawk = new Card("Sawk", "https://i.imgur.com/fspNjKR.jpg", fighting, 75, 125, 75, 30, 75, 85, 3);
        cardRepository.save(sawk);
        Card goodra = new Card("Goodra", "https://pbs.twimg.com/media/FOeCMitXMAMpE-E?format=jpg&name=large", dragon, 90, 100, 70, 110, 150, 80, 5);
        cardRepository.save(goodra);
        Card beartic = new Card("Beartic", "https://i.pinimg.com/originals/cf/03/2d/cf032d2af799dd8b496f5a60a8ffbd37.jpg", ice, 95, 130, 80, 70, 80, 50, 4);
        cardRepository.save(beartic);
        Card trubbish = new Card("Trubbish", "https://d.furaffinity.net/art/haychel/1378191688/1378191688.haychel_trubbish.jpg", poison, 50, 50, 62, 40, 62, 65,1 );
        cardRepository.save(trubbish);

        ownershipRepository.save(new Ownership(losh, hooh, true ));
        ownershipRepository.save(new Ownership(losh, giratina, true));
        ownershipRepository.save(new Ownership(losh, sawk, true));
        ownershipRepository.save(new Ownership(losh, goodra, true));
        ownershipRepository.save(new Ownership(losh, beartic, true));
        ownershipRepository.save(new Ownership(losh, trubbish, true));
        ownershipRepository.save(new Ownership(losh, megaCharizardX, true));
        ownershipRepository.save(new Ownership(losh, alolanNinetales, true));
        ownershipRepository.save(new Ownership(losh, shinyGyarados, true));
        ownershipRepository.save(new Ownership(losh, lucario, true));
        ownershipRepository.save(new Ownership(losh, arcanine, true));

    }

}


