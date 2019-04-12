public class Main {
    public static void main(String ...args){
        Method method = new Method();
        method.solve();

        System.out.printf("minX: %1$.3f", method.minX);
        System.out.println();
        System.out.printf("minF: %1$.3f",method.Fmin);
        System.out.println();
        System.out.printf("f: %1$.3f", method.fy);
        System.out.println();
        System.out.printf("[ %1$.3f, %2$.3f ]", method.a, method.b);
    }

}
