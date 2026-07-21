package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
class vz {
    public final int a0;
    private static final int a = zzkq.f("ftyp");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13474b = zzkq.f("avc1");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13475c = zzkq.f("avc3");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f13476d = zzkq.f("esds");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f13477e = zzkq.f("mdat");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f13478f = zzkq.f("mp4a");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f13479g = zzkq.f("ac-3");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f13480h = zzkq.f("dac3");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f13481i = zzkq.f("ec-3");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f13482j = zzkq.f("dec3");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f13483k = zzkq.f("tfdt");
    private static final int l = zzkq.f("tfhd");
    private static final int m = zzkq.f("trex");
    private static final int n = zzkq.f("trun");
    private static final int o = zzkq.f("sidx");
    public static final int p = zzkq.f("moov");
    public static final int q = zzkq.f("mvhd");
    public static final int r = zzkq.f("trak");
    public static final int s = zzkq.f("mdia");
    public static final int t = zzkq.f("minf");
    public static final int u = zzkq.f("stbl");
    public static final int v = zzkq.f("avcC");
    private static final int w = zzkq.f("moof");
    private static final int x = zzkq.f("traf");
    private static final int y = zzkq.f("mvex");
    public static final int z = zzkq.f("tkhd");
    public static final int A = zzkq.f("mdhd");
    public static final int B = zzkq.f("hdlr");
    public static final int C = zzkq.f("stsd");
    private static final int D = zzkq.f("pssh");
    public static final int E = zzkq.f("sinf");
    public static final int F = zzkq.f("schm");
    public static final int G = zzkq.f("schi");
    public static final int H = zzkq.f("tenc");
    public static final int I = zzkq.f("encv");
    public static final int J = zzkq.f("enca");
    public static final int K = zzkq.f("frma");
    private static final int L = zzkq.f("saiz");
    private static final int M = zzkq.f("uuid");
    private static final int N = zzkq.f("senc");
    public static final int O = zzkq.f("pasp");
    public static final int P = zzkq.f("TTML");
    public static final int Q = zzkq.f("vmhd");
    public static final int R = zzkq.f("smhd");
    public static final int S = zzkq.f("mp4v");
    public static final int T = zzkq.f("stts");
    public static final int U = zzkq.f("stss");
    public static final int V = zzkq.f("ctts");
    public static final int W = zzkq.f("stsc");
    public static final int X = zzkq.f("stsz");
    public static final int Y = zzkq.f("stco");
    public static final int Z = zzkq.f("co64");

    vz(int i2) {
        this.a0 = i2;
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static String b(int i2) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) (i2 >> 24));
        sb.append((char) ((i2 >> 16) & 255));
        sb.append((char) ((i2 >> 8) & 255));
        sb.append((char) (i2 & 255));
        return sb.toString();
    }

    public String toString() {
        return b(this.a0);
    }
}
