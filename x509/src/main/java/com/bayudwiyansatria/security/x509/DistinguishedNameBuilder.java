package com.bayudwiyansatria.security.x509;

import java.math.BigInteger;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;

/**
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 * @see <a href="http://tools.ietf.org/html/rfc3739.html> RFC-3739 </a>
 * @since 0.0.1
 */
public class DistinguishedNameBuilder {

    private final X500NameBuilder builder = new X500NameBuilder();

    /**
     * Domain Component
     *
     * @see <a href="https://datatracker.ietf.org/doc/html/rfc2247"> RFC 2247 </a>
     */
    public DistinguishedNameBuilder setDomainComponent(String domainComponent) {
        builder.addRDN(BCStyle.DC, domainComponent);
        return this;
    }

    /**
     * Two-letter country code, e.g., "ID"
     *
     * @param countryName String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setCountryName(String countryName) {
        builder.addRDN(BCStyle.C, countryName);
        return this;
    }

    /**
     * Common Name of a person or Certificate Name, e.g., "Bayu Dwiyan Satria" Indonesia Root CA
     *
     * @param commonName String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setCommonName(String commonName) {
        builder.addRDN(BCStyle.CN, commonName);
        return this;
    }

    /**
     * Family name
     *
     * @param surname String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setSurname(String surname) {
        builder.addRDN(BCStyle.SURNAME, surname);
        return this;
    }

    /**
     * Name
     *
     * @param givensName String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setGivensName(String givensName) {
        builder.addRDN(BCStyle.GIVENNAME, givensName);
        return this;
    }

    /**
     * Pseudonym typically a shortened version of a longer GivenName, e.g., Dwiyan is often
     * shortened to Dwi.
     *
     * @param pseudonym String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setPseudonym(String pseudonym) {
        builder.addRDN(BCStyle.PSEUDONYM, pseudonym);
        return this;
    }

    /**
     * Serial Number
     *
     * @param serialNumber String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setSerialNumber(BigInteger serialNumber) {
        builder.addRDN(BCStyle.SERIALNUMBER, serialNumber.toString());
        return this;
    }

    /**
     * A title such as Mr. or Ms., which is pre-pended to the name to refer formally to the
     * certificate subject.
     *
     * @param title String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setTitle(String title) {
        builder.addRDN(BCStyle.T, title);
        return this;
    }

    /**
     * Large organization name, e.g., "Astrocode Indonesia"
     *
     * @param organizationName String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setOrganizationName(String organizationName) {
        builder.addRDN(BCStyle.O, organizationName);
        return this;
    }

    /**
     * Small organization (e.g, department or division) name, e.g., "DevOps" or "Certificate
     * Authorities"
     *
     * @param organizationalUnitName String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setOrganizationalUnitName(String organizationalUnitName) {
        builder.addRDN(BCStyle.OU, organizationalUnitName);
        return this;
    }

    /**
     * State or Province Name, e.g., "East Java"
     *
     * @param stateOrProvinceName String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setStateOrProvinceName(String stateOrProvinceName) {
        builder.addRDN(BCStyle.ST, stateOrProvinceName);
        return this;
    }

    /**
     * Locality Name locality (city) name, e.g., "Ponorogo"
     *
     * @param localityName String
     * @since 0.0.1
     */
    public DistinguishedNameBuilder setLocalityName(String localityName) {
        builder.addRDN(BCStyle.L, localityName);
        return this;
    }

    /**
     * Build Distinguished Name
     *
     * @param x500Name X500Name
     * @return DistinguishedName
     * @see DistinguishedName
     * @since 0.0.1
     */
    public DistinguishedName build(X500Name x500Name) {
        String[] arr = x500Name.toString().split(",");
        for (String value : arr) {
            String[] s = value.split("=");
            switch (s[0]) {
                case "CN":
                    this.setCommonName(s[1]);
                case "O":
                    this.setOrganizationName(s[1]);
                case "OU":
                    this.setOrganizationalUnitName(s[1]);
                case "L":
                    this.setLocalityName(s[1]);
                case "ST":
                    this.setStateOrProvinceName(s[1]);
            }
        }
        return this.build();
    }

    /**
     * Build Distinguished Name
     *
     * @return Distinguished Name
     * @see DistinguishedName
     * @since 0.0.1
     */
    public DistinguishedName build() {
        return new DistinguishedName(builder.build());
    }
}
