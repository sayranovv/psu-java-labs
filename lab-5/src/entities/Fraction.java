package entities;

public class Fraction {
    private int numerator;

    private int denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен 0");
        }

        if (denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
    }

    public double getDecimalValue() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Fraction)) {
            return false;
        }

        Fraction other = (Fraction) obj;

        return this.numerator == other.numerator &&
                this.denominator == other.denominator;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(numerator) ^ Integer.hashCode(denominator);
    }
}