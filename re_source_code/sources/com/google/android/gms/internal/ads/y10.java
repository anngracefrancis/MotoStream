package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
class y10 {
    public final int P0;
    public static final int a = zzsy.i("ftyp");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13593b = zzsy.i("avc1");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13594c = zzsy.i("avc3");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13595d = zzsy.i("hvc1");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f13596e = zzsy.i("hev1");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13597f = zzsy.i("s263");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f13598g = zzsy.i("d263");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f13599h = zzsy.i("mdat");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f13600i = zzsy.i("mp4a");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f13601j = zzsy.i(".mp3");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f13602k = zzsy.i("wave");
    public static final int l = zzsy.i("lpcm");
    public static final int m = zzsy.i("sowt");
    public static final int n = zzsy.i("ac-3");
    public static final int o = zzsy.i("dac3");
    public static final int p = zzsy.i("ec-3");
    public static final int q = zzsy.i("dec3");
    public static final int r = zzsy.i("dtsc");
    public static final int s = zzsy.i("dtsh");
    public static final int t = zzsy.i("dtsl");
    public static final int u = zzsy.i("dtse");
    public static final int v = zzsy.i("ddts");
    private static final int w = zzsy.i("tfdt");
    private static final int x = zzsy.i("tfhd");
    private static final int y = zzsy.i("trex");
    private static final int z = zzsy.i("trun");
    private static final int A = zzsy.i("sidx");
    public static final int B = zzsy.i("moov");
    public static final int C = zzsy.i("mvhd");
    public static final int D = zzsy.i("trak");
    public static final int E = zzsy.i("mdia");
    public static final int F = zzsy.i("minf");
    public static final int G = zzsy.i("stbl");
    public static final int H = zzsy.i("avcC");
    public static final int I = zzsy.i("hvcC");
    public static final int J = zzsy.i("esds");
    public static final int K = zzsy.i("moof");
    private static final int L = zzsy.i("traf");
    public static final int M = zzsy.i("mvex");
    private static final int N = zzsy.i("mehd");
    public static final int O = zzsy.i("tkhd");
    public static final int P = zzsy.i("edts");
    public static final int Q = zzsy.i("elst");
    public static final int R = zzsy.i("mdhd");
    public static final int S = zzsy.i("hdlr");
    public static final int T = zzsy.i("stsd");
    private static final int U = zzsy.i("pssh");
    public static final int V = zzsy.i("sinf");
    public static final int W = zzsy.i("schm");
    public static final int X = zzsy.i("schi");
    public static final int Y = zzsy.i("tenc");
    public static final int Z = zzsy.i("encv");
    public static final int a0 = zzsy.i("enca");
    public static final int b0 = zzsy.i("frma");
    private static final int c0 = zzsy.i("saiz");
    private static final int d0 = zzsy.i("saio");
    private static final int e0 = zzsy.i("sbgp");
    private static final int f0 = zzsy.i("sgpd");
    private static final int g0 = zzsy.i("uuid");
    private static final int h0 = zzsy.i("senc");
    public static final int i0 = zzsy.i("pasp");
    public static final int j0 = zzsy.i("TTML");
    private static final int k0 = zzsy.i("vmhd");
    public static final int l0 = zzsy.i("mp4v");
    public static final int m0 = zzsy.i("stts");
    public static final int n0 = zzsy.i("stss");
    public static final int o0 = zzsy.i("ctts");
    public static final int p0 = zzsy.i("stsc");
    public static final int q0 = zzsy.i("stsz");
    public static final int r0 = zzsy.i("stz2");
    public static final int s0 = zzsy.i("stco");
    public static final int t0 = zzsy.i("co64");
    public static final int u0 = zzsy.i("tx3g");
    public static final int v0 = zzsy.i("wvtt");
    public static final int w0 = zzsy.i("stpp");
    public static final int x0 = zzsy.i("c608");
    public static final int y0 = zzsy.i("samr");
    public static final int z0 = zzsy.i("sawb");
    public static final int A0 = zzsy.i("udta");
    public static final int B0 = zzsy.i("meta");
    public static final int C0 = zzsy.i("ilst");
    public static final int D0 = zzsy.i("mean");
    public static final int E0 = zzsy.i("name");
    public static final int F0 = zzsy.i("data");
    private static final int G0 = zzsy.i("emsg");
    public static final int H0 = zzsy.i("st3d");
    public static final int I0 = zzsy.i("sv3d");
    public static final int J0 = zzsy.i("proj");
    public static final int K0 = zzsy.i("vp08");
    public static final int L0 = zzsy.i("vp09");
    public static final int M0 = zzsy.i("vpcC");
    public static final int N0 = zzsy.i("camm");
    public static final int O0 = zzsy.i("alac");

    public y10(int i2) {
        this.P0 = i2;
    }

    public static int a(int i2) {
        return i2 & 16777215;
    }

    public static int b(int i2) {
        return (i2 >> 24) & 255;
    }

    public static String c(int i2) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) (i2 >>> 24));
        sb.append((char) ((i2 >> 16) & 255));
        sb.append((char) ((i2 >> 8) & 255));
        sb.append((char) (i2 & 255));
        return sb.toString();
    }

    public String toString() {
        return c(this.P0);
    }
}
