package dsk.redone.view;

import java.io.File;

public class WriteToFile implements UserView {
    @Override
    public void dataOut() {
        File file = new File("dataOut.txt");
    }
}
