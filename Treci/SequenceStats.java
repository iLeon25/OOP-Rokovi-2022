package hr.fer.oop.ljir.z3;

import java.util.LinkedList;
import java.util.List; 
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequenceStats {
	
	public static int totalSeqLength(List<Sequence> seqList) {
		//return seqList.stream().mapToInt((a) -> a.getSequence().length()).sum();
		
		List<String> inputList = 
							seqList.stream().map((a) -> a.getSequence()).collect(Collectors.toList());
		
		int total = 0;
		
		for (String string : inputList) {
			total += string.length();
		}
		return total; 
	}
	
	public static List<String> seqNames(Stream<Sequence> seqList) {
		List<String> names = 
		seqList.map((a) -> a.getName()).collect(Collectors.toList());
		
		return names;
	}
	
	public static double avgQuality(List<Sequence> seqList) {
		return seqList.stream()
				.mapToDouble((a) -> a.avgSeqQuality()).average().getAsDouble();		
				
	}
	
	// Sequences with Quality above threshold
	public static Stream<Sequence> usableSequences(List<Sequence> seqList, double thqual) {
		return seqList.stream().filter((a) -> a.avgSeqQuality() > thqual).map((a) -> new Sequence(a.getName(), a.getSequence(), ""));
	}

}
