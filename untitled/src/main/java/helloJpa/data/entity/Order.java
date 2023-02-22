package helloJpa.data.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDERS") // 와 키워드... 와...
public class Order {
    @Id @GeneratedValue
    @Column(name="ORDER_ID")
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name="MEMBER_ID")
    private Member member;

    public Order() {
    }

    public Order(Date orderDate, OrderStatus status, Member member) {
        System.out.println("여기서 확인하자");
        this.orderDate = orderDate;
        System.out.println("여기서 확인하자");
        this.status = status;
        System.out.println("여기서 확인하자");
        this.member = member;
    }

    @OneToMany(mappedBy="order")
    private List<OrderItem> orderItems=new ArrayList<>();


    @OneToOne
    @JoinColumn(name="DELIVERY_ID")
    private Delivery delivery;

    public void setDelivery(Delivery delivery){
        this.delivery=delivery;
        delivery.setOrder(this);
    }
    public void setMember(Member member){
        if(this.member !=null){
            this.member.getOrderList().remove(this);
        }

        this.member=member;
        member.getOrderList().add(this);
    }

    public void addOrderItem(OrderItem orderItem){
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public Long getId() {
        return id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Member getMember() {
        return member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }


}

