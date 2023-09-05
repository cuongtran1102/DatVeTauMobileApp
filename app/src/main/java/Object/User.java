package Object;

import java.time.LocalDate;
import java.util.List;

public class User {
    private String userUID, name, dateOfBirth;
    private int userRole;
    private List<Ticket> ticketList;

    public User() {
    }

    public User(String userUID, String name, int userRole, String dateOfBirth) {
        this.userUID = userUID;
        this.name = name;
        this.userRole = userRole;
        this.dateOfBirth = dateOfBirth;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }
}
