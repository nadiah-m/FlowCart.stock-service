package net.javaguides.stockservice.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private String orderId;
    private String name;
    private int qty;
    private double price;
   // @CreatedDate
  //  @Column(name = "created_at", updatable = false) // Do not update the creation date
   // private LocalDateTime createdAt;

    //@LastModifiedDate
  //  @Column(name = "updated_at")
   // private LocalDateTime updatedAt;
    // Getters and setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

 //   public LocalDateTime getCreatedAt() {
 //       return createdAt;
 //   }

  //  public void setCreatedAt(LocalDateTime createdAt) {
 //       this.createdAt = createdAt;
  //  }

  //  public LocalDateTime getUpdatedAt() {
  //      return updatedAt;
  //  }

  //  public void setUpdatedAt(LocalDateTime updatedAt) {
  //      this.updatedAt = updatedAt;
  //  }
    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
   //             ", createdAt=" + createdAt +
    //            ", updatedAt=" + updatedAt +
                '}';
    }
}
