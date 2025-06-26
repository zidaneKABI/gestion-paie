package zid.paie.demo.services;

import java.util.Random;

public  class Fonctions {


    
        public static String generateMatricule(String nom)
        {
            
            if (nom == null || nom.isEmpty())
            {
            throw new IllegalArgumentException("Le nom ne doit pas être null");
            }
            
            char premiereLettre = Character.toUpperCase(nom.charAt(0));
            Random random = new Random();
            StringBuilder nombreSansZero = new StringBuilder();

            // Génère 5 chiffres aléatoires entre 1 et 9
            for (int i = 0; i < 5; i++) 
            {
            int chiffre = random.nextInt(9) + 1; // entre 1 et 9
            nombreSansZero.append(chiffre);
            }

            return premiereLettre + nombreSansZero.toString();
        }

}
