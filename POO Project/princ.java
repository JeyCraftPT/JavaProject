import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;

public class princ {
  public static void main(String[] args) throws Exception {
	  
      
	  mainMenu();
	
	
}
  
  public static void joinClass(regimembro manager, Scanner scanner) {
	  manager.loadMembers();
	  //registry.loadRegistry();

      
	  System.out.print("Your first name: ");
	  String fName = scanner.nextLine();
	  System.out.print("Your last name: ");
	  String lName = scanner.nextLine();
	  membro member = manager.findMember(fName, lName);

	  System.out.println(member.toString());

	  System.out.print("What class do you wanna join: ");
	  String aula = scanner.nextLine();

	  member.setAula(aula);

	  manager.saveMembers();

	  System.out.println(member);

	  mainMenu();


  }
  
  public static void mainMenu() {
	
	  Scanner scanner = new Scanner(System.in);
	  
	  regimembro manager = new regimembro();



	  regipt staff = new regipt();


		// Load members on program open
	  manager.loadMembers();
	  staff.loadTrainers();
	  
	  while (true) {

			System.out.println("Options:");
	        System.out.println("1 - Perform operations on members");
	        System.out.println("2 - Perform operations on Personal Trainers");
	        System.out.println("3 - Join Classes");
			System.out.println("4 - Staff Work");
	        System.out.println("5 - Exit");
	        System.out.print("Enter your choice: ");
	        
	        int outerChoice = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        switch (outerChoice) {
	            case 1:
	                memberChanges(manager, scanner);
	                break;
	            case 2:
	            	ptChanges(staff, scanner);
	                break;
	            case 3:
	            	joinClass(manager, scanner);
	            	break;
				case 4:
					staffWork(manager, staff, scanner);
					break;
				case 5:
					manager.saveMembers();
					staff.saveTrainers();
					System.out.println("Exiting...");

					System.exit(0);
					break;
	            default:
	                System.out.println("Invalid choice. Please enter a valid option.");
	                break;
	        }
	  
  }
	  
}
  
	
	public static void memberChanges (regimembro manager, Scanner scanner) {

	while (true) {

		System.out.println("Options:");
		System.out.println("1 - Add member");
		System.out.println("2 - Update member");
		System.out.println("3 - Display all members in same class as me");
		System.out.println("4 - What is my IMC");
		System.out.println("5 - exit");
		System.out.print("Enter your choice: ");

		int choice = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		switch (choice) {
		case 1:

			System.out.print("Enter name: ");
			String name = scanner.nextLine();
			System.out.print("Entre last name: ");
			String lastname = scanner.nextLine();
			System.out.print("Enter age: ");
			int age = scanner.nextInt();
			System.out.print("Enter mensality: ");
			double mensal = scanner.nextDouble();
			scanner.nextLine(); // Consume newline
			membro newMember = new membro(name,lastname, age, mensal);
			manager.addMember(newMember);
			break;

		case 2:

			System.out.print("Enter name of member to update: ");
			String oldName = scanner.nextLine();
			System.out.print("Enter old last name: ");
			String oldApelido = scanner.nextLine();
			System.out.print("Enter new name: ");
			String newName = scanner.nextLine();
			System.out.print("Enter new last name: ");
			String newLastName = scanner.nextLine();
			System.out.print("Enter new age: ");
			int newAge = scanner.nextInt();
			System.out.print("Enter new Mensality: ");
			double newMensal = scanner.nextDouble();
			scanner.nextLine(); // Consume newline
			membro updatedMember = new membro(newName, newLastName, newAge, newMensal);
			manager.updateMember(oldName, oldApelido, updatedMember);
			break;

		case 3:

			System.out.print("Enter the class name: ");
			String aulaName = scanner.nextLine();

			ArrayList<membro> membersInAula = manager.getMembersInAula(aulaName);

			if (membersInAula.isEmpty()) {
				System.out.println("No members found in the class: " + aulaName);
			} else {
				System.out.println("Members in class '" + aulaName + "':");
				for (membro member : membersInAula) {
					System.out.println(member.toString());
				}
			}
			break;

		case 4:

			System.out.print("How much do you weight? ");
			String pesoStr = scanner.nextLine().replace(',', '.'); // Replace comma with dot
			double peso = Double.parseDouble(pesoStr);

			System.out.print("How tall are you? (In meters) ");
			String alturaStr = scanner.nextLine().replace(',', '.'); // Replace comma with dot
			double altura = Double.parseDouble(alturaStr);

			DecimalFormat df = new DecimalFormat("#.#");
			double imc = manager.calculateIMC(peso, altura);

			System.out.println("Under 18.5\tUnderweight");
			System.out.println("18.5 - 24.9\tNormal");
			System.out.println("25 - 29.9\tOverweight");
			System.out.println("30 and over\tObese");
			System.out.println();
			System.out.println("Your IMC is: " + df.format(imc));
			System.out.println();
			break;

		case 5:

			// Save members and exit
			manager.saveMembers();
			System.out.println("Exiting...");
			mainMenu();

		default:
			System.out.println("Invalid choice. Please enter a valid option.");
		}
	}

	}


	public static void ptChanges(regipt staff, Scanner scanner) {

	    while (true) {
	        System.out.println("Options:");
	        System.out.println("1 - Add personal trainer");
	        System.out.println("2 - Display all personal trainers");
	        System.out.println("3 - Delete personal trainer");
	        System.out.println("4 - Exit");
	        System.out.print("Enter your choice: ");

	        int choice = scanner.nextInt();
	        scanner.nextLine(); // Consume newline

	        switch (choice) {
	            case 1:
	                System.out.print("Enter first name: ");
	                String name = scanner.nextLine();
	                System.out.print("Enter last name: ");
	                String lastName = scanner.nextLine();
	                System.out.print("Enter age: ");
	                int age = scanner.nextInt();
	                scanner.nextLine(); // Consume newline
	                System.out.print("Enter specialization: ");
	                
	                String specialization = scanner.nextLine();
	                pt newTrainer = new pt(name, lastName, age, specialization);
	                staff.addTrainer(newTrainer);
	                break;
	            case 2:
	                System.out.println("All Personal Trainers:");
	                ArrayList<pt> allTrainers = staff.getTrainers();
	                for (pt trainer : allTrainers) {
	                    System.out.println(trainer.toString());
	                }
	                break;
	            case 3:
	                System.out.print("Please write the name of the trainer you want to delete: ");
	                String del = scanner.next();
	                staff.deleteTrainer(del);
	                break;
	            case 4:
	                // Save trainers and exit
	                staff.saveTrainers();
	                System.out.println("Exiting...");
	                mainMenu();
	            default:
	                System.out.println("Invalid choice. Please enter a valid option.");
	        }
	    }
	}



	public static void staffWork(regimembro manager, regipt staff, Scanner scanner){

		System.out.println("1 - See every member");
		System.out.println("2 - Delete member");
		System.out.println("3 - Change speciality");
		System.out.println("4 - Exit");
		System.out.print("Enter your choice: ");

		int choice = scanner.nextInt();

		switch (choice) {
			case 1:
				System.out.println("All Members:");
				ArrayList<membro> allMembers = manager.getMembers();
				for (membro member : allMembers) {
					if (member.getAula()==null){
						System.out.println("Name: " + member.getNome() + ", Last name: " + member.getApelido() +", Age: " + member.getIdade() + ", Mensalidade: " + member.getMensal());
					}else{
						System.out.println("Name: " + member.getNome() + ", Last name: " + member.getApelido() +", Age: " + member.getIdade() + ", Mensalidade: " + member.getMensal() + ", Aula: "+ member.getAula());
					}

				}
				break;
			case 2:
				System.out.print("Please write the name of the member you wanna delete: ");
				String del = scanner.next();
				manager.deleteMember(del);
				break;
			case 3:
				System.out.print("What is your first name trainer: ");
				String fiName = scanner.nextLine();
				System.out.print("What is your last name trainer: ");
				String lName = scanner.nextLine();

				pt foundTrainer = staff.findTrainer(fiName, lName);

				System.out.println("What do you want your new speciality to be? ");
				String newSpec = scanner.nextLine();

				foundTrainer.changeEspecialidade(newSpec);

				System.out.println(foundTrainer);
			case 4 :
				// Save members and exit
				manager.saveMembers();
				staff.saveTrainers();
				System.out.println("Exiting...");
				mainMenu();
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
		}

	}


}
