package iu9;

import java.io.Serializable;

public class RowSerializable implements Serializable {
    private String[] values;
    private static final long serialVersionUID = 1L;

    private RowSerializable(String[] values) {
        this.values = values;
    }

    public String getValue(int column) {
        return values[column];
    }

    public static RowSerializable parseRow(String row, String del) {
        return new RowSerializable(
                row.substring(1, row.length()-1).split("\""+del+"\"")
        );
    }

    public static RowSerializable parseByRegex(String row, String regex) {
        return new RowSerializable(row.split(regex));
    }
}
