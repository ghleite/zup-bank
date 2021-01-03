package br.com.zupbank.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import br.com.zupbank.model.Client;

public class ClientDTO {

	@NotNull
	@NotEmpty
	private String name;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String cpf;
	@Past
	private LocalDateTime birthdate;
	
	public ClientDTO() {
	}

	public ClientDTO(Client client) {
		this.name = client.getName();
		this.email = client.getEmail();
		this.cpf = client.getCpf();
		this.birthdate = client.getBirthdate();
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

	public LocalDateTime getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDateTime birthdate) {
		this.birthdate = birthdate;
	}

	public static List<ClientDTO> convert(List<Client> clients) {
		return clients.stream().map(ClientDTO::new).collect(Collectors.toList());
	}

	public Client convertObject() {
		return new Client(name, email, cpf, birthdate);
	}
}
