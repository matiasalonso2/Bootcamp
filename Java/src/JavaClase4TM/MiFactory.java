package JavaClase4TM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.Properties;

public class MiFactory {

    public static Object getInstance(String objName){
        Properties properties= new Properties();
        Object result = null;
        try {
            properties.load(new FileInputStream(new File("MiFactory.properties")));
            String className = properties.get(objName).toString();
            System.out.println(properties.get(objName));
            Class cl = Class.forName(className);
            result = cl.getDeclaredConstructor().newInstance();
            return result;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        finally {
            return result;
        }
    }

    public static void main(String[] args) {
        Time time = new Time();

        Sorter instance = (Sorter) getInstance("sorter");
        Comparator comp = new ComparatorIntAsc();

        Integer[] arr = new Integer[100000];
        for (int i = 99999; i>=0; i--){
            arr[i] = i;
        }
        time.start();
        //Arrays.sort(arr);
        instance.sort(arr,comp);
        time.stop();
        System.out.println("Se demoro " + time.elapsedTime() + "ms");
        //for(Integer n : arr){
        //    System.out.println(n);
        //}
    }
}
