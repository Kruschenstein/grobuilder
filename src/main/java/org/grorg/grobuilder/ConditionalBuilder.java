package org.grorg.grobuilder;

import org.mockito.Answers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.*;

public abstract class ConditionalBuilder<T extends ConditionalBuilder<T, U>, U> {
    private T trueImplementation;
    private T mockedImplementation;

    ConditionalBuilder() {
        mockedImplementation = (T) mock(self().getClass(), Answers.RETURNS_SELF);
        when(mockedImplementation.build()).then(arg -> trueImplementation.build());
        when(mockedImplementation.onCondition(anyBoolean())).thenCallRealMethod();
        when(mockedImplementation.getTrueImplementation()).thenCallRealMethod();
        doCallRealMethod().when(mockedImplementation).setTrueImplementation(any());
        when(mockedImplementation.self()).thenReturn(mockedImplementation);
        mockedImplementation.setTrueImplementation(self());
        setTrueImplementation(self());
    }

    public T onCondition(boolean condition) {
        if (condition) {
            return getTrueImplementation() == null ? self() : getTrueImplementation();
        }

        return mockedImplementation;
    }

    protected abstract T self();

    public abstract U build();

    T getTrueImplementation() {
        return trueImplementation;
    }

    void setTrueImplementation(T trueImplementation) {
        this.trueImplementation = trueImplementation;
    }
}
