package quentin.color.model;

public class Color {
    private int red;
    private int green;
    private int blue;
    private String hexValue;
    private static final String HEXA_REGEX_PATTERN = "^#([A-F0-9]{6})$";

    public Color(int red, int green, int blue){
        if(isCorrectArgumentToSetRGBValues(red) && isCorrectArgumentToSetRGBValues(green) && isCorrectArgumentToSetRGBValues(blue)){
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.hexValue = String.format("#%02X%02X%02X", this.red, this.green, this.blue);
        }
    }

    public Color(String hexValue){
        if (isCorrectArgumentToSetHexValue(hexValue)){
            this.hexValue = hexValue;
            convertHexInColor();
        }
    }

    private boolean isCorrectArgumentToSetRGBValues(int color){
        if (!(color >= 0 && color <= 255)){
            throw new IllegalArgumentException("L'argument doit être compris entre 0 et 255 !");
        }
        return true;
    }

    private boolean isCorrectArgumentToSetHexValue(String hexValue){
        if (hexValue == null || !(hexValue.matches(HEXA_REGEX_PATTERN))){
            throw new IllegalArgumentException("Pas le bon format !");
        }
        return true;
    }

    private String convertColorInHex(int color){
        return String.format("%02X", color);
    }

    private void convertHexInColor(){
        this.red = Integer.valueOf(this.hexValue.substring(1, 3), 16);
        this.green = Integer.valueOf(this.hexValue.substring(3, 5), 16);
        this.blue = Integer.valueOf(this.hexValue.substring(5, 7), 16);
    }

    private void calculateHexValueFromRGBValues(String colorName, int colorInt){
        String hexValue = convertColorInHex(colorInt);
        switch (colorName){
            case "red":
                this.hexValue = this.hexValue.replace(this.hexValue.substring(1,3), hexValue);
                break;
            case "green":
                this.hexValue = this.hexValue.replace(this.hexValue.substring(3,5), hexValue);
                break;
            case "blue" :
                this.hexValue = this.hexValue.replace(this.hexValue.substring(5,7), hexValue);
                break;
        }
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red){
        if(isCorrectArgumentToSetRGBValues(red)) {
            this.red = red;
            calculateHexValueFromRGBValues("red",red);
        }
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green){
        if(isCorrectArgumentToSetRGBValues(green)){
            this.green = green;
            calculateHexValueFromRGBValues("green",green);
        }
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue){
        if (isCorrectArgumentToSetRGBValues(blue)){
            this.blue = blue;
            calculateHexValueFromRGBValues("blue",blue);
        }
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        if (isCorrectArgumentToSetHexValue(hexValue)){
            this.hexValue = hexValue;
            convertHexInColor();
        }
    }

    @Override
    public String toString() {
        return "[value=" + this.hexValue + ", r=" + this.red + ", g=" + this.green + ", b=" + this.blue + "]";
    }
}
