import java.util.Scanner;
import java.lang.String;




class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = (new Scanner(System.in));
        System.out.println("Введите выражение с двумя цыфрами");
        String expression = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Ответ");
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int number1;
        int number2;
        String oper;
        String result;
        boolean isRoman;
        String[] operands = expression.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Должно быть введено 2 числа");
        oper = detectOperationion(expression);
        if (oper == null) throw new Exception("Не поддерживается канкулятором");
        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
            number1 = Roman.convertToArabian(operands[0]);
            number2 = Roman.convertToArabian(operands[1]);
            isRoman = true;
        }
        else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            number1 = Integer.parseInt(operands[0]);
            number2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        else {
            throw  new Exception("Числа должны быть на одном математическом языке");
        }
        if (number1 > 10 || number2 > 10) {
            throw new Exception("Число должно быть не больше 10");
        }
        int arabian = calc(number1, number2, oper);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("Римские числа должны быть не ниже I");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }

    static String detectOperationion(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calc(int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else if (oper.equals("/")) return a / b;
        else return a / b;
    }
}

class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V",
            "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV",
            "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV",
            "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII",
            "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI",
            "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
            "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX",
            "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII",
            "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI",
            "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII",
            "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX",
            "XС", "XСI", "XСII", "XСIII", "XСIV", "XСV", "XСVI", "XСVII", "XСVIII",
            "XСIX", "С",};

    public  static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])){
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) { return romanArray[arabian]; }



}
