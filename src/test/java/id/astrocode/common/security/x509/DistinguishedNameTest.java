package id.astrocode.common.security.x509;

import org.junit.Assert;
import org.junit.Test;

/**
 * DistinguishedName Test
 *
 * @author Bayu Dwiyan Satria
 * @version 0.0.1
 */
public class DistinguishedNameTest {

    @Test
    public void buildDistinguishedName() {
        DistinguishedName distinguishedName = new DistinguishedNameBuilder()
            .setCommonName("astrocode.id")
            .build();
        Assert.assertEquals("CN=astrocode.id", distinguishedName.getName());
    }
}
