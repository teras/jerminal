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
class SystemDependent {

    static final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    static final String arch = System.getProperty("os.arch").contains("64") ? "64" : "32";

}
