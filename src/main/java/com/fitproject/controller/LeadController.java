package com.fitproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fitproject.domain.Lead;
import com.fitproject.service.LeadService;

@Controller
public class LeadController {
	
	private LeadService leadService;
	
	@Autowired
	public LeadController(LeadService leadService) {
		super();
		this.leadService = leadService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("leads", leadService.findAll());
		return "index";
	}
	
	/*
	 * Create new lead
	 */
	@RequestMapping(value="/", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> newLead(@RequestBody Lead lead) {
		leadService.save(lead);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/lead/update", method=RequestMethod.POST)
	public String updateLead(Model model, Lead lead) {
		Lead savedLead = leadService.save(lead);
		return "redirect:/lead/" + savedLead.getId();
	}
	
	/*
	 * View lead based on ID
	 */
	@RequestMapping("/lead/{id}")
	public String viewLead(Model model, @PathVariable Long id) {
		model.addAttribute("lead", leadService.findOne(id));
		return "lead";
	}
	
	/*
	 * Edit lead based on ID
	 */
	@RequestMapping("/lead/edit/{id}")
	public String editLead(Model model, @PathVariable Long id) {
		model.addAttribute("lead", leadService.findOne(id));
		return "edit";
	}
	
	/*
	@RequestMapping(value="/leads", method=RequestMethod.GET)
	public ResponseEntity<Iterable<Lead>> showAll() { 
		Iterable<Lead> leads = leadService.findAll();
		return new ResponseEntity<Iterable<Lead>>(leads, HttpStatus.OK);
	}
	*/
	
}
