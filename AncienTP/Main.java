import fr.unistra.pelican.ByteImage;
import fr.unistra.pelican.algorithms.io.ImageLoader;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;


import fr.unistra.pelican.Image;
import fr.unistra.pelican.algorithms.io.ImageLoader;
import fr.unistra.pelican.algorithms.visualisation.Viewer2D;

public class Test {


    public static void median(Image image){
        /**
             * Cette fonction applique le filtre median sur l'image
             *
             * @param image l'image bruitée à traiter
             *
             */
                ByteImage new_image = new ByteImage(image.getXDim(), image.getYDim(), 1, 1, 1);

                for (int x = 1; x < image.getXDim() - 1; x++) {
                    for (int y = 1; y < image.getYDim() - 1; y++) {
                        // calcul de la mediane
                        int[] arr = { //
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
        new_image.setColor(false); //si false => affichage de chaque canal, si true => affichage d'une image couleur
        Viewer2D.exec(new_image);
            } // median




    public static void main(String[] args) throws IOException {
        Image test = ImageLoader.exec("Z:\\Image\\maldive.jpg");
        median(test);
        double [] histo= getHisto(test,1);


        double[] histoRouge = getHisto(test, 0);
        double[] histoVert = getHisto(test, 1);
        double[] histoBleu = getHisto(test, 2);
        Histogram.plotHistogram(histoRouge,"rouge");
        Histogram.plotHistogram(histoVert,"vert");
        Histogram.plotHistogram(histoBleu,"bleu");

    }
    private static void discretisation(double[] histogram){

      double [] nouvelHisto= new double [histogram.length/2];
       for (int i=0; i<=nouvelHisto.length ; i++){
           for (int j=0; j<=nouvelHisto.length; j++){
            
           }
       }


    }


    private static double[] getHisto(Image image, int canal) {
        double histo[] = new double[256];
        for (int i = 0; i < histo.length; i++) {
            histo[i] = 0;
        }
        for (int x = 0; x < image.getXDim(); x++) {
            for (int y = 0; y < image.getYDim(); y++) {
                histo[image.getPixelXYBByte(x, y, canal)] += 1;
            }
        }
        return histo;
    }
}
