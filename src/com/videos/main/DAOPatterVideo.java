package com.videos.main;

import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.videos.interfaces.UsuariosDAO;
import com.videos.project.*;

public class DAOPatterVideo {

	public static void main(String[] args) {
		
		UsuariosDAO usuariosDAO = new UsuariosDAOImpl();
		HashMap<Usuario, Video> relacion = new HashMap<Usuario,Video>(); // Guardamos la relacion de Usuario con Video
		
		usuariosDAO.addUsuario();
		
		int dato1 = usuariosDAO.getAllUsuarios().size()-1;
		int dato2 = usuariosDAO.getAllVideo().size()-1;
		
		relacion.put(usuariosDAO.getAllUsuarios().get(dato1), usuariosDAO.getAllVideo().get(dato2));
		
		
		/***************************************** MAP *****************************************************/
		
		for(Usuario cuenta:relacion.keySet()) {
			System.out.println(cuenta.nombreCompleto()+ ": " +relacion.get(cuenta).getDatosVideo());
			
		}
		
		/***************************************** Nuevo video *****************************************************/
		
		String[] video = {
	            "Si",
	            "No"
	    };
		
		ImageIcon icono = new ImageIcon("img/icon.png");
		
		String tipo = (String) JOptionPane.showInputDialog(null, 
        		"Vas a añadir nuevo Video!!", "Video", JOptionPane.DEFAULT_OPTION, 
        		icono, video, video[0]);
		
		switch(tipo) {
		
		case "Si":
			try {
				
				String nombre = JOptionPane.showInputDialog(null,"Introduce tu nombre");
				String apellido = JOptionPane.showInputDialog(null,"Introduce tu apellido");
				
				usuariosDAO.newsVideos(usuariosDAO.getUsuario(nombre, apellido));
				
				dato1 = usuariosDAO.getUsuarioPosicion(nombre, apellido);
				dato2 = usuariosDAO.getAllVideo().size()-1;
				relacion.put(usuariosDAO.getAllUsuarios().get(dato1), usuariosDAO.getAllVideo().get(dato2));
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		
		case "No":
			try {
				System.out.println("En otra ocasion sera!! Recuerda que puedes añadir tus videos");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;

		}
		
	}

}
