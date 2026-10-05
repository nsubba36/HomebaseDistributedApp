/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ValidationRules;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
/**
 *
 * @author nishansubba
 */
public class HomeBaseDateRules {
    public void testItemDate(String date) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);
        LocalDate inputDate;
        
        // check format
        try {
            inputDate = LocalDate.parse(date, dtf);
        } catch (DateTimeParseException e) {
            throw new Exception("Invalid date format. Use yyyy-mm-dd");
        }
        // check date to make sure its not in the future
        // item cannot have future date since it should be the date you added or bought.
        if (inputDate.isAfter(LocalDate.now())) {
            throw new Exception("Date cannot be in the future");
        }
    }
}
