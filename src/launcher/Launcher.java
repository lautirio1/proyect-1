package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
		Student Estudiante;
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        	Student Estudiante;
        	public void run() {
        		inicializarDatos();
			    SimplePresentationScreen window = new SimplePresentationScreen(Estudiante);
			    window.setVisible(true);
            }
        	public void inicializarDatos() {
            	int id = 126114;
            	String apellido = "Chanquia";
            	String nombre = "Lautaro";
            	String mail = "lautarochanquia@gmail.com";
            	String Git = "https://github.com/lautirio1";
            	String Photo = "/images/yo.png";
            	Estudiante = new Student (id, apellido, nombre, mail, Git, Photo);
            }
            
        });
    }
}