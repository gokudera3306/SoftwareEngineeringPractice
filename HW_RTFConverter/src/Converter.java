public abstract class Converter {
    private final String character;
    private final String fontChange;
    private final String paragraph;

    protected Converter(String character, String fontChange, String paragraph) {
        this.character = character;
        this.fontChange = fontChange;
        this.paragraph = paragraph;
    }

    public String convert(RTF rtf) throws Exception {
        var result = new StringBuilder();

        for (var c : rtf.text().toCharArray()) {
            result.append(switch (c) {
                case 'C' -> character;
                case 'F' -> fontChange;
                case 'P' -> paragraph;
                default -> throw new Exception();
            });
        }

        return result.toString();
    }
}
