package com.bumptech.glide.load.o.e;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.j;
import java.util.List;

/* JADX INFO: compiled from: ResourceDrawableDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements j<Uri, Drawable> {
    private final Context a;

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        if (str.equals(this.a.getPackageName())) {
            return this.a;
        }
        try {
            return this.a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            if (str.contains(this.a.getPackageName())) {
                return this.a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e2) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e2);
        }
    }

    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public u<Drawable> b(Uri uri, int i2, int i3, i iVar) {
        Context contextD = d(uri, uri.getAuthority());
        return d.f(a.b(this.a, contextD, g(contextD, uri)));
    }

    @Override // com.bumptech.glide.load.j
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri, i iVar) {
        return uri.getScheme().equals("android.resource");
    }
}
