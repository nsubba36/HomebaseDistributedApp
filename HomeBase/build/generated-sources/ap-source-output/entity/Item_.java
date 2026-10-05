package entity;

import entity.Category;
import entity.Location;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2026-04-05T14:41:25")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, String> date;
    public static volatile SingularAttribute<Item, Integer> itemId;
    public static volatile SingularAttribute<Item, String> note;
    public static volatile SingularAttribute<Item, Integer> cost;
    public static volatile SingularAttribute<Item, Integer> quantity;
    public static volatile SingularAttribute<Item, Location> locationId;
    public static volatile SingularAttribute<Item, String> name;
    public static volatile SingularAttribute<Item, String> urlPath;
    public static volatile SingularAttribute<Item, Category> categoryId;

}