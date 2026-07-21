package com.airbnb.epoxy;

import com.airbnb.epoxy.q;
import java.util.List;

/* JADX INFO: compiled from: EpoxyModelWithHolder.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class t<T extends q> extends s<T> {
    public t() {
    }

    protected abstract T createNewHolder();

    public t(long j2) {
        super(j2);
    }

    @Override // com.airbnb.epoxy.s
    public /* bridge */ /* synthetic */ void bind(Object obj, s sVar) {
        bind((q) obj, (s<?>) sVar);
    }

    @Override // com.airbnb.epoxy.s
    public boolean onFailedToRecycleView(T t) {
        return super.onFailedToRecycleView(t);
    }

    @Override // com.airbnb.epoxy.s
    public void onViewAttachedToWindow(T t) {
        super.onViewAttachedToWindow(t);
    }

    @Override // com.airbnb.epoxy.s
    public void onViewDetachedFromWindow(T t) {
        super.onViewDetachedFromWindow(t);
    }

    @Override // com.airbnb.epoxy.s
    public void onVisibilityChanged(float f2, float f3, int i2, int i3, T t) {
        super.onVisibilityChanged(f2, f3, i2, i3, t);
    }

    @Override // com.airbnb.epoxy.s
    public void onVisibilityStateChanged(int i2, T t) {
        super.onVisibilityStateChanged(i2, t);
    }

    @Override // com.airbnb.epoxy.s
    public void unbind(T t) {
        super.unbind(t);
    }

    @Override // com.airbnb.epoxy.s
    public /* bridge */ /* synthetic */ void bind(Object obj, List list) {
        bind((q) obj, (List<Object>) list);
    }

    @Override // com.airbnb.epoxy.s
    public void bind(T t) {
        super.bind(t);
    }

    public void bind(T t, List<Object> list) {
        super.bind(t, list);
    }

    public void bind(T t, s<?> sVar) {
        super.bind(t, sVar);
    }
}
