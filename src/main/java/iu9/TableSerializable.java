package iu9;

import java.io.Serializable;

public class RowSerializable implements Serializable {
    private String[] values;

    private RowSerializable(String[] values) {
        this.values = values;
    }

    public static RowSerializable parseRow(String row, String del) {
        return new RowSerializable(
                row.substring(1, row.length()-1).split("\""+del+"\"")
        );
    }
}
