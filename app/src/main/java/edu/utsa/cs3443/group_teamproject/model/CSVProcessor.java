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

public class CSVProcessor {

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

    public static boolean fileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }


    public static void remove(String target, String fileName, Context context) {
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


}
