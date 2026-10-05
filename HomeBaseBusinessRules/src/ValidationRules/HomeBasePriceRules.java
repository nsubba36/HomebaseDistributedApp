/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidationRules;

/**
 *
 * @author nishansubba
 */
public class HomeBasePriceRules {
    public void testItemPrice(int price) throws Exception {
        if (price < 0) {
            throw new Exception("Price cannot be lower than 0.");
        }
    }
}
