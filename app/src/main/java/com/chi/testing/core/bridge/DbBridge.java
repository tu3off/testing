package com.chi.testing.core.bridge;

import com.chi.testing.model.Test;

public interface DbBridge {
    long insert(Test object);

    Test select();
}
