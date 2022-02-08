package util;
import fr.unistra.pelican.Image;
import fr.unistra.pelican.algorithms.io.ImageLoader;
import fr.unistra.pelican.algorithms.noise.Speckle;
import fr.unistra.pelican.algorithms.visualisation.Viewer2D;

import java.io.IOException;


public class NoiseTools {

    public static Image addNoise(Image img, double noiseLevel) {

        //Déclarer une nouvelle image pour stocker resultat
        Image result = Speckle.exec(img, noiseLevel, 2);

        return result;
    }


    public static void main(String[] args) throws IOException {

        //Charger une image en memoire
        Image test = ImageLoader.exec("C:\\Users\\mediyo0207\\Downloads\\01.jpg");

        Image noisyImage = addNoise(test, 0.1);

        //Afficher une image
        noisyImage.setColor(true); //si false => affichage de chaque canal, si true => affichage d'une image couleur
        Viewer2D.exec(noisyImage);

    }

}
