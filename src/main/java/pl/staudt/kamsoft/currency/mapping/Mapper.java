package pl.staudt.kamsoft.currency.mapping;

public interface Mapper<S, T> {

    T convert(S source);

}
