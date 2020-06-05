package com.Kotori.Protocol;

import java.io.IOException;
import java.io.OutputStream;

public class Protocol {
    private static String DOLLAR_BYTE = "$";
    private static String ASTERISK_BYTE = "*";
    private static String BLANK_BYTE = "\r\n";


    public static void sendCommand(OutputStream outputStream, Protocol.COMMAND command, byte[]... b) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ASTERISK_BYTE).append(b.length+1).append(BLANK_BYTE);
        stringBuffer.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_BYTE);
        stringBuffer.append(command).append(BLANK_BYTE);

        for (byte[] args : b) {
            stringBuffer.append(DOLLAR_BYTE).append(args.length).append(BLANK_BYTE);
            stringBuffer.append(new String(args)).append(BLANK_BYTE);
        }

        try {
            outputStream.write(stringBuffer.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static enum COMMAND {
        SET,
        GET
    }

}
