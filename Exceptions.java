import java.io.IOException;

//Exception handling In Java---------->
//1.checked Exceptions - it occurs on compile time
// 2. Unchecked Exceptions - it occurs on Runtime Exception
/*
Exception class is a subclass of the Throwable class
1. Error 2. Exception
 */
public class Exceptions {
    public static void ArrayIndexBoundExp(int[] arr) {
        try {
            System.out.println("Access Element : " + arr[4]);//try to access 4th element of array if present
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception Thrown : " + e);//else exception will throw
        }
    }

    //common scenarios of java exceptions
    static void ArithmeticExceptions(int num, int num2) {
        try {
            int res = num / num2;
            System.out.println(num + "/" + num2 + " = " + res);
        } catch (ArithmeticException e) {
            System.out.println("Exception Thrown : " + e);
        }
    }

    static void NullPointerExceptions(String str) {
        try {
            System.out.println("Length of String" + str.length());
        } catch (NullPointerException e) {
            System.out.println("Exception Thrown : " + e);
        }
    }

    static void NumberFormatExceptions(String str) {
        try {
            int num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println("Exception Thrown : " + e);
        }
    }
    //Handle the Exception using the parent class Exception ---->
    static void division(int num1,int num2){
        try{
            int res = num1/num2;
            System.out.println("Result : "+res);
        }catch(Exception e){
            System.out.println(e);
            //custom message
            System.out.println("Can't Divide By Zero");
            //resolving the exception
            int res = num1/(num2+2);
            System.out.println("Exception resolved :"+res);
        }
        System.out.println("Exception Handled");
    }
    //Multiple catch Block
    static void multipleCatch(int[] arre){
        try{
            arre[5]=30/0;
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arithmetic Exception occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(Exception e)
        {
            System.out.println("Parent Exception occurs");
        }
        System.out.println("Outside of the code");
    }
    //Nested try and finally Block
    static void NestedTry(int num,int[] ar){
        try{
            try{
                System.out.println("going to divide");
                num =39/0;
                System.out.println("Result : "+ num);
            }catch(ArithmeticException e){System.out.println(e);}

            try{
                ar[5]=4;
            }catch(ArrayIndexOutOfBoundsException e){System.out.println(e);}

            System.out.println("other statement");
        }catch(Exception e){System.out.println("handeled");}
        finally {
            System.out.println("This Block will be always Executed!");
        }

        System.out.println("normal flow..");
    }
    //use of throw keyword - it is used to throw a custom exception message in code.
    static void validate(int age){
        if(age<18){
            throw new ArithmeticException("Your age is Under 18!");
        }
        else{
            System.out.println("You are eligible for Voting!");
        }
    }
    public static void main(String[] args) {
        int[] Arr = new int[]{1, 2, 3};
        ArrayIndexBoundExp(Arr);
        ArithmeticExceptions(5,0);
        String s = null;
        NullPointerExceptions(s);
        String s1 = "abc";
        NumberFormatExceptions(s1);
        //Handled Exception
        division(3,0);
        //Multiple catch
        multipleCatch(Arr);
        //Nested Try
        NestedTry(40,Arr);
        //use of throw
        validate(17);
        Test3 test = new Test3();
        test.p();
        System.out.println("Normal Flow!");
    }

}
//Throws Keyword is used to declare an exception
class Test3{
    void m()throws IOException{
        throw new IOException("No Input value!");
    }
    void n()throws IOException{
        m();
    }
    void p(){
        try{
            n();
        }catch(Exception e){
            System.out.println("Exception Handled!");
        }
    }
}
