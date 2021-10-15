package com.hackerearth.challenge.omnicell.Reciepe.controller;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackerearth.challenge.omnicell.Reciepe.entities.Reciepe;
import com.hackerearth.challenge.omnicell.Reciepe.services.ReciepeService;

@RestController
public class ReciepeController {
	private final ReciepeService reciepeService;
	private ResourceLoader resourceLoader = new DefaultResourceLoader();

	public ReciepeController(@Qualifier("reciepeService") ReciepeService reciepeService) {
		this.reciepeService=reciepeService;
	}
	@GetMapping("/")
	public List<Reciepe> allReciepes() {
		return reciepeService.getAllReciepe();
	}
	
	
	@RequestMapping(value = "/{id}",method =RequestMethod.GET)
    public Reciepe getReciepe(@PathVariable int id) {
		
		return reciepeService.getReciepeObject(id);
	} 
	
	@RequestMapping(value = "/{id}/show",method= RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
    public  @ResponseBody byte[]  getReciepeImage(@PathVariable int id,HttpServletResponse  response) throws IOException {
		
		URL url = new URL(reciepeService.getReciepeObject(id).getImage());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
        
        try (InputStream inputStream = url.openStream()) {
            int n = 0;
            byte [] buffer = new byte[ 1024 ];
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }
        
	    return output.toByteArray();

	} 
	
	@PostMapping
	public String addReciepe(@Valid @RequestBody Reciepe reciepe) {
		return reciepeService.addReciepe(reciepe);
	}
}
