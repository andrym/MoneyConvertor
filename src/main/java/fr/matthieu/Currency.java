package fr.matthieu;

public enum Currency {
    Dollar("\u0024", 1.18),
    Euro("\u20AC", 1.00),
    Pound("\u00A3", 0.86),
    Yen("\u00A5", 129.21);

    private String symbol;
    private double convertValue;
    
    Currency(String symbol, double convertValue) {
        this.symbol = symbol;
        this.convertValue = convertValue;
    }

    public String getSymbol() {
        return this.symbol;
    }
    
    public Double getConvertValue() {
        return this.convertValue;
    }    
    // private Map<String, String> convertsymbol = Map.of("Dollar", "$", "Euro", "€", "Pound", "£", "Yen", "¥");
    // private Map<String, Double> convertValues = Map.of("Dollar", 1.18, "Euro", 1.00, "Pound", 0.86, "Yen", 129.81);
}
