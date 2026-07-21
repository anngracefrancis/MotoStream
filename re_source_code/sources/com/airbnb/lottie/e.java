package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import android.util.Log;
import cm.aptoide.pt.utils.MultiDexHelper;
import com.airbnb.lottie.u.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: LottieCompositionFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final Map<String, l<com.airbnb.lottie.d>> a = new HashMap();

    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    static class a implements h<Throwable> {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Throwable th) {
            e.a.remove(this.a);
        }
    }

    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    static class b implements Callable<k<com.airbnb.lottie.d>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f8505f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f8506g;

        b(Context context, String str) {
            this.f8505f = context;
            this.f8506g = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k<com.airbnb.lottie.d> call() {
            return e.e(this.f8505f, this.f8506g);
        }
    }

    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    static class c implements Callable<k<com.airbnb.lottie.d>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f8507f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f8508g;

        c(Context context, int i2) {
            this.f8507f = context;
            this.f8508g = i2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k<com.airbnb.lottie.d> call() {
            return e.k(this.f8507f, this.f8508g);
        }
    }

    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    static class d implements Callable<k<com.airbnb.lottie.d>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ JsonReader f8509f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f8510g;

        d(JsonReader jsonReader, String str) {
            this.f8509f = jsonReader;
            this.f8510g = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k<com.airbnb.lottie.d> call() {
            return e.i(this.f8509f, this.f8510g);
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    static class CallableC0115e implements Callable<k<com.airbnb.lottie.d>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.d f8511f;

        CallableC0115e(com.airbnb.lottie.d dVar) {
            this.f8511f = dVar;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k<com.airbnb.lottie.d> call() {
            Log.d("Gabe", "call\treturning from cache");
            return new k<>(this.f8511f);
        }
    }

    /* JADX INFO: compiled from: LottieCompositionFactory.java */
    static class f implements h<com.airbnb.lottie.d> {
        final /* synthetic */ String a;

        f(String str) {
            this.a = str;
        }

        @Override // com.airbnb.lottie.h
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.airbnb.lottie.d dVar) {
            if (this.a != null) {
                com.airbnb.lottie.s.g.b().c(this.a, dVar);
            }
            e.a.remove(this.a);
        }
    }

    private static l<com.airbnb.lottie.d> b(String str, Callable<k<com.airbnb.lottie.d>> callable) {
        com.airbnb.lottie.d dVarA = com.airbnb.lottie.s.g.b().a(str);
        if (dVarA != null) {
            return new l<>(new CallableC0115e(dVarA));
        }
        Map<String, l<com.airbnb.lottie.d>> map = a;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        l<com.airbnb.lottie.d> lVar = new l<>(callable);
        lVar.h(new f(str));
        lVar.g(new a(str));
        map.put(str, lVar);
        return lVar;
    }

    private static g c(com.airbnb.lottie.d dVar, String str) {
        for (g gVar : dVar.i().values()) {
            if (gVar.b().equals(str)) {
                return gVar;
            }
        }
        return null;
    }

    public static l<com.airbnb.lottie.d> d(Context context, String str) {
        return b(str, new b(context.getApplicationContext(), str));
    }

    public static k<com.airbnb.lottie.d> e(Context context, String str) {
        try {
            String str2 = "asset_" + str;
            return str.endsWith(MultiDexHelper.EXTRACTED_SUFFIX) ? m(new ZipInputStream(context.getAssets().open(str)), str2) : f(context.getAssets().open(str), str2);
        } catch (IOException e2) {
            return new k<>((Throwable) e2);
        }
    }

    public static k<com.airbnb.lottie.d> f(InputStream inputStream, String str) {
        return g(inputStream, str, true);
    }

    private static k<com.airbnb.lottie.d> g(InputStream inputStream, String str, boolean z) {
        try {
            return i(new JsonReader(new InputStreamReader(inputStream)), str);
        } finally {
            if (z) {
                com.airbnb.lottie.v.f.c(inputStream);
            }
        }
    }

    public static l<com.airbnb.lottie.d> h(JsonReader jsonReader, String str) {
        return b(str, new d(jsonReader, str));
    }

    public static k<com.airbnb.lottie.d> i(JsonReader jsonReader, String str) {
        try {
            com.airbnb.lottie.d dVarA = t.a(jsonReader);
            com.airbnb.lottie.s.g.b().c(str, dVarA);
            return new k<>(dVarA);
        } catch (Exception e2) {
            return new k<>((Throwable) e2);
        }
    }

    public static l<com.airbnb.lottie.d> j(Context context, int i2) {
        return b(o(i2), new c(context.getApplicationContext(), i2));
    }

    public static k<com.airbnb.lottie.d> k(Context context, int i2) {
        try {
            return f(context.getResources().openRawResource(i2), o(i2));
        } catch (Resources.NotFoundException e2) {
            return new k<>((Throwable) e2);
        }
    }

    public static l<com.airbnb.lottie.d> l(Context context, String str) {
        return com.airbnb.lottie.t.c.b(context, str);
    }

    public static k<com.airbnb.lottie.d> m(ZipInputStream zipInputStream, String str) {
        try {
            return n(zipInputStream, str);
        } finally {
            com.airbnb.lottie.v.f.c(zipInputStream);
        }
    }

    private static k<com.airbnb.lottie.d> n(ZipInputStream zipInputStream, String str) {
        HashMap map = new HashMap();
        try {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            com.airbnb.lottie.d dVarB = null;
            while (nextEntry != null) {
                if (nextEntry.getName().contains("__MACOSX")) {
                    zipInputStream.closeEntry();
                } else if (nextEntry.getName().contains(".json")) {
                    dVarB = g(zipInputStream, str, false).b();
                } else if (nextEntry.getName().contains(".png")) {
                    String[] strArrSplit = nextEntry.getName().split("/");
                    map.put(strArrSplit[strArrSplit.length - 1], BitmapFactory.decodeStream(zipInputStream));
                } else {
                    zipInputStream.closeEntry();
                }
                nextEntry = zipInputStream.getNextEntry();
            }
            if (dVarB == null) {
                return new k<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
            }
            for (Map.Entry entry : map.entrySet()) {
                g gVarC = c(dVarB, (String) entry.getKey());
                if (gVarC != null) {
                    gVarC.d((Bitmap) entry.getValue());
                }
            }
            for (Map.Entry<String, g> entry2 : dVarB.i().entrySet()) {
                if (entry2.getValue().a() == null) {
                    return new k<>((Throwable) new IllegalStateException("There is no image for " + entry2.getValue().b()));
                }
            }
            com.airbnb.lottie.s.g.b().c(str, dVarB);
            return new k<>(dVarB);
        } catch (IOException e2) {
            return new k<>((Throwable) e2);
        }
    }

    private static String o(int i2) {
        return "rawRes_" + i2;
    }
}
