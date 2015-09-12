package com.ground.java8;

import java.util.Collection;
import java.util.stream.Stream;

public abstract class MyOptimizedCollection<E> implements Collection<E>{
    private enum OperatingSystem{
        LINUX, WINDOWS, ANDROID
    }
    private OperatingSystem operatingSystem = OperatingSystem.WINDOWS;
    private int numberOfCores = Runtime.getRuntime().availableProcessors();
    private Collection<E> delegate;

    @Override
    public Stream<E> parallelStream() {
        if (!System.getProperty("parallelSupport").equals("true")) {
            return this.delegate.stream();
        }
        switch (operatingSystem) {
            case WINDOWS:
                if (numberOfCores > 3 && delegate.size() > 10000) {
                    return this.delegate.parallelStream();
                }else{
                    return this.delegate.stream();
                }
            case LINUX:
               // return SomeVerySpecialStreamImplementation.stream(this.delegate.spliterator());
            case ANDROID:
            default:
                return this.delegate.stream();
        }
    }
}