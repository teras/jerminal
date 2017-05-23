/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.panayotis.jerminal;

/**
 *
 * @author teras
 */
class TermUnix {

    private static int width = -1;

    @SuppressWarnings("UseSpecificCatch")
    public synchronized static int width() {
        if (width < 0)
            try {
                width = 80;
                String out = SimpleLaunch.run(null, ProcessBuilder.Redirect.INHERIT, "tput", "cols");
                if (out != null)
                    width = Integer.parseInt(out.trim());
            } catch (Throwable ex) {
            }
        return width;
    }

}
