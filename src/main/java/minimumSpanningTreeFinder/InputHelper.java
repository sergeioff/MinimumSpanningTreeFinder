package minimumSpanningTreeFinder;

import java.io.*;
import java.util.InputMismatchException;

/**
 * Wrapper class for read data from different sources.
 * By default it reads data from {@link System#in}
 * @author sergeioff
 */
public class InputHelper {
    private BufferedReader reader;

    /**
     * Creates new instance that reads data from {@link System#in}
     */
    InputHelper() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Creates new instance that reads data from specified <tt>inputStream</tt>.
     * @param inputStream input stream.
     */
    public InputHelper(InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    /**
     * Creates new instance that reads data from specified file.
     * @param fileName file name.
     */
    public InputHelper(String fileName) {
        try {
            this.reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("No such file! Restart program and try another file name.");
            System.exit(1);
        }
    }

    /**
     * Sets new input stream to reader.
     * @param inputStream - input stream.
     */
    public void setNewInputStream(InputStream inputStream) {
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    /**
     * Reads line.
     * @return line.
     */
    public String readLine() {
        try {
           return reader.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        return null;
    }

    /**
     * Reads integer.
     * @return integer number.
     */
    public int readInteger() {
        int value = -1;
        try {
            value = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Wrong input! Please enter a number!");
            value = readInteger();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return value;
    }

    /**
     * Reads array of integers.
     * @return array of integers.
     */
    public int[] readIntegers() {
        int[] integers = null;
        try {
            String line = reader.readLine();
            String[] parts = line.split(" ");

            if (parts.length != 3) throw new InputMismatchException();

            integers = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {
                integers[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException | InputMismatchException e) {
            System.err.println("You've made a mistake. Please re-enter line!");
            integers = readIntegers();
        } catch (NullPointerException e) {
            System.err.println("Please check your file. It has mistakes!");
            System.exit(1);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        return integers;
    }
}
