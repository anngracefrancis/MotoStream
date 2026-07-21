package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class v10 {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public int H;
    public int I;
    public long J;
    public long K;
    public boolean L;
    public boolean M;
    private String N;
    public zznw O;
    public int P;
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f13423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public zznx f13424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f13425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zzne f13426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13427j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f13428k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public float x;
    public float y;
    public float z;

    private v10() {
        this.f13427j = -1;
        this.f13428k = -1;
        this.l = -1;
        this.m = -1;
        this.n = 0;
        this.o = null;
        this.p = -1;
        this.q = false;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = 1000;
        this.v = 200;
        this.w = -1.0f;
        this.x = -1.0f;
        this.y = -1.0f;
        this.z = -1.0f;
        this.A = -1.0f;
        this.B = -1.0f;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1.0f;
        this.F = -1.0f;
        this.G = 1;
        this.H = -1;
        this.I = 8000;
        this.J = 0L;
        this.K = 0L;
        this.M = true;
        this.N = "eng";
    }

    private static List<byte[]> b(zzst zzstVar) throws zzlm {
        try {
            zzstVar.l(16);
            if (zzstVar.w() != 826496599) {
                return null;
            }
            byte[] bArr = zzstVar.a;
            for (int iB = zzstVar.b() + 20; iB < bArr.length - 4; iB++) {
                if (bArr[iB] == 0 && bArr[iB + 1] == 0 && bArr[iB + 2] == 1 && bArr[iB + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, iB, bArr.length));
                }
            }
            throw new zzlm("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlm("Error parsing FourCC VC1 codec private");
        }
    }

    private static boolean d(zzst zzstVar) throws zzlm {
        try {
            int iV = zzstVar.v();
            if (iV == 1) {
                return true;
            }
            if (iV == 65534) {
                zzstVar.k(24);
                if (zzstVar.e() == zzod.f16530d.getMostSignificantBits() && zzstVar.e() == zzod.f16530d.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlm("Error parsing MS/ACM codec private");
        }
    }

    private static List<byte[]> e(byte[] bArr) throws zzlm {
        try {
            if (bArr[0] != 2) {
                throw new zzlm("Error parsing vorbis codec private");
            }
            int i2 = 1;
            int i3 = 0;
            while (bArr[i2] == -1) {
                i3 += 255;
                i2++;
            }
            int i4 = i2 + 1;
            int i5 = i3 + bArr[i2];
            int i6 = 0;
            while (bArr[i4] == -1) {
                i6 += 255;
                i4++;
            }
            int i7 = i4 + 1;
            int i8 = i6 + bArr[i4];
            if (bArr[i7] != 1) {
                throw new zzlm("Error parsing vorbis codec private");
            }
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, i7, bArr2, 0, i5);
            int i9 = i7 + i5;
            if (bArr[i9] != 3) {
                throw new zzlm("Error parsing vorbis codec private");
            }
            int i10 = i9 + i8;
            if (bArr[i10] != 5) {
                throw new zzlm("Error parsing vorbis codec private");
            }
            byte[] bArr3 = new byte[bArr.length - i10];
            System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzlm("Error parsing vorbis codec private");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:131:0x024e A[PHI: r1 r18
      0x024e: PHI (r1v88 int) = (r1v69 int), (r1v91 int) binds: [B:159:0x031f, B:128:0x0226] A[DONT_GENERATE, DONT_INLINE]
      0x024e: PHI (r18v19 java.lang.String) = (r18v1 java.lang.String), (r18v21 java.lang.String) binds: [B:159:0x031f, B:128:0x0226] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:173:0x0377  */
    /* JADX WARN: Code duplicated, block: B:174:0x0379  */
    /* JADX WARN: Code duplicated, block: B:177:0x0381  */
    /* JADX WARN: Code duplicated, block: B:178:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:180:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:182:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:184:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:187:0x03be  */
    /* JADX WARN: Code duplicated, block: B:189:0x03c3  */
    /* JADX WARN: Code duplicated, block: B:192:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:195:0x03dc  */
    /* JADX WARN: Code duplicated, block: B:198:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:200:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:220:0x049d  */
    /* JADX WARN: Code duplicated, block: B:222:0x04ad  */
    /* JADX WARN: Code duplicated, block: B:224:0x04d9  */
    /* JADX WARN: Code duplicated, block: B:226:0x04df  */
    /* JADX WARN: Code duplicated, block: B:228:0x04f9  */
    /* JADX WARN: Code duplicated, block: B:230:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:4:0x0015  */
    public final void c(zznp zznpVar, int i2) throws zzlm {
        byte b2;
        List<byte[]> listSingletonList;
        int iO;
        int i3;
        int i4;
        List<byte[]> list;
        int i5;
        int i6;
        zzlh zzlhVarH;
        int i7;
        int i8;
        float f2;
        zztb zztbVar;
        byte[] bArr;
        int i9;
        int i10;
        int i11;
        String str = this.a;
        str.hashCode();
        int i12 = 1;
        switch (str) {
            case "V_MPEG4/ISO/AP":
                b2 = 0;
                break;
            case "V_MPEG4/ISO/SP":
                b2 = 1;
                break;
            case "A_MS/ACM":
                b2 = 2;
                break;
            case "A_TRUEHD":
                b2 = 3;
                break;
            case "A_VORBIS":
                b2 = 4;
                break;
            case "A_MPEG/L2":
                b2 = 5;
                break;
            case "A_MPEG/L3":
                b2 = 6;
                break;
            case "V_MS/VFW/FOURCC":
                b2 = 7;
                break;
            case "S_DVBSUB":
                b2 = 8;
                break;
            case "V_MPEG4/ISO/ASP":
                b2 = 9;
                break;
            case "V_MPEG4/ISO/AVC":
                b2 = 10;
                break;
            case "S_VOBSUB":
                b2 = 11;
                break;
            case "A_DTS/LOSSLESS":
                b2 = 12;
                break;
            case "A_AAC":
                b2 = 13;
                break;
            case "A_AC3":
                b2 = 14;
                break;
            case "A_DTS":
                b2 = 15;
                break;
            case "V_VP8":
                b2 = 16;
                break;
            case "V_VP9":
                b2 = 17;
                break;
            case "S_HDMV/PGS":
                b2 = 18;
                break;
            case "V_THEORA":
                b2 = 19;
                break;
            case "A_DTS/EXPRESS":
                b2 = 20;
                break;
            case "A_PCM/INT/LIT":
                b2 = 21;
                break;
            case "V_MPEGH/ISO/HEVC":
                b2 = 22;
                break;
            case "S_TEXT/UTF8":
                b2 = 23;
                break;
            case "V_MPEG2":
                b2 = 24;
                break;
            case "A_EAC3":
                b2 = 25;
                break;
            case "A_FLAC":
                b2 = 26;
                break;
            case "A_OPUS":
                b2 = 27;
                break;
            default:
                b2 = -1;
                break;
        }
        String str2 = "application/pgs";
        String str3 = "audio/raw";
        switch (b2) {
            case 0:
            case 1:
            case 9:
                str2 = "application/pgs";
                byte[] bArr2 = this.f13425h;
                listSingletonList = bArr2 == null ? null : Collections.singletonList(bArr2);
                str3 = "video/mp4v-es";
                i3 = -1;
                i4 = -1;
                int i13 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i13 | i5;
                if (!zzsp.b(str3)) {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                } else if (zzsp.c(str3)) {
                    if (this.n == 0) {
                        i10 = this.l;
                        i7 = -1;
                        if (i10 == -1) {
                            i10 = this.f13427j;
                        }
                        this.l = i10;
                        i11 = this.m;
                        if (i11 == -1) {
                            i11 = this.f13428k;
                        }
                        this.m = i11;
                    } else {
                        i7 = -1;
                    }
                    i8 = this.l;
                    if (i8 != i7 || (i9 = this.m) == i7) {
                        f2 = -1.0f;
                    } else {
                        f2 = (this.f13428k * i8) / (this.f13427j * i9);
                    }
                    if (this.q) {
                        if (this.w != -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                            bArr = null;
                        } else {
                            bArr = new byte[25];
                            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                            byteBufferWrap.put((byte) 0);
                            byteBufferWrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
                            byteBufferWrap.putShort((short) (this.E + 0.5f));
                            byteBufferWrap.putShort((short) (this.F + 0.5f));
                            byteBufferWrap.putShort((short) this.u);
                            byteBufferWrap.putShort((short) this.v);
                        }
                        zztbVar = new zztb(this.r, this.t, this.s, bArr);
                    } else {
                        zztbVar = null;
                    }
                    zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                    i12 = 2;
                } else {
                    if ("application/x-subrip".equals(str3)) {
                        zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                    } else {
                        if ("application/vobsub".equals(str3) && !str2.equals(str3) && !"application/dvbsubs".equals(str3)) {
                            throw new zzlm("Unexpected MIME type.");
                        }
                        zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                    }
                    i12 = 3;
                }
                zznw zznwVarY = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY;
                zznwVarY.a(zzlhVarH);
                return;
            case 2:
                str2 = "application/pgs";
                if (d(new zzst(this.f13425h))) {
                    iO = zzsy.o(this.H);
                    if (iO == 0) {
                        int i14 = this.H;
                        StringBuilder sb = new StringBuilder("audio/x-unknown".length() + 60);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i14);
                        sb.append(". Setting mimeType to ");
                        sb.append("audio/x-unknown");
                        Log.w("MatroskaExtractor", sb.toString());
                    } else {
                        i3 = iO;
                        listSingletonList = null;
                    }
                    i4 = -1;
                    int i15 = (this.M ? 1 : 0) | 0;
                    if (this.L) {
                        i5 = 2;
                    } else {
                        i5 = 0;
                    }
                    i6 = i15 | i5;
                    if (!zzsp.b(str3)) {
                        if (zzsp.c(str3)) {
                            if (this.n == 0) {
                                i10 = this.l;
                                i7 = -1;
                                if (i10 == -1) {
                                    i10 = this.f13427j;
                                }
                                this.l = i10;
                                i11 = this.m;
                                if (i11 == -1) {
                                    i11 = this.f13428k;
                                }
                                this.m = i11;
                            } else {
                                i7 = -1;
                            }
                            i8 = this.l;
                            if (i8 != i7) {
                                f2 = -1.0f;
                            } else {
                                f2 = -1.0f;
                            }
                            if (this.q) {
                                if (this.w != -1.0f) {
                                    bArr = null;
                                } else {
                                    bArr = null;
                                }
                                zztbVar = new zztb(this.r, this.t, this.s, bArr);
                            } else {
                                zztbVar = null;
                            }
                            zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                            i12 = 2;
                        } else {
                            if ("application/x-subrip".equals(str3)) {
                                zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                            } else {
                                if ("application/vobsub".equals(str3)) {
                                }
                                zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                            }
                            i12 = 3;
                        }
                        break;
                    } else {
                        zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                    }
                    zznw zznwVarY2 = zznpVar.y(this.f13419b, i12);
                    this.O = zznwVarY2;
                    zznwVarY2.a(zzlhVarH);
                    return;
                }
                Log.w("MatroskaExtractor", "audio/x-unknown".length() != 0 ? "Non-PCM MS/ACM is unsupported. Setting mimeType to ".concat("audio/x-unknown") : new String("Non-PCM MS/ACM is unsupported. Setting mimeType to "));
                str3 = "audio/x-unknown";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i16 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i16 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY3 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY3;
                zznwVarY3.a(zzlhVarH);
                return;
            case 3:
                str2 = "application/pgs";
                str3 = "audio/true-hd";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i17 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i17 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY4 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY4;
                zznwVarY4.a(zzlhVarH);
                return;
            case 4:
                str2 = "application/pgs";
                listSingletonList = e(this.f13425h);
                str3 = "audio/vorbis";
                i3 = -1;
                i4 = 8192;
                int i18 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i18 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY5 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY5;
                zznwVarY5.a(zzlhVarH);
                return;
            case 5:
                str3 = "audio/mpeg-L2";
                listSingletonList = null;
                i3 = -1;
                i4 = RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
                int i19 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i19 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY6 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY6;
                zznwVarY6.a(zzlhVarH);
                return;
            case 6:
                str3 = "audio/mpeg";
                listSingletonList = null;
                i3 = -1;
                i4 = RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
                int i110 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i110 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY7 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY7;
                zznwVarY7.a(zzlhVarH);
                return;
            case 7:
                str2 = "application/pgs";
                listSingletonList = b(new zzst(this.f13425h));
                if (listSingletonList != null) {
                    str3 = "video/wvc1";
                } else {
                    Log.w("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                    str3 = "video/x-unknown";
                }
                i3 = -1;
                i4 = -1;
                int i111 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i111 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY8 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY8;
                zznwVarY8.a(zzlhVarH);
                return;
            case 8:
                str2 = "application/pgs";
                byte[] bArr3 = this.f13425h;
                listSingletonList = Collections.singletonList(new byte[]{bArr3[0], bArr3[1], bArr3[2], bArr3[3]});
                str3 = "application/dvbsubs";
                i3 = -1;
                i4 = -1;
                int i112 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i112 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY9 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY9;
                zznwVarY9.a(zzlhVarH);
                return;
            case 10:
                zzta zztaVarA = zzta.a(new zzst(this.f13425h));
                list = zztaVarA.a;
                this.P = zztaVarA.f16748b;
                str3 = "video/avc";
                listSingletonList = list;
                i3 = -1;
                i4 = -1;
                int i113 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i113 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY10 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY10;
                zznwVarY10.a(zzlhVarH);
                return;
            case 11:
                str2 = "application/pgs";
                listSingletonList = Collections.singletonList(this.f13425h);
                str3 = "application/vobsub";
                i3 = -1;
                i4 = -1;
                int i114 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i114 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY11 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY11;
                zznwVarY11.a(zzlhVarH);
                return;
            case 12:
                str2 = "application/pgs";
                str3 = "audio/vnd.dts.hd";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i115 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i115 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY12 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY12;
                zznwVarY12.a(zzlhVarH);
                return;
            case 13:
                str2 = "application/pgs";
                listSingletonList = Collections.singletonList(this.f13425h);
                str3 = "audio/mp4a-latm";
                i3 = -1;
                i4 = -1;
                int i116 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i116 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY13 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY13;
                zznwVarY13.a(zzlhVarH);
                return;
            case 14:
                str2 = "application/pgs";
                str3 = "audio/ac3";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i117 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i117 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY14 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY14;
                zznwVarY14.a(zzlhVarH);
                return;
            case 15:
            case 20:
                str2 = "application/pgs";
                str3 = "audio/vnd.dts";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i118 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i118 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY15 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY15;
                zznwVarY15.a(zzlhVarH);
                return;
            case 16:
                str2 = "application/pgs";
                str3 = "video/x-vnd.on2.vp8";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i119 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i119 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY16 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY16;
                zznwVarY16.a(zzlhVarH);
                return;
            case 17:
                str2 = "application/pgs";
                str3 = "video/x-vnd.on2.vp9";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i1110 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1110 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY17 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY17;
                zznwVarY17.a(zzlhVarH);
                return;
            case 18:
                str2 = "application/pgs";
                listSingletonList = null;
                str3 = str2;
                i3 = -1;
                i4 = -1;
                int i1111 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1111 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY18 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY18;
                zznwVarY18.a(zzlhVarH);
                return;
            case 19:
                str2 = "application/pgs";
                str3 = "video/x-unknown";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i1112 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1112 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY19 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY19;
                zznwVarY19.a(zzlhVarH);
                return;
            case 21:
                str2 = "application/pgs";
                iO = zzsy.o(this.H);
                if (iO == 0) {
                    int i20 = this.H;
                    StringBuilder sb2 = new StringBuilder("audio/x-unknown".length() + 60);
                    sb2.append("Unsupported PCM bit depth: ");
                    sb2.append(i20);
                    sb2.append(". Setting mimeType to ");
                    sb2.append("audio/x-unknown");
                    Log.w("MatroskaExtractor", sb2.toString());
                    str3 = "audio/x-unknown";
                    listSingletonList = null;
                    i3 = -1;
                } else {
                    i3 = iO;
                    listSingletonList = null;
                }
                i4 = -1;
                int i1113 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1113 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY110 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY110;
                zznwVarY110.a(zzlhVarH);
                return;
            case 22:
                zztg zztgVarA = zztg.a(new zzst(this.f13425h));
                list = zztgVarA.a;
                this.P = zztgVarA.f16762b;
                str3 = "video/hevc";
                listSingletonList = list;
                i3 = -1;
                i4 = -1;
                int i1114 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1114 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY111 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY111;
                zznwVarY111.a(zzlhVarH);
                return;
            case 23:
                str2 = "application/pgs";
                str3 = "application/x-subrip";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i1115 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1115 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY112 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY112;
                zznwVarY112.a(zzlhVarH);
                return;
            case 24:
                str2 = "application/pgs";
                str3 = "video/mpeg2";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i1116 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1116 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY113 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY113;
                zznwVarY113.a(zzlhVarH);
                return;
            case 25:
                str2 = "application/pgs";
                str3 = "audio/eac3";
                listSingletonList = null;
                i3 = -1;
                i4 = -1;
                int i1117 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1117 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY114 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY114;
                zznwVarY114.a(zzlhVarH);
                return;
            case 26:
                str2 = "application/pgs";
                listSingletonList = Collections.singletonList(this.f13425h);
                str3 = "audio/x-flac";
                i3 = -1;
                i4 = -1;
                int i1118 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1118 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY115 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY115;
                zznwVarY115.a(zzlhVarH);
                return;
            case 27:
                listSingletonList = new ArrayList<>(3);
                listSingletonList.add(this.f13425h);
                str2 = "application/pgs";
                listSingletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                listSingletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                str3 = "audio/opus";
                i3 = -1;
                i4 = 5760;
                int i1119 = (this.M ? 1 : 0) | 0;
                if (this.L) {
                    i5 = 2;
                } else {
                    i5 = 0;
                }
                i6 = i1119 | i5;
                if (!zzsp.b(str3)) {
                    if (zzsp.c(str3)) {
                        if (this.n == 0) {
                            i10 = this.l;
                            i7 = -1;
                            if (i10 == -1) {
                                i10 = this.f13427j;
                            }
                            this.l = i10;
                            i11 = this.m;
                            if (i11 == -1) {
                                i11 = this.f13428k;
                            }
                            this.m = i11;
                        } else {
                            i7 = -1;
                        }
                        i8 = this.l;
                        if (i8 != i7) {
                            f2 = -1.0f;
                        } else {
                            f2 = -1.0f;
                        }
                        if (this.q) {
                            if (this.w != -1.0f) {
                                bArr = null;
                            } else {
                                bArr = null;
                            }
                            zztbVar = new zztb(this.r, this.t, this.s, bArr);
                        } else {
                            zztbVar = null;
                        }
                        zzlhVarH = zzlh.b(Integer.toString(i2), str3, null, -1, i4, this.f13427j, this.f13428k, -1.0f, listSingletonList, -1, f2, this.o, this.p, zztbVar, this.f13426i);
                        i12 = 2;
                    } else {
                        if ("application/x-subrip".equals(str3)) {
                            zzlhVarH = zzlh.f(Integer.toString(i2), str3, null, -1, i6, this.N, this.f13426i);
                        } else {
                            if ("application/vobsub".equals(str3)) {
                            }
                            zzlhVarH = zzlh.h(Integer.toString(i2), str3, null, -1, listSingletonList, this.N, this.f13426i);
                        }
                        i12 = 3;
                    }
                    break;
                } else {
                    zzlhVarH = zzlh.c(Integer.toString(i2), str3, null, -1, i4, this.G, this.I, i3, listSingletonList, this.f13426i, i6, this.N);
                }
                zznw zznwVarY116 = zznpVar.y(this.f13419b, i12);
                this.O = zznwVarY116;
                zznwVarY116.a(zzlhVarH);
                return;
            default:
                throw new zzlm("Unrecognized codec identifier.");
        }
    }

    /* synthetic */ v10(t10 t10Var) {
        this();
    }
}
