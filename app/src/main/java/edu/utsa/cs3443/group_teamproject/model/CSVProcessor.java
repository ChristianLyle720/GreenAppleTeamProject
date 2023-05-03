package edu.utsa.cs3443.group_teamproject.model;

import android.content.Context;
import android.content.res.AssetManager;
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
            InputStream inputStream = context.getAssets().open(assetFileName);
            OutputStream outputStream = context.openFileOutput(privateFileName, Context.MODE_PRIVATE);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

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
     * Removes a question from the CSV file by the answer.
     *
     * @param target  the answer of the question to be removed
     * @param fileName the name of the CSV file
     * @param context the application context
     */
    public static void removeQuestion(String target, String fileName, Context context) {
        List<String> lines = new ArrayList<>();

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

        boolean lineRemoved = false;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(target)) {
                lines.remove(i);
                lineRemoved = true;
                break;
            }
        }

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
     * Adds a new question to the CSV file.
     *
     * @param question the question text
     * @param answer   the answer text
     * @param setGroup the name of the question set
     * @param context  the application context
     */
    public static void addQuestion(String question, String answer, String setGroup, Context context) {
        String newLine = question + "," + answer + "," + setGroup;

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("questions.csv", Context.MODE_APPEND));
            BufferedWriter bw = new BufferedWriter(outputStreamWriter);

            bw.newLine();
            bw.write(newLine);
            Log.i("INFO", "Added LINE!");
            bw.close();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Edits an existing question in the CSV file.
     *
     * @param targetQuestion the text of the question to be replaced
     * @param newQuestion    the new question text
     * @param newAnswer      the new answer text
     * @param setName        the name of the question set
     * @param context        the application context
     */
    public static void editQuestion(String targetQuestion, String newQuestion, String newAnswer, String setName, Context context) {
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

        boolean questionReplaced = false;
        for (int i = 0; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts[0].equals(targetQuestion) && parts[2].equals(setName)) {
                lines.set(i, newQuestion + "," + newAnswer + "," + setName);
                questionReplaced = true;
                break;
            }
        }

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
