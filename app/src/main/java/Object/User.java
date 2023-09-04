package Object;

import java.time.LocalDate;
import java.util.List;

public class User {
    private String userUID, name;
    private int userRole;
    private LocalDate dateOFBirth;
    private List<Ticket> ticketList;

    public User() {
    }

    public User(String userUID, String name, int userRole, LocalDate dateOFBirth) {
        this.userUID = userUID;
        this.name = name;
        this.userRole = userRole;
        this.dateOFBirth = dateOFBirth;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public LocalDate getDateOFBirth() {
        return dateOFBirth;
    }

    public void setDateOFBirth(LocalDate dateOFBirth) {
        this.dateOFBirth = dateOFBirth;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
