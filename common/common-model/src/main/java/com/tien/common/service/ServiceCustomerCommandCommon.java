package com.tien.common.service;

public interface ServiceCustomerCommandCommon<Tdto, Tcreaterequest, Tupdaterequest, Iid> {
    Tdto create(Tcreaterequest request);

    Tdto update(Tupdaterequest request, Iid id);

    void inActive(Iid id);

    void active(Iid id);
}
