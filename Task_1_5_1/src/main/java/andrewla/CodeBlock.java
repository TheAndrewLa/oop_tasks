package andrewla;

public class CodeBlock implements AbstractMultilineBuilder {

    private final String content;
    private final String language;

    public CodeBlock(String code, CodeLanguage language) {
        content = code;

        switch (language) {
            case Python: {
                this.language = "python";
            }
            break;

            case C: {
                this.language = "c";
            }
            break;

            case Cpp: {
                this.language = "cpp";
            }
            break;

            case Java: {
                this.language = "java";
            }
            break;

            default: {
                throw new RuntimeException("Unknown enum value!");
            }
        }
    }

    @Override
    public String[] build() {
        /*
        TODO: here's a sample

        ```python
          a = int(input())
          print(a)
        ```
         */
    }
}
