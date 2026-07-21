package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzvk {
    private final zzva a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f16852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f16853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f16854e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f16855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f16856g;

    public zzvk(int i2, int i3, int i4) {
        this.f16851b = i2;
        if (i3 > 64 || i3 < 0) {
            this.f16855f = 64;
        } else {
            this.f16855f = i3;
        }
        if (i4 <= 0) {
            this.f16856g = 1;
        } else {
            this.f16856g = i4;
        }
        this.a = new zzvj(this.f16855f);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0094  */
    public final String a(ArrayList<String> arrayList, ArrayList<zzuz> arrayList2) {
        boolean z;
        boolean z2;
        int i2;
        Collections.sort(arrayList2, new zzvl(this));
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            String[] strArrSplit = Normalizer.normalize(arrayList.get(arrayList2.get(i3).e()), Normalizer.Form.NFKC).toLowerCase(Locale.US).split("\n");
            if (strArrSplit.length != 0) {
                int i4 = 0;
                while (true) {
                    if (i4 < strArrSplit.length) {
                        String str = strArrSplit[i4];
                        if (str.indexOf("'") != -1) {
                            StringBuilder sb = new StringBuilder(str);
                            int i5 = 1;
                            boolean z3 = false;
                            while (true) {
                                int i6 = i5 + 2;
                                if (i6 > sb.length()) {
                                    break;
                                }
                                if (sb.charAt(i5) == '\'') {
                                    if (sb.charAt(i5 - 1) != ' ') {
                                        int i7 = i5 + 1;
                                        if ((sb.charAt(i7) == 's' || sb.charAt(i7) == 'S') && (i6 == sb.length() || sb.charAt(i6) == ' ')) {
                                            sb.insert(i5, ' ');
                                            i5 = i6;
                                        } else {
                                            sb.setCharAt(i5, ' ');
                                        }
                                    } else {
                                        sb.setCharAt(i5, ' ');
                                    }
                                    i2 = 1;
                                    z3 = true;
                                } else {
                                    i2 = 1;
                                }
                                i5 += i2;
                            }
                            String string = z3 ? sb.toString() : null;
                            if (string != null) {
                                this.f16853d = string;
                                str = string;
                            }
                        }
                        String[] strArrB = zzve.b(str, true);
                        if (strArrB.length >= this.f16856g) {
                            int i8 = 0;
                            while (true) {
                                if (i8 < strArrB.length) {
                                    String strConcat = HttpUrl.FRAGMENT_ENCODE_SET;
                                    int i9 = 0;
                                    while (true) {
                                        if (i9 >= this.f16856g) {
                                            z2 = true;
                                            break;
                                        }
                                        int i10 = i8 + i9;
                                        if (i10 >= strArrB.length) {
                                            z2 = false;
                                            break;
                                        }
                                        if (i9 > 0) {
                                            strConcat = String.valueOf(strConcat).concat(" ");
                                        }
                                        String strValueOf = String.valueOf(strConcat);
                                        String strValueOf2 = String.valueOf(strArrB[i10]);
                                        strConcat = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                                        i9++;
                                    }
                                    if (z2) {
                                        hashSet.add(strConcat);
                                        if (hashSet.size() < this.f16851b) {
                                            i8++;
                                        }
                                    }
                                    z = false;
                                }
                                if (hashSet.size() >= this.f16851b) {
                                    z = false;
                                }
                            }
                        }
                        i4++;
                    } else {
                        z = true;
                    }
                }
            } else {
                z = true;
            }
            if (!z) {
                break;
            }
        }
        t40 t40Var = new t40();
        this.f16852c = HttpUrl.FRAGMENT_ENCODE_SET;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            try {
                t40Var.a(this.a.a((String) it.next()));
            } catch (IOException e2) {
                zzbad.c("Error while writing hash to byteStream", e2);
            }
        }
        return t40Var.toString();
    }
}
