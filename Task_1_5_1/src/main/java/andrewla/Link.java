package andrewla;

public class Link implements AbstractOnelineBuilder {

    private final AbstractOnelineBuilder text;
    private final String link;

    Link(String link, TextBlockBuilder textBuilder) {
        this.text = textBuilder;

        // TODO: ensure that link is actually link
        this.link = link;
    }

    @Override
    public String build() {
        return "[" + text.build() + "]" + "(" + link + ")";
    }
}
