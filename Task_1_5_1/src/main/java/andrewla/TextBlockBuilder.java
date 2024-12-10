package andrewla;

import java.util.ArrayList;
import java.util.HashMap;

public class TextBlockBuilder implements AbstractOnelineBuilder {

    public static class Bold extends TextBlockBuilder {

        public Bold(String string) {
            super(string);
            addFormatting(TextFormat.Bold);
        }
    }

    public static class Italic extends TextBlockBuilder {

        public Italic(String string) {
            super(string);
            addFormatting(TextFormat.Italic);
        }
    }

    public static class Strikethrough extends TextBlockBuilder {

        public Strikethrough(String string) {
            super(string);
            addFormatting(TextFormat.Strikethrough);
        }
    }

    public static class Code extends TextBlockBuilder {

        public Code(String string) {
            super(string);
            addFormatting(TextFormat.Code);
        }
    }

    protected final StringBuilder builder;
    protected final ArrayList<TextFormat> formats;

    protected final HashMap<TextFormat, String> formatsPatterns;

    public TextBlockBuilder(String string) {
        builder = new StringBuilder(string);
        formats = new ArrayList<>();

        formatsPatterns = new HashMap<>();
        formatsPatterns.put(TextFormat.Bold, "**");
        formatsPatterns.put(TextFormat.Italic, "_");
        formatsPatterns.put(TextFormat.Strikethrough, "~~");
        formatsPatterns.put(TextFormat.Code, "`");
    }

    public void addFormatting(TextFormat format) {
        // TODO: maybe somehow optimize process of applying multiple format specifiers

        if (formats.contains(format)) {
            throw new IllegalArgumentException("Format already applied!");
        }

        formats.add(format);
    }

    @Override
    public String build() {

        for (TextFormat i : formats) {
            String pattern = formatsPatterns.get(i);
            builder.insert(0, pattern);
            builder.append(pattern);
        }

        return builder.toString();
    }
}
