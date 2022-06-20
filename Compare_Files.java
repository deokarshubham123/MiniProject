package demojava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Compare_Files {
	
	public static void main(String args[]) throws FileNotFoundException {

		long start = System.currentTimeMillis();
		LinkedList<String> list = new LinkedList<String>();
		File file=new File("C:\\Users\\shudeoka\\SeleniumDemo1\\DemoProject\\src\\words.txt");
		FileInputStream fis=new FileInputStream(file); //opens a connection to an actual file
		System.out.println("file content: ");
		//File file = new File("words.txt");
		try {
		Scanner sc = new Scanner(file);
		String words;
		while (sc.hasNext()) {
		words = sc.next();
		words = words.replaceAll("[^a-zA-Z0-9]", "");
		words = words.toLowerCase();
		words = words.trim();
		list.add(words);
		}
		sc.close();
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		Map<String, Integer> frequency = new TreeMap<String, Integer>();
		for (String count : list) {
		if (frequency.containsKey(count)) {
		frequency.put(count, frequency.get(count) + 1);
		} else {
		frequency.put(count, 1);
		}
		}
		System.out.println(frequency);
		long end = System.currentTimeMillis();
		System.out.println("\n" + "Duration: " + (end - start) + " ms");
		}

}
