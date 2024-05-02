import java.awt.*;
import java.io.File;
import java.io.IOException;
public class FontLoader {
    private static Font customFont;

    public static Font loadFont(String filename, int style, float size){
        if(customFont == null){
            try {
                File fontFile = new File(filename);
                customFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            } catch(IOException | FontFormatException e){
                e.printStackTrace();
                return null;
            }
        }
        return customFont.deriveFont(style,size);
    }
}