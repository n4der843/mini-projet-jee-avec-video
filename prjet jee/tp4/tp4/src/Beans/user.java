package Beans;

public class user {
	private int idUser;
	private String name;
	private String prenom;
	private String email;
	private String mdp;
	private byte[] image;

	public user(String name,String prenom, String email,String mdp) {
		
		this.name = name;
		this.prenom=prenom;
		this.email = email;
		this.mdp=mdp;
	}
public user(String name,String prenom, String email,String mdp, byte[] image) {
		
		this.name = name;
		this.prenom=prenom;
		this.email = email;
		this.mdp=mdp;
		this.image=image ;
	}
	public user(int id,String nom, String prenom,String email) {
		
		this.idUser = id;
		this.name=nom;
		this.prenom = prenom;
		this.email=email;
	}
	public user(int id, String name, String email) {
		this.idUser=id;
		this.name = name;
		this.email = email;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public user( String name, String email) {
		
		this.name = name;
		this.email = email;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	 public byte[] getImage() {
	        return image;
	    }

	    public void setImage(byte[] image) {
	        this.image = image;
	    }
}
