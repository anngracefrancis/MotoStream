package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpk;
import java.security.GeneralSecurityException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdbt<P, KeyProto extends zzdpk, KeyFormatProto extends zzdpk> implements zzdbs<P> {
    private final Class<P> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<KeyProto> f15857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<KeyFormatProto> f15858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f15859d;

    protected zzdbt(Class<P> cls, Class<KeyProto> cls2, Class<KeyFormatProto> cls3, String str) {
        this.a = cls;
        this.f15857b = cls2;
        this.f15858c = cls3;
        this.f15859d = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <Casted> Casted h(Object obj, String str, Class<Casted> cls) throws GeneralSecurityException {
        if (cls.isInstance(obj)) {
            return obj;
        }
        throw new GeneralSecurityException(str);
    }

    private final P m(KeyProto keyproto) throws GeneralSecurityException {
        j(keyproto);
        return l(keyproto);
    }

    private final KeyProto o(KeyFormatProto keyformatproto) throws GeneralSecurityException {
        k(keyformatproto);
        KeyProto keyproto = (KeyProto) n(keyformatproto);
        j(keyproto);
        return keyproto;
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final Class<P> a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final String b() {
        return this.f15859d;
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final zzdpk c(zzdpk zzdpkVar) throws GeneralSecurityException {
        String name = this.f15858c.getName();
        return o((zzdpk) h(zzdpkVar, name.length() != 0 ? "Expected proto of type ".concat(name) : new String("Expected proto of type "), this.f15858c));
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final P d(zzdpk zzdpkVar) throws GeneralSecurityException {
        String name = this.f15857b.getName();
        return m((zzdpk) h(zzdpkVar, name.length() != 0 ? "Expected proto of type ".concat(name) : new String("Expected proto of type "), this.f15857b));
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final zzdgr e(zzdmr zzdmrVar) throws GeneralSecurityException {
        try {
            return (zzdgr) ((zzdob) zzdgr.E().w(this.f15859d).v(o(q(zzdmrVar)).e()).u(i()).p0());
        } catch (zzdok e2) {
            throw new GeneralSecurityException("Unexpected proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final zzdpk f(zzdmr zzdmrVar) throws GeneralSecurityException {
        try {
            return o(q(zzdmrVar));
        } catch (zzdok e2) {
            String name = this.f15858c.getName();
            throw new GeneralSecurityException(name.length() != 0 ? "Failures parsing proto of type ".concat(name) : new String("Failures parsing proto of type "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final P g(zzdmr zzdmrVar) throws GeneralSecurityException {
        try {
            return m(p(zzdmrVar));
        } catch (zzdok e2) {
            String name = this.f15857b.getName();
            throw new GeneralSecurityException(name.length() != 0 ? "Failures parsing proto of type ".concat(name) : new String("Failures parsing proto of type "), e2);
        }
    }

    protected abstract zzdgr.zzb i();

    protected abstract void j(KeyProto keyproto) throws GeneralSecurityException;

    protected abstract void k(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    protected abstract P l(KeyProto keyproto) throws GeneralSecurityException;

    protected abstract KeyProto n(KeyFormatProto keyformatproto) throws GeneralSecurityException;

    protected abstract KeyProto p(zzdmr zzdmrVar) throws zzdok;

    protected abstract KeyFormatProto q(zzdmr zzdmrVar) throws zzdok;
}
