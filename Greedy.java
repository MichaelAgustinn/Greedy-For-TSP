import java.util.ArrayList;
import java.util.Scanner;

public class Greedy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //@formatter:off
        int[][] jalur = {
            {0,1,22,23,24,25,26,15,27,28,29,30,31,14},
            {1,0,2,40,39,38,37,36,16,35,34,33,32,31},
            {22,2,0,3,49,48,47,46,45,17,44,43,42,41},
            {23,40,3,0,4,57,56,55,54,53,18,52,51,50},
            {24,39,49,4,0,5,64,63,62,61,60,19,59,58},
            {25,38,48,57,5,0,6,70,69,68,67,66,20,65},
            {26,37,47,56,64,6,0,7,75,74,73,72,71,21},
            {15,36,46,55,63,70,7,0,8,80,79,78,77,76},
            {27,16,45,54,62,69,75,8,0,9,84,83,82,81},
            {28,35,17,53,61,68,74,80,9,0,10,87,86,85},
            {29,34,44,18,60,67,73,79,84,10,0,11,88,87},
            {30,33,43,52,19,66,72,78,83,87,11,0,12,89},
            {31,32,42,51,59,20,71,77,82,86,88,12,0,13},
            {14,31,41,50,58,65,21,76,81,85,87,89,13,0},
        };
        //@formatter:on
        ArrayList<Integer> tampungNilai = new ArrayList<>();
        boolean[] jejak = new boolean[jalur.length];
        int min = Integer.MAX_VALUE;
        int totalJarak = 0;

        int awalan = in.nextInt();
        int kotaSekarang = awalan - 1;
        jejak[kotaSekarang] = true;
        tampungNilai.add(kotaSekarang);

        while (tampungNilai.size() < jalur.length) {
            int index = 0;
            min = Integer.MAX_VALUE;
            for (int i = 0; i < jalur[kotaSekarang].length; i++) {
                if (jalur[kotaSekarang][i] < min && jalur[kotaSekarang][i] != 0 && !jejak[i]) {
                    min = jalur[kotaSekarang][i];
                    index = i;
                }
            }
            totalJarak += jalur[kotaSekarang][index];
            kotaSekarang = index;
            jejak[kotaSekarang] = true;
            tampungNilai.add(kotaSekarang);

            index = 0;
        }
        tampungNilai.add(awalan - 1);
        totalJarak += jalur[kotaSekarang][0];

        for (int i = 0; i < tampungNilai.size(); i++) {
            System.out.print("V" + (tampungNilai.get(i) + 1) + " ");
        }
        System.out.println("= " + totalJarak);
        in.close();
    }
}
