package models;

import com.avaje.ebean.Model;

import javax.persistence.*;


@Entity
@Table(name = "itementity")
public class ItemEntity extends Model{
    public static Finder<Long,ItemEntity> FINDER = new Finder<>(ItemEntity.class);

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "Item")
    private Long id;
    private Long product_id;
    private Long wishlist_id;
    private int quantity;

    public ItemEntity(){
        this.id=null;
        this.product_id = null;
        this.wishlist_id=null;
        this.quantity=0;
    }

    public ItemEntity(Long id,Long product_id, Long wishlist_id, int quantity) {
        this.id = id;
        this.product_id = product_id;
        this.wishlist_id = wishlist_id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(Long wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "id=" + id +
                ", product id='" + product_id + '\'' +
                ", wishlist_id=" + wishlist_id +
                ", quantity=" + quantity +
                '}';
    }
}
