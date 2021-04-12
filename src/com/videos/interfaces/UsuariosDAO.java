package com.videos.interfaces;

import java.util.*;

import com.videos.project.*;

public interface UsuariosDAO {
	
	public List<Usuario> getAllUsuarios();
	public Usuario getUsuario(String nombre, String apellido);
	public void updateUsuario(Usuario usuario);
	public void deleteUsuario(Usuario usuario);
	public void addUsuario();
	public Usuario newsVideos(Usuario usuario);
	public int getUsuarioPosicion(String nombre, String apellido);
	
	public List<Video> getAllVideo();
	public Video getVideo(String titulo);
	public void updateVideo(Video video);
	public void deleteVideo(Video video);
	public void addVideo(boolean add);

}
