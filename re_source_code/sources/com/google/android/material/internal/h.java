package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: TextDrawableHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f18715c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e.e.b.c.x.d f18718f;
    private final TextPaint a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e.e.b.c.x.f f18714b = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18716d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<b> f18717e = new WeakReference<>(null);

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    class a extends e.e.b.c.x.f {
        a() {
        }

        @Override // e.e.b.c.x.f
        public void a(int i2) {
            h.this.f18716d = true;
            b bVar = (b) h.this.f18717e.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // e.e.b.c.x.f
        public void b(Typeface typeface, boolean z) {
            if (z) {
                return;
            }
            h.this.f18716d = true;
            b bVar = (b) h.this.f18717e.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: TextDrawableHelper.java */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public h(b bVar) {
        g(bVar);
    }

    private float c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.a.measureText(charSequence, 0, charSequence.length());
    }

    public e.e.b.c.x.d d() {
        return this.f18718f;
    }

    public TextPaint e() {
        return this.a;
    }

    public float f(String str) {
        if (!this.f18716d) {
            return this.f18715c;
        }
        float fC = c(str);
        this.f18715c = fC;
        this.f18716d = false;
        return fC;
    }

    public void g(b bVar) {
        this.f18717e = new WeakReference<>(bVar);
    }

    public void h(e.e.b.c.x.d dVar, Context context) {
        if (this.f18718f != dVar) {
            this.f18718f = dVar;
            if (dVar != null) {
                dVar.j(context, this.a, this.f18714b);
                b bVar = this.f18717e.get();
                if (bVar != null) {
                    this.a.drawableState = bVar.getState();
                }
                dVar.i(context, this.a, this.f18714b);
                this.f18716d = true;
            }
            b bVar2 = this.f18717e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void i(boolean z) {
        this.f18716d = z;
    }

    public void j(Context context) {
        this.f18718f.i(context, this.a, this.f18714b);
    }
}
