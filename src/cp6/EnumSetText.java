package cp6;

import java.util.Set;

public class EnumSetText {

    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH,}

    public void applyStyles(Set<Style> styles){
        System.out.println(styles);
    }

}
