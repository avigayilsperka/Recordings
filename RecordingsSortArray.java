package Program9;
import java.util.Scanner;

public class RecordingsSortArray{
	
	public static void main(String[]args) {
		Scanner input = new Scanner(System.in);
		Recordings []recordings = new Recordings[5];
		fillArray(input, recordings);
		int key =1;
		while(key==1) {
			menu(input, recordings);
			System.out.println("\nType 1 to search again or 0 to quit:");
			key = input.nextInt();
		}
		System.out.println("Thank you for using this program!");
	}
	
		
		public static void fillArray(Scanner input, Recordings[] recordings) {
			for (int x=0; x<recordings.length; x++) {
				System.out.println("Enter the title for recording "+(x+1)+":");
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
				recordings[x]= new Recordings(title, artist,sec);
			}
		}
		
		public static void menu(Scanner input, Recordings[] recordings) {
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
		
		public static void sortByTitle(Recordings[]recordings) {
		
			for (int x=0; x<recordings.length; x++) {
				String minValue = recordings[x].getTitle();
				for (int index= x+1; index< recordings.length; index++) {
					int compare = minValue.compareToIgnoreCase(recordings[index].getTitle());
					if (compare>0) {
						minValue = recordings[index].getTitle();
						Recordings hold = recordings[index];
						recordings[index]=recordings[x];
						recordings[x]=hold;
					}
				}
			}
			for (int x=0; x<recordings.length;x++) {
				System.out.println(recordings[x].toString());
				System.out.println();
			}	
		}
		
		public static void sortByArtist(Recordings[]recordings) {
			for (int x=0; x<recordings.length; x++) {
				String minValue = recordings[x].getArtist();
				for (int index= x+1; index< recordings.length; index++) {
					int compare = minValue.compareToIgnoreCase(recordings[index].getArtist());
					if (compare>0) {
						minValue = recordings[index].getArtist();
						Recordings hold = recordings[index];
						recordings[index]=recordings[x];
						recordings[x]=hold;
					}
				}
			}
			for (int x=0; x<recordings.length;x++) {
				System.out.println(recordings[x].toString());
				System.out.println();
			}	
		}
		
		
		public static void sortByPlayTime(Recordings[]recordings) {
			for (int x=0; x<recordings.length; x++) {
				int minValue = recordings[x].getPlayingTime();
				for (int index= x+1; index< recordings.length; index++) {
					if (minValue > recordings[index].getPlayingTime()) {
						minValue = recordings[index].getPlayingTime();
						Recordings hold = recordings[index];
						recordings[index]=recordings[x];
						recordings[x]=hold;
					}
				}
			}
			for (int x=0; x<recordings.length;x++) {
				System.out.println(recordings[x].toString());
				System.out.println();
			}	
		}
		
	
}
