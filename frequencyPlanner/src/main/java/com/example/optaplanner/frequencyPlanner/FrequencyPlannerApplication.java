package com.example.optaplanner.frequencyPlanner;


import java.io.IOException;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import domain.Frequency;
import domain.FrequencyPlan;
import domain.Transmitter;
import persistence.FrequencyPlanGenerator;

@SpringBootApplication
public class FrequencyPlannerApplication {

	public static void main(String[] args) {
		
		
		SolverFactory<FrequencyPlan> solverFactory = SolverFactory.createFromXmlResource(
                "com/example/optaplanner/frequencyPlanner/solve/FrequencyPlannerSolve.xml");
        Solver<FrequencyPlan> solver = solverFactory.buildSolver();

        // Load a problem
        FrequencyPlan unsolvedFrequencyPlan = new FrequencyPlanGenerator().createFrequencyPlan(8, 6);
       
        // Solve the problem
        FrequencyPlan solvedFrequencyPlan = solver.solve(unsolvedFrequencyPlan);

		
		 
		for(Transmitter iterator: unsolvedFrequencyPlan.getTransmitterList()) {
			System.out.println("\n Transmitter id------------>:"+iterator.getId() );
			if(iterator.getNeighbours()!=null) {
			for(Transmitter secondIterrator:iterator.getNeighbours())
			System.out.println(" \n TransmitterNeighbour id ->:"+secondIterrator.getId() );
		    }
		}
		
		
		for(Frequency frequency:unsolvedFrequencyPlan.getFrequencyList()) {
			System.out.println("\n frequency id: ----->" + frequency.getFrequencyValue());
		}
		
		
		
		
		
	}
	
	
	private KieServices kieServices = KieServices.Factory.get();

	private KieFileSystem getKieFileSystem() throws IOException {
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource("com/example/optaplanner/frequencyPlanner/solve/FrequencyPlannerContraints.xml"));
		return kieFileSystem;

	}

	@Bean
	public KieContainer getKieContainer() throws IOException {
		System.out.println("Container created...");
		getKieRepository();
		KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
		kb.buildAll();
		KieModule kieModule = kb.getKieModule();
		KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
		return kContainer;

	}

	private void getKieRepository() {
		final KieRepository kieRepository = kieServices.getRepository();
		kieRepository.addKieModule(new KieModule() {
			public ReleaseId getReleaseId() {
				return kieRepository.getDefaultReleaseId();
			}
		});
	}

	@Bean
	public KieSession getKieSession() throws IOException {
		System.out.println("session created...");
		return getKieContainer().newKieSession();

	}

}
