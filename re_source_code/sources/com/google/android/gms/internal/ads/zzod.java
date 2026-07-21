package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class zzod implements zznn {
    private static final zznq a = new t10();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f16528b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final byte[] f16529c = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final UUID f16530d = new UUID(72057594037932032L, -9223371306706625679L);
    private long A;
    private boolean B;
    private long C;
    private long D;
    private long E;
    private zzsn F;
    private zzsn G;
    private boolean H;
    private int I;
    private long J;
    private long K;
    private int L;
    private int M;
    private int[] N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private byte W;
    private int X;
    private int Y;
    private int Z;
    private boolean a0;
    private boolean b0;
    private zznp c0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r10 f16531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x10 f16532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SparseArray<v10> f16533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f16534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzst f16535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzst f16536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzst f16537k;
    private final zzst l;
    private final zzst m;
    private final zzst n;
    private final zzst o;
    private final zzst p;
    private final zzst q;
    private ByteBuffer r;
    private long s;
    private long t;
    private long u;
    private long v;
    private long w;
    private v10 x;
    private boolean y;
    private int z;

    public zzod() {
        this(0);
    }

    private final int a(zzno zznoVar, zznw zznwVar, int i2) throws InterruptedException, IOException {
        int iD;
        int iU = this.n.u();
        if (iU > 0) {
            iD = Math.min(i2, iU);
            zznwVar.b(this.n, iD);
        } else {
            iD = zznwVar.d(zznoVar, i2, false);
        }
        this.R += iD;
        this.Z += iD;
        return iD;
    }

    private final void j(zzno zznoVar, v10 v10Var, int i2) throws InterruptedException, IOException {
        int i3;
        if ("S_TEXT/UTF8".equals(v10Var.a)) {
            byte[] bArr = f16528b;
            int length = bArr.length + i2;
            if (this.o.a() < length) {
                this.o.a = Arrays.copyOf(bArr, length + i2);
            }
            zznoVar.readFully(this.o.a, bArr.length, i2);
            this.o.k(0);
            this.o.o(length);
            return;
        }
        zznw zznwVar = v10Var.O;
        if (!this.S) {
            if (v10Var.f13422e) {
                this.Q &= -1073741825;
                if (!this.T) {
                    zznoVar.readFully(this.f16537k.a, 0, 1);
                    this.R++;
                    byte[] bArr2 = this.f16537k.a;
                    if ((bArr2[0] & 128) == 128) {
                        throw new zzlm("Extension bit is set in signal byte");
                    }
                    this.W = bArr2[0];
                    this.T = true;
                }
                byte b2 = this.W;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.Q |= 1073741824;
                    if (!this.U) {
                        zznoVar.readFully(this.p.a, 0, 8);
                        this.R += 8;
                        this.U = true;
                        zzst zzstVar = this.f16537k;
                        zzstVar.a[0] = (byte) ((z ? 128 : 0) | 8);
                        zzstVar.k(0);
                        zznwVar.b(this.f16537k, 1);
                        this.Z++;
                        this.p.k(0);
                        zznwVar.b(this.p, 8);
                        this.Z += 8;
                    }
                    if (z) {
                        if (!this.V) {
                            zznoVar.readFully(this.f16537k.a, 0, 1);
                            this.R++;
                            this.f16537k.k(0);
                            this.X = this.f16537k.g();
                            this.V = true;
                        }
                        int i4 = this.X << 2;
                        this.f16537k.j(i4);
                        zznoVar.readFully(this.f16537k.a, 0, i4);
                        this.R += i4;
                        short s = (short) ((this.X / 2) + 1);
                        int i5 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.r;
                        if (byteBuffer == null || byteBuffer.capacity() < i5) {
                            this.r = ByteBuffer.allocate(i5);
                        }
                        this.r.position(0);
                        this.r.putShort(s);
                        int i6 = 0;
                        int i7 = 0;
                        while (true) {
                            i3 = this.X;
                            if (i6 >= i3) {
                                break;
                            }
                            int iS = this.f16537k.s();
                            if (i6 % 2 == 0) {
                                this.r.putShort((short) (iS - i7));
                            } else {
                                this.r.putInt(iS - i7);
                            }
                            i6++;
                            i7 = iS;
                        }
                        int i8 = (i2 - this.R) - i7;
                        if (i3 % 2 == 1) {
                            this.r.putInt(i8);
                        } else {
                            this.r.putShort((short) i8);
                            this.r.putInt(0);
                        }
                        this.q.m(this.r.array(), i5);
                        zznwVar.b(this.q, i5);
                        this.Z += i5;
                    }
                }
            } else {
                byte[] bArr3 = v10Var.f13423f;
                if (bArr3 != null) {
                    this.n.m(bArr3, bArr3.length);
                }
            }
            this.S = true;
        }
        int iC = i2 + this.n.c();
        if (!"V_MPEG4/ISO/AVC".equals(v10Var.a) && !"V_MPEGH/ISO/HEVC".equals(v10Var.a)) {
            while (true) {
                int i9 = this.R;
                if (i9 >= iC) {
                    break;
                } else {
                    a(zznoVar, zznwVar, iC - i9);
                }
            }
        } else {
            byte[] bArr4 = this.f16536j.a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i10 = v10Var.P;
            int i11 = 4 - i10;
            while (this.R < iC) {
                int i12 = this.Y;
                if (i12 == 0) {
                    int iMin = Math.min(i10, this.n.u());
                    zznoVar.readFully(bArr4, i11 + iMin, i10 - iMin);
                    if (iMin > 0) {
                        this.n.n(bArr4, i11, iMin);
                    }
                    this.R += i10;
                    this.f16536j.k(0);
                    this.Y = this.f16536j.s();
                    this.f16535i.k(0);
                    zznwVar.b(this.f16535i, 4);
                    this.Z += 4;
                } else {
                    this.Y = i12 - a(zznoVar, zznwVar, i12);
                }
            }
        }
        if ("A_VORBIS".equals(v10Var.a)) {
            this.l.k(0);
            zznwVar.b(this.l, 4);
            this.Z += 4;
        }
    }

    private final void k(v10 v10Var, long j2) {
        byte[] bArrM;
        if ("S_TEXT/UTF8".equals(v10Var.a)) {
            byte[] bArr = this.o.a;
            long j3 = this.K;
            if (j3 == -9223372036854775807L) {
                bArrM = f16529c;
            } else {
                int i2 = (int) (j3 / 3600000000L);
                long j4 = j3 - (((long) i2) * 3600000000L);
                int i3 = (int) (j4 / 60000000);
                long j5 = j4 - ((long) (60000000 * i3));
                int i4 = (int) (j5 / 1000000);
                bArrM = zzsy.m(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j5 - ((long) (1000000 * i4))) / 1000))));
            }
            System.arraycopy(bArrM, 0, bArr, 19, 12);
            zznw zznwVar = v10Var.O;
            zzst zzstVar = this.o;
            zznwVar.b(zzstVar, zzstVar.c());
            this.Z += this.o.c();
        }
        v10Var.O.c(j2, this.Q, this.Z, 0, v10Var.f13424g);
        this.a0 = true;
        r();
    }

    private static int[] l(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        return iArr.length >= i2 ? iArr : new int[Math.max(iArr.length << 1, i2)];
    }

    static boolean m(int i2) {
        return i2 == 357149030 || i2 == 524531317 || i2 == 475249515 || i2 == 374648427;
    }

    private final void o(zzno zznoVar, int i2) throws InterruptedException, IOException {
        if (this.f16537k.c() >= i2) {
            return;
        }
        if (this.f16537k.a() < i2) {
            zzst zzstVar = this.f16537k;
            byte[] bArr = zzstVar.a;
            zzstVar.m(Arrays.copyOf(bArr, Math.max(bArr.length << 1, i2)), this.f16537k.c());
        }
        zzst zzstVar2 = this.f16537k;
        zznoVar.readFully(zzstVar2.a, zzstVar2.c(), i2 - this.f16537k.c());
        this.f16537k.o(i2);
    }

    private final long q(long j2) throws zzlm {
        long j3 = this.u;
        if (j3 != -9223372036854775807L) {
            return zzsy.c(j2, j3, 1000L);
        }
        throw new zzlm("Can't scale timecode prior to timecodeScale being set.");
    }

    private final void r() {
        this.R = 0;
        this.Z = 0;
        this.Y = 0;
        this.S = false;
        this.T = false;
        this.V = false;
        this.X = 0;
        this.W = (byte) 0;
        this.U = false;
        this.n.i();
    }

    static int t(int i2) {
        switch (i2) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    final void b(int i2, double d2) {
        if (i2 == 181) {
            this.x.I = (int) d2;
            return;
        }
        if (i2 == 17545) {
            this.v = (long) d2;
            return;
        }
        switch (i2) {
            case 21969:
                this.x.w = (float) d2;
                break;
            case 21970:
                this.x.x = (float) d2;
                break;
            case 21971:
                this.x.y = (float) d2;
                break;
            case 21972:
                this.x.z = (float) d2;
                break;
            case 21973:
                this.x.A = (float) d2;
                break;
            case 21974:
                this.x.B = (float) d2;
                break;
            case 21975:
                this.x.C = (float) d2;
                break;
            case 21976:
                this.x.D = (float) d2;
                break;
            case 21977:
                this.x.E = (float) d2;
                break;
            case 21978:
                this.x.F = (float) d2;
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void c() {
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zznn
    public final int d(zzno zznoVar, zznt zzntVar) throws InterruptedException, IOException {
        boolean z;
        this.a0 = false;
        boolean zC = true;
        while (zC && !this.a0) {
            zC = this.f16531e.c(zznoVar);
            if (zC) {
                long position = zznoVar.getPosition();
                if (this.B) {
                    this.D = position;
                    zzntVar.a = this.C;
                    this.B = false;
                } else {
                    if (this.y) {
                        long j2 = this.D;
                        if (j2 != -1) {
                            zzntVar.a = j2;
                            this.D = -1L;
                        }
                        if (z) {
                            return 1;
                        }
                    }
                    z = false;
                    if (z) {
                        return 1;
                    }
                }
                z = true;
                if (z) {
                    return 1;
                }
            }
        }
        return zC ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void e(zznp zznpVar) {
        this.c0 = zznpVar;
    }

    /* JADX WARN: Code duplicated, block: B:86:0x0225  */
    /* JADX WARN: Code duplicated, block: B:87:0x0227  */
    /* JADX WARN: Code duplicated, block: B:96:0x023a  */
    /* JADX WARN: Code duplicated, block: B:98:0x023d  */
    /* JADX WARN: Code duplicated, block: B:99:0x0240  */
    final void f(int i2, int i3, zzno zznoVar) throws InterruptedException, IOException {
        char c2;
        int i4;
        int i5;
        int[] iArr;
        byte[] bArr;
        boolean z;
        int i6;
        int i7;
        int i8 = 0;
        int i9 = 1;
        if (i2 != 161 && i2 != 163) {
            if (i2 == 16981) {
                byte[] bArr2 = new byte[i3];
                this.x.f13423f = bArr2;
                zznoVar.readFully(bArr2, 0, i3);
                return;
            }
            if (i2 == 18402) {
                byte[] bArr3 = new byte[i3];
                zznoVar.readFully(bArr3, 0, i3);
                this.x.f13424g = new zznx(1, bArr3);
                return;
            }
            if (i2 == 21419) {
                Arrays.fill(this.m.a, (byte) 0);
                zznoVar.readFully(this.m.a, 4 - i3, i3);
                this.m.k(0);
                this.z = (int) this.m.q();
                return;
            }
            if (i2 == 25506) {
                byte[] bArr4 = new byte[i3];
                this.x.f13425h = bArr4;
                zznoVar.readFully(bArr4, 0, i3);
                return;
            } else if (i2 == 30322) {
                byte[] bArr5 = new byte[i3];
                this.x.o = bArr5;
                zznoVar.readFully(bArr5, 0, i3);
                return;
            } else {
                StringBuilder sb = new StringBuilder(26);
                sb.append("Unexpected id: ");
                sb.append(i2);
                throw new zzlm(sb.toString());
            }
        }
        if (this.I == 0) {
            this.O = (int) this.f16532f.b(zznoVar, false, true, 8);
            this.P = this.f16532f.e();
            this.K = -9223372036854775807L;
            this.I = 1;
            this.f16537k.i();
        }
        v10 v10Var = this.f16533g.get(this.O);
        if (v10Var == null) {
            zznoVar.a(i3 - this.P);
            this.I = 0;
            return;
        }
        if (this.I == 1) {
            o(zznoVar, 3);
            int i10 = (this.f16537k.a[2] & 6) >> 1;
            byte b2 = 255;
            if (i10 == 0) {
                this.M = 1;
                int[] iArrL = l(this.N, 1);
                this.N = iArrL;
                iArrL[0] = (i3 - this.P) - 3;
            } else {
                if (i2 != 163) {
                    throw new zzlm("Lacing only supported in SimpleBlocks.");
                }
                int i11 = 4;
                o(zznoVar, 4);
                int i12 = (this.f16537k.a[3] & 255) + 1;
                this.M = i12;
                int[] iArrL2 = l(this.N, i12);
                this.N = iArrL2;
                if (i10 == 2) {
                    int i13 = (i3 - this.P) - 4;
                    int i14 = this.M;
                    Arrays.fill(iArrL2, 0, i14, i13 / i14);
                } else {
                    if (i10 == 1) {
                        int i15 = 0;
                        int i16 = 0;
                        while (true) {
                            i4 = this.M;
                            if (i15 >= i4 - 1) {
                                break;
                            }
                            this.N[i15] = 0;
                            do {
                                i11++;
                                o(zznoVar, i11);
                                i5 = this.f16537k.a[i11 - 1] & 255;
                                iArr = this.N;
                                iArr[i15] = iArr[i15] + i5;
                            } while (i5 == 255);
                            i16 += iArr[i15];
                            i15++;
                        }
                        this.N[i4 - 1] = ((i3 - this.P) - i11) - i16;
                    } else {
                        if (i10 != 3) {
                            StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unexpected lacing value: ");
                            sb2.append(i10);
                            throw new zzlm(sb2.toString());
                        }
                        int i17 = 0;
                        int i18 = 0;
                        while (true) {
                            int i19 = this.M;
                            if (i17 >= i19 - 1) {
                                c2 = 1;
                                this.N[i19 - 1] = ((i3 - this.P) - i11) - i18;
                                break;
                            }
                            this.N[i17] = i8;
                            i11++;
                            o(zznoVar, i11);
                            int i20 = i11 - 1;
                            if (this.f16537k.a[i20] == 0) {
                                throw new zzlm("No valid varint length mask found");
                            }
                            long j2 = 0;
                            int i21 = 0;
                            while (i21 < 8) {
                                int i22 = i9 << (7 - i21);
                                if ((this.f16537k.a[i20] & i22) != 0) {
                                    i11 += i21;
                                    o(zznoVar, i11);
                                    long j3 = this.f16537k.a[i20] & b2 & (i22 ^ (-1));
                                    int i23 = i20 + 1;
                                    while (true) {
                                        j2 = j3;
                                        if (i23 >= i11) {
                                            break;
                                        }
                                        j3 = (j2 << 8) | ((long) (this.f16537k.a[i23] & b2));
                                        i23++;
                                        b2 = 255;
                                    }
                                    if (i17 <= 0) {
                                        break;
                                    }
                                    j2 -= (1 << ((i21 * 7) + 6)) - 1;
                                    break;
                                }
                                i21++;
                                i9 = 1;
                                b2 = 255;
                            }
                            long j4 = j2;
                            if (j4 < -2147483648L || j4 > 2147483647L) {
                                throw new zzlm("EBML lacing sample size out of range.");
                            }
                            int i24 = (int) j4;
                            int[] iArr2 = this.N;
                            if (i17 != 0) {
                                i24 += iArr2[i17 - 1];
                            }
                            iArr2[i17] = i24;
                            i18 += iArr2[i17];
                            i17++;
                            i8 = 0;
                            i9 = 1;
                            b2 = 255;
                        }
                    }
                    byte[] bArr6 = this.f16537k.a;
                    this.J = this.E + q((bArr6[c2] & 255) | (bArr6[0] << 8));
                    bArr = this.f16537k.a;
                    if ((bArr[2] & 8) == 8) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (v10Var.f13420c != 2 || (i2 == 163 && (bArr[2] & 128) == 128)) {
                        i6 = 1;
                    } else {
                        i6 = 0;
                    }
                    if (z) {
                        i7 = Integer.MIN_VALUE;
                    } else {
                        i7 = 0;
                    }
                    this.Q = i6 | i7;
                    this.I = 2;
                    this.L = 0;
                }
            }
            c2 = 1;
            byte[] bArr7 = this.f16537k.a;
            this.J = this.E + q((bArr7[c2] & 255) | (bArr7[0] << 8));
            bArr = this.f16537k.a;
            if ((bArr[2] & 8) == 8) {
                z = true;
            } else {
                z = false;
            }
            if (v10Var.f13420c != 2) {
                i6 = 1;
            } else {
                i6 = 1;
            }
            if (z) {
                i7 = Integer.MIN_VALUE;
            } else {
                i7 = 0;
            }
            this.Q = i6 | i7;
            this.I = 2;
            this.L = 0;
        }
        if (i2 != 163) {
            j(zznoVar, v10Var, this.N[0]);
            return;
        }
        while (true) {
            int i25 = this.L;
            if (i25 >= this.M) {
                this.I = 0;
                return;
            } else {
                j(zznoVar, v10Var, this.N[i25]);
                k(v10Var, this.J + ((long) ((this.L * v10Var.f13421d) / 1000)));
                this.L++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final boolean g(zzno zznoVar) throws InterruptedException, IOException {
        return new w10().a(zznoVar);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void h(long j2, long j3) {
        this.E = -9223372036854775807L;
        this.I = 0;
        this.f16531e.a();
        this.f16532f.a();
        r();
    }

    final void i(int i2, String str) throws zzlm {
        if (i2 == 134) {
            this.x.a = str;
            return;
        }
        if (i2 != 17026) {
            if (i2 != 2274716) {
                return;
            }
            this.x.N = str;
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzlm(sb.toString());
        }
    }

    final void n(int i2, long j2, long j3) throws zzlm {
        if (i2 == 160) {
            this.b0 = false;
            return;
        }
        if (i2 == 174) {
            this.x = new v10(null);
            return;
        }
        if (i2 == 187) {
            this.H = false;
            return;
        }
        if (i2 == 19899) {
            this.z = -1;
            this.A = -1L;
            return;
        }
        if (i2 == 20533) {
            this.x.f13422e = true;
            return;
        }
        if (i2 == 21968) {
            this.x.q = true;
            return;
        }
        if (i2 == 408125543) {
            long j4 = this.t;
            if (j4 != -1 && j4 != j2) {
                throw new zzlm("Multiple Segment elements not supported");
            }
            this.t = j2;
            this.s = j3;
            return;
        }
        if (i2 == 475249515) {
            this.F = new zzsn();
            this.G = new zzsn();
        } else if (i2 == 524531317 && !this.y) {
            if (this.f16534h && this.C != -1) {
                this.B = true;
            } else {
                this.c0.z(new zznv(this.w));
                this.y = true;
            }
        }
    }

    final void p(int i2, long j2) throws zzlm {
        if (i2 == 20529) {
            if (j2 == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j2);
            sb.append(" not supported");
            throw new zzlm(sb.toString());
        }
        if (i2 == 20530) {
            if (j2 == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j2);
            sb2.append(" not supported");
            throw new zzlm(sb2.toString());
        }
        switch (i2) {
            case 131:
                this.x.f13420c = (int) j2;
                return;
            case 136:
                this.x.L = j2 == 1;
                return;
            case 155:
                this.K = q(j2);
                return;
            case 159:
                this.x.G = (int) j2;
                return;
            case 176:
                this.x.f13427j = (int) j2;
                return;
            case 179:
                this.F.a(q(j2));
                return;
            case 186:
                this.x.f13428k = (int) j2;
                return;
            case 215:
                this.x.f13419b = (int) j2;
                return;
            case 231:
                this.E = q(j2);
                return;
            case 241:
                if (this.H) {
                    return;
                }
                this.G.a(j2);
                this.H = true;
                return;
            case 251:
                this.b0 = true;
                return;
            case 16980:
                if (j2 == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(50);
                sb3.append("ContentCompAlgo ");
                sb3.append(j2);
                sb3.append(" not supported");
                throw new zzlm(sb3.toString());
            case 17029:
                if (j2 < 1 || j2 > 2) {
                    StringBuilder sb4 = new StringBuilder(53);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j2);
                    sb4.append(" not supported");
                    throw new zzlm(sb4.toString());
                }
                return;
            case 17143:
                if (j2 == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(50);
                sb5.append("EBMLReadVersion ");
                sb5.append(j2);
                sb5.append(" not supported");
                throw new zzlm(sb5.toString());
            case 18401:
                if (j2 == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(49);
                sb6.append("ContentEncAlgo ");
                sb6.append(j2);
                sb6.append(" not supported");
                throw new zzlm(sb6.toString());
            case 18408:
                if (j2 == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(56);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j2);
                sb7.append(" not supported");
                throw new zzlm(sb7.toString());
            case 21420:
                this.A = j2 + this.t;
                return;
            case 21432:
                int i3 = (int) j2;
                if (i3 == 0) {
                    this.x.p = 0;
                    return;
                }
                if (i3 == 1) {
                    this.x.p = 2;
                    return;
                } else if (i3 == 3) {
                    this.x.p = 1;
                    return;
                } else {
                    if (i3 != 15) {
                        return;
                    }
                    this.x.p = 3;
                    return;
                }
            case 21680:
                this.x.l = (int) j2;
                return;
            case 21682:
                this.x.n = (int) j2;
                return;
            case 21690:
                this.x.m = (int) j2;
                return;
            case 21930:
                this.x.M = j2 == 1;
                return;
            case 22186:
                this.x.J = j2;
                return;
            case 22203:
                this.x.K = j2;
                return;
            case 25188:
                this.x.H = (int) j2;
                return;
            case 2352003:
                this.x.f13421d = (int) j2;
                return;
            case 2807729:
                this.u = j2;
                return;
            default:
                switch (i2) {
                    case 21945:
                        int i4 = (int) j2;
                        if (i4 == 1) {
                            this.x.t = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.x.t = 1;
                            return;
                        }
                    case 21946:
                        int i5 = (int) j2;
                        if (i5 != 1) {
                            if (i5 == 16) {
                                this.x.s = 6;
                                return;
                            } else if (i5 == 18) {
                                this.x.s = 7;
                                return;
                            } else if (i5 != 6 && i5 != 7) {
                                return;
                            }
                        }
                        this.x.s = 3;
                        return;
                    case 21947:
                        v10 v10Var = this.x;
                        v10Var.q = true;
                        int i6 = (int) j2;
                        if (i6 == 1) {
                            v10Var.r = 1;
                            return;
                        }
                        if (i6 == 9) {
                            v10Var.r = 6;
                            return;
                        } else {
                            if (i6 == 4 || i6 == 5 || i6 == 6 || i6 == 7) {
                                v10Var.r = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.x.u = (int) j2;
                        return;
                    case 21949:
                        this.x.v = (int) j2;
                        return;
                    default:
                        return;
                }
        }
    }

    final void u(int i2) throws zzlm {
        zznu zznvVar;
        zzsn zzsnVar;
        zzsn zzsnVar2;
        int i3;
        int i4 = 0;
        if (i2 == 160) {
            if (this.I != 2) {
                return;
            }
            if (!this.b0) {
                this.Q |= 1;
            }
            k(this.f16533g.get(this.O), this.J);
            this.I = 0;
            return;
        }
        if (i2 == 174) {
            String str = this.x.a;
            if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 0) != 0) {
                v10 v10Var = this.x;
                v10Var.c(this.c0, v10Var.f13419b);
                SparseArray<v10> sparseArray = this.f16533g;
                v10 v10Var2 = this.x;
                sparseArray.put(v10Var2.f13419b, v10Var2);
            }
            this.x = null;
            return;
        }
        if (i2 == 19899) {
            int i5 = this.z;
            if (i5 != -1) {
                long j2 = this.A;
                if (j2 != -1) {
                    if (i5 == 475249515) {
                        this.C = j2;
                        return;
                    }
                    return;
                }
            }
            throw new zzlm("Mandatory element SeekID or SeekPosition not found");
        }
        if (i2 == 25152) {
            v10 v10Var3 = this.x;
            if (v10Var3.f13422e) {
                if (v10Var3.f13424g == null) {
                    throw new zzlm("Encrypted Track found but ContentEncKeyID was not found");
                }
                v10Var3.f13426i = new zzne(new zzne.zza(zzkt.f16407b, "video/webm", this.x.f13424g.f16527b));
                return;
            }
            return;
        }
        if (i2 == 28032) {
            v10 v10Var4 = this.x;
            if (v10Var4.f13422e && v10Var4.f13423f != null) {
                throw new zzlm("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i2 == 357149030) {
            if (this.u == -9223372036854775807L) {
                this.u = 1000000L;
            }
            long j3 = this.v;
            if (j3 != -9223372036854775807L) {
                this.w = q(j3);
                return;
            }
            return;
        }
        if (i2 == 374648427) {
            if (this.f16533g.size() == 0) {
                throw new zzlm("No valid tracks were found");
            }
            this.c0.d();
            return;
        }
        if (i2 == 475249515 && !this.y) {
            zznp zznpVar = this.c0;
            if (this.t == -1 || this.w == -9223372036854775807L || (zzsnVar = this.F) == null || zzsnVar.c() == 0 || (zzsnVar2 = this.G) == null || zzsnVar2.c() != this.F.c()) {
                this.F = null;
                this.G = null;
                zznvVar = new zznv(this.w);
            } else {
                int iC = this.F.c();
                int[] iArr = new int[iC];
                long[] jArr = new long[iC];
                long[] jArr2 = new long[iC];
                long[] jArr3 = new long[iC];
                for (int i6 = 0; i6 < iC; i6++) {
                    jArr3[i6] = this.F.b(i6);
                    jArr[i6] = this.t + this.G.b(i6);
                }
                while (true) {
                    i3 = iC - 1;
                    if (i4 >= i3) {
                        break;
                    }
                    int i7 = i4 + 1;
                    iArr[i4] = (int) (jArr[i7] - jArr[i4]);
                    jArr2[i4] = jArr3[i7] - jArr3[i4];
                    i4 = i7;
                }
                iArr[i3] = (int) ((this.t + this.s) - jArr[i3]);
                jArr2[i3] = this.w - jArr3[i3];
                this.F = null;
                this.G = null;
                zznvVar = new zznl(iArr, jArr, jArr2, jArr3);
            }
            zznpVar.z(zznvVar);
            this.y = true;
        }
    }

    private zzod(int i2) {
        this(new o10(), 0);
    }

    private zzod(r10 r10Var, int i2) {
        this.t = -1L;
        this.u = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.w = -9223372036854775807L;
        this.C = -1L;
        this.D = -1L;
        this.E = -9223372036854775807L;
        this.f16531e = r10Var;
        r10Var.b(new u10(this, null));
        this.f16534h = true;
        this.f16532f = new x10();
        this.f16533g = new SparseArray<>();
        this.f16537k = new zzst(4);
        this.l = new zzst(ByteBuffer.allocate(4).putInt(-1).array());
        this.m = new zzst(4);
        this.f16535i = new zzst(zzsq.a);
        this.f16536j = new zzst(4);
        this.n = new zzst();
        this.o = new zzst();
        this.p = new zzst(8);
        this.q = new zzst();
    }
}
