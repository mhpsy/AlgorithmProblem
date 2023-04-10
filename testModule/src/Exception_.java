public class Exception_ {
    public static void main(String[] args) {
        try {
            throwRecursiveException(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void throwRecursiveException(int depth) throws Exception {
        if (depth == 1000) {
            throw new Exception(depth + "");
        } else {
            throwRecursiveException(depth + 1);
        }
    }
}
