package com.airbnb.epoxy;

import com.airbnb.epoxy.n;
import java.util.List;

/* JADX INFO: compiled from: ControllerHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f<T extends n> {
    public abstract void resetAutoModels();

    protected void setControllerToStageTo(s<?> sVar, T t) {
        sVar.controllerToStageTo = t;
    }

    protected void validateModelHashCodesHaveNotChanged(T t) {
        List<s<?>> listD = t.getAdapter().D();
        for (int i2 = 0; i2 < listD.size(); i2++) {
            listD.get(i2).validateStateHasNotChangedSinceAdded("Model has changed since it was added to the controller.", i2);
        }
    }
}
