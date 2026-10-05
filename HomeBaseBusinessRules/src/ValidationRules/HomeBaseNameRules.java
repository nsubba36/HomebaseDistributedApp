/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidationRules;
import java.util.List;
/**
 *
 * @author nishansubba
 */
public class HomeBaseNameRules {
    public void testUniqueNameForCategoryLocation(String name, List<String> existingNames) throws Exception {
        if (name == null || name.trim().isEmpty()) {
            throw new Exception("Name cannot be empty.");
        }

        String formatInput = name.trim().toLowerCase();

        for (String usedName : existingNames) {
            String formatUsedName = usedName.trim().toLowerCase();
            if (usedName != null && formatUsedName.equals(formatInput)) {
                 throw new Exception("Name must be unique. " + name + " already exists.");
            }
        }   
    }
}
