public class Docker {
    public static void main(String[] args) {
        System.out.println("hello ");
//        lambda
        Lam lam = () -> System.out.println("people run");
//        匿名内部类
        Lam l = new Lam() {
            @Override
            public void run() {
                System.out.println("people");
            }
        };
//        实现类
        L ls = new L();

  lam.run();
    }


}
@FunctionalInterface
interface Lam{
    public void run();
}

class L implements  Lam{
    @Override
    public void run() {
        System.out.println("people");
    }
}
