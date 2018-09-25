package fr.istic.master.wego.dto;

public class UserDtoRead {

	private Long id;
    private String firstName;
    private String lastName;
    private String mail;
    private boolean isMySportsEmpty = true;
    private boolean isMyPlacesEmpty = true;

    public UserDtoRead() {
    }
    
    public Long getId() {
		return id;
		}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

	public boolean isMySportsEmpty() {
		return isMySportsEmpty;
	}
	
	public void setMySportsEmpty(boolean isMySportsEmpty) {
		this.isMySportsEmpty = isMySportsEmpty;
	}

	public boolean isMyPlacesEmpty() {
		return isMyPlacesEmpty;
	}

	public void setMyPlacesEmpty(boolean isMyPlacesEmpty) {
		this.isMyPlacesEmpty = isMyPlacesEmpty;
	}
}
