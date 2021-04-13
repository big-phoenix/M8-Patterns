package com.videos.main;

import java.sql.Timestamp;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.videos.interfaces.UsuariosDAO;
import com.videos.project.*;
import com.videos.project.Usuario.Estado;

public class DAOPatterVideo {

	public static void main(String[] args) {
		
		UsuariosDAO usuariosDAO = new UsuariosDAOImpl();
		HashMap<Usuario, Video> relacion = new HashMap<Usuario,Video>(); // Guardamos la relacion de Usuario con Video
		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				
				for(Usuario usuario: usuariosDAO.getAllUsuarios()) {
					
					if(usuario.getEstado() == Estado.Uploading) {
						usuario.setEstado(Estado.Verifying);
					}else if(usuario.getEstado() == Estado.Verifying) {
						usuario.setEstado(Estado.Public);
					}
					
				}
				
			}
			
		};
		
		timer.schedule(task,10, 3000);
		
		
		
		usuariosDAO.addUsuario();
		
		int dato1 = usuariosDAO.getAllUsuarios().size()-1;
		int dato2 = usuariosDAO.getAllVideo().size()-1;
		
		relacion.put(usuariosDAO.getAllUsuarios().get(dato1), usuariosDAO.getAllVideo().get(dato2));
		
		
		for(Usuario usuario: usuariosDAO.getAllUsuarios()) {
			System.out.println("Usuario: [Nombre : " + usuario.getNombre() + ", Apellido : " + usuario.getApellido() + 
					", Fecha de Registro : " + usuario.getFecha_rg() + ", Tiempo : " + usuario.getTimes() + 
					", Estado : " + usuario.getEstado() + "  ]");
			
			System.out.println("-----------------------------------------------------------------------------------");
			
		}
		
		
		for(Video video: usuariosDAO.getAllVideo()) {
			System.out.println("Video: [Titulo : " + video.getTitulo() + ", URL : " + video.getUrl() + 
					", Tags : " + video.getAllTag() + "  ]");
		}
		
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
