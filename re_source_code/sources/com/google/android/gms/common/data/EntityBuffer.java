package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11920g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<Integer> f11921h;

    private final void i() {
        synchronized (this) {
            if (!this.f11920g) {
                int count = this.f11896f.getCount();
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.f11921h = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String strH = h();
                    String strY = this.f11896f.Y(strH, 0, this.f11896f.e0(0));
                    for (int i2 = 1; i2 < count; i2++) {
                        int iE0 = this.f11896f.e0(i2);
                        String strY2 = this.f11896f.Y(strH, i2, iE0);
                        if (strY2 == null) {
                            StringBuilder sb = new StringBuilder(String.valueOf(strH).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(strH);
                            sb.append(", at row: ");
                            sb.append(i2);
                            sb.append(", for window: ");
                            sb.append(iE0);
                            throw new NullPointerException(sb.toString());
                        }
                        if (!strY2.equals(strY)) {
                            this.f11921h.add(Integer.valueOf(i2));
                            strY = strY2;
                        }
                    }
                }
                this.f11920g = true;
            }
        }
    }

    private final int n(int i2) {
        if (i2 >= 0 && i2 < this.f11921h.size()) {
            return this.f11921h.get(i2).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i2);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }

    @KeepForSdk
    protected String f() {
        return null;
    }

    @KeepForSdk
    protected abstract T g(int i2, int i3);

    /* JADX WARN: Code duplicated, block: B:18:0x0066  */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public final T get(int i2) {
        int iIntValue;
        int iIntValue2;
        i();
        int iN = n(i2);
        int i3 = 0;
        if (i2 >= 0 && i2 != this.f11921h.size()) {
            if (i2 == this.f11921h.size() - 1) {
                iIntValue = this.f11896f.getCount();
                iIntValue2 = this.f11921h.get(i2).intValue();
            } else {
                iIntValue = this.f11921h.get(i2 + 1).intValue();
                iIntValue2 = this.f11921h.get(i2).intValue();
            }
            int i4 = iIntValue - iIntValue2;
            if (i4 == 1) {
                int iN2 = n(i2);
                int iE0 = this.f11896f.e0(iN2);
                String strF = f();
                if (strF == null || this.f11896f.Y(strF, iN2, iE0) != null) {
                    i3 = i4;
                }
            } else {
                i3 = i4;
            }
        }
        return g(iN, i3);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        i();
        return this.f11921h.size();
    }

    @KeepForSdk
    protected abstract String h();
}
