package se.chasacademy.databaser.jpaorders;

import jakarta.persistence.*;

@Entity
public class OrderLine {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderLine getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(OrderLine orderLine) {
        this.orderLine = orderLine;
    }

    @Id @GeneratedValue private Long id;
    @ManyToOne @JoinColumn(name ="OrderLine_id") private OrderLine orderLine;
}
