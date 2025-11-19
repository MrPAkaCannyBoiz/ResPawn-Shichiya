package org.example.respawnmarket.dtos;

public class ResellerLoginResponseDto
{
    private int id;
    private String username;

    public ResellerLoginResponseDto() {
    }

    public ResellerLoginResponseDto(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}