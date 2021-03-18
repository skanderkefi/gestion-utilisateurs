package com.gec.controller;

import java.util.ArrayList; 
import java.util.List;
import java.util.zip.Deflater;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gec.model.ImageModel;
import com.gec.model.Login;
import com.gec.model.User;
import com.gec.repository.ImageRepository;
import com.gec.service.AdminService;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/Admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@CrossOrigin
	@GetMapping("/show")
	public List<User> getAllUsers() {
		return adminService.findAllUsers();
	}
	
	@CrossOrigin
	@DeleteMapping("/deletebyid/{id}")
	public String deleteUser(@PathVariable Long id) {
		 adminService.deleteUser(id);
		 System.out.println("============================="+id+"==========================");
		 return "from back!";
	}
	
	@CrossOrigin
	@PutMapping("/Update")
	public String getUserByMatricule(@Valid @RequestBody User user) {
		adminService.updateUserByMatricule(user);
		System.out.println("=========editing===========");
		return "updated";
		
	}
	
	@CrossOrigin
	@PostMapping("/create")
	public BodyBuilder createUser(@Valid @RequestBody User user) throws IOException {
		
		adminService.createUser(user);
		System.out.println("=========creating===========");
		return ResponseEntity.status(HttpStatus.OK);
		
	}
	
	
	
	
	//upload Image
	@Autowired
	ImageRepository imageRepository;
	@PostMapping("/upload")
	public ResponseEntity<Long> uplaodImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImageModel img = new ImageModel(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		imageRepository.save(img);
		return new ResponseEntity<>(img.getId(), HttpStatus.OK);
	}
	
	@GetMapping(path = { "/getImage/{id}" })
	public ImageModel getImage(@PathVariable("id") Long id) throws IOException {
		final Optional<ImageModel> retrievedImage = imageRepository.findById(id);
		ImageModel img = new ImageModel(retrievedImage.get().getName(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getPicByte()));
		return img;
	}
	
	
	// compress the image bytes before storing it in the database
		public static byte[] compressBytes(byte[] data) {
			Deflater deflater = new Deflater();
			deflater.setInput(data);
			deflater.finish();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			while (!deflater.finished()) {
				int count = deflater.deflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			try {
				outputStream.close();
			} catch (IOException e) {
			}
			System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
			return outputStream.toByteArray();
		}
	
		// uncompress the image bytes before returning it to the angular application
		public static byte[] decompressBytes(byte[] data) {
			Inflater inflater = new Inflater();
			inflater.setInput(data);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
			byte[] buffer = new byte[1024];
			try {
				while (!inflater.finished()) {
					int count = inflater.inflate(buffer);
					outputStream.write(buffer, 0, count);
				}
				outputStream.close();
			} catch (IOException ioe) {
			} catch (DataFormatException e) {
			}
			return outputStream.toByteArray();
		}
	
	
	
	
	
}
