package liscircular;

import da.ListaCircular;

public class LisCircular {

    public static void main(String[] args) {
        ListaCircular lc = new ListaCircular();
        lc.add('0');
        lc.add('1');
        lc.add('2');
        lc.add('3');
        lc.add('4');
        lc.add('5');
        lc.add('6');
        lc.add('7');
        lc.add('8');
        lc.add('9');
        lc.add('a');

        System.out.println(lc.toString());
        System.out.println(lc.size());
        lc.borraPrimos();
        System.out.println(lc.toString());
        System.out.println(lc.size());
    }

}
