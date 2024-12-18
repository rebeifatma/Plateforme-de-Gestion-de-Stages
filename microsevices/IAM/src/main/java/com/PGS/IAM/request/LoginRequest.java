package com.PGS.IAM.request;

public class LoginRequest {

    private String email;
    private String mdp;

    // Constructeur par défaut
    public LoginRequest() {
    }

    // Constructeur avec paramètres
    public LoginRequest(String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    // Getter pour email
    public String getEmail() {
        return email;
    }

    // Setter pour email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter pour mdp
    public String getMdp() {
        return mdp;
    }

    // Setter pour mdp
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    // Optionnel : méthode toString pour affichage facile
    @Override
    public String toString() {
        return "LoginRequest{" +
                "email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }
}
