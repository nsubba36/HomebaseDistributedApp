/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidationRules;
import java.util.Map;
/**
 *
 * @author nishansubba
 */
public class HomeBaseFieldRules {
    public void testRequiredField(Map<String, String> fields) throws Exception {

        for (Map.Entry<String, String> entry : fields.entrySet()) {
            String fieldLabel = entry.getKey();
            String fieldValue = entry.getValue();

            if (fieldValue == null || fieldValue.trim().isEmpty()) {
                throw new Exception(fieldLabel + " is required and cannot be empty.");
            }
        }
    }
}
