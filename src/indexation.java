import fr.unistra.pelican.ByteImage;
import fr.unistra.pelican.Image;
import fr.unistra.pelican.algorithms.io.ImageLoader;
import fr.unistra.pelican.algorithms.visualisation.Viewer2D;

import java.awt.*;

public class indexation {

    public static void grissation(){

        Image image = ImageLoader.exec("C:\\Users\\RAMIREZ\\Desktop\\Lettre de Motivation\\eiffel.jpg");

        int largeur = image.getXDim();
        int hauteur = image.getYDim();
        ByteImage result = new ByteImage(largeur, hauteur, 1,1,1);


        for(int x = 0; x < image.getXDim(); x++){
            for(int y = 0; y < image.getYDim(); y++){
                int r = image.getPixelXYBByte(x,y,0);
                int g = image.getPixelXYBByte(x,y,1);
                int b = image.getPixelXYBByte(x,y,2);

                int avg = (r+g+b)/3;

                result.setPixelXYByte(y,x,avg);
            }
        }
        image.setColor(false);
        Viewer2D.exec(result);
    }

}
