package Program9;


import java.util.*;

public class RecordingsSortArrayList {
	
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		ArrayList <Recordings> recordings = new ArrayList <Recordings>(5);
		fillArray(input, recordings);
		int key =1;
		while(key==1) {
			menu(input, recordings);
			System.out.println("\nType 1 to sort again or 0 to quit:");
			key = input.nextInt();
		}
		System.out.println("Thank you for using this program!");
	}
	
		
		public static void fillArray(Scanner input, ArrayList <Recordings> recordings) {
			System.out.println("Would you like to enter a song? ('y' for yes, 'n' for no)");
			String key=input.nextLine();
			while(!key.equals("y")&&!key.equals("n")) {
				System.out.print("Invalid. Try again.");
				key = input.nextLine();
			};
			
			if (key.equals("n")) {
				System.out.println("Goodbye.");
				System.exit(0);
			}
			while (key.equals("y")) {
				System.out.println("Enter the title:");
				String title=input.nextLine();
				System.out.println("Enter the artist:");
				String artist = input.nextLine();
				System.out.println("Enter the playing time in seconds:");
				int sec = input.nextInt();
				input.nextLine();
				while (sec<=0) {
					System.out.println("Invalid entry. Enter a number greater that zero:");
					sec = input.nextInt();
					input.nextLine();
				}
				recordings.add(new Recordings(title,artist, sec));
				System.out.println("Would you like to enter a song? ('y' for yes, 'n' for no)");
				key=input.nextLine();
			}
			
		}
		
		public static void menu(Scanner input, ArrayList <Recordings> recordings) {
			int option;
			
			do {
				System.out.println("Enter your option from the menu:");
				System.out.println("1. Sort by Title\n2. Sort by Artist\n3. Sort by playing time ");
				option = input.nextInt();
				if (option<1 || option >3)
					System.out.println("Invalid data entry.");
			}while(option<1 || option >3);
			
			if (option==1)
				sortByTitle(recordings);
			if (option==2)
				sortByArtist(recordings);
			if (option ==3)
				sortByPlayTime(recordings);
				
		}
		
		public static void sortByTitle(ArrayList <Recordings>recordings) {
		
			for (int x=0; x<recordings.size(); x++) {
				String minValue = recordings.get(x).getTitle();
				for (int index= x+1; index< recordings.size(); index++) {
					int compare = minValue.compareToIgnoreCase(recordings.get(index).getTitle());
					if (compare>0) {
						minValue = recordings.get(index).getTitle();
						Recordings hold = recordings.get(index);
						recordings.set(index, recordings.get(x));
						recordings.set(x, hold);
					}
				}
			}
			for (int x=0; x<recordings.size();x++) {
				System.out.println(recordings.get(x).toString());
				System.out.println();
			}	
		}
		
		public static void sortByArtist(ArrayList <Recordings>recordings) {
			for (int x=0; x<recordings.size(); x++) {
				String minValue = recordings.get(x).getArtist();
				for (int index= x+1; index< recordings.size(); index++) {
					int compare = minValue.compareToIgnoreCase(recordings.get(index).getArtist());
					if (compare>0) {
						minValue = recordings.get(index).getArtist();
						Recordings hold = recordings.get(index);
						recordings.set(index, recordings.get(x));
						recordings.set(x, hold);
					}
				}
			}
			for (int x=0; x<recordings.size();x++) {
				System.out.println(recordings.get(x).toString());
				System.out.println();
			}	
		}
		
		
		public static void sortByPlayTime(ArrayList <Recordings>recordings) {
			for (int x=0; x<recordings.size(); x++) {
				int minValue = recordings.get(x).getPlayingTime();
				for (int index= x+1; index< recordings.size(); index++) {
					if (minValue > recordings.get(index).getPlayingTime()) {
						minValue = recordings.get(index).getPlayingTime();
						Recordings hold = recordings.get(index);
						recordings.set(index, recordings.get(x));
						recordings.set(x, hold);
					}
				}
			}
			for (int x=0; x<recordings.size();x++) {
				System.out.println(recordings.get(x).toString());
				System.out.println();
			}	
		}
		
	
}
