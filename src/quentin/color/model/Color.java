package quentin.color.model;

public class Color {
    private int red;
    private int green;
    private int blue;
    private String hexValue;
    private static final String HEXA_REGEX_PATTERN = "^#([A-F0-9]{6})$";

    /**
     * Instancie une couleur et intialise sa valeur hexadecimal selon ses valeurs RGB.
     * @param red valeur int du rouge
     * @param green valeur int du vert
     * @param blue valeur int du bleu
     * @throws IllegalArgumentException;
     */
    public Color(int red, int green, int blue){
        if(isCorrectArgumentToSetRGBValues(red) && isCorrectArgumentToSetRGBValues(green) && isCorrectArgumentToSetRGBValues(blue)){
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.hexValue = String.format("#%02X%02X%02X", this.red, this.green, this.blue);
        }
    }

    /**
     * Instancie une couleur et intialise ses valeurs RGB selon sa valeur hexadecimal.
     * @param hexValue valeur String hexadecimal
     * @throws IllegalArgumentException;
     */
    public Color(String hexValue){
        if (isCorrectArgumentToSetHexValue(hexValue)){
            this.hexValue = hexValue;
            convertHexInColor();
        }
    }

    /**
     * Verifie que color est compris entre 0 et 255
     * @param color valeur int de la couleur
     * @throws IllegalArgumentException;
     * @return true si la condition est respectée
     */
    private boolean isCorrectArgumentToSetRGBValues(int color){
        if (!(color >= 0 && color <= 255)){
            throw new IllegalArgumentException("L'argument doit être compris entre 0 et 255 !");
        }
        return true;
    }

    /**
     * Verifie que hexValue n'est pas null et match HEXA_REGEX_PATTERN
     * @param hexValue valeur String hexadecimal
     * @throws IllegalArgumentException;
     * @return true si la condition est respectée
     */
    private boolean isCorrectArgumentToSetHexValue(String hexValue){
        if (hexValue == null || !(hexValue.matches(HEXA_REGEX_PATTERN))){
            throw new IllegalArgumentException("Pas le bon format !");
        }
        return true;
    }

    /**
     * Convertit color au format hexadecimal
     * @param color valeur int de la couleur
     * @return color au format hexadecimal
     */
    private String convertColorInHex(int color){
        return String.format("%02X", color);
    }

    /**
     * Convertit une valeur hexadecimal en trois couleurs RGB
     */
    private void convertHexInColor(){
        this.red = Integer.valueOf(this.hexValue.substring(1, 3), 16);
        this.green = Integer.valueOf(this.hexValue.substring(3, 5), 16);
        this.blue = Integer.valueOf(this.hexValue.substring(5, 7), 16);
    }

    /**
     * Calcule la valeur hexadecimal depuis les valeurs RGB
     * @param colorName nom de la couleur
     * @param colorInt valeur int de la couleur
     */
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
