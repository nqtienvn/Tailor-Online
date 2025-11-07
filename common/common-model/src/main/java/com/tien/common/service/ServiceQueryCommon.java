package com.tien.common.service;

public interface ServiceQueryCommon<T, F> {
    T search(F request);
}
