package com.gec.model;

public class Login {

	private String matricule,mdp;
	
	

	public Login(String matricule, String mdp) {
		super();
		this.matricule = matricule;
		this.mdp = mdp;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
}

