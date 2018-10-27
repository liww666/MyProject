package com.sunyard.myproject.reference;

/**
 * Created by Administrator on 2018/9/26.
 */
public class ValueContainer {
    private final String value;
    public ValueContainer(final String value) {
        this.value = value;
    }
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.printf("Finalizing for [%s]%n", toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueContainer that = (ValueContainer) o;

        return !(value != null ? !value.equals(that.value) : that.value != null);

    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}