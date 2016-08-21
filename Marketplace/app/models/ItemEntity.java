package models;

import com.avaje.ebean.Model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "itementity")
public class ItemEntity extends Model{
    public static Finder<Long,ItemEntity> FINDER = new Finder<>(ItemEntity.class);

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Item")
    private Long id;
    
    @ManyToOne(optional=false)
    private ProductEntity product;

    @ManyToOne(optional=false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private WishListEntity wishList;

    private int quantity;

    public ItemEntity(){
        this.id=null;
        this.wishList = null;
        this.product = null;
        this.quantity=0;
    }

    public ItemEntity(Long id, int quantity, WishListEntity wishList, ProductEntity product) {
        this.id = id;
        this.quantity = quantity;
        this.wishList = wishList;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWishList(WishListEntity wishList)
    {
        this.wishList = wishList;
    }

    public WishListEntity getWishList()
    {
        return wishList;
    }


    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", product id='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}