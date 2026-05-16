package org.finora.dsa;

// Simple dispatcher to run DayNN classes by number or run all days
public class DsaRunner {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java org.finora.dsa.DsaRunner <day|all>\nExample: java org.finora.dsa.DsaRunner 01\n         java org.finora.dsa.DsaRunner all");
            return;
        }

        String target = args[0].trim();
        if ("all".equalsIgnoreCase(target)) {
            for (int i = 1; i <= 30; i++) {
                invokeDay(i);
            }
            return;
        }

        try {
            int day = Integer.parseInt(target);
            invokeDay(day);
        } catch (NumberFormatException ex) {
            // allow zero-padded like "01"
            try {
                int day = Integer.parseInt(target.replaceFirst("^0+", ""));
                invokeDay(day);
            } catch (Exception e) {
                System.err.println("Invalid day: " + target);
            }
        }
    }

    private static void invokeDay(int day) {
        if (day < 1 || day > 30) {
            System.err.println("Day out of range: " + day);
            return;
        }
        String num = String.format("%02d", day);
        String className = "org.finora.dsa.day.Day" + num;
        System.out.println("\n--- Running " + className + " ---");
        try {
            Class<?> cls = Class.forName(className);
            // Prefer run() if available, otherwise call main(String[])
            try {
                java.lang.reflect.Method run = cls.getMethod("run");
                run.invoke(null);
            } catch (NoSuchMethodException nsme) {
                java.lang.reflect.Method main = cls.getMethod("main", String[].class);
                main.invoke(null, (Object) new String[0]);
            }
        } catch (Throwable t) {
            System.err.println("Failed to run " + className + ": " + t);
        }
    }
}

