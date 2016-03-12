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
public class ImatgeBN extends Imatge{
    
    public ImatgeBN(String path){
        super(path);
    }

    public ImatgeBN(String path, String nom) {
        super(path, nom);
    }
    
    private BufferedImage color2gray(){
	BufferedImage inBufferedImage;
        inBufferedImage = (BufferedImage)getImage();
	int width = inBufferedImage.getWidth();
	int height = inBufferedImage.getHeight();	
	BufferedImage outImage = new BufferedImage( width, height, BufferedImage.TYPE_3BYTE_BGR);
	for(int	i=0; i<height; i++){
            for(int j=0; j<width; j++){
		Color c =new Color(inBufferedImage.getRGB(j,i));
                int red	= (int)(c.getRed() * 0.2126);
		int green = (int)(c.getGreen() * 0.7152);
		int blue  = (int)(c.getBlue() * 0.0722);
		Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
		outImage.setRGB(j,i,newColor.getRGB());
            }
        }									
	return(outImage);
    }
    
     public BufferedImage filtrar(){
        return this.color2gray();
    }
    
}
