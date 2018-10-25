package lab2;
/**
 *
 * @author terehin.andrey
 */
public class Toy implements Present {
    @Override
    public void whoAmI() {
        System.out.println("Toy");
    }

    @Override
    public String it_can_be_presented() {
        return "Toy can be presented" ;
    }
}
