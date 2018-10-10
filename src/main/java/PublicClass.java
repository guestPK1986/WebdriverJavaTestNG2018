import org.testng.annotations.Test;

public class PublicClass {

    @Test
    public void try001() {
        System.out.println("Hello, World!");
    }

    @Test
    public void test002() {

        int myNumber;
        myNumber = 5;

        System.out.println(myNumber);
    }

    @Test
        public void test003() {
        double d = 7.5;
        d = 3.0;
        System.out.println(d);

    }
    @Test
        public void test004() {
        char c = 'g';
        System.out.println(c);
    }

    @Test
        public void test005(){

        String s2 = "who...";
        String s3 = "123";
        System.out.println(s2+ "   " + s3);

    }
    @Test
        public void test006(){

        boolean b;
        b = true;

        boolean toBe = false;
        b = toBe || !toBe;

        if (b == true) {
            System.out.println(toBe);
        }
    }
    @Test
        public void test007(){
        int a = 1;
        int b = 2;
            if (a ==b )
                System.out.println("equals");

            else
                System.out.println("differs");
        }
    @Test
    public void test008(){

        int num = 5;
        String s = "I have " + num + " cookies";
        System.out.println(s);
    }

    @Test
    public void test009(){
        int a = 3100;
        float b = (float) 2.0;

        boolean c;
        c = true;

        boolean toBe = false;
        c = toBe || !toBe;

        if (c == true)

        System.out.println("H"+ a + " "+ "w0r1d " + b + " "+ c);


    }



    }


