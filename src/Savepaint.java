import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Savepaint {

    public static BufferedImage getScreenShot(Component component) {

        BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
        // paints into image's Graphics
        component.paint(image.getGraphics());
        return image;
    }

    public static void getSaveSnapShot(Component component, String fileName) throws Exception {
        BufferedImage img = getScreenShot(component);
        // write the captured image as a PNG
        ImageIO.write(img, "png", new File(fileName));
         
 try{
	 Thread.sleep(200);
 }
 catch(Exception e)
 {
	 System.out.println(e);
 }
        // capture and save image
       // getSaveSnapShot(c.j, "billreceipt.png");
       // getSaveSnapShot(button, "button.png");
    }  
}