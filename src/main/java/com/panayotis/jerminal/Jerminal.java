/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panayotis.jerminal;

import static com.panayotis.jerminal.SystemDependent.isWindows;

/**
 * @author teras
 */
public class Jerminal {

    final static String EmphOn, EmphOff;
    private static int width = -1;

    static {
        if (isWindows)
            EmphOn = EmphOff = "";
        else {
            EmphOn = "\033[0m\033[1m";
            EmphOff = "\033[0m";
        }
    }

    public static int getWidth() {
        if (width < 0)
            width = isWindows ? TermWindows.width() : TermUnix.width();
        return width;
    }
}
