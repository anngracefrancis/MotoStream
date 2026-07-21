package com.facebook.internal;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FacebookInitProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004JM\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J1\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\b2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/facebook/internal/FacebookInitProvider;", "Landroid/content/ContentProvider;", HttpUrl.FRAGMENT_ENCODE_SET, "onCreate", "()Z", "Landroid/net/Uri;", DeepLinkIntentReceiver.DeepLinksKeys.URI, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "getType", "(Landroid/net/Uri;)Ljava/lang/String;", "Landroid/content/ContentValues;", "values", "insert", "(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;", HttpUrl.FRAGMENT_ENCODE_SET, "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", "f", "a", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class FacebookInitProvider extends ContentProvider {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f9720g = FacebookInitProvider.class.getSimpleName();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        kotlin.jvm.internal.m.f(uri, DeepLinkIntentReceiver.DeepLinksKeys.URI);
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        kotlin.jvm.internal.m.f(uri, DeepLinkIntentReceiver.DeepLinksKeys.URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        kotlin.jvm.internal.m.f(uri, DeepLinkIntentReceiver.DeepLinksKeys.URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            Context context = getContext();
            if (context == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            com.facebook.a0 a0Var = com.facebook.a0.a;
            com.facebook.a0.M(context);
            return false;
        } catch (Exception e2) {
            Log.i(f9720g, "Failed to auto initialize the Facebook SDK", e2);
            return false;
        }
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        kotlin.jvm.internal.m.f(uri, DeepLinkIntentReceiver.DeepLinksKeys.URI);
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        kotlin.jvm.internal.m.f(uri, DeepLinkIntentReceiver.DeepLinksKeys.URI);
        return 0;
    }
}
