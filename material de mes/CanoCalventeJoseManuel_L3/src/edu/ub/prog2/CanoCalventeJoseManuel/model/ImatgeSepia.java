/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.CanoCalventeJoseManuel.model;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author jcanocal8.alumnes
 */
public class ImatgeSepia extends Imatge {

    public ImatgeSepia(String path) {
        super(path);
    }
    
    public ImatgeSepia(String path, String name) {
        super(path,name);
    }
    
    private BufferedImage color2sepia(){
	BufferedImage inBufferedImage;
        inBufferedImage = (BufferedImage)getImage();
	int width = inBufferedImage.getWidth();
	int height = inBufferedImage.getHeight();	
	BufferedImage outImage = new BufferedImage( width, height, BufferedImage.TYPE_3BYTE_BGR);
	for(int	i=0; i<height; i++){
            for(int j=0; j<width; j++){
		Color c =new Color(inBufferedImage.getRGB(j,i));
                int red	= (int)(c.getRed());
		int green = (int)(c.getGreen());
		int blue  = (int)(c.getBlue());
                int r = (int)((red*0.393)+(green*0.769)+(blue*0.189));
                int g = (int)((red*0.343)+(green*0.686)+(blue*0.168));
                int b = (int)((red*0.272)+(green*0.534)+(blue*0.131));
                if(r>255) r = 255;
                if(g>255) g = 255;
                if(b>255) b = 255;
		Color newColor = new Color(r,g,b);
		outImage.setRGB(j,i,newColor.getRGB());
            }
        }									
	return(outImage);
    }
    
    public BufferedImage filtrar(){
        return this.color2sepia();
    }
}
