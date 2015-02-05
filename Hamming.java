package singlefile;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * Programmed By Sanat Rohatgi
 */
public class Hamming {

    public static void main(String br[]) throws Exception {

        Vector finalcode = new Vector();
        String code, codecopy;
        int cod = 0, ke, i = 1;
        Scanner sc = new Scanner(System.in);
        boolean notput = false;
        System.out.println("Enter the code");
        code = sc.nextLine();
        codecopy = code;
        Hamming obj = new Hamming();
        while (codecopy.length() > 0) {
            if (notput == false) {                  //take next bit only if the previous bit has been already put in the vector
                cod = Integer.parseInt(codecopy.substring(0, 1));
                codecopy = codecopy.substring(1);
            }

            if ((i & (i - 1)) == 0) {                 //if the position index is a power of 2 
                //then put -1 tempporarily 
                finalcode.add(-1);
                notput = true;
                i++;
                continue;
            }
            if (cod == 1) {
                finalcode.add(1);
                i++;
                notput = false;
            }
            if (cod == 0) {
                finalcode.add(0);
                i++;
                notput = false;
            }
        }
        for (int j = 0; j < finalcode.size(); j++) {
            if (finalcode.get(j) == -1) {           //if the index has -1 then calculate parity for that index
                ke = obj.getbit(finalcode, j);
                finalcode.set(j, ke);
            }
        }
        System.out.println("The final code is" + finalcode);
    }

    int getbit(Vector code1, int paritybit) {
        int pbit, finalpbit = 0;
        for (int i = 2; i < code1.size(); i++) {            //get n bits to calculate parity
            for (int y = 0; y < paritybit + 1; y++) {
                pbit = getspecificbit(code1, i);
                if (pbit == -1) {
                    break;
                }
                i++;
                finalpbit = (finalpbit != pbit) ? (1) : (0);
            }
            for (int u = 0; u < paritybit; u++) {           //Skip n bits
                i++;
            }
        }

        return finalpbit;
    }

    int getspecificbit(Vector code2, int pos) {      //specific bit at the pos index
        int dum;

        if (pos >= code2.size()) {
            dum = -1;
            return dum;
        } else {
            dum = (code2.elementAt(pos) == '0') ? (0) : (1);
        }

        return dum;
    }
}
