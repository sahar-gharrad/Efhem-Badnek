package com.example.efhem_rouhek.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.efhem_rouhek.Entity.maladie;
import com.example.efhem_rouhek.Entity.symptomes;

import java.util.List;

@Dao
public interface SymptomeDAO {

    @Query("SELECT * FROM symptomes")
    List<symptomes> getAll();

    @Query("INSERT INTO `symptomes` (`id_symptome`, `labelle`, `id_maladie`, `degre_symp`) VALUES\n" +
            "(1, 'difficulté à respirer ou essoufflement grave', 1, 3),\n" +
            "(2, 'pression ou douleur persistante à la poitrine', 1, 3),\n" +
            "(3, 'peau, lèvres ou lits d’ongles de couleur pâle, grise ou bleue', 1, 2),\n" +
            "(4, 'mal de gorge\\r\\n', 1, 1),\n" +
            "(5, 'sensation de fièvre', 1, 1),\n" +
            "(13, 'Fièvre élevée', 2, 3),\n" +
            "(6, 'douleurs musculaires ou courbatures\\r\\n', 1, 2),\n" +
            "(7, 'perte de l’odorat ou du goût', 1, 2),\n" +
            "(8, 'mal de tête', 1, 1),\n" +
            "(9, 'douleurs abdominales', 1, 1),\n" +
            "(10, 'diarrhée et vomissements', 1, 1),\n" +
            "(14, 'frissons', 2, 2),\n" +
            "(15, 'toux sèche et douloureuse.', 2, 2),\n" +
            "(16, 'douleurs articulaires et musculaires', 2, 2),\n" +
            "(17, 'fatigue intense', 2, 2),\n" +
            "(18, 'une perte d’appétit', 3, 2),\n" +
            "(19, 'douleurs thoraciques', 3, 3),\n" +
            "(20, 'des faiblesses ou une fatigue', 3, 2),\n" +
            "(21, 'une perte de poids', 3, 3),\n" +
            "(22, 'de la fièvre', 3, 1),\n" +
            "(23, 'formation de plaques rouges bien délimitées sur la peau', 4, 3),\n" +
            "(24, 'vésicules qui se rompent au grattage et suintent', 4, 3),\n" +
            "(25, 'apparition de croûtes qui ne laissent pas de cicatrices', 4, 3),\n" +
            "(26, 'Les croûtes tombent en une à deux semaines en laissant des cicatrices rosées.', 4, 3),\n" +
            "(27, 'La sécheresse de la peau est constante', 4, 3),\n" +
            "(28, 'larmoiement des yeux, qui sont injectés de sang', 5, 3),\n" +
            "(29, 'sensations de corps étranger, de démangeaison, de brûlure et de piqûre dans l’œil', 5, 3),\n" +
            "(30, 'sécheresse oculaire ', 5, 2),\n" +
            "(31, 'sensibilité anormale à la lumière ou vision brouillée.', 5, 3),\n" +
            "(32, 'gonflement et rougeur des paupières', 5, 3),\n" +
            "(33, 'signes de conjonctivite', 7, 3),\n" +
            "(34, 'picotements et démangeaisons du nez, de la gorge et des oreilles', 7, 2),\n" +
            "(35, 'écoulement nasal clair et abondant;\\r\\n', 7, 2),\n" +
            "(36, 'maux de tête', 7, 1),\n" +
            "(37, 'fatigue', 7, 1),\n" +
            "(38, 'des troubles respiratoires', 8, 2),\n" +
            "(39, 'une enflure du visage, de la gorge, des lèvres et de la langue', 8, 3),\n" +
            "(40, 'des étourdissements\\r\\n', 8, 2),\n" +
            "(41, 'une perte de connaissance', 8, 3),\n" +
            "(42, 'un resserrement de la gorge', 8, 2),\n" +
            "(43, 'une voix rauque', 8, 2);")
    void Insterall();
}
