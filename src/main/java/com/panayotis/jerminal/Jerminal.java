/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panayotis.jerminal;

import static com.panayotis.jerminal.SystemDependent.isWindows;

/**
 *
 * @author teras
 */
public class Jerminal {

    final static String EmphOn, EmphOff;
    private final int width;

    static {

        if (isWindows)
            EmphOn = EmphOff = "";
        else {
            EmphOn = "\033[0m\033[1m";
            EmphOff = "\033[0m";
        }
    }

    {
        width = isWindows ? TermWindows.width() : TermUnix.width();
    }

    public int getWidth() {
        return width;
    }

    public static void main(String[] args) {
        System.out.println(new Jerminal().width);
    }

}
