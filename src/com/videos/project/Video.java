package com.videos.project;

import java.sql.Timestamp;
import java.util.*;

public class Video {
	
	private String url;
	private String titulo;
	private List<String> tag = new ArrayList<String>();
	
	public Video(String url, String titulo, List<String> tag) {
		
		this.url = url;
		this.titulo = titulo;
		this.tag = tag;
		
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public List<String> getAllTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag.add(tag);
	}
	
	
	public String getDatosVideo() {
		return "Video: [Titulo : " + titulo + ", Url : " + url + 
				", Tag : " + tag + "  ]";
	}

}
