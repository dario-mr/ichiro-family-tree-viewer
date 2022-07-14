package com.dario.ift.core.repository;

import com.dario.ift.core.domain.Color;
import com.dario.ift.core.domain.Country;
import com.dario.ift.core.domain.Dog;
import com.dario.ift.core.domain.Gender;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import static com.dario.ift.config.CacheConfig.GET_FAMILY_TREE;
import static com.dario.ift.core.domain.Color.RED;
import static com.dario.ift.core.domain.Country.*;
import static com.dario.ift.core.domain.Gender.F;
import static com.dario.ift.core.domain.Gender.M;

@Repository
public class FamilyTreeRepository {

    @Cacheable(GET_FAMILY_TREE)
    public Dog getFamilyTree() { // TODO currently up to generation 5...
        return buildDog(1, "Ichiro Go Takimisou", M, RED, RU, LocalDate.of(2021, 10, 14), "", "http://www.shiba-pedigree.ru/details.php?id=79238",
                buildDog(2, "Triumf Sibiri W'vip Go Takimisou", M, RED, RU, LocalDate.of(2018, 4, 29), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5ce5526a54e75.JPG", "http://www.shiba-pedigree.ru/details.php?id=72439",
                        buildDog(3, "Hikay's Takes The Lead", M, RED, RU, LocalDate.of(2016, 8, 16), "http://www.shiba-pedigree.ru/pics/medium/2581/med_5901bac984d1a.jpg", "http://www.shiba-pedigree.ru/details.php?id=70124",
                                buildDog(4, "Copperdots One To Watch At Hikay's", M, RED, US, null, "", "http://www.shiba-pedigree.ru/details.php?id=69029",
                                        buildDog(5, "Toushin No Taira Go Kishuu Toushinsou", M, RED, JP, LocalDate.of(2011, 8, 20), "http://www.shiba-pedigree.ru/pics/medium/2409/med_57b5d57f82025.jpg", "http://www.shiba-pedigree.ru/details.php?id=69030",
                                                null,
                                                null),
                                        buildDog(5, "Copperdots Beikoku Ichiban", F, RED, US, LocalDate.of(2013, 3, 29), "http://www.shiba-pedigree.ru/pics/medium/2409/med_57b5d6f8ed33d.jpg", "http://www.shiba-pedigree.ru/details.php?id=69032",
                                                null,
                                                null)),
                                buildDog(4, "Hikay's Damit Janet", F, RED, UK, null, "", "http://www.shiba-pedigree.ru/details.php?id=69124",
                                        buildDog(5, "Kintoki Shinda Kashshu", M, null, UK, null, "", "http://www.shiba-pedigree.ru/details.php?id=69125",
                                                null,
                                                null),
                                        buildDog(5, "Hikay's Que Sera Sera", F, null, UK, null, "", "http://www.shiba-pedigree.ru/details.php?id=69126",
                                                null,
                                                null))),
                        buildDog(3, "Dar Chingiza Vest Virginia", F, RED, RU, LocalDate.of(2015, 5, 1), "http://www.shiba-pedigree.ru/pics/medium/2409/med_57cd27180f3af.jpg", "http://www.shiba-pedigree.ru/details.php?id=69077",
                                buildDog(4, "Handzimesite Yugake's", M, RED, RU, LocalDate.of(2013, 3, 30), "http://www.shiba-pedigree.ru/pics/medium/2414/med_5795d65a2686f.jpg", "http://www.shiba-pedigree.ru/details.php?id=66453",
                                        buildDog(5, "Juhou Go Kuwana Mitomosou", M, RED, JP, LocalDate.of(2006, 10, 3), "http://www.shiba-pedigree.ru/pics/medium/2390/med_554243b36841b.jpg", "http://www.shiba-pedigree.ru/details.php?id=63200",
                                                null,
                                                null),
                                        buildDog(5, "Orienta Hoshi No Ame", F, RED, AU, LocalDate.of(2010, 11, 26), "http://www.shiba-pedigree.ru/pics/medium/2504/med_5426f45e0abe8.jpg", "http://www.shiba-pedigree.ru/details.php?id=65107",
                                                null,
                                                null)),
                                buildDog(4, "Murakami Miki Kiyosi", F, RED, RU, LocalDate.of(2013, 8, 4), "http://www.shiba-pedigree.ru/pics/medium/2414/med_574b42cbea5e0.jpg", "http://www.shiba-pedigree.ru/details.php?id=68772",
                                        buildDog(5, "Handzimemesite Bouken", M, RED, RU, LocalDate.of(2010, 10, 1), "http://www.shiba-pedigree.ru/pics/medium/2476/med_555b84d0365e2.jpg", "http://www.shiba-pedigree.ru/details.php?id=65299",
                                                null,
                                                null),
                                        buildDog(5, "Snezhnyi Angel Akane", F, RED, RU, LocalDate.of(2009, 9, 22), "", "http://www.shiba-pedigree.ru/details.php?id=63730",
                                                null,
                                                null)))),
                buildDog(2, "Jasmine Go Takimisou", F, RED, RU, LocalDate.of(2019, 12, 5), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5fb3a755d6bb4.JPG", "http://www.shiba-pedigree.ru/details.php?id=76194",
                        buildDog(3, "Epic Go Takimisou", M, RED, RU, LocalDate.of(2018, 4, 9), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5d02be5a3a4e4.JPG", "http://www.shiba-pedigree.ru/details.php?id=72425",
                                buildDog(4, "Sunojo's High Tide", M, RED, CA, LocalDate.of(2009, 9, 21), "http://www.shiba-pedigree.ru/pics/medium/2395/med_5710fe73e3369.png", "http://www.shiba-pedigree.ru/details.php?id=64335",
                                        buildDog(5, "Katai's Daichi No Sunojo", M, RED, US, LocalDate.of(2006, 2, 26), "http://www.shiba-pedigree.ru/pics/medium/2274/med_4e85b14fb7d7c.jpg", "http://www.shiba-pedigree.ru/details.php?id=64316",
                                                null,
                                                null),
                                        buildDog(5, "Sunojo's The Moon And The Sea", F, RED, CA, LocalDate.of(2007, 7, 29), "http://www.shiba-pedigree.ru/pics/medium/2516/med_5c97a8f9d47ea.jpg", "http://www.shiba-pedigree.ru/details.php?id=64323",
                                                null,
                                                null)),
                                buildDog(4, "Kenline Olimpia", F, RED, RU, LocalDate.of(2016, 9, 11), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5ae6422ba6e3b.JPG", "http://www.shiba-pedigree.ru/details.php?id=71478",
                                        buildDog(5, "Handzimemesite Rikikadze", M, RED, RU, LocalDate.of(2014, 2, 8), "http://www.shiba-pedigree.ru/pics/medium/2391/med_56e59ee6b06ee.jpg", "http://www.shiba-pedigree.ru/details.php?id=68061",
                                                null,
                                                null),
                                        buildDog(5, "Hana Montana Kenlain", F, RED, RU, LocalDate.of(2014, 2, 2), "", "http://www.shiba-pedigree.ru/details.php?id=67557",
                                                null,
                                                null))),
                        buildDog(3, "Ruzh Renar Jeanette", F, RED, RU, LocalDate.of(2017, 10, 22), "http://www.shiba-pedigree.ru/pics/medium/2554/med_5ce550ae1c011.JPG", "http://www.shiba-pedigree.ru/details.php?id=71784",
                                buildDog(4, "Shitonuba Akihiro Katsuro", M, RED, RU, LocalDate.of(2015, 2, 2), "http://www.shiba-pedigree.ru/pics/medium/2409/med_59971ebc318ee.jpg", "http://www.shiba-pedigree.ru/details.php?id=67670",
                                        buildDog(5, "Jaklho Keep A Dream In Your Pocket", M, RED, NL, LocalDate.of(2010, 9, 17), "http://www.shiba-pedigree.ru/pics/medium/2292/med_5b31bd33da98d.jpg", "http://www.shiba-pedigree.ru/details.php?id=66750",
                                                null,
                                                null),
                                        buildDog(5, "Handzimemesite Chizato", F, RED, RU, LocalDate.of(2010, 5, 15), "http://www.shiba-pedigree.ru/pics/medium/2497/med_537a43a85fb37.jpg", "http://www.shiba-pedigree.ru/details.php?id=65151",
                                                null,
                                                null)),
                                buildDog(4, "Ruzh Renar Amaya", F, RED, RU, LocalDate.of(2014, 12, 23), "http://www.shiba-pedigree.ru/pics/medium/2513/med_568e8eb17673b.jpg", "http://www.shiba-pedigree.ru/details.php?id=67404",
                                        buildDog(5, "Handzimemesite Fusavasiy Aite", M, RED, RU, LocalDate.of(2012, 9, 5), "http://www.shiba-pedigree.ru/pics/medium/2418/med_62a19f21b607e.jpeg", "http://www.shiba-pedigree.ru/details.php?id=65624",
                                                null,
                                                null),
                                        buildDog(5, "Lyurua Dyuring Hiroko Koya-san", F, RED, RU, LocalDate.of(2011, 9, 10), "http://www.shiba-pedigree.ru/pics/medium/2433/med_5142a2744219c.jpg", "http://www.shiba-pedigree.ru/details.php?id=65431",
                                                null,
                                                null)))
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
