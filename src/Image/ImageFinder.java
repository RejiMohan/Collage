package Image;

   import java.awt.Color;
import java.awt.image.BufferedImage;
   import java.awt.image.RenderedImage;
   import java.awt.image.renderable.ParameterBlock;
   import java.io.File;
   import java.io.IOException;


   import javax.imageio.ImageIO;
   import javax.media.jai.InterpolationNearest;
   import javax.media.jai.JAI;
   import javax.media.jai.iterator.RandomIter;
   import javax.media.jai.iterator.RandomIterFactory;

   import java.util.Vector;


   
    public class ImageFinder {
    
    public Color[][] signature;
    public static final int baseSize = 300;
    public  static final String basePath ="D:/e.jpg";

    public ImageFinder(){

     }

    public Vector getCollection(File reference,File dir)throws Exception{
        Vector vec=new Vector();
        try
        {
            RenderedImage ref = rescale(ImageIO.read(reference));
            signature = calcSignature(ref);
            File[] others = getOtherImageFiles(dir);
            RenderedImage[] rothers = new RenderedImage[others.length];
            double[] distances = new double[others.length];
            for (int o = 0; o < others.length; o++)
            {
                rothers[o] = rescale(ImageIO.read(others[o]));
                distances[o] = calcDistance(rothers[o]);
            }
            for (int p1 = 0; p1 < others.length - 1; p1++)
             for (int p2 = p1 + 1; p2 < others.length; p2++)
             {
                if (distances[p1] > distances[p2])
                {
                    double tempDist = distances[p1];
                    distances[p1] = distances[p2];
                    distances[p2] = tempDist;
                    RenderedImage tempR = rothers[p1];
                    rothers[p1] = rothers[p2];
                    rothers[p2] = tempR;
                    File tempF = others[p1];
                    others[p1] = others[p2];
                    others[p2] = tempF;
                }
            }
           
           for (int o = 0; o < others.length; o++)
           {
                if(distances[o]<500)
                {
                    System.out.println(distances[o]);
          
                    vec.add(others[o].getAbsolutePath());
                }
          
           }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        return vec;
    }


    private RenderedImage rescale(RenderedImage i)
    {
        float scaleW = ((float) baseSize) / i.getWidth();
        float scaleH = ((float) baseSize) / i.getHeight();
        ParameterBlock pb = new ParameterBlock();
        pb.addSource(i);
        pb.add(scaleW);
        pb.add(scaleH);
        pb.add(0.0F);
        pb.add(0.0F);
        pb.add(new InterpolationNearest());
        return JAI.create("scale", pb);
      }

    private Color[][] calcSignature(RenderedImage i)
    {
        Color[][] sig = new Color[5][5];
        float[] prop = new float[]
        {1f / 10f, 3f / 10f, 5f / 10f, 7f / 10f, 9f / 10f};
        for (int x = 0; x < 5; x++)
         for (int y = 0; y < 5; y++)
          sig[x][y] = averageAround(i, prop[x], prop[y]);
        return sig;
    }

    private Color averageAround(RenderedImage i, double px, double py)
    {
        double[] pixel = new double[3];
        double[] accum = new double[3];
        try
        {
            RandomIter iterator = RandomIterFactory.create(i, null);
            int sampleSize = 15;
            for (double x = px * baseSize - sampleSize; x < px * baseSize + sampleSize; x++)
            {
                for (double y = py * baseSize - sampleSize; y < py * baseSize+ sampleSize; y++)
                {
                    iterator.getPixel((int) x, (int) y, pixel);
                    accum[0] += pixel[0];
                    accum[1] += pixel[1];
                    accum[2] += pixel[2];
                }
            }
            accum[0] /= sampleSize * sampleSize * 4;
            accum[1] /= sampleSize * sampleSize * 4;
            accum[2] /= sampleSize * sampleSize * 4;
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        return new Color((int) accum[0], (int) accum[1], (int) accum[2]);
     }

    private File[] getOtherImageFiles(File reference)
     {
        File dir = new File(reference.getAbsolutePath());
        File[] others = dir.listFiles(new JPEGImageFileFilter());
        return others;
     }


    private double calcDistance(RenderedImage other)
     {
        Color[][] sigOther = calcSignature(other);
        double dist = 0;
        for (int x = 0; x < 5; x++)
         for (int y = 0; y < 5; y++)
         {
            int r1 = signature[x][y].getRed();
            int g1 = signature[x][y].getGreen();
            int b1 = signature[x][y].getBlue();
            int r2 = sigOther[x][y].getRed();
            int g2 = sigOther[x][y].getGreen();
            int b2 = sigOther[x][y].getBlue();
            double tempDist = Math.sqrt((r1 - r2) * (r1 - r2) + (g1 - g2)* (g1 - g2) + (b1 - b2) * (b1 - b2));
            dist += tempDist;
         }
        return dist;
     }
    
    public String getMess(String file)
    {
        String mess="";
        try
        {
            File fp=new File(file);
            //new ImageFinder(fp);
            BufferedImage img=ImageIO.read(fp);
            ImageFinder dd=new ImageFinder();
            Steganography obj=new Steganography();
            int x=0,y=0,i=0;
            String c=new String();
            for(y=0;y<img.getHeight();y+=50)
            {
                for(x=0;x<img.getWidth();x+=50)
                {
                    c=dd.extractImage(img, x, y);
                    if(c.equals(" "))
                    {
                        i++;
                        if(i==3)
                        {
                            return mess;
                        }
                    }
                    else
                    {
                        i=0;
                    }
                    mess=mess+obj.decode(c);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e);
        }
        return mess;

    }
    
    public String extractImage(BufferedImage img,int x,int y)
    {
        try
        {
            File f=new File("D:/img.jpg");
            ImageIO.write(img.getSubimage(x, y, 50, 50), "JPG", f);
            Vector v=new ImageFinder().getCollection(f, new File("D:/ImagePool"));
            return v.elementAt(0).toString();
        }
        catch(Exception e)
        {
           return null;
        }
    }



}

