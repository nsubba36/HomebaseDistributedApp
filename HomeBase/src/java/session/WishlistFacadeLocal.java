/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package session;

import entity.Wishlist;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author nishansubba
 */
@Local
public interface WishlistFacadeLocal {

    void create(Wishlist wishlist);

    void edit(Wishlist wishlist);

    void remove(Wishlist wishlist);

    Wishlist find(Object id);

    List<Wishlist> findAll();

    List<Wishlist> findRange(int[] range);

    int count();
    
}
