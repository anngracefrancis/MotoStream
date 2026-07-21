package com.bumptech.glide.load.engine.z;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SizeConfigStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements l {
    private static final Bitmap.Config[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Bitmap.Config[] f9245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Bitmap.Config[] f9246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f9247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f9248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f9249f = new c();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h<b, Bitmap> f9250g = new h<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f9251h = new HashMap();

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static final class b implements m {
        private final c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f9253c;

        public b(c cVar) {
            this.a = cVar;
        }

        @Override // com.bumptech.glide.load.engine.z.m
        public void a() {
            this.a.c(this);
        }

        public void b(int i2, Bitmap.Config config) {
            this.f9252b = i2;
            this.f9253c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9252b == bVar.f9252b && com.bumptech.glide.r.k.d(this.f9253c, bVar.f9253c);
        }

        public int hashCode() {
            int i2 = this.f9252b * 31;
            Bitmap.Config config = this.f9253c;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return n.i(this.f9252b, this.f9253c);
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static class c extends d<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.z.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i2, Bitmap.Config config) {
            b bVarB = b();
            bVarB.b(i2, config);
            return bVarB;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        a = configArr;
        f9245b = configArr;
        f9246c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f9247d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f9248e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void g(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapK = k(bitmap.getConfig());
        Integer num2 = (Integer) navigableMapK.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapK.remove(num);
                return;
            } else {
                navigableMapK.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + f(bitmap) + ", this: " + this);
    }

    private b h(int i2, Bitmap.Config config) {
        b bVarE = this.f9249f.e(i2, config);
        for (Bitmap.Config config2 : j(config)) {
            Integer numCeilingKey = k(config2).ceilingKey(Integer.valueOf(i2));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i2 * 8) {
                if (numCeilingKey.intValue() == i2) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVarE;
                        }
                    } else if (config2.equals(config)) {
                        return bVarE;
                    }
                }
                this.f9249f.c(bVarE);
                return this.f9249f.e(numCeilingKey.intValue(), config2);
            }
        }
        return bVarE;
    }

    static String i(int i2, Bitmap.Config config) {
        return "[" + i2 + "](" + config + ")";
    }

    private static Bitmap.Config[] j(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f9245b;
        }
        int i2 = a.a[config.ordinal()];
        if (i2 == 1) {
            return a;
        }
        if (i2 == 2) {
            return f9246c;
        }
        if (i2 != 3) {
            return i2 != 4 ? new Bitmap.Config[]{config} : f9248e;
        }
        return f9247d;
    }

    private NavigableMap<Integer, Integer> k(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f9251h.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f9251h.put(config, treeMap);
        return treeMap;
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap a() {
        Bitmap bitmapF = this.f9250g.f();
        if (bitmapF != null) {
            g(Integer.valueOf(com.bumptech.glide.r.k.h(bitmapF)), bitmapF);
        }
        return bitmapF;
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String b(int i2, int i3, Bitmap.Config config) {
        return i(com.bumptech.glide.r.k.g(i2, i3, config), config);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public void c(Bitmap bitmap) {
        b bVarE = this.f9249f.e(com.bumptech.glide.r.k.h(bitmap), bitmap.getConfig());
        this.f9250g.d(bVarE, bitmap);
        NavigableMap<Integer, Integer> navigableMapK = k(bitmap.getConfig());
        Integer num = (Integer) navigableMapK.get(Integer.valueOf(bVarE.f9252b));
        navigableMapK.put(Integer.valueOf(bVarE.f9252b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        b bVarH = h(com.bumptech.glide.r.k.g(i2, i3, config), config);
        Bitmap bitmapA = this.f9250g.a(bVarH);
        if (bitmapA != null) {
            g(Integer.valueOf(bVarH.f9252b), bitmapA);
            bitmapA.reconfigure(i2, i3, config);
        }
        return bitmapA;
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public int e(Bitmap bitmap) {
        return com.bumptech.glide.r.k.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.z.l
    public String f(Bitmap bitmap) {
        return i(com.bumptech.glide.r.k.h(bitmap), bitmap.getConfig());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f9250g);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f9251h.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f9251h.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), HttpUrl.FRAGMENT_ENCODE_SET);
        }
        sb.append(")}");
        return sb.toString();
    }
}
