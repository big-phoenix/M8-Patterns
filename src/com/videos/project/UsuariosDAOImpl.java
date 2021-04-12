package com.videos.project;

import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import com.videos.interfaces.UsuariosDAO;

public class UsuariosDAOImpl implements UsuariosDAO {
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Video> videos = new ArrayList<Video>();
	

	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return usuarios;
	}

	@Override
	public Usuario getUsuario(String nombre, String apellido) {
		
		Usuario datos = null;
		
		for(int i=0; i < usuarios.size();i++) {
			
			String nombres = usuarios.get(i).getNombre();
			String apellidos = usuarios.get(i).getApellido();
				
				if(nombres.equals(nombre) && apellidos.equals(apellido)) {
					datos = usuarios.get(i);
				}else {
					System.out.println("No encontrado");
				}
			
		}
		
		return datos;
	}
	
	public int getUsuarioPosicion(String nombre, String apellido) {
		
		int datos = 0;
		
		for(int i=0; i < usuarios.size();i++) {
			
			String nombres = usuarios.get(i).getNombre();
			String apellidos = usuarios.get(i).getApellido();
				
				if(nombres.equals(nombre) && apellidos.equals(apellido)) {
					datos = i;
				}else {
					System.out.println("No encontrado");
				}
			
		}
		
		return datos;
	}

	@Override
	public void updateUsuario(Usuario usuario) {
		
		try {
			
			String nombre = usuario.getNombre();
			String apellido = usuario.getApellido();
			
			for(int i=0; i < usuarios.size();i++) {
				Usuario user = usuarios.get(i);
				
				if(user.getNombre() == nombre && user.getApellido() == apellido) {
					
					String name = JOptionPane.showInputDialog(null,"Introduce tu nuevo nombre");
					String sname = JOptionPane.showInputDialog(null,"Introduce tu nuevo apellido");
					
					user.setNombre(name);
					user.setApellido(sname);
				} 
				
			}
			
		}catch(Exception  e){
		
			System.out.println("No se encontraron datos para actualizacion del Usuario");
			
		}
		
		
		
	}

	@Override
	public void deleteUsuario(Usuario usuario) {
		
		String nombre = usuario.getNombre();
		String apellido = usuario.getApellido();
		
		for(int i=0; i < usuarios.size();i++) {
			
			Usuario user = usuarios.get(i);
			
			if(user.getNombre() == nombre && user.getApellido() == apellido) {
				
				usuarios.remove(user);
			} 
			
		}
		
		
		
	}

	@Override
	public List<Video> getAllVideo() {
		// TODO Auto-generated method stub
		return videos;
	}

	@Override
	public Video getVideo(String titulo) {
		
		Video datos = null;
		
		for(int i=0; i < videos.size();i++) {
			
			String title = videos.get(i).getTitulo();
				
				if(title.equals(titulo)) {
					datos = videos.get(i);
				}else {
					System.out.println("No encontrado");
				}
			
		}
		
		return datos;
		
	}

	@Override
	public void updateVideo(Video video) {
		
		try {
			
			String titulo = video.getTitulo();
			String url = video.getUrl();
			
			for(int i=0; i < videos.size();i++) {
				Video videoss = videos.get(i);
				
				if(videoss.getTitulo() == titulo && videoss.getUrl() == url) {
					
					String name = JOptionPane.showInputDialog(null,"Introduce tu nuevo Titulo");
					
					videoss.setTitulo(name);
				} 
				
			}
			
		}catch(Exception  e){
		
			System.out.println("No se encontraron datos para actualizacion el Video");
			
		}
		
	}

	@Override
	public void deleteVideo(Video video) {
		
		String titulo = video.getTitulo();
		String url = video.getUrl();
		
		for(int i=0; i < videos.size();i++) {
			
			Video videoss = videos.get(i);
			
			if(videoss.getTitulo() == titulo && videoss.getUrl() == url) {
				
				videos.remove(videoss);
			} 
			
		}
		
	}
	
	
	public void addVideos() {
		
		String[] video = {
	            "Si",
	            "No"
	    };
		
		ImageIcon icono = new ImageIcon("img/icon.png");
		
		String tipo = (String) JOptionPane.showInputDialog(null, 
        		"Vas a añadir Video!!", "Video", JOptionPane.DEFAULT_OPTION, 
        		icono, video, video[0]);
		
		switch(tipo) {
		
		case "Si":
			try {
				addVideo(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		
		case "No":
			try {
				addVideo(false);
				System.out.println("En otra ocasion sera!! Recuerda que puedes añadir tus videos");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;

		}
		
	}


	
	@Override
	public void addUsuario() {
		
		String nombre = JOptionPane.showInputDialog(null,"Introduce tu nombre");
		String apellido = JOptionPane.showInputDialog(null,"Introduce tu apellido");
		String passw = JOptionPane.showInputDialog(null,"Introduce tu password");
		
		String dia = JOptionPane.showInputDialog(null,"Introduce el dia de nacimiento");
		int dias = Integer.parseInt(dia);
		
		String mes = JOptionPane.showInputDialog(null,"Introduce el mes de nacimiento");
		int mess = Integer.parseInt(mes);
		
		String ano = JOptionPane.showInputDialog(null,"Introduce el año de nacimiento");
		int anos = Integer.parseInt(ano);
		
		Usuario usuario = new Usuario(nombre, apellido, passw, anos, mess, dias);
		this.usuarios.add(usuario);
		
		addVideos();
		
	}

	@Override
	public void addVideo(boolean add) {
		
		List<String> tags = new ArrayList<String>();
		Video video;
		
		if(add == true) {
			
			String url = JOptionPane.showInputDialog(null,"Introduce la URL del Video");
			String titulo = JOptionPane.showInputDialog(null,"Introduce el titulo del Video");
			String tag = JOptionPane.showInputDialog(null,"Introduce un Tag!! si quieres");
			
			tags.add(tag);
			
			video = new Video(url, titulo, tags);
			this.videos.add(video);
			
		}else {
			
			tags.add("");
			
			video = new Video("", "", tags);
			this.videos.add(video);
			
			
		}
		
	}

	@Override
	public Usuario newsVideos(Usuario usuario) {
		
		String nombre = usuario.getNombre();
		String apellido = usuario.getApellido();
		
		Usuario dato = null;
		
		for(int i=0; i < usuarios.size();i++) {
			
			Usuario user = usuarios.get(i);
			
			if(user.getNombre() == nombre && user.getApellido() == apellido) {
				dato = user;
				addVideo(true);
			} 
			
		}
		
		return dato;
		
	}


}
