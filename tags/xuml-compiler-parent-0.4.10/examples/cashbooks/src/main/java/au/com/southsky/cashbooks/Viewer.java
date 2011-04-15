package au.com.southsky.cashbooks;

import moten.david.xuml.model.viewer.ViewerUtil;
import au.com.southsky.cashbooks.CashbookSystem;

public class Viewer {

        public static void main(String[] args) throws Exception {
                ViewerUtil.view("src/viewer", CashbookSystem.class);
        }
}
