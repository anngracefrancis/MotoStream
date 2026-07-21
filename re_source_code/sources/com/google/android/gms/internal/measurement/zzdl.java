package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.internal.measurement.zzdn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdl<MessageType extends zzdl<MessageType, BuilderType>, BuilderType extends zzdn<MessageType, BuilderType>> implements zzgo {
    protected int zza = 0;

    protected static <T> void c(Iterable<T> iterable, List<? super T> list) {
        zzff.d(iterable);
        if (iterable instanceof zzfv) {
            List<?> listB = ((zzfv) iterable).b();
            zzfv zzfvVar = (zzfv) list;
            int size = list.size();
            for (Object obj : listB) {
                if (obj == null) {
                    int size2 = zzfvVar.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    for (int size3 = zzfvVar.size() - 1; size3 >= size; size3--) {
                        zzfvVar.remove(size3);
                    }
                    throw new NullPointerException(string);
                }
                if (obj instanceof zzdu) {
                    zzfvVar.n1((zzdu) obj);
                } else {
                    zzfvVar.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof m3) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Element at index ");
                sb2.append(size5);
                sb2.append(" is null.");
                String string2 = sb2.toString();
                for (int size6 = list.size() - 1; size6 >= size4; size6--) {
                    list.remove(size6);
                }
                throw new NullPointerException(string2);
            }
            list.add(t);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgo
    public final zzdu h() {
        try {
            t1 t1VarX = zzdu.x(i());
            g(t1VarX.b());
            return t1VarX.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final byte[] j() {
        try {
            byte[] bArr = new byte[i()];
            zzen zzenVarF = zzen.f(bArr);
            g(zzenVarF);
            zzenVarF.N();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    int k() {
        throw new UnsupportedOperationException();
    }

    void l(int i2) {
        throw new UnsupportedOperationException();
    }
}
