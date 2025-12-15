package se.chasacademy.databaser.jpaorders;

import jakarta.persistence.*;

@Entity
public class Customer {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Id @GeneratedValue private Long id;
    @ManyToOne @JoinColumn(name = "Customer_id") private Customer customer;
}
