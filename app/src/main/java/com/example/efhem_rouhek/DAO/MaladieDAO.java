package com.example.efhem_rouhek.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.efhem_rouhek.Entity.maladie;

import java.util.List;

@Dao
public interface MaladieDAO {



    @Query("SELECT * FROM maladie")
    List<maladie> getAll();

    @Query("INSERT INTO `maladie` (`id_maladie`, `labelle`, `description`, `image`, `color`, `imagegrand`, `id_categorie`) VALUES\n" +
            "(1, 'COVID-19','La maladie à coronavirus 2019 (COVID-19) est une maladie infectieuse due au virus SARS-CoV-2.\n" +
            "La majorité des personnes atteintes de la COVID-19 ne ressentiront que des symptômes bénins ou modérés et guériront sans traitement particulier.Cependant, certaines tomberont gravement malades et auront besoin de soins médicaux. ','@drawable/coronavirus','rouge','@drawable/covid', 1),\n" +
            "(2, 'Influenza (grippe)','La grippe est une infection des voies respiratoires qui se transmet très facilement. Elle est causée par le virus de l influenza. Chaque année, la grippe circule au Québec et ailleurs dans le monde. Au Québec, elle est surtout présente de la fin de " +
            "l automne au début du printemps.','@drawable/sneeze','jaune', '@drawable/grippe', 1),\n" +
            "(3, 'tuberculose','La tuberculose (TB) est une maladie infectieuse provoquée par une mycobactérie qui se transmet par voie aérienne aussi" +
            " bien aux enfants qu aux adultes. Elle touche le plus souvent les poumons mais atteint aussi parfois autres organes et peut évoluer vers le décès si elle n est pas traitée.', '@drawable/tuberculosis','bleu','@drawable/tuberculosefond', 1),\n" +
            "(4, 'L’eczéma\\r\\n','eczéma atopique ou dermatite atopique est une maladie cutanée prurigineuse (provoquant des démangeaisons) chronique, évoluant par poussées. " +
            "Il touche principalement les nourrissons et les enfants mais peut persister à l adolescence et à l âge adulte.','@drawable/eczema','jaune','@drawable/skinfond',  2),\n" +
            "(5, 'La rosacée','La rosacée est une maladie cutanée chronique caractérisée par une atteinte des petits vaisseaux sanguins du visage." +
            " Cette maladie de la peau touche essentiellement la partie centrale du visage (front, nez, joues, menton).', '@drawable/rosacea','rouge','@drawable/skinfond', 2),\n" +
            "(6, 'Le psoriasis','Le psoriasis est une maladie inflammatoire chronique de la peau qui se manifeste par des plaques rouges présentant des squames. " +
            "Il s agit le plus souvent d une maladie bénigne, mais il existe des formes sévères (environ 20% des cas), associées à une atteinte généralisée et/ou à des douleurs articulaires. ', '@drawable/psoriasis','bleu','@drawable/skinfond', 2),\n" +
            "(7, 'Allergie au pollen\\r\\n','Les allergies au pollen sont la plupart du temps bénignes et se traduisent par une rhinite allergique (éternuements, nez bouché et/ou qui coule," +
            " yeux larmoyants). Des formes plus sévères peuvent apparaître, notamment chez les personnes avec une fragilité respiratoire, comme de l asthme par exemple ','@drawable/allergyskin' ,'jaune','@drawable/pollen', 3),\n" +
            "(8, 'Allergie alimentaire','allergie alimentaire est un ensemble de réactions immunitaires anormales, survenant après l ingestion d un aliment particulier." +
            " Celui-ci, normalement inoffensif pour l organisme, est alors appelé \" allergène \" ou \"trophallergène\" (terme désignant un allergène ingéré). ','@drawable/allergysk','rouge', '@drawable/alimentaire', 3),\n" +
            "(9, 'Allergie aux poils d’animaux ','Les manifestations allergiques aux animaux sont de plus en plus fréquentes. " +
            "Quelques minutes après le contact avec l animal peuvent apparaître écoulement nasal, rougeur des yeux, toux ou signes cutanés. Comment s explique cette allergie ? Comment la traiter ? Réponses avec le Dr Isabelle Bossé, allergologue. ','@drawable/petallergy','bleu', '@drawable/allergianimal', 3);")
    void Insterall();
}
