import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.ObjectInputStream;



/**
 * 
 */
public class regimembro {
	private ArrayList<membro> members = new ArrayList<>();


  public void addMember (membro member) {
	  
	  	members.add(member);
	    saveMembers();
	    
  }
  
  public void updateMember(String oldName, String oldApelido, membro newMember) {
	  
	  
	  for (membro member : members) {
	        // Check if the member and its name are not null before using getNome()
	        if (member != null && member.getNome() != null && member.getNome().equals(oldName)) {
	            member.setNome(newMember.getNome());
	            member.setIdade(newMember.getIdade());
	            member.setApelido(newMember.getApelido());
	            member.setMensal(newMember.getMensal());
	            saveMembers();
	            break;
	        }
	    }
	 }
  
public void saveMembers() {
     try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("members.ser"))) {
         oos.writeObject(members);
     } catch (IOException e) {
         e.printStackTrace();
     }
 }
        
 

public void loadMembers() {
    File file = new File("members.ser");
    if (file.exists()) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            members = (ArrayList<membro>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("File 'members.ser' does not exist. Creating an empty list of members.");
        members = new ArrayList<>();
        saveMembers(); // Save the empty list to the file
    }
}

public void deleteMember(String nameToDelete) {
    // Create a temporary list to store members to be removed
    ArrayList<membro> membersToRemove = new ArrayList<>();

    // Find members matching the name to delete and add them to the temporary list
    for (membro member : members) {
        if (member != null && member.getNome() != null && member.getNome().equals(nameToDelete)) {
            membersToRemove.add(member);
        }
    }

    // Remove the found members from the main members list
    members.removeAll(membersToRemove);

    // Save the updated members list
    saveMembers();
    System.out.println("Delete sucefull");
}

public void deleteAllMembers() {
    members.clear(); // Remove all members from the list

    // Save the updated (empty) members list
    saveMembers();
}

public membro findMember(String fName, String lName) {
    for (membro members : members) {
        if (members != null && members.getNome() != null && members.getApelido() != null &&
            members.getNome().equalsIgnoreCase(fName) && members.getApelido().equalsIgnoreCase(lName)) {
            return members; // Return the member if found
        }
    }
    return null; // Return null if the member is not found
}




  public ArrayList<membro> getMembers() {
	     return members;
	 }

    public ArrayList<membro> getMembersInAula(String aulaName) {
        ArrayList<membro> membersInAula = new ArrayList<>();
        for (membro member : members) {
            if (member != null && member.getAula() != null && member.getAula().equalsIgnoreCase(aulaName)) {
                membersInAula.add(member);
            }
        }
        return membersInAula;
    }

    public double calculateIMC(double peso, double altura){
      double imc = peso / (altura * altura);
      return imc;
    }

}