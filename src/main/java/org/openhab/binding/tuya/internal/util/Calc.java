/**
 * Copyright (c) 2010-2018 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.tuya.internal.util;

import org.eclipse.smarthome.core.types.Command;

/**
 * Helper class for channel calculations.
 *
 * @author Wim Vissers.
 *
 */
public class Calc {

    /**
     * Never instantiated.
     */
    private Calc() {
    }

    /**
     * Take an OH command, and try to calculate the value as and integer
     * from 0 to 255. This is used to convert dimmer commands to the 0..255 value used by the Tuya devices.
     *
     * @param command the OH command.
     * @return the numeric value in the range 0..255.
     */
    public static int numberTo255(Command command) {
        if (command instanceof Number) {
            return (int) ((Math.round(((Number) (command)).doubleValue() * 255)) & 0xFF);
        } else {
            throw new IllegalArgumentException("Command could not be converted to int.");
        }
    }

}
