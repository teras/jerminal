/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panayotis.jerminal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

/**
 *
 * @author teras
 */
public class SimpleLaunch {

    public static String run(String... args) {
        return run(null, null, args);
    }

    @SuppressWarnings("UseSpecificCatch")
    public static String run(Redirect output, Redirect error, String... args) {
        try {
            StringBuilder out = new StringBuilder();
            String line;
            ProcessBuilder pb = new ProcessBuilder(args);
            if (output != null)
                pb.redirectOutput(output);
            if (error != null)
                pb.redirectError(error);

            Process exec = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while ((line = in.readLine()) != null)
                out.append(line).append('\n');
            in.close();

            in = new BufferedReader(new InputStreamReader(exec.getErrorStream()));
            while ((line = in.readLine()) != null)
                out.append(line).append('\n');

            exec.waitFor();
            return out.toString();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            return null;
        }
    }
}
