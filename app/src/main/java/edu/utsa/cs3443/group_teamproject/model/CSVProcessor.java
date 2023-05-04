package edu.utsa.cs3443.group_teamproject.model;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
/**
 * CSVProcessor is a utility class for processing CSV files.
 */
public class CSVProcessor {

    /**
     * Copies an asset file to the private storage.
     *
     * @param context         the application context
     * @param assetFileName   the name of the asset file
     * @param privateFileName the name of the target private file
     */
    public static void copyAssetToFile(Context context, String assetFileName, String privateFileName) {
        try {
            // Open the input stream for the asset file
            InputStream inputStream = context.getAssets().open(assetFileName);

            // Open the output stream for the destination file in the private file directory
            OutputStream outputStream = context.openFileOutput(privateFileName, Context.MODE_PRIVATE);

            // Buffer for transferring data between streams
            byte[] buffer = new byte[1024];
            int bytesRead;

            // Read data from the input stream and write it to the output stream
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Close the input and output streams
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if a file exists.
     *
     * @param filePath the path to the file
     * @return true if the file exists, false otherwise
     */
    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    /**
     * Removes a question from a CSV file based on the target string.
     *
     * @param target  the target string to search for in the file's lines
     * @param fileName the name of the file to remove the question from
     * @param context the application context, used for accessing the file system
     */
    public static void removeQuestion(String target, String fileName, Context context) {
        // Create a list to store the lines from the file
        List<String> lines = new ArrayList<>();

        // Read the lines from the file
        try {
            InputStream inputStream = context.openFileInput(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            br.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove the line containing the target string
        boolean lineRemoved = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(target)) {
                lines.remove(i);
                lineRemoved = true;
                break;
            }
        }

        // Move all the questions up under the removed line to fill the gap
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("questions.csv", Context.MODE_PRIVATE));
            BufferedWriter bw = new BufferedWriter(outputStreamWriter);

            for (int i = 0; i < lines.size(); i++) {
                bw.write(lines.get(i));
                if (i < lines.size() - 1) {
                    bw.newLine();
                }
            }

            bw.close();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Adds a new question to a CSV file.
     *
     * @param question the question text
     * @param answer   the answer text
     * @param setGroup the group name the question belongs to
     * @param context  the application context, used for accessing the file system
     */
    public static void addQuestion(String question, String answer, String setGroup, Context context) {
        // Create a new line for the question, answer, and setGroup
        String newLine = question + "," + answer + "," + setGroup;

        // Open the file in append mode and write the new line to the file
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("questions.csv", Context.MODE_APPEND));
            BufferedWriter bw = new BufferedWriter(outputStreamWriter);

            // Add a newline before writing the new question to avoid appending to the last line
            bw.newLine();
            bw.write(newLine);

            // Log the addition of the new line
            Log.i("INFO", "Added LINE!");

            // Close the BufferedWriter and OutputStreamWriter
            bw.close();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Edits an existing question in a CSV file.
     *
     * @param targetQuestion the original question text
     * @param newQuestion    the new question text
     * @param newAnswer      the new answer text
     * @param setName        the group name the question belongs to
     * @param context        the application context, used for accessing the file system
     */
    public static void editQuestion(String targetQuestion, String newQuestion, String newAnswer, String setName, Context context) {
        // Read the contents of the file into a List of lines
        List<String> lines = new ArrayList<>();
        try {
            InputStream inputStream = context.openFileInput("questions.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            br.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Replace the target question with the new question and answer
        boolean questionReplaced = false;
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts[0].equals(targetQuestion) && parts[2].equals(setName)) {
                lines.set(i, newQuestion + "," + newAnswer + "," + setName);
                questionReplaced = true;
                break;
            }
        }

        // If the question was replaced, write the modified contents back to the file
        if (questionReplaced) {
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("questions.csv", Context.MODE_PRIVATE));
                BufferedWriter bw = new BufferedWriter(outputStreamWriter);

                for (int i = 0; i < lines.size(); i++) {
                    bw.write(lines.get(i));
                    if (i < lines.size() - 1) {
                        bw.newLine();
                    }
                }

                bw.close();
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
