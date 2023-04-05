import java.util.Objects;

public class Heap {
    // try {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int[] line1 = new int[4];
//        String[] arr = br.readLine().split("\s");
    public static void main(String[] args) {
        int size = 7;

        String instructions = "I 5" +
                "I 3" +
                "P" +
                "I 9" +
                "I 2" +
                "I 1" +
                "P";
        Instruction[] arr = new Instruction[size];

//        for (Instruction instruction :
//                arr) {
//            arr =
//        }
        System.out.println();
    }

}

record Instruction(Inst instruction, int value) {
    public Instruction {
        Objects.requireNonNull(instruction);
        Objects.requireNonNull(value);
    }

    static Instruction instructionFromString(String data) {
        String[] split = data.split("\s");
        Inst inst = Inst.of(split[0]);
        int value = Integer.parseInt(split[1]);

        return new Instruction(inst, value);
    }
}

enum Inst {
    INSERT, PRINT, EXTRACT_MAX;

    static Inst of(String s) {
        switch (s) {
            case "I":
                return Inst.INSERT;
            case "P":
                return Inst.PRINT;
            case "E":
                return Inst.EXTRACT_MAX;
            default:
                throw new RuntimeException("invalid value");
        }
    }

}