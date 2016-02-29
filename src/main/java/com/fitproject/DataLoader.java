package com.fitproject;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fitproject.domain.Lead;
import com.fitproject.repository.LeadRepository;

@Component
public class DataLoader {
	
	private LeadRepository leadRepository;
	
	@Autowired
	public DataLoader(LeadRepository leadRepository) {
		this.leadRepository = leadRepository;
	}
	
	@PostConstruct
	public void loadData() {
		leadRepository.deleteAll();
		createLeads();
	}
	
	public void createLeads() {
		Lead lead1 = new Lead();
		lead1.setName("Peter");
		lead1.setEmail("peter@example.com");
		lead1.setDescription("Lose weight and tone muscles");
		lead1.setPhone("20111757");
		leadRepository.save(lead1);
		
		Lead lead2 = new Lead();
		lead2.setName("Morten");
		lead2.setEmail("morten@example.com");
		lead2.setDescription("Bulk up to 100 kilos");
		lead2.setPhone("20111758");
		leadRepository.save(lead2);
		
		Lead lead3 = new Lead();
		lead3.setName("Jens");
		lead3.setEmail("morten@example.com");
		lead3.setDescription("Slim down my waist");
		lead3.setPhone("20111759");
		leadRepository.save(lead3);
	}

}
