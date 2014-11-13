package gsb1 ;

import java.util.Calendar;
import java.util.GregorianCalendar;

/** Manipuler les dates
 * 
 * @author xilim
 *
 */
public class Dates {
	/** Convertir une date en chaîne de caractères
	 * 
	 * @param date La date à convertir
	 * @return La date au format "JJ/MM/AAAA"
	 */
	public static String parseDate(GregorianCalendar date){
		int jour = date.get(Calendar.DAY_OF_MONTH) ;
		int mois = date.get(Calendar.MONTH) + 1 ;
		int annee = date.get(Calendar.YEAR) ;
		return String.format("%02d/%02d/%04d",jour,mois,annee) ;
	}
	
	/** Convertir une chaîne de caractères en date
	 * 
	 * @param date La chaîne de caractères au format "JJ/MM/AAAA"
	 * @return La date
	 */
	public static GregorianCalendar parseString(String date){
		String [] champs = date.split("/") ;
		int jour = Integer.parseInt(champs[0]) ;
		int mois = Integer.parseInt(champs[1]) - 1 ;
		int annee = Integer.parseInt(champs[2]) ;
		return new GregorianCalendar(annee,mois,jour) ;
	}
	
	/** Vérifier le format "JJ/MM/AAAA"
	 * @param source La chaîne sensée représenter une date
	 * @return true si la chaîne respecte le format "JJ/MM/AAAA" et false dans le cas contraire
	 */
	public static boolean estDate(String source){
		if(source.length() != 10){
			return false ;
		}
		else {
			try {
				int jour = Integer.parseInt(source.substring(0,2)) ;
				int mois = Integer.parseInt(source.substring(3,5)) - 1 ;
				int annee = Integer.parseInt(source.substring(6)) ;
				if(jour >= 1 && mois >= 0 && annee >= 1){
					new GregorianCalendar(annee,mois,jour) ;
					return true ;
				}
				else {
					return false ;
				}
			}
			catch(Exception e){
				return false ;
			}
		}
	}
}
