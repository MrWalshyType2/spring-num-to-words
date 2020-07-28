package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Converter;

@RestController
@RequestMapping("/convert")
public class ConverterController {
	
	@Autowired
	Converter conv;

	@GetMapping("/{num}")
	public String numToWord(@PathVariable("num") int num) {
		return conv.numToWord(num);
	}
}
