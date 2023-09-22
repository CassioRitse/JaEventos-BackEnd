package com.example.JaEventos.repo;

import java.util.ArrayList;
import java.util.List;

import com.example.JaEventos.Models.ModelEvento;

public class BancoDeDados {
	private static ModeloBD bd;
	
	
	public BancoDeDados() {
		this.bd = new ModeloBD();
	}
	
	public static ModeloBD getInstance() {
		if(bd != null) {
			return bd;
		}else {
			return new BancoDeDados().bd;
		}
	}
	
	
}
