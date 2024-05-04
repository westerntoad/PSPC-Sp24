import java.io.File;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Driver {

    private static Scanner getScanner(String fileName) {    // finished
        File file = new File(fileName);
        Scanner scanner = new Scanner(System.in);

        try {
            scanner = new Scanner(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scanner;
    }

    private static void practice(Scanner scanner) {     // finished
        while(scanner.hasNext()) {
            int num = scanner.nextInt();

            if (num == 0)
                return;

            String out = "The number " + num + " is ";
            out = out + ( num % 2 == 0 ? "EVEN." : "ODD.");
            System.out.println(out);
        }
    }

    private static void problemA(Scanner scanner) {     // finished
        while(scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            if (line.length < 3)
                continue;

            System.out.println(line[0]);
            System.out.println(line[1]);

            int i = 2;
            String word = line[i];
            while(word.equals(word.toUpperCase())) {
                System.out.print(word + " ");
                i++;
                word = line[i];
            }
            System.out.println("\n");

            int n = 1;
            while (i < line.length) {

                for(int j = 0; j < n && i + j < line.length; j++) {
                    System.out.print(line[j + i] + " ");
                }
                System.out.println();

                i += n;
                n++;
            }

            System.out.println();
        }
    }

    private static void problemB(Scanner scanner) {     // finished
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            if (str.equals(str.toUpperCase())) {
                System.out.println("GONK");
            } else {
                System.out.println("gonk");
            }
        }
    }

    private static void problemC(Scanner scanner) {     // finished
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(2 * n * (n - 1));
        }
    }

    private static void problemD(Scanner scanner) {

        while (scanner.hasNext()) {
            final double laserSpeed = 168. / 1000.; // ft/ms
            final double timeToReact = 50.; // ms
            final double timeToDisable = 400.; // ms

            int n = scanner.nextInt();

            int enemiesDisabled = 1;
            int numDeflected = 1;
            double extra = scanner.nextFloat() * laserSpeed;  // ms to ft
            double total = scanner.nextFloat() + extra; // extra + ft
            double time = total;
            boolean flag = false;
            for(int i = 0; i < n - 1; i++) {
                extra = laserSpeed * scanner.nextFloat();
                total = extra + scanner.nextFloat();
                double actualTime = (total-time)/168 * 1000;
                time = total;
                if (actualTime < 50) {
                    flag = true;
                    }
                if (actualTime < 400 && !flag) {
                    numDeflected++;
                } else if (!flag){
                    numDeflected++;
                    enemiesDisabled++;
                }
            }
            String str = enemiesDisabled + " enemies disabled";
            if (flag) {
                System.out.println(str + ", " + numDeflected + " shots deflected before jumping to safety.");
            } else {
                System.out.println(str + " and all shots deflected.");
            }

        }
    }

    private static void problemE(Scanner scanner) {

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] jumps = new String[n*3];
            for (int i = 0 ; i<n; i++) {
                String[] k = scanner.nextLine().split(",");
                System.arraycopy(k, 0, jumps, i*3, 3 );
            }

            float max = Float.MIN_VALUE;
            int skip = 0;
            for(int i = 0; i < n - 1; i++) {
                int num = i;
                int average = 0;
                if (i == 0) {
                    num = i + 1;
                    average = (Integer.parseInt(jumps[2].trim()) + Integer.parseInt(jumps[(num+1) * 3-1].trim()) / 2);
                } else {
                    average = (Integer.parseInt(jumps[i * 3 - 1].trim()) + Integer.parseInt(jumps[(num + 1) * 3 - 1].trim()) / 2);
                }
                if (average > max) {
                    max = average;
                    skip = i+1;
                }
            }
            double sum = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int num = i;
                if (i == 0) {
                    num +=1;
                }
                if (i != skip) {
                    sb.append(jumps[i] + ",");
                    sum += Integer.parseInt(jumps[num*3 -1].trim());
                } else {
                    sb.append(jumps[i*2-1]+ ",");
                    sum += max;
                }
        }
            System.out.print(sum + sb.toString());
            System.out.println();
        }
    }

    private static void problemF(Scanner scanner) {
        while (scanner.hasNextInt()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();

            double v = 0.1 * (4. / 3.) * Math.PI * x * y * z;
            double k = v * 0.5;
            double calc = (4. / 3.) * Math.PI * (x - k) * (y - k) * (z - k);

            while (round(calc, 5) != round(v, 5)) {
                System.out.println(k);
                if (calc < v) {
                    k += 0.5 * k;
                } else {
                    k -= 0.5 * k;
                }

                calc = (4. / 3.) * Math.PI * (x - k) * (y - k) * (z - k);
            }

            System.out.println(k);
        }
    }

    private static void problemG(Scanner scanner) {
        while (scanner.hasNextInt()) {
            String[] line = scanner.nextLine().split(" ");
            int n = line.length;
            int[] arr = new int[n];
            int[] minSteps = new int[n];

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(line[i]);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    minSteps[i] += Math.abs(arr[i] - arr[j]);
                }
            }

            int idx = 0;
            for(int i = 0; i < n; i++) {
                if (minSteps[i] < minSteps[idx]) {
                    idx = i;
                }
            }

            System.out.println(idx);
        }
    }

    private static void problemH(Scanner scanner) {

    }

    private static void problemI(Scanner scanner) {
        while (scanner.hasNextDouble()) {
            double x0 = scanner.nextDouble();
            double y0 = scanner.nextDouble();
            double z0 = scanner.nextDouble();

            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();

            System.out.println(round(x1 - x0 + x1, 1) + " " + round(y1 - y0 + y1, 1) + " " + round(z1 - z0 + z1, 1));
        }
    }

    private static double round(double val, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(val * scale) / scale;
    }

    private static void problemJ(Scanner scanner) {
        String[] key = scanner.nextLine().split(" ");
        while(scanner.hasNext()) {
            boolean flag = true;
            String msg = scanner.nextLine();
            for (String s : key) {
                if(msg.toLowerCase().contains(s.toLowerCase())) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Sure thing, my Lord!");
            } else {
                System.out.println("That’s immoral! Get some help!");
            }
        }
    }


    public static void main(String[] args) {
        problemF(getScanner("f.in.txt"));
    }
}
