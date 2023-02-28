package cp6.n38;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class TestOp {

    public static void main(String[] args) {
        double x = 10;
        double y = 3;
        test(ExtendedOperation.class, x, y);
        test(BasicOperation.class, x, y);
        testC(Arrays.asList(ExtendedOperation.values()), x, y);
        testC(Arrays.asList(BasicOperation.values()), x, y);

    }
    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y){
        for(Operation op : opEnumType.getEnumConstants()) System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x,y));
    }
    private static void testC(Collection<? extends Operation> opSet, double x, double y){
        for(Operation op : opSet) System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x,y));
    }
}
