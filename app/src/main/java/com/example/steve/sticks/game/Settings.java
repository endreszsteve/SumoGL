package com.example.steve.sticks.game;

/**
 * Created by Steve on 2015-05-21.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import com.example.steve.sticks.FileIO;

public class Settings
{
    public static boolean soundenabled = true;
    public static int[] highscores = new int[] { 100, 80, 50, 30, 10};

    public static void load(FileIO files)
    {
        BufferedReader in = null;
        try
        {
            in = new BufferedReader(new InputStreamReader(files.readFile(".sumo")));
            soundenabled = Boolean.parseBoolean(in.readLine());
            for (int i = 0; i < 5; i++)
            {
                highscores[i] = Integer.parseInt(in.readLine());
            }
        } catch (IOException e)
        {
            // :( It's ok we have defaults
        } catch (NumberFormatException e)
        {
            // :/ It's ok, defaults save the day!
        }
        finally
        {
            try
            {
                if (in != null)
                    in.close();
            }catch (IOException e)
            {}
        }
    }

    public static void save(FileIO files)
    {
        BufferedWriter out = null;
        try
        {
            out = new BufferedWriter(new OutputStreamWriter(files.writeFile(".sumo")));
            out.write(Boolean.toString(soundenabled));
            for (int i = 0; i < 5; i++)
            {
                out.write(Integer.toString(highscores[i]));
            }
        } catch (IOException e)
        {}
        finally
        {
            try
            {
                if (out != null)
                    out.close();
            } catch (IOException e)
            {}
        }
    }

    public static void addScore(int score)
    {
        for (int i = 0; i < 5; i++)
        {
            if (highscores[i] < score)
            {
                for (int j = 4; j < i; j--)
                    highscores[j] = highscores[j - 1];
                break;
            }
        }
    }
}
