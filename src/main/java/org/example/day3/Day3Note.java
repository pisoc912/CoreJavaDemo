package org.example.day3;

import org.example.exception.UserNotFoundException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Supplier;

public class Day3Note {
    /**
     * 1. Exception(are used to handle errors that can be recovered from within the program.)
     *    Error (can't control)
     *    # Checked Exception => compile
     *      handle
     *          try/catch
     *         #    public static void main(String[] args){
     *                  try{
     *                      fileReader("/");
     *                  } catch (FileNotFoundException e){
     *                      throw new RuntimeException(e);
     *                  }
     *              }
     *
     *              public static void fileReader(String path) throws FileNotFoundException{
     *
     *              }
     *          throws
     *              throws VS throw
     *              throws: declare the exceptions that method potentially throw.
     *              throw: explicitly throw an exception from within a block of code or a method
     *              .
     *            # public static String main(String str) {
     *                if(str == null || str.length() == 0){
     *                    throw new Error() / new IllegalArgumentException();  //both correct
     *                }
     *                return null;
     *            }
     *    # UnChecked Exception => runtime
     *          ArithmeticException
     *          ArrayIndexOutOfBoundsException
     *          ClassCastException
     *          NullPointerException
     *
     *    # Customized Exceptions(extends Exception/RuntimeException)
     *          public class UserNotFoundException extends RuntimeException{
     *              public UserNotFoundException(){
     *                  super();
     *              }
     *              public UserNotFoundException(String msg){
     *                  super(msg + "this is a customized exception");
     *              }
     *          }
     *
     *          public static void main(String[] args){
     *              throw new UserNotFoundException("asdasdasd");
     *          }
     *    # finally
     *      will execute no matter try/catch block have return or not
     *
     *    # multiple catch
     *          public static void main(String[] args){
     *              try{
     *                  throw new IOException("sample IOException");
     *              }catch (IOException | NullPointerException | ArithmeticException e){
     *                  System.out.println(e);
     *              }catch (Exception ex){
     *                  System.out.println(ex);
     *              }
     *          }
     *    # try with resources
     *      version < 7
     *          public static void main(String[] args){
     *              BufferedReader br = null;
     *          try{
     *              br = new BufferedReader(new FileReader("/"));
     *          }catch (FileNotFoundException ex){
     *              throw new RuntimeException(ex);
     *          }
     *          try{
     *              br.readLine();
     *          }catch (IOException e){
     *              throw new RuntimeException(e);
     *          } finally {
     *              try{
     *                  br.close();
     *              }catch (IOException e){
     *                  throw new RuntimeException(e);
     *              }
     *          }
     *      version > 7
     *          public static void main(String[] args) {
     *              try(BufferedReader br = new BufferedReader(new FileReader("/"))){ //autocloseable
     *                  br.readLine();
     *              }catch (FileNotFoundException e){
     *                  throw new RuntimeException(e);
     *              }catch (IOException ex){
     *                  throw new RuntimeException(ex);
     *              }
     *          }
     */

    /*
        2. Generics(request params need to be Object Type)
            class Node<K,V> {
                K key;
                V value;
                public Node(K key,V value){
                    this.key = key;
                    this.value = value;
                }
            }

            Node<Integer,String> node = new Node<>(1,"Bob");
            Node<Double,Character> node2 = new Node<>(1.1,'a');
                    |                                           after compile
             cannot be primitive type
             (type erasure, Node<int,string> => Node<Object,Object> int(not Object) => can't handle)

           # <?>,<A extend B>,<B super A>
             <?>: represent any types of generics & can only read NOT write(except write null)
             <A extend B>: Indicates that type A must be a subclass of type B or type B itself.
                           This boundary restriction enables the use of polymorphism in generics.
                           Only used for read.
             <B super A>: Indicates that type B must be a superclass of type A or type A itself.
                          This bounding enables more general writing operations within generics.
                          Only used for write.
           # int / int[]
             int not inherited from Object
                 public static void main(String[] args) {
                    int[] array = new int[]{1,2,3,4};
                    System.out.println(getFirstElement(array));
                }

                public static <E> E getFirstElement(E[] array){
                    return array[0];
                }
             int[] inherited from Object
                    public static void main(String[] args) {
                        int[][] array = new int[][]{{1,2,3},{13},{3,5,78}};
                        System.out.println(Arrays.toString(getFirstElement(array)));
                    }

                    public static <E> E getFirstElement(E[] array){
                        return array[0];
                    }
     */

    /*
        3. Java 8 new feature
           lambda expression
           (arguments -> {body}
           1. Workout wk = () -> {System.out.println("this is lambda");
              we.run();
           2. List<String> list = Arrays.asList("a", "b", "c");
              list.forEach(item -> System.out.println(item)); //output: "a","b","c"
           3. BinaryOperator<Integer> adder = (a, b) -> a + b;
              System.out.println(adder.apply(5, 3)); // output: 8
           4. Functional Interface // optional
                => only one abstract method，there can be multiple default methods and static methods
                @FunctionalInterface
                public interface MyFunctionalInterface {
                    void myMethod();
                }

             interface: Can contain multiple abstract methods, default methods and static methods

             predefined functional interface
                Predicate(accepts a parameters and return boolean value)
                    public Boolean test(T t)
                    Predicate<Integer> isEven = (n) => n % 2 == 0; => output: true

                Function(accepts a single input parameters and return results)
                    public R apply(T t)
                    Function<Integer,String> intToString = (n) => "Number" + n;

                Consumer(accepts a single input parameters and return no results)
                    public void accept(T t)
                    Consumer<String> print = (s) -> System.out.println(s);

                Supplier(NO input, give result)
                    public R get();
                    Supplier<Double> randomVal = () -> Math.random();

                BiPredicate(two parameters of the same type and returns the same type of result)
                    public boolean test(T t,U u)
                    BinaryOperator<Integer> add = (a, b) -> a + b;
                    System.out.println(add.apply(2, 3)); // output 5

                BiFunction(Represents a function that accepts two parameters and returns a result)
                    public R apply(T t, U u);
                    BiFunction<Integer, Integer, String> concatenate = (a, b) -> "Result: " + (a + b);
                    System.out.println(concatenate.apply(2, 3)); //  Result: 5
            5. Optional => Container object, used to contain non-null values or represent missing values
                Optional<String> emptyOpt = Optional.empty(); //output: Optional.empty
                Optional<String> nonEmptyOpt = Optional.of("Hello"); // is input is null -> NullPointerException
                Optional<String> nullableOpt = Optional.ofNullable(null);
                if (nonEmptyOpt.isPresent()) System.out.println("Value is present");
                String value = nonEmptyOpt.get(); //if null, throw NoSuchElementException
                String valueOrDefault = nullableOpt.orElse("Default Value"); // if exists return value else default
                String valueOrSupplier = nullableOpt.orElseGet(() -> "Default from Supplier");
                //Returns the value if it exists; otherwise generates a default value from the provided Supplier
                String valueOrException = nullableOpt.orElseThrow(() -> new IllegalArgumentException("Value not present"));
                //If the value exists, returns the value; otherwise throws the exception generated by the provided Supplier.
     */

    public static void main(String[] args) {
        Optional<String> emptyOpt = Optional.empty();
        System.out.println(emptyOpt);
    }

    public static <E> E getFirstElement(E[] array){
        return array[0];
    }
}

@FunctionalInterface
interface Drawable{
    public void draw();
}

class Node<K,V> {
    K key;
    V value;
    public Node(K key,V value){
        this.key = key;
        this.value = value;
    }
}