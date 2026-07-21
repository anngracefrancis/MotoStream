package com.facebook.r0.a;

import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.e0;
import com.facebook.internal.p0;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ShareInternalUtility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static final a a = new a();

    private a() {
    }

    public static final GraphRequest a(AccessToken accessToken, Uri uri, GraphRequest.b bVar) throws FileNotFoundException {
        m.f(uri, "imageUri");
        String path = uri.getPath();
        p0 p0Var = p0.a;
        if (p0.Y(uri) && path != null) {
            return b(accessToken, new File(path), bVar);
        }
        if (!p0.V(uri)) {
            throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
        }
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(uri, "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, "me/staging_resources", bundle, e0.POST, bVar, null, 32, null);
    }

    public static final GraphRequest b(AccessToken accessToken, File file, GraphRequest.b bVar) throws FileNotFoundException {
        GraphRequest.ParcelableResourceWithMimeType parcelableResourceWithMimeType = new GraphRequest.ParcelableResourceWithMimeType(ParcelFileDescriptor.open(file, 268435456), "image/png");
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("file", parcelableResourceWithMimeType);
        return new GraphRequest(accessToken, "me/staging_resources", bundle, e0.POST, bVar, null, 32, null);
    }
}
