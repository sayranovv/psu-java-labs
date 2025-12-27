package entities;

public class FractionCached extends Fraction {
    private Double cachedValue;

    private boolean isCacheValid;

    public FractionCached() {
        super();
        initializeCache();
    }

    public FractionCached(int numerator, int denominator) {
        super(numerator, denominator);
        initializeCache();
    }

    private void initializeCache() {
        this.cachedValue = null;
        this.isCacheValid = false;
    }

    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        isCacheValid = false;
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        isCacheValid = false;
    }

    @Override
    public double getDecimalValue() {
        if (!isCacheValid) {
            cachedValue = super.getDecimalValue();
            isCacheValid = true;
        }

        return cachedValue;
    }
}