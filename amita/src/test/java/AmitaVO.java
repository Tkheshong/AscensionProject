/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kohli
 */
public class AmitaVO {
    private String citystatezip;

    @Override
    public String toString() {
        return "AmitaVO{" + "citystatezip=" + citystatezip + '}';
    }

    
    
    public AmitaVO(String citystatezip) {
        this.citystatezip = citystatezip;
    }

    
    
    public String getCitystatezip() {
        return citystatezip;
    }

    public void setCitystatezip(String citystatezip) {
        this.citystatezip = citystatezip;
    }
    
    
}
