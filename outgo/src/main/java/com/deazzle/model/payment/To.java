package com.deazzle.model.payment;

import com.fasterxml.jackson.annotation.*;

public class To {
/*    private Person person;

    @JsonProperty("person")
    public Person getPerson() { return person; }
    @JsonProperty("person")
    public void setPerson(Person value) { this.person = value; }
    */
    
    private Business business;

    @JsonProperty("business")
    public Business getBusiness() { return business; }
    @JsonProperty("business")
    public void setBusiness(Business value) { this.business = value; }
}
