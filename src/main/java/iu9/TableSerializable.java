package iu9;

import java.io.Serializable;

public class TableSerializable implements Serializable {
    public static TableSerializable parseRow(String row, String del) {
        return new TableSerializable(
                row.replaceAll("\"", "")
                        .replaceAll("")
                        .split()
        )
    }
}
