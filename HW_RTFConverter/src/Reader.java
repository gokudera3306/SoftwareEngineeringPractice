public class Reader {
    private Converter converter = new TeXConverter();

    public void setConverter(String type) throws Exception {
        this.converter = switch (type) {
            case "TeX" -> new TeXConverter();
            case "TextWidget" -> new TextWidgetConverter();
            default -> throw new Exception();
        };
    }

    public void convert(String text) throws Exception {
        var rtf = new RTF(text);

        var result = converter.convert(rtf);

        System.out.println(result);
    }
}
