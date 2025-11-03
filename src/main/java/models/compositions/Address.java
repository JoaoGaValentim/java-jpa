package models.compositions;

import javax.persistence.Embeddable;

@Embeddable // fica dentro da tabela da entidade
public class Address {
	private String location;
	private String complement;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
}
