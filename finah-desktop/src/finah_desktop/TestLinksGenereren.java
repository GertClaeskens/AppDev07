package finah_desktop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class TestLinksGenereren {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		// //METHOD EXAMPLE
		// String id1 = UUID.randomUUID().toString().replaceAll("-", "");
		// String id2 = UUID.randomUUID().toString().replaceAll("-", "");
		//
		// System.out.println("UUID One: " + id1);
		// System.out.println("UUID Two: " + id2);
		
		for(int i=0;i<1000;i++){
			list1.add(UUID.randomUUID().toString().replaceAll("-", ""));
		}
		for(int i=0;i<1000;i++){
			list2.add(list1.get(i));
		}
		
		for(int i=0; i<1000;i++){
			int freq = Collections.frequency(list1, list2.get(i));
			System.out.println(list2.get(i) + " :: " + freq);
		}
	}
}
