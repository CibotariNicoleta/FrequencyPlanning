package score.calculator;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;

import domain.FrequencyPlan;
import domain.Transmitter;

public class FrequencyEasyScoreCalculator implements EasyScoreCalculator<FrequencyPlan>{
	
	 @Override
	public HardSoftScore calculateScore(FrequencyPlan fr) {
		 int hardScore = 0;
		 for(Transmitter iterator : fr.getTransmitterList()) {
			 for(Transmitter neighbourIterator : iterator.getNeighbours())  
				 if(iterator.getFrequency()==null || neighbourIterator.getFrequency() ==null)
					 continue;
				 else if(iterator.getFrequency().getFrequencyValue() == neighbourIterator.getFrequency().getFrequencyValue() )
					 hardScore-=1;
		 }
		 return HardSoftScore.of(hardScore, 0 );
	}
}



//package org.optaplanner.examples.cloudbalancing.optional.score;
//
//import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
//import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
//import org.optaplanner.examples.cloudbalancing.domain.CloudBalance;
//import org.optaplanner.examples.cloudbalancing.domain.CloudComputer;
//import org.optaplanner.examples.cloudbalancing.domain.CloudProcess;
//
//public class CloudBalancingEasyScoreCalculator implements EasyScoreCalculator<CloudBalance> {
//
//   
//    @Override
//    public HardSoftScore calculateScore(CloudBalance cloudBalance) {
//        int hardScore = 0;
//        int softScore = 0;
//        for (CloudComputer computer : cloudBalance.getComputerList()) {
//            int cpuPowerUsage = 0;
//            int memoryUsage = 0;
//            int networkBandwidthUsage = 0;
//            boolean used = false;
//
//            // Calculate usage
//            for (CloudProcess process : cloudBalance.getProcessList()) {
//                if (computer.equals(process.getComputer())) {
//                    cpuPowerUsage += process.getRequiredCpuPower();
//                    memoryUsage += process.getRequiredMemory();
//                    networkBandwidthUsage += process.getRequiredNetworkBandwidth();
//                    used = true;
//                    
//                   
//                }
//            }
//
//            // Hard constraints
//            int cpuPowerAvailable = computer.getCpuPower() - cpuPowerUsage;
//            if (cpuPowerAvailable < 0) {
//                hardScore += cpuPowerAvailable;
//               
//            }
//            int memoryAvailable = computer.getMemory() - memoryUsage;
//            if (memoryAvailable < 0) {
//                hardScore += memoryAvailable;
//            }
//            int networkBandwidthAvailable = computer.getNetworkBandwidth() - networkBandwidthUsage;
//            if (networkBandwidthAvailable < 0) {
//                hardScore += networkBandwidthAvailable;
//            }
//
//            // Soft constraints
//            if (used) {
//                softScore -= computer.getCost();
//            }
//        }
//        
//        
//        return HardSoftScore.of(hardScore, softScore );
//    }
//
//}
