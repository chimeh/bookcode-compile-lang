// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.malsolo.crm.domain;

import com.malsolo.crm.domain.CartOrder;
import com.malsolo.crm.domain.Company;
import java.lang.String;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

privileged aspect Customer_Roo_DbManaged {
    
    @OneToMany(mappedBy = "customerId")
    private Set<CartOrder> Customer.cartOrders;
    
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "COMPANY_ID")
    private Company Customer.companyId;
    
    @Column(name = "LAST_NAME")
    private String Customer.lastName;
    
    @Column(name = "FIRST_NAME")
    private String Customer.firstName;
    
    public Set<CartOrder> Customer.getCartOrders() {
        return this.cartOrders;
    }
    
    public void Customer.setCartOrders(Set<CartOrder> cartOrders) {
        this.cartOrders = cartOrders;
    }
    
    public Company Customer.getCompanyId() {
        return this.companyId;
    }
    
    public void Customer.setCompanyId(Company companyId) {
        this.companyId = companyId;
    }
    
    public String Customer.getLastName() {
        return this.lastName;
    }
    
    public void Customer.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String Customer.getFirstName() {
        return this.firstName;
    }
    
    public void Customer.setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
}
