import java.util.*;

class Address implements RandomLoader{
    String houseNo;
    String street;
    String city;
    String state;
    String country;
    int zip;

    Address(){
        randomlyLoadData();
    }

    Address(String houseNo, String street, String city, String state, String country, int zip){
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.street = street;
        this.zip = zip;
    }

    @Override
    public void randomlyLoadData() {
        Random rand = new Random();
        this.houseNo = "ENAME_" + Integer.toString((int)(rand.nextFloat()*1000));;
        this.street ="ENAME_" + Integer.toString((int)(rand.nextFloat()*1000));;
        this.city = "ENAME_" + Integer.toString((int)(rand.nextFloat()*1000));;
        this.state = "ENAME_" + Integer.toString((int)(rand.nextFloat()*1000));;
        this.country = "ENAME_" + Integer.toString((int)(rand.nextFloat()*1000));;
        this.street = "ENAME_" + Integer.toString((int)(rand.nextFloat()*1000));;
        this.zip = (int)(rand.nextFloat()*1000000);;
    }
}

