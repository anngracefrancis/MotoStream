package okhttp3;

import j.i;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.m;
import kotlin.text.l;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;

/* JADX INFO: compiled from: CertificatePinner.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0003+*,B#\b\u0000\u0012\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110#\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b(\u0010)J#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\nH\u0000¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u000f\"\u00020\u0005H\u0007¢\u0006\u0004\b\b\u0010\u0010J\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010 \u001a\u0004\b!\u0010\"R\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006-"}, d2 = {"Lokhttp3/CertificatePinner;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "hostname", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/security/cert/Certificate;", "peerCertificates", "Lkotlin/u;", "check", "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "check$okhttp", "(Ljava/lang/String;Lkotlin/a0/c/a;)V", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "Lokhttp3/CertificatePinner$Pin;", "findMatchingPins", "(Ljava/lang/String;)Ljava/util/List;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "withCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)Lokhttp3/CertificatePinner;", "withCertificateChainCleaner", "other", HttpUrl.FRAGMENT_ENCODE_SET, "equals", "(Ljava/lang/Object;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "()I", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", HttpUrl.FRAGMENT_ENCODE_SET, "pins", "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "<init>", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "Companion", "Builder", "Pin", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CertificatePinner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final CertificatePinner DEFAULT = new Builder().build();
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<Pin> pins;

    /* JADX INFO: compiled from: CertificatePinner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lokhttp3/CertificatePinner$Builder;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "pattern", HttpUrl.FRAGMENT_ENCODE_SET, "pins", "add", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "Lokhttp3/CertificatePinner;", "build", "()Lokhttp3/CertificatePinner;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/CertificatePinner$Pin;", "Ljava/util/List;", "getPins", "()Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public final Builder add(String pattern, String... pins) {
            m.f(pattern, "pattern");
            m.f(pins, "pins");
            for (String str : pins) {
                this.pins.add(new Pin(pattern, str));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final CertificatePinner build() {
            return new CertificatePinner(c0.I0(this.pins), null, 2, 0 == true ? 1 : 0);
        }

        public final List<Pin> getPins() {
            return this.pins;
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lokhttp3/CertificatePinner$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/security/cert/X509Certificate;", "Lj/i;", "sha1Hash", "(Ljava/security/cert/X509Certificate;)Lj/i;", "sha256Hash", "Ljava/security/cert/Certificate;", "certificate", HttpUrl.FRAGMENT_ENCODE_SET, "pin", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "Lokhttp3/CertificatePinner;", "DEFAULT", "Lokhttp3/CertificatePinner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final String pin(Certificate certificate) {
            m.f(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + sha256Hash((X509Certificate) certificate).g();
        }

        public final i sha1Hash(X509Certificate x509Certificate) {
            m.f(x509Certificate, "$this$sha1Hash");
            i.a aVar = i.f22842g;
            PublicKey publicKey = x509Certificate.getPublicKey();
            m.e(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            m.e(encoded, "publicKey.encoded");
            return i.a.f(aVar, encoded, 0, 0, 3, null).N();
        }

        public final i sha256Hash(X509Certificate x509Certificate) {
            m.f(x509Certificate, "$this$sha256Hash");
            i.a aVar = i.f22842g;
            PublicKey publicKey = x509Certificate.getPublicKey();
            m.e(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            m.e(encoded, "publicKey.encoded");
            return i.a.f(aVar, encoded, 0, 0, 3, null).O();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: CertificatePinner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\fR\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\f¨\u0006 "}, d2 = {"Lokhttp3/CertificatePinner$Pin;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "hostname", HttpUrl.FRAGMENT_ENCODE_SET, "matchesHostname", "(Ljava/lang/String;)Z", "Ljava/security/cert/X509Certificate;", "certificate", "matchesCertificate", "(Ljava/security/cert/X509Certificate;)Z", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "()I", "Lj/i;", "hash", "Lj/i;", "getHash", "()Lj/i;", "pattern", "Ljava/lang/String;", "getPattern", "hashAlgorithm", "getHashAlgorithm", "pin", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Pin {
        private final i hash;
        private final String hashAlgorithm;
        private final String pattern;

        public Pin(String str, String str2) {
            m.f(str, "pattern");
            m.f(str2, "pin");
            if (!((u.E(str, "*.", false, 2, null) && v.W(str, "*", 1, false, 4, null) == -1) || (u.E(str, "**.", false, 2, null) && v.W(str, "*", 2, false, 4, null) == -1) || v.W(str, "*", 0, false, 6, null) == -1)) {
                throw new IllegalArgumentException(("Unexpected pattern: " + str).toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException("Invalid pattern: " + str);
            }
            this.pattern = canonicalHost;
            if (u.E(str2, "sha1/", false, 2, null)) {
                this.hashAlgorithm = "sha1";
                i.a aVar = i.f22842g;
                String strSubstring = str2.substring(5);
                m.e(strSubstring, "(this as java.lang.String).substring(startIndex)");
                i iVarA = aVar.a(strSubstring);
                if (iVarA != null) {
                    this.hash = iVarA;
                    return;
                }
                throw new IllegalArgumentException("Invalid pin hash: " + str2);
            }
            if (!u.E(str2, "sha256/", false, 2, null)) {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            this.hashAlgorithm = "sha256";
            i.a aVar2 = i.f22842g;
            String strSubstring2 = str2.substring(7);
            m.e(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            i iVarA2 = aVar2.a(strSubstring2);
            if (iVarA2 != null) {
                this.hash = iVarA2;
                return;
            }
            throw new IllegalArgumentException("Invalid pin hash: " + str2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pin)) {
                return false;
            }
            Pin pin = (Pin) other;
            return ((m.a(this.pattern, pin.pattern) ^ true) || (m.a(this.hashAlgorithm, pin.hashAlgorithm) ^ true) || (m.a(this.hash, pin.hash) ^ true)) ? false : true;
        }

        public final i getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return (((this.pattern.hashCode() * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public final boolean matchesCertificate(X509Certificate certificate) {
            m.f(certificate, "certificate");
            String str = this.hashAlgorithm;
            int iHashCode = str.hashCode();
            if (iHashCode != -903629273) {
                if (iHashCode == 3528965 && str.equals("sha1")) {
                    return m.a(this.hash, CertificatePinner.INSTANCE.sha1Hash(certificate));
                }
            } else if (str.equals("sha256")) {
                return m.a(this.hash, CertificatePinner.INSTANCE.sha256Hash(certificate));
            }
            return false;
        }

        /* JADX WARN: Failed to inline method: kotlin.h0.l.v(java.lang.String, int, java.lang.String, int, int, boolean, int, java.lang.Object):boolean */
        /* JADX WARN: Unknown register number '(r12v0 'hostname' java.lang.String)' in method call: kotlin.h0.l.v(java.lang.String, int, java.lang.String, int, int, boolean, int, java.lang.Object):boolean */
        public final boolean matchesHostname(String hostname) {
            m.f(hostname, "hostname");
            if (u.E(this.pattern, "**.", false, 2, null)) {
                int length = this.pattern.length() - 3;
                int length2 = hostname.length() - length;
                if (!u.u(hostname, hostname.length() - length, this.pattern, 3, length, (hostname & 16) != 0 ? false : false)) {
                    return false;
                }
                if (length2 != 0 && hostname.charAt(length2 - 1) != '.') {
                    return false;
                }
            } else {
                if (!u.E(this.pattern, "*.", false, 2, null)) {
                    return m.a(hostname, this.pattern);
                }
                int length3 = this.pattern.length() - 1;
                int length4 = hostname.length() - length3;
                if (!l.v(hostname, hostname.length() - length3, this.pattern, 1, length3, false, 16, null) || v.a0(hostname, '.', length4 - 1, false, 4, null) != -1) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return this.hashAlgorithm + '/' + this.hash.g();
        }
    }

    /* JADX INFO: renamed from: okhttp3.CertificatePinner$check$1, reason: invalid class name */
    /* JADX INFO: compiled from: CertificatePinner.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/security/cert/X509Certificate;", "invoke", "()Ljava/util/List;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function0<List<? extends X509Certificate>> {
        final /* synthetic */ String $hostname;
        final /* synthetic */ List $peerCertificates;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List list, String str) {
            super(0);
            this.$peerCertificates = list;
            this.$hostname = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends X509Certificate> invoke() {
            List<Certificate> listClean;
            CertificateChainCleaner certificateChainCleaner = CertificatePinner.this.getCertificateChainCleaner();
            if (certificateChainCleaner == null || (listClean = certificateChainCleaner.clean(this.$peerCertificates, this.$hostname)) == null) {
                listClean = this.$peerCertificates;
            }
            ArrayList arrayList = new ArrayList(kotlin.collections.v.u(listClean, 10));
            for (Certificate certificate : listClean) {
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public CertificatePinner(Set<Pin> set, CertificateChainCleaner certificateChainCleaner) {
        m.f(set, "pins");
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner;
    }

    public static final String pin(Certificate certificate) {
        return INSTANCE.pin(certificate);
    }

    public static final i sha1Hash(X509Certificate x509Certificate) {
        return INSTANCE.sha1Hash(x509Certificate);
    }

    public static final i sha256Hash(X509Certificate x509Certificate) {
        return INSTANCE.sha256Hash(x509Certificate);
    }

    public final void check(String hostname, List<? extends Certificate> peerCertificates) throws SSLPeerUnverifiedException {
        m.f(hostname, "hostname");
        m.f(peerCertificates, "peerCertificates");
        check$okhttp(hostname, new AnonymousClass1(peerCertificates, hostname));
    }

    public final void check$okhttp(String hostname, Function0<? extends List<? extends X509Certificate>> cleanedPeerCertificatesFn) throws SSLPeerUnverifiedException {
        m.f(hostname, "hostname");
        m.f(cleanedPeerCertificatesFn, "cleanedPeerCertificatesFn");
        List<Pin> listFindMatchingPins = findMatchingPins(hostname);
        if (listFindMatchingPins.isEmpty()) {
            return;
        }
        List<? extends X509Certificate> listInvoke = cleanedPeerCertificatesFn.invoke();
        for (X509Certificate x509Certificate : listInvoke) {
            i iVarSha256Hash = null;
            i iVarSha1Hash = null;
            for (Pin pin : listFindMatchingPins) {
                String hashAlgorithm = pin.getHashAlgorithm();
                int iHashCode = hashAlgorithm.hashCode();
                if (iHashCode != -903629273) {
                    if (iHashCode != 3528965 || !hashAlgorithm.equals("sha1")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (iVarSha1Hash == null) {
                        iVarSha1Hash = INSTANCE.sha1Hash(x509Certificate);
                    }
                    if (m.a(pin.getHash(), iVarSha1Hash)) {
                        return;
                    }
                } else {
                    if (!hashAlgorithm.equals("sha256")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.getHashAlgorithm());
                    }
                    if (iVarSha256Hash == null) {
                        iVarSha256Hash = INSTANCE.sha256Hash(x509Certificate);
                    }
                    if (m.a(pin.getHash(), iVarSha256Hash)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : listInvoke) {
            sb.append("\n    ");
            sb.append(INSTANCE.pin(x509Certificate2));
            sb.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            m.e(subjectDN, "element.subjectDN");
            sb.append(subjectDN.getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(hostname);
        sb.append(":");
        for (Pin pin2 : listFindMatchingPins) {
            sb.append("\n    ");
            sb.append(pin2);
        }
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public boolean equals(Object other) {
        if (other instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) other;
            if (m.a(certificatePinner.pins, this.pins) && m.a(certificatePinner.certificateChainCleaner, this.certificateChainCleaner)) {
                return true;
            }
        }
        return false;
    }

    public final List<Pin> findMatchingPins(String hostname) {
        m.f(hostname, "hostname");
        Set<Pin> set = this.pins;
        List<Pin> listJ = kotlin.collections.u.j();
        for (Object obj : set) {
            if (((Pin) obj).matchesHostname(hostname)) {
                if (listJ.isEmpty()) {
                    listJ = new ArrayList<>();
                }
                l0.b(listJ).add(obj);
            }
        }
        return listJ;
    }

    /* JADX INFO: renamed from: getCertificateChainCleaner$okhttp, reason: from getter */
    public final CertificateChainCleaner getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    public final Set<Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int iHashCode = (1517 + this.pins.hashCode()) * 41;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        return iHashCode + (certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0);
    }

    public final CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        m.f(certificateChainCleaner, "certificateChainCleaner");
        return m.a(this.certificateChainCleaner, certificateChainCleaner) ? this : new CertificatePinner(this.pins, certificateChainCleaner);
    }

    public /* synthetic */ CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner, int i2, g gVar) {
        this(set, (i2 & 2) != 0 ? null : certificateChainCleaner);
    }

    public final void check(String hostname, Certificate... peerCertificates) throws SSLPeerUnverifiedException {
        m.f(hostname, "hostname");
        m.f(peerCertificates, "peerCertificates");
        check(hostname, n.Z(peerCertificates));
    }
}
