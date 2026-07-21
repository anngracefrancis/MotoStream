package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
final class j20 {
    private static final int a = zzsy.i("nam");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f12799b = zzsy.i("trk");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12800c = zzsy.i("cmt");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12801d = zzsy.i("day");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f12802e = zzsy.i("ART");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f12803f = zzsy.i("too");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f12804g = zzsy.i("alb");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f12805h = zzsy.i("com");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f12806i = zzsy.i("wrt");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f12807j = zzsy.i("lyr");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f12808k = zzsy.i("gen");
    private static final int l = zzsy.i("covr");
    private static final int m = zzsy.i("gnre");
    private static final int n = zzsy.i("grp");
    private static final int o = zzsy.i("disk");
    private static final int p = zzsy.i("trkn");
    private static final int q = zzsy.i("tmpo");
    private static final int r = zzsy.i("cpil");
    private static final int s = zzsy.i("aART");
    private static final int t = zzsy.i("sonm");
    private static final int u = zzsy.i("soal");
    private static final int v = zzsy.i("soar");
    private static final int w = zzsy.i("soaa");
    private static final int x = zzsy.i("soco");
    private static final int y = zzsy.i("rtng");
    private static final int z = zzsy.i("pgap");
    private static final int A = zzsy.i("sosn");
    private static final int B = zzsy.i("tvsh");
    private static final int C = zzsy.i("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    private static zzpv a(int i2, String str, zzst zzstVar, boolean z2, boolean z3) {
        int iE = e(zzstVar);
        if (z3) {
            iE = Math.min(1, iE);
        }
        if (iE >= 0) {
            return z2 ? new zzpw(str, null, Integer.toString(iE)) : new zzps("und", str, Integer.toString(iE));
        }
        String strValueOf = String.valueOf(y10.c(i2));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(strValueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }

    private static zzpw b(int i2, String str, zzst zzstVar) {
        int iD = zzstVar.d();
        if (zzstVar.d() == y10.F0) {
            zzstVar.l(8);
            return new zzpw(str, null, zzstVar.p(iD - 16));
        }
        String strValueOf = String.valueOf(y10.c(i2));
        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse text attribute: ".concat(strValueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzpw c(int i2, String str, zzst zzstVar) {
        int iD = zzstVar.d();
        if (zzstVar.d() == y10.F0 && iD >= 22) {
            zzstVar.l(10);
            int iH = zzstVar.h();
            if (iH > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(iH);
                String string = sb.toString();
                int iH2 = zzstVar.h();
                if (iH2 > 0) {
                    String strValueOf = String.valueOf(string);
                    StringBuilder sb2 = new StringBuilder(strValueOf.length() + 12);
                    sb2.append(strValueOf);
                    sb2.append("/");
                    sb2.append(iH2);
                    string = sb2.toString();
                }
                return new zzpw(str, null, string);
            }
        }
        String strValueOf2 = String.valueOf(y10.c(i2));
        Log.w("MetadataUtil", strValueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(strValueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0037  */
    public static zzpo.zza d(zzst zzstVar) {
        String str;
        String str2;
        int iB = zzstVar.b() + zzstVar.d();
        int iD = zzstVar.d();
        int i2 = iD >>> 24;
        zzpo.zza zzpsVar = null;
        try {
            if (i2 == 169 || i2 == 65533) {
                int i3 = 16777215 & iD;
                if (i3 == f12800c) {
                    int iD2 = zzstVar.d();
                    if (zzstVar.d() == y10.F0) {
                        zzstVar.l(8);
                        String strP = zzstVar.p(iD2 - 16);
                        zzpsVar = new zzps("und", strP, strP);
                    } else {
                        String strValueOf = String.valueOf(y10.c(iD));
                        Log.w("MetadataUtil", strValueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(strValueOf) : new String("Failed to parse comment attribute: "));
                    }
                    zzstVar.k(iB);
                    return zzpsVar;
                }
                if (i3 != a && i3 != f12799b) {
                    if (i3 != f12805h && i3 != f12806i) {
                        if (i3 == f12801d) {
                            zzpw zzpwVarB = b(iD, "TDRC", zzstVar);
                            zzstVar.k(iB);
                            return zzpwVarB;
                        }
                        if (i3 == f12802e) {
                            zzpw zzpwVarB2 = b(iD, "TPE1", zzstVar);
                            zzstVar.k(iB);
                            return zzpwVarB2;
                        }
                        if (i3 == f12803f) {
                            zzpw zzpwVarB3 = b(iD, "TSSE", zzstVar);
                            zzstVar.k(iB);
                            return zzpwVarB3;
                        }
                        if (i3 == f12804g) {
                            zzpw zzpwVarB4 = b(iD, "TALB", zzstVar);
                            zzstVar.k(iB);
                            return zzpwVarB4;
                        }
                        if (i3 == f12807j) {
                            zzpw zzpwVarB5 = b(iD, "USLT", zzstVar);
                            zzstVar.k(iB);
                            return zzpwVarB5;
                        }
                        if (i3 == f12808k) {
                            zzpw zzpwVarB6 = b(iD, "TCON", zzstVar);
                            zzstVar.k(iB);
                            return zzpwVarB6;
                        }
                        if (i3 == n) {
                            zzpw zzpwVarB7 = b(iD, "TIT1", zzstVar);
                            zzstVar.k(iB);
                            return zzpwVarB7;
                        }
                    }
                    zzpw zzpwVarB8 = b(iD, "TCOM", zzstVar);
                    zzstVar.k(iB);
                    return zzpwVarB8;
                }
                zzpw zzpwVarB9 = b(iD, "TIT2", zzstVar);
                zzstVar.k(iB);
                return zzpwVarB9;
            }
            if (iD == m) {
                int iE = e(zzstVar);
                if (iE > 0) {
                    String[] strArr = D;
                    if (iE <= strArr.length) {
                        str2 = strArr[iE - 1];
                    } else {
                        str2 = null;
                    }
                } else {
                    str2 = null;
                }
                if (str2 != null) {
                    zzpsVar = new zzpw("TCON", null, str2);
                } else {
                    Log.w("MetadataUtil", "Failed to parse standard genre code");
                }
                zzstVar.k(iB);
                return zzpsVar;
            }
            if (iD == o) {
                zzpw zzpwVarC = c(iD, "TPOS", zzstVar);
                zzstVar.k(iB);
                return zzpwVarC;
            }
            if (iD == p) {
                zzpw zzpwVarC2 = c(iD, "TRCK", zzstVar);
                zzstVar.k(iB);
                return zzpwVarC2;
            }
            if (iD == q) {
                zzpv zzpvVarA = a(iD, "TBPM", zzstVar, true, false);
                zzstVar.k(iB);
                return zzpvVarA;
            }
            if (iD == r) {
                zzpv zzpvVarA2 = a(iD, "TCMP", zzstVar, true, true);
                zzstVar.k(iB);
                return zzpvVarA2;
            }
            if (iD == l) {
                int iD3 = zzstVar.d();
                if (zzstVar.d() == y10.F0) {
                    int iA = y10.a(zzstVar.d());
                    if (iA == 13) {
                        str = "image/jpeg";
                    } else {
                        str = iA == 14 ? "image/png" : null;
                    }
                    if (str == null) {
                        StringBuilder sb = new StringBuilder(41);
                        sb.append("Unrecognized cover art flags: ");
                        sb.append(iA);
                        Log.w("MetadataUtil", sb.toString());
                    } else {
                        zzstVar.l(4);
                        int i4 = iD3 - 16;
                        byte[] bArr = new byte[i4];
                        zzstVar.n(bArr, 0, i4);
                        zzpsVar = new zzpq(str, null, 3, bArr);
                    }
                } else {
                    Log.w("MetadataUtil", "Failed to parse cover art attribute");
                }
                zzstVar.k(iB);
                return zzpsVar;
            }
            if (iD == s) {
                zzpw zzpwVarB10 = b(iD, "TPE2", zzstVar);
                zzstVar.k(iB);
                return zzpwVarB10;
            }
            if (iD == t) {
                zzpw zzpwVarB11 = b(iD, "TSOT", zzstVar);
                zzstVar.k(iB);
                return zzpwVarB11;
            }
            if (iD == u) {
                zzpw zzpwVarB12 = b(iD, "TSO2", zzstVar);
                zzstVar.k(iB);
                return zzpwVarB12;
            }
            if (iD == v) {
                zzpw zzpwVarB13 = b(iD, "TSOA", zzstVar);
                zzstVar.k(iB);
                return zzpwVarB13;
            }
            if (iD == w) {
                zzpw zzpwVarB14 = b(iD, "TSOP", zzstVar);
                zzstVar.k(iB);
                return zzpwVarB14;
            }
            if (iD == x) {
                zzpw zzpwVarB15 = b(iD, "TSOC", zzstVar);
                zzstVar.k(iB);
                return zzpwVarB15;
            }
            if (iD == y) {
                zzpv zzpvVarA3 = a(iD, "ITUNESADVISORY", zzstVar, false, false);
                zzstVar.k(iB);
                return zzpvVarA3;
            }
            if (iD == z) {
                zzpv zzpvVarA4 = a(iD, "ITUNESGAPLESS", zzstVar, false, true);
                zzstVar.k(iB);
                return zzpvVarA4;
            }
            if (iD == A) {
                zzpw zzpwVarB16 = b(iD, "TVSHOWSORT", zzstVar);
                zzstVar.k(iB);
                return zzpwVarB16;
            }
            if (iD == B) {
                zzpw zzpwVarB17 = b(iD, "TVSHOW", zzstVar);
                zzstVar.k(iB);
                return zzpwVarB17;
            }
            if (iD == C) {
                String strP2 = null;
                String strP3 = null;
                int i5 = -1;
                int i6 = -1;
                while (zzstVar.b() < iB) {
                    int iB2 = zzstVar.b();
                    int iD4 = zzstVar.d();
                    int iD5 = zzstVar.d();
                    zzstVar.l(4);
                    if (iD5 == y10.D0) {
                        strP2 = zzstVar.p(iD4 - 12);
                    } else if (iD5 == y10.E0) {
                        strP3 = zzstVar.p(iD4 - 12);
                    } else {
                        if (iD5 == y10.F0) {
                            i5 = iB2;
                            i6 = iD4;
                        }
                        zzstVar.l(iD4 - 12);
                    }
                }
                if ("com.apple.iTunes".equals(strP2) && "iTunSMPB".equals(strP3) && i5 != -1) {
                    zzstVar.k(i5);
                    zzstVar.l(16);
                    zzpsVar = new zzps("und", strP3, zzstVar.p(i6 - 16));
                }
                zzstVar.k(iB);
                return zzpsVar;
            }
            String strValueOf2 = String.valueOf(y10.c(iD));
            Log.d("MetadataUtil", strValueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(strValueOf2) : new String("Skipped unknown metadata entry: "));
            zzstVar.k(iB);
            return null;
        } catch (Throwable th) {
            zzstVar.k(iB);
            throw th;
        }
    }

    private static int e(zzst zzstVar) {
        zzstVar.l(4);
        if (zzstVar.d() == y10.F0) {
            zzstVar.l(8);
            return zzstVar.g();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }
}
