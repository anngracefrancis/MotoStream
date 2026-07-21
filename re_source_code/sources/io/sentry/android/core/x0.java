package io.sentry.android.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: EmptySecureContentProvider.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
abstract class x0 extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final io.sentry.android.core.internal.util.l f22277f = new io.sentry.android.core.internal.util.l();

    x0() {
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        this.f22277f.a(this);
        return 0;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        this.f22277f.a(this);
        return null;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        this.f22277f.a(this);
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        this.f22277f.a(this);
        return 0;
    }
}
