package models;
import com.avaje.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wishlistentity")

public class WishListEntity extends Model
{
    public static Model.Finder<Long,WishListEntity> FINDER = new Model.Finder<>(WishListEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WishList")
    private Long id;
    private String username;

    @OneToMany(mappedBy="wishList")
    private List<ItemEntity> items;


    public WishListEntity() {
        id = null;
        username = "NONE";
    }

    public WishListEntity(Long id, List<ItemEntity> items, String username) {
        this.id = id;
        this.username = username;
        this.items = items;
    }

    public WishListEntity(Long id) {
        this();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void addItem(ItemEntity item)
    {
        items.add(item);
    }

    public List<ItemEntity> getItems()
    {
        return items;
    }

    @Override
    public String toString() {
        return "WishListEntity{" +
                "id=" + id +
                ", username='" + username +
                '}';
    }
}