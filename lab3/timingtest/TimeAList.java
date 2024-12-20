package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.print("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int[] samples = {1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};

        timeAListWithSamples(Ns, times, opCounts, samples);

        printTimingTable(Ns, times, opCounts);
    }

    private static void timeAListWithSamples(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts, int[] samples) {
        for (int i : samples) {
            Ns.addLast(i);
            times.addLast(addItems(i));
            opCounts.addLast(i);
        }
    }

    private static double addItems(int n) {
        AList<Integer> list = new AList<>();
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < n; i++) {
            list.addLast(i);
        }
        return sw.elapsedTime();
    }
}
