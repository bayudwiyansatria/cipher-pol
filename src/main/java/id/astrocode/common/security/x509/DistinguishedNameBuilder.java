package id.astrocode.common.security.x509;

import java.math.BigInteger;

/**
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 * @see <a href="http://tools.ietf.org/html/rfc3739.html> RFC-3739 </a>
 * @since 0.0.1
 */
public class DistinguishedNameBuilder {

    private String domainComponent;
    private String countryName;
    private String commonName;
    private String surname;
    private String givensName;
    private String pseudonym;
    private BigInteger serialNumber;
    private String title;
    private String organizationName;
    private String organizationalUnitName;
    private String stateOrProvinceName;
    private String localityName;

    /**
     * Domain Component
     *
     * @see <a href="https://datatracker.ietf.org/doc/html/rfc2247"> RFC 2247 </a>
     */
    public void setDomainComponent(String domainComponent) {
        this.domainComponent = domainComponent;
    }

    /**
     * Two-letter country code, e.g., "ID"
     *
     * @param countryName String
     * @since 0.0.1
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Common Name of a person or Certificate Name, e.g., "Bayu Dwiyan Satria" or "Astrocode
     * Indonesia Root CA"
     *
     * @param commonName String
     * @since 0.0.1
     */
    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    /**
     * Family name
     *
     * @param surname String
     * @since 0.0.1
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Name
     *
     * @param givensName String
     */
    public void setGivensName(String givensName) {
        this.givensName = givensName;
    }

    /**
     * Pseudonym typically a shortened version of a longer GivenName, e.g., Dwiyan is often
     * shortened to Dwi.
     *
     * @param pseudonym String
     * @since 0.0.1
     */
    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    /**
     * Serial Number
     *
     * @param serialNumber String
     * @since 0.0.1
     */
    public void setSerialNumber(BigInteger serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * A title such as Mr. or Ms., which is pre-pended to the name to refer formally to the
     * certificate subject.
     *
     * @param title String
     * @since 0.0.1
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Large organization name, e.g., "Astrocode Indonesia"
     *
     * @param organizationName String
     * @since 0.0.1
     */
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    /**
     * Small organization (e.g, department or division) name, e.g., "DevOps" or "Certificate
     * Authorities"
     *
     * @param organizationalUnitName String
     * @since 0.0.1
     */
    public void setOrganizationalUnitName(String organizationalUnitName) {
        this.organizationalUnitName = organizationalUnitName;
    }

    /**
     * State or Province Name, e.g., "East Java"
     *
     * @param stateOrProvinceName String
     * @since 0.0.1
     */
    public void setStateOrProvinceName(String stateOrProvinceName) {
        this.stateOrProvinceName = stateOrProvinceName;
    }

    /**
     * Locality Name locality (city) name, e.g., "Ponorogo"
     *
     * @param localityName String
     * @since 0.0.1
     */
    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }
}
