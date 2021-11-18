package iu9;

import java.io.Serializable;

public class TableSerializable implements Serializable {

    private RowSerializable(String[] )

    public static RowSerializable parseRow(String row, String del) {
        return new TableSerializable(
                row.substring(1, row.length()-1).split("\""+del+"\"")
        );
    }
}
