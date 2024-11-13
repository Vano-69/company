package telran.generic;

import telran.generic.model.JsonWrapper1;

public class JsonWrapper1Appl {
    public static void main(String[] args) {
        JsonWrapper1 wrapper1 = new JsonWrapper1(10);
        System.out.println(wrapper1);
//        Integer a = (Integer) wrapper1.getValue();
        String a = (String) wrapper1.getValue();
        System.out.println(a);
    }
}
