package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.internal.measurement.zzdn;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdn<MessageType extends zzdl<MessageType, BuilderType>, BuilderType extends zzdn<MessageType, BuilderType>> implements zzgn {
    private final String n(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(name.length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ zzgn X0(zzgo zzgoVar) {
        if (d().getClass().isInstance(zzgoVar)) {
            return j((zzdl) zzgoVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ zzgn Y(byte[] bArr, zzeq zzeqVar) throws zzfo {
        return m(bArr, 0, bArr.length, zzeqVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final /* synthetic */ zzgn i0(byte[] bArr) throws zzfo {
        return l(bArr, 0, bArr.length);
    }

    protected abstract BuilderType j(MessageType messagetype);

    public abstract BuilderType k(zzeg zzegVar, zzeq zzeqVar) throws IOException;

    public BuilderType l(byte[] bArr, int i2, int i3) throws zzfo {
        try {
            zzeg zzegVarC = zzeg.c(bArr, 0, i3, false);
            k(zzegVarC, zzeq.a());
            zzegVarC.d(0);
            return this;
        } catch (zzfo e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException(n("byte array"), e3);
        }
    }

    public BuilderType m(byte[] bArr, int i2, int i3, zzeq zzeqVar) throws zzfo {
        try {
            zzeg zzegVarC = zzeg.c(bArr, 0, i3, false);
            k(zzegVarC, zzeqVar);
            zzegVarC.d(0);
            return this;
        } catch (zzfo e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException(n("byte array"), e3);
        }
    }

    @Override // 
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();
}
