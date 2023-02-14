package BasicJava;

public class bit {
    public static void main(String[] args) {
        // number to bit

        //13->odd                 1
        //13>>1 or 13/2= 6->even  0
        //6/2=3->                 1
        //3/2=1->                 1
        //13 = 1011

        //know bit in number

        //101101 = 1 *2^5 + 0 *2^4 + 1 *2^3 + 1 *2^2+ 0 *2^1+ 1 *2^0
        //       = 32+13=45

        // &-> bane bit 1 1 then 1 naka all time 0
        // |-> bane bit 0 0 then 0 naka all time 1
        // ^-> bane bit alag linke 01 ,10 then   1 naka 0
        // ~->NOT GATE jem


        //for sum in bit
        // 1011011->91
        //+0101010->42
        //---------
        //10000101->133

        //for sub
        // 8
        //-3
        //---
        //5


        //in bit like sum  8+(-3)=5
        //for negative number
        // 2 comp of 3->000....11

        //   ~3->111....00
        //       +00.....1
        //-----------------
        // -3=111.......01

        //8+(-3)
        //00.....1000
        //+111...1101
        //------------
        //0000..000101->5

        //bit masking video and book

    }
}
