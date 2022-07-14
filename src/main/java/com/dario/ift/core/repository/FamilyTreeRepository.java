package com.dario.ift.core.repository;

import com.dario.ift.core.domain.Color;
import com.dario.ift.core.domain.Country;
import com.dario.ift.core.domain.Dog;
import com.dario.ift.core.domain.Gender;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import static com.dario.ift.config.CacheConfig.GET_FAMILY_TREE;
import static com.dario.ift.core.domain.Color.*;
import static com.dario.ift.core.domain.Country.*;
import static com.dario.ift.core.domain.Gender.F;
import static com.dario.ift.core.domain.Gender.M;

@Repository
public class FamilyTreeRepository {

    @Cacheable(GET_FAMILY_TREE)
    public Dog getFamilyTree() { // TODO currently up to generation 6...
        return buildDog(1, "Ichiro Go Takimisou", M, RED, RU, LocalDate.of(2021, 10, 14), "", "http://www.shiba-pedigree.ru/details.php?id=79238",
                buildDog(2, "Triumf Sibiri W'vip Go Takimisou", M, RED, RU, LocalDate.of(2018, 4, 29), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5ce5526a54e75.JPG", "http://www.shiba-pedigree.ru/details.php?id=72439",
                        buildDog(3, "Hikay's Takes The Lead", M, RED, RU, LocalDate.of(2016, 8, 16), "http://www.shiba-pedigree.ru/pics/medium/2581/med_5901bac984d1a.jpg", "http://www.shiba-pedigree.ru/details.php?id=70124",
                                buildDog(4, "Copperdots One To Watch At Hikay's", M, RED, US, null, "", "http://www.shiba-pedigree.ru/details.php?id=69029",
                                        buildDog(5, "Toushin No Taira Go Kishuu Toushinsou", M, RED, JP, LocalDate.of(2011, 8, 20), "http://www.shiba-pedigree.ru/pics/medium/2409/med_57b5d57f82025.jpg", "http://www.shiba-pedigree.ru/details.php?id=69030",
                                                buildDog(6, "Beni No Yuudai Go Sakai Yoshikawasou", M, null, JP, LocalDate.of(2007, 7, 6), "", "http://www.shiba-pedigree.ru/details.php?id=69031", null, null),
                                                buildDog(6, "Touka Go Kishuu Toushinsou", F, null, JP, null, "", "http://www.shiba-pedigree.ru/details.php?id=69036", null, null)),
                                        buildDog(5, "Copperdots Beikoku Ichiban", F, RED, US, LocalDate.of(2013, 3, 29), "http://www.shiba-pedigree.ru/pics/medium/2409/med_57b5d6f8ed33d.jpg", "http://www.shiba-pedigree.ru/details.php?id=69032",
                                                buildDog(6, "Copperdots Beikoku Tetsu", M, RED, US, LocalDate.of(2010, 8, 10), "http://www.shiba-pedigree.ru/pics/medium/2409/med_57b5d90ee644d.jpg", "http://www.shiba-pedigree.ru/details.php?id=69033", null, null),
                                                buildDog(6, "Copperdots Beikoku Ichiko", F, RED, US, LocalDate.of(2011, 6, 15), "http://www.shiba-pedigree.ru/pics/medium/2409/med_57b5db3714625.jpg", "http://www.shiba-pedigree.ru/details.php?id=69034", null, null))),
                                buildDog(4, "Hikay's Damit Janet", F, RED, UK, null, "", "http://www.shiba-pedigree.ru/details.php?id=69124",
                                        buildDog(5, "Kintoki Shinda Kashshu", M, null, UK, null, "", "http://www.shiba-pedigree.ru/details.php?id=69125",
                                                buildDog(6, "Yuudai Go Torishimasou", M, BLACK, US, LocalDate.of(2008, 11, 20), "http://www.shiba-pedigree.ru/pics/medium/2409/med_57e54f26055f5.jpg", "http://www.shiba-pedigree.ru/details.php?id=69127", null, null),
                                                buildDog(6, "Kintoki Angelica Pickles", F, null, UK, null, "", "http://www.shiba-pedigree.ru/details.php?id=69128", null, null)),
                                        buildDog(5, "Hikay's Que Sera Sera", F, null, UK, null, "", "http://www.shiba-pedigree.ru/details.php?id=69126",
                                                buildDog(6, "Sapporo Sergio Ross At Deanery", M, null, UK, LocalDate.of(2004, 9, 13), "", "http://www.shiba-pedigree.ru/details.php?id=69739", null, null),
                                                buildDog(6, "Hikay's Rumour Has It", F, null, UK, LocalDate.of(2010, 4, 27), "", "http://www.shiba-pedigree.ru/details.php?id=69740", null, null)))),
                        buildDog(3, "Dar Chingiza Vest Virginia", F, RED, RU, LocalDate.of(2015, 5, 1), "http://www.shiba-pedigree.ru/pics/medium/2409/med_57cd27180f3af.jpg", "http://www.shiba-pedigree.ru/details.php?id=69077",
                                buildDog(4, "Handzimesite Yugake's", M, RED, RU, LocalDate.of(2013, 3, 30), "http://www.shiba-pedigree.ru/pics/medium/2414/med_5795d65a2686f.jpg", "http://www.shiba-pedigree.ru/details.php?id=66453",
                                        buildDog(5, "Juhou Go Kuwana Mitomosou", M, RED, JP, LocalDate.of(2006, 10, 3), "http://www.shiba-pedigree.ru/pics/medium/2390/med_554243b36841b.jpg", "http://www.shiba-pedigree.ru/details.php?id=63200",
                                                buildDog(6, "Mori No Toyokuni Go Yoshino Ichimorisou", M, RED, JP, null, "http://www.shiba-pedigree.ru/pics/medium/2318/med_50d7938266ecb.jpg", "http://www.shiba-pedigree.ru/details.php?id=63201", null, null),
                                                buildDog(6, "Wakame Go To Get Mitomosou", F, null, JP, null, "http://www.shiba-pedigree.ru/pics/medium/2461/med_54255421ae3ec.JPG", "http://www.shiba-pedigree.ru/details.php?id=63208", null, null)),
                                        buildDog(5, "Orienta Hoshi No Ame", F, RED, AU, LocalDate.of(2010, 11, 26), "http://www.shiba-pedigree.ru/pics/medium/2504/med_5426f45e0abe8.jpg", "http://www.shiba-pedigree.ru/details.php?id=65107",
                                                buildDog(6, "Snostorm's American Playboy Of Orienta", M, RED, US, LocalDate.of(2008, 10, 28), "http://www.shiba-pedigree.ru/pics/medium/2250/med_552000c16c6ca.jpg", "http://www.shiba-pedigree.ru/details.php?id=65108", null, null),
                                                buildDog(6, "Orienta Envy Me", F, null, AU, null, "", "http://www.shiba-pedigree.ru/details.php?id=65109", null, null))),
                                buildDog(4, "Murakami Miki Kiyosi", F, RED, RU, LocalDate.of(2013, 8, 4), "http://www.shiba-pedigree.ru/pics/medium/2414/med_574b42cbea5e0.jpg", "http://www.shiba-pedigree.ru/details.php?id=68772",
                                        buildDog(5, "Handzimemesite Bouken", M, RED, RU, LocalDate.of(2010, 10, 1), "http://www.shiba-pedigree.ru/pics/medium/2476/med_555b84d0365e2.jpg", "http://www.shiba-pedigree.ru/details.php?id=65299",
                                                buildDog(6, "Juhou Go Kuwana Mitomosou", M, RED, JP, LocalDate.of(2008, 10, 3), "http://www.shiba-pedigree.ru/pics/medium/2390/med_554243b36841b.jpg", "http://www.shiba-pedigree.ru/details.php?id=63200", null, null),
                                                buildDog(6, "Mara-shimas Mami Reigai", F, RED, NL, LocalDate.of(2009, 6, 7), "http://www.shiba-pedigree.ru/pics/medium/2260/med_4b9ea01ce46bd.jpg", "http://www.shiba-pedigree.ru/details.php?id=63541", null, null)),
                                        buildDog(5, "Snezhnyi Angel Akane", F, RED, RU, LocalDate.of(2009, 9, 22), "", "http://www.shiba-pedigree.ru/details.php?id=63730",
                                                buildDog(6, "Handzimemesite Yakuriu", M, RED, RU, LocalDate.of(2008, 7, 31), "http://www.shiba-pedigree.ru/pics/medium/2451/med_517ee75923086.jpg", "http://www.shiba-pedigree.ru/details.php?id=63731", null, null),
                                                buildDog(6, "Eyga-suta S Akulovoy Gori", F, RED, RU, LocalDate.of(2008, 7, 17), "http://www.shiba-pedigree.ru/pics/medium/2430/med_5be426ae6ae67.jpg", "http://www.shiba-pedigree.ru/details.php?id=63732", null, null))))),
                buildDog(2, "Jasmine Go Takimisou", F, RED, RU, LocalDate.of(2019, 12, 5), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5fb3a755d6bb4.JPG", "http://www.shiba-pedigree.ru/details.php?id=76194",
                        buildDog(3, "Epic Go Takimisou", M, RED, RU, LocalDate.of(2018, 4, 9), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5d02be5a3a4e4.JPG", "http://www.shiba-pedigree.ru/details.php?id=72425",
                                buildDog(4, "Sunojo's High Tide", M, RED, CA, LocalDate.of(2009, 9, 21), "http://www.shiba-pedigree.ru/pics/medium/2395/med_5710fe73e3369.png", "http://www.shiba-pedigree.ru/details.php?id=64335",
                                        buildDog(5, "Katai's Daichi No Sunojo", M, RED, US, LocalDate.of(2006, 2, 26), "http://www.shiba-pedigree.ru/pics/medium/2274/med_4e85b14fb7d7c.jpg", "http://www.shiba-pedigree.ru/details.php?id=64316",
                                                buildDog(6, "Hi-jinx American Grafitti", M, RED, US, LocalDate.of(2004, 4, 8), "", "http://www.shiba-pedigree.ru/details.php?id=64317", null, null),
                                                buildDog(6, "Sunojo's Ms Canada No Katai", F, RED, CA, LocalDate.of(2003, 10, 25), "http://www.shiba-pedigree.ru/pics/medium/2274/med_4e85b96e75299.jpg", "http://www.shiba-pedigree.ru/details.php?id=64383", null, null)),
                                        buildDog(5, "Sunojo's The Moon And The Sea", F, RED, CA, LocalDate.of(2007, 7, 29), "http://www.shiba-pedigree.ru/pics/medium/2516/med_5c97a8f9d47ea.jpg", "http://www.shiba-pedigree.ru/details.php?id=64323",
                                                buildDog(6, "Sunojo Bad Moon Rising", M, SESAME, CA, LocalDate.of(2005, 5, 10), "http://www.shiba-pedigree.ru/pics/medium/2516/med_5c97a9bacbf76.jpg", "http://www.shiba-pedigree.ru/details.php?id=64325", null, null),
                                                buildDog(6, "Sunojo's Sea Goddess", F, RED, CA, null, "http://www.shiba-pedigree.ru/pics/medium/2516/med_5c97a9854238b.jpg", "http://www.shiba-pedigree.ru/details.php?id=64326", null, null))),
                                buildDog(4, "Kenline Olimpia", F, RED, RU, LocalDate.of(2016, 9, 11), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5ae6422ba6e3b.JPG", "http://www.shiba-pedigree.ru/details.php?id=71478",
                                        buildDog(5, "Handzimemesite Rikikadze", M, RED, RU, LocalDate.of(2014, 2, 8), "http://www.shiba-pedigree.ru/pics/medium/2391/med_56e59ee6b06ee.jpg", "http://www.shiba-pedigree.ru/details.php?id=68061",
                                                buildDog(6, "Handzimemesite O-raydon", M, RED, RU, LocalDate.of(2011, 11, 13), "http://www.shiba-pedigree.ru/pics/medium/2504/med_542a7cbee32c1.jpg", "http://www.shiba-pedigree.ru/details.php?id=65640", null, null),
                                                buildDog(6, "Handzimemesite Mabusii Hodono Ucukusisa", F, RED, RU, LocalDate.of(2011, 9, 2), "", "http://www.shiba-pedigree.ru/details.php?id=68090", null, null)),
                                        buildDog(5, "Hana Montana Kenlain", F, RED, RU, LocalDate.of(2014, 2, 2), "", "http://www.shiba-pedigree.ru/details.php?id=67557",
                                                buildDog(6, "Handzimemesite Fuukaku-no Aru", M, RED, RU, LocalDate.of(2012, 9, 5), "http://www.shiba-pedigree.ru/pics/medium/2250/med_5a983ad495334.jpg", "http://www.shiba-pedigree.ru/details.php?id=66476", null, null),
                                                buildDog(6, "Shakura San Go You Djenima", F, RED, UA, LocalDate.of(2012, 2, 11), "http://www.shiba-pedigree.ru/pics/medium/2391/med_5258efca249bc.jpg", "http://www.shiba-pedigree.ru/details.php?id=65966", null, null)))),
                        buildDog(3, "Ruzh Renar Jeanette", F, RED, RU, LocalDate.of(2017, 10, 22), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5ce550ae1c011.JPG", "http://www.shiba-pedigree.ru/details.php?id=71784",
                                buildDog(4, "Shitonuba Akihiro Katsuro", M, RED, RU, LocalDate.of(2015, 2, 2), "http://www.shiba-pedigree.ru/pics/medium/2409/med_59971ebc318ee.jpg", "http://www.shiba-pedigree.ru/details.php?id=67670",
                                        buildDog(5, "Jaklho Keep A Dream In Your Pocket", M, RED, NL, LocalDate.of(2010, 9, 17), "http://www.shiba-pedigree.ru/pics/medium/2292/med_5b31bd33da98d.jpg", "http://www.shiba-pedigree.ru/details.php?id=66750",
                                                buildDog(6, "We-sedso Go Nippo", M, RED, DE, null, "http://www.shiba-pedigree.ru/pics/medium/2503/med_53c04161d553a.jpg", "http://www.shiba-pedigree.ru/details.php?id=66751", null, null),
                                                buildDog(6, "Jaklho Future Road To Avalon", F, RED, NL, LocalDate.of(2005, 6, 16), "http://www.shiba-pedigree.ru/pics/medium/2534/med_59ec6605650a1.jpg", "http://www.shiba-pedigree.ru/details.php?id=66442", null, null)),
                                        buildDog(5, "Handzimemesite Chizato", F, RED, RU, LocalDate.of(2010, 5, 15), "http://www.shiba-pedigree.ru/pics/medium/2497/med_537a43a85fb37.jpg", "http://www.shiba-pedigree.ru/details.php?id=65151",
                                                buildDog(6, "Juhou Go Kuwana Mitomosou", M, RED, JP, LocalDate.of(2006, 10, 3), "http://www.shiba-pedigree.ru/pics/medium/2390/med_554243b36841b.jpg", "http://www.shiba-pedigree.ru/details.php?id=63200", null, null),
                                                buildDog(6, "Copperdots Shinko", F, RED, US, LocalDate.of(2006, 10, 20), "http://www.shiba-pedigree.ru/pics/medium/2342/med_5cdeccaae332c.jpg", "http://www.shiba-pedigree.ru/details.php?id=63549", null, null))),
                                buildDog(4, "Ruzh Renar Amaya", F, RED, RU, LocalDate.of(2014, 12, 23), "http://www.shiba-pedigree.ru/pics/medium/2513/med_568e8eb17673b.jpg", "http://www.shiba-pedigree.ru/details.php?id=67404",
                                        buildDog(5, "Handzimemesite Fusavasiy Aite", M, RED, RU, LocalDate.of(2012, 9, 5), "http://www.shiba-pedigree.ru/pics/medium/2418/med_62a19f21b607e.jpeg", "http://www.shiba-pedigree.ru/details.php?id=65624",
                                                buildDog(6, "Handzimemesite Hiroshi", M, RED, RU, LocalDate.of(2009, 11, 28), "http://www.shiba-pedigree.ru/pics/medium/2292/med_6234aec9bd0c7.jpg", "http://www.shiba-pedigree.ru/details.php?id=63699", null, null),
                                                buildDog(6, "Mara-shimas Michi Naranukoi", F, RED, NL, LocalDate.of(2010, 3, 8), "", "http://www.shiba-pedigree.ru/details.php?id=63711", null, null)),
                                        buildDog(5, "Lyurua Dyuring Hiroko Koya-san", F, RED, RU, LocalDate.of(2011, 9, 10), "http://www.shiba-pedigree.ru/pics/medium/2433/med_5142a2744219c.jpg", "http://www.shiba-pedigree.ru/details.php?id=65431",
                                                buildDog(6, "Handzimemesite Umi Ga Kikoeru", M, RED, RU, LocalDate.of(2009, 8, 28), "http://www.shiba-pedigree.ru/pics/medium/2582/med_5d8dc2c0dadfa.jpeg", "http://www.shiba-pedigree.ru/details.php?id=65015", null, null),
                                                buildDog(6, "Dan-star-kom Havai Hatiko", F, RED, RU, LocalDate.of(2009, 12, 14), "http://www.shiba-pedigree.ru/pics/medium/2513/med_54d0d569aece6.jpg", "http://www.shiba-pedigree.ru/details.php?id=65432", null, null))))
                )
        );
    }

    private Dog buildDog(int generation, String name, Gender gender, Color color, Country country, LocalDate dateOfBirth, String imageUrl, String profileUrl, Dog father, Dog mother) {
        return Dog.builder()
                .name(name)
                .gender(gender.getValue())
                .country(country.getValue())
                .dateOfBirth(dateOfBirth)
                .color(color != null ? color.getValue() : null)
                .imageUrl(imageUrl)
                .profileUrl(profileUrl)
                .generation(generation)
                .mother(mother)
                .father(father)
                .build();
    }
}
