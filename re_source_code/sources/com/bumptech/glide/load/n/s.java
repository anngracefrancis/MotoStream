package com.bumptech.glide.load.n;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;

/* JADX INFO: compiled from: ResourceLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {
    private final n<Uri, Data> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f9342b;

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static final class a implements o<Integer, AssetFileDescriptor> {
        private final Resources a;

        public a(Resources resources) {
            this.a = resources;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Integer, AssetFileDescriptor> b(r rVar) {
            return new s(this.a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class b implements o<Integer, ParcelFileDescriptor> {
        private final Resources a;

        public b(Resources resources) {
            this.a = resources;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Integer, ParcelFileDescriptor> b(r rVar) {
            return new s(this.a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class c implements o<Integer, InputStream> {
        private final Resources a;

        public c(Resources resources) {
            this.a = resources;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Integer, InputStream> b(r rVar) {
            return new s(this.a, rVar.d(Uri.class, InputStream.class));
        }
    }

    /* JADX INFO: compiled from: ResourceLoader.java */
    public static class d implements o<Integer, Uri> {
        private final Resources a;

        public d(Resources resources) {
            this.a = resources;
        }

        @Override // com.bumptech.glide.load.n.o
        public n<Integer, Uri> b(r rVar) {
            return new s(this.a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f9342b = resources;
        this.a = nVar;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f9342b.getResourcePackageName(num.intValue()) + '/' + this.f9342b.getResourceTypeName(num.intValue()) + '/' + this.f9342b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(Integer num, int i2, int i3, com.bumptech.glide.load.i iVar) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.a.b(uriD, i2, i3, iVar);
    }

    @Override // com.bumptech.glide.load.n.n
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }
}
