/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidationRules;

/**
 *
 * @author nishansubba
 */
public class HomeBaseQuantityRules {
    public void testItemQuantity(int quantity) throws Exception {
            if (quantity < 1) {
                throw new Exception("Quantity cannot be lower than 1.");
            }
        }
}
