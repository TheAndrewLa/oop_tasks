package andrewla;

import java.util.ArrayList;

public class TextBuilder implements AbstractOnelineBuilder {

    private final ArrayList<AbstractOnelineBuilder> builders = new ArrayList<>();

    void addTextBlock(TextBlockBuilder textBlock) {
        builders.add(textBlock);
    }

    @Override
    public String build() {

        final StringBuilder stringBuilder = new StringBuilder();

        for (AbstractOnelineBuilder i : builders) {
            stringBuilder.append(i.build());
            stringBuilder.append(' ');
        }

        return stringBuilder.toString();
    }
}
