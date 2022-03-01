package quentin.color.model;

public class Color {
    private int red;
    private int green;
    private int blue;
    private String hexValue;

    public Color(int red, int green, int blue){
        if ( !(red>=0 && red<=255) || !(green>=0 && green<=255) || !(blue>=0 && blue<=255)){
            throw new IllegalArgumentException("Les arguments doivent être compris entre 0 et 255 !");
        }else {
            this.red = red;
            this.green = green;
            this.blue = blue;
            this.hexValue = String.format("#%02X%02X%02X", this.red, this.green, this.blue);
        }
    }

    public Color(String hexValue){
        if ( hexValue == null || !(hexValue.matches("^#([A-F0-9]{6})$"))){
            throw new IllegalArgumentException("Pas le bon format");
        } else {
            this.hexValue = hexValue;
            this.red = Integer.valueOf(hexValue.substring(1,3), 16);
            this.green = Integer.valueOf(hexValue.substring(3,5), 16);
            this.blue = Integer.valueOf(hexValue.substring(5,7),16);
        }
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red){
        if (!(red>=0 && red<=255)){
            throw new IllegalArgumentException("L'argument doit être compris entre 0 et 255 !");
        }else {
            this.red = red;
            String redInHex = String.format("%02X", this.red);
            this.hexValue.replace(this.hexValue.substring(1,3), redInHex);
            this.hexValue = this.hexValue.replace(this.hexValue.substring(1,3), redInHex);
            //this.hexValue = String.format("#%02X%02X%02X", this.red, this.green, this.blue);
        }
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green){
        if ( !(green>=0 && green<=255)){
            throw new IllegalArgumentException("L'argument doit être compris entre 0 et 255 !");
        }else {
            this.green = green;
            String greenInHex = String.format("%02X", this.green);
            this.hexValue.replace(this.hexValue.substring(3,5), greenInHex);
            this.hexValue = this.hexValue.replace(this.hexValue.substring(3,5), greenInHex);
        }
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue){
        if ( !(blue>=0 && blue<=255)){
            throw new IllegalArgumentException("L'argument doit être compris entre 0 et 255 !");
        }else {
            this.blue = blue;
            String blueInHex = String.format("%02X", this.blue);
            this.hexValue.replace(this.hexValue.substring(5,7), blueInHex);
            this.hexValue = this.hexValue.replace(this.hexValue.substring(5,7), blueInHex);
        }
    }

    public String getHexValue() {
        return hexValue;
    }

    public void setHexValue(String hexValue) {
        if (hexValue == null || !(hexValue.matches("^#([A-F0-9]{6})$"))){
            throw new IllegalArgumentException();
        }else {
            this.hexValue = hexValue;
            this.red = Integer.valueOf(hexValue.substring(1, 3), 16);
            this.green = Integer.valueOf(hexValue.substring(3, 5), 16);
            this.blue = Integer.valueOf(hexValue.substring(5, 7), 16);

        }
    }

    @Override
    public String toString() {
        return "[value=" + this.hexValue + ", r=" + this.red + ", g=" + this.green + ", b=" + this.blue + "]";
    }
}
