package aveta;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class Aveta {
    private static final List<String> DEFAULT_UNITS = Arrays.asList("", "K", "M", "B", "T");

    public static String format(double number) {
        return format(number, new Options());
    }

    public static String format(double number, Options options) {
        if (number == 0) return "0";

        int tier = (int) Math.log10(Math.abs(number)) / 3;
        if (tier >= options.units.size()) tier = options.units.size() - 1;

        double scaled = number / Math.pow(1000, tier);
        String unit = options.units.get(tier);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(options.digits);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);

        String result = df.format(scaled);

        if (options.precision > 0) {
            result = String.format("%." + options.precision + "f", scaled);
        }

        if (options.lowercase) {
            unit = unit.toLowerCase();
        }

        String separator = options.separator;
        if (options.space && !unit.isEmpty()) {
            separator = " ";
        }

        return result + separator + unit;
    }

    public static class Options {
        int digits = 1;
        boolean lowercase = false;
        int precision = -1;
        String separator = "";
        boolean space = false;
        List<String> units = DEFAULT_UNITS;

        public Options setDigits(int digits) {
            this.digits = digits;
            return this;
        }

        public Options setLowercase(boolean lowercase) {
            this.lowercase = lowercase;
            return this;
        }

        public Options setPrecision(int precision) {
            this.precision = precision;
            return this;
        }

        public Options setSeparator(String separator) {
            this.separator = separator;
            return this;
        }

        public Options setSpace(boolean space) {
            this.space = space;
            return this;
        }

        public Options setUnits(List<String> units) {
            this.units = units;
            return this;
        }
    }
    public static void main(String[] args) {
        System.out.println(Aveta.format(8700));

        System.out.println(Aveta.format(123456, new Aveta.Options()
                .setDigits(3)
                .setLowercase(true)));

        System.out.println(Aveta.format(4567, new Aveta.Options()
                .setDigits(3)
                .setLowercase(true)));

        System.out.println(Aveta.format(2048000, new Aveta.Options()
                .setPrecision(2)
                .setLowercase(true)));

        System.out.println(Aveta.format(45500, new Aveta.Options()
                .setPrecision(3)
                .setSeparator(",")));

        System.out.println(Aveta.format(1440000, new Aveta.Options()
                .setUnits(Arrays.asList("B", "KB", "MB", "GB", "TB"))
                .setSpace(true))); 
    }
}