package br.net.itech.dtos;

public class PeopleDto {
	private String id;
	
	private String name;
	
	private String email;
	
	private String cpf;
	
	private String registry;

	private String rg;
	
	private String profile;
	
	public PeopleDto() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRegistry() {
		return registry;
	}

	public void setRegistry(String registry) {
		this.registry = registry;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "PeopleDto [id=" + id + ", name=" + name + ", email=" + email + ", cpf=" + cpf + ", registry=" + registry
				+ ", rg=" + rg + ", profile=" + profile + "]";
	}
}