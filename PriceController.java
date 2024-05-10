package com.example.helloworld.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.model.Price;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prices")
public class PriceController {

	private static final Map<String, Double> priceMap = new HashMap<>();

	// Create operation for prices
	@PostMapping
	public Price createPrice(@RequestBody Price price) {
		priceMap.put(price.getArtId(), price.getPrice());
		return price;
	}

	@GetMapping("/{artId}")
    public ResponseEntity<Double> getPrice(@PathVariable String artId) {
        Double price = priceMap.get(artId);
        if (price != null) {
            return ResponseEntity.ok(price);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
 
	// Update operation for prices
	@PutMapping("/{artId}")
	public Price updatePrice(@PathVariable String artId, @RequestBody Price price) {
		priceMap.put(artId, price.getPrice());
		return price;
	}

	// Delete operation for prices
	@DeleteMapping("/{artId}")
	public void deletePrice(@PathVariable String artId) {
		priceMap.remove(artId);
	}
}
