package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.n.s;
import com.bumptech.glide.load.n.t;
import com.bumptech.glide.load.n.u;
import com.bumptech.glide.load.n.w;
import com.bumptech.glide.load.o.c.o;
import com.bumptech.glide.load.o.c.v;
import com.bumptech.glide.load.o.c.x;
import com.bumptech.glide.load.o.c.y;
import com.bumptech.glide.m.l;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Glide.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile c f8915f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f8916g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final k f8917h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f8918i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a0.h f8919j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.c0.a f8920k;
    private final e l;
    private final Registry m;
    private final com.bumptech.glide.load.engine.z.b n;
    private final l o;
    private final com.bumptech.glide.m.d p;
    private final List<i> q = new ArrayList();
    private f r = f.NORMAL;

    c(Context context, k kVar, com.bumptech.glide.load.engine.a0.h hVar, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar, l lVar, com.bumptech.glide.m.d dVar, int i2, com.bumptech.glide.p.h hVar2, Map<Class<?>, j<?, ?>> map, List<com.bumptech.glide.p.g<Object>> list, boolean z) {
        this.f8917h = kVar;
        this.f8918i = eVar;
        this.n = bVar;
        this.f8919j = hVar;
        this.o = lVar;
        this.p = dVar;
        this.f8920k = new com.bumptech.glide.load.engine.c0.a(hVar, eVar, (com.bumptech.glide.load.b) hVar2.r().a(com.bumptech.glide.load.o.c.l.a));
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.m = registry;
        registry.o(new com.bumptech.glide.load.o.c.j());
        if (Build.VERSION.SDK_INT >= 27) {
            registry.o(new o());
        }
        List<ImageHeaderParser> listG = registry.g();
        com.bumptech.glide.load.o.c.l lVar2 = new com.bumptech.glide.load.o.c.l(listG, resources.getDisplayMetrics(), eVar, bVar);
        com.bumptech.glide.load.o.g.a aVar = new com.bumptech.glide.load.o.g.a(context, listG, eVar, bVar);
        com.bumptech.glide.load.j<ParcelFileDescriptor, Bitmap> jVarG = y.g(eVar);
        com.bumptech.glide.load.o.c.f fVar = new com.bumptech.glide.load.o.c.f(lVar2);
        v vVar = new v(lVar2, bVar);
        com.bumptech.glide.load.o.e.e eVar2 = new com.bumptech.glide.load.o.e.e(context);
        s.c cVar = new s.c(resources);
        s.d dVar2 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        com.bumptech.glide.load.o.c.c cVar2 = new com.bumptech.glide.load.o.c.c(bVar);
        com.bumptech.glide.load.o.h.a aVar3 = new com.bumptech.glide.load.o.h.a();
        com.bumptech.glide.load.o.h.d dVar3 = new com.bumptech.glide.load.o.h.d();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registryP = registry.a(ByteBuffer.class, new com.bumptech.glide.load.n.c()).a(InputStream.class, new t(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, fVar).e("Bitmap", InputStream.class, Bitmap.class, vVar).e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, jVarG).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, y.c(eVar)).d(Bitmap.class, Bitmap.class, com.bumptech.glide.load.n.v.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new x()).b(Bitmap.class, cVar2).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.o.c.a(resources, fVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.o.c.a(resources, vVar)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.o.c.a(resources, jVarG)).b(BitmapDrawable.class, new com.bumptech.glide.load.o.c.b(eVar, cVar2)).e("Gif", InputStream.class, com.bumptech.glide.load.o.g.c.class, new com.bumptech.glide.load.o.g.j(listG, aVar, bVar)).e("Gif", ByteBuffer.class, com.bumptech.glide.load.o.g.c.class, aVar).b(com.bumptech.glide.load.o.g.c.class, new com.bumptech.glide.load.o.g.d()).d(com.bumptech.glide.l.a.class, com.bumptech.glide.l.a.class, com.bumptech.glide.load.n.v.a.a()).e("Bitmap", com.bumptech.glide.l.a.class, Bitmap.class, new com.bumptech.glide.load.o.g.h(eVar)).c(Uri.class, Drawable.class, eVar2).c(Uri.class, Bitmap.class, new com.bumptech.glide.load.o.c.t(eVar2, eVar)).p(new com.bumptech.glide.load.o.d.a.C0137a()).d(File.class, ByteBuffer.class, new com.bumptech.glide.load.n.d.b()).d(File.class, InputStream.class, new com.bumptech.glide.load.n.f.e()).c(File.class, File.class, new com.bumptech.glide.load.o.f.a()).d(File.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.n.f.b()).d(File.class, File.class, com.bumptech.glide.load.n.v.a.a()).p(new com.bumptech.glide.load.m.k.a(bVar));
        Class cls = Integer.TYPE;
        registryP.d(cls, InputStream.class, cVar).d(cls, ParcelFileDescriptor.class, bVar2).d(Integer.class, InputStream.class, cVar).d(Integer.class, ParcelFileDescriptor.class, bVar2).d(Integer.class, Uri.class, dVar2).d(cls, AssetFileDescriptor.class, aVar2).d(Integer.class, AssetFileDescriptor.class, aVar2).d(cls, Uri.class, dVar2).d(String.class, InputStream.class, new com.bumptech.glide.load.n.e.c()).d(Uri.class, InputStream.class, new com.bumptech.glide.load.n.e.c()).d(String.class, InputStream.class, new u.c()).d(String.class, ParcelFileDescriptor.class, new u.b()).d(String.class, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new com.bumptech.glide.load.n.y.b.a()).d(Uri.class, InputStream.class, new com.bumptech.glide.load.n.a.c(context.getAssets())).d(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.n.a.b(context.getAssets())).d(Uri.class, InputStream.class, new com.bumptech.glide.load.n.y.c.a(context)).d(Uri.class, InputStream.class, new com.bumptech.glide.load.n.y.d.a(context)).d(Uri.class, InputStream.class, new w.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).d(Uri.class, InputStream.class, new com.bumptech.glide.load.n.x.a()).d(URL.class, InputStream.class, new com.bumptech.glide.load.n.y.e.a()).d(Uri.class, File.class, new com.bumptech.glide.load.n.k.a(context)).d(com.bumptech.glide.load.n.g.class, InputStream.class, new com.bumptech.glide.load.n.y.a.C0136a()).d(byte[].class, ByteBuffer.class, new com.bumptech.glide.load.n.b.a()).d(byte[].class, InputStream.class, new com.bumptech.glide.load.n.b.d()).d(Uri.class, Uri.class, com.bumptech.glide.load.n.v.a.a()).d(Drawable.class, Drawable.class, com.bumptech.glide.load.n.v.a.a()).c(Drawable.class, Drawable.class, new com.bumptech.glide.load.o.e.f()).q(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.o.h.b(resources)).q(Bitmap.class, byte[].class, aVar3).q(Drawable.class, byte[].class, new com.bumptech.glide.load.o.h.c(eVar, aVar3, dVar3)).q(com.bumptech.glide.load.o.g.c.class, byte[].class, dVar3);
        this.l = new e(context, bVar, registry, new com.bumptech.glide.p.l.e(), hVar2, map, list, kVar, z, i2);
    }

    private static void a(Context context) {
        if (f8916g) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f8916g = true;
        m(context);
        f8916g = false;
    }

    public static c c(Context context) {
        if (f8915f == null) {
            synchronized (c.class) {
                if (f8915f == null) {
                    a(context);
                }
            }
        }
        return f8915f;
    }

    private static a d() {
        try {
            return (a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e2) {
            q(e2);
            return null;
        } catch (InstantiationException e3) {
            q(e3);
            return null;
        } catch (NoSuchMethodException e4) {
            q(e4);
            return null;
        } catch (InvocationTargetException e5) {
            q(e5);
            return null;
        }
    }

    private static l l(Context context) {
        com.bumptech.glide.r.j.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    private static void m(Context context) {
        n(context, new d());
    }

    private static void n(Context context, d dVar) {
        Context applicationContext = context.getApplicationContext();
        a aVarD = d();
        List<com.bumptech.glide.n.b> listEmptyList = Collections.emptyList();
        if (aVarD == null || aVarD.c()) {
            listEmptyList = new com.bumptech.glide.n.d(applicationContext).a();
        }
        if (aVarD != null && !aVarD.d().isEmpty()) {
            Set<Class<?>> setD = aVarD.d();
            Iterator<com.bumptech.glide.n.b> it = listEmptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.n.b next = it.next();
                if (setD.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<com.bumptech.glide.n.b> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        dVar.e(aVarD != null ? aVarD.e() : null);
        Iterator<com.bumptech.glide.n.b> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().applyOptions(applicationContext, dVar);
        }
        if (aVarD != null) {
            aVarD.b(applicationContext, dVar);
        }
        c cVarA = dVar.a(applicationContext);
        Iterator<com.bumptech.glide.n.b> it4 = listEmptyList.iterator();
        while (it4.hasNext()) {
            it4.next().registerComponents(applicationContext, cVarA, cVarA.m);
        }
        if (aVarD != null) {
            aVarD.a(applicationContext, cVarA, cVarA.m);
        }
        applicationContext.registerComponentCallbacks(cVarA);
        f8915f = cVarA;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public static i t(Context context) {
        return l(context).d(context);
    }

    public static i u(Fragment fragment) {
        return l(fragment.getActivity()).e(fragment);
    }

    public void b() {
        com.bumptech.glide.r.k.b();
        this.f8919j.b();
        this.f8918i.b();
        this.n.b();
    }

    public com.bumptech.glide.load.engine.z.b e() {
        return this.n;
    }

    public com.bumptech.glide.load.engine.z.e f() {
        return this.f8918i;
    }

    com.bumptech.glide.m.d g() {
        return this.p;
    }

    public Context h() {
        return this.l.getBaseContext();
    }

    e i() {
        return this.l;
    }

    public Registry j() {
        return this.m;
    }

    public l k() {
        return this.o;
    }

    void o(i iVar) {
        synchronized (this.q) {
            if (this.q.contains(iVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.q.add(iVar);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        r(i2);
    }

    boolean p(com.bumptech.glide.p.l.i<?> iVar) {
        synchronized (this.q) {
            Iterator<i> it = this.q.iterator();
            while (it.hasNext()) {
                if (it.next().p(iVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i2) {
        com.bumptech.glide.r.k.b();
        this.f8919j.a(i2);
        this.f8918i.a(i2);
        this.n.a(i2);
    }

    void s(i iVar) {
        synchronized (this.q) {
            if (!this.q.contains(iVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.q.remove(iVar);
        }
    }
}
