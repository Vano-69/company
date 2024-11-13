package telran.generic;

import telran.generic.model.JsonWrapper2;

public class JsonWrapper2Appl {
    public static void main(String[] args) {
        JsonWrapper2<Integer> wrapper1 = new JsonWrapper2<>(10);
        System.out.println(wrapper1);
        Integer a = wrapper1.getValue();
        System.out.println(a);
        JsonWrapper2<String > wrapper2 = new JsonWrapper2<>("Hello");
        System.out.println(wrapper2);
    }
}
