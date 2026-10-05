package entity;

import entity.Item;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2026-04-05T14:41:25")
@StaticMetamodel(Location.class)
public class Location_ { 

    public static volatile SingularAttribute<Location, String> note;
    public static volatile CollectionAttribute<Location, Item> itemCollection;
    public static volatile SingularAttribute<Location, Integer> locationId;
    public static volatile SingularAttribute<Location, String> name;

}