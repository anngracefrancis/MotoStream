package com.google.android.gms.common.sqlite;

import android.database.AbstractWindowedCursor;
import android.database.CrossProcessCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class CursorWrapper extends android.database.CursorWrapper implements CrossProcessCursor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AbstractWindowedCursor f12139f;

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public void fillWindow(int i2, CursorWindow cursorWindow) {
        this.f12139f.fillWindow(i2, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    @KeepForSdk
    public CursorWindow getWindow() {
        return this.f12139f.getWindow();
    }

    @Override // android.database.CursorWrapper
    public final /* synthetic */ Cursor getWrappedCursor() {
        return this.f12139f;
    }

    @Override // android.database.CrossProcessCursor
    public final boolean onMove(int i2, int i3) {
        return this.f12139f.onMove(i2, i3);
    }
}
