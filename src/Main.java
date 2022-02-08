import fr.unistra.pelican.ByteImage;
import fr.unistra.pelican.Image;
import fr.unistra.pelican.algorithms.io.ImageLoader;
import fr.unistra.pelican.algorithms.visualisation.Viewer2D;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Image test = ImageLoader.exec("C:\\Users\\mediyo0207\\Downloads\\sorbonne.jpg");
        Image imageTraitée = contours(test);
        imageTraitée.setColor(true); //si false => affichage de chaque canal, si true => affichage d'une image couleur
        Viewer2D.exec(imageTraitée);

    }

    /**
     * Cette fonction applique le filtre moyenneur sur l'image
     *
     * @param image l'image bruitée à traiter
     * @return l'image traitée
     */
    public static Image moyenneur(Image image) {
        ByteImage new_image = new ByteImage(image.getXDim(), image.getYDim(), 1, 1, 1);
        for (int x = 1; x < image.getXDim() - 1; x++) {
            for (int y = 1; y < image.getYDim() - 1; y++) {
                // calcul de la moyenne
                int moyenne = 0;/* = ( // TODO : A CHANGER URGENT
                        image.getPixelXYBByte(x,y,0) +
                        image.getPixelXYBByte(x+1,y+1,0) +
                        image.getPixelXYBByte(x-1,y-1,0) +
                        image.getPixelXYBByte(x-1,y,0) +
                        image.getPixelXYBByte(x,y-1,0) +
                        image.getPixelXYBByte(x-1,y+1,0) +
                        image.getPixelXYBByte(x+1,y-1,0) +
                        image.getPixelXYBByte(x,y+1,0) +
                        image.getPixelXYBByte(x+1,y,0))/9;*/
                for (int xx = -1; xx <= 1; xx++) {
                    for (int yy = -1; yy <= 1; yy++) {
                        moyenne += image.getPixelXYBByte(x + xx, y + yy, 0);
                    }
                }
                moyenne /= 9;
                // attribue le pixel dans la nouvelle image
                new_image.setPixelXYBByte(x, y, 0, moyenne);
            } // y for
        } // x for
        return new_image;
    } // moyenneur


    public static Image median(Image image) {
        ByteImage new_image = new ByteImage(image.getXDim(), image.getYDim(), 1, 1, 1);

        for (int x = 1; x < image.getXDim() - 1; x++) {
            for (int y = 1; y < image.getYDim() - 1; y++) {
                // calcul de la mediane
                int[] arr = { // TODO : A CHANGER URGENT
                        image.getPixelXYBByte(x, y, 0),
                        image.getPixelXYBByte(x + 1, y + 1, 0),
                        image.getPixelXYBByte(x - 1, y - 1, 0),
                        image.getPixelXYBByte(x - 1, y, 0),
                        image.getPixelXYBByte(x, y - 1, 0),
                        image.getPixelXYBByte(x - 1, y + 1, 0),
                        image.getPixelXYBByte(x + 1, y - 1, 0),
                        image.getPixelXYBByte(x, y + 1, 0),
                        image.getPixelXYBByte(x + 1, y, 0)
                };

                System.out.println(arr);
                Arrays.sort(arr);
                int mediane = arr[arr.length / 2];
                new_image.setPixelXYBByte(x, y, 0, mediane);
            } // y for
        } // x for
        return new_image;
    } // median

    public static Image contours(Image image) {
        ByteImage new_image = new ByteImage(image.getXDim(), image.getYDim(), 1, 1, 1);


        for (int x = 1; x < image.getXDim() - 1; x++) {
            for (int y = 1; y < image.getYDim() - 1; y++) {
                new_image.setPixelXYBByte(x, y, 0, image.getPixelXYBByte(x, y, 0) * -2);
                new_image.setPixelXYBByte(x, y, 0, image.getPixelXYBByte(x + 1, y + 1, 0)*0);
                new_image.setPixelXYBByte(x, y, 0, image.getPixelXYBByte(x - 1, y - 1, 0)*0);
                new_image.setPixelXYBByte(x, y, 0, image.getPixelXYBByte(x - 1, y, 0)*1);
                new_image.setPixelXYBByte(x, y, 0, image.getPixelXYBByte(x, y - 1, 0)*1);
                new_image.setPixelXYBByte(x, y, 0, image.getPixelXYBByte(x - 1, y + 1, 0)*0);
                new_image.setPixelXYBByte(x, y, 0, image.getPixelXYBByte(x + 1, y - 1, 0)*0);
                new_image.setPixelXYBByte(x, y, 0, image.getPixelXYBByte(x, y + 1, 0)*0);
                new_image.setPixelXYBByte(x, y, 0, image.getPixelXYBByte(x + 1, y, 0)*0);
            } // y for
        } // x for

        return new_image;
    }


} // Main
