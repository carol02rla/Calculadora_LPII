public class Protocol {
    public Protocol() {
    }
    
    public String processLine(String input) {
        String array[] = input.split(" ");
        int num1 = Integer.parseInt(array[0]);
        String operador = array[1];
        int num2 = Integer.parseInt(array[2]);
        int result;

        if(operador.equals("+")) {
            result = num1 + num2;
        }
        else if(operador.equals("-")) {
            result = num1 - num2;
        }
        else if(operador.equals("*")) {
            result = num1 * num2;
        }
        else if(operador.equals("/")) {
            result = num1 / num2;
        }
        else {
            return "Operacao invalida";
        }

        return "Resposta: " + result;
    }
}