package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataFiles {
    public static Collection<String[]> csvFileAsCollectionOfStringArrays(String csvFileName) {
        List<String[]> csvRows = new ArrayList<String[]>();
        String rawCSVRow;
        BufferedReader csvFileReader = null;
        String delimiter = ",";

        //System.out.println("Reading data from " + csvFileName);

        // Create reader and open CSV file
        try {
            csvFileReader = new BufferedReader(new FileReader(csvFileName));
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file " + csvFileName);
            e.printStackTrace();
        }

        // Read each row of CSV file, split items on delimiter
        int rowNumber = 1;

        try {
            while ((rawCSVRow = csvFileReader.readLine()) != null) {
                String delimitedItems[] = rawCSVRow.split(delimiter, -1);
                csvRows.add(delimitedItems);
                rowNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error reading row number " + rowNumber);
        }

        // Close CSV file
        try {
            csvFileReader.close();
        } catch (IOException e) {
            System.out.println("Error closing file " + e.getMessage());
            e.printStackTrace();
        }

        return csvRows;
    }
}
