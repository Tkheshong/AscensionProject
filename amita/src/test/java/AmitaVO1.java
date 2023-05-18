/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kohli
 */
public class AmitaVO1 {
    private String user;
    private String lastname;
    private String dob;
    private String doby;
    private String pdob;
    private String pdoby;

    @Override
    public String toString() {
        return "AmitaVO1{" + "user=" + user + ", lastname=" + lastname + ", dob=" + dob + ", doby=" + doby + ", pdob=" + pdob + ", pdoby=" + pdoby + '}';
    }

    public AmitaVO1(String user, String lastname, String dob, String doby, String pdob, String pdoby) {
        this.user = user;
        this.lastname = lastname;
        this.dob = dob;
        this.doby = doby;
        this.pdob = pdob;
        this.pdoby = pdoby;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDoby() {
        return doby;
    }

    public void setDoby(String doby) {
        this.doby = doby;
    }

    public String getPdob() {
        return pdob;
    }

    public void setPdob(String pdob) {
        this.pdob = pdob;
    }

    public String getPdoby() {
        return pdoby;
    }

    public void setPdoby(String pdoby) {
        this.pdoby = pdoby;
    }

   
    
}
