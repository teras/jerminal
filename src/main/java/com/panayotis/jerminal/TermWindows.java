/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panayotis.jerminal;

import static java.lang.ProcessBuilder.Redirect.*;

/**
 *
 * @author teras
 */
class TermWindows {

    private static int width = -1;

    public synchronized static int width() {
        if (width < 0) {
            String res = SimpleLaunch.run(null, INHERIT, "cmd.exe", "/c", "mode con");
            if (res != null) {
                String[] s = res.split("\\r?\\n");
                try {
                    int delta = (s[0].trim().isEmpty()) ? 1 : 0;
                    if (s[1 + delta].contains("---"))
                        width = Integer.parseInt(s[3 + delta].substring(s[3 + delta].indexOf(':') + 1).trim());
                } catch (Exception e) {
                    width = 80;
                }
            }
        }
        return width;
    }

}
