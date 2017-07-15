package com.krista.ninjagold.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


@Controller 

public class HomeController {
	int gold = 0;

	
	@RequestMapping("/")
	public String index(HttpSession session) {
		session.setAttribute("gold", gold);
		
		// if session myArray does not exist, create it
		if(session.getAttribute("myArray") == null) {
			ArrayList<String> myArray = new ArrayList<>();
			session.setAttribute("myArray", myArray);
		}
		return "index";
	}
	
	@RequestMapping("/farm")
	public String visitFarm(HttpSession session) {
		int randomNum = ThreadLocalRandom.current().nextInt(10, 21);
		String result = "You won " + randomNum + " coins at the Farm!";
		gold += randomNum;
		// pulling myArray session down and cast it into new ArrayList called log
		ArrayList<String> log = (ArrayList<String>)session.getAttribute("myArray");
		//add result of winnings to "log" ArrayList
		log.add(result);
		//push myArray session back up
		session.setAttribute("myArray", log);
		return "redirect:/";
	}
	
	@RequestMapping("/cave")
	public String visitCave(HttpSession session) {
		int randomNum = ThreadLocalRandom.current().nextInt(5, 11);
		String result = "You won " + randomNum + " coins at the Cave!";
		gold += randomNum;
		ArrayList<String> log = (ArrayList<String>)session.getAttribute("myArray");
		log.add(result);
		session.setAttribute("myArray", log);
		return "redirect:/";	}
	
	@RequestMapping("/house")
	public String visitHouse(HttpSession session) {
		int randomNum = ThreadLocalRandom.current().nextInt(2, 5);
		String result = "You won " + randomNum + " coins at the House!";
		gold += randomNum;
		ArrayList<String> log = (ArrayList<String>)session.getAttribute("myArray");
		log.add(result);
		session.setAttribute("myArray", log);
		return "redirect:/";	}
	
	@RequestMapping("/casino")
	public String visitCasino(HttpSession session) {
		int randomNum = ThreadLocalRandom.current().nextInt(-50, 51);
		
		if(randomNum < 0) {
			String result = "You lost " + randomNum + " coins at the Casino.";
			gold += randomNum;
			ArrayList<String> log = (ArrayList<String>)session.getAttribute("myArray");
			log.add(result);
			session.setAttribute("myArray", log);
		}
		else{
			String result = "You won " + randomNum + " coins at the Casino!";
			gold += randomNum;
			ArrayList<String> log = (ArrayList<String>)session.getAttribute("myArray");
			log.add(result);
			session.setAttribute("myArray", log);
		}
		return "redirect:/";	
	}
	
	@RequestMapping("/reset")
	public String newGame(HttpSession session) {
		session.invalidate();
		gold = 0;
		return "redirect:/";
	}
	
}
