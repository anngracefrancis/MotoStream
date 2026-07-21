package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public class zzak implements zzm {
    private static final boolean a = zzag.f13871b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    private final zzas f13929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzaj f13930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzal f13931d;

    @Deprecated
    public zzak(zzas zzasVar) {
        this(zzasVar, new zzal(RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT));
    }

    private static void b(String str, zzr<?> zzrVar, zzaf zzafVar) throws zzaf {
        zzac zzacVarR = zzrVar.R();
        int iQ = zzrVar.Q();
        try {
            zzacVarR.a(zzafVar);
            zzrVar.I(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(iQ)));
        } catch (zzaf e2) {
            zzrVar.I(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(iQ)));
            throw e2;
        }
    }

    private final byte[] c(InputStream inputStream, int i2) throws IOException, zzad {
        zzaw zzawVar = new zzaw(this.f13931d, i2);
        try {
            if (inputStream == null) {
                throw new zzad();
            }
            byte[] bArrB = this.f13931d.b(1024);
            while (true) {
                int i3 = inputStream.read(bArrB);
                if (i3 == -1) {
                    break;
                }
                zzawVar.write(bArrB, 0, i3);
            }
            byte[] byteArray = zzawVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused) {
                zzag.c("Error occurred when closing InputStream", new Object[0]);
            }
            this.f13931d.a(bArrB);
            zzawVar.close();
            return byteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    zzag.c("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.f13931d.a(null);
            zzawVar.close();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:115:0x01fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x01f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0193  */
    @Override // com.google.android.gms.internal.ads.zzm
    public zzp a(zzr<?> zzrVar) throws zzaf {
        zzar zzarVar;
        byte[] bArr;
        int iC;
        zzp zzpVar;
        Map<String, String> mapEmptyMap;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            List<zzl> listEmptyList = Collections.emptyList();
            try {
                try {
                    zzc zzcVarN = zzrVar.N();
                    if (zzcVarN == null) {
                        mapEmptyMap = Collections.emptyMap();
                    } else {
                        HashMap map = new HashMap();
                        String str = zzcVarN.f14946b;
                        if (str != null) {
                            map.put("If-None-Match", str);
                        }
                        long j2 = zzcVarN.f14948d;
                        if (j2 > 0) {
                            map.put("If-Modified-Since", zzaq.b(j2));
                        }
                        mapEmptyMap = map;
                    }
                    zzar zzarVarB = this.f13930c.b(zzrVar, mapEmptyMap);
                    try {
                        int iC2 = zzarVarB.c();
                        List<zzl> listD = zzarVarB.d();
                        if (iC2 == 304) {
                            zzc zzcVarN2 = zzrVar.N();
                            if (zzcVarN2 == null) {
                                return new zzp(304, (byte[]) null, true, SystemClock.elapsedRealtime() - jElapsedRealtime, listD);
                            }
                            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                            if (!listD.isEmpty()) {
                                Iterator<zzl> it = listD.iterator();
                                while (it.hasNext()) {
                                    treeSet.add(it.next().a());
                                }
                            }
                            ArrayList arrayList = new ArrayList(listD);
                            List<zzl> list = zzcVarN2.f14952h;
                            if (list != null) {
                                if (!list.isEmpty()) {
                                    for (zzl zzlVar : zzcVarN2.f14952h) {
                                        if (!treeSet.contains(zzlVar.a())) {
                                            arrayList.add(zzlVar);
                                        }
                                    }
                                }
                            } else if (!zzcVarN2.f14951g.isEmpty()) {
                                for (Map.Entry<String, String> entry : zzcVarN2.f14951g.entrySet()) {
                                    if (!treeSet.contains(entry.getKey())) {
                                        arrayList.add(new zzl(entry.getKey(), entry.getValue()));
                                    }
                                }
                            }
                            return new zzp(304, zzcVarN2.a, true, SystemClock.elapsedRealtime() - jElapsedRealtime, (List<zzl>) arrayList);
                        }
                        InputStream inputStreamA = zzarVarB.a();
                        byte[] bArrC = inputStreamA != null ? c(inputStreamA, zzarVarB.b()) : new byte[0];
                        try {
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            if (a || jElapsedRealtime2 > 3000) {
                                Object[] objArr = new Object[5];
                                objArr[0] = zzrVar;
                                objArr[1] = Long.valueOf(jElapsedRealtime2);
                                objArr[2] = bArrC != null ? Integer.valueOf(bArrC.length) : "null";
                                objArr[3] = Integer.valueOf(iC2);
                                objArr[4] = Integer.valueOf(zzrVar.R().c());
                                zzag.a("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
                            }
                            if (iC2 < 200 || iC2 > 299) {
                                throw new IOException();
                            }
                            return new zzp(iC2, bArrC, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listD);
                        } catch (IOException e2) {
                            e = e2;
                            listEmptyList = listD;
                            bArr = bArrC;
                            zzarVar = zzarVarB;
                            if (zzarVar != null) {
                                throw new zzq(e);
                            }
                            iC = zzarVar.c();
                            zzag.b("Unexpected response code %d for %s", Integer.valueOf(iC), zzrVar.q());
                            if (bArr != null) {
                                zzpVar = new zzp(iC, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listEmptyList);
                                if (iC == 401) {
                                }
                                b("auth", zzrVar, new zza(zzpVar));
                            } else {
                                b("network", zzrVar, new zzo());
                            }
                        }
                    } catch (IOException e3) {
                        e = e3;
                        zzarVar = zzarVarB;
                        bArr = null;
                        if (zzarVar != null) {
                            throw new zzq(e);
                        }
                        iC = zzarVar.c();
                        zzag.b("Unexpected response code %d for %s", Integer.valueOf(iC), zzrVar.q());
                        if (bArr != null) {
                            zzpVar = new zzp(iC, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listEmptyList);
                            if (iC == 401 && iC != 403) {
                                if (iC >= 400 && iC <= 499) {
                                    throw new zzg(zzpVar);
                                }
                                if (iC < 500 || iC > 599) {
                                    throw new zzad(zzpVar);
                                }
                                throw new zzad(zzpVar);
                            }
                            b("auth", zzrVar, new zza(zzpVar));
                        } else {
                            b("network", zzrVar, new zzo());
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    zzarVar = null;
                }
            } catch (MalformedURLException e5) {
                String strValueOf = String.valueOf(zzrVar.q());
                throw new RuntimeException(strValueOf.length() != 0 ? "Bad URL ".concat(strValueOf) : new String("Bad URL "), e5);
            } catch (SocketTimeoutException unused) {
                b("socket", zzrVar, new zzae());
            }
        }
    }

    @Deprecated
    private zzak(zzas zzasVar, zzal zzalVar) {
        this.f13929b = zzasVar;
        this.f13930c = new o0(zzasVar);
        this.f13931d = zzalVar;
    }

    public zzak(zzaj zzajVar) {
        this(zzajVar, new zzal(RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT));
    }

    private zzak(zzaj zzajVar, zzal zzalVar) {
        this.f13930c = zzajVar;
        this.f13929b = zzajVar;
        this.f13931d = zzalVar;
    }
}
