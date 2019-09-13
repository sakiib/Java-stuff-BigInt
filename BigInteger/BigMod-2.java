import java.util.*;
import java.math.BigInteger;

public class BigMod {
    public static void main( String args[] ) {
        Scanner scan = new Scanner( System.in );
        int t = scan.nextInt();
        for( int tc = 1; tc <= t; tc++ ) {
            BigInteger base = BigInteger.ZERO;
            BigInteger power = BigInteger.ZERO;
            BigInteger mod = BigInteger.ZERO;
            base = scan.nextBigInteger();
            power = scan.nextBigInteger();
            mod = scan.nextBigInteger();
            System.out.println( BigMod( base , power , mod ) );
        }
        System.exit( 0 );
    }
    static BigInteger BigMod( BigInteger b , BigInteger p , BigInteger m ) {
        if( p.compareTo( BigInteger.ZERO ) == 0 ) return BigInteger.ONE;
        BigInteger temp = BigMod( b , p.divide( BigInteger.valueOf( 2 ) ) , m );
        temp = temp.remainder( m );
        if( p.mod( BigInteger.valueOf( 2 ) ) == BigInteger.ZERO ) {
            temp = temp.multiply( temp );
            temp = temp.remainder( m );
        }
        else {
            temp = temp.multiply( temp ).multiply( b );
            temp = temp.remainder( m );
        }
        return temp;
    }
}
