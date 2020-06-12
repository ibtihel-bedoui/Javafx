/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entities.evenement;
import entities.participant;
import java.awt.AWTException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import services.evenementCRUD;
import services.participantCRUD;
/**
 *
 * @author pc-ibtihel
 */
public class main {
      public static void main(String[] args) throws AWTException {

 evenementCRUD cc = new evenementCRUD();
    
   //participant p1 = new participant("ale","bedoui",1010);

 //add   
  // cc.ajouterParticipant(p1);
evenement jj = new evenement();
 //supp  
  cc.deleteEvenement(jj);
//   cc.supprimerEvenement(24);
 //afficher
 // List<participant> list = cc.afficherParticipant();
   //     System.out.println(list);
         
   //cc.modifierEvenement(e3);
         


}
   
      
     
}
